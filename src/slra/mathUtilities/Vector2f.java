package slra.mathUtilities;
/**
 * This class represents a
 * 2D vector object and defines
 * 2D vector operations.
 * @author Henry Valentine
 * Based on thebennybox 3D game Engine tutorial
 */
public class Vector2f {
	
	////* Instance Variables *////
	private float x, y;		//x and y components of the vector
	
	////* Constructor *////
	/**
	 * Creates a new 2D vector
	 * @param x : x component
	 * @param y : y component
	 */
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}//end constructor
	
	/**
	 * Returns the length of this vector
	 * @return length : float
	 */
	public float length() {
		return (float)Math.sqrt(x * x + y * y); 
	}//end length
	
	/**
	 * Returns the dot product of this 2D vector
	 * multiplied by the given 2D vector 
	 * @param r : Vector to be multiplied by
	 * @return the dot product of these two vectors
	 */
	public float dot(Vector2f r) {
		return x * r.getX() + y * r.getY();
	}//end dot
	
	/**
	 * Normalize the current vector
	 * @return This vector after normalization
	 */
	public Vector2f normalize(){
		float length = length();
		
		x /= length;
		y /= length;
		
		return this;
	}//end normalize
	
	/**
	 * Rotates this 2D vector by the 
	 * given angle
	 * @param angle in degrees
	 * @return new vector with applied rotation
	 */
	public Vector2f rotate(float angle){
		
		double rad = Math.toRadians(angle);
		double cos = Math.cos(rad);
		double sin = Math.sin(rad);
		
		//based on imaginary number rotation
		return new Vector2f((float)(x * cos - y * sin), (float)(x * sin - y * cos));
	}//end rotation
	
	/**
	 * 2D Vector addition
	 * @param r : Vector to be added
	 * @return sum of these vectors
	 */
	public Vector2f add(Vector2f r){
		return new Vector2f(x + r.getX(), y + r.getY());
	}//end add
	
	/**
	 * Addition of vector and scalar
	 * @param r : float number to be added
	 * @return sum of vector and scalar number
	 */
	public Vector2f add(float r){
		return new Vector2f(x + r, y + r);
	}//end add
	
	/**
	 * Subtract the given vector from this vector
	 * @param r : Vector to be subtracted
	 * @return difference of these vectors
	 */
	public Vector2f subtract(Vector2f r){
		return new Vector2f(x - r.getX(), y - r.getY());
	}//end subtract
	
	/**
	 * Difference of this vector 
	 * and the given scalar
	 * @param r : the value to be subtracted 
	 * @return difference o fthis vector and the scalar
	 */
	public Vector2f subtract(float r){
		return new Vector2f(x - r, y - r);
	}//end subtract
	
	/**
	 * Multiply the components of these two vectors
	 * @param r : vector to be multiplied
	 * @return product of these vectors
	 */
	public Vector2f multiply(Vector2f r){
		return new Vector2f(x * r.getX(), y * r.getY());
	}//end multiply
	
	/**
	 * Scalar multiplication of this vector
	 * @param r : number to multiply by
	 * @return product of this vector and the scalar
	 */
	public Vector2f multiply(float r){
		return new Vector2f(x * r, y * r);
	}//end multiply
	
	/**
	 * Returns a string representation of
	 * this vector.
	 */
	public String toString() {
		return "(" + x +  ", " + y + ")";
	}//end toString
	
	////* Getters and Setters *////
	public float getX() {
		return x;
	}	
	public float getY() {
		return y;
	}
	public void setX(float x) {
		this.x = x;
	}
	public void stY(float y) {
		this.y = y;
	}
}//end class