#include "include/cpsGUI/glwidget.h"


GLWidget::GLWidget(QWidget *parent) :
    QOpenGLWidget(parent)
{

}

void GLWidget::initializeGL()
{
    // Set Up Rendering Context, Load Shaders, Load Resources, etc...
    initializeOpenGLFunctions();
    glClearColor(0, 0, 0, 1);
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_LIGHTING);
    glEnable(GL_COLOR_MATERIAL);
}

void GLWidget::paintGL()
{
    // All the Rendering Code
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
}

void GLWidget::resizeGL(int w, int h)
{
    // How the OpenGL widget handles a resize event
}
