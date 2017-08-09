package slra.simulation;

import static org.lwjgl.glfw.GLFW.GLFW_DECORATED;
import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL11.GL_CW;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_RGB;
import static org.lwjgl.opengl.GL11.glFrontFace;
import static org.lwjgl.opengl.GL11.glReadPixels;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.system.MemoryUtil;

import slra.gui.GUI;
import slra.lighting.BaseLight;
import slra.lighting.DirectionalLight;
import slra.lighting.PhongShader;
import slra.lighting.Shader;
import slra.mathUtilities.Point2f;
import slra.mathUtilities.Vector3f;
import slra.simObjects.utilities.SimObject;
import slra.util.RenderUtil;

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
	
	@SuppressWarnings("unused")
	private GLFWKeyCallback keyCallback;			//Key Handler
	private KeyHandler keyHandler;					//Key Handler
	
	public final int DATA_INTERVAL;	//Data Collection Interval in milliseconds
	
	////* Constructor *////
	/**
	 * Creates a new SLRA Simulation
	 * @param passDuration : Duration of the pass (i.e. simulation time) in seconds
	 */
	public Simulation(int passDuration, GUI gui, int sampleRate) {
		DATA_INTERVAL = (int)((1 / (double)sampleRate) * 1000.0);
		System.out.println("Data Interval: " + DATA_INTERVAL);
		windowInit();
		init();
		this.gui = gui;
		gui.setRunning(true);	//Prevents Concurrent Simulations
		this.passDuration = passDuration;
		System.out.println("----- Simulation Initialized -----");
		gui.print("----- Simulation Initialized -----");
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
	public void addObject(SimObject object, Vector3f rAxis, float rAngle, Vector3f vAxis, float vAngle) {
		this.object = object;
		this.object.setRot(rAxis.normalize(), rAngle);
		this.object.setVel(vAxis.normalize(), vAngle);
	}//end setObject
	
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
			bSum += ((1.0/3) * pixels[i] + (1.0/3) * pixels[i+1] + (1.0/3) * pixels[i + 2]) / 255;//calculations for brightness (actual, not perceived)
		}
		return bSum / (WIDTH * HEIGHT);//Clamps from 0 to 1
	}//end getBrightness
	
	/** Updates the current SimObject */
	private void update() {
		object.update();//update Object
	}//end update
	
	/** Renders the current SimObject */
	private void render() {
		// Clears depth buffer too so it doesn't overwrite itself and produce a black screen //
		RenderUtil.clearScreen();
		
		shader.bind();//bind the shader to this context

		glFrontFace(GL_CW);//TEMP TEMP TEMP FIX!
		// Update Uniforms in Shader for light calculations //
		object.render(shader);
		
	}//end render
	
	/**
	 * Runs as soon as a new Simulation is Instantiated.
	 * This Method Calls the Update and Render Methods and
	 * serves as the core of the Simulation.
	 */
	public void run() {
		
		System.out.println("Simulation Running...");
		gui.print("Simulation Running...");
		
		double lastTime = System.currentTimeMillis();
		float elapsedTime = 0;
		
		// First Data Point //
		update();	//Might be a better way to get the first point...
		render();
		gui.addPoint(new Point2f(elapsedTime, getBrightness()));
		gui.graph();
		
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
							
					glfwSetWindowPos(windowID, gui.getX() + 180, gui.getY() + 32);//TEMP TEMP TEMP
					
					// Collect Brightness Data //
					double delta = System.currentTimeMillis() - lastTime;
					if(delta >= DATA_INTERVAL) {
						elapsedTime += delta;
						gui.addPoint(new Point2f(elapsedTime, getBrightness()));
						gui.graph();
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
				gui.saveData();
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
			System.err.println("GLFW FAILED TO INITIALIZE");
			gui.print("ERROR: GLFW FAILED TO INITIALIZE");
		}
		
		// Set window Parameters //
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); 
		glfwWindowHint(GLFW_DECORATED, GLFW_FALSE); // GETS RID OF BORDER
		
		
		// Create Window //
		windowID = glfwCreateWindow(WIDTH, HEIGHT, "Test3D", MemoryUtil.NULL, MemoryUtil.NULL);
		glfwSetWindowPos(windowID, 100, 100);		// SET WINDOW LOCATION (UPDATE EACH CYCLE IN NEW GUI)
		
		// Check Window Initialization //
		if(windowID == MemoryUtil.NULL) {
			System.err.println("ERROR: WINDOW FAILED TO INITIALIZE");
			gui.print("ERROR: WINDOW FAILED TO INITIALIZE");
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
		System.out.println("----- Simulation Terminated -----\n");
		gui.print("----- Simulation Terminated -----\n");
		gui.setRunning(false);
		glfwDestroyWindow(windowID);
		glfwTerminate();
	}//end terminate
}//end class
