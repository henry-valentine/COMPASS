************************************* Satellite Light Reflection Analyzer *************************************
	Author: Henry Valentine, Embry-Riddle Aernonautical University
	Current Version: 0.9.1
	Version Date: 12/12/2016
	Copyright © 2016, Henry Valentine
	
	PURPOSE:
		- This program simulates light interactions with 3D satellite models and calculates brightness levels as perceived
		  from a specific view-point. User input, accessed via the UI, is used to establish the satellites orientation
		  and angular velocity as well as the duration of the simulated pass (i.e. data collection period). Brightness data
		  is collected at regular intervals and logged in a text file. Data collections may be selected and graphed via the UI.
	
	INSTRUCTIONS:
		RUNNING THE PROGRAM
		- To run this program, simply double click on the SLRA.exe file in this directory. Alternatively, you may double click on the
		  SLRA.jar file in this directory or type "Java -jar SLRA.jar" in the command line once this directory has been selected. (Doing
		  so allows you to see real-time status updates from the software)
		INITIALIZING A SIMULATION  
		- Once this program is executed, a Graphical User Interface (GUI) should appear in a new window. To run a new SLRA simulation,
 		  begin by selecting a menu item from the drop-down box labelled "Sim Objects." Next, fill in the text fields below labelled
		  "X Rotation" and "X Velocity" with the desired initial rotation about the X axis in degrees and the angular velocity of the object
		  about the X axis in Hertz (Revolutios per second). Do the same for the Y and Z paremters (Note: Do not leave any fields blank. 
		  If you do not wish for there to be an angular displacement or velocity about a given axis, simply insert a "0" into the textfield). 
		  After this, enter the duration of the simulation in seconds in the "Pass Duration" textfield and click "Run" to begin the simulation.
		RUNNING A SIMULATION  
		- While the simulation is running, you may press the Space Bar at any time to pause the simulation (Note: this will have no affect on 
		  the data) or press the Escape key to end the simulation (Note: Data will still be saved if the simulation is ended prematurely). The
		  simulation will, otherwise, run throughput the length of its specified duration. Once the pass duration is reached, the simulation
		  will automatically terminate and save the collected brightness data to a new file in the "SLRA/res/data" directory. Upon ending the
		  simulation, the program updates the data files available to graph automatically so the program does not need to be reloaded to access
		  recent data.
		GRAPHING  
		- In order to display the brightness data of any given simulation in a graphical format, select the desired simulation from the drop-box
		  labelled "Sim Graph." Next, click the "Graph" button and a new window should appear plotting the brightness data (vertical axis) against
		  the time its was collected (horizontal axis). (Note: Data Sets are automatically scaled to fill the graphing window)
		TERMINATING THE PROGRAM
		- To end the program, simply click on the "X" symbol in the upper right hand corner of the window. All data will be mainted in the 
		  "SLRA/res/data" directory and will not be lost on termination of the program.
		  
	FUTURE UPDATES:
		- More research on Rendering equation and Genetic Algorithms*******
    	- Fix SimObject Rotations 
    		- Make more Realistic 
    		- Euler rotation theorem
    		- User rotation x,y,z to create a single axis
			- Include option for rotational acceleration? (Probably not...)
		- Make light source size accurate.
		- Edit shader programs (Remove ambient light and other stuff...)
		- Fix SimObject Rotations --> Make more Realistic
		- Add support for STL files
		- print a "pause" message
		- represent xRot, yRot... with vectors instead
		- UI Error Messages - Pop-up boxes or printing somewhere
		- Migrate Brightness calculations to Shader Program
		- Add ChildObject class whose position and orientation are defined by a parent SimObject (In progress) 
			- Add support for child objects in Simulation class (ArrayList with multiple objects)
		- Apply genetic algorithms to derive orientation from a given light curve
		- Create option to run and observe a single simulation, 
		  or run multiple (without rendering them) based on a genetic algorithm
		- Update shader to improve accuracy
			- Render Objects casting shadows on themselves and other objects
			- Assign specular intensity and power values to accurately model sunlight
		- Change aspect ratio to immitate telescope?
		- Change data collection interval to match telescope's?
		- Update graphing utility
			- Add graduations
			- Add User Defined Graph Scale
		- Make a "Save As" button. Choose whether to save or not after each sim (Default name is SimulationN) (Whatever number)
		- Option to run a single simulation at a time or run algorithm given a light curve. 
			- (Parameters for algorithm --> Save top x% of simulations, run to within x% of actual)
		- User defined sample rate (data)interval --> Warnings for potential aliasing
		- Add more error messages
		- consider atmospheric effects
		
		Version 1.0
			- Import brightness curve data and use a genetic algorithm, running multiple simulations to narrow in on the behavior and configuration
			  of the real-world object.
			- Run multiple simulations of the same angular positions and velocities and average results for better accuracy?? 
		  Or create the option to do so... This would make the simulations take way longer
		
	UPDATE HISTORY:
		- 0.9.1 : Bug fixes. Code tidying. Updated angular velocity input units to Hertz (revolutions per second)
		- 0.9.0 : Initial export. Simulations created one at a time and rendered in a separate window. Graphing Utilities implemented.
		
	KNOWN BUGS:
		- Using the Escape key to end a simulation prevents a new one from being created [RESOLVED : 0.9.1]
	
	EXTERNAL LIBRARIES:
		**See Respective Websites for Licensing Agreements**
		- LWJGL (Lightweight Java Game Library) : https://lwjgl.org/
		- OpenGL : https://www.opengl.org/
		- GLFW : http://www.glfw.org/
			
	REFERENCES:
		- OpenGL-based 3D engine inspired by thebennybox youtube tutorials : 
		  https://www.youtube.com/user/thebennybox (See project folder for license)
		- Heiko Brumme's Texture Class for LWJGL 3 Compatibility (Under MIT License)
		- Web-based PNG to ICON converter: http://convertico.com/
		- Web-based STL to OBJ converter: http://www.greentoken.de/onlineconv/
	
	FURTHER READING:
		- Rendering Equation - http://x86.cs.duke.edu/courses/cps124/fall09/notes/16_rendering/p143-kajiya.pdf
		- Euler's Theorem - http://vmm.math.uci.edu/PalaisPapers/EulerFPT.pdf
	
	NOTES:
		- Program Documentation is included in the SLRA/doc directory (javadoc and UML)
	
	SOFTWARE LICENSE EXTENSION:
		- No rights reserved as of or prior to the 12/12/2016 release of this software. (Version 0.9.1)
		- Modify or redistrubite this work at your own discression provided that:
			- This license is redistributed along with the software itself
			- Any modifications to the software are documented within the source code and 
			  stated to be the work of the contributing author.
			- The author of this software (Henry Valentine) is credited with the 
			  original development of this product and referenced in any copies and/or
			  modifications of this work.
			- thebennybox is credited for the sole development of any software components on which "thebennybox" is
			  the only author.
		- All other licensing terms are discussed in the LICENSE.txt file within the SLRA folder
			  
***************************************************************************************************************