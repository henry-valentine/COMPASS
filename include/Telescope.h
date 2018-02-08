/* INSERT STANDARD FILE HEADER COMMENT HERE */
/* SEE OTHER FILES FOR EXAMPLES             */

#ifndef TELESCOPE_H
#define TELESCOPE_H

#include <Ogre.h>

using namespace Ogre;

class Telescope
{

public:

	/* Constructor Destructor */
		// Takes in ScnMngr as argument. Use Scene Manager to Create the Camera and the Camera Node. (Similar to the Scene Node in the Satellite Class)
		// Attach Camera to the Camera Node (See the Simulation.cpp Class Line 50)
		// Set Autoaspect ratio and near-clip distance (See Simulation.cpp Line 45-47 


	/* Update */
	// Update the look vector using the LookAt() function Below. 
	// Takes the Satellite Position Vector as an argument

	/* Look At */
	// Takes a Vector3 as an argument and looks at that point. See Simulation.cpp line 168

	/* Getters and Setters */
	// For All instance Variables

private:

	/* Instance Variables */
	// Ogre Camera
	// Ogre Scene Node
	// Vector3 m_pos
	// Vector3 for Looking Direction. (Update the Looking Direction of the camera node when Getters and Setters are called -> see Simulation.cpp line 168)

};

#endif // TELESCOPE_H
