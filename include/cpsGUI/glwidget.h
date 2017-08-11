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
 * contains the OpenGL contect for this program.
 ********************************************************/

#ifndef GLWIDGET_H
#define GLWIDGET_H

#include <QOpenGLWidget>
#include <QOpenGLFunctions>
#include <QTimer>

class GLWidget : public QOpenGLWidget, protected QOpenGLFunctions
{
public:
    GLWidget(QWidget *parent);

    void initializeGL();
    void paintGL();
    void resizeGL(int w, int h);

private:
    QTimer timer;
};

#endif // GLWIDGET_H
