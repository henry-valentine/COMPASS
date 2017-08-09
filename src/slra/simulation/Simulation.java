package slra.simulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL.*;

import slra.gui.GUI;
import slra.lighting.BaseLight;
import slra.lighting.DirectionalLight;
import slra.lighting.PhongShader;
import slra.lighting.Shader;
import slra.mathUtilities.Point2f;
import slra.mathUtilities.Vector3f;
import slra.simObjects.utilities.SimObject;
import slra.util.RenderUtil;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.system.MemoryUtil;

/**
 * Simulation Class
 * Represents an SLRA simulation
 * @author Henry Valentine
 * @version 12/4/2016
 */
public class Simulation implements Runnable {
	
	////* Instance Variables *////
	private SimObject object;						//Object Modeled in simulation
	private int passDuration;						//Simulation Duration in Seconds
	private GUI gui;								//The GUI that created this simulation
	
	public static int WIDTH, HEIGHT;				//Width and Height of the Window displaying this simulation
	public static Camera camera;					//Camera (or telescope) of this simulation
	private long windowID;							//ID for the current Window
	public boolean running;							//Whether or not the Simulation is running
	public boolean paused;							//Whether simulation is paused or not
	private Shader shader;							//Shader for this simulation
	
	private GLFWKeyCallback keyCallback;			//Key Handler
	private KeyHandler keyHandler;					//Key Handler
	
	private ArrayList<Point2f> dataPoints;			//Brightness Data
	public static final int DATA_INTERVAL = 200;	//Data Collection Interval in milliseconds
	
	////* Constructor *////
	/**
	 * Creates a new SLRA Simulation
	 * @param passDuration : Duration of the pass (i.e. simulation time) in seconds
	 */
	public Simulation(int passDuration, GUI gui) {
		windowInit();
		init();
		this.gui = gui;
		gui.setRunning(true);	//Prevents Concurrent Simulations
		this.passDuration = passDuration;
		System.out.println("----- Simulation Initialized -----");
	}//end Constructor
	
	////* Methods *////
	/**
	 * Add an object to this simulation and adjust its translation
	 * to fill the screen.
	 * @param object : Object to be modeled in the simulation
	 * @param xRot 	 : Angular Position about x axis
	 * @param yRot 	 : Angular Position about y axis
	 * @param zRot 	 : Angular Position about z axis
	 * @param xVel 	 : Angular Velocity about x axis
	 * @param yVel 	 : Angular Velocity about y axis
	 * @param zVel 	 : Angular Velocity about z axis
	 */
	public void addObject(SimObject object, float xRot, float yRot, float zRot, float xVel, float yVel, float zVel) {
		this.object = object;
		
		object.setxRot(xRot);
		object.setyRot(yRot);
		object.setzRot(zRot);
		object.setxVel(xVel);
		object.setyVel(yVel);
		object.setzVel(zVel);
	}//end setObject
	
	/**
	 * Saves the Current Brightness Data as a text
	 * file in the data sub-directory
	 */
	public void saveData() {
		// Create File Name and Path //
		String path = "res/data/";
		path += "Simulation" + (gui.getSimulationList().size() + 1) + ".txt";
		
		// Create File //
		File dataFile = new File(path);
		
		try {
			FileWriter fr = new FileWriter(dataFile);
			
			// Write Data To File //
			for(Point2f point : dataPoints) {
				fr.write(point.getX() + " " + point.getY() + "\n");
			}
			fr.close();
			System.out.println("DATA SAVED: " + path);
			
		} catch (IOException e) {
			System.err.println("WARNING: FAILED TO SAVE SIMULATION DATA");
		}
		gui.clearSimulations();//clear simulations so files are not show more than once
		gui.loadSimulations();//Updates ComboBox in GUI
	}//end saveData
	
	/**
	 * Returns the brightness of the entire scene.
	 * @return brightness value for the entire scene
	 * This function should be migrated to shader program.
	 */
	private float getBrightness() {
		float [] pixels = new float [3 * WIDTH * HEIGHT];
		glReadPixels(0, 0, WIDTH, HEIGHT, GL_RGB, GL_FLOAT, pixels);
		
		float bSum = 0;
		
		for(int i = 0; i < pixels.length; i += 3) {
			bSum += (.333 * pixels[i] + .333 * pixels[i+1] + .333 * pixels[i + 2]) / 255;//calculations for brightness (actual, not perceived)
		}
		return bSum;
	}//end getBrightness
	
