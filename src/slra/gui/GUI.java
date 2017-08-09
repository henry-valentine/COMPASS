 package slra.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import slra.mathUtilities.Point2f;
import slra.mathUtilities.Vector3f;
import slra.simObjects.utilities.SimObject;
import slra.simulation.Simulation;
import slra.util.FileConverter;
import slra.util.ResourceLoader;

/*************************************************** Satellite Light Reflection Analyzer **************************************************
 * Satellite Light Reflection Analyzer (SLRA)
 * @author Henry Valentine
 * @version 0.9.1
 * 
 * Purpose:
 * This program simulates light interactions with 3D satellite models and calculates brightness levels as perceived
 * from a specific view-point. User input, accessed via the UI, is used to establish the satellites orientation
 * and angular velocity as well as the duration of the simulated pass (i.e. data collection period). Brightness data
 * is collected at regular intervals and logged in a text file. Data collections may be selected and graphed via the UI.
 * 
 * EXTERNAL LIBRARIES:
 *	**See Respective Websites for Licensing Agreements**
 *	- LWJGL (Lightweight Java Game Library) : https://lwjgl.org/
 *	- OpenGL : https://www.opengl.org/
 *  - GLFW : http://www.glfw.org/
 * 
 * REFERENCES:
 *	- OpenGL-based 3D engine inspired by thebennybox youtube tutorials : 
 *	  https://www.youtube.com/user/thebennybox (See project folder for license)
 *	- Heiko Brumme's Texture Class for LWJGL 3 Compatibility (Under MIT License)
 *	- Web-based PNG to ICON converter: http://convertico.com/
 *	- Web-based STL to OBJ converter: http://www.greentoken.de/onlineconv/
 * 
 * NOTES:
 *	- Program Documentation is included in the SLRA/doc directory (javadoc and UML)
 *	- ** Error messages have not yet been implemented in the UI. 
 *		 To see program error messages -> run SLRA.jar in the command window
 *	- Use Meshes with higher vertex counts for more accurate shading (i.e with a cube)
 * 
 * FUTURE UPDATES:
 ******************************************************************************************************************************************/

/**
 * GUI class to get user input and interface with satellite modeling simulation
 * @author Henry Valentine
 * @version 12/8/2016
 */
public class GUI extends Application {
	
	// Software Version //
	public static final String VERSION = "0.9.1";
	
	///////////VARIABLE DECLARATION///////////
	private Pane pane;//GUI Pane declaration
	
	private Stage stage;
	
	////GUI Nodes////
	//Buttons
	private Button btRun, btGraph, btHelp, btTLE, btExit, btGraphOp, btConfig, btAdd;	
	
	//Combo Boxes
	private ComboBox<String> objectBox, graphBox;
	private ObservableList<String> simulationList, simObjects;
	
	//TextFields
	private TextField tfXRot, tfYRot, tfZRot, tfWRot,		
					  tfXVel, tfYVel, tfZVel, tfWVel,
					  tfI, tfRA, tfE, tfAP, tfMA, tfMM,
					  tfSR, tfOTime, tfPassDuration;
	
	//Menu Labels
	private Label lRunMenu, lGraphMenu, lRotation, lVelocity, lOE, lOptions;
	
	//Satellite Image
	private ImageView image;
	
	//Window Parameters
	public static final int WIDTH = 1160;//Window Width
	public static final int HEIGHT = 800;//Window Height
	
	//Backgrounds
	public static Background darkGreyBr, lightGreyBr, blackBr, lightBlackBr;
	
	//Font
	public static Font btFont = Font.font("Ariel", FontWeight.BOLD, 14);
	public static Font menuFont = Font.font("Ariel", FontWeight.BOLD, 18);
	
	//RUNNING
	boolean running;	//Whether or not a simulation is running (to prevent concurrent simulations)
	
	//Console
	ScrollPane console;
	String consoleText;
	Label consoleLabel;
	
	//Live Graph
	Pane liveGraph;
	ArrayList<Point2f> dataPoints;	//Used For Live Graph and Saved Data
	float scaleFactor;
	int simTime;
	int sampleRate;
	
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
		lightBlackBr = new Background(new BackgroundFill(new Color(0.1, 0.1, 0.1, 0.5), null, null));
		
		//Initialize Stage
		stage = new Stage();
		
		//Initialize Pane
		pane = new Pane();
		
