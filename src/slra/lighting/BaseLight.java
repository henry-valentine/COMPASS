package slra.lighting;

import slra.mathUtilities.Vector3f;

/**
 * Base Light Class
 * This class represents the base color and
 * intensity of a light
 * @author thebennybox
 */
public class BaseLight {

	private Vector3f color;
	private float intensity;
	
	public BaseLight(Vector3f color, float intensity) {
		this.color = color;
		this.intensity = intensity;
	}
	
	/* Generate Getters and Setters */
	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}

	public float getIntensity() {
		return intensity;
	}

	public void setIntensity(float intensity) {
		this.intensity = intensity;
	}
}//end class
