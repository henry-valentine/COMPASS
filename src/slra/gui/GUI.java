package slra.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import slra.mathUtilities.Point2f;
import slra.simObjects.objects.*;
import slra.simObjects.utilities.SimObject;
import slra.simulation.Simulation;
import slra.util.ResourceLoader;

/***************************************************CS225 Final Project**************************************************
 * Satellite Light Reflection Analyzer (SLRA)
 * @author Henry Valentine
 * @version 11/21/2016
 * CS225 Section 1: Dr. Garfield
 * 
 * This program simulates light interactions with 3D satellite models and calculates brightness levels as perceived
 * from a specific view-point. User input, accessed via the UI, is used to establish the satellites orientation
 * and angular velocity as well as the duration of the simulated pass (i.e. data collection period). Brightness data
 * is collected at regular intervals and logged in a text file. Data collections may be selected and graphed via the UI.
 * 
 * External Reference Libraries:
 * - LWJGL
 * 	- OpenGL
 * 	- GLFW
 * 
 * References:
 * - OpenGL-based 3D engine inspired by thebennybox youtube tutorials : https://www.youtube.com/user/thebennybox
 * 	 see res folder for License
 * - Heiko Brumme's Texture Class for LWJGL 3 Compatibility (See TextureLoader class for software license)
 * 
 * TODO: 
 *  - Set translation to fill window
 *  - Display UI error message
 *  - Print a "Paused" message
 *  - Handle Parsing errors by printing a message to screen (or pop-up box)
 *  - Print a "Simulation Ended" Message
 *  - Use vectors to represent xRot yRot zRot cause its way easier
 *  - Add Graduations to Graph
 *  - User Defined Graph Scale
 *  - Save Simulation Button
 *  - Add Support for custom objects
 *  - Add support for STL files
 *  - Edit Shader Programs (Get Rid of Ambient Light - not needed - hardCode eye position?)
 * 
 *************************************************************************************************************************/

/**
 * GUI class to get user input and interface with satellite modeling simulation
 * CS225 Final Project
 * @author Henry Valentine
 * @version 12/8/2016
 */
public class GUI extends Application {
	
	///////////VARIABLE DECLARATION///////////
	private Pane pane;//GUI Pane declaration
	
	////GUI Nodes////
	//Buttons
	private Button btRun, btGraph, btHelp;	
	
	//Combo Boxes
	private ComboBox<String> objectBox, graphBox;
	private ObservableList<String> simulationList, simObjects;
		
	//HashMap to refer to simulation data for Graphing
	private HashMap<String, String> simulations;
	
	//TextFields
	private TextField tfXRot, tfYRot, tfZRot,		
					  tfXVel, tfYVel, tfZVel,
					  tfPassDuration;
	
	//Menu Labels
	private Label lRunMenu, lGraphMenu;
	
	//Satellite Image
	private ImageView image;
	
	//SLRA Text
	private Text slra;
	
	//Window Parameters
	public static final int WIDTH = 362;//Window Width
	public static final int HEIGHT = 241;//Window Height
	
	//Backgrounds
	public static Background darkGreyBr, lightGreyBr, blackBr;
	
	//Font
	public static Font btFont = Font.font("Ariel", FontWeight.BOLD, 14);
	public static Font menuFont = Font.font("Ariel", FontWeight.BOLD, 18);
	
	//RUNNING
	boolean running;	//Whether or not a simulation is running (to prevent concurrent simulations)
	
