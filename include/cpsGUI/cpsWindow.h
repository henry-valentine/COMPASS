/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: cpsWindow.h
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * The CpsWindow class represents the window containing
 * the user interface and OpenGL Widget of this program.
 ********************************************************/

#ifndef CPSWINDOW_H
#define CPSWINDOW_H

namespace Ui {
class CpsWindow;
}

#include <QMainWindow>
#include <QTimer>

class CpsWindow : public QMainWindow
{
    Q_OBJECT

public:
    /** Constructor **/
    explicit CpsWindow(QWidget *parent = 0);
    ~CpsWindow();

private slots:
    /**
     * Update method called with each iteration
     * of the QTimer.
     */
    void update();

    /** Button Slots **/
    void on_exitButton_released();

    void on_runButton_released();

    void on_stopButton_released();

private:
    /** Object Representing UI Components **/
    Ui::CpsWindow *ui;

    /** Update Timer **/
    QTimer timer;

};

#endif // CPSWINDOW_H
