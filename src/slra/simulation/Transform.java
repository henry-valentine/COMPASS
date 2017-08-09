package slra.simulation;

import slra.mathUtilities.Matrix4f;
import slra.mathUtilities.Vector3f;

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
	private Vector3f rotation;		//x,y,z rotation values
	private Vector3f scale;			//x,y,z scale factors
	
	// Orientation Vectors //
	private Vector3f up, forward; 					//Current Up and Forward Directions of the Object
	private final Vector3f UP_AXIS, FORWARD_AXIS;	//
	
	////* Constructors *////
	/**
	 * Creates a new Transform object
	 * and initializes the translation,
	 * rotation, and scale vectors to 0
	 * @param upAxis 		: The direction of the objects "Up" Axis
	 * @param forwardAxis	: The direction of the objects "Forward" Axis
	 */
	public Transform(Vector3f upAxis, Vector3f forwardAxis) {
		translation = rotation = scale = new Vector3f(0,0,0);
		this.UP_AXIS = upAxis.normalize();
		this.FORWARD_AXIS = forwardAxis.normalize();
		
		up = new Vector3f(0, 0, 0);			//Initialize up to default
		forward = new Vector3f(0, 0, 0);	//Initialize forward to default
		
		// Set up to the Up Axis //
		up.setX(this.UP_AXIS.getX());
		up.setY(this.UP_AXIS.getY());
		up.setZ(this.UP_AXIS.getZ());
		
		// Set forward to the Forward Axis //
		forward.setX(this.FORWARD_AXIS.getX());
		forward.setY(this.FORWARD_AXIS.getY());
		forward.setZ(this.FORWARD_AXIS.getZ());
	}//end constructor
	
	/**
	 * Creates a new Transform Object
	 * using default up and forward axes
	 */
	public Transform() {
		this(new Vector3f(0, 1, 0), new Vector3f(0, 0, 1));
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
		Matrix4f rotationMatrix = new Matrix4f().initRotation(forward, up);															//Rotation Matrix
		Matrix4f scaleMatrix = new Matrix4f().initScale(scale.getX(), scale.getY(), scale.getZ());									//Scale Matrix
		
		return translationMatrix.multiply(rotationMatrix.multiply(scaleMatrix));//Order of multiplication matters!
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
	
	public Vector3f getRotation() {
		return rotation;
	}
	
	public void setRotation(Vector3f rotation) {
		up.setX(UP_AXIS.getX());
		up.setY(UP_AXIS.getY());
		up.setZ(UP_AXIS.getZ());
		
		forward.setX(FORWARD_AXIS.getX());
		forward.setY(FORWARD_AXIS.getY());
		forward.setZ(FORWARD_AXIS.getZ());
		
		Vector3f r = forward.cross(up).normalize();
		
		up.rotate(rotation.getX(), r).normalize();
		forward.rotate(rotation.getX(), r).normalize();
	
		//Rotate Up about z and Forward about y
		up.rotate(rotation.getZ(), forward).normalize();
		forward.rotate(rotation.getY(), up).normalize();
	}
	
	public void setRotation(float x, float y, float z) {
		setRotation(new Vector3f(x, y, z));
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
	
	public static Camera getCamera() {
		return camera;
	}
	
	public static void setCamera(Camera camera) {
		Transform.camera = camera;
	}
}//end class