	/**
	 * GUI class constructor.
	 * Initializes nodes for the window.
	 */
	public GUI() {
		////Initialize Instance Variables////
		
		running = false;	//no Sim running yet
		
		//Initialize background values
		darkGreyBr = new Background(new BackgroundFill(Color.DARKGREY, null, null));
		lightGreyBr = new Background(new BackgroundFill(Color.LIGHTGREY, null, null));
		blackBr = new Background(new BackgroundFill(Color.BLACK, null, null));
		
		//Initialize Pane
		pane = new Pane();
		
		//Satellite Image
		image = new ImageView(new Image("file:res/images/SatLogo.png"));
		if(image == null) {
			System.err.println("ERROR: Logo Not Loaded =(");
		}
		
		//SLRA Text
		slra = new Text("Satellite\nLight\nReflection\nAnalyzer");
		
		//ComboBox Options
		simulations = new HashMap<String, String>();
		simulationList = FXCollections.observableArrayList();
		simObjects = FXCollections.observableArrayList();
		
		//Labels
		lRunMenu = new Label("          Run Menu");//Because it's kind of a pain to center label text...
		lGraphMenu = new Label("        Graph Menu");
		
		//Button Nodes
		btRun = new Button("Run");
		btGraph = new Button("Graph");
		btHelp = new Button("Help");
		
		//ComboBox Nodes
		objectBox = new ComboBox<String>(simObjects);
		objectBox.setPromptText("Sim Object");
		graphBox = new ComboBox<String>(simulationList);//TEST TEST TEST
		graphBox.setPromptText("Sim Graph");
		
		//TextField Nodes
		tfXRot = new TextField("X Rotation");
		tfYRot = new TextField("Y Rotation");
		tfZRot = new TextField("Z Rotation");
		tfXVel = new TextField("X Velocity");
		tfYVel = new TextField("Y Velocity");
		tfZVel = new TextField("Z Velocity");
		tfPassDuration = new TextField("Pass Duration");
		
		//// Populate Combo Boxes ////
		loadSimulations();
		loadObjects();
		
		////Pane Options////
		pane.setBackground(blackBr);
		
		////Help Button////
		btHelp.setBackground(darkGreyBr);
			btHelp.setPrefWidth(178);
			btHelp.setLayoutX(184);
			btHelp.setLayoutY(105);
			btHelp.setFont(btFont);
		
		////Run Menu Layout////
		//Menu Title
		lRunMenu.setPrefWidth(178);
		lRunMenu.setBackground(darkGreyBr);
		lRunMenu.setPrefHeight(32);
		lRunMenu.setFont(menuFont);
		//Simulation Object ComboBox
		objectBox.setLayoutY(35);
		objectBox.setPrefWidth(178);
		objectBox.setBackground(darkGreyBr);
		//Rotation TextFields
		tfXRot.setLayoutY(70);
			tfXRot.setPrefWidth(88);
			tfXRot.setBackground(darkGreyBr);
		tfYRot.setLayoutY(105);
			tfYRot.setPrefWidth(88);
			tfYRot.setBackground(darkGreyBr);
		tfZRot.setLayoutY(140);
			tfZRot.setPrefWidth(88);
			tfZRot.setBackground(darkGreyBr);
		//Angular Velocity TextFields
		tfXVel.setLayoutY(70);
			tfXVel.setLayoutX(90);
			tfXVel.setPrefWidth(88);
			tfXVel.setBackground(darkGreyBr);
		tfYVel.setLayoutY(105);
			tfYVel.setLayoutX(90);
			tfYVel.setPrefWidth(88);
			tfYVel.setBackground(darkGreyBr);
		tfZVel.setLayoutY(140);
			tfZVel.setLayoutX(90);
			tfZVel.setPrefWidth(88);
			tfZVel.setBackground(darkGreyBr);
		//Pass Duration TextField
		tfPassDuration.setLayoutY(175);
		tfPassDuration.setPrefWidth(178);
		tfPassDuration.setBackground(darkGreyBr);
		//Run Button
		btRun.setLayoutY(210);
		btRun.setPrefWidth(178);
		btRun.setBackground(darkGreyBr);
		btRun.setFont(btFont);
			
		////Graph Menu Layout////
		//Menu Title
		lGraphMenu.setPrefWidth(178);
		lGraphMenu.setPrefHeight(32);
		lGraphMenu.setLayoutX(184);
		lGraphMenu.setBackground(darkGreyBr);
		lGraphMenu.setFont(menuFont);
		//Graph Selection ComboBox
		graphBox.setPrefWidth(178);
		graphBox.setLayoutX(184);
		graphBox.setLayoutY(35);
		graphBox.setBackground(darkGreyBr);
		//Graph Button
		btGraph.setPrefWidth(178);
		btGraph.setLayoutX(184);
		btGraph.setLayoutY(70);
		btGraph.setBackground(darkGreyBr);
		btGraph.setFont(btFont);
		
		////Satellite Image////
		image.setLayoutX(184);//230
		image.setLayoutY(140);
		image.setFitWidth(101);
		image.setFitHeight(101);
			
		////SLRA Text////
		slra.setLayoutX(290);
		slra.setLayoutY(165);
		slra.setFill(Color.DARKGRAY);
		slra.setFont(btFont);
		
		////Pane Assembly////
		//Help
		pane.getChildren().add(btHelp);
		
		//Run Menu
		pane.getChildren().add(lRunMenu);
		pane.getChildren().add(objectBox);
		pane.getChildren().add(tfXRot);
		pane.getChildren().add(tfYRot);
		pane.getChildren().add(tfZRot);
		pane.getChildren().add(tfXVel);
		pane.getChildren().add(tfYVel);
		pane.getChildren().add(tfZVel);
		pane.getChildren().add(tfPassDuration);
		pane.getChildren().add(btRun);
		
		//Graph Menu
		pane.getChildren().add(lGraphMenu);
		pane.getChildren().add(graphBox);
		pane.getChildren().add(btGraph);
		
		//Embellishments n' such
		pane.getChildren().add(image);
		pane.getChildren().add(slra);
		
		//Assign behavior to Nodes
		assignBehavior();
	}//end GUI
	
