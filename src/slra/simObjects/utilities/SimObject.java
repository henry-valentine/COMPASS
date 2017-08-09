package slra.simObjects.utilities;

import slra.simulation.Transform;

/**
 * SimObject Class
 * SLRA Simulation Object BluePrint
 * @author Henry Valentine
 *
 */
public abstract class SimObject {
	
	////* Instance Variables *////
	protected Mesh mesh;				//Object mesh
	protected Transform transform;		//Position and orientation of object in the world
	protected Material material;		//Object material
	
	protected float xRot, yRot, zRot;	//Angular Positions along each axis
	protected float xVel, yVel, zVel;	//Angular Velocities on each axis
	
	/////* Constructors */////
	/**
	 * Primary Constructor
	 * Creates a new SLRA SimObject
	 * @param mesh		: Mesh defining the structure of this object 
	 * @param tranform	: Transformation of this objects vertices
	 * @param material	: Material this object is composed of
	 */
	public SimObject(Mesh mesh, Transform tranform, Material material) {
		this.mesh = mesh;
		this.transform = tranform;
		this.material = material;
	}//end constructor
	
	/**
	 * Creates a new SLRA SimObject
	 * Uses default material and texture
	 * @param mesh		: Mesh defining the structure of this object 
	 * @param tranform	: Transformation of this objects vertices
	 */
	public SimObject(Mesh mesh, Transform transform) {
		this(mesh, transform, new Material());
	}//end constructor
	
	/**
	 * Creates a new SLRA SimObject
	 * Default material and texture
	 * World position set to middle of the map.
	 * @param mesh : Mesh defining the structure of this object
	 */
	public SimObject(Mesh mesh) {
		this(mesh, new Transform(), new Material()); 
	}//end constructor
	
	
	/////* METHODS */////
	/**
	 * abstract update method
	 * TODO: Transformation, Reset up and forward vectors,
	 * physics, movement, etc...
	 */
	public abstract void update(); 
	
	/**
	 * abstract draw method
	 * TODO: Draw Mesh, render object
	 */
	public abstract void render();
	
	/**
	 * Creates a String representation
	 * of this Object
	 * 
	 * toString Must Be Overridden
	 * for all SimObjects
	 */
	public abstract String toString();
	
	/////* Getters and Setters */////
	public Mesh getMesh() {
		return mesh;
	}

	public void setMesh(Mesh mesh) {
		this.mesh = mesh;
	}

	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public float getxRot() {
		return xRot;
	}

	public void setxRot(float xRot) {
		this.xRot = xRot;
	}

	public float getyRot() {
		return yRot;
	}

	public void setyRot(float yRot) {
		this.yRot = yRot;
	}

	public float getzRot() {
		return zRot;
	}

	public void setzRot(float zRot) {
		this.zRot = zRot;
	}

	public float getxVel() {
		return xVel;
	}

	public void setxVel(float xVel) {
		this.xVel = xVel;
	}

	public float getyVel() {
		return yVel;
	}

	public void setyVel(float yVel) {
		this.yVel = yVel;
	}

	public float getzVel() {
		return zVel;
	}

	public void setzVel(float zVel) {
		this.zVel = zVel;
	} 
}//end class
