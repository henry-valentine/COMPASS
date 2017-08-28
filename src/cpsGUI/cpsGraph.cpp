/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Copyright ©, 2017 Embry-Riddle Aeronautical University
 *
 * File: cpsGraph.cpp
 *
 * @author Henry Valentine
 * @version 8/17/2017
 *
 * Contains the implementation of CpsGraph
 *
 * TODO: Make the widget inherit the ChartView class? Then
 * add an instantiation of CpsGraph?
 *
 ********************************************************/

#include "include/cpsGUI/cpsGraph.h"

CpsGraph::CpsGraph(QGraphicsItem *parent, Qt::WindowFlags wFlags):
    QChart(QChart::ChartTypeCartesian, parent, wFlags)
{
    // TEMP //
    m_data.append(0,0);
    m_data.append(1,1);
    m_data.append(2,4);
    m_data.append(3,5);
    m_data.append(4,3);
    m_data.append(5,2);
    //////////

    legend()->hide();
    addSeries(&m_data);
    createDefaultAxes();

}

CpsGraph::~CpsGraph()
{

}

void CpsGraph::update()
{
    // TODO //
}
