package slra.simObjects.objects;

import slra.simObjects.utilities.Material;
import slra.simObjects.utilities.SimObject;
import slra.simulation.Transform;
import slra.util.ResourceLoader;

/**
 * CubeSat2U Object
 * A simulated 2U CubeSat
 * @author Henry Valentine
 *
 */
public class CubeSat2U extends SimObject{
	
	/** Creates a new Cube SimObject */
	public CubeSat2U() {
		super(ResourceLoader.loadMesh("2UCubeSat.obj"), new Transform(), new Material());
		
		//Default Transformation//
		transform.setScale(.03f, .03f, .03f);
		transform.setRotation(0, 0, 0);
		transform.setTranslation(0, 0, .25f);
	}

	
	/**
	 * Updates the state of this object.
	 * Sets orientation based on angular speeds.
	 */
	public void update() {
		
		xRot += xVel * 6;
		yRot += yVel * 6;
		zRot += zVel * 6;
		
		// Keep rotation values between 0 and 360 //
		if(xRot >= 360) xRot = 0;
		if(yRot >= 360) yRot = 0;
		if(zRot >= 360) zRot = 0;
		
		if(xRot < 0) xRot = 360;
		if(yRot < 0) yRot = 360;
		if(zRot < 0) zRot = 360;
		
		//Update transformation//
		transform.setRotation(xRot, yRot, zRot);
	}//end update

	/**
	 * Renders this object
	 */
	public void render() {
		mesh.draw();
	}//end render
	
	/**
	 * Returns a String representation of this Object
	 * @return String representing Object
	 */
	public String toString() {
		return "CubeSat2U";
	}//end toString
}//end class
