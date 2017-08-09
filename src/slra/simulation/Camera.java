package slra.simulation;

import slra.mathUtilities.Vector3f;

/**
 * Camera Class
 * Represents the camera through which the
 * world is viewed. 
 * (Represents the view of the telescope in this program)
 * @author Henry Valentine
 * based on thebennybox 3D game engine tutorials
 */
public class Camera {

	public static final Vector3f yAxis = new Vector3f(0, 1, 0);//Absolute up
	
	////* Instance Variables *////
	private Vector3f pos;		//Camera position
	private Vector3f forward; 	//Which direction is forward
	private Vector3f up;		//Which direction is up
	
	////* Constructor *////
	/**
	 * Creates a new Camera object
	 * @param pos 	  : Vector position of the Camera
	 * @param forward : Forward vector of the Camera
	 * @param up	  : Up direction of the Camera
	 */
	public Camera(Vector3f pos, Vector3f forward, Vector3f up) {
		this.pos = pos;
		this.forward = forward;
		this.up = up;
		
		up.normalize();//turns into unit vector
		forward.normalize();
	}//end constructor
	
	/**
	 * Creates a new Camera
	 */
	public Camera() {
		this(new Vector3f(0, 0, 0), new Vector3f(0, 0, 1), new Vector3f(0, 1, 0));
	}//end constructor
	
	////* Methods *////
	/** 
	 * Returns the left facing Vector from the Camera 
	 * @return the left facing Vector from the camera
	 */
	public Vector3f getLeft() {
		Vector3f left = up.cross(forward);
		left.normalize();
		return left;
	}//end getLeft
	
	/** 
	 * Returns the right facing Vector from the Camera 
	 * @return the right facing Vector from the Camera
	 */
	public Vector3f getRight() {
		Vector3f right = forward.cross(up);
		right.normalize();
		return right;
	}//end getRight
	
	//* Getters and Setters *//
	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}

	public Vector3f getForward() {
		return forward;
	}

	public void setForward(Vector3f forward) {
		this.forward = forward;
	}

	public Vector3f getUp() {
		return up;
	}

	public void setUp(Vector3f up) {
		this.up = up;
	}
}//end class
