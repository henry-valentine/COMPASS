/********************************************************
* Computational Photometry Analyzer for Small Satellites
* Copyright ©, 2017 Embry-Riddle Aeronautical University
*
* File: Simulation.h
*
* @author Henry Valentine
* @version 12/05/2017
*
* Represents a Photometry Simulation
*
********************************************************/

#ifndef SIMULATION_H
#define SIMULATION_H

#include <Ogre.h>
#include <OgreApplicationContext.h>
#include <OgreApplicationContext.h>
#include <OgreRTShaderSystem.h>
#include <iostream>
#include <fstream>

#include "Satellite.h"

using namespace Ogre;
using namespace OgreBites;

class Simulation
	: public ApplicationContext
{

public:
	/* Constructor-Destructor */
	Simulation();
	virtual ~Simulation();

	/* Initialize Simulation */
	void initSim();

	/* Overridden from ApplicationContext */
	void setup();

	/* Run the Simulation */
	void run();

	/* Render Frame */
	void render(int frameNumber);

	/* Update Freame */
	void update(int frameNumber);

private:

	// Setup Elements //
	Root*						m_root;			 // Pointer to the Root Object
	SceneManager*				m_scnMgr;		 // Pointer to Scene Manager
	RTShader::ShaderGenerator*	m_shaderGen;	 // Pointer to Shader Generator
	bool						m_running;

	// Scene Elements //
	Satellite					m_satellite;	 // Satellite Object
	Light*						m_sun;			 // Sun Object
	Camera*						m_camera;		 // Camera Object

	// Position Elements //
	SceneNode*					m_cameraNode;
	SceneNode*					m_sunNode;
	Vector3						m_sunDirection;

	// Rendering Elements //
	Ogre::TexturePtr			m_rttTexture;	 // RTT Texture Pointer
	Ogre::RenderTexture*		m_renderTexture; // RTT Texture
	bool						m_renderToImage; // Render to Image
};




#endif // SIMULATION_H
