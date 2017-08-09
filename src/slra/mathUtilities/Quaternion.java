package slra.mathUtilities;
/**
 * Instantiations of this class represent Quaternions.
 * This class defines Quaternion operation methods.
 * 
 * @author Henry Valentine
 * based on thebennybox 3D game Engine Tutorial
 */
public class Quaternion {
	
	////* Instance Variables *////
	private float x, y, z, w;	//x, y, z, and w components of this quaternion
	
	////* Constructor *////
	/**
	 * Creates a new Quaternion
	 * @param x : x component
	 * @param y : y component
	 * @param z : z component
	 * @param w : w component
	 */
	public Quaternion(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}//end constructor
	
	/**
	 * Returns the length of this quaternion
	 * @return length
	 */
	public float length() {
		return (float)Math.sqrt(x * x + y * y + z * z);
	}//end length
	
	/**
	 * Normalize this quaternion.
	 * (i.e. set its length to 1)
	 * @return
	 */
	public Quaternion normalize() {
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		w /= length;
		
		return this;
	}//end normalize
	
	/**
	 * Return the conjugate of
	 * this quaternion
	 * @return conjugate
	 */
	public Quaternion conjugate() {
		return new Quaternion(-x, -y, -z, w);
	}//end conjugate
	
	/**
	 * Multiply this Quaternion by the given Quaternion
	 * @param r : Quaternion to multiply by
	 * @return	product of these quaternions
	 */
	public Quaternion multiply(Quaternion r) {
		
		float w_ = w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();//scalar component
		float x_ = w * r.getX() + x * r.getW() + y * r.getZ() - z * r.getY();
		float y_ = w * r.getY() + y * r.getW() + z * r.getX() - x * r.getZ();
		float z_ = w * r.getZ() + z * r.getW() + x * r.getY() - y * r.getX();		
				
		
		return new Quaternion(x_, y_, z_, w_);
	}//end multiply
	
	/**
	 * Multiply this quaternion by a 3D vector
	 * @param r : Vector to be multiplied by
	 * @return product of this Quaternion and the vector
	 */
	public Quaternion multiply(Vector3f r) {
		
		float w_ = -x * r.getX() - y * r.getY() - z * r.getZ();
		float x_ =  w * r.getX() + y * r.getZ() - z * r.getY();
		float y_ =  w * r.getY() + z * r.getX() - x * r.getZ();
		float z_ =  w * r.getZ() + x * r.getY() - y * r.getX();
		
		return new Quaternion(x_, y_, z_, w_);
	}//end multiply
	
	////* Getters and Setters *////
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
	public float getW() {
		return w;
	}
	public void setW(float w) {
		this.w = w;
	}
}//end class