/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: glwidget.h
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * The GLWidget class represents the QT Widget that
 * contains the OpenGL context for this program.
 ********************************************************/

#ifndef CPSWIDGET_H
#define CPSWIDGET_H

#include <QOpenGLWidget>
#include <QOpenGLFunctions>

class CpsWidget : public QOpenGLWidget, protected QOpenGLFunctions
{
public:
    CpsWidget(QWidget *parent);

    void initializeGL();
    void paintGL();
    void resizeGL(int w, int h);
};

#endif // CPSWIDGET_H
