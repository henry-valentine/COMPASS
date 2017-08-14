/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: glwidget.cpp
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * Contains the implementation of GLWidget
 ********************************************************/

#include "include/cpsGUI/cpsWidget.h"

CpsWidget::CpsWidget(QWidget *parent) :
    QOpenGLWidget(parent)
{
    // Constructor
}

// Called once before the first paintGL or resizeGL call //
void CpsWidget::initializeGL()
{
    // Set Up Rendering Context, Load Shaders, Load Resources, etc...
    initializeOpenGLFunctions();
    glClearColor(0, 0, 0, 1);
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_LIGHTING);
    glEnable(GL_COLOR_MATERIAL);
}

// Called every time the widget is updated //
void CpsWidget::paintGL()
{
    // All the Rendering Code
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
}

// Called wheneber the widget is resized //
void CpsWidget::resizeGL(int w, int h)
{
    // How the OpenGL widget handles a resize event
}
