/********************************************************
* Computational Photometry Analyzer for Small Satellites
* Copyright ©, 2017 Embry-Riddle Aeronautical University
*
* File: main.cpp
*
* @author Henry Valentine
* @version 8/11/2017
*
* Contains the implementation of main
*
********************************************************/

#include <iostream>
#include "Simulation.h"

int main(int argc, char **argv)
{
	try
	{
		Simulation sim = Simulation();
		sim.initSim();
		sim.run();

	}
	catch (const std::exception& e)
	{
		std::cerr << "Error occurred during execution: " << e.what() << '\n';
		return 1;
	}

	return 0;
}