	/** Updates the current SimObject */
	private void update() {
		object.update();//update Object
	}//end update
	
	/** Renders the current SimObject */
	private void render() {
		// Clears depth buffer too so it doesn't overwrite itself and produce a black screen //
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		shader.bind();//bind the shader to this context
		
		// Update Uniforms in Shader for light calculations //
		shader.updateUniforms(object.getTransform().getTransformation(), object.getTransform().getProjectedTransformation(), object.getMaterial());
		object.render();
	}//end render
	
	/**
	 * Runs as soon as a new Simulation is Instantiated.
	 * This Method Calls the Update and Render Methods and
	 * serves as the core of the Simulation.
	 */
	public void run() {
		
		System.out.println("Simulation Running...");
		
		double lastTime = System.currentTimeMillis();
		float elapsedTime = 0;
		
		// First Data Point //
		update();	//Might be a better way to get the first point...
		render();
		dataPoints.add(new Point2f(elapsedTime, getBrightness()));
		
		// Run Simulation //
		while(running) {
			//Get User Input //
			keyHandler.getInput(this);	
			
			// Update //
			if(elapsedTime <= passDuration * 1000) {
				
				// Checks If the Simulation is Paused //
				if(!paused) {
					//Update Objects //
					update();
				
					// Collect Brightness Data //
					double delta = System.currentTimeMillis() - lastTime;
					if(delta >= DATA_INTERVAL) {
						elapsedTime += delta;
						dataPoints.add(new Point2f(elapsedTime, getBrightness()));
						lastTime = System.currentTimeMillis();
					}
				}
				else {
					lastTime += (System.currentTimeMillis() - lastTime);
				}
			}
			else {
				running = false;
			}
			
			// End Simulation and Save //
			if (!running) {
				// Save Data //
				saveData();
			}

			// Render Objects //
			render(); 
			
			// Check for Window Close //
			if(glfwWindowShouldClose(windowID)) running = false;
			
			glfwPollEvents();//Regulates FrameRate
			glfwSwapBuffers(windowID);//Swaps Buffered Images
		}
		// Terminate On Close //
		terminate();
	}//end run
	
	/** Initialize this simulation */
	private void init() {
		
		running = true;							//Simulation is now Running
		paused = false;							//Initialize to "not paused"
		
		dataPoints = new ArrayList<Point2f>(); 	//Initialize dataPoints for this Simulation
		
		camera = new Camera();					//Initialize Camera
		
		keyHandler = new KeyHandler();
		
		glfwSetKeyCallback(windowID, keyCallback = keyHandler);	//Apply new KeyHandler to GLFW context
		
		shader = new PhongShader();				//Create new Shader for this simulation
		PhongShader.setAmbientLight(new Vector3f(.1f, .1f, .1f));	//REMOVE REMOVE REMOVE REMOVE
		PhongShader.setDirectionalLight(new DirectionalLight(new BaseLight(new Vector3f(1,1,1), 0.8f), new Vector3f(1,1,1))); //REMOVE and HARDCODE
		
		Transform.setCamera(camera);			//Global Transformation for the Camera
		Transform.setProjection(70f, 0.1f, 1000, WIDTH, HEIGHT);	//Set projection parameters
	}//end init
	
	/** Initialize the window and graphics of this simulation */
	private void windowInit() {
		// Initialize Window height and Width //
		WIDTH = 800; HEIGHT = 600;
		
		// Initialize GLFW //
		if (!glfwInit()) {
			System.err.println("GLFW Failed to Initialize...");
		}
		
		// Set window Parameters //
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); 
		
		// Create Window //
		windowID = glfwCreateWindow(WIDTH, HEIGHT, "Test3D", MemoryUtil.NULL, MemoryUtil.NULL);
		
		// Check Window Initialization //
		if(windowID == MemoryUtil.NULL) {
			System.err.println("Window Failed to Initialize");
		}
		
		// Appends GLFW Context to this window //
		glfwMakeContextCurrent(windowID);
		
		// FPS //
		glfwSwapInterval(1);
		
		// Render the Window //
		glfwShowWindow(windowID);
		
		// Create GlCapabilities //
		createCapabilities();
		
		// Initialize Graphics //
		RenderUtil.initGraphics();
	}//end windowInit
	
	/** Ends the current simulation */
	public void terminate() {
		System.out.println("----- Simulation Terminated -----");
		gui.setRunning(false);
		glfwDestroyWindow(windowID);
		glfwTerminate();
	}//end terminate
}//end class
