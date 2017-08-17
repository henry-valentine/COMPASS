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
 *  - Create GUI Design
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