		//Create Console//
		console = new ScrollPane();
		consoleText = "****************************************SATELLITE LIGHT REFLECTION ANALYZER****************************************";
		consoleLabel = new Label();
		consoleLabel.setPrefWidth(800);
		consoleLabel.setText(consoleText);
		consoleLabel.setWrapText(false);
		consoleLabel.setTextFill(Color.GREY);
		
		console.setContent(consoleLabel);
		console.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		console.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		console.setPrefHeight(200);
		console.setPrefWidth(800);
		console.setLayoutX(180);
		console.setLayoutY(600);
		console.getStylesheets().add("slra.css");
		
		//Create Live Graph//
		liveGraph = new Pane();
		liveGraph.setPrefWidth(180);
		liveGraph.setPrefHeight(381);
		liveGraph.setLayoutX(980);
		liveGraph.setLayoutY(123);
		liveGraph.setBackground(lightBlackBr);
		
		//Satellite Image
		image = new ImageView(new Image("file:res/images/SatLogo.png"));
		if(image == null) {
			System.err.println("ERROR: LOGO NOT LOADED =(");
			this.print("ERROR: LOGO NOT LOADED =(");
		}
		
		//ComboBox Options
		simulationList = FXCollections.observableArrayList();
		simObjects = FXCollections.observableArrayList();
		
		//Labels
		lRunMenu = new Label("          Run Menu");//Because it's kind of a pain to center label text...
		lGraphMenu = new Label("        Graph Menu");
		lRotation = new Label("    Rotation");
		lVelocity = new Label("    Velocity");
		lOE = new Label("         Orbital Elements");
		lOptions = new Label("            Options");
		
		//Button Nodes
		btRun = new Button("Run");
		btGraph = new Button("Graph");
		btHelp = new Button("Help");
		btTLE = new Button("TLE");
		btExit = new Button("Exit");
		btGraphOp = new Button("Graph Options");
		btConfig = new Button("SAT Config");
		btAdd = new Button("Add SAT");
		
		//ComboBox Nodes
		objectBox = new ComboBox<String>(simObjects);
		objectBox.setPromptText("Sim Object");
		graphBox = new ComboBox<String>(simulationList);
		graphBox.setPromptText("Sim Graph");
		
		//TextField Nodes
		tfXRot = new TextField("X");
		tfYRot = new TextField("Y");
		tfZRot = new TextField("Z");
		tfWRot = new TextField("Angle");
		tfXVel = new TextField("X");
		tfYVel = new TextField("Y");
		tfZVel = new TextField("Z");
		tfWVel = new TextField("Hertz");
		tfI = new TextField("I");
		tfRA = new TextField("RA");
		tfE = new TextField("E");
		tfAP = new TextField("AP");
		tfMA = new TextField("MA");
		tfMM= new TextField("MM");
		tfOTime = new TextField("Observation Time");
		tfPassDuration = new TextField("Pass Duration");
		tfSR = new TextField("Sample Rate [Hz]");
		
		//// Populate Combo Boxes ////
		loadSimulations();
		loadObjects();
		
		////Pane Options////
		pane.setBackground(blackBr);
		
		////Run Menu Layout////
		//Menu Title
		lRunMenu.setPrefWidth(180);
		lRunMenu.setBackground(darkGreyBr);
		lRunMenu.setPrefHeight(32);
		lRunMenu.setFont(menuFont);
		//Simulation Object ComboBox
		objectBox.setLayoutY(41);
		objectBox.setPrefWidth(180);
		objectBox.setBackground(darkGreyBr);
		//Velocity/Rotation Labels
		lRotation.setLayoutY(82);
			lRotation.setPrefWidth(88);
			lRotation.setBackground(darkGreyBr);
			lRotation.setPrefHeight(32);
			lRotation.setFont(btFont);
		lVelocity.setLayoutY(82);
			lVelocity.setLayoutX(92);
			lVelocity.setPrefWidth(88);
			lVelocity.setBackground(darkGreyBr);
			lVelocity.setPrefHeight(32);
			lVelocity.setFont(btFont);
		//Rotation TextFields
		tfXRot.setLayoutY(120);
			tfXRot.setPrefWidth(88);
			tfXRot.setBackground(darkGreyBr);
		tfYRot.setLayoutY(158);
			tfYRot.setPrefWidth(88);
			tfYRot.setBackground(darkGreyBr);
		tfZRot.setLayoutY(196);
			tfZRot.setPrefWidth(88);
			tfZRot.setBackground(darkGreyBr);
		tfWRot.setLayoutY(234);
			tfWRot.setPrefWidth(88);
			tfWRot.setBackground(darkGreyBr);
			
