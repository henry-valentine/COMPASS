package slra.mathUtilities;

/**
 * Point2f class - Creates an object representing a point on
 * a two-dimensional Cartesian
 * 
 * @author Henry Valentine
 * @version 11/21/2016
 *
 */
public class Point2f {

	private float x, y;
	
	/*
	 * Constructor - Initialize x and y values
	 */
	public Point2f(float x, float y) {
		this.x = x;
		this.y = y;
	}//end Point2f
	
	/**
	 * Calculates and returns the distance between two points.
	 * 
	 * @param p2 - Point2f Object
	 * @return - The distance between this point and the point passed in
	 */
	public float distance(Point2f p2) {
		return (float)Math.sqrt(Math.pow(x - p2.getX(), 2) + Math.pow(y - p2.getY(), 2));
	}//end distance
	
	/*
	 * Getters and Setters
	 */
	public void setY(float y){
		this.y = y;
	}
	public void setX(float x){
		this.x = x;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
}//end class
