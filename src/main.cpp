/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: main.cpp
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * Contains the implementation of main
 *
 *
 * TODO:
 *  - Create Comment Headers for each file. Create a standard header to use
 *  - Change Name of GUI class? My cause some issues/confusion, but I'm not sure...
 *  - Write out high-level program architecture: Consider primary functions and go from there...
 *  - Cereate GUI Design
 *  - include ui_gui.h and build folder to avoid issues?
 *  - Folders: cpsMath, cpsGUI, cpsRendering, cpsSimulation, cpsUtil, cpsSimObjects
 *
 ********************************************************/

#include "include/cpsGUI/cpsWindow.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    CpsWindow w;
    w.show();

    return a.exec();
}
