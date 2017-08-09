package slra.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import slra.gui.GUI;
import slra.mathUtilities.Quaternion;
import slra.mathUtilities.Vector3f;
import slra.simObjects.utilities.Vertex;

/**
 * This class is used to convert files to
 * SATT format and save them in the program's
 * resource folder.
 * 
 * Supported File Types: obj, stl, amf
 * 
 * @author Henry Valentine
 */
public class FileConverter {
	/**
	 * Checks whether or not the file type is supported
	 * and calls the converter method specific to that type
	 * @param fileName : name of file to be converted
	 */
	public static void convertFile(Path path) {
		String [] splitArray = path.getFileName().toString().split("\\.");	//used to get the file extension
		String ext = splitArray[splitArray.length - 1];
		String name = path.getFileName().toString();
		
		//Check to make sure file type is supported
		if(ext.equalsIgnoreCase("obj") || ext.equalsIgnoreCase("stl") || ext.equalsIgnoreCase("amf")) {
		
			System.out.println("Converting File: " + name);
		
			//Convert Specific File Types
			if(ext.equalsIgnoreCase("obj")) {
				convertOBJ(path);
			}
			else if(ext.equalsIgnoreCase("stl")) {
				convertSTL(path);
			}
			else if(ext.equals("amf")){
				convertAMF(path);
			}
		}
		else {
			System.err.println("ERROR: FILE TYPE NOT SUPPORTED FOR MESH DATA (" + ext + ") COULD NOT CONVERT " + name + ext);
		}

	}//end convertFile
	
