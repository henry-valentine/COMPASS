package slra.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import slra.mathUtilities.Vector3f;
import slra.simObjects.utilities.Mesh;
import slra.simObjects.utilities.Texture;
import slra.simObjects.utilities.Vertex;

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
		
		String [] splitArray = fileName.split("\\.");//used to get the file extension
		String ext = splitArray[splitArray.length - 1];
		
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
		
		if(!ext.equals("obj")) {
			System.err.println("ERROR: FILE TYPE NOT SUPPORTED FOR MESH DATA: " + ext);
			new Exception().printStackTrace();
			System.exit(1);
		}
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		BufferedReader meshReader = null;
		
		// Reads in text from obj file and assigns values to the vertices and indices of the mesh //
		try{
			meshReader = new BufferedReader(new FileReader("res/models/" + fileName));
			String line;
			
			while((line = meshReader.readLine()) != null) {
				
				String [] tokens = line.split(" ");//separates all elements in the line
				
				tokens = Util.formatOBJ(tokens);
				
				//Comment or empty line
				if(tokens.length == 0 || tokens[0].equals("#") || tokens[0].equals("")){
					continue;
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
}//end class
