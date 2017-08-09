package slra.mathUtilities;

/**
 * This class represents 3D vectors
 * and defines 3D vector operations
 * @author Henry Valentine
 * Based on thebennybox 3D game Engine tutorial
 * 
 */
public class Vector3f {

	////* Instance Variables *////
	private float x, y, z;		//x, y, z components of this vector

	////* Constructor *////
	/**
	 * Creates a new 3D vector
	 * @param x : x component of this vector
	 * @param y : y component of this vector
	 * @param z : z component of this vector
	 */
	public Vector3f(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}//end constructor
	
	////* Methods *////
	/**
	 * Returns the dot product of this vector 
	 * and the given vector
	 * @param r : vector to multiply by
	 * @return dot product of this vector and the given vector
	 */
	public float dot(Vector3f r) {
		return x * r.getX() + y * r.getY() + z * r.getZ();
	}//end dot
	
	/**
	 * Returns the cross product of this
	 * vector and the given vector
	 * @param r : Vector to multiply by
	 * @return cross product of this vector and given vector
	 */
	public Vector3f cross(Vector3f r) {
		float x_ = y * r.getZ() - z * r.getY();
		float y_ = z * r.getX() - x * r.getZ();
		float z_ = x * r.getY() - y * r.getX();
		
		return new Vector3f(x_, y_, z_);
	}//end cross
	
	/**
	 *  Rotates this vector about the given axis
	 *  by the given amount using quaternion 
	 *  rotations.
	 *  @param angle : angle of rotation 
	 *  @param axis  : 3D vector representing rotation axis
	 *  @return this vector after applying the rotation
	 */
	public Vector3f rotate(float angle, Vector3f axis) {
		
		float sinHalfAngle = (float) Math.sin(Math.toRadians(angle / 2));
		float cosHalfAngle = (float) Math.cos(Math.toRadians(angle / 2));
		
		// Quaternion Components //
		float rx = axis.getX() * sinHalfAngle;
		float ry = axis.getY() * sinHalfAngle;
		float rz = axis.getZ() * sinHalfAngle;
		float rw = cosHalfAngle;
		
		Quaternion rotation = new Quaternion(rx, ry, rz, rw);
		
		Quaternion conjugate = rotation.conjugate();
		
		// Multiplication to get rotation //
		Quaternion w = rotation.multiply(this).multiply(conjugate);
		//conjugate multiplication returns the vector to its original length after the rotation
		
		//Setting the vector after Quaternion rotation
		x = w.getX();
		y = w.getY();
		z = w.getZ();
		
		return this;
	}//end rotate
	
	/**
	 * Normalize this vector.
	 * Set length to 1
	 * @return this vector, normalized
	 */
	public Vector3f normalize() {
		
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		
		return this;
	}//end normalize
	
	/**
	 * Calculates the length of this vector
	 * @return length of this vector
	 */
	public float length() {
		return (float)Math.sqrt(x * x + y * y + z * z);
	}//end length
	
	/**
	 * Converts this vector into
	 * a 4x4 matrix representing a direction
	 * @return Matrix representation of this direction vector
	 */
	public Matrix4f toDirectionMatrix() {
		Matrix4f matrix = new Matrix4f();
		float [][] m = {{x, 0, 0, 0},	//x
						{0, y, 0, 0},	//y
						{0, 0, z, 0},	//z
						{0, 0, 0, 0}};	//w
		matrix.setM(m);
		return matrix;
	}//end toDirectionMatrix
	
	/**
	 * Converts this vector into a 4x4
	 * matrix representing a point in
	 * space
	 * @return Matrix representation of this position vector
	 */
	public Matrix4f toPositionMatrix() {
		Matrix4f matrix = new Matrix4f();
		float [][] m = {{x, 0, 0, 0},	//x
						{0, y, 0, 0},	//y
						{0, 0, z, 0},	//z
						{0, 0, 0, 1}};	//w
		matrix.setM(m);
		return matrix;
	}//end toPositionMatrix
	
	//* Math Functions *//
	/**
	 * Add this vector to the given vector
	 * @param r : vector to add
	 * @return new vector representing the sum of these vectors
	 */
	public Vector3f add(Vector3f r) {
		return new Vector3f(x + r.getX(), y + r.getY(), z + r.getZ());
	}//end add
	
	/**
	 * Add a scalar to each component
	 * of this vector
	 * @param r : scalar to be added
	 * @return new vector after addition
	 */
	public Vector3f add(float r){
		return new Vector3f(x + r, y + r, z + r);
	}//end add
	
	/**
	 * Subtract the components of the given
	 * vector from this vector
	 * @param r : vector to be subtracted
	 * @return new vector after subtraction
	 */
	public Vector3f subtract(Vector3f r) {
		return new Vector3f(x - r.getX(), y - r.getY(), z - r.getZ());
	}//end subtract
	
	/**
	 * Subtract a scalar from the components
	 * of this vector
	 * @param r : scalar to be subtracted
	 * @return new vector after subtraction
	 */
	public Vector3f subtract(float r){
		return new Vector3f(x - r, y - r, z - r);
	}//end class
	
	/**
	 * Multiply the components of this vector by
	 * this of the given vector
	 * @param r : vector to be multiplied by
	 * @return new vector after multiplication
	 */
	public Vector3f multiply(Vector3f r) {
		return new Vector3f(x * r.getX(), y * r.getY(), z * r.getZ());
	}//end multiply
	
	/**
	 * Multiply components of this vector
	 * by a scalar value
	 * @param r : scalar value to multiply by
	 * @return new vector after multiplication
	 */
	public Vector3f multiply(float r){
		return new Vector3f(x * r, y * r, z * r);
	}//end multiply
	
	//* Getters and Setters *//
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
}//end class