	/** Assigns behavior to JavaFX Nodes in Pane*/
	public void assignBehavior() {
		////Help Button////
		btHelp.setOnMouseEntered(e -> btHelp.setBackground(lightGreyBr));//Change Button Color on mouse hover
		btHelp.setOnMouseExited(e -> btHelp.setBackground(darkGreyBr));
		//Create Help Window when clicked
		btHelp.setOnMouseClicked(e -> {
			//Create Label and help text
			Label helpLabel = new Label();
			String helpText = ResourceLoader.loadText("res/help.txt");
			
			helpLabel.setText(helpText);
			helpLabel.setWrapText(true);
			helpLabel.setPrefWidth(381);
			helpLabel.setBackground(darkGreyBr);
			
			VBox root = new VBox();
			Scene helpScene = new Scene(root, 400, 200);
			ScrollPane sp = new ScrollPane();
			
			sp.setBackground(darkGreyBr);
			sp.setContent(helpLabel);
			
			sp.setHbarPolicy(ScrollBarPolicy.NEVER);
			sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			
			sp.setPrefHeight(400);
			
			root.getChildren().add(sp);
			root.setBackground(darkGreyBr);
			
			//Create new Scene and Stage and Display Help Information
			Stage helpStage = new Stage();
			helpStage.setScene(helpScene);
			helpStage.sizeToScene();
			helpStage.setTitle("Help");
			helpStage.setResizable(false);
			helpStage.getIcons().add(new Image("file:res/images/SatLogo.png"));
			helpStage.show();
		});
		
		////Text Fields////
		tfXRot.setOnMouseClicked(e -> tfXRot.clear());	//Clears the TextField when selected
		tfYRot.setOnMouseClicked(e -> tfYRot.clear());
		tfZRot.setOnMouseClicked(e -> tfZRot.clear());
		tfXVel.setOnMouseClicked(e -> tfXVel.clear());
		tfYVel.setOnMouseClicked(e -> tfYVel.clear());
		tfZVel.setOnMouseClicked(e -> tfZVel.clear());
		tfPassDuration.setOnMouseClicked(e -> tfPassDuration.clear());
		
		////Graph Button////
		btGraph.setOnMouseEntered(e -> btGraph.setBackground(lightGreyBr));	//Change Button Color on mouse hover
		btGraph.setOnMouseExited(e -> btGraph.setBackground(darkGreyBr));
		btGraph.setOnMouseClicked(e -> {									//If A selection has been made from the Graph ComboBox
			if(graphBox.getValue() != null) {								//Graph the selected data
				new Graph(graphBox.getValue(), retrieveData(simulations.get(graphBox.getValue())));
			}
			else {
				System.err.println("ERROR: Invalid Graph Selection");
			}
		});
		
		////Run Button////
		btRun.setOnMouseEntered(e -> btRun.setBackground(lightGreyBr));//Change Button Color on mouse hover
		btRun.setOnMouseExited(e -> btRun.setBackground(darkGreyBr));
		btRun.setOnMouseClicked(e -> run());
		
	}//end assignBehavior
	
	/**
	 * 
	 * This Method Populates the Simulation Object ComboBox
	 * 
	 * Note:
	 * The implementation of this method is probably temporary.
	 * Develop a better way to represent objects in the comboBox
	 * Add support for Custom OBJ or STL objects
	 */
	public void loadObjects() {
		simObjects.add("Cube");
		simObjects.add("2U CubeSat");
		simObjects.add("Cylinder");
		simObjects.add("Teapot");
	}//end loadObjects
	
