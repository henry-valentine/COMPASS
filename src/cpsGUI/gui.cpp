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

#include "include/cpsGUI/gui.h"
#include "ui_gui.h"

GUI::GUI(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::GUI)
{
    ui->setupUi(this);
}

GUI::~GUI()
{
    delete ui;
}

// GUI Event Handling
void GUI::on_exitButton_released()
{
    this->close();
}
