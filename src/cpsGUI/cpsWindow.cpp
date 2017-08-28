/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Copyright ©, 2017 Embry-Riddle Aeronautical University
 *
 * File: cpsWindow.cpp
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * Contains the implementation of CpsWindow
 ********************************************************/

#include <QFile>
#include "include/cpsGUI/cpsWindow.h"
#include "ui_CpsWindow.h"

CpsWindow::CpsWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::CpsWindow)
{
    // Initialize Window and UI //
    ui->setupUi(this);
    setWindowFlags(Qt::CustomizeWindowHint | Qt::FramelessWindowHint);

    // Update Loop //
    connect(&timer, SIGNAL(timeout()), this, SLOT(update()));
    timer.start(16); // 60 fps
}

CpsWindow::~CpsWindow()
{
    delete ui;
}

void CpsWindow::update()
{
    ui->cpsSim->update();
    // Update Graph
}

/** GUI Event Handling **/
void CpsWindow::on_runButton_released()
{
    timer.stop();
    //ui->CpsSim->initializeSim();
    connect(&timer, SIGNAL(timeout()), this, SLOT(update()));
    timer.start(1000); // Restart timer here according to simulation parameters. 60fps or as fast as possible. Set to 0 for fast
}

void CpsWindow::on_stopButton_released()
{

}

void CpsWindow::on_exitButton_released()
{
    this->close();
}
