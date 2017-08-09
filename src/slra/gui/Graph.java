package slra.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import slra.mathUtilities.Point2f;

/**
 * Graph Class - Produces a new window containing a line
 * graph of the given Point2f data.
 * 
 * TODO: Scale Data for window size.
 * 		 Create graduations on x and y axis.
 * 		 Make it look pretty.
 * 
 * @author Henry Valentine
 * @version 12/8/2016
 */
public class Graph {
	
	////* Instance Variables *////
	private ArrayList<Point2f> points;	//Graph Points
	private Pane pane;					//Window Pane
	private GUI gui;
	
	private final int WIDTH = 400;		//Window Width
	private final int HEIGHT = 400;		//Window Height
	
	////* Constructor *////
	/**
	 * Constructor - Initializes Graph Points and window settings.
	 * @param points - Points to be graphed
	 */
	public Graph(String title, GUI gui) {
		//Initialize Instance Variables
		this.gui = gui;
		points = retrieveData("res/data/" + title + ".txt");
		
		//Create Pane
		pane = new Pane();
		pane.setBackground(GUI.blackBr);
		
		//Graph Data to Pane
		graphData();
		
		//Create Scene
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		
		//Create Stage and Display Window
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle(title);
		stage.sizeToScene();
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:res/images/SatLogo.png"));
		stage.show();
	}//end Graph
	
	/**
	 * Loads Data From the Given Simulation File
	 * @param path : Path of the simulation to read data from
	 * @return Point2f ArrayList of data points
	 */
	public ArrayList<Point2f> retrieveData(String path) {
		// Get Simulation Data File //
		File inFile = new File(path);
		Scanner input = null;
		ArrayList<Point2f> data = new ArrayList<Point2f>();
		
		try {
			input = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.err.println("Could not locate file: " + path);
			gui.print("Could not locate file: " + path);
			e.printStackTrace();
		}
		// Read in Data //
		if(input != null) {
			try {
				while(input.hasNext()) {
					float p1 = Float.parseFloat(input.next());
					float p2 = Float.parseFloat(input.next());
					data.add(new Point2f(p1, p2));
					}
				System.out.println("Data Loaded From: " + path);
				gui.print("Data Loaded From: " + path);
			} catch(Exception e) {
				System.err.println("WARNING: POSSIBLE DATA CORRUPTION");
				gui.print("WARNING: POSSIBLE DATA CORRUPTION");
				System.err.println("File: " + path + " may not be formatted correctly");
				gui.print("File: " + path + " may not be formatted correctly");
			}
			input.close();//Close Scanner
		}
		return data;
	}//end retrieveData
	
	/**
	 * Takes Point data from instance variables
	 * and produces a line graph.
	 */
	public void graphData() {
		
		// Graph Scale Values //
		float minBright = Float.MAX_VALUE;
		float maxBright = Float.MIN_VALUE;
		
		// Max Time : Last Time in Data Set //
		float maxTime = points.get(points.size() - 1).getX();
		
		// Gets the Biggest and Smallest Brightness Values //
		for(Point2f point : points) {
			if(point.getY() > maxBright) {
				maxBright = point.getY();
			}
			if(point.getY() < minBright) {
				minBright = point.getY();
			}
		}
		
		// Graph Straight line if all data is the same //
		if(maxBright == minBright) {
			maxBright++;
			minBright--;
		}
		
		//Create Points and Lines for Graphs and add them to the Pane
		for(int i = 0; i < points.size(); i++) {
			
			// Scale Data //
			points.get(i).setX(points.get(i).getX() * WIDTH / maxTime);
			points.get(i).setY(HEIGHT - ((points.get(i).getY() - minBright) * HEIGHT / (maxBright - minBright)));//Subtract From Height b/c coordinates are inverted
			
			// Create Point //
			Circle tempPoint = new Circle();
			tempPoint.setRadius(2);
			
			//Graph Points and Scale to Window //
			tempPoint.setCenterX(points.get(i).getX());
			tempPoint.setCenterY(points.get(i).getY());
			
			// Set Color //
			tempPoint.setFill(Color.AQUA);
			tempPoint.setStroke(Color.AQUA);
			
			// Add point to Pane //
			pane.getChildren().add(tempPoint);
			
			// Create Line //
			if(i != 0) {
				Line line = new Line(points.get(i).getX(), points.get(i).getY(),
									 points.get(i - 1).getX(), points.get(i - 1).getY());
				line.setFill(Color.AQUA);
				line.setStroke(Color.AQUA);				
				pane.getChildren().add(line);	//Add Line to Pane
			}
		}//end loop
	}//end graph data
}//end class