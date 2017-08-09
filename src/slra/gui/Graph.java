package slra.gui;

import java.util.ArrayList;
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
 * @version 11/21/2016
 */
public class Graph {
	
	////* Instance Variables *////
	private ArrayList<Point2f> points;	//Graph Points
	private String title;				//Window Title
	private Pane pane;					//Window Pane
			
	private final int WIDTH = 400;		//Window Width
	private final int HEIGHT = 400;		//Window Height
	
	////* Constructor *////
	/**
	 * Constructor - Initializes Graph Points and window settings.
	 * @param points - Points to be graphed
	 */
	public Graph(String title, ArrayList<Point2f> points) {
		//Initialize Instance Variables
		this.points = points;
		this.title = title;
		
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
		
		//Create Points and Lines for Graphs and add them to the Pane
		for(int i = 0; i < points.size(); i++) {
			
			// Scale Data //
			points.get(i).setX(points.get(i).getX() * WIDTH / maxTime);
			points.get(i).setY((points.get(i).getY() - minBright) * HEIGHT / (maxBright - minBright));
			
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