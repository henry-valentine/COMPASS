package slra.simObjects.utilities;

import static org.lwjgl.opengl.GL11.*;
/**
 * Represents a texture object
 * @author thebennybox
 *
 */
public class Texture {
	
	////* Instance Variable *////
	private int id;	//Texture id. Handle for the texture
	
	////* Constructor *////
	/**
	 * Creates a new Texture with the
	 * given texture id
	 * @param id
	 */
	public Texture(int id) {
		this.id = id;
	}//end constructor
	
	////* Methods *////
	/**
	 * Bind this texture to the 
	 * current OpenGL context so
	 * that it is used to draw
	 */
	public void bind() {
		glBindTexture(GL_TEXTURE_2D, id);
	}//end bind
	
	/**
	 * Returns the id of this texture
	 * @return texture id
	 */
	public int getId() {
		return id;
	}//end getId
}//end class
