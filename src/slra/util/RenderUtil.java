package slra.util;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

import slra.mathUtilities.Vector3f;
/**
 * Rendering Utilities
 * @author thebennybox
 */
public class RenderUtil {
	////* Methods *////
	/**
	 * Clears the Screen
	 */
	public static void clearScreen() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}//end clearScreen
	
	/**
	 * Unbind all textures from the
	 * current OpenGL context
	 */
	public static void unbindTextures() {
		glBindTexture(GL_TEXTURE_2D, 0);//bind texture to nothing  --> id = 0
	}//end bindTextures
	
	/**
	 * Enable or disable textures
	 * @param enabled
	 */
	public static void setTextures(boolean enabled) {
		if(enabled) glEnable(GL_TEXTURE_2D);
		else glDisable(GL_TEXTURE_2D);
	}//end setTextures
	
	/**
	 * Sets the clear color of the screen
	 * @param color
	 */
	public static void setClearColor(Vector3f color) {
		glClearColor(color.getX(), color.getY(), color.getZ(), 1);
	}//end setClearColor
	
	/**
	 * Initialize the graphics for openGL
	 */
	public static void initGraphics() {
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);	//clearColor set to 0 b/c space....
		
		glFrontFace(GL_CW);		//clockwise order of vertices defines the front of a face
		glCullFace(GL_BACK);	//Doesn't draw on back face
		glEnable(GL_CULL_FACE);	//normally draws the same thing on either side of a face. If you don't want the second face you cull it
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
	}//end initGraphics
}//end class
