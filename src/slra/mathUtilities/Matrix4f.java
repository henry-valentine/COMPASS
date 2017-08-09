package slra.mathUtilities;

/**
 * Matrix4f Class
 * Represents a 4X4 matrix
 * and defines matrix operation methods
 * 
 * @author Henry Valentine
 * based on thebennybox 3D Game Engine Tutorial
 */
public class Matrix4f {
	
	////* Instance Variables *////
	private float [][] m;	//2D float array representing the 4X4 Matrix
	
	////* Constructor *////
	public Matrix4f() {
		m = new float[4][4];
	}//end Constructor
	
	/**
	 * Creates an Identity Matrix
	 * @return the identity matrix
	 */
	public Matrix4f initIdentity() {
		m[0][0] = 1; m[0][1] = 0; m[0][2] = 0; m[0][3] = 0;
		m[1][0] = 0; m[1][1] = 1; m[1][2] = 0; m[1][3] = 0;
		m[2][0] = 0; m[2][1] = 0; m[2][2] = 1; m[2][3] = 0;
		m[3][0] = 0; m[3][1] = 0; m[3][2] = 0; m[3][3] = 1;
		
		return this;
	}//end initIdentity
	
	/**
	 * Creates a translation matrix based on the given
	 * translation vector values
	 * @param x	: x translation
	 * @param y	: y translation
	 * @param z	: z translation
	 * @return this translation matrix
	 */
	public Matrix4f initTranslation(float x, float y, float z) {
		m[0][0] = 1; m[0][1] = 0; m[0][2] = 0; m[0][3] = x;
		m[1][0] = 0; m[1][1] = 1; m[1][2] = 0; m[1][3] = y;
		m[2][0] = 0; m[2][1] = 0; m[2][2] = 1; m[2][3] = z;
		m[3][0] = 0; m[3][1] = 0; m[3][2] = 0; m[3][3] = 1;
														   
		return this;
	}//end initTranslation
	
	/**
	 * Initializes a rotation matrix based
	 * on the altered up and forward vectors
	 * of the translation 
	 * 	
	 * @param up		: Up Direction
	 * @param forward	: Forward Direction
	 * @return rotation matrix
	 */
	public Matrix4f initRotation(Vector3f forward, Vector3f up) {
		
		Vector3f f = forward.normalize();
		Vector3f u = up.normalize();
		Vector3f r = f.cross(u).normalize();
		
		//f u and r represent the three axes of the camera.
		//moves the whole scene to align with what the camera should see
		
		m[0][0] = r.getX(); m[0][1] = r.getY(); m[0][2] = r.getZ(); m[0][3] = 0;//x
		m[1][0] = u.getX();	m[1][1] = u.getY();	m[1][2] = u.getZ();	m[1][3] = 0;//y
		m[2][0] = f.getX();	m[2][1] = f.getY();	m[2][2] = f.getZ();	m[2][3] = 0;//z
		m[3][0] = 0; 		m[3][1] = 0; 		m[3][2] = 0; 		m[3][3] = 1;
		
		return this;
	}//end initRotation
	
	/**
	 * Creates a new Scale Matrix
	 * @param x	: x Scale Factor
	 * @param y	: y Scale Factor
	 * @param z	: z Scale Factor
	 * @return Scale Matrix
	 */
	public Matrix4f initScale(float x, float y, float z) {
		m[0][0] = x; m[0][1] = 0; m[0][2] = 0; m[0][3] = 0; //original x times passed in x
		m[1][0] = 0; m[1][1] = y; m[1][2] = 0; m[1][3] = 0;
		m[2][0] = 0; m[2][1] = 0; m[2][2] = z; m[2][3] = 0;
		m[3][0] = 0; m[3][1] = 0; m[3][2] = 0; m[3][3] = 1;
		
		return this;
	}//end initScale
	
	/**
	 * Initialize the projection matrix
	 * @param fov 	: Field of View
	 * @param zNear : Near clipping value	
	 * @param zFar	: Far clipping value
	 * @param WIDTH	: Window WIDTH
	 * @param HEIGHT: Widow Height
	 * @return projection matrix
	 */
	public Matrix4f initProjection(float fov, float zNear, float zFar, float WIDTH, float HEIGHT) {
		
		float ar = WIDTH / HEIGHT;//aspect ratio
		float tanHalfFOV = (float)Math.tan(Math.toRadians(fov / 2));//Essentially the distance between edge and middle of screen
		float zRange = zNear - zFar;//Depth
		
		
		m[0][0] = 1.0f / (tanHalfFOV * ar); 	m[0][1] = 0;					m[0][2] = 0; 							m[0][3] = 0;
		m[1][0] = 0; 							m[1][1] = 1.0f / tanHalfFOV; 	m[1][2] = 0; 							m[1][3] = 0;
		m[2][0] = 0; 							m[2][1] = 0; 					m[2][2] = (-zNear - zFar) / zRange; 	m[2][3] = 2 * zFar * zNear / zRange;//
		m[3][0] = 0; 							m[3][1] = 0; 					m[3][2] = 1; 							m[3][3] = 0;//w is set to z value so that z is preserved for later
																											//since we kind of get rid of it to map it to the 1X1X1 cube
		return this;
	}//end initProjection
	
	/**
	 * Multiplies this matrix by the given matrix
	 * @param r : Matrix to be multiplied by
	 * @return  : The product of these Matrices
	 */
	public Matrix4f multiply(Matrix4f r) {
		Matrix4f res = new Matrix4f();
		
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {
				res.set(row, col, m[row][0] * r.get(0, col) +
								m[row][1] * r.get(1, col) +
								m[row][2] * r.get(2, col) +
								m[row][3] * r.get(3, col));
			}
		}
		
		return res;
	}//end multiply
	
	////* Getters and Setters *////
	public float[][] getM() {
		return m;
	}
	
	public float get(int row, int col) {
		return m[row][col];
	}
	
	public void set(int row, int col, float value) {
		m[row][col] = value;
	}
	
	public void setM(float [][] m) {
		this.m = m;
	}
}//end class