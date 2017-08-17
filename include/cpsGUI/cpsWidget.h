/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: cpsWidget.h
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * The CpsWidget class represents the QT Widget that
 * contains the OpenGL context for this program.
 ********************************************************/

#ifndef CPSWIDGET_H
#define CPSWIDGET_H

#include <QOpenGLWidget>
#include <QOpenGLFunctions>

class CpsWidget : public QOpenGLWidget, protected QOpenGLFunctions
{
public:
    /** Constructor **/
    CpsWidget(QWidget *parent);

    /** Initialize OpenGL **/
    void initializeGL();

    /** Render a Frame **/
    void paintGL();

    /** Resize Action **/
    void resizeGL(int w, int h);

    /** Initialize a New Simulation **/
    void initializeSim();
};

#endif // CPSWIDGET_H
