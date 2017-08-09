package slra.simObjects.utilities;

import static org.lwjgl.opengl.GL11.GL_CCW;
import static org.lwjgl.opengl.GL11.glFrontFace;

import java.util.ArrayList;

import slra.lighting.Shader;
import slra.mathUtilities.Quaternion;
import slra.mathUtilities.Vector3f;
import slra.simulation.Transform;

/**
 * SimObject Class
 * SLRA Simulation Object BluePrint
 * @author Henry Valentine
 * @version 1/26/2017
 */
public class SimObject {
	
	////* Instance Variables *////
	protected Mesh mesh;				//Object mesh
	protected Transform transform;		//Position and orientation of object in the world
	protected Material material;		//Object material
	protected String id;				//Object ID
	private boolean root;				//Is this a root object?
	
	protected Quaternion rot;			//Rotation Quatenrion
	protected Quaternion vel;			//Angular Velocity Quaternion
	
	protected ArrayList<SimObject> children;	//Child Objects
	
	/////* Constructors */////
	/**
	 * Primary Constructor
	 * Creates a new SLRA SimObject
	 * @param mesh		: Mesh defining the structure of this object 
	 * @param tranform	: Transformation of this objects vertices
	 * @param material	: Material this object is composed of
	 * @param id		: Object ID
	 */
	public SimObject(Mesh mesh, Transform transform, Material material, String id) {
		this.mesh = mesh;
		this.transform = transform;
		this.material = material;
		this.id = id;
		children = new ArrayList<SimObject>();
		root = false;
	}//end constructor
	
	/**
	 * Creates a new SLRA SimObject
	 * Uses default material and texture
	 * @param mesh		: Mesh defining the structure of this object 
	 * @param tranform	: Transformation of this objects vertices
	 * @param id		: Object ID
	 */
	public SimObject(Mesh mesh, Transform transform, String id) {
		this(mesh, transform, new Material(), id);
	}//end constructor
	
	/**
	 * Creates a new SLRA SimObject
	 * Uses Default Transform
	 * @param mesh		: Mesh defining the structure of this object 
	 * @param material	: Material this object is composed of
	 * @param id		: Object ID
	 */
	public SimObject(Mesh mesh, Material material, String id) {
		this(mesh, new Transform(), material, id);
	}
	
	/**
	 * Creates a new SLRA SimObject
	 * Default material and texture
	 * World position set to middle of the map.
	 * @param mesh : Mesh defining the structure of this object
	 * @param id		: Object ID
	 */
	public SimObject(Mesh mesh, String id) {
		this(mesh, new Transform(), new Material(), id); 
	}//end constructor
	
	/**
	 * Creates a new SLRA Root SimObject
	 * This is an invisible SimObject used
	 * to serve as the parent to other objects.
	 * The entire unit's transformation is based
	 * on the root transformation.
	 */
	public SimObject(String id) {
		this.children = new ArrayList<SimObject>();
		this.transform = new Transform();
		this.material = new Material();
		this.mesh = new Mesh();
		this.id = id;
		this.root = true;
	}//end constructor
	
	/////* METHODS */////
	/**
	 * Add a child objects to this
	 * object.
	 * @param child : Child Object to be added to this object
	 */
	public void addChild(SimObject child) {
		children.add(child);
		child.getTransform().setParent(this);
	}//end addChildren
	
	/**
	 * Add child objects to this object.
	 * @param children : child objects to be added to this object
	 */
	public void addChildren(SimObject... children) {
		for(SimObject child : children) {
			this.children.add(child);
			child.getTransform().setParent(this);
		}
	}//end addChildren
	
	/**
	 * updates this object and
	 * all associated child objects
	 */
	public void update() {

		
		// Sets Rotation of Parent Object Only //
		if(transform.getParent() == null) {
			rot = rot.multiply(vel);	//Apply angular velocity to initial position		//TEST TEST TEST
			transform.setRotation(rot);
		}
		
		// Updates Children //
		if(children.size() != 0) {
			for(SimObject child : children) {
				child.update();
			}
		}
	}//end update 
	
	/**
	 * Renders this object and
	 * its associated Child Objects
	 */
	public void render(Shader shader) {
		// Stops Culling Issue //
		if(transform.getParent() != null) {
			glFrontFace(GL_CCW);//TEMP FIX!
		}
		
		// Update Shader Uniforms and Draw //
		shader.updateUniforms(transform.getTransformation(), transform.getProjectedTransformation(), material);
		mesh.draw();
		
		// Render Children //
		if(children.size() != 0) {
			for(SimObject child : children) {
				child.render(shader);
			}
		}
	}//end render
	
	/**
	 * Creates a String representation
	 * of this Object
	 */
	public String toString() {
		return id;
	}
	
	/////* Getters and Setters */////
	public boolean isRoot() {
		return root;
	}
	
	public ArrayList<SimObject> getChildren() {
		return children;
	}
	
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
	
	public void setRot(Quaternion rot) {
		this.rot = rot;
	}
	
	public void setRot(float x, float y, float z, float angle) {
		this.rot = new Quaternion().initRotation(new Vector3f(x,  y, z), angle); 
	}
	
	public void setRot(Vector3f axis, float angle) {
		this.rot = new Quaternion().initRotation(axis, angle);
	}
	
	public Quaternion getRot() {
		return rot;
	}
	
	public void setVel(Quaternion rot) {
		this.vel = rot;
	}
	
	public void setVel(float x, float y, float z, float angle) {
		this.vel = new Quaternion().initRotation(new Vector3f(x,  y, z), angle); 
	}
	
	public void setVel(Vector3f axis, float angle) {
		this.vel = new Quaternion().initRotation(axis, angle);
	}
	
	public Quaternion getVel() {
		return vel;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
}//end class
