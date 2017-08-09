package slra.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import slra.mathUtilities.Quaternion;
import slra.mathUtilities.Vector3f;
import slra.simObjects.utilities.Material;
import slra.simObjects.utilities.Mesh;
import slra.simObjects.utilities.SimObject;
import slra.simObjects.utilities.Texture;
import slra.simObjects.utilities.Vertex;
import slra.simulation.Transform;

/**
 * Contains ResourceLoading Utilities
 * @author Henry Valentine
 * based on thebennybox 3D Game Engine tutorials
 */
public class ResourceLoader {
	
	/**
	 * This method returns a String array
	 * representing the files in a given
	 * directory
	 * @param directory : Directory to get files from. (Directory is created if it doesn't exist)
	 * @return String array listing files
	 */
	public static String [] loadPaths(String directory) {
		
		ArrayList<String> paths = new ArrayList<String>();
		
		// File To Represent The Directory //
		File folder = new File(directory);
		// List Files In Directory //
		File [] files = folder.listFiles();
		
		// Get Paths //
		if(files != null) {
			for(File file : files) {
				// Check To Make Sure It's a File //
				if(file.isFile()) {
					paths.add(file.getPath());
				}
			}
		}
		
		// Convert Array List to Array //
		String [] pathArray = new String [paths.size()];
		
		paths.toArray(pathArray);
	
		return pathArray;
	}//end loadPaths
	
	/**
	 * Loads a Texture
	 * @param fileName : filName of the texture (File loaded from the texture folder)
	 * @return the texture id
	 */
	public static Texture loadTexture(String fileName) {
		
		//String [] splitArray = fileName.split("\\.");//used to get the file extension
		//String ext = splitArray[splitArray.length - 1];
		
		try{
			int id = TextureLoader.loadTexture("res/textures/" + fileName).getID();
			return new Texture(id);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}//end loadTexture
	
	/**
	 * Loads text from a text file and
	 * converts it into a string
	 * @param path of text file
	 * @return a string of all the file text
	 */
	public static String loadText(String path) {
		
		StringBuilder buider = new StringBuilder();
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new FileReader(path));
			
			String line;
			while((line = reader.readLine()) != null) {
				buider.append(line).append("\n");
			}
			reader.close();
		}
		catch(Exception e){
			System.err.println("ERROR: COULD NOT LOAD FILE FROM: " + path);
			return null;
		}
		