		//Angular Velocity TextFields
		tfXVel.setLayoutY(120);
			tfXVel.setLayoutX(92);
			tfXVel.setPrefWidth(88);
			tfXVel.setBackground(darkGreyBr);
		tfYVel.setLayoutY(158);
			tfYVel.setLayoutX(92);
			tfYVel.setPrefWidth(88);
			tfYVel.setBackground(darkGreyBr);
		tfZVel.setLayoutY(196);
			tfZVel.setLayoutX(92);
			tfZVel.setPrefWidth(88);
			tfZVel.setBackground(darkGreyBr);
		tfWVel.setLayoutY(234);
			tfWVel.setLayoutX(92);
			tfWVel.setPrefWidth(88);
			tfWVel.setBackground(darkGreyBr);	
		//Orbital Elements Label
		lOE.setLayoutY(275);
			lOE.setPrefWidth(180);
			lOE.setBackground(darkGreyBr);
			lOE.setPrefHeight(32);
			lOE.setFont(btFont);
		//Orbital Element Textfields
		tfI.setLayoutY(313);
			tfI.setPrefWidth(88);
			tfI.setBackground(darkGreyBr);
		tfRA.setLayoutY(351);
			tfRA.setPrefWidth(88);
			tfRA.setBackground(darkGreyBr);
		tfE.setLayoutY(389);
			tfE.setPrefWidth(88);
			tfE.setBackground(darkGreyBr);	
		tfAP.setLayoutY(313);
			tfAP.setLayoutX(92);
			tfAP.setPrefWidth(88);
			tfAP.setBackground(darkGreyBr);
		tfMA.setLayoutY(351);
			tfMA.setLayoutX(92);
			tfMA.setPrefWidth(88);
			tfMA.setBackground(darkGreyBr);
		tfMM.setLayoutY(389);
			tfMM.setLayoutX(92);
			tfMM.setPrefWidth(88);
			tfMM.setBackground(darkGreyBr);
		//Observation Time TextField
		tfOTime.setLayoutY(430);
			tfOTime.setPrefWidth(180);
			tfOTime.setBackground(darkGreyBr);
		//Pass Duration TextField
		tfPassDuration.setLayoutY(471);
		tfPassDuration.setPrefWidth(180);
		tfPassDuration.setBackground(darkGreyBr);
		//TLE Button
		btTLE.setLayoutY(512);
			btTLE.setPrefWidth(180);
			btTLE.setBackground(darkGreyBr);
			btTLE.setFont(btFont);
		//Run Button
		btRun.setLayoutY(553);
		btRun.setPrefWidth(180);
		btRun.setBackground(darkGreyBr);
		btRun.setFont(btFont);
			
		////Graph Menu Layout////
		//Menu Title
		lGraphMenu.setPrefWidth(178);
		lGraphMenu.setPrefHeight(32);
		lGraphMenu.setLayoutX(980);
		lGraphMenu.setBackground(darkGreyBr);
		lGraphMenu.setFont(menuFont);
		//Graph Selection ComboBox
		graphBox.setPrefWidth(178);
		graphBox.setLayoutX(980);
		graphBox.setLayoutY(41);
		graphBox.setBackground(darkGreyBr);
		//Graph Button
		btGraph.setPrefWidth(178);
		btGraph.setLayoutX(980);
		btGraph.setLayoutY(82);
		btGraph.setBackground(darkGreyBr);
		btGraph.setFont(btFont);
		
