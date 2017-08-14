/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: gui.cpp
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * Contains the implementation of GUI
 ********************************************************/

#include "include/cpsGUI/cpsWindow.h"
#include "ui_CpsWindow.h"

CpsWindow::CpsWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::CpsWindow)
{
    ui->setupUi(this);

    // Update Loop
    connect(&timer, SIGNAL(timeout()), this, SLOT(update()));
    timer.start(16); // 60 fps
}

CpsWindow::~CpsWindow()
{
    delete ui;
}

void CpsWindow::update()
{
    ui->CpsSim->update();
    // Update Graph
}

// GUI Event Handling
void CpsWindow::on_exitButton_released()
{
    this->close();
}
