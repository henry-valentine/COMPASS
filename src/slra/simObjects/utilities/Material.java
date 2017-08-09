package slra.simObjects.utilities;

import slra.mathUtilities.Vector3f;
import slra.util.ResourceLoader;

/**
 * This Class represents an instantiation of a SimObject's material.
 * Material defines the color, texture, and light reflection properties
 * of an object.
 * 
 * @author Henry Valentine
 *
 */
public class Material {
	
	/////* Instance Variables */////
	private String id;					//Material ID
	private Texture texture;			//Object Texture
	private Vector3f color;				//Object Base Color
	private float specularIntensity;	//Reflection intensity
	private float specularPower;		//How wide the reflection is
	
	/////* Constructors */////
	/**
	 * Primary Constructor
	 * Creates new Material Object
	 * @param texture			 : Texture of the Object
	 * @param color				 : Base Color of the Object
	 * @param specularIntensity	 : Reflection Intensity
	 * @param specularPower		 : Reflection Width
	 */
	public Material(Texture texture, Vector3f color, float specularIntensity, float specularPower, String id) {
		this.texture = texture;
		this.color = color;
		this.specularIntensity = specularIntensity;
		this.specularPower = specularPower;
		this.id = id;
	}//end constructor
	
	/**
	 * Creates new Material Object
	 * With default specular Intensity and Power
	 * @param texture			 : Texture of the Object
	 * @param color				 : Base Color of the Object
	 */
	public Material(Texture texture, Vector3f color) {
		this(texture, color, 2, 32, "DEFAULT");//default values    Do research to calculate these factor for the project
	}//end constructor
	
	/**
	 * Creates new Material Object
	 * With default specular Intensity and Power
	 * and default Texture
	 * @param color				 : Base Color of the Object
	 */
	public Material(Vector3f color) {
		this(ResourceLoader.loadTexture("defaultTexture.png"), color);
	}//end constructor
	
	/**
	 * Creates new Material Object
	 * With default specular Intensity and Power
	 * and default Base Color
	 * @param texture			 : Texture of the Object
	 */
	public Material(Texture texture) {
		this(texture, new Vector3f(1,1,1));
	}//end constructor
	
	/**
	 * Default Material
	 * Creates new Material Object
	 * With default specular Intensity and Power,
	 * default base color, and default texture
	 * @param texture			 : Texture of the Object
	 * @param color				 : Base Color of the Object
	 */
	public Material() {
		this(ResourceLoader.loadTexture("defaultTexture.png"));
	}//end constructor

	////* Methods *////
	
	//* Getters and Setters *//
	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}

	public float getSpecularIntensity() {
		return specularIntensity;
	}

	public void setSpecularIntensity(float specularIntensity) {
		this.specularIntensity = specularIntensity;
	}

	public float getSpecularPower() {
		return specularPower;
	}

	public void setSpecularPower(float specularExponent) {
		this.specularPower = specularExponent;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
}//end class