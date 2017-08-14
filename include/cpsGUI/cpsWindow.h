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

#ifndef CPSWINDOW_H
#define CPSWINDOW_H

#include <QMainWindow>
#include <QTimer>

namespace Ui {
class CpsWindow;
}

class CpsWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit CpsWindow(QWidget *parent = 0);
    ~CpsWindow();

private slots:
    void on_exitButton_released();

private:
    Ui::CpsWindow *ui;
    QTimer timer;
    void update();
};

#endif // CPSWINDOW_H