		return buider.toString();//converts the entire file to a string
	}//end loadText
	
	/**
	 * Loads a mesh from a .obj file
	 * @param fileName : .obj file containing the mesh
	 * @return a new mesh from this file
	 */
	public static Mesh loadMesh(String fileName) {
		
		String [] splitArray = fileName.split("\\.");//used to get the file extension
		String ext = splitArray[splitArray.length - 1];
		
		if(!ext.equals("obj") && !ext.equals("stl")) {
			System.err.println("ERROR: FILE TYPE NOT SUPPORTED FOR MESH DATA: " + ext);
			new Exception().printStackTrace();
		}
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		BufferedReader meshReader = null;
		
		// Reads in text from obj file and assigns values to the vertices and indices of the mesh //
		try{
			meshReader = new BufferedReader(new FileReader("res/models/" + fileName));
			String line;
			
			while((line = meshReader.readLine()) != null) {
				
				String [] tokens = Util.formatLine(line);
				
				if(ext.equals("obj")) {
					readLineOBJ(tokens, vertices, indices);
				}
				
				else {//STL FILES. CHANGE TO else-if IF MORE FILE TYPES ADDED
					readLineSTL(tokens, vertices, indices);
				}
				
			}//end while
			meshReader.close();
			
			Mesh mesh = new Mesh();
			
			Vertex [] vertexData = new Vertex [vertices.size()];
			vertices.toArray(vertexData);//convert ArrayList to array
			
			mesh.addVertices(vertexData, Util.toIntArray(indices), true);
			
			return mesh;
			
		} catch(Exception e) {
			System.err.println("ERROR: FAILED TO LOAD OBJECT MESH: " + fileName);
			e.printStackTrace();
		}
		return null;
	}//end loadMesh
	
	/**
	 * Loads a satellite model from a .SATT file
	 * and produces a list of SimObjects representing
	 * this satellite.
	 * @param fileName - .SATT file containing satellite
	 * @return ArrayList of SimObjects comprising this model
	 */
	public static ArrayList<SimObject> loadSat(String fileName) {
		// Get File Extension //
		String ext = fileName.split("\\.")[fileName.split("\\.").length - 1];
		
		// Check For SATT File //
		if(!ext.equalsIgnoreCase("satt")) {
			System.err.println("ERROR: CANNOT LOAD MODEL FROM FILE TYPE (" + ext + "). MUST USE SATT FORMAT!");
			new Exception().printStackTrace();
			return null;
		}
		else {		
		BufferedReader satReader = null;
		ArrayList<SimObject> objects = new ArrayList<SimObject>();
		
		//// Load Satellite Data From File ////
		try {
			satReader = new BufferedReader(new FileReader("res/models/" + fileName));
			String line;
			int lineNumb = 0;
			
			//// READ FILE ////
			while((line = satReader.readLine()) != null) {
				lineNumb++;
				String [] tokens = Util.formatLine(line);	//Format Line Elements
				if(!Util.hasData(tokens)){continue;}		//Comment or Empty Line
				
				//// OBJECTS ////
				else if(tokens[0].equalsIgnoreCase("object")){	//Get The Name of the Satellite later? SATT file id
					//// OBJECT ATTRIBUTES ////
					ArrayList<SimObject> parts = new ArrayList<SimObject>();	//Parts Making Up This Object	
					Transform objectTrans = new Transform();	  				//Transformation to be applied to Parent Part
					String objectID = "DEFAULT";
					
					//// READ OBJECTS ////
					while((line = satReader.readLine()) != null) {
						lineNumb++;
						tokens = Util.formatLine(line);			//Format Line Elements
						if(!Util.hasData(tokens)){continue;}	//Comment or Empty Line
						
						//// OBJECT ID ////
						else if(tokens[0].equalsIgnoreCase("id")) {
							objectID = tokens[1];
						}
						//// OBJECT TRANSFORM ////
						else if(tokens[0].equalsIgnoreCase("transform")) {
							//// READ TRANSFORM ////
							while((line = satReader.readLine()) != null) {
								lineNumb++;
								tokens = Util.formatLine(line);			//Format Line Elements
								if(!Util.hasData(tokens)){continue;}	//Comment or Empty Line
								
								// TRANSFORM TRANSLATION //
								else if(tokens[0].equalsIgnoreCase("translation")) {
									float x = Float.parseFloat(tokens[1]);
									float y = Float.parseFloat(tokens[2]);
									float z = Float.parseFloat(tokens[3]);
									objectTrans.setTranslation(x, y, z);
								}
								// TRNASFORM ROTATION //
								else if(tokens[0].equalsIgnoreCase("rotation")) {
									float rx = Float.parseFloat(tokens[1]);
									float ry = Float.parseFloat(tokens[2]);
									float rz = Float.parseFloat(tokens[3]);
									float rw = Float.parseFloat(tokens[4]);
									objectTrans.setRotation(new Quaternion().initRotation(new Vector3f(rx, ry, rz), rw));
								}
								// TRANSFORM SCALE //
								else if(tokens[0].equalsIgnoreCase("scale")) {
									objectTrans.setScale(Float.parseFloat(tokens[1]));
								}
								// BREAK //
								else if(tokens[0].equalsIgnoreCase("}")) {
									break;
								}
								// ERROR //
								else {
									System.err.println("ERROR: SYNTAX ERROR LINE " + lineNumb + " IN FILE " + fileName);
									satReader.close();
									throw new Exception();
								}
							}//end read transform
						}//end transform
						
						//// OBJECT PARTS ////
						else if(tokens[0].equalsIgnoreCase("part")) {
							// PART ATTRIBUTES //
							SimObject part;							//Part 
							String partID = "DEFAULT";				//Part ID
							Material partMat = new Material();		//Part Material
							Transform partTrans = new Transform();	//Part Transformation
							Mesh partMesh = new Mesh();				//Part Mesh
								ArrayList<Vector3f> normals = new ArrayList<Vector3f>();	//Mesh Vertex Normals
								Vertex [] vertexData = null;								//Mesh Vertices
								int [] indexData = null;									//Mesh Indices
							
							// READ PARTS //
							while((line = satReader.readLine()) != null) {
								lineNumb++;
								tokens = Util.formatLine(line);			//Format Line Elements
								if(!Util.hasData(tokens)){continue;}	//Comment or Empty Line
								
								// PART ID //
								else if(tokens[0].equalsIgnoreCase("id")) {
									partID = tokens[1];
								}
								
								// PART TRANSFORM //
								else if(tokens[0].equalsIgnoreCase("transform")) {
									// READ TRANSFORM //
									while((line = satReader.readLine()) != null) {
										lineNumb++;
										tokens = Util.formatLine(line);			//Format Line Elements
										if(!Util.hasData(tokens)){continue;}	//Comment or Empty Line
										
										// TRANSFORM TRANSLATION //
										else if(tokens[0].equalsIgnoreCase("translation")) {
											float x = Float.parseFloat(tokens[1]);
											float y = Float.parseFloat(tokens[2]);
											float z = Float.parseFloat(tokens[3]);
											partTrans.setTranslation(x, y, z);
										}
										// TRNASFORM ROTATION //
										else if(tokens[0].equalsIgnoreCase("rotation")) {
											float rx = Float.parseFloat(tokens[1]);
											float ry = Float.parseFloat(tokens[2]);
											float rz = Float.parseFloat(tokens[3]);
											float rw = Float.parseFloat(tokens[4]);
											objectTrans.setRotation(new Quaternion().initRotation(new Vector3f(rx, ry, rz), rw));
										}
										// TRANSFORM SCALE //
										else if(tokens[0].equalsIgnoreCase("scale")) {
											partTrans.setScale(Float.parseFloat(tokens[1]));
										}
										// BREAK //
										else if(tokens[0].equalsIgnoreCase("}")) {
											break;
										}
										// ERROR //
										else {
											System.err.println("ERROR: SYNTAX ERROR LINE " + lineNumb + " IN FILE " + fileName);
											satReader.close();
											throw new Exception();
										}
									}//end read transform
								}//end transform
								
								// PART MATERIAL //
								else if(tokens[0].equalsIgnoreCase("material")) {
									// READ MATERIAL //
									while((line = satReader.readLine()) != null) {
										lineNumb++;
										tokens = Util.formatLine(line);			//Format Line Elements
										if(!Util.hasData(tokens)){continue;}	//Comment or Empty Line
										// MATERIAL ID //
										else if(tokens[0].equalsIgnoreCase("id")) {
											partMat.setID(tokens[1]);
										}
										// MATERIAL COLOR //
										else if(tokens[0].equalsIgnoreCase("color")) {
											float r = Float.parseFloat(tokens[1]);
											float g = Float.parseFloat(tokens[2]);
											float b = Float.parseFloat(tokens[3]);
											partMat.setColor(new Vector3f(r,g,b));
										}
										// MATERIAL INTENSITY //
										else if(tokens[0].equalsIgnoreCase("specInt")) {
											partMat.setSpecularIntensity(Float.parseFloat(tokens[1]));
										}
										// MATERIAL POWER //
										else if(tokens[0].equalsIgnoreCase("specPow")) {
											partMat.setSpecularPower(Float.parseFloat(tokens[1]));
										}
										// BREAK //
										else if(tokens[0].equalsIgnoreCase("}")) {
											break;
										}
										// ERROR //
										else {
											System.err.println("ERROR: SYNTAX ERROR LINE " + lineNumb + " IN FILE " + fileName);
											satReader.close();
											throw new Exception();
										}
									}//end read material
								}//end material
								
								// PART VERTICES //
								else if(tokens[0].equalsIgnoreCase("vertices")) {
									ArrayList<Vertex> vertices = new ArrayList<Vertex>();
									// READ VERTICES //
									while((line = satReader.readLine()) != null) {
										lineNumb++;
										tokens = Util.formatLine(line);			//Format Line Elements
										if(!Util.hasData(tokens)){continue;}	//Comment or Empty Line
										// VERTICES //
										else if(tokens[0].equalsIgnoreCase("v")) {
											float x = Float.parseFloat(tokens[1]);
											float y = Float.parseFloat(tokens[2]);
											float z = Float.parseFloat(tokens[3]);
											vertices.add(new Vertex(new Vector3f(x, y, z)));
										}
										// BREAK //
										else if(tokens[0].equalsIgnoreCase("}")) {
											vertexData = new Vertex [vertices.size()];
											vertices.toArray(vertexData);
											break;
										}
										// ERROR //
										else {
											System.err.println("ERROR: SYNTAX ERROR LINE " + lineNumb + " IN FILE " + fileName);
											satReader.close();
											throw new Exception();
										}
									}//end read vertices
								}//end vertices
								
								// PART INDICES //
								else if(tokens[0].equalsIgnoreCase("indices")) {
									ArrayList<Integer> indices = new ArrayList<Integer>();
									// READ INDICES //
									while((line = satReader.readLine()) != null) {
										lineNumb++;
										tokens = Util.formatLine(line);			//Format Line Elements
										if(!Util.hasData(tokens)){continue;}	//Comment or Empty Line
										// INDICES //
										else if(tokens[0].equalsIgnoreCase("i")) {
											indices.add(Integer.parseInt(tokens[1]));
											indices.add(Integer.parseInt(tokens[2]));
											indices.add(Integer.parseInt(tokens[3]));
										}
										// BREAK //
										else if(tokens[0].equalsIgnoreCase("}")) {
											indexData = Util.toIntArray(indices);
											break;
										}
										// ERROR //
										else {
											System.err.println("ERROR: SYNTAX ERROR LINE " + lineNumb + " IN FILE " + fileName);
											satReader.close();
											throw new Exception();
										}
									}//end read indices
								}//end indices
								
								// PART NORMALS //
								else if(tokens[0].equalsIgnoreCase("normals")) {
									// READ NORMALS //
									while((line = satReader.readLine()) != null) {
										lineNumb++;
										tokens = Util.formatLine(line);			//Format Line Elements
										if(!Util.hasData(tokens)){continue;}	//Comment or Empty Line
										// NORMALS //
										else if(tokens[0].equalsIgnoreCase("n")) {
											float x = Float.parseFloat(tokens[1]);
											float y = Float.parseFloat(tokens[2]);
											float z = Float.parseFloat(tokens[3]);
											normals.add(new Vector3f(x,y,z));
										}
										// BREAK //
										else if(tokens[0].equalsIgnoreCase("}")) {
											break;
										}
										// ERROR //
										else {
											System.err.println("ERROR: SYNTAX ERROR LINE " + lineNumb + " IN FILE " + fileName);
											satReader.close();
											throw new Exception();
										}
									}//end read normals
								}//end normals
								
								// BREAK //
								else if(tokens[0].equalsIgnoreCase("}")) {
									//Set Normals If Available //
									boolean calcNormals = true;
									if(normals.size() == vertexData.length) {
										for(int i = 0; i < vertexData.length; i++) {
											vertexData[i].setNormal(normals.get(i));
										}
										calcNormals = false;
									}
									// Create Part //
									partMesh.addVertices(vertexData, indexData, calcNormals);
									part = new SimObject(partMesh, partTrans, partMat, partID);
									
									// Add Part to Parts List //
									parts.add(part);
									break;
								}
								// ERROR //
								else {
									System.err.println("ERROR: SYNTAX ERROR LINE " + lineNumb + " IN FILE " + fileName);
									satReader.close();
									throw new Exception();
								}
							}//end read part
						}//end part
						// BREAK //
						else if(tokens[0].equalsIgnoreCase("}")) {
							// Create Object //
							SimObject object = new SimObject(objectID);
							object.setTransform(objectTrans);
							// Add Children //
							for(SimObject part : parts) {
								object.addChild(part);
							}
							// Add Object to List //
							objects.add(object);
							break;
						}
						// ERROR //
						else {
							System.err.println("ERROR: SYNTAX ERROR LINE " + lineNumb + " IN FILE " + fileName);
							satReader.close();
							throw new Exception();
						}
					}//end read object	
				}//end object
				else if(tokens[0].equalsIgnoreCase("}")) {
					break;
				}//break file
			}//end file
			satReader.close();
		}
		catch(Exception e) {
			System.err.println("ERROR: FAILED TO LOAD MODEL (" + fileName + ")");
			e.printStackTrace();
		}
		return objects;
		}
	}//end loadSat
	
	/**
	 * Reads a Single OBJ file Line
	 * and adds vertices and indices 
	 * to the ArrayLists passed in
	 * @param line: 	The Line to be read
	 * @param Verties: 	List of vertices to be added to
	 * @param Indices:	Indices for this object
	 */
	public static void readLineOBJ(String [] tokens, ArrayList<Vertex> vertices, ArrayList<Integer>indices) {
		//Comment or empty line
		if(tokens.length == 0 || tokens[0].equals("#") || tokens[0].equals("")){
			return;
		}
		//Vertex Definition
		else if(tokens[0].equals("v")) {
			
			vertices.add(new Vertex(new Vector3f(Float.parseFloat(tokens[1]), 
												 Float.parseFloat(tokens[2]), 
												 Float.parseFloat(tokens[3]))));
		}
		//Face Definition
		else if(tokens[0].equals("f")){
			indices.add(Integer.parseInt(tokens[1]) - 1);// - 1 b/c obj files start at 1 while meshes start at 0	
			indices.add(Integer.parseInt(tokens[2]) - 1);
			indices.add(Integer.parseInt(tokens[3]) - 1);
		}
	}//end ReadLineOBJ
	
	/**
	 * Reads a Single STL file Line
	 * and adds vertices and indices 
	 * to the ArrayLists passed in
	 * @param line: 	The Line to be read
	 * @param Verties: 	List of vertices to be added to
	 * @param Indices:	Indices for this object
	 */
	public static void readLineSTL(String [] tokens, ArrayList<Vertex> vertices, ArrayList<Integer>indices) {//TEST
		
		//Comment or empty line
		if(tokens.length == 0 || tokens[0].equals("#") || tokens[0].equals("")){
			return;
		}
		
		//Vertex/Face Definition
		else if(tokens[0].equals("vertex")) {
			Vertex vertex = new Vertex(new Vector3f(Float.parseFloat(tokens[1]), 
										   			Float.parseFloat(tokens[2]), 
										   			Float.parseFloat(tokens[3])));
			//If the vertex already exists, add an index reference
			if(vertices.contains(vertex)) {
				indices.add(vertices.indexOf(vertex));
			}
			//If the vertex does not exist, add it to vertices and add an index reference
			else {
				vertices.add(vertex);
				indices.add(vertices.size() - 1);
			}
		}
	}//end readLineSTL
}//end class