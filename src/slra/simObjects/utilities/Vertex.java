package slra.simObjects.utilities;

import slra.mathUtilities.Vector2f;
import slra.mathUtilities.Vector3f;
/**
 * This class represents a mesh vertex
 * @author thebennybox, Henry Valentine
 */
public class Vertex {
	
	// Byte size of a vertex //
	public static final int SIZE = 8;	//Update size when instance variables are added! 
									 	//Add instance variables to FlippedBuffer method in Util class
	
	////* Instance Variables *////
	private Vector3f pos;
	private Vector2f texCoord; //Texture Coordinate
	private Vector3f normal;
	
	////* Constructors *////
	/**
	 * Creates a new Vertex with
	 * the given position, texture
	 * mapping coordinate, and normal
	 * vector
	 * @param pos		: Position vector of this vertex
	 * @param texCoord	: Texture mapping coordinate of this vertex
	 * @param normal	: Normal vector of this vertex
	 */
	public Vertex(Vector3f pos, Vector2f texCoord, Vector3f normal) {
		this.pos = pos;
		this.texCoord = texCoord;
		this.normal = normal;
	}//end constructor
	
	/**
	 * Creates a new vertex
	 * with default normal vector
	 * (to be calculated later)
	 * @param pos		: Position vector of this vertex
	 * @param texCoord	: Texture mapping coordinate of this vertex
	 */
	public Vertex(Vector3f pos, Vector2f texCoord) {
		this(pos, texCoord, new Vector3f(0, 0, 0));
	}//end constructor
	
	/**
	 * Creates a new Vertex
	 * with default texture
	 * coordinate and normal
	 * vector
	 * @param pos	: Position vector of this vertex
	 */
	public Vertex(Vector3f pos) {
		this(pos, new Vector2f(0, 0));
	}//end Constructor
	
	////* Methods *////
	
	/* Getters and Setters */
	public Vector2f getTexCoord() {
		return texCoord;
	}

	public void setTexCoord(Vector2f texCoord) {
		this.texCoord = texCoord;
	}

	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}

	public Vector3f getNormal() {
		return normal;
	}

	public void setNormal(Vector3f normal) {
		this.normal = normal;
	}
}//end class