		////Options////
		lOptions.setBackground(darkGreyBr);
			lOptions.setPrefWidth(180);
			lOptions.setLayoutX(980);
			lOptions.setLayoutY(513);
			lOptions.setFont(menuFont);
		//Sample Rate
		tfSR.setBackground(darkGreyBr);
			tfSR.setPrefWidth(180);
			tfSR.setLayoutX(980);
			tfSR.setLayoutY(554);
		//SAT Config
		btConfig.setBackground(darkGreyBr);
			btConfig.setPrefWidth(180);
			btConfig.setLayoutX(980);
			btConfig.setLayoutY(595);
			btConfig.setFont(btFont);
		//Add SAT
		btAdd.setBackground(darkGreyBr);
			btAdd.setPrefWidth(180);
			btAdd.setLayoutX(980);
			btAdd.setLayoutY(636);
			btAdd.setFont(btFont);
		//Graph Options
		btGraphOp.setBackground(darkGreyBr);
			btGraphOp.setPrefWidth(180);
			btGraphOp.setLayoutX(980);
			btGraphOp.setLayoutY(677);
			btGraphOp.setFont(btFont);
		////Help Button////
		btHelp.setBackground(darkGreyBr);
			btHelp.setPrefWidth(180);
			btHelp.setLayoutX(980);
			btHelp.setLayoutY(718);
			btHelp.setFont(btFont);
		////Exit Button////
		btExit.setBackground(darkGreyBr);
			btExit.setPrefWidth(180);
			btExit.setLayoutX(980);
			btExit.setLayoutY(759);
			btExit.setFont(btFont);
		////Satellite Image////
		image.setLayoutX(40);//230
		image.setLayoutY(630);
		image.setFitWidth(101);
		image.setFitHeight(101);
		
		////Pane Assembly////
		//Run Menu
		pane.getChildren().add(lRunMenu);
		pane.getChildren().add(objectBox);
		pane.getChildren().add(lRotation);
		pane.getChildren().add(lVelocity);
		pane.getChildren().add(tfXRot);
		pane.getChildren().add(tfYRot);
		pane.getChildren().add(tfZRot);
		pane.getChildren().add(tfWRot);
		pane.getChildren().add(tfXVel);
		pane.getChildren().add(tfYVel);
		pane.getChildren().add(tfZVel);
		pane.getChildren().add(tfWVel);
		pane.getChildren().add(lOE);
		pane.getChildren().add(tfI);
		pane.getChildren().add(tfRA);
		pane.getChildren().add(tfE);
		pane.getChildren().add(tfAP);
		pane.getChildren().add(tfMA);
		pane.getChildren().add(tfMM);
		pane.getChildren().add(btTLE);
		pane.getChildren().add(tfPassDuration);
		pane.getChildren().add(tfOTime);
		pane.getChildren().add(btRun);
		
		//Graph Menu
		pane.getChildren().add(lGraphMenu);
		pane.getChildren().add(graphBox);
		pane.getChildren().add(btGraph);
		
		//Options
		pane.getChildren().add(lOptions);
		pane.getChildren().add(tfSR);
		pane.getChildren().add(btConfig);
		pane.getChildren().add(btAdd);
		pane.getChildren().add(btGraphOp);
		
		//Help
		pane.getChildren().add(btHelp);
		
		//Exit
		pane.getChildren().add(btExit);
		
		//Embellishments n' such
		pane.getChildren().add(image);
		
		//Console
		pane.getChildren().add(console);
		
		//Live Graph
		pane.getChildren().add(liveGraph);
		
