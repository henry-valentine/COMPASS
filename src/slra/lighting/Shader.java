package slra.lighting;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

import java.util.HashMap;
import slra.mathUtilities.Matrix4f;
import slra.mathUtilities.Vector3f;
import slra.simObjects.utilities.Material;
import slra.util.Util;

/**
 * Shader Class
 * This class serves as a blueprint for specific shader classes.
 * Shader objects in this program act as an interface between
 * the java program and the GLSL shader program.
 * @author thebennybox
 */
public abstract class Shader {
	
	////* Instance Variables *////
	private int program; 					   //Handler that refers to the memory location of the shader program
	private HashMap<String, Integer> uniforms; //Refer to uniforms with string names
	
	////* Constructor *////
	/**
	 * Creates a new shader program and 
	 * initializes the uniform HashMap
	 */
	public Shader() {
		program = glCreateProgram();//Creates a program object referenced by the pointer "program"
		uniforms = new HashMap<String, Integer>();
		
		if(program == 0) {
			System.err.println("Shader Creation Failed");
			System.exit(1);//Terminates program
		}
	}//end constructor
	
	////* Methods *////
	/**
	 * binds the shader program to the
	 * current OpenGL context
	 */
	public void bind() {
		glUseProgram(program);//bind program to OpenGL context
	}//end bind
	
	/**
	 * This method updates the shader uniforms.
	 * Shader is never instantiated so this method is only
	 * implemented in subclasses
	 * @param worldMatrix	  : Object's transformation
	 * @param projectedMatrix : Projection transformation for object
	 * @param material		  :	Material of the object
	 */
	public abstract void updateUniforms(Matrix4f worldMatrix, Matrix4f projectedMatrix, Material material);
	
	/**
	 * Adds a new vertex shader
	 * @param text : The GLSL code loaded for the shader
	 */
	public void addVertexShader(String text){
		addProgram(text, GL_VERTEX_SHADER);
	}//end addVertexShader
	
	/**
	 * Adds a new Fragment shader
	 * @param text : The GLSL code loaded for the shader
	 */
	public void addFragmentShader(String text) {
		addProgram(text, GL_FRAGMENT_SHADER);
	}//end addFragmentShader
	
	/**
	 * Compiles the GLSL code into a new shader program 
	 */
	public void compileShader() {
		glLinkProgram(program);//links all the shaders together in the program
		
		if(glGetProgrami(program, GL_LINK_STATUS) == 0){
			System.err.println(glGetShaderInfoLog(program, 1024));//linkage fails
		}
		
		glValidateProgram(program);//make sure program works
	}//end compileShader
	
	/**
	 * Add a new shader to the program
	 * @param text : GLSL code of shader
	 * @param type : type of shader (Vertex or Fragment)
	 */
	public void addProgram(String text, int type){
		
		int shader = glCreateShader(type);//pointer for the shader object
		
		if (shader == 0){
			System.err.println("Shader Creation Failed. ");
			System.exit(1);
		}
		
		glShaderSource(shader, text);	//attaches text to shader for compilation
		glCompileShader(shader);		//compiles the shader
		
		if(glGetShaderi(shader, GL_COMPILE_STATUS) == 0){
			System.err.println("Shader Compilation Error");
			System.err.println(glGetShaderInfoLog(shader, 1024));
		}
		
		glAttachShader(program, shader);//attaches shader to the program
		
	}//end addProgram
	
	/**
	 * Adds a new uniform variable to this shader
	 * @param uniform : a new uniform variable. (Uniforms are variables that can be initialized on the CPU and sent to the 
	 * shader program on the GPU for use in rendering calculations)
	 */
	public void addUniform(String uniform) {
		int uniformLocation = glGetUniformLocation(program, uniform);//returns handler representing the location of the uniform variable
		
		//*NOTE: Could not find Uniform Variable errors can occur if the uniform is never used in the shader outside of the declaration
		
		// Error Check //
		if(uniformLocation == -1) {
			System.err.println("Could not find Uniform Variable: " + uniform);
			new Exception().printStackTrace();
			System.exit(1);
		}
		
		uniforms.put(uniform, uniformLocation);//Adds this uniform to the uniform HashMap	
	}//end addUniform
	
	//* Uniform Setter Methods *//
	public void setUniformi(String uniformName, int value) {//sets the uniform variable to the value in the 2nd parameter
		glUniform1i(uniforms.get(uniformName), value);//stores value in the pointer location given in the first parameter. 
	}
	
	public void setUniformf(String uniformName, float value) {
		glUniform1f(uniforms.get(uniformName), value);
	}
	
	public void setUniform(String uniformName, Vector3f value) {
		glUniform3f(uniforms.get(uniformName), value.getX(), value.getY(), value.getZ());//sets the uniform variable to the x, y, z values of the vector	
	}
	
	public void setUniform(String uniformName, Matrix4f value) {///NOT DONE
		glUniformMatrix4fv(uniforms.get(uniformName), true, Util.createFlippedBuffer(value));
		
	}
}//end class
