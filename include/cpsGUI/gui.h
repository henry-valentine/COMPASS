/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: gui.h
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * The GUI class contains the implementation of the QT
 * User Interface used within this program.
 ********************************************************/

#ifndef GUI_H
#define GUI_H

#include <QMainWindow>

namespace Ui {
class GUI;
}

class GUI : public QMainWindow
{
    Q_OBJECT

public:
    explicit GUI(QWidget *parent = 0);
    ~GUI();

private slots:
    void on_exitButton_released();

private:
    Ui::GUI *ui;
};

#endif // GUI_H
