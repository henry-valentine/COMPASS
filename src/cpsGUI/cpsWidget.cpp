/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: cpsWidget.cpp
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * Contains the implementation of CpsWidget
 ********************************************************/

#include "include/cpsGUI/cpsWidget.h"

CpsWidget::CpsWidget(QWidget *parent) :
    QOpenGLWidget(parent)
{
    // Constructor
}

void CpsWidget::initializeGL()
{
    // TODO: Set Up Rendering Context, Load Shaders, Load Resources, etc...
    initializeOpenGLFunctions();
    glClearColor(0, 0, 0, 1);
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_LIGHTING);
    glEnable(GL_COLOR_MATERIAL);
}

void CpsWidget::paintGL()
{
    // All the Rendering Code
    glClear(GL_COLOR_BUFFER_BIT);
}

void CpsWidget::resizeGL(int w, int h)
{
    // How the OpenGL widget handles a resize event
}

void CpsWidget::initializeSim()
{
    makeCurrent();// Must be called when using OpenGL functinos outside of initializeGl, paintGL, and resizeGL (These 3 call it automatically)
    glClearColor(0, 1, 1, 1);//TEMP
}
