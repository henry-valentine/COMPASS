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

#include <QtCharts/QChart>
#include <QtCharts/QLineSeries>

QT_CHARTS_USE_NAMESPACE

class CpsGraph : public QChart
{
    Q_OBJECT

public:
    /** Constructor **/
    CpsGraph(QGraphicsItem *parent = 0, Qt::WindowFlags wFlags = 0);
    ~CpsGraph();

    /** TODO **/
    void update();

    /** Instance Variables **/
    QLineSeries m_data;
};

#endif // CPSGRAPH_H
