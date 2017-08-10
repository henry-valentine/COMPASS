#ifndef GLWIDGET_H
#define GLWIDGET_H

#include <QOpenGLWidget>
#include <QOpenGLFunctions>

class GLWidget : public QOpenGLWidget, protected QOpenGLFunctions
{
public:
    GLWidget(QWidget *parent);

    void initializeGL();
    void paintGL();
    void resizeGL(int w, int h);
};

#endif // GLWIDGET_H
