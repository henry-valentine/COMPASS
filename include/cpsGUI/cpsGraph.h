/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Copyright ©, 2017 Embry-Riddle Aeronautical University
 *
 * File: cpsGraph.h
 *
 * @author Henry Valentine
 * @version 8/17/2017
 *
 * The CpsGraph class represents the widget containing
 * the live graph in the main window.
 ********************************************************/

#ifndef CPSGRAPH_H
#define CPSGRAPH_H

#include <QWidget>

class CpsGraph : public QWidget
{
public:
    CpsGraph(QWidget *parent);
};

#endif // CPSGRAPH_H