	/**
	 * Writes a SATT file and saves it
	 * to the program's resource folder.
	 * @param fileName : name of the file
	 * @param objects  : List of objects which make up the satellite
	 */
	private static void writeSATT(String name, ArrayList<SATTObject> objects) {
		try {
			boolean newFile = true;
			//Create File
			name = name.substring(0, name.indexOf("."));
			File file = new File("res/models/" + name + ".SATT");
			
			//Check If File Exists Already (For Information Purposes Only)
			if(file.exists()) {
				newFile = false;
			}
			//Create Writer
			FileWriter fw = new FileWriter(file);
			BufferedWriter fileWriter = new BufferedWriter(fw);
			
			//File Header
			fileWriter.write("# SATELLITE LIGHT REFLECTION ANALYZER V" + GUI.VERSION + "\n"
						   + "# SATTELITE MODELLING FORMAT\n"
						   + "# TITLE: " + name.toUpperCase() + ".SATT\n"
						   + "# DATE CREATED: " + new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + "\n\n");
			
			//MAIN BODY
			fileWriter.write("satt {\n"
						   + "    " + "id " + name + "\n");
			
				//OBJECTS
				for(SATTObject object : objects) {
					//Translation Variables
					float x = object.transform.translation.getX();
					float y = object.transform.translation.getY();
					float z = object.transform.translation.getZ();
					float rx = object.transform.rotation.getX();
					float ry = object.transform.rotation.getY();
					float rz = object.transform.rotation.getZ();
					float rw = object.transform.rotation.getW();
					float scale = object.transform.scale;
				
					fileWriter.write("    " + "object {\n"
									+ "    " + "    " + "id " + object.id + "\n"
									+ "    " + "    " + "transform {\n"
									+ "    " + "    " + "    " + "translation " + x + " " + y + " " + z + "\n"
									+ "    " + "    " + "    " + "rotation " + rx + " " + ry + " " + rz + " " + rw + "\n"
									+ "    " + "    " + "    " + "scale " + scale + " " + "\n"
									+ "    " + "    " + "}\n");	//end transform
							
						//OBJECT PARTS
						for(Part part : object.parts) {
							//Translation Variables
							x = part.transform.translation.getX();
							y = part.transform.translation.getY();
							z = part.transform.translation.getZ();
							rx = part.transform.rotation.getX();
							ry = part.transform.rotation.getY();
							rz = part.transform.rotation.getZ();
							rw = part.transform.rotation.getW();
							scale = part.transform.scale;
							
							//Material Variables
							String matID = part.material.id;
							float r = part.material.color.getX();
							float g = part.material.color.getY();
							float b = part.material.color.getZ();
							float specI = part.material.specI;
							float specP = part.material.specP;
							
							
							fileWriter.write("    " + "    " + "part {\n"
										   + "    " + "    " + "    " + "id " + part.id + "\n"
										   + "    " + "    " + "    " + "transform {\n"
										   + "    " + "    " + "    " + "    " + "translation " + x + " " + y + " " + z + "\n"
										   + "    " + "    " + "    " + "    " + "rotation " + rx + " " + ry + " " + rz + " " + rw + "\n"
										   + "    " + "    " + "    " + "    " + "scale " + scale + " " + "\n"
										   + "    " + "    " + "    " + "}\n"
										   + "    " + "    " + "    " + "material {\n"
										   + "    " + "    " + "    " + "    " + "id " + matID + "\n"
										   + "    " + "    " + "    " + "    " + "color " + r + " " + g + " " + b + "\n"
										   + "    " + "    " + "    " + "    " + "specInt " + specI + "\n"
										   + "    " + "    " + "    " + "    " + "specPow " + specP + "\n"
										   + "    " + "    " + "    " + "}\n");
								//PART VERTICES
								fileWriter.write("    " + "    " + "    " + "vertices {\n");
								for(Vertex v : part.vertices) {
									float vx = v.getPos().getX(); 
									float vy = v.getPos().getY(); 
									float vz = v.getPos().getZ(); 
									fileWriter.write("    " + "    " + "    " + "    " + "v " + vx + " " + vy + " " + vz + "\n");
								}			   
								fileWriter.write("    " + "    " + "    " + "}\n");//end vertices
								
								//PART INDICES
								fileWriter.write("    " + "    " + "    " + "indices {\n");
								for(int i = 0; i < part.indices.size(); i += 3) {
									int ix = part.indices.get(i);
									int iy = part.indices.get(i + 1);
									int iz = part.indices.get(i + 2);
									fileWriter.write("    " + "    " + "    " + "    " + "i " + ix + " " + iy + " " + iz + "\n");
								}			   
								fileWriter.write("    " + "    " + "    " + "}\n");//end indices
								
								//PART NORMALS
								fileWriter.write("    " + "    " + "    " + "normals {\n");
								if(part.vertices.size() != 0 && part.vertices.get(0).getNormal().length() != 1) {
									fileWriter.write("    " + "    " + "    " + "    " + "# NORMAL DATA NOT AVAILABLE\n");
								}
								else {
									for(Vertex v : part.vertices) {
										float nx = v.getNormal().getX();
										float ny = v.getNormal().getY();
										float nz = v.getNormal().getZ();
										fileWriter.write("    " + "    " + "    " + "    " + "n " + nx + " " + ny + " " + nz + "\n");
									}			 
								}
								fileWriter.write("    " + "    " + "    " + "}\n");//end normals
								
							fileWriter.write("    " + "    " + "}\n");
						}//end part
				
					fileWriter.write("    " + "}\n");
				}//end object
				
			fileWriter.write("}");	//end file		
			
			fileWriter.close();
			
			if(newFile) {
				System.out.println("File Created: " + name + ".SATT");
			}
			else {
				System.out.println("File Updated: " + name + ".SATT");
			}
			
		} catch (IOException e) {
			System.err.println("ERROR: FAILED TO CREATE " + name + ".SATT FILE");
			e.printStackTrace();
		}
	}//end writeSATT
	
