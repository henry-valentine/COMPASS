package slra.simulation;

import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.*;

/**
 * KeyHandler Class
 * Maintains a boolean array of
 * keys. Key value is true if the
 * key is pressed down. False Otherwise.
 * Handles Key Events
 * @author Henry Valentine
 */
public class KeyHandler extends GLFWKeyCallback {
	
	////* Instance Variables *////
	// Key Boolean Array //
	public static boolean [] keys = new boolean [65536];
	
	// KeyPressed Booleans //
	boolean spacePressed;	//Allows the action to be performed only once per press and release.
	//Use An array in the future? like the keys array?
	/////////////////////////
	
	////* Constructor *////
	public KeyHandler() {
		spacePressed = false;
	}
	
	////* Methods *////
	/**
	 * Check to see if the key is pressed
	 * @param keyCode
	 * @return whether or not the key is pressed
	 */
	public static boolean isKeyDown(int keyCode) {
		return keys[keyCode];
	}//end isKeyDown
	
	/**
	 * Sets the key boolean array value for a specific
	 * key to true if it is pressed down
	 */
	public void invoke(long window, int key, int scancode, int action, int mods) { 
		keys[key] = action != GLFW_RELEASE;//sets the boolean value for this key in the keys array to true if it's pressed
	}//end invoke
	
	/**
	 * Gets User Input
	 */
	public void getInput(Simulation sim) {
		// Terminate Simulation of ESCAPE is pressed //
		if(KeyHandler.isKeyDown(GLFW_KEY_ESCAPE)) {
			sim.running = false;
			keys[GLFW_KEY_ESCAPE] = false;
		}
		
		// Pause The Simulation //
		if(KeyHandler.isKeyDown(GLFW_KEY_SPACE)) {
			if(!spacePressed) {
				if(sim.paused) {
					sim.paused = false;
					System.out.println("User Input: Simulation Resumed");
				}
				else { 
					sim.paused = true;
					System.out.println("User Input: Simulation Paused");
				}
				spacePressed = true;
			}
		} else spacePressed = false;
	}//end getInput
}//end class
