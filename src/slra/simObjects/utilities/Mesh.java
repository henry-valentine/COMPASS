package slra.simObjects.utilities;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

import slra.mathUtilities.Vector3f;
import slra.util.Util;

/**
 * Represents the mesh of a
 * 3D object in OpenGL
 * @author thebennybox, Henry Valentine
 */
public class Mesh {
	
	////* Instance Variables *////
	private int vbo;	//Vertex Buffer Object. Handler which refers to the memory location of the vertex buffer for this mesh.
	private int ibo;	//Index Buffer Object. Handler which refers to the order in which these vertices are drawn.
	private int size;	//Number of vertices in the mesh. (Number of indices)
	
	////* Constructor *////
	/**
	 * Creates a new Mesh representing a
	 * 3D model of an object in OpenGL
	 */
	public Mesh() {
		vbo = glGenBuffers();//Creates Vertex Buffer referenced by the vbo handle
		ibo = glGenBuffers();//Create index buffer referenced by ibo handle
		size = 0;
	}//end constructor
	
	/**
	 * Add vertices to this mesh
	 * @param vertices : Vertices of the Mesh
	 * @param indices : the order in which these vertices are drawn (Allows vertex reuse)
	 * @param calcNormals : boolean value. Do normals need to be calculated?
	 */
	public void addVertices(Vertex[] vertices, int [] indices, boolean calcNormals) {
		
		if(calcNormals) calcNormals(vertices, indices);//calculate normals if asked to
		
		size = indices.length;//Number of vertices
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo); //type of buffer, bufferObject (GL_ARRAY_BUFFER is a Vertex Buffer) -> binds a buffer to the specified 'pointer'
		glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);//Lots of finagling to create the buffer and basically use vbo as a pointer
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);
	}//end addVertices
	
	/**
	 * Add vertices to this mesh
	 * Will not calculate vertex normals
	 * @param vertices : Vertices of the Mesh
	 * @param indices : the order in which these vertices are drawn (Allows vertex reuse)
	 */
	public void addVertices(Vertex[] vertices, int [] indices) {
		addVertices(vertices, indices, false);//default
	}//end addVertices
	
	/**
	 * Renders this mesh through the shader program
	 */
	public void draw() {
		
		// Create Attribute Buffer Arrays //
		// Attributes of a vertex //
		glEnableVertexAttribArray(0);//Vertex position
		glEnableVertexAttribArray(1);//Vertex Texutre Coordinates
		glEnableVertexAttribArray(2);//Vertex Normals
		
		// Bind this Buffer to the vbo handle //
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		
		// Establish the pointer for each Attribute in the vertex buffer //
		//1st parameter. Where to start in vertex buffer. Same as layout (location = 0)
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);	//Vertex positions
		glVertexAttribPointer(1, 2, GL_FLOAT, false, Vertex.SIZE * 4, 12);	//Vertex Texture Mapping Coordinates 
		glVertexAttribPointer(2, 3, GL_FLOAT, false, Vertex.SIZE * 4, 20);	//Vertex Normals
		//last parameter --> byte offset in the buffer		
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);				//bind buffer
		
		glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);	//Render to the screen
		
		// Disable Vertex Attribute Arrays //
		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(2);
	}//end draw
	
	/**
	 * Generates normals for all vertices in the mesh
	 * Normals are set as the average normal of all the faces that a vertex belongs to. 
	 */
	private void calcNormals(Vertex [] vertices, int [] indices) {
		for(int i = 0; i < indices.length; i += 3) {// += 3 b/c going by triangle faces
			int i0 = indices[i];
			int i1 = indices[i + 1];
			int i2 = indices[i + 2];
			
			//Gets line between vertices so you can get up direction
			Vector3f v1 = vertices[i1].getPos().subtract(vertices[i0].getPos());	//Vectors defining a face
			Vector3f v2 = vertices[i2].getPos().subtract(vertices[i0].getPos());	//
			
			Vector3f normal = v1.cross(v2).normalize();	//Creates the normal for a face
			
			//effectively averages the normals of each vertex based on the index
			//creates an average normal from all the faces that a vertex belongs to
			vertices[i0].setNormal(vertices[i0].getNormal().add(normal).normalize());
			vertices[i1].setNormal(vertices[i1].getNormal().add(normal).normalize());
			vertices[i2].setNormal(vertices[i2].getNormal().add(normal).normalize());
		}
	}//end calcNormals	
}//end class