	/**
	 * Parse SATTObjects from an AMF file
	 * and send to writeSATT method
	 * @param fileName : name of the file
	 */
	public static void convertAMF(Path path) {
		BufferedReader fileReader = null;
		ArrayList<SATTObject> objects = new ArrayList<SATTObject>();
		ArrayList<Part> parts = new ArrayList<Part>();
		
		String name = path.getFileName().toString();
		int lineNumb = 0;
		
		try{
			fileReader = new BufferedReader(new FileReader(path.toString()));			//Replace this with the variable path later from a file explorer!
			String line;
			//Format and Read Each Line
			while((line = fileReader.readLine()) != null) {
				lineNumb++;
				String [] tokens = Util.formatLine(line);
				if(!Util.hasData(tokens)){continue;}
				// OBJECT //
				else if(tokens[0].equalsIgnoreCase("<object")) {//amf object is a part in the context of this program
					// OBJECT ATTRIBUTES //
					String partID = "DEFAULT";
					PartTrans partTrans = new PartTrans();
					PartMat partMat = new PartMat();
					ArrayList<Vertex> vertices = new ArrayList<Vertex>();
					ArrayList<Integer> indices = new ArrayList<Integer>();
					
					// READ OBJECT //
					while((line = fileReader.readLine()) != null) {
						lineNumb++;
						tokens = Util.formatLine(line);
						if(!Util.hasData(tokens)){continue;}
						// OBJECT ID //
						else if(tokens[0].equalsIgnoreCase("<metadata")) {
							String tok = "";
							for(int i = 1; i < tokens.length; i++) {
								tok += tokens[i];
							}
							partID = tok.substring(tok.indexOf(">") + 1, tok.indexOf("<"));
						}//end id
						// VERTICES //
						else if(tokens[0].equalsIgnoreCase("<vertex>")) {
							float x = 0;
							float y = 0;
							float z = 0;
							// READ VERTICES //
							while((line = fileReader.readLine()) != null) {
								lineNumb++;
								tokens = Util.formatLine(line);
								if(!Util.hasData(tokens)){continue;}
								else if(tokens[0].contains("<x>")) {
									x = Float.parseFloat(tokens[0].substring(tokens[0].indexOf(">") + 1, tokens[0].indexOf("</")));
								}
								else if(tokens[0].contains("<y>")) {
									y = Float.parseFloat(tokens[0].substring(tokens[0].indexOf(">") + 1, tokens[0].indexOf("</")));
								}
								else if(tokens[0].contains("<z>")) {
									z = Float.parseFloat(tokens[0].substring(tokens[0].indexOf(">") + 1, tokens[0].indexOf("</")));
								}
								else if(tokens[0].equalsIgnoreCase("</vertex>")) {
									vertices.add(new Vertex(new Vector3f(x,y,z)));
									break;
								}
							}//end read vertices
						}//end vertices
						
						// INDICES //
						else if(tokens[0].equalsIgnoreCase("<triangle>")) {
							int x = 0;
							int y = 0;
							int z = 0;
							while((line = fileReader.readLine()) != null) {
								lineNumb++;
								tokens = Util.formatLine(line);
								if(!Util.hasData(tokens)){continue;}
								else if(tokens[0].contains("<v1>")) {
									x = Integer.parseInt(tokens[0].substring(tokens[0].indexOf(">") + 1, tokens[0].indexOf("</")));
								}
								else if(tokens[0].contains("<v2>")) {
									y = Integer.parseInt(tokens[0].substring(tokens[0].indexOf(">") + 1, tokens[0].indexOf("</")));
								}
								else if(tokens[0].contains("<v3>")) {
									z = Integer.parseInt(tokens[0].substring(tokens[0].indexOf(">") + 1, tokens[0].indexOf("</")));
								}
								else if(tokens[0].equalsIgnoreCase("</triangle>")) {
									indices.add(x);
									indices.add(y);
									indices.add(z);
									break;
								}
							}//end read indices
						}//end indices
						// BREAK OBJECT //
						else if(tokens[0].equalsIgnoreCase("</object>")) {
							break;
						}//end break
					}//end read object
					// ASSIGN PART ATTRIBUTES //
					Part part = new Part(partID);
					part.material = partMat;
					part.transform = partTrans;
					part.vertices = vertices;
					part.indices = indices;
					parts.add(part);
				}//end Object
				// BREAK //
				else if(tokens[0].equalsIgnoreCase("</amf>")) {
					break;
				}//break file
			}//end while
			// Create Satellite //
			SATTObject object = new SATTObject(name);	//CHANGE THIS LATER. ONLY ONE OBJECT. DON"T USE ARRAY
			object.parts = parts;
			objects.add(object);
			
			fileReader.close();	
		} catch(Exception e) {
			System.err.println("ERROR: FAILED TO CREATE " + name + " .SATT FILE");
			System.err.println("SYNTAX ERROR. LINE: " + lineNumb);
			e.printStackTrace();
			return;
		}
		writeSATT(name, objects);
	}//end convertAMF
	
	/**
	 * Parse SATTObjects from an STL file
	 * and send to writeSATT method
	 * @param fileName : name of the file
	 */
	public static void convertSTL(Path path) {
		BufferedReader fileReader = null;
		ArrayList<SATTObject> objects = new ArrayList<SATTObject>();
		
		SATTObject object = new SATTObject("DEFAULT");
		Part part = new Part("DEFAULT");
		
		String name = path.getFileName().toString();
		
		try{
			fileReader = new BufferedReader(new FileReader(path.toString()));
			String line;
			
			//Format and Read Each Line
			while((line = fileReader.readLine()) != null) {
				String [] tokens = Util.formatLine(line);
				//Comment or empty line
				if(!Util.hasData(tokens)){continue;}
				//Vertex/Face Definition
				else if(tokens[0].equals("vertex")) {
					Vertex vertex = new Vertex(new Vector3f(Float.parseFloat(tokens[1]), 
												   			Float.parseFloat(tokens[2]), 
												   			Float.parseFloat(tokens[3])));
					//If the vertex already exists, add an index reference
					if(part.vertices.contains(vertex)) {
						part.indices.add(part.vertices.indexOf(vertex));
					}
					//If the vertex does not exist, add it to vertices and add an index reference
					else {
						part.vertices.add(vertex);
						part.indices.add(part.vertices.size() - 1);
					}
				}
			}//end while
			fileReader.close();	
		} catch(Exception e) {
			System.err.println("ERROR: FAILED TO CREATE " + name + " .SATT FILE");
			e.printStackTrace();
			return;
		}
		object.addPart(part);
		objects.add(object);
		writeSATT(name, objects);
	}//end convertSTL
	
