package slra.util;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;

import slra.mathUtilities.Matrix4f;
import slra.simObjects.utilities.Vertex;

/**
 * Utilities Class
 * @author Henry Valentine
 * based on thebennybox 3D Game Engine Tutorial
 */
public class Util {

	////* Methods *////
	/**
	 * Creates a new Float Buffer
	 * @param size of data to be reserved for float buffer
	 * @return your very own brand new float buffer =D
	 */
	public static FloatBuffer createFloatBuffer(int size) {
		return BufferUtils.createFloatBuffer(size);
	}//end createFloatBuffer
	
	/**
	 * Creates a new Integer Buffer
	 * @param size of data to be reserved for int buffer
	 * @return new int buffer
	 */
	public static IntBuffer createIntBuffer(int size) {
		return BufferUtils.createIntBuffer(size);
	}
	
	/* 
	 * Creates and Flips an int buffer
	 * Creating Flipped buffers basically changes the buffer from a 'setter' mode to a 'getter' mode
	 * As a normal buffer, data cannot be read from it. Data is added w/ the put methods
	 * then it is flipped which allows data to be read.
	 */
	public static IntBuffer createFlippedBuffer(int... values) {
		IntBuffer buffer = createIntBuffer(values.length);
		buffer.put(values);
		buffer.flip();
		return buffer;
	}
	
	/**
	 * Crates a vertex buffer and flipis it
	 * @param vertices : vertex array to add to buffer
	 * @return new buffer
	 */
	public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {
		
		FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE); //vertices length * the size of each vertex for memory amount
		
		// Loads position, texture coordinate, and normal of each vertex to the buffer //
		for(int i = 0; i < vertices.length; i++){
			buffer.put(vertices[i].getPos().getX());
			buffer.put(vertices[i].getPos().getY());
			buffer.put(vertices[i].getPos().getZ());
			buffer.put(vertices[i].getTexCoord().getX());
			buffer.put(vertices[i].getTexCoord().getY());
			buffer.put(vertices[i].getNormal().getX());
			buffer.put(vertices[i].getNormal().getY());
			buffer.put(vertices[i].getNormal().getZ());
		}
		buffer.flip();
		return buffer;
	}//end createFlippedBuffer
	
	/**
	 * Creates a new Matrix Buffer and flips it
	 * @param Matrix to be put in a buffer
	 * @return new buffer
	 */
	public static FloatBuffer createFlippedBuffer(Matrix4f value) {
		
		FloatBuffer buffer = createFloatBuffer(4 * 4);
		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++){
				buffer.put(value.get(i, j));
			}
		}
		
		buffer.flip();//orders data for openGL
		
		return buffer;
	}//end createFlippedBuffer
	
	/**
	 * Removes all leading and trailing white spaces from all 
	 * elements in a given String array.
	 * 
	 * @param tokens : String array to be modified
	 * @return A new String [] with no leading or trailing empty spaces
	 */
	public static String [] removeEmptyStrings(String [] tokens) {//removes blank spaces from string array
		for(int i = 0; i < tokens.length; i++) {
			tokens[i] = tokens[i].trim();
		}
		return tokens;	
	}//end removeEmptyStrings
	
	/**
	 * Formats String [] from OBJ file
	 * @param tokens : individual lines of the obj file
	 * @return 
	 */
	public static String [] formatOBJ(String [] tokens) {
		for(int i = 0; i < tokens.length; i++) {
			tokens[i] = tokens[i].trim();
			
			/* Remove Empty Strings*/
			if(tokens[i].isEmpty()){
				String [] temp = new String [tokens.length - 1];
				
				for(int j = 0; j < temp.length; j++) {
					if(j < i) temp[j] = tokens[j];
					else temp[j] = tokens[j + 1];
				}
				tokens = temp;
				
				if(tokens.length == 0) return tokens;
			}
			
			
			if(tokens[i].contains("/")){ //removes slashes from face values
				tokens[i] = tokens[i].substring(0, tokens[i].indexOf("/"));
			}
		}
		return tokens;	
	}
	
	/**
	 * Converts an Integer ArrayList into an int array
	 * @param values : ArrayList to be converted
	 * @return int [] from ArrayList
	 */
	public static int [] toIntArray(ArrayList<Integer> values) {//convert Integer ArrayList to int Array
		
		int [] res = new int [values.size()];
		
		for(int i = 0; i < values.size(); i++) {
			res[i] = values.get(i);
		}
		return res;
	}//end toIntArray
}//end class
