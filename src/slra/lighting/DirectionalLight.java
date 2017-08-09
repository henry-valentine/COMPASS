package slra.lighting;

import slra.mathUtilities.Vector3f;

/**
 * DirectionalLight class
 * represents a directional light in
 * the shader program.
 * @author thebennybox
 * This and the BaseLight are meant to mirror the GLSL code
 */
public class DirectionalLight {

	private BaseLight base;
	private Vector3f direction;
	
	public DirectionalLight(BaseLight base, Vector3f direction) {
		this.base = base;
		this.direction = direction.normalize();
	}//end constructor
	
	/* Getters and Setters */
	public BaseLight getBase() {
		return base;
	}

	public void setBase(BaseLight base) {
		this.base = base;
	}

	public Vector3f getDirection() {
		return direction;
	}

	public void setDirection(Vector3f direction) {
		this.direction = direction;
	}	
}//end class