	/**
	 * Parse SATTObjects from an OBJ file
	 * and send to writeSATT method
	 * @param fileName : name of the file
	 */
	public static void convertOBJ(Path path) {
		
		BufferedReader fileReader = null;
		ArrayList<SATTObject> objects = new ArrayList<SATTObject>();
		
		SATTObject object = new SATTObject("DEFAULT");
		Part part = new Part("DEFAULT");
		
		String name = path.getFileName().toString();
		
		try{
			fileReader = new BufferedReader(new FileReader(path.toString()));
			String line;
			
			while((line = fileReader.readLine()) != null) {
				String [] tokens = Util.formatLine(line);//removes empty tokens
				if(!Util.hasData(tokens)) {continue;}
				// VERTICES //
				else if(tokens[0].equalsIgnoreCase("v")) {
					part.vertices.add(new Vertex(new Vector3f(Float.parseFloat(tokens[1]), 
														 	  Float.parseFloat(tokens[2]), 
														 	  Float.parseFloat(tokens[3]))));
				}//end vertices
				// INDICES //
				else if(tokens[0].equalsIgnoreCase("f")) {
					part.indices.add(Integer.parseInt(tokens[1].substring(0, tokens[1].indexOf("/"))) - 1);// - 1 b/c obj files start numbering at 0
					part.indices.add(Integer.parseInt(tokens[2].substring(0, tokens[2].indexOf("/"))) - 1);
					part.indices.add(Integer.parseInt(tokens[3].substring(0, tokens[3].indexOf("/"))) - 1);
				}//end indices
			}//end while
			object.addPart(part);
			objects.add(object);
			fileReader.close();	
		} catch(Exception e) {
			System.err.println("ERROR: FAILED TO CREATE " + name + " .SATT FILE");
			e.printStackTrace();
			return;
		}
		writeSATT(name, objects);
	}//end convertOBJ
}//end class

/**
 * SATTObject Inner Class
 * Represents a Simulation Object
 * comprised of various parts
 */
 class SATTObject {
	protected String id;
	protected PartTrans transform;
	protected ArrayList<Part> parts;
	
	public SATTObject(String id) {
		this.id = id;
		parts = new ArrayList<Part>();
		transform = new PartTrans();
	}//end constructor
	
	public void addPart(Part part) {
		parts.add(part);
	}
}//end SATTObject

/**
 * Part Inner Class
 * Represents a single 3D element
 * with a single material type
 */
 class Part {
	protected String id;
	protected PartTrans transform;
	protected PartMat material;
	protected ArrayList<Vertex> vertices;
	protected ArrayList<Integer> indices;
	
	public Part(String id) {
		this.id = id;
		indices = new ArrayList<Integer>();
		vertices = new ArrayList<Vertex>();
		transform = new PartTrans();
		material = new PartMat();
	}//end constructor
}//end Part
 
 /**
  * PartMat Inner Class
  * Used to represent a material object
  * without creating an actual material
  * object. (Material Objects require a
  * current OpenGL context in order to
  * create textures properly).
  * ADD TEXTURES LATER. Do this for Transformation as well?
  */
 class PartMat {
	 protected String id;
	 protected Vector3f color;
	 protected float specI;
	 protected float specP;
	 
	 public PartMat() {
		 //Set Default Values
		 id = "DEFAULT";
		 color = new Vector3f(0, 1, 1);
		 specI = 2;
		 specP = 32;
	 }
 }
 
 /**
  * PartTrans Inner Class
  * Used to represent Transform
  * object without creating an 
  * actual Transform object
  */
 class PartTrans {
	 protected Vector3f translation;	
	 protected Quaternion rotation;		
	 protected float scale;	
	 
	 public PartTrans() {
		 //Set Default Values
		 translation = new Vector3f(0, 0, 0);
		 rotation = new Quaternion();
		 scale = 1;
	 }
 }