		//Assign behavior to Nodes
		assignBehavior();	
	}//end GUI
	
	/** Assigns behavior to JavaFX Nodes in Pane*/
	public void assignBehavior() {
		////Help Button////
		btHelp.setOnMouseEntered(e -> btHelp.setBackground(lightGreyBr));//Change Button Color on mouse hover
		btHelp.setOnMouseExited(e -> btHelp.setBackground(darkGreyBr));
		btHelp.setOnAction(e -> new Help());
		
		////Exit Button////
		btExit.setOnMouseEntered(e -> btExit.setBackground(lightGreyBr));
		btExit.setOnMouseExited(e -> btExit.setBackground(darkGreyBr));
		btExit.setOnAction(e -> System.exit(1));	
		
		////SAT Config////
		btConfig.setOnMouseEntered(e -> btConfig.setBackground(lightGreyBr));
		btConfig.setOnMouseExited(e -> btConfig.setBackground(darkGreyBr));
		
		////Add SAT////
		btAdd.setOnMouseEntered(e -> btAdd.setBackground(lightGreyBr));
		btAdd.setOnMouseExited(e -> btAdd.setBackground(darkGreyBr));
		btAdd.setOnAction(e -> {
			FileChooser chooser = new FileChooser();
			chooser.setTitle("File Explorer");
			chooser.getExtensionFilters().add(new ExtensionFilter("SATT", "*.SATT"));
			chooser.getExtensionFilters().add(new ExtensionFilter("OBJ", "*.OBJ"));
			chooser.getExtensionFilters().add(new ExtensionFilter("STL", "*.STL"));
			chooser.getExtensionFilters().add(new ExtensionFilter("AMF", "*.AMF"));
			
			File theChosenOne = chooser.showOpenDialog(stage);
			
			if(theChosenOne != null) {
				String name = theChosenOne.getName();
				//If It's a SATT File, just copy to models folder
				if(name.substring(name.indexOf(".")).equalsIgnoreCase(".SATT")) {
					try {
						Files.copy(Paths.get(theChosenOne.getPath()), Paths.get(new File("res/models/" + name).getPath()), StandardCopyOption.REPLACE_EXISTING);
						clearObjects();
						loadObjects();
					} catch (IOException e1) {
						System.err.println("ERROR: FAILED TO LOAD " + name);
						this.print("ERROR: FAILED TO LOAD " + name);
						e1.printStackTrace();
					}
				}
				//Convert to Sat and Copy
				else {
					FileConverter.convertFile(Paths.get(theChosenOne.getPath()));
					clearObjects();
					loadObjects();
				}
			}
		});
		
		////Graph Options////
		btGraphOp.setOnMouseEntered(e -> btGraphOp.setBackground(lightGreyBr));
		btGraphOp.setOnMouseExited(e -> btGraphOp.setBackground(darkGreyBr));
		
		////Text Fields////
		tfXRot.setOnMouseClicked(e -> tfXRot.clear());	//Clears the TextField when selected
		tfYRot.setOnMouseClicked(e -> tfYRot.clear());
		tfZRot.setOnMouseClicked(e -> tfZRot.clear());
		tfWRot.setOnMouseClicked(e -> tfWRot.clear());
		tfXVel.setOnMouseClicked(e -> tfXVel.clear());
		tfYVel.setOnMouseClicked(e -> tfYVel.clear());
		tfZVel.setOnMouseClicked(e -> tfZVel.clear());
		tfWVel.setOnMouseClicked(e -> tfWVel.clear());
		tfI.setOnMouseClicked(e -> tfI.clear());
		tfRA.setOnMouseClicked(e -> tfRA.clear());
		tfE.setOnMouseClicked(e -> tfE.clear());
		tfAP.setOnMouseClicked(e -> tfAP.clear());
		tfMA.setOnMouseClicked(e -> tfMA.clear());
		tfMM.setOnMouseClicked(e -> tfMM.clear());
		tfPassDuration.setOnMouseClicked(e -> tfPassDuration.clear());
		tfOTime.setOnMouseClicked(e -> tfOTime.clear());
		tfSR.setOnMouseClicked(e -> tfSR.clear());
		
		////Graph Button////
		btGraph.setOnMouseEntered(e -> btGraph.setBackground(lightGreyBr));	//Change Button Color on mouse hover
		btGraph.setOnMouseExited(e -> btGraph.setBackground(darkGreyBr));
		btGraph.setOnMouseClicked(e -> {									//If A selection has been made from the Graph ComboBox
			if(graphBox.getValue() != null) {								//Graph the selected data
				new Graph(graphBox.getValue(), this);
			}
			else {
				System.err.println("ERROR: INVALID GRAPH SELECTION.");
				this.print("ERROR: INVALID GRAPH SELECTION.");
			}
		});
		
		////Run Button////
		btRun.setOnMouseEntered(e -> btRun.setBackground(lightGreyBr));//Change Button Color on mouse hover
		btRun.setOnMouseExited(e -> btRun.setBackground(darkGreyBr));
		btRun.setOnMouseClicked(e -> run());
		
		////TLE Button///
		btTLE.setOnMouseEntered(e -> btTLE.setBackground(lightGreyBr));
		btTLE.setOnMouseExited(e -> btTLE.setBackground(darkGreyBr));
	}//end assignBehavior
	
	/** This Method Populates the Simulation Object ComboBox **/
	public void loadObjects() {
		String [] paths = ResourceLoader.loadPaths("res/models");
		System.out.println("--------------------Simulation Models--------------------");
		this.print("--------------------Simulation Models--------------------");
		
		for(String path : paths) {
			String file = Paths.get(path).getFileName().toString();
			String [] tokens = file.split("\\.");
			
			if(!tokens[1].equalsIgnoreCase("SATT")) {
				continue;
			}
			else {
				simObjects.add(tokens[0]);
				System.out.println("Model Loaded: " + tokens[0]);
				this.print("Model Loaded: " + tokens[0]);
			}
		}
		System.out.println("---------------------------------------------------------");
		this.print("---------------------------------------------------------");	
	}//end loadObjects
	
	/** Clears SimObjects From ComboBox **/
	public void clearObjects() {
		simObjects.clear();
		System.out.println("Object Data Cleared...");
		this.print("Object Data Cleared...");
	}
	
	/**
	 * Loads the names and file locations of
	 * every simulation saved in the data folder
	 * and adds them to the HashMap to be displayed
	 * in the comboBox.
	 */
	public void loadSimulations() {
		String [] paths = ResourceLoader.loadPaths("res/data");
		
		System.out.println("---------------------Simulation Data---------------------");
		this.print("---------------------Simulation Data---------------------");
		
		for(String path : paths) {
			// Remove All SubDirectory Names //
			String name = Paths.get(path).getFileName().toString();
			
			// Remove File Extension //
			name = name.substring(0, name.indexOf("."));
			simulationList.add(name);
			System.out.println("Simulation Data Loaded: " + name);
			this.print("Simulation Data Loaded: " + name);
		}
		System.out.println("---------------------------------------------------------");
		this.print("---------------------------------------------------------");
	}//end loadSimulations
	
	/** Clears the Current List of simulations */
	public void clearSimulations() {
		simulationList.clear();
		System.out.println("Simulation Data Cleared...");
		this.print("Simulation Data Cleared...");
	}//end clearSimulations
	
	/**
	 * Creates a new Simulation given
	 * the user defined parameters
	 * from the GUI
	 */
	public void run() {
		
		boolean error = false;
		
		float xRot, yRot, zRot, rotAngle;
		float xVel, yVel, zVel, velAngle;
		
		// Default Initialization //
		xRot = yRot = zRot = rotAngle = 0;
		xVel = yVel = zVel = velAngle =  0;
		simTime = 0;
		
		// Read Values From GUI //
		try {
			//Get Rotation Parameters
			xRot = Float.parseFloat(tfXRot.getText());
			yRot = Float.parseFloat(tfYRot.getText());
			zRot = Float.parseFloat(tfZRot.getText());
			rotAngle = Float.parseFloat(tfWRot.getText());
			xVel = Float.parseFloat(tfXVel.getText());
			yVel = Float.parseFloat(tfYVel.getText());
			zVel = Float.parseFloat(tfZVel.getText());
			velAngle = Float.parseFloat(tfWVel.getText());
			//Live Graph Scale Factor
			scaleFactor = 0.00005f;
			
			//Pass Duration
			simTime = Integer.parseInt(tfPassDuration.getText());
			//Sample Rate
			if(tfSR.getText() != null && !tfSR.getText().trim().equals("") && !tfSR.getText().equals("Sample Rate [Hz]")) {
				sampleRate = Integer.parseInt(tfSR.getText());
			}
			else {
				sampleRate = 5;	//Default Sample Rate is 5Hz
			}
			System.out.println("Simulation Parameters Loaded...");
			this.print("Simulation Parameters Loaded...");
		} catch(Exception e) {
			System.err.println("ERROR: COULD NOT PARSE VALUES FROM TEXTFIELD(S)");
			this.print("ERROR: COULD NOT PARSE VALUES FROM TEXTFIELD(S)");
			error = true;
		}
		
		// If Values Were Parsed Correctly, Create a new Simulation //
		if(!error) {
			if(!running) {
				dataPoints = new ArrayList<Point2f>();	//Initialize or Reset DataPoints
				Simulation sim = new Simulation(simTime, this, sampleRate);//Create and initialize new Simulation ***** Change to include sample rate!
				SimObject object = null;
				
				try {
					// Select Object Type Based On ComboBox //
					object = ResourceLoader.loadSat(objectBox.getValue() + ".SATT").get(0);
					
					System.out.println(object + " Successfully Created...");
					this.print(object + " Successfully Created...");
				} catch(Exception e) {
					System.err.println("ERROR: OBJECT SELECTION NOT VALID.");
					e.printStackTrace();
				}
				
				// Add Object and Run the Simulation //
				if(object != null) {
					
					// Aliasing Warning //
					if(xVel >= 2.5 || yVel >= 2.5 || zVel >= 2.5) { //Change values for user defined sample rate! (Passed in to Simulation constructor)
						System.err.println("WARNING: HIGH ANGULAR VELOCITIES. POTENTIAL DATA CORRUPTION DUE TO ALIASING.");
						this.print("WARNING: HIGH ANGULAR VELOCITIES. POTENTIAL DATA CORRUPTION DUE TO ALIASING.");
					}
					
					sim.addObject(object, new Vector3f(xRot, yRot, zRot), rotAngle, new Vector3f(xVel, yVel, zVel), velAngle);//Add object to the simulation
					sim.run();//Run the simulation
					this.stage.requestFocus();//Allows User Input on Both Simulation and GUI
				}
				else {
					// Terminate the Simulation if no object //
					sim.terminate();
				}
			}
			else {
				System.err.println("ERROR: CANNOT RUN MULTIPLE SIMULATIONS AT ONCE.");
			}
		}
	}//end run
	
	/**
	 * Saves the Current Brightness Data as a text
	 * file in the data sub-directory
	 */
	public void saveData() {
		// Create File Name and Path //
		String path = "res/data/";
		path += "Simulation" + (this.getSimulationList().size() + 1) + ".txt";
		
		// Create File //
		File dataFile = new File(path);
		
		try {
			FileWriter fr = new FileWriter(dataFile);
			
			if(dataPoints.size() == 0) {fr.close(); throw new Exception();}
			
			// Write Data To File //
			for(Point2f point : this.dataPoints) {
				fr.write(point.getX() + " " + point.getY() + "\n");
			}
			fr.close();
			System.out.println("DATA SAVED: " + path);
			this.print("DATA SAVED: " + path);
			
		} catch (Exception e) {
			System.err.println("WARNING: FAILED TO SAVE SIMULATION DATA");
			this.print("WARNING: FAILED TO SAVE SIMULATION DATA");
		}
		this.clearSimulations();//clear simulations so files are not show more than once
		this.loadSimulations();//Updates ComboBox in GUI
	}//end saveData
	
	/**
	 * Runs the GUI
	 * Overridden from Application class.
	 */
	public void start(Stage primaryStage) {
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		
		//Key Event Handling
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER){run();}
			}
		});
		
		//Scroll Event Handling
		scene.setOnScroll(new EventHandler<ScrollEvent>() {
			public void handle(ScrollEvent event) {
				scaleFactor += event.getDeltaY()/10000000.0;
			}
		});
		
		stage.setScene(scene);
		stage.sizeToScene(); 		//sets window size to the size of the scene.
		stage.setTitle("SLRA");		//Satellite light Reflection Analyzer.
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:res/images/SatLogo.png"));	//Does not produce an error if Icon file is unavailable.	
		stage.show();
	}//end start
	
	public static void main(String [] args) {
		launch(args);
	}//end main
	
	/** Print to Console **/
	public void print(String string) {
		consoleText += ("\n" + string);
		consoleLabel.setText(consoleText);
	}
	/** Add Point to Brightness Data **/
	public void addPoint(Point2f point) {
		this.dataPoints.add(point);
	}
	
	/** Updates the Live Graph **/
	public void graph() {
		
		liveGraph.getChildren().clear();
		
		Point2f lastPoint = null;
		Circle dot;
		
		for(Point2f point : dataPoints) {
			//Dot Coordinates
			float x = (point.getX() / (simTime * 1000)) * (float)liveGraph.getWidth();
			float y = (float)liveGraph.getHeight() * (1 - ((point.getY() / scaleFactor)));// Subtract from height b/c coordinate system is inverted. (i.e. Up is Down)
			
			//Graph Dot//
			dot = new Circle();
			dot.setRadius(2);
			dot.setCenterX(x);
			dot.setCenterY(y);
			
			// Set Color //
			dot.setFill(Color.AQUA);
			dot.setStroke(Color.AQUA);
			
			liveGraph.getChildren().add(dot);
			
			if(lastPoint != null) {
				Line line = new Line(x, y, lastPoint.getX(), lastPoint.getY());
				line.setFill(Color.AQUA);
				line.setStroke(Color.AQUA);	
				liveGraph.getChildren().add(line);
			}
			//Set Last Point
			lastPoint = new Point2f(x, y);
		}
	}//end graph
	
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
	
	public int getX() {
		return (int)stage.getX();
	}
	
	public int getY() {
		return (int)stage.getY();
	}
}//end class