	/**
	 * Loads the names and file locations of
	 * every simulation saved in the data folder
	 * and adds them to the HashMap to be displayed
	 * in the comboBox.
	 */
	public void loadSimulations() {
		String [] paths = ResourceLoader.loadPaths("res/data");
		
		System.out.println("-------- Simulation Data --------");
		
		for(String path : paths) {
			// Remove All SubDirectory Names //
			String name = Paths.get(path).getFileName().toString();
			
			// Remove File Extension //
			name = name.substring(0, name.indexOf("."));
			simulations.put(name, path);
			simulationList.add(name);
			System.out.println("Simulation Data Loaded: " + name);
		}
		System.out.println("---------------------------------");
	}//end loadSimulations
	
	/** Clears the Current List of simulations */
	public void clearSimulations() {
		simulations.clear();
		simulationList.clear();
		System.out.println("Simulation Data Cleared...");
	}//end clearSimulations
	
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
			} catch(Exception e) {
				System.err.println("WARNING: POSSIBLE DATA CORRUPTION");
				System.err.println("File: " + path + " may not be formatted correctly");
			}
			input.close();//Close Scanner
		}
		return data;
	}//end retrieveData
	
	/**
	 * Creates a new Simulation given
	 * the user defined parameters
	 * from the GUI
	 */
	public void run() {
		
		boolean error = false;
		
		float xRot, yRot, zRot;
		float xVel, yVel, zVel;
		int passDuration;
		
		// Default Initialization //
		xRot = yRot = zRot = 0;
		xVel = yVel = zVel = 0;
		passDuration = 0;
		
		// Read Values From GUI //
		try {
			xRot = Float.parseFloat(tfXRot.getText());
			yRot = Float.parseFloat(tfYRot.getText());
			zRot = Float.parseFloat(tfZRot.getText());
			xVel = Float.parseFloat(tfXVel.getText());
			yVel = Float.parseFloat(tfYVel.getText());
			zVel = Float.parseFloat(tfZVel.getText());
			passDuration = Integer.parseInt(tfPassDuration.getText());
			System.out.println("Simulation Parameters Loaded...");
		} catch(Exception e) {
			System.err.println("ERROR: Could not parse values from TextField(s)");
			error = true;
		}
		
		// If Values Were Parsed Correctly, Create a new Simulation //
		if(!error) {
			if(!running) {
				Simulation sim = new Simulation(passDuration, this);			//Create and initialize new Simulation
				SimObject object = null;
				
				try {
					// Select Object Type Based On ComboBox //
					if(objectBox.getValue().equals("Cube")) {
						object = new Cube();
					}
					else if(objectBox.getValue().equals("2U CubeSat")) {
						object = new CubeSat2U();
					}
					else if(objectBox.getValue().equals("Cylinder")) {
						object = new Cylinder();
					}
					else if(objectBox.getValue().equals("Teapot")) {
						object = new TeaPot();
					}
					System.out.println(object + " Successfully Created...");
				} catch(Exception e) {
					System.err.println("ERROR: Object Selection Not Valid");
				}
				
				// Add Object and Run the Simulation //
				if(object != null) {
					sim.addObject(object, xRot, yRot, zRot, xVel, yVel, zVel);//Add object to the simulation
					sim.run();//Run the simulation
				}
				else {
					// Terminate the Simulation if no object //
					sim.terminate();
				}
			}
			else {
				System.err.println("ERROR: Cannot Run Multiple Simulations at once.");
			}
		}
		
		// Display Error Message in GUI //
		
	}//end run
	
	/**
	 * Runs the GUI
	 * Overridden from Application class.
	 */
	public void start(Stage primaryStage) {
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene(); 		//sets window size to the size of the scene.
		primaryStage.setTitle("SLRA");		//Satellite light Reflection Analyzer.
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("file:res/images/SatLogo.png"));	//Does not produce an error if Icon file is unavailable.	
		primaryStage.show();
	}//end start
	
	public static void main(String [] args) {
		launch(args);
	}//end main
	
	/* Getters and Setters */
	public ObservableList<String> getSimulationList() {
		return simulationList;
	}

	public void setSimulationList(ObservableList<String> simulationList) {
		this.simulationList = simulationList;
	}

	public ObservableList<String> getSimObjects() {
		return simObjects;
	}

	public void setSimObjects(ObservableList<String> simObjects) {
		this.simObjects = simObjects;
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isRunning() {
		return running;
	}
}//end class
