package slra.lighting;

import slra.mathUtilities.Matrix4f;
import slra.mathUtilities.Vector3f;
import slra.simObjects.utilities.Material;
import slra.simulation.Transform;
import slra.util.RenderUtil;
import slra.util.ResourceLoader;

/**
 * PhongShader class
 * Allows the java program to update
 * variables (uniforms) in the shader
 * program.
 * Shader based on Phong lighting model
 * @author Henry Valentine
 * based on thebennybox 3D game Engine Tutorial
 */
public class PhongShader extends Shader {
	
	////* Simulation Light Variables *////
	private static Vector3f ambientLight = new Vector3f(0, 0, 0);//REMOVE
	private static DirectionalLight directionalLight = new DirectionalLight(new BaseLight(new Vector3f(1,1,1), 0), new Vector3f(0,0,0));
	
	/////* Constructor */////
	/**
	 * Calls superclass constructor.
	 * Creates and compiles GLSL shader
	 * Adds uniforms for the Phong shader.
	 * (Initializes them in the java program
	 * 	so the shader program equivalents may
	 * 	be updated)
	 */
	public PhongShader() {
		super();
		
		// Get Shader Code //
		String vs = ResourceLoader.loadText("res/shaders/phongVertex.vs");
		String fs = ResourceLoader.loadText("res/shaders/phongFragment.fs");
		
		// Check For Text Loading Error //
		if(vs == null || fs == null) {
			System.err.println("ERROR: Shader Text Failed to Load");
			new Exception().printStackTrace();
			System.exit(1);
		}
		
		addVertexShader(vs);		//Add vertex shader
		addFragmentShader(fs);		//Add fragment shader
		compileShader();			//Compile GLSL Shader
		
		// Transformation variables //
		addUniform("transform");
		addUniform("transformProjected");
		
		// Lighting variables //
		addUniform("baseColor");
		addUniform("ambientLight");
		
		addUniform("specularPower");
		addUniform("specularIntensity");
		
		// directionalLight struct in shader program //
		addUniform("directionalLight.base.color");		
		addUniform("directionalLight.base.intensity");
		addUniform("directionalLight.direction");
	
		
		addUniform("eyePos");//Camera Position ---> Remove
	}//end constructor
	
	/////* Methods */////
	/**
	 * This method updates the uniforms in
	 * the shader program. This is called for
	 * each mesh that is rendered so that
	 * its light interactions are accurately modeled.
	 */
	public void updateUniforms(Matrix4f worldMatrix, Matrix4f projectedMatrix, Material material) {
		
		//draw with the texture if there is a texture
		if(material.getTexture() != null) material.getTexture().bind();
		else RenderUtil.unbindTextures();
		
		setUniform("transform", worldMatrix);
		setUniform("transformProjected", projectedMatrix);
		setUniform("baseColor", material.getColor());		//remove this and make specific for individual game objects
		setUniform("ambientLight", ambientLight);
		setUniform("directionalLight", directionalLight);
		
		setUniformf("specularIntensity", material.getSpecularIntensity());	//remove and make specific for gameobjects
		setUniformf("specularPower", material.getSpecularPower());          //remove and make specific for gameobjects
		setUniform("eyePos", Transform.getCamera().getPos());
	}//end updateUniforms
	
	/////* Getters and Setters */////
	public static Vector3f getAmbientLight() { //REMOVE
		return ambientLight;
	}

	public static void setAmbientLight(Vector3f ambientLight) {//REMOVE
		PhongShader.ambientLight = ambientLight;
	}
	
	public void setUniform(String uniformName, BaseLight baseLight) {
		setUniform(uniformName + ".color", baseLight.getColor());//setUniform(String, Vector3f)
		setUniformf(uniformName + ".intensity", baseLight.getIntensity());
	}
	
	public void setUniform(String uniformName, DirectionalLight directionalLight) {
		setUniform(uniformName + ".base", directionalLight.getBase());
		setUniform(uniformName + ".direction", directionalLight.getDirection());
	}
	
	public static void setDirectionalLight(DirectionalLight directionalLight) {
		PhongShader.directionalLight = directionalLight;
	}
}//end class
