/********************************************************
* Computational Photometry Analyzer for Small Satellites
* Copyright ©, 2017 Embry-Riddle Aeronautical University
*
* File: Simulation.cpp
*
* @author Henry Valentine
* @version 12/05/2017
*
* Contains the implementation of Simulation
*
********************************************************/

#include "Simulation.h"

Simulation::Simulation()
	: ApplicationContext("COMPASS")
{
	// Base Class Init Function //
	initApp();
}

Simulation::~Simulation()
{

}

void
Simulation::setup()
{
	// Call the base class setup function //
	ApplicationContext::setup();

	// Initialize Root and Scene Manager //
	m_root = getRoot();
	m_scnMgr = m_root->createSceneManager();

	// Initialize RTSS //
	m_shaderGen = RTShader::ShaderGenerator::getSingletonPtr();
	m_shaderGen->addSceneManager(m_scnMgr);

	// Initialize Camera //
	m_camera = m_scnMgr->createCamera("Telescope");	//
	m_camera->setNearClipDistance(3);				// MOVE TO CAMERA CONSTRUCTOR
	m_camera->setAutoAspectRatio(true);				//

	m_cameraNode = m_scnMgr->getRootSceneNode()->createChildSceneNode(); // TO CAMERA CONSTRUCTOR
	m_cameraNode->attachObject(m_camera);							     // 

	// Initialize Viewport //
	getRenderWindow()->addViewport(m_camera); // Change to Telescope.getCamera()
}

void
Simulation::initSim()
{
	// Enable Shadows //
	m_scnMgr->setShadowTechnique(SHADOWTYPE_STENCIL_ADDITIVE); // Change in Future
	m_scnMgr->setShadowTextureSelfShadow(true);

	// No Ambient Light //
	m_scnMgr->setAmbientLight(ColourValue(0, 0, 0));

	// Create Sun //
	m_sunDirection = Vector3(-1, 0, 0);																	////// TAG

	m_sun = m_scnMgr->createLight("SunLight");		//
	m_sun->setType(Light::LT_DIRECTIONAL);			// 
	m_sun->setDiffuseColour(ColourValue(1, 1, 1));	// MOVE TO SUN CLASS
	m_sun->setSpecularColour(ColourValue(1, 1, 1));	// 
	m_sun->setDirection(m_sunDirection);			//

	m_sunNode = m_scnMgr->getRootSceneNode()->createChildSceneNode();		//
	m_sunNode->attachObject(m_sun);											// TO SUN CLASS
	m_sunNode->setDirection(0, -1, 1);										//

	// Initialize Camera Position //
	m_cameraNode->setPosition(0, 0, 50); // TAG
	// m_cameraNode->setPosition(0, -9.84, 50.94);

	// Initialize Satellite //
	m_satellite = Satellite(m_scnMgr);
	m_satellite.setEntity(m_scnMgr->createEntity("2FaceCube.mesh"));
	//m_satellite.scale(0.15, 0.15, 0.15); // Move Later
	m_satellite.scale(2, 2, 2);

	// RTT Setup //
	m_rttTexture =
		Ogre::TextureManager::getSingleton().createManual(
			"RttTex",
			Ogre::ResourceGroupManager::DEFAULT_RESOURCE_GROUP_NAME,
			Ogre::TEX_TYPE_2D,
			getRenderWindow()->getWidth(), getRenderWindow()->getHeight(),
			0,
			Ogre::PF_R8G8B8,
			Ogre::TU_RENDERTARGET
		);

	m_renderTexture = m_rttTexture->getBuffer(0, 0)->getRenderTarget();  ////////////////////////// ACCESS MIPMAP HERE

	m_renderTexture->addViewport(m_camera);
	m_renderTexture->getViewport(0)->setClearEveryFrame(true);
	m_renderTexture->getViewport(0)->setBackgroundColour(Ogre::ColourValue::Black);
	m_renderTexture->getViewport(0)->setOverlaysEnabled(false);

	// Render to Image //
	m_renderToImage = false;

	// Start Running
	m_running = true;
}

void
Simulation::run()
{

	int frameNumber = 0; 

	Timer timer = Timer();

	float startTime = timer.getMilliseconds();

	while (m_running)
	{
		// Update Scene
		update(frameNumber);

		// Render Frame
		render(frameNumber);
		
		frameNumber++;				

		if (frameNumber == 30000) ///// TEMPORARY       TAG
		{						  /////
			m_running = false;	  /////
		}						  /////

		// Close Window
		if (getRenderWindow()->isClosed())
		{
			m_running = false;
		}
	} // End Loop

	float endTime = timer.getMilliseconds();

	float totalTime = endTime - startTime;

	std::cout << "Simultaion Duration: " << totalTime << "\n";

	while (true) /////////////// TEMP
	{
		// Chill Here For a Bit
	}

} // End Run

void
Simulation::update(int frameNumber)
{
	// Update Satellite
	m_satellite.update(frameNumber);

	// Camera AutoTrack Satellite ///////////////// MOVE SOMEWHERE ELSE
	Vector3 satPos = m_satellite.getNode()->getPosition();
	m_cameraNode->lookAt(satPos, Node::TS_PARENT);/////////////////////// Use AutoTrack in Future if you can

	///////////////////////////////////////////////////////////////////////////////////////// Move to New Function Later and pass in the texture as a parameter
	// Calculate Scene Brightness //

	// Pixel Format
	PixelFormat pf = m_renderTexture->suggestPixelFormat();

	// Width and Height of Texture
	int width  = m_renderTexture->getWidth();
	int height = m_renderTexture->getHeight();


	// Allocate Memory for the Pixel Data
	uchar *data = OGRE_ALLOC_T(uchar, width * height * PixelUtil::getNumElemBytes(pf), MEMCATEGORY_RENDERSYS);

	// Destination Pixel Box
	PixelBox pBox = PixelBox(width, height, 1, pf, data); 

	// Copy Teture Contents to Memory
	m_renderTexture->copyContentsToMemory(pBox, pBox);

	// Access Data Through an Image Object
	Image img = Image().loadDynamicImage(data, width, height, 1, pf, false, 1, 0);

	// Total Color
	double totalColor = 0;

	// Iterate Through Image
	for (int i = 0; i < width; i++)
	{
		for (int j = 0; j < height; j++)
		{
			totalColor += img.getColourAt(i, j, 0).r / 3;	
			totalColor += img.getColourAt(i, j, 0).g / 3;
			totalColor += img.getColourAt(i, j, 0).b / 3;
		}
	}

	img.freeMemory();

	// Free the Data
	OGRE_FREE(data, MEMCATEGORY_RENDERSYS);

	double brightness = totalColor / (double)(width * height);

	// Write Brightness Data to File
	std::ofstream file;
	file.open("../../res/data/data.txt", std::ios_base::app);
	file << std::to_string(brightness) << ", " << std::to_string((double)frameNumber / 50.0) << "\n"; // DIVIDE BY FRAMES PER SECOND HERE!!!       TAG
	file.close();

	////////////////////////////////////////////////////////////////////////////////////////////
} // end Update

void
Simulation::render(int frameNumber)
{

	// Render Frame in Window
	m_root->renderOneFrame();

	// Update RTT Texture
	m_renderTexture->update();

	// Write to File //
	if (m_renderToImage)
	{
		m_renderTexture->writeContentsToFile("../../res/images/img" + std::to_string(frameNumber) + ".png");
	}

} // end Render