package slra.simulation;

import slra.mathUtilities.Matrix4f;
import slra.mathUtilities.Quaternion;
import slra.mathUtilities.Vector3f;
import slra.simObjects.utilities.SimObject;

/**
 * Transform Class
 * This class creates a Transformation
 * matrix which is applied to each vertex position 
 * vector in the shader program.
 * @author Henry Valentine
 * Based on thebennybox 3D game engine tutorial
 *
 */
public class Transform {
	
	////* Instance Variables *////
	// Projection Variables //
	private static float zNear;		//Near Clipping Range
	private static float zFar;		//Far Clipping Range
	private static float WIDTH;		//Window Width
	private static float HEIGHT;	//Window Height
	private static float fov;		//Field of View
	
	private static Camera camera;	//Camera (Or Telescope) for this Simulation
	
	// Transformation Vectors //
	private Vector3f translation;	//Translation Vector
	private Quaternion rotation;	//x,y,z rotation values
	private Vector3f scale;			//x,y,z scale factors
	
	// Parent Object //
	private SimObject parent;
	
	////* Constructors *////
	/**
	 * Creates a new Transform Object
	 * With the given translation, rotation,
	 * and scale and the given parent object.
	 * @param translation : Object Translation
	 * @param rotation	  : Object Rotation
	 * @param scale		  : Object Scale
	 * @param parent	  : Parent Object
	 */
	public Transform(Vector3f translation, Quaternion rotation, float scale, SimObject parent) {
		this(new Vector3f(0, 1, 0), new Vector3f(0, 0, 1), parent);
		this.translation = translation;
		setRotation(rotation);
		this.scale = new Vector3f(scale, scale, scale);
	}//end constructor
	
	/**
	 * Creates a new Transform object
	 * with the given translation, rotation
	 * and scale.
	 * @param translation : Object Translation
	 * @param rotation	  : Object Rotation
	 * @param scale		  : Object Scale
	 */
	public Transform(Vector3f translation, Quaternion rotation, float scale) {
		this(translation, rotation, scale, null);
	}//end Constructor
	
	/**
	 * TODO: REMOVE THIS CONSTRUCTOR
	 */
	public Transform(Vector3f upAxis, Vector3f forwardAxis, SimObject parent) {
		translation = scale = new Vector3f(0,0,0);
		rotation = new Quaternion(0,0,0,1);
	}//end constructor
	
	/**
	 * TODO: REMOVE THIS CONSTRUCTOR
	 */
	public Transform(Vector3f upAxis, Vector3f forwardAxis) {
		this(upAxis, forwardAxis, null);
	}//end constructor
	
	/**
	 * Creates a new Transform object with default
	 * up and forward axes. This object is bound to
	 * the parent object provided.
	 * @param parent - Parent object of this object
	 */
	public Transform(SimObject parent) {
		this(new Vector3f(0, 1, 0), new Vector3f(0, 0, 1), parent);
	}//end constructor
	
	/**
	 * Creates a new Transform Object
	 * using default up and forward axes
	 */
	public Transform() {
		this(new Vector3f(0, 1, 0), new Vector3f(0, 0, 1), null);
	}//end Constructor
	
	////* Methods *////
	
	/**
	 * Combines rotation, translation, and 
	 * scale matrices to create and return 
	 * a single Transformation Matrix.
	 * @return transformation matrix
	 */
	public Matrix4f getTransformation() {
		Matrix4f translationMatrix = new Matrix4f().initTranslation(translation.getX(), translation.getY(), translation.getZ());	//Translation Matrix
		Matrix4f rotationMatrix = rotation.toRotationMatrix();																		//Rotation Matrix
		Matrix4f scaleMatrix = new Matrix4f().initScale(scale.getX(), scale.getY(), scale.getZ());									//Scale Matrix
		
		Matrix4f parentMatrix;
		
		if(parent != null) {
			parentMatrix = parent.getTransform().getTransformation();//MOVE TO INSTANCE VARIABLE AND SET TO IDENTITY IN CONSTRUCTOR	 
		} 
		else {
			parentMatrix = new Matrix4f().initIdentity();
		}
		
		return parentMatrix.multiply(translationMatrix.multiply(rotationMatrix.multiply(scaleMatrix)));//Order of multiplication matters!
	}//end getTransformation													 
	
	/**
	 * Initializes the projection matrix values
	 * @param fov		: Field of View
	 * @param zNear		: Near Clipping Range
	 * @param zFar		: Far Clipping Range
	 * @param WIDTH		: Window Width
	 * @param HEIGHT	: Window Height
	 */
	public static void setProjection(float fov, float zNear, float zFar, float WIDTH, float HEIGHT) {
		Transform.fov = fov; //b/c static not instance
		Transform.zNear = zNear;
		Transform.zFar = zFar;
		Transform.WIDTH = WIDTH;
		Transform.HEIGHT = HEIGHT;
	}//end setProjection
	
	/**
	 * Combines The Transformation Matrix with the
	 * projection Matrix and the Camera Matrices in
	 * order to produce the final projection Matrix
	 * to be used in the shader.
	 * @return Projection Matrix
	 */
	public Matrix4f getProjectedTransformation() {
		
		Matrix4f transformationMatrix = getTransformation();
		Matrix4f projectionMatrix = new Matrix4f().initProjection(fov, zNear, zFar, WIDTH, HEIGHT);
		Matrix4f cameraRotationMatrix = new Matrix4f().initRotation(camera.getForward(), camera.getUp());
		Matrix4f cameraTranslationMatrix = new Matrix4f().initTranslation(-camera.getPos().getX(), -camera.getPos().getY(), -camera.getPos().getZ());
		
		return projectionMatrix.multiply(cameraRotationMatrix.multiply(cameraTranslationMatrix.multiply(transformationMatrix)));
	}//end getProjectedTraasnformation
	
	//* Getters and Setters *//
	public Vector3f getTranslation() {
		return translation;
	}
	
	public void setTranslation(Vector3f translation) {
		this.translation = translation;
	}
	
	public void setTranslation(float x, float y, float z) {
		this.translation = new Vector3f(x, y, z);
	}
	
	public Quaternion getRotation() {
		return rotation;
	}
	
	public void setRotation(Quaternion rotation) {
		this.rotation = rotation;
	}
	
	public void setRotation(float x, float y, float z, float w) {
		setRotation(new Quaternion(x, y, z, w));
	}
	
	public Vector3f getScale() {
		return scale;
	}
	
	public void setScale(Vector3f scale) {
		this.scale = scale;
	} 
	
	public void setScale(float x, float y, float z) {
		this.scale = new Vector3f(x, y, z);
	}
	
	public void setScale(float scale) {
		this.scale = new Vector3f(scale, scale, scale);
	}
	
	public SimObject getParent() {
		return parent;
	}
	
	public void setParent(SimObject parent) {
		this.parent = parent;
	}
	public static Camera getCamera() {
		return camera;
	}
	
	public static void setCamera(Camera camera) {
		Transform.camera = camera;
	}
}//end class
