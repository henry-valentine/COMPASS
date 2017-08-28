/********************************************************************************
** Form generated from reading UI file 'CpsWindow.ui'
**
** Created by: Qt User Interface Compiler version 5.9.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CPSWINDOW_H
#define UI_CPSWINDOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QCheckBox>
#include <QtWidgets/QComboBox>
#include <QtWidgets/QFormLayout>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QProgressBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QRadioButton>
#include <QtWidgets/QScrollArea>
#include <QtWidgets/QSlider>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QToolBox>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>
#include "include/cpsGUI/cpsWidget.h"

QT_BEGIN_NAMESPACE

class Ui_CpsWindow
{
public:
    QWidget *centralWidget;
    QHBoxLayout *horizontalLayout;
    QVBoxLayout *menuLayout;
    QToolBox *menuToolBox;
    QWidget *satellitePage;
    QVBoxLayout *verticalLayout_4;
    QGroupBox *satelliteSelectionGroup;
    QFormLayout *formLayout_14;
    QLabel *label_13;
    QComboBox *comboBox_2;
    QLabel *label_14;
    QComboBox *comboBox_3;
    QPushButton *pushButton_4;
    QPushButton *pushButton_5;
    QGroupBox *satelliteInformationGroup;
    QFormLayout *formLayout_13;
    QLabel *label_15;
    QLineEdit *lineEdit_30;
    QLabel *label_16;
    QLineEdit *lineEdit_31;
    QLabel *label_17;
    QLabel *label_18;
    QLineEdit *lineEdit_32;
    QLabel *label_19;
    QLineEdit *lineEdit_33;
    QLabel *label_20;
    QLineEdit *lineEdit_34;
    QLabel *label_21;
    QLineEdit *lineEdit_35;
    QLabel *label_22;
    QLineEdit *lineEdit_36;
    QLabel *label_23;
    QLineEdit *lineEdit_37;
    QPushButton *satellitePreviewButton;
    QSpacerItem *verticalSpacer_7;
    QWidget *telescopePage;
    QVBoxLayout *verticalLayout_5;
    QGroupBox *telescopeSensorGroup;
    QFormLayout *formLayout;
    QLabel *label_25;
    QLineEdit *lineEdit_38;
    QSpacerItem *verticalSpacer;
    QWidget *graphPage;
    QVBoxLayout *verticalLayout_14;
    QGroupBox *graphScaleGroup;
    QFormLayout *formLayout_3;
    QLabel *label_28;
    QLineEdit *lineEdit_41;
    QSlider *horizontalSlider_17;
    QRadioButton *radioButton;
    QRadioButton *radioButton_2;
    QGroupBox *graphOptionsGroup;
    QFormLayout *formLayout_4;
    QCheckBox *checkBox_3;
    QCheckBox *checkBox_4;
    QGroupBox *graphLoadDataGroup;
    QVBoxLayout *verticalLayout_13;
    QComboBox *comboBox_5;
    QPushButton *pushButton_7;
    QPushButton *graphButton;
    QSpacerItem *verticalSpacer_6;
    QWidget *passPage;
    QVBoxLayout *verticalLayout_6;
    QGroupBox *runSimMode;
    QFormLayout *formLayout_15;
    QRadioButton *radioButton_11;
    QRadioButton *radioButton_12;
    QGroupBox *runRenderMode;
    QFormLayout *formLayout_16;
    QRadioButton *radioButton_13;
    QRadioButton *radioButton_14;
    QGroupBox *runTLEGroup;
    QFormLayout *formLayout_5;
    QLineEdit *lineEdit;
    QLabel *label_2;
    QPushButton *pushButton;
    QLineEdit *lineEdit_2;
    QLabel *label_3;
    QGroupBox *runObserverLocationGroup;
    QFormLayout *formLayout_6;
    QLabel *label_4;
    QLineEdit *lineEdit_3;
    QLabel *label_5;
    QLineEdit *lineEdit_4;
    QGroupBox *runObserverTimeGroup;
    QFormLayout *formLayout_7;
    QLabel *label_6;
    QLineEdit *lineEdit_5;
    QLabel *label_9;
    QLineEdit *lineEdit_14;
    QGroupBox *runRotationGrou;
    QFormLayout *formLayout_8;
    QLabel *label_7;
    QLabel *label_8;
    QLineEdit *lineEdit_6;
    QLineEdit *lineEdit_7;
    QLineEdit *lineEdit_8;
    QLineEdit *lineEdit_9;
    QLineEdit *lineEdit_10;
    QLineEdit *lineEdit_11;
    QLineEdit *lineEdit_12;
    QLineEdit *lineEdit_13;
    QProgressBar *runProgressBar;
    QSpacerItem *verticalSpacer_2;
    QWidget *manualControlsPage;
    QVBoxLayout *verticalLayout_7;
    QGroupBox *manualLightDirectionGroup;
    QFormLayout *formLayout_9;
    QLineEdit *lineEdit_15;
    QSlider *horizontalSlider;
    QLineEdit *lineEdit_16;
    QSlider *horizontalSlider_2;
    QLineEdit *lineEdit_17;
    QSlider *horizontalSlider_3;
    QGroupBox *manualAttitudeGroup;
    QFormLayout *formLayout_10;
    QLineEdit *lineEdit_18;
    QSlider *horizontalSlider_4;
    QLineEdit *lineEdit_19;
    QSlider *horizontalSlider_5;
    QLineEdit *lineEdit_20;
    QSlider *horizontalSlider_6;
    QLineEdit *lineEdit_21;
    QSlider *horizontalSlider_7;
    QGroupBox *manualAngularVelocityGroup;
    QFormLayout *formLayout_11;
    QLineEdit *lineEdit_22;
    QSlider *horizontalSlider_8;
    QLineEdit *lineEdit_23;
    QSlider *horizontalSlider_9;
    QLineEdit *lineEdit_24;
    QSlider *horizontalSlider_10;
    QLineEdit *lineEdit_25;
    QSlider *horizontalSlider_11;
    QGroupBox *manualAltitudeGroup;
    QFormLayout *formLayout_12;
    QLineEdit *lineEdit_26;
    QSlider *horizontalSlider_12;
    QGroupBox *manualCameraControlGroup;
    QHBoxLayout *horizontalLayout_2;
    QCheckBox *checkBox;
    QPushButton *resetCameraButton;
    QSpacerItem *verticalSpacer_3;
    QWidget *playbackPage;
    QVBoxLayout *verticalLayout_10;
    QGroupBox *groupBox_20;
    QFormLayout *formLayout_17;
    QRadioButton *radioButton_15;
    QRadioButton *radioButton_16;
    QGroupBox *playbackSimDataGroup;
    QVBoxLayout *verticalLayout_8;
    QComboBox *comboBox;
    QPushButton *pushButton_2;
    QGroupBox *playbackTimingGroup;
    QGridLayout *gridLayout;
    QLabel *label_11;
    QLabel *label_12;
    QLineEdit *lineEdit_28;
    QLineEdit *lineEdit_27;
    QLabel *label_10;
    QLineEdit *lineEdit_29;
    QSlider *horizontalSlider_13;
    QSlider *horizontalSlider_15;
    QGroupBox *groupBox_15;
    QVBoxLayout *verticalLayout_9;
    QCheckBox *checkBox_2;
    QPushButton *pushButton_6;
    QSpacerItem *verticalSpacer_4;
    QWidget *reconstructionPage;
    QVBoxLayout *verticalLayout_12;
    QGroupBox *reconstructionSimModeGroup;
    QHBoxLayout *horizontalLayout_3;
    QRadioButton *radioButton_17;
    QRadioButton *radioButton_18;
    QGroupBox *reconstructionSimDataGroup;
    QVBoxLayout *verticalLayout_11;
    QComboBox *comboBox_4;
    QPushButton *pushButton_3;
    QGroupBox *groupBox_4;
    QFormLayout *formLayout_2;
    QLabel *label_26;
    QLineEdit *lineEdit_39;
    QLineEdit *lineEdit_40;
    QLabel *label_27;
    QSlider *horizontalSlider_14;
    QSlider *horizontalSlider_16;
    QProgressBar *progressBar_2;
    QSpacerItem *verticalSpacer_5;
    QPushButton *runButton;
    QPushButton *stopButton;
    QPushButton *resetButton;
    QPushButton *exitButton;
    QVBoxLayout *simLayout;
    CpsWidget *cpsSim;
    QHBoxLayout *horizontalLayout_4;
    QLabel *CpsLogo;
    QVBoxLayout *GraphConsoleLayout;
    QWidget *cpsGraph;
    QScrollArea *consoleScrollArea;
    QWidget *consoleLayout;
    QVBoxLayout *verticalLayout;
    QLabel *console;

    void setupUi(QMainWindow *CpsWindow)
    {
        if (CpsWindow->objectName().isEmpty())
            CpsWindow->setObjectName(QStringLiteral("CpsWindow"));
        CpsWindow->setEnabled(true);
        CpsWindow->resize(1600, 900);
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(CpsWindow->sizePolicy().hasHeightForWidth());
        CpsWindow->setSizePolicy(sizePolicy);
        CpsWindow->setMinimumSize(QSize(1600, 900));
        CpsWindow->setMaximumSize(QSize(1600, 900));
        CpsWindow->setStyleSheet(QStringLiteral(""));
        centralWidget = new QWidget(CpsWindow);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        QSizePolicy sizePolicy1(QSizePolicy::Preferred, QSizePolicy::Preferred);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(centralWidget->sizePolicy().hasHeightForWidth());
        centralWidget->setSizePolicy(sizePolicy1);
        centralWidget->setMinimumSize(QSize(1600, 900));
        centralWidget->setMaximumSize(QSize(3000, 2000));
        centralWidget->setStyleSheet(QLatin1String("QToolTip\n"
"{\n"
"    border: 1px solid #76797C;\n"
"    background-color: rgb(90, 102, 117);;\n"
"    color: white;\n"
"    padding: 5px;\n"
"    opacity: 200;\n"
"}\n"
"\n"
"QWidget\n"
"{\n"
"    color: #eff0f1;\n"
"    background-color: #31363b;\n"
"    selection-background-color:#3daee9;\n"
"    selection-color: #eff0f1;\n"
"    background-clip: border;\n"
"    border-image: none;\n"
"    border: 0px transparent black;\n"
"    outline: 0;\n"
"}\n"
"\n"
"QWidget:item:hover\n"
"{\n"
"    background-color: #18465d;\n"
"    color: #eff0f1;\n"
"}\n"
"\n"
"QWidget:item:selected\n"
"{\n"
"    background-color: #18465d;\n"
"}\n"
"\n"
"QCheckBox\n"
"{\n"
"    spacing: 5px;\n"
"    outline: none;\n"
"    color: white;\n"
"    margin-bottom: 2px;\n"
"}\n"
"\n"
"QCheckBox:disabled\n"
"{\n"
"    color: #76797C;\n"
"}\n"
"\n"
"QCheckBox::indicator,\n"
"QGroupBox::indicator\n"
"{\n"
"    width: 18px;\n"
"    height: 18px;\n"
"}\n"
"QGroupBox::indicator\n"
"{\n"
"    margin-left: 2px;\n"
"}\n"
"\n"
"QCheckBox::indicator:"
                        "unchecked\n"
"{\n"
"    image: url(:/res/images/icon_checkbox_unchecked.png);\n"
"}\n"
"\n"
"QCheckBox::indicator:unchecked:hover,\n"
"QCheckBox::indicator:unchecked:focus,\n"
"QCheckBox::indicator:unchecked:pressed,\n"
"QGroupBox::indicator:unchecked:hover,\n"
"QGroupBox::indicator:unchecked:focus,\n"
"QGroupBox::indicator:unchecked:pressed\n"
"{\n"
"  border: none;\n"
"    image: url(:/res/images/icon_checkbox_unchecked_pressed.png);\n"
"}\n"
"\n"
"QCheckBox::indicator:checked\n"
"{\n"
"    image: url(:/res/images/icon_checkbox_checked.png);\n"
"}\n"
"\n"
"QCheckBox::indicator:checked:hover,\n"
"QCheckBox::indicator:checked:focus,\n"
"QCheckBox::indicator:checked:pressed,\n"
"QGroupBox::indicator:checked:hover,\n"
"QGroupBox::indicator:checked:focus,\n"
"QGroupBox::indicator:checked:pressed\n"
"{\n"
"  border: none;\n"
"    image: url(:/res/images/icon_checkbox_checked_pressed.png);\n"
"}\n"
"\n"
"\n"
"QCheckBox::indicator:indeterminate\n"
"{\n"
"    image: url(:/res/images/icon_checkbox_indeterminate.png);\n"
""
                        "}\n"
"\n"
"QCheckBox::indicator:indeterminate:focus,\n"
"QCheckBox::indicator:indeterminate:hover,\n"
"QCheckBox::indicator:indeterminate:pressed\n"
"{\n"
"    image: url(:/res/images/icon_checkbox_indeterminate_pressed.png);\n"
"}\n"
"\n"
"QCheckBox::indicator:checked:disabled,\n"
"QGroupBox::indicator:checked:disabled\n"
"{\n"
"    image: url(:/res/images/icon_checkbox_checked_disabled.png);\n"
"}\n"
"\n"
"QCheckBox::indicator:unchecked:disabled,\n"
"QGroupBox::indicator:unchecked:disabled\n"
"{\n"
"    image: url(:/res/images/cicon_checkbox_unchecked_disabled.png);\n"
"}\n"
"\n"
"QRadioButton\n"
"{\n"
"    spacing: 5px;\n"
"    outline: none;\n"
"    color: #eff0f1;\n"
"    margin-bottom: 2px;\n"
"}\n"
"\n"
"QRadioButton:disabled\n"
"{\n"
"    color: #76797C;\n"
"}\n"
"QRadioButton::indicator\n"
"{\n"
"    width: 21px;\n"
"    height: 21px;\n"
"}\n"
"\n"
"QRadioButton::indicator:unchecked\n"
"{\n"
"    image: url(:/res/images/radio_unchecked.png);\n"
"}\n"
"\n"
"\n"
"QRadioButton::indicator:unchecked:hover,"
                        "\n"
"QRadioButton::indicator:unchecked:focus,\n"
"QRadioButton::indicator:unchecked:pressed\n"
"{\n"
"    border: none;\n"
"    outline: none;\n"
"    image: url(:/res/images/radio_unchecked_focus.png);\n"
"}\n"
"\n"
"QRadioButton::indicator:checked\n"
"{\n"
"    border: none;\n"
"    outline: none;\n"
"    image: url(:/res/images/radio_checked.png);\n"
"}\n"
"\n"
"QRadioButton::indicator:checked:hover,\n"
"QRadioButton::indicator:checked:focus,\n"
"QRadioButton::indicator:checked:pressed\n"
"{\n"
"    border: none;\n"
"    outline: none;\n"
"    image: url(:/res/images/radio_checked_focus.png);\n"
"}\n"
"\n"
"QRadioButton::indicator:checked:disabled\n"
"{\n"
"    outline: none;\n"
"    image: url(:/res/images/radio_checked_disabled.png);\n"
"}\n"
"\n"
"QRadioButton::indicator:unchecked:disabled\n"
"{\n"
"    image: url(:/res/images/radio_unchecked_disabled.png);\n"
"}\n"
"\n"
"\n"
"QMenuBar\n"
"{\n"
"    background-color: #31363b;\n"
"    color: #eff0f1;\n"
"}\n"
"\n"
"QMenuBar::item\n"
"{\n"
"    background:"
                        " transparent;\n"
"}\n"
"\n"
"QMenuBar::item:selected\n"
"{\n"
"    background: transparent;\n"
"    border: 1px solid #76797C;\n"
"}\n"
"\n"
"QMenuBar::item:pressed\n"
"{\n"
"    border: 1px solid #76797C;\n"
"    background-color: #3daee9;\n"
"    color: #eff0f1;\n"
"    margin-bottom:-1px;\n"
"    padding-bottom:1px;\n"
"}\n"
"\n"
"QMenu\n"
"{\n"
"    border: 1px solid #76797C;\n"
"    color: #eff0f1;\n"
"    margin: 2px;\n"
"}\n"
"\n"
"QMenu::icon\n"
"{\n"
"    margin: 5px;\n"
"}\n"
"\n"
"QMenu::item\n"
"{\n"
"    padding: 5px 30px 5px 30px;\n"
"    border: 1px solid transparent; /* reserve space for selection border */\n"
"}\n"
"\n"
"QMenu::item:selected\n"
"{\n"
"    color: #eff0f1;\n"
"}\n"
"\n"
"QMenu::separator {\n"
"    height: 2px;\n"
"    background: lightblue;\n"
"    margin-left: 10px;\n"
"    margin-right: 5px;\n"
"}\n"
"\n"
"QMenu::indicator {\n"
"    width: 18px;\n"
"    height: 18px;\n"
"}\n"
"\n"
"/* non-exclusive indicator = check box style indicator\n"
"   (see QActionGroup::setExclusive) *"
                        "/\n"
"QMenu::indicator:non-exclusive:unchecked {\n"
"    image: url(:/res/images/checkbox_unchecked.png);\n"
"}\n"
"\n"
"QMenu::indicator:non-exclusive:unchecked:selected {\n"
"    image: url(:/res/images/checkbox_unchecked_disabled.png);\n"
"}\n"
"\n"
"QMenu::indicator:non-exclusive:checked {\n"
"    image: url(:/res/images/checkbox_checked.png);\n"
"}\n"
"\n"
"QMenu::indicator:non-exclusive:checked:selected {\n"
"    image: url(:/res/images/checkbox_checked_disabled.png);\n"
"}\n"
"\n"
"/* exclusive indicator = radio button style indicator (see QActionGroup::setExclusive) */\n"
"QMenu::indicator:exclusive:unchecked {\n"
"    image: url(:/res/images/radio_unchecked.png);\n"
"}\n"
"\n"
"QMenu::indicator:exclusive:unchecked:selected {\n"
"    image: url(:/res/images/radio_unchecked_disabled.png);\n"
"}\n"
"\n"
"QMenu::indicator:exclusive:checked {\n"
"    image: url(:/res/images/radio_checked.png);\n"
"}\n"
"\n"
"QMenu::indicator:exclusive:checked:selected {\n"
"    image: url(:/res/images/radio_checked_disable"
                        "d.png);\n"
"}\n"
"\n"
"QMenu::right-arrow {\n"
"    margin: 5px;\n"
"    image: url(:/res/images/right_arrow.png)\n"
"}\n"
"\n"
"\n"
"QWidget:disabled\n"
"{\n"
"    color: #454545;\n"
"    background-color: #31363b;\n"
"}\n"
"\n"
"QAbstractItemView\n"
"{\n"
"    alternate-background-color: #31363b;\n"
"    color: #eff0f1;\n"
"    border: 1px solid 3A3939;\n"
"    border-radius: 2px;\n"
"}\n"
"\n"
"QWidget:focus, QMenuBar:focus\n"
"{\n"
"    border: 1px solid #3daee9;\n"
"}\n"
"\n"
"QTabWidget:focus, QCheckBox:focus, QRadioButton:focus, QSlider:focus\n"
"{\n"
"    border: none;\n"
"}\n"
"\n"
"QLineEdit\n"
"{\n"
"    background-color: #232629;\n"
"    padding: 5px;\n"
"    border-style: solid;\n"
"    border: 1px solid #76797C;\n"
"    border-radius: 2px;\n"
"    color: #eff0f1;\n"
"}\n"
"\n"
"QAbstractItemView QLineEdit\n"
"{\n"
"    padding: 0;\n"
"}\n"
"\n"
"QGroupBox {\n"
"    border:1px solid #76797C;\n"
"    border-radius: 2px;\n"
"    margin-top: 20px;\n"
"}\n"
"\n"
"QGroupBox::title {\n"
"    subcontrol-"
                        "origin: margin;\n"
"    subcontrol-position: top center;\n"
"    padding-left: 10px;\n"
"    padding-right: 10px;\n"
"    padding-top: 10px;\n"
"}\n"
"\n"
"QAbstractScrollArea\n"
"{\n"
"    border-radius: 2px;\n"
"    border: 1px solid #76797C;\n"
"    background-color: transparent;\n"
"}\n"
"\n"
"QScrollBar:horizontal\n"
"{\n"
"    height: 15px;\n"
"    margin: 3px 15px 3px 15px;\n"
"    border: 1px transparent #2A2929;\n"
"    border-radius: 4px;\n"
"    background-color: #2A2929;\n"
"}\n"
"\n"
"QScrollBar::handle:horizontal\n"
"{\n"
"    background-color: #605F5F;\n"
"    min-width: 5px;\n"
"    border-radius: 4px;\n"
"}\n"
"\n"
"QScrollBar::add-line:horizontal\n"
"{\n"
"    margin: 0px 3px 0px 3px;\n"
"    border-image: url(:/res/images/right_arrow_disabled.png);\n"
"    width: 10px;\n"
"    height: 10px;\n"
"    subcontrol-position: right;\n"
"    subcontrol-origin: margin;\n"
"}\n"
"\n"
"QScrollBar::sub-line:horizontal\n"
"{\n"
"    margin: 0px 3px 0px 3px;\n"
"    border-image: url(:/res/images/left_arr"
                        "ow_disabled.png);\n"
"    height: 10px;\n"
"    width: 10px;\n"
"    subcontrol-position: left;\n"
"    subcontrol-origin: margin;\n"
"}\n"
"\n"
"QScrollBar::add-line:horizontal:hover,QScrollBar::add-line:horizontal:on\n"
"{\n"
"    border-image: url(:/res/images/right_arrow.png);\n"
"    height: 10px;\n"
"    width: 10px;\n"
"    subcontrol-position: right;\n"
"    subcontrol-origin: margin;\n"
"}\n"
"\n"
"\n"
"QScrollBar::sub-line:horizontal:hover, QScrollBar::sub-line:horizontal:on\n"
"{\n"
"    border-image: url(:/res/images/left_arrow.png);\n"
"    height: 10px;\n"
"    width: 10px;\n"
"    subcontrol-position: left;\n"
"    subcontrol-origin: margin;\n"
"}\n"
"\n"
"QScrollBar::up-arrow:horizontal, QScrollBar::down-arrow:horizontal\n"
"{\n"
"    background: none;\n"
"}\n"
"\n"
"\n"
"QScrollBar::add-page:horizontal, QScrollBar::sub-page:horizontal\n"
"{\n"
"    background: none;\n"
"}\n"
"\n"
"QScrollBar:vertical\n"
"{\n"
"    background-color: #2A2929;\n"
"    width: 15px;\n"
"    margin: 15px 3px 15px 3p"
                        "x;\n"
"    border: 1px transparent #2A2929;\n"
"    border-radius: 4px;\n"
"}\n"
"\n"
"QScrollBar::handle:vertical\n"
"{\n"
"    background-color: #605F5F;\n"
"    min-height: 5px;\n"
"    border-radius: 4px;\n"
"}\n"
"\n"
"QScrollBar::sub-line:vertical\n"
"{\n"
"    margin: 3px 0px 3px 0px;\n"
"    border-image: url(:/res/images/up_arrow_disabled.png);\n"
"    height: 10px;\n"
"    width: 10px;\n"
"    subcontrol-position: top;\n"
"    subcontrol-origin: margin;\n"
"}\n"
"\n"
"QScrollBar::add-line:vertical\n"
"{\n"
"    margin: 3px 0px 3px 0px;\n"
"    border-image: url(:/res/images/down_arrow_disabled.png);\n"
"    height: 10px;\n"
"    width: 10px;\n"
"    subcontrol-position: bottom;\n"
"    subcontrol-origin: margin;\n"
"}\n"
"\n"
"QScrollBar::sub-line:vertical:hover,QScrollBar::sub-line:vertical:on\n"
"{\n"
"\n"
"    border-image: url(:/res/images/up_arrow.png);\n"
"    height: 10px;\n"
"    width: 10px;\n"
"    subcontrol-position: top;\n"
"    subcontrol-origin: margin;\n"
"}\n"
"\n"
"\n"
"QScrollBar::"
                        "add-line:vertical:hover, QScrollBar::add-line:vertical:on\n"
"{\n"
"    border-image: url(:/res/images/down_arrow.png);\n"
"    height: 10px;\n"
"    width: 10px;\n"
"    subcontrol-position: bottom;\n"
"    subcontrol-origin: margin;\n"
"}\n"
"\n"
"QScrollBar::up-arrow:vertical, QScrollBar::down-arrow:vertical\n"
"{\n"
"    background: none;\n"
"}\n"
"\n"
"\n"
"QScrollBar::add-page:vertical, QScrollBar::sub-page:vertical\n"
"{\n"
"    background: none;\n"
"}\n"
"\n"
"QTextEdit\n"
"{\n"
"    background-color: #232629;\n"
"    color: #eff0f1;\n"
"    border: 1px solid #76797C;\n"
"}\n"
"\n"
"QPlainTextEdit\n"
"{\n"
"    background-color: #232629;;\n"
"    color: #eff0f1;\n"
"    border-radius: 2px;\n"
"    border: 1px solid #76797C;\n"
"}\n"
"\n"
"QHeaderView::section\n"
"{\n"
"    background-color: #76797C;\n"
"    color: #eff0f1;\n"
"    padding: 5px;\n"
"    border: 1px solid #76797C;\n"
"}\n"
"\n"
"QSizeGrip {\n"
"    image: url(:/res/images/sizegrip.png);\n"
"    width: 12px;\n"
"    height: 12px;\n"
"}\n"
""
                        "\n"
"\n"
"QMainWindow::separator\n"
"{\n"
"    background-color: #31363b;\n"
"    color: white;\n"
"    padding-left: 4px;\n"
"    spacing: 2px;\n"
"    border: 1px dashed #76797C;\n"
"}\n"
"\n"
"QMainWindow::separator:hover\n"
"{\n"
"\n"
"    background-color: #787876;\n"
"    color: white;\n"
"    padding-left: 4px;\n"
"    border: 1px solid #76797C;\n"
"    spacing: 2px;\n"
"}\n"
"\n"
"\n"
"QMenu::separator\n"
"{\n"
"    height: 1px;\n"
"    background-color: #76797C;\n"
"    color: white;\n"
"    padding-left: 4px;\n"
"    margin-left: 10px;\n"
"    margin-right: 5px;\n"
"}\n"
"\n"
"\n"
"QFrame\n"
"{\n"
"    border-radius: 2px;\n"
"    border: 1px solid #76797C;\n"
"}\n"
"\n"
"QFrame[frameShape=\"0\"]\n"
"{\n"
"    border-radius: 2px;\n"
"    border: 1px transparent #76797C;\n"
"}\n"
"\n"
"QStackedWidget\n"
"{\n"
"    border: 1px transparent black;\n"
"}\n"
"\n"
"QToolBar {\n"
"    border: 1px transparent #393838;\n"
"    background: 1px solid #31363b;\n"
"    font-weight: bold;\n"
"}\n"
"\n"
"QToolBar::ha"
                        "ndle:horizontal {\n"
"    image: url(:/res/images/Hmovetoolbar.png);\n"
"}\n"
"QToolBar::handle:vertical {\n"
"    image: url(:/res/images/Vmovetoolbar.png);\n"
"}\n"
"QToolBar::separator:horizontal {\n"
"    image: url(:/res/images/Hsepartoolbar.png);\n"
"}\n"
"QToolBar::separator:vertical {\n"
"    image: url(:/res/images/Vsepartoolbar.png);\n"
"}\n"
"QToolButton#qt_toolbar_ext_button {\n"
"    background: #58595a\n"
"}\n"
"\n"
"QPushButton\n"
"{\n"
"    color: #eff0f1;\n"
"    background-color: #31363b;\n"
"    border-width: 1px;\n"
"    border-color: #76797C;\n"
"    border-style: solid;\n"
"    padding: 5px;\n"
"    border-radius: 2px;\n"
"    outline: none;\n"
"}\n"
"\n"
"QPushButton:disabled\n"
"{\n"
"    background-color: #31363b;\n"
"    border-width: 1px;\n"
"    border-color: #454545;\n"
"    border-style: solid;\n"
"    padding-top: 5px;\n"
"    padding-bottom: 5px;\n"
"    padding-left: 10px;\n"
"    padding-right: 10px;\n"
"    border-radius: 2px;\n"
"    color: #454545;\n"
"}\n"
"\n"
"QPushButto"
                        "n:focus {\n"
"    background-color: #3daee9;\n"
"    color: white;\n"
"}\n"
"\n"
"QPushButton:pressed\n"
"{\n"
"    background-color: #3daee9;\n"
"    padding-top: -15px;\n"
"    padding-bottom: -17px;\n"
"}\n"
"\n"
"QComboBox\n"
"{\n"
"    selection-background-color: #3daee9;\n"
"    border-style: solid;\n"
"    border: 1px solid #76797C;\n"
"    border-radius: 2px;\n"
"    padding: 5px;\n"
"    min-width: 75px;\n"
"}\n"
"\n"
"QPushButton:checked{\n"
"    background-color: #76797C;\n"
"    border-color: #6A6969;\n"
"}\n"
"\n"
"QComboBox:hover,QPushButton:hover,QAbstractSpinBox:hover,QLineEdit:hover,QTextEdit:hover,QPlainTextEdit:hover,QAbstractView:hover,QTreeView:hover\n"
"{\n"
"    border: 1px solid #3daee9;\n"
"    color: #eff0f1;\n"
"}\n"
"\n"
"QComboBox:on\n"
"{\n"
"    padding-top: 3px;\n"
"    padding-left: 4px;\n"
"    selection-background-color: #4a4a4a;\n"
"}\n"
"\n"
"QComboBox QAbstractItemView\n"
"{\n"
"    background-color: #232629;\n"
"    border-radius: 2px;\n"
"    border: 1px solid #76797C;\n"
""
                        "    selection-background-color: #18465d;\n"
"}\n"
"\n"
"QComboBox::drop-down\n"
"{\n"
"    subcontrol-origin: padding;\n"
"    subcontrol-position: top right;\n"
"    width: 15px;\n"
"\n"
"    border-left-width: 0px;\n"
"    border-left-color: darkgray;\n"
"    border-left-style: solid;\n"
"    border-top-right-radius: 3px;\n"
"    border-bottom-right-radius: 3px;\n"
"}\n"
"\n"
"QComboBox::down-arrow\n"
"{\n"
"    image: url(:/res/images/down_arrow_disabled.png);\n"
"}\n"
"\n"
"QComboBox::down-arrow:on, QComboBox::down-arrow:hover,\n"
"QComboBox::down-arrow:focus\n"
"{\n"
"    image: url(:/res/images/down_arrow.png);\n"
"}\n"
"\n"
"QAbstractSpinBox {\n"
"    padding: 5px;\n"
"    border: 1px solid #76797C;\n"
"    background-color: #232629;\n"
"    color: #eff0f1;\n"
"    border-radius: 2px;\n"
"    min-width: 75px;\n"
"}\n"
"\n"
"QAbstractSpinBox:up-button\n"
"{\n"
"    background-color: transparent;\n"
"    subcontrol-origin: border;\n"
"    subcontrol-position: center right;\n"
"}\n"
"\n"
"QAbstractSpinBox:"
                        "down-button\n"
"{\n"
"    background-color: transparent;\n"
"    subcontrol-origin: border;\n"
"    subcontrol-position: center left;\n"
"}\n"
"\n"
"QAbstractSpinBox::up-arrow,QAbstractSpinBox::up-arrow:disabled,QAbstractSpinBox::up-arrow:off {\n"
"    image: url(:/res/images/up_arrow_disabled.png);\n"
"    width: 10px;\n"
"    height: 10px;\n"
"}\n"
"QAbstractSpinBox::up-arrow:hover\n"
"{\n"
"    image: url(:/res/images/up_arrow.png);\n"
"}\n"
"\n"
"\n"
"QAbstractSpinBox::down-arrow,QAbstractSpinBox::down-arrow:disabled,QAbstractSpinBox::down-arrow:off\n"
"{\n"
"    image: url(:/res/images/down_arrow_disabled.png);\n"
"    width: 10px;\n"
"    height: 10px;\n"
"}\n"
"QAbstractSpinBox::down-arrow:hover\n"
"{\n"
"    image: url(:/res/images/down_arrow.png);\n"
"}\n"
"\n"
"\n"
"QLabel\n"
"{\n"
"    border: 0px solid black;\n"
"}\n"
"\n"
"QTabWidget{\n"
"    border: 0px transparent black;\n"
"}\n"
"\n"
"QTabWidget::pane {\n"
"    border: 1px solid #76797C;\n"
"    padding: 5px;\n"
"    margin: 0px;\n"
"}\n"
"\n"
""
                        "QTabWidget::tab-bar {\n"
"    left: 5px; /* move to the right by 5px */\n"
"}\n"
"\n"
"QTabBar\n"
"{\n"
"    qproperty-drawBase: 0;\n"
"    border-radius: 3px;\n"
"}\n"
"\n"
"QTabBar:focus\n"
"{\n"
"    border: 0px transparent black;\n"
"}\n"
"\n"
"QTabBar::close-button  {\n"
"    image: url(:/res/images/close.png);\n"
"    background: transparent;\n"
"}\n"
"\n"
"QTabBar::close-button:hover\n"
"{\n"
"    image: url(:/res/images/close-hover.png);\n"
"    background: transparent;\n"
"}\n"
"\n"
"QTabBar::close-button:pressed {\n"
"    image: url(:/res/images/close-pressed.png);\n"
"    background: transparent;\n"
"}\n"
"\n"
"/* TOP TABS */\n"
"QTabBar::tab:top {\n"
"    color: #eff0f1;\n"
"    border: 1px solid #76797C;\n"
"    border-bottom: 1px transparent black;\n"
"    background-color: #31363b;\n"
"    padding: 5px;\n"
"    min-width: 50px;\n"
"    border-top-left-radius: 2px;\n"
"    border-top-right-radius: 2px;\n"
"}\n"
"\n"
"QTabBar::tab:top:!selected\n"
"{\n"
"    color: #eff0f1;\n"
"    background-colo"
                        "r: #54575B;\n"
"    border: 1px solid #76797C;\n"
"    border-bottom: 1px transparent black;\n"
"    border-top-left-radius: 2px;\n"
"    border-top-right-radius: 2px;    \n"
"}\n"
"\n"
"QTabBar::tab:top:!selected:hover {\n"
"    background-color: #3daee9;\n"
"}\n"
"\n"
"/* BOTTOM TABS */\n"
"QTabBar::tab:bottom {\n"
"    color: #eff0f1;\n"
"    border: 1px solid #76797C;\n"
"    border-top: 1px transparent black;\n"
"    background-color: #31363b;\n"
"    padding: 5px;\n"
"    border-bottom-left-radius: 2px;\n"
"    border-bottom-right-radius: 2px;\n"
"    min-width: 50px;\n"
"}\n"
"\n"
"QTabBar::tab:bottom:!selected\n"
"{\n"
"    color: #eff0f1;\n"
"    background-color: #54575B;\n"
"    border: 1px solid #76797C;\n"
"    border-top: 1px transparent black;\n"
"    border-bottom-left-radius: 2px;\n"
"    border-bottom-right-radius: 2px;\n"
"}\n"
"\n"
"QTabBar::tab:bottom:!selected:hover {\n"
"    background-color: #3daee9;\n"
"}\n"
"\n"
"/* LEFT TABS */\n"
"QTabBar::tab:left {\n"
"    color: #eff0f1;\n"
"    "
                        "border: 1px solid #76797C;\n"
"    border-left: 1px transparent black;\n"
"    background-color: #31363b;\n"
"    padding: 5px;\n"
"    border-top-right-radius: 2px;\n"
"    border-bottom-right-radius: 2px;\n"
"    min-height: 50px;\n"
"}\n"
"\n"
"QTabBar::tab:left:!selected\n"
"{\n"
"    color: #eff0f1;\n"
"    background-color: #54575B;\n"
"    border: 1px solid #76797C;\n"
"    border-left: 1px transparent black;\n"
"    border-top-right-radius: 2px;\n"
"    border-bottom-right-radius: 2px;\n"
"}\n"
"\n"
"QTabBar::tab:left:!selected:hover {\n"
"    background-color: #3daee9;\n"
"}\n"
"\n"
"\n"
"/* RIGHT TABS */\n"
"QTabBar::tab:right {\n"
"    color: #eff0f1;\n"
"    border: 1px solid #76797C;\n"
"    border-right: 1px transparent black;\n"
"    background-color: #31363b;\n"
"    padding: 5px;\n"
"    border-top-left-radius: 2px;\n"
"    border-bottom-left-radius: 2px;\n"
"    min-height: 50px;\n"
"}\n"
"\n"
"QTabBar::tab:right:!selected\n"
"{\n"
"    color: #eff0f1;\n"
"    background-color: #54575B;\n"
" "
                        "   border: 1px solid #76797C;\n"
"    border-right: 1px transparent black;\n"
"    border-top-left-radius: 2px;\n"
"    border-bottom-left-radius: 2px;\n"
"}\n"
"\n"
"QTabBar::tab:right:!selected:hover {\n"
"    background-color: #3daee9;\n"
"}\n"
"\n"
"QTabBar QToolButton::right-arrow:enabled {\n"
"     image: url(:/res/images/right_arrow.png);\n"
" }\n"
"\n"
" QTabBar QToolButton::left-arrow:enabled {\n"
"     image: url(:/res/images/left_arrow.png);\n"
" }\n"
"\n"
"QTabBar QToolButton::right-arrow:disabled {\n"
"     image: url(:/res/images/right_arrow_disabled.png);\n"
" }\n"
"\n"
" QTabBar QToolButton::left-arrow:disabled {\n"
"     image: url(:/res/images/left_arrow_disabled.png);\n"
" }\n"
"\n"
"\n"
"QDockWidget {\n"
"    background: #31363b;\n"
"    border: 1px solid #403F3F;\n"
"    titlebar-close-icon: url(:/res/images/close.png);\n"
"    titlebar-normal-icon: url(:/res/images/undock.png);\n"
"}\n"
"\n"
"QDockWidget::close-button, QDockWidget::float-button {\n"
"    border: 1px solid transparent;\n"
""
                        "    border-radius: 2px;\n"
"    background: transparent;\n"
"}\n"
"\n"
"QDockWidget::close-button:hover, QDockWidget::float-button:hover {\n"
"    background: rgba(255, 255, 255, 10);\n"
"}\n"
"\n"
"QDockWidget::close-button:pressed, QDockWidget::float-button:pressed {\n"
"    padding: 1px -1px -1px 1px;\n"
"    background: rgba(255, 255, 255, 10);\n"
"}\n"
"\n"
"QTreeView, QListView\n"
"{\n"
"    border: 1px solid #76797C;\n"
"    background-color: #232629;\n"
"}\n"
"\n"
"QTreeView:branch:selected, QTreeView:branch:hover\n"
"{\n"
"    background: url(:/res/images/transparent.png);\n"
"}\n"
"\n"
"QTreeView::branch:has-siblings:!adjoins-item {\n"
"    border-image: url(:/res/images/transparent.png);\n"
"}\n"
"\n"
"QTreeView::branch:has-siblings:adjoins-item {\n"
"    border-image: url(:/res/images/transparent.png);\n"
"}\n"
"\n"
"QTreeView::branch:!has-children:!has-siblings:adjoins-item {\n"
"    border-image: url(:/res/images/transparent.png);\n"
"}\n"
"\n"
"QTreeView::branch:has-children:!has-siblings:closed"
                        ",\n"
"QTreeView::branch:closed:has-children:has-siblings {\n"
"    image: url(:/res/images/branch_closed.png);\n"
"}\n"
"\n"
"QTreeView::branch:open:has-children:!has-siblings,\n"
"QTreeView::branch:open:has-children:has-siblings  {\n"
"    image: url(:/res/images/branch_open.png);\n"
"}\n"
"\n"
"QTreeView::branch:has-children:!has-siblings:closed:hover,\n"
"QTreeView::branch:closed:has-children:has-siblings:hover {\n"
"    image: url(:/res/images/branch_closed-on.png);\n"
"    }\n"
"\n"
"QTreeView::branch:open:has-children:!has-siblings:hover,\n"
"QTreeView::branch:open:has-children:has-siblings:hover  {\n"
"    image: url(:/res/images/branch_open-on.png);\n"
"    }\n"
"\n"
"QListView::item:!selected:hover, QTreeView::item:!selected:hover  {\n"
"    background: #18465d;\n"
"    outline: 0;\n"
"    color: #eff0f1\n"
"}\n"
"\n"
"QListView::item:selected:hover, QTreeView::item:selected:hover  {\n"
"    background: #287399;\n"
"    color: #eff0f1;\n"
"}\n"
"\n"
"QSlider::groove:horizontal {\n"
"    border: 1px so"
                        "lid #565a5e;\n"
"    height: 4px;\n"
"    background: #565a5e;\n"
"    margin: 0px;\n"
"    border-radius: 2px;\n"
"}\n"
"\n"
"QSlider::handle:horizontal {\n"
"    background: #232629;\n"
"    border: 1px solid #565a5e;\n"
"    width: 8px;\n"
"    height: 8px;\n"
"    margin: -8px 0;\n"
"    border-radius: 9px;\n"
"}\n"
"\n"
"QSlider::groove:vertical {\n"
"    border: 1px solid #565a5e;\n"
"    width: 4px;\n"
"    background: #565a5e;\n"
"    margin: 0px;\n"
"    border-radius: 3px;\n"
"}\n"
"\n"
"QSlider::handle:vertical {\n"
"    background: #232629;\n"
"    border: 1px solid #565a5e;\n"
"    width: 8px;\n"
"    height: 8px;\n"
"    margin: 0 -8px;\n"
"    border-radius: 9px;\n"
"}\n"
"\n"
"QToolButton {\n"
"    background-color: transparent;\n"
"    border: 1px transparent #76797C;\n"
"    border-radius: 2px;\n"
"    margin: 3px;\n"
"    padding: 5px;\n"
"}\n"
"\n"
"QToolButton[popupMode=\"1\"] { /* only for MenuButtonPopup */\n"
" padding-right: 20px; /* make way for the popup button */\n"
" border: 1px #7"
                        "6797C;\n"
" border-radius: 5px;\n"
"}\n"
"\n"
"QToolButton[popupMode=\"2\"] { /* only for InstantPopup */\n"
" padding-right: 10px; /* make way for the popup button */\n"
" border: 1px #76797C;\n"
"}\n"
"\n"
"\n"
"QToolButton:hover, QToolButton::menu-button:hover {\n"
"    background-color: transparent;\n"
"    border: 1px solid #3daee9;\n"
"    padding: 5px;\n"
"}\n"
"\n"
"QToolButton:checked, QToolButton:pressed,\n"
"        QToolButton::menu-button:pressed {\n"
"    background-color: #3daee9;\n"
"    border: 1px solid #3daee9;\n"
"    padding: 5px;\n"
"}\n"
"\n"
"/* the subcontrol below is used only in the InstantPopup or DelayedPopup mode */\n"
"QToolButton::menu-indicator {\n"
"    image: url(:/res/images/down_arrow.png);\n"
"    top: -7px; left: -2px; /* shift it a bit */\n"
"}\n"
"\n"
"/* the subcontrols below are used only in the MenuButtonPopup mode */\n"
"QToolButton::menu-button {\n"
"    border: 1px transparent #76797C;\n"
"    border-top-right-radius: 6px;\n"
"    border-bottom-right-radius: 6px;\n"
""
                        "    /* 16px width + 4px for border = 20px allocated above */\n"
"    width: 16px;\n"
"    outline: none;\n"
"}\n"
"\n"
"QToolButton::menu-arrow {\n"
"    image: url(:/res/images/down_arrow.png);\n"
"}\n"
"\n"
"QToolButton::menu-arrow:open {\n"
"    border: 1px solid #76797C;\n"
"}\n"
"\n"
"QPushButton::menu-indicator  {\n"
"    subcontrol-origin: padding;\n"
"    subcontrol-position: bottom right;\n"
"    left: 8px;\n"
"}\n"
"\n"
"QTableView\n"
"{\n"
"    border: 1px solid #76797C;\n"
"    gridline-color: #31363b;\n"
"    background-color: #232629;\n"
"}\n"
"\n"
"\n"
"QTableView, QHeaderView\n"
"{\n"
"    border-radius: 0px;\n"
"}\n"
"\n"
"QTableView::item:pressed, QListView::item:pressed, QTreeView::item:pressed  {\n"
"    background: #18465d;\n"
"    color: #eff0f1;\n"
"}\n"
"\n"
"QTableView::item:selected:active, QTreeView::item:selected:active, QListView::item:selected:active  {\n"
"    background: #287399;\n"
"    color: #eff0f1;\n"
"}\n"
"\n"
"\n"
"QHeaderView\n"
"{\n"
"    background-color: #31363b;\n"
""
                        "    border: 1px transparent;\n"
"    border-radius: 0px;\n"
"    margin: 0px;\n"
"    padding: 0px;\n"
"\n"
"}\n"
"\n"
"QHeaderView::section  {\n"
"    background-color: #31363b;\n"
"    color: #eff0f1;\n"
"    padding: 5px;\n"
"    border: 1px solid #76797C;\n"
"    border-radius: 0px;\n"
"    text-align: center;\n"
"}\n"
"\n"
"QHeaderView::section::vertical::first, QHeaderView::section::vertical::only-one\n"
"{\n"
"    border-top: 1px solid #76797C;\n"
"}\n"
"\n"
"QHeaderView::section::vertical\n"
"{\n"
"    border-top: transparent;\n"
"}\n"
"\n"
"QHeaderView::section::horizontal::first, QHeaderView::section::horizontal::only-one\n"
"{\n"
"    border-left: 1px solid #76797C;\n"
"}\n"
"\n"
"QHeaderView::section::horizontal\n"
"{\n"
"    border-left: transparent;\n"
"}\n"
"\n"
"\n"
"QHeaderView::section:checked\n"
" {\n"
"    color: white;\n"
"    background-color: #334e5e;\n"
" }\n"
"\n"
" /* style the sort indicator */\n"
"QHeaderView::down-arrow {\n"
"    image: url(:/res/images/down_arrow.png);\n"
"}\n"
"\n"
""
                        "QHeaderView::up-arrow {\n"
"    image: url(:/res/images/up_arrow.png);\n"
"}\n"
"\n"
"\n"
"QTableCornerButton::section {\n"
"    background-color: #31363b;\n"
"    border: 1px transparent #76797C;\n"
"    border-radius: 0px;\n"
"}\n"
"\n"
"QToolBox  {\n"
"    padding: 5px;\n"
"    border: none;\n"
"}\n"
"\n"
"QToolBox::tab {\n"
"    color: #eff0f1;\n"
"    background-color: #31363b;\n"
"    border-image: url(:/res/images/toolboxPage.png);\n"
"}\n"
"\n"
"QToolBox::tab:selected {\n"
"    font: italic;\n"
"    background-color: #31363b;\n"
"    border-image: url(:/res/images/toolboxPage_selected.png);\n"
" }\n"
"\n"
"QStatusBar::item {\n"
"    border: 0px transparent dark;\n"
" }\n"
"\n"
"\n"
"QFrame[height=\"3\"], QFrame[width=\"3\"] {\n"
"    background-color: #76797C;\n"
"}\n"
"\n"
"\n"
"QSplitter::handle {\n"
"    border: 1px dashed #76797C;\n"
"}\n"
"\n"
"QSplitter::handle:hover {\n"
"    background-color: #787876;\n"
"    border: 1px solid #76797C;\n"
"}\n"
"\n"
"QSplitter::handle:horizontal {\n"
"    width"
                        ": 1px;\n"
"}\n"
"\n"
"QSplitter::handle:vertical {\n"
"    height: 1px;\n"
"}\n"
"\n"
"QProgressBar {\n"
"    border: 1px solid #76797C;\n"
"    border-radius: 5px;\n"
"    text-align: center;\n"
"}\n"
"\n"
"QProgressBar::chunk {\n"
"    background-color: #05B8CC;\n"
"}\n"
"\n"
"QDateEdit\n"
"{\n"
"    selection-background-color: #3daee9;\n"
"    border-style: solid;\n"
"    border: 1px solid #3375A3;\n"
"    border-radius: 2px;\n"
"    padding: 1px;\n"
"    min-width: 75px;\n"
"}\n"
"\n"
"QDateEdit:on\n"
"{\n"
"    padding-top: 3px;\n"
"    padding-left: 4px;\n"
"    selection-background-color: #4a4a4a;\n"
"}\n"
"\n"
"QDateEdit QAbstractItemView\n"
"{\n"
"    background-color: #232629;\n"
"    border-radius: 2px;\n"
"    border: 1px solid #3375A3;\n"
"    selection-background-color: #3daee9;\n"
"}\n"
"\n"
"QDateEdit::drop-down\n"
"{\n"
"    subcontrol-origin: padding;\n"
"    subcontrol-position: top right;\n"
"    width: 15px;\n"
"    border-left-width: 0px;\n"
"    border-left-color: darkgray;\n"
"    borde"
                        "r-left-style: solid;\n"
"    border-top-right-radius: 3px;\n"
"    border-bottom-right-radius: 3px;\n"
"}\n"
"\n"
"QDateEdit::down-arrow\n"
"{\n"
"    image: url(:/res/images/down_arrow_disabled.png);\n"
"}\n"
"\n"
"QDateEdit::down-arrow:on, QDateEdit::down-arrow:hover,\n"
"QDateEdit::down-arrow:focus\n"
"{\n"
"    image: url(:/res/images/down_arrow.png);\n"
"}"));
        horizontalLayout = new QHBoxLayout(centralWidget);
        horizontalLayout->setSpacing(6);
        horizontalLayout->setContentsMargins(11, 11, 11, 11);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        menuLayout = new QVBoxLayout();
        menuLayout->setSpacing(6);
        menuLayout->setObjectName(QStringLiteral("menuLayout"));
        menuLayout->setContentsMargins(0, -1, -1, -1);
        menuToolBox = new QToolBox(centralWidget);
        menuToolBox->setObjectName(QStringLiteral("menuToolBox"));
        QSizePolicy sizePolicy2(QSizePolicy::Fixed, QSizePolicy::Expanding);
        sizePolicy2.setHorizontalStretch(0);
        sizePolicy2.setVerticalStretch(0);
        sizePolicy2.setHeightForWidth(menuToolBox->sizePolicy().hasHeightForWidth());
        menuToolBox->setSizePolicy(sizePolicy2);
        menuToolBox->setMinimumSize(QSize(200, 0));
        menuToolBox->setMaximumSize(QSize(200, 16777215));
        menuToolBox->setBaseSize(QSize(200, 0));
        satellitePage = new QWidget();
        satellitePage->setObjectName(QStringLiteral("satellitePage"));
        satellitePage->setGeometry(QRect(0, 0, 190, 557));
        verticalLayout_4 = new QVBoxLayout(satellitePage);
        verticalLayout_4->setSpacing(6);
        verticalLayout_4->setContentsMargins(11, 11, 11, 11);
        verticalLayout_4->setObjectName(QStringLiteral("verticalLayout_4"));
        verticalLayout_4->setContentsMargins(0, -1, 0, -1);
        satelliteSelectionGroup = new QGroupBox(satellitePage);
        satelliteSelectionGroup->setObjectName(QStringLiteral("satelliteSelectionGroup"));
        formLayout_14 = new QFormLayout(satelliteSelectionGroup);
        formLayout_14->setSpacing(6);
        formLayout_14->setContentsMargins(11, 11, 11, 11);
        formLayout_14->setObjectName(QStringLiteral("formLayout_14"));
        label_13 = new QLabel(satelliteSelectionGroup);
        label_13->setObjectName(QStringLiteral("label_13"));

        formLayout_14->setWidget(0, QFormLayout::LabelRole, label_13);

        comboBox_2 = new QComboBox(satelliteSelectionGroup);
        comboBox_2->setObjectName(QStringLiteral("comboBox_2"));
        comboBox_2->setMinimumSize(QSize(87, 25));
        comboBox_2->setMaximumSize(QSize(16777215, 25));

        formLayout_14->setWidget(0, QFormLayout::FieldRole, comboBox_2);

        label_14 = new QLabel(satelliteSelectionGroup);
        label_14->setObjectName(QStringLiteral("label_14"));

        formLayout_14->setWidget(1, QFormLayout::LabelRole, label_14);

        comboBox_3 = new QComboBox(satelliteSelectionGroup);
        comboBox_3->setObjectName(QStringLiteral("comboBox_3"));
        comboBox_3->setMinimumSize(QSize(87, 25));
        comboBox_3->setMaximumSize(QSize(16777215, 25));

        formLayout_14->setWidget(1, QFormLayout::FieldRole, comboBox_3);

        pushButton_4 = new QPushButton(satelliteSelectionGroup);
        pushButton_4->setObjectName(QStringLiteral("pushButton_4"));

        formLayout_14->setWidget(2, QFormLayout::SpanningRole, pushButton_4);

        pushButton_5 = new QPushButton(satelliteSelectionGroup);
        pushButton_5->setObjectName(QStringLiteral("pushButton_5"));

        formLayout_14->setWidget(3, QFormLayout::SpanningRole, pushButton_5);


        verticalLayout_4->addWidget(satelliteSelectionGroup);

        satelliteInformationGroup = new QGroupBox(satellitePage);
        satelliteInformationGroup->setObjectName(QStringLiteral("satelliteInformationGroup"));
        formLayout_13 = new QFormLayout(satelliteInformationGroup);
        formLayout_13->setSpacing(6);
        formLayout_13->setContentsMargins(11, 11, 11, 11);
        formLayout_13->setObjectName(QStringLiteral("formLayout_13"));
        label_15 = new QLabel(satelliteInformationGroup);
        label_15->setObjectName(QStringLiteral("label_15"));

        formLayout_13->setWidget(0, QFormLayout::LabelRole, label_15);

        lineEdit_30 = new QLineEdit(satelliteInformationGroup);
        lineEdit_30->setObjectName(QStringLiteral("lineEdit_30"));
        lineEdit_30->setMinimumSize(QSize(0, 25));
        lineEdit_30->setMaximumSize(QSize(16777215, 25));

        formLayout_13->setWidget(0, QFormLayout::FieldRole, lineEdit_30);

        label_16 = new QLabel(satelliteInformationGroup);
        label_16->setObjectName(QStringLiteral("label_16"));

        formLayout_13->setWidget(1, QFormLayout::LabelRole, label_16);

        lineEdit_31 = new QLineEdit(satelliteInformationGroup);
        lineEdit_31->setObjectName(QStringLiteral("lineEdit_31"));
        lineEdit_31->setMinimumSize(QSize(0, 25));
        lineEdit_31->setMaximumSize(QSize(16777215, 25));

        formLayout_13->setWidget(1, QFormLayout::FieldRole, lineEdit_31);

        label_17 = new QLabel(satelliteInformationGroup);
        label_17->setObjectName(QStringLiteral("label_17"));

        formLayout_13->setWidget(3, QFormLayout::LabelRole, label_17);

        label_18 = new QLabel(satelliteInformationGroup);
        label_18->setObjectName(QStringLiteral("label_18"));

        formLayout_13->setWidget(4, QFormLayout::LabelRole, label_18);

        lineEdit_32 = new QLineEdit(satelliteInformationGroup);
        lineEdit_32->setObjectName(QStringLiteral("lineEdit_32"));
        lineEdit_32->setMinimumSize(QSize(0, 25));
        lineEdit_32->setMaximumSize(QSize(16777215, 25));

        formLayout_13->setWidget(4, QFormLayout::FieldRole, lineEdit_32);

        label_19 = new QLabel(satelliteInformationGroup);
        label_19->setObjectName(QStringLiteral("label_19"));

        formLayout_13->setWidget(5, QFormLayout::LabelRole, label_19);

        lineEdit_33 = new QLineEdit(satelliteInformationGroup);
        lineEdit_33->setObjectName(QStringLiteral("lineEdit_33"));
        lineEdit_33->setMinimumSize(QSize(0, 25));
        lineEdit_33->setMaximumSize(QSize(16777215, 25));

        formLayout_13->setWidget(5, QFormLayout::FieldRole, lineEdit_33);

        label_20 = new QLabel(satelliteInformationGroup);
        label_20->setObjectName(QStringLiteral("label_20"));

        formLayout_13->setWidget(6, QFormLayout::LabelRole, label_20);

        lineEdit_34 = new QLineEdit(satelliteInformationGroup);
        lineEdit_34->setObjectName(QStringLiteral("lineEdit_34"));
        lineEdit_34->setMinimumSize(QSize(0, 25));
        lineEdit_34->setMaximumSize(QSize(16777215, 25));

        formLayout_13->setWidget(6, QFormLayout::FieldRole, lineEdit_34);

        label_21 = new QLabel(satelliteInformationGroup);
        label_21->setObjectName(QStringLiteral("label_21"));

        formLayout_13->setWidget(7, QFormLayout::LabelRole, label_21);

        lineEdit_35 = new QLineEdit(satelliteInformationGroup);
        lineEdit_35->setObjectName(QStringLiteral("lineEdit_35"));
        lineEdit_35->setMinimumSize(QSize(0, 25));
        lineEdit_35->setMaximumSize(QSize(16777215, 25));

        formLayout_13->setWidget(7, QFormLayout::FieldRole, lineEdit_35);

        label_22 = new QLabel(satelliteInformationGroup);
        label_22->setObjectName(QStringLiteral("label_22"));

        formLayout_13->setWidget(8, QFormLayout::LabelRole, label_22);

        lineEdit_36 = new QLineEdit(satelliteInformationGroup);
        lineEdit_36->setObjectName(QStringLiteral("lineEdit_36"));
        lineEdit_36->setMinimumSize(QSize(0, 25));
        lineEdit_36->setMaximumSize(QSize(16777215, 25));

        formLayout_13->setWidget(8, QFormLayout::FieldRole, lineEdit_36);

        label_23 = new QLabel(satelliteInformationGroup);
        label_23->setObjectName(QStringLiteral("label_23"));

        formLayout_13->setWidget(9, QFormLayout::LabelRole, label_23);

        lineEdit_37 = new QLineEdit(satelliteInformationGroup);
        lineEdit_37->setObjectName(QStringLiteral("lineEdit_37"));
        lineEdit_37->setMinimumSize(QSize(0, 25));
        lineEdit_37->setMaximumSize(QSize(16777215, 25));

        formLayout_13->setWidget(9, QFormLayout::FieldRole, lineEdit_37);


        verticalLayout_4->addWidget(satelliteInformationGroup);

        satellitePreviewButton = new QPushButton(satellitePage);
        satellitePreviewButton->setObjectName(QStringLiteral("satellitePreviewButton"));

        verticalLayout_4->addWidget(satellitePreviewButton);

        verticalSpacer_7 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_4->addItem(verticalSpacer_7);

        menuToolBox->addItem(satellitePage, QStringLiteral("Satellite"));
        telescopePage = new QWidget();
        telescopePage->setObjectName(QStringLiteral("telescopePage"));
        telescopePage->setGeometry(QRect(0, 0, 190, 557));
        verticalLayout_5 = new QVBoxLayout(telescopePage);
        verticalLayout_5->setSpacing(6);
        verticalLayout_5->setContentsMargins(11, 11, 11, 11);
        verticalLayout_5->setObjectName(QStringLiteral("verticalLayout_5"));
        verticalLayout_5->setContentsMargins(0, -1, 0, -1);
        telescopeSensorGroup = new QGroupBox(telescopePage);
        telescopeSensorGroup->setObjectName(QStringLiteral("telescopeSensorGroup"));
        formLayout = new QFormLayout(telescopeSensorGroup);
        formLayout->setSpacing(6);
        formLayout->setContentsMargins(11, 11, 11, 11);
        formLayout->setObjectName(QStringLiteral("formLayout"));
        label_25 = new QLabel(telescopeSensorGroup);
        label_25->setObjectName(QStringLiteral("label_25"));

        formLayout->setWidget(0, QFormLayout::LabelRole, label_25);

        lineEdit_38 = new QLineEdit(telescopeSensorGroup);
        lineEdit_38->setObjectName(QStringLiteral("lineEdit_38"));
        lineEdit_38->setMinimumSize(QSize(0, 25));
        lineEdit_38->setMaximumSize(QSize(16777215, 25));

        formLayout->setWidget(0, QFormLayout::FieldRole, lineEdit_38);


        verticalLayout_5->addWidget(telescopeSensorGroup);

        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_5->addItem(verticalSpacer);

        menuToolBox->addItem(telescopePage, QStringLiteral("Telescope"));
        graphPage = new QWidget();
        graphPage->setObjectName(QStringLiteral("graphPage"));
        graphPage->setGeometry(QRect(0, 0, 190, 557));
        verticalLayout_14 = new QVBoxLayout(graphPage);
        verticalLayout_14->setSpacing(6);
        verticalLayout_14->setContentsMargins(11, 11, 11, 11);
        verticalLayout_14->setObjectName(QStringLiteral("verticalLayout_14"));
        verticalLayout_14->setContentsMargins(0, -1, 0, -1);
        graphScaleGroup = new QGroupBox(graphPage);
        graphScaleGroup->setObjectName(QStringLiteral("graphScaleGroup"));
        formLayout_3 = new QFormLayout(graphScaleGroup);
        formLayout_3->setSpacing(6);
        formLayout_3->setContentsMargins(11, 11, 11, 11);
        formLayout_3->setObjectName(QStringLiteral("formLayout_3"));
        label_28 = new QLabel(graphScaleGroup);
        label_28->setObjectName(QStringLiteral("label_28"));

        formLayout_3->setWidget(1, QFormLayout::LabelRole, label_28);

        lineEdit_41 = new QLineEdit(graphScaleGroup);
        lineEdit_41->setObjectName(QStringLiteral("lineEdit_41"));
        lineEdit_41->setMinimumSize(QSize(0, 25));
        lineEdit_41->setMaximumSize(QSize(16777215, 25));

        formLayout_3->setWidget(1, QFormLayout::FieldRole, lineEdit_41);

        horizontalSlider_17 = new QSlider(graphScaleGroup);
        horizontalSlider_17->setObjectName(QStringLiteral("horizontalSlider_17"));
        horizontalSlider_17->setMinimumSize(QSize(0, 10));
        horizontalSlider_17->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_17->setSliderPosition(50);
        horizontalSlider_17->setOrientation(Qt::Horizontal);

        formLayout_3->setWidget(2, QFormLayout::SpanningRole, horizontalSlider_17);

        radioButton = new QRadioButton(graphScaleGroup);
        radioButton->setObjectName(QStringLiteral("radioButton"));

        formLayout_3->setWidget(0, QFormLayout::LabelRole, radioButton);

        radioButton_2 = new QRadioButton(graphScaleGroup);
        radioButton_2->setObjectName(QStringLiteral("radioButton_2"));

        formLayout_3->setWidget(0, QFormLayout::FieldRole, radioButton_2);


        verticalLayout_14->addWidget(graphScaleGroup);

        graphOptionsGroup = new QGroupBox(graphPage);
        graphOptionsGroup->setObjectName(QStringLiteral("graphOptionsGroup"));
        formLayout_4 = new QFormLayout(graphOptionsGroup);
        formLayout_4->setSpacing(6);
        formLayout_4->setContentsMargins(11, 11, 11, 11);
        formLayout_4->setObjectName(QStringLiteral("formLayout_4"));
        checkBox_3 = new QCheckBox(graphOptionsGroup);
        checkBox_3->setObjectName(QStringLiteral("checkBox_3"));

        formLayout_4->setWidget(0, QFormLayout::SpanningRole, checkBox_3);

        checkBox_4 = new QCheckBox(graphOptionsGroup);
        checkBox_4->setObjectName(QStringLiteral("checkBox_4"));

        formLayout_4->setWidget(1, QFormLayout::SpanningRole, checkBox_4);


        verticalLayout_14->addWidget(graphOptionsGroup);

        graphLoadDataGroup = new QGroupBox(graphPage);
        graphLoadDataGroup->setObjectName(QStringLiteral("graphLoadDataGroup"));
        verticalLayout_13 = new QVBoxLayout(graphLoadDataGroup);
        verticalLayout_13->setSpacing(6);
        verticalLayout_13->setContentsMargins(11, 11, 11, 11);
        verticalLayout_13->setObjectName(QStringLiteral("verticalLayout_13"));
        comboBox_5 = new QComboBox(graphLoadDataGroup);
        comboBox_5->setObjectName(QStringLiteral("comboBox_5"));
        comboBox_5->setMaximumSize(QSize(16777215, 25));

        verticalLayout_13->addWidget(comboBox_5);

        pushButton_7 = new QPushButton(graphLoadDataGroup);
        pushButton_7->setObjectName(QStringLiteral("pushButton_7"));

        verticalLayout_13->addWidget(pushButton_7);


        verticalLayout_14->addWidget(graphLoadDataGroup);

        graphButton = new QPushButton(graphPage);
        graphButton->setObjectName(QStringLiteral("graphButton"));

        verticalLayout_14->addWidget(graphButton);

        verticalSpacer_6 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_14->addItem(verticalSpacer_6);

        menuToolBox->addItem(graphPage, QStringLiteral("Graph"));
        passPage = new QWidget();
        passPage->setObjectName(QStringLiteral("passPage"));
        passPage->setGeometry(QRect(0, 0, 175, 719));
        verticalLayout_6 = new QVBoxLayout(passPage);
        verticalLayout_6->setSpacing(6);
        verticalLayout_6->setContentsMargins(11, 11, 11, 11);
        verticalLayout_6->setObjectName(QStringLiteral("verticalLayout_6"));
        verticalLayout_6->setContentsMargins(0, -1, 0, -1);
        runSimMode = new QGroupBox(passPage);
        runSimMode->setObjectName(QStringLiteral("runSimMode"));
        formLayout_15 = new QFormLayout(runSimMode);
        formLayout_15->setSpacing(6);
        formLayout_15->setContentsMargins(11, 11, 11, 11);
        formLayout_15->setObjectName(QStringLiteral("formLayout_15"));
        radioButton_11 = new QRadioButton(runSimMode);
        radioButton_11->setObjectName(QStringLiteral("radioButton_11"));

        formLayout_15->setWidget(0, QFormLayout::LabelRole, radioButton_11);

        radioButton_12 = new QRadioButton(runSimMode);
        radioButton_12->setObjectName(QStringLiteral("radioButton_12"));

        formLayout_15->setWidget(0, QFormLayout::FieldRole, radioButton_12);


        verticalLayout_6->addWidget(runSimMode);

        runRenderMode = new QGroupBox(passPage);
        runRenderMode->setObjectName(QStringLiteral("runRenderMode"));
        formLayout_16 = new QFormLayout(runRenderMode);
        formLayout_16->setSpacing(6);
        formLayout_16->setContentsMargins(11, 11, 11, 11);
        formLayout_16->setObjectName(QStringLiteral("formLayout_16"));
        radioButton_13 = new QRadioButton(runRenderMode);
        radioButton_13->setObjectName(QStringLiteral("radioButton_13"));

        formLayout_16->setWidget(0, QFormLayout::LabelRole, radioButton_13);

        radioButton_14 = new QRadioButton(runRenderMode);
        radioButton_14->setObjectName(QStringLiteral("radioButton_14"));

        formLayout_16->setWidget(0, QFormLayout::FieldRole, radioButton_14);


        verticalLayout_6->addWidget(runRenderMode);

        runTLEGroup = new QGroupBox(passPage);
        runTLEGroup->setObjectName(QStringLiteral("runTLEGroup"));
        formLayout_5 = new QFormLayout(runTLEGroup);
        formLayout_5->setSpacing(6);
        formLayout_5->setContentsMargins(11, 11, 11, 11);
        formLayout_5->setObjectName(QStringLiteral("formLayout_5"));
        formLayout_5->setContentsMargins(6, -1, 6, -1);
        lineEdit = new QLineEdit(runTLEGroup);
        lineEdit->setObjectName(QStringLiteral("lineEdit"));
        lineEdit->setMinimumSize(QSize(0, 25));
        lineEdit->setMaximumSize(QSize(16777215, 25));

        formLayout_5->setWidget(0, QFormLayout::FieldRole, lineEdit);

        label_2 = new QLabel(runTLEGroup);
        label_2->setObjectName(QStringLiteral("label_2"));

        formLayout_5->setWidget(0, QFormLayout::LabelRole, label_2);

        pushButton = new QPushButton(runTLEGroup);
        pushButton->setObjectName(QStringLiteral("pushButton"));

        formLayout_5->setWidget(2, QFormLayout::SpanningRole, pushButton);

        lineEdit_2 = new QLineEdit(runTLEGroup);
        lineEdit_2->setObjectName(QStringLiteral("lineEdit_2"));
        lineEdit_2->setMinimumSize(QSize(0, 25));
        lineEdit_2->setMaximumSize(QSize(16777215, 25));

        formLayout_5->setWidget(1, QFormLayout::FieldRole, lineEdit_2);

        label_3 = new QLabel(runTLEGroup);
        label_3->setObjectName(QStringLiteral("label_3"));

        formLayout_5->setWidget(1, QFormLayout::LabelRole, label_3);


        verticalLayout_6->addWidget(runTLEGroup);

        runObserverLocationGroup = new QGroupBox(passPage);
        runObserverLocationGroup->setObjectName(QStringLiteral("runObserverLocationGroup"));
        formLayout_6 = new QFormLayout(runObserverLocationGroup);
        formLayout_6->setSpacing(6);
        formLayout_6->setContentsMargins(11, 11, 11, 11);
        formLayout_6->setObjectName(QStringLiteral("formLayout_6"));
        formLayout_6->setContentsMargins(6, -1, 6, -1);
        label_4 = new QLabel(runObserverLocationGroup);
        label_4->setObjectName(QStringLiteral("label_4"));

        formLayout_6->setWidget(0, QFormLayout::LabelRole, label_4);

        lineEdit_3 = new QLineEdit(runObserverLocationGroup);
        lineEdit_3->setObjectName(QStringLiteral("lineEdit_3"));
        lineEdit_3->setMinimumSize(QSize(0, 25));
        lineEdit_3->setMaximumSize(QSize(16777215, 25));

        formLayout_6->setWidget(0, QFormLayout::FieldRole, lineEdit_3);

        label_5 = new QLabel(runObserverLocationGroup);
        label_5->setObjectName(QStringLiteral("label_5"));

        formLayout_6->setWidget(3, QFormLayout::LabelRole, label_5);

        lineEdit_4 = new QLineEdit(runObserverLocationGroup);
        lineEdit_4->setObjectName(QStringLiteral("lineEdit_4"));
        lineEdit_4->setMinimumSize(QSize(0, 25));
        lineEdit_4->setMaximumSize(QSize(16777215, 25));

        formLayout_6->setWidget(3, QFormLayout::FieldRole, lineEdit_4);


        verticalLayout_6->addWidget(runObserverLocationGroup);

        runObserverTimeGroup = new QGroupBox(passPage);
        runObserverTimeGroup->setObjectName(QStringLiteral("runObserverTimeGroup"));
        formLayout_7 = new QFormLayout(runObserverTimeGroup);
        formLayout_7->setSpacing(6);
        formLayout_7->setContentsMargins(11, 11, 11, 11);
        formLayout_7->setObjectName(QStringLiteral("formLayout_7"));
        formLayout_7->setContentsMargins(6, -1, 6, -1);
        label_6 = new QLabel(runObserverTimeGroup);
        label_6->setObjectName(QStringLiteral("label_6"));

        formLayout_7->setWidget(0, QFormLayout::LabelRole, label_6);

        lineEdit_5 = new QLineEdit(runObserverTimeGroup);
        lineEdit_5->setObjectName(QStringLiteral("lineEdit_5"));
        lineEdit_5->setMinimumSize(QSize(0, 25));
        lineEdit_5->setMaximumSize(QSize(16777215, 25));

        formLayout_7->setWidget(0, QFormLayout::FieldRole, lineEdit_5);

        label_9 = new QLabel(runObserverTimeGroup);
        label_9->setObjectName(QStringLiteral("label_9"));

        formLayout_7->setWidget(1, QFormLayout::LabelRole, label_9);

        lineEdit_14 = new QLineEdit(runObserverTimeGroup);
        lineEdit_14->setObjectName(QStringLiteral("lineEdit_14"));
        lineEdit_14->setMinimumSize(QSize(0, 25));
        lineEdit_14->setMaximumSize(QSize(16777215, 25));

        formLayout_7->setWidget(1, QFormLayout::FieldRole, lineEdit_14);


        verticalLayout_6->addWidget(runObserverTimeGroup);

        runRotationGrou = new QGroupBox(passPage);
        runRotationGrou->setObjectName(QStringLiteral("runRotationGrou"));
        formLayout_8 = new QFormLayout(runRotationGrou);
        formLayout_8->setSpacing(6);
        formLayout_8->setContentsMargins(11, 11, 11, 11);
        formLayout_8->setObjectName(QStringLiteral("formLayout_8"));
        formLayout_8->setContentsMargins(6, -1, 6, -1);
        label_7 = new QLabel(runRotationGrou);
        label_7->setObjectName(QStringLiteral("label_7"));

        formLayout_8->setWidget(0, QFormLayout::LabelRole, label_7);

        label_8 = new QLabel(runRotationGrou);
        label_8->setObjectName(QStringLiteral("label_8"));

        formLayout_8->setWidget(0, QFormLayout::FieldRole, label_8);

        lineEdit_6 = new QLineEdit(runRotationGrou);
        lineEdit_6->setObjectName(QStringLiteral("lineEdit_6"));
        sizePolicy.setHeightForWidth(lineEdit_6->sizePolicy().hasHeightForWidth());
        lineEdit_6->setSizePolicy(sizePolicy);
        lineEdit_6->setMinimumSize(QSize(60, 25));
        lineEdit_6->setMaximumSize(QSize(80, 25));

        formLayout_8->setWidget(1, QFormLayout::LabelRole, lineEdit_6);

        lineEdit_7 = new QLineEdit(runRotationGrou);
        lineEdit_7->setObjectName(QStringLiteral("lineEdit_7"));
        sizePolicy.setHeightForWidth(lineEdit_7->sizePolicy().hasHeightForWidth());
        lineEdit_7->setSizePolicy(sizePolicy);
        lineEdit_7->setMinimumSize(QSize(60, 25));
        lineEdit_7->setMaximumSize(QSize(80, 25));

        formLayout_8->setWidget(1, QFormLayout::FieldRole, lineEdit_7);

        lineEdit_8 = new QLineEdit(runRotationGrou);
        lineEdit_8->setObjectName(QStringLiteral("lineEdit_8"));
        sizePolicy.setHeightForWidth(lineEdit_8->sizePolicy().hasHeightForWidth());
        lineEdit_8->setSizePolicy(sizePolicy);
        lineEdit_8->setMinimumSize(QSize(60, 25));
        lineEdit_8->setMaximumSize(QSize(80, 25));

        formLayout_8->setWidget(2, QFormLayout::LabelRole, lineEdit_8);

        lineEdit_9 = new QLineEdit(runRotationGrou);
        lineEdit_9->setObjectName(QStringLiteral("lineEdit_9"));
        sizePolicy.setHeightForWidth(lineEdit_9->sizePolicy().hasHeightForWidth());
        lineEdit_9->setSizePolicy(sizePolicy);
        lineEdit_9->setMinimumSize(QSize(60, 25));
        lineEdit_9->setMaximumSize(QSize(80, 25));

        formLayout_8->setWidget(2, QFormLayout::FieldRole, lineEdit_9);

        lineEdit_10 = new QLineEdit(runRotationGrou);
        lineEdit_10->setObjectName(QStringLiteral("lineEdit_10"));
        sizePolicy.setHeightForWidth(lineEdit_10->sizePolicy().hasHeightForWidth());
        lineEdit_10->setSizePolicy(sizePolicy);
        lineEdit_10->setMinimumSize(QSize(60, 25));
        lineEdit_10->setMaximumSize(QSize(80, 25));

        formLayout_8->setWidget(3, QFormLayout::LabelRole, lineEdit_10);

        lineEdit_11 = new QLineEdit(runRotationGrou);
        lineEdit_11->setObjectName(QStringLiteral("lineEdit_11"));
        sizePolicy.setHeightForWidth(lineEdit_11->sizePolicy().hasHeightForWidth());
        lineEdit_11->setSizePolicy(sizePolicy);
        lineEdit_11->setMinimumSize(QSize(60, 25));
        lineEdit_11->setMaximumSize(QSize(80, 25));

        formLayout_8->setWidget(3, QFormLayout::FieldRole, lineEdit_11);

        lineEdit_12 = new QLineEdit(runRotationGrou);
        lineEdit_12->setObjectName(QStringLiteral("lineEdit_12"));
        sizePolicy.setHeightForWidth(lineEdit_12->sizePolicy().hasHeightForWidth());
        lineEdit_12->setSizePolicy(sizePolicy);
        lineEdit_12->setMinimumSize(QSize(60, 25));
        lineEdit_12->setMaximumSize(QSize(80, 25));

        formLayout_8->setWidget(4, QFormLayout::LabelRole, lineEdit_12);

        lineEdit_13 = new QLineEdit(runRotationGrou);
        lineEdit_13->setObjectName(QStringLiteral("lineEdit_13"));
        sizePolicy.setHeightForWidth(lineEdit_13->sizePolicy().hasHeightForWidth());
        lineEdit_13->setSizePolicy(sizePolicy);
        lineEdit_13->setMinimumSize(QSize(60, 25));
        lineEdit_13->setMaximumSize(QSize(80, 25));

        formLayout_8->setWidget(4, QFormLayout::FieldRole, lineEdit_13);


        verticalLayout_6->addWidget(runRotationGrou);

        runProgressBar = new QProgressBar(passPage);
        runProgressBar->setObjectName(QStringLiteral("runProgressBar"));
        runProgressBar->setMinimumSize(QSize(0, 25));
        runProgressBar->setMaximumSize(QSize(16777215, 25));
        runProgressBar->setValue(50);
        runProgressBar->setAlignment(Qt::AlignCenter);

        verticalLayout_6->addWidget(runProgressBar);

        verticalSpacer_2 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_6->addItem(verticalSpacer_2);

        menuToolBox->addItem(passPage, QStringLiteral("Pass"));
        manualControlsPage = new QWidget();
        manualControlsPage->setObjectName(QStringLiteral("manualControlsPage"));
        manualControlsPage->setGeometry(QRect(0, 0, 175, 647));
        verticalLayout_7 = new QVBoxLayout(manualControlsPage);
        verticalLayout_7->setSpacing(6);
        verticalLayout_7->setContentsMargins(11, 11, 11, 11);
        verticalLayout_7->setObjectName(QStringLiteral("verticalLayout_7"));
        verticalLayout_7->setContentsMargins(2, 9, 2, -1);
        manualLightDirectionGroup = new QGroupBox(manualControlsPage);
        manualLightDirectionGroup->setObjectName(QStringLiteral("manualLightDirectionGroup"));
        formLayout_9 = new QFormLayout(manualLightDirectionGroup);
        formLayout_9->setSpacing(6);
        formLayout_9->setContentsMargins(11, 11, 11, 11);
        formLayout_9->setObjectName(QStringLiteral("formLayout_9"));
        formLayout_9->setContentsMargins(6, 9, 6, -1);
        lineEdit_15 = new QLineEdit(manualLightDirectionGroup);
        lineEdit_15->setObjectName(QStringLiteral("lineEdit_15"));
        sizePolicy.setHeightForWidth(lineEdit_15->sizePolicy().hasHeightForWidth());
        lineEdit_15->setSizePolicy(sizePolicy);
        lineEdit_15->setMinimumSize(QSize(60, 25));
        lineEdit_15->setMaximumSize(QSize(60, 25));

        formLayout_9->setWidget(0, QFormLayout::LabelRole, lineEdit_15);

        horizontalSlider = new QSlider(manualLightDirectionGroup);
        horizontalSlider->setObjectName(QStringLiteral("horizontalSlider"));
        horizontalSlider->setMinimumSize(QSize(0, 10));
        horizontalSlider->setMaximumSize(QSize(16777215, 10));
        horizontalSlider->setOrientation(Qt::Horizontal);

        formLayout_9->setWidget(0, QFormLayout::FieldRole, horizontalSlider);

        lineEdit_16 = new QLineEdit(manualLightDirectionGroup);
        lineEdit_16->setObjectName(QStringLiteral("lineEdit_16"));
        sizePolicy.setHeightForWidth(lineEdit_16->sizePolicy().hasHeightForWidth());
        lineEdit_16->setSizePolicy(sizePolicy);
        lineEdit_16->setMinimumSize(QSize(60, 25));
        lineEdit_16->setMaximumSize(QSize(60, 25));

        formLayout_9->setWidget(1, QFormLayout::LabelRole, lineEdit_16);

        horizontalSlider_2 = new QSlider(manualLightDirectionGroup);
        horizontalSlider_2->setObjectName(QStringLiteral("horizontalSlider_2"));
        horizontalSlider_2->setMinimumSize(QSize(0, 10));
        horizontalSlider_2->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_2->setMaximum(359);
        horizontalSlider_2->setOrientation(Qt::Horizontal);

        formLayout_9->setWidget(1, QFormLayout::FieldRole, horizontalSlider_2);

        lineEdit_17 = new QLineEdit(manualLightDirectionGroup);
        lineEdit_17->setObjectName(QStringLiteral("lineEdit_17"));
        sizePolicy.setHeightForWidth(lineEdit_17->sizePolicy().hasHeightForWidth());
        lineEdit_17->setSizePolicy(sizePolicy);
        lineEdit_17->setMinimumSize(QSize(60, 25));
        lineEdit_17->setMaximumSize(QSize(60, 25));

        formLayout_9->setWidget(2, QFormLayout::LabelRole, lineEdit_17);

        horizontalSlider_3 = new QSlider(manualLightDirectionGroup);
        horizontalSlider_3->setObjectName(QStringLiteral("horizontalSlider_3"));
        horizontalSlider_3->setMinimumSize(QSize(0, 10));
        horizontalSlider_3->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_3->setMaximum(359);
        horizontalSlider_3->setOrientation(Qt::Horizontal);

        formLayout_9->setWidget(2, QFormLayout::FieldRole, horizontalSlider_3);


        verticalLayout_7->addWidget(manualLightDirectionGroup);

        manualAttitudeGroup = new QGroupBox(manualControlsPage);
        manualAttitudeGroup->setObjectName(QStringLiteral("manualAttitudeGroup"));
        formLayout_10 = new QFormLayout(manualAttitudeGroup);
        formLayout_10->setSpacing(6);
        formLayout_10->setContentsMargins(11, 11, 11, 11);
        formLayout_10->setObjectName(QStringLiteral("formLayout_10"));
        formLayout_10->setContentsMargins(6, -1, 6, -1);
        lineEdit_18 = new QLineEdit(manualAttitudeGroup);
        lineEdit_18->setObjectName(QStringLiteral("lineEdit_18"));
        sizePolicy.setHeightForWidth(lineEdit_18->sizePolicy().hasHeightForWidth());
        lineEdit_18->setSizePolicy(sizePolicy);
        lineEdit_18->setMinimumSize(QSize(60, 25));
        lineEdit_18->setMaximumSize(QSize(60, 25));

        formLayout_10->setWidget(0, QFormLayout::LabelRole, lineEdit_18);

        horizontalSlider_4 = new QSlider(manualAttitudeGroup);
        horizontalSlider_4->setObjectName(QStringLiteral("horizontalSlider_4"));
        horizontalSlider_4->setMinimumSize(QSize(0, 10));
        horizontalSlider_4->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_4->setMaximum(359);
        horizontalSlider_4->setOrientation(Qt::Horizontal);

        formLayout_10->setWidget(0, QFormLayout::FieldRole, horizontalSlider_4);

        lineEdit_19 = new QLineEdit(manualAttitudeGroup);
        lineEdit_19->setObjectName(QStringLiteral("lineEdit_19"));
        sizePolicy.setHeightForWidth(lineEdit_19->sizePolicy().hasHeightForWidth());
        lineEdit_19->setSizePolicy(sizePolicy);
        lineEdit_19->setMinimumSize(QSize(60, 25));
        lineEdit_19->setMaximumSize(QSize(60, 25));

        formLayout_10->setWidget(1, QFormLayout::LabelRole, lineEdit_19);

        horizontalSlider_5 = new QSlider(manualAttitudeGroup);
        horizontalSlider_5->setObjectName(QStringLiteral("horizontalSlider_5"));
        horizontalSlider_5->setMinimumSize(QSize(0, 10));
        horizontalSlider_5->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_5->setMaximum(359);
        horizontalSlider_5->setOrientation(Qt::Horizontal);

        formLayout_10->setWidget(1, QFormLayout::FieldRole, horizontalSlider_5);

        lineEdit_20 = new QLineEdit(manualAttitudeGroup);
        lineEdit_20->setObjectName(QStringLiteral("lineEdit_20"));
        sizePolicy.setHeightForWidth(lineEdit_20->sizePolicy().hasHeightForWidth());
        lineEdit_20->setSizePolicy(sizePolicy);
        lineEdit_20->setMinimumSize(QSize(60, 25));
        lineEdit_20->setMaximumSize(QSize(60, 25));

        formLayout_10->setWidget(2, QFormLayout::LabelRole, lineEdit_20);

        horizontalSlider_6 = new QSlider(manualAttitudeGroup);
        horizontalSlider_6->setObjectName(QStringLiteral("horizontalSlider_6"));
        horizontalSlider_6->setMinimumSize(QSize(0, 10));
        horizontalSlider_6->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_6->setMaximum(359);
        horizontalSlider_6->setOrientation(Qt::Horizontal);

        formLayout_10->setWidget(2, QFormLayout::FieldRole, horizontalSlider_6);

        lineEdit_21 = new QLineEdit(manualAttitudeGroup);
        lineEdit_21->setObjectName(QStringLiteral("lineEdit_21"));
        sizePolicy.setHeightForWidth(lineEdit_21->sizePolicy().hasHeightForWidth());
        lineEdit_21->setSizePolicy(sizePolicy);
        lineEdit_21->setMinimumSize(QSize(60, 25));
        lineEdit_21->setMaximumSize(QSize(60, 25));

        formLayout_10->setWidget(3, QFormLayout::LabelRole, lineEdit_21);

        horizontalSlider_7 = new QSlider(manualAttitudeGroup);
        horizontalSlider_7->setObjectName(QStringLiteral("horizontalSlider_7"));
        horizontalSlider_7->setMinimumSize(QSize(0, 10));
        horizontalSlider_7->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_7->setMaximum(99);
        horizontalSlider_7->setOrientation(Qt::Horizontal);

        formLayout_10->setWidget(3, QFormLayout::FieldRole, horizontalSlider_7);


        verticalLayout_7->addWidget(manualAttitudeGroup);

        manualAngularVelocityGroup = new QGroupBox(manualControlsPage);
        manualAngularVelocityGroup->setObjectName(QStringLiteral("manualAngularVelocityGroup"));
        formLayout_11 = new QFormLayout(manualAngularVelocityGroup);
        formLayout_11->setSpacing(6);
        formLayout_11->setContentsMargins(11, 11, 11, 11);
        formLayout_11->setObjectName(QStringLiteral("formLayout_11"));
        formLayout_11->setContentsMargins(6, -1, 6, -1);
        lineEdit_22 = new QLineEdit(manualAngularVelocityGroup);
        lineEdit_22->setObjectName(QStringLiteral("lineEdit_22"));
        sizePolicy.setHeightForWidth(lineEdit_22->sizePolicy().hasHeightForWidth());
        lineEdit_22->setSizePolicy(sizePolicy);
        lineEdit_22->setMinimumSize(QSize(60, 25));
        lineEdit_22->setMaximumSize(QSize(60, 25));

        formLayout_11->setWidget(0, QFormLayout::LabelRole, lineEdit_22);

        horizontalSlider_8 = new QSlider(manualAngularVelocityGroup);
        horizontalSlider_8->setObjectName(QStringLiteral("horizontalSlider_8"));
        horizontalSlider_8->setMinimumSize(QSize(0, 10));
        horizontalSlider_8->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_8->setMaximum(359);
        horizontalSlider_8->setOrientation(Qt::Horizontal);

        formLayout_11->setWidget(0, QFormLayout::FieldRole, horizontalSlider_8);

        lineEdit_23 = new QLineEdit(manualAngularVelocityGroup);
        lineEdit_23->setObjectName(QStringLiteral("lineEdit_23"));
        sizePolicy.setHeightForWidth(lineEdit_23->sizePolicy().hasHeightForWidth());
        lineEdit_23->setSizePolicy(sizePolicy);
        lineEdit_23->setMinimumSize(QSize(60, 25));
        lineEdit_23->setMaximumSize(QSize(60, 25));

        formLayout_11->setWidget(1, QFormLayout::LabelRole, lineEdit_23);

        horizontalSlider_9 = new QSlider(manualAngularVelocityGroup);
        horizontalSlider_9->setObjectName(QStringLiteral("horizontalSlider_9"));
        horizontalSlider_9->setMinimumSize(QSize(0, 10));
        horizontalSlider_9->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_9->setMaximum(359);
        horizontalSlider_9->setOrientation(Qt::Horizontal);

        formLayout_11->setWidget(1, QFormLayout::FieldRole, horizontalSlider_9);

        lineEdit_24 = new QLineEdit(manualAngularVelocityGroup);
        lineEdit_24->setObjectName(QStringLiteral("lineEdit_24"));
        sizePolicy.setHeightForWidth(lineEdit_24->sizePolicy().hasHeightForWidth());
        lineEdit_24->setSizePolicy(sizePolicy);
        lineEdit_24->setMinimumSize(QSize(60, 25));
        lineEdit_24->setMaximumSize(QSize(60, 25));

        formLayout_11->setWidget(2, QFormLayout::LabelRole, lineEdit_24);

        horizontalSlider_10 = new QSlider(manualAngularVelocityGroup);
        horizontalSlider_10->setObjectName(QStringLiteral("horizontalSlider_10"));
        horizontalSlider_10->setMinimumSize(QSize(0, 10));
        horizontalSlider_10->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_10->setMaximum(359);
        horizontalSlider_10->setOrientation(Qt::Horizontal);

        formLayout_11->setWidget(2, QFormLayout::FieldRole, horizontalSlider_10);

        lineEdit_25 = new QLineEdit(manualAngularVelocityGroup);
        lineEdit_25->setObjectName(QStringLiteral("lineEdit_25"));
        sizePolicy.setHeightForWidth(lineEdit_25->sizePolicy().hasHeightForWidth());
        lineEdit_25->setSizePolicy(sizePolicy);
        lineEdit_25->setMinimumSize(QSize(60, 25));
        lineEdit_25->setMaximumSize(QSize(60, 25));

        formLayout_11->setWidget(3, QFormLayout::LabelRole, lineEdit_25);

        horizontalSlider_11 = new QSlider(manualAngularVelocityGroup);
        horizontalSlider_11->setObjectName(QStringLiteral("horizontalSlider_11"));
        horizontalSlider_11->setMinimumSize(QSize(0, 10));
        horizontalSlider_11->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_11->setMaximum(99);
        horizontalSlider_11->setOrientation(Qt::Horizontal);

        formLayout_11->setWidget(3, QFormLayout::FieldRole, horizontalSlider_11);


        verticalLayout_7->addWidget(manualAngularVelocityGroup);

        manualAltitudeGroup = new QGroupBox(manualControlsPage);
        manualAltitudeGroup->setObjectName(QStringLiteral("manualAltitudeGroup"));
        formLayout_12 = new QFormLayout(manualAltitudeGroup);
        formLayout_12->setSpacing(6);
        formLayout_12->setContentsMargins(11, 11, 11, 11);
        formLayout_12->setObjectName(QStringLiteral("formLayout_12"));
        formLayout_12->setContentsMargins(6, -1, 6, -1);
        lineEdit_26 = new QLineEdit(manualAltitudeGroup);
        lineEdit_26->setObjectName(QStringLiteral("lineEdit_26"));
        sizePolicy.setHeightForWidth(lineEdit_26->sizePolicy().hasHeightForWidth());
        lineEdit_26->setSizePolicy(sizePolicy);
        lineEdit_26->setMinimumSize(QSize(100, 25));
        lineEdit_26->setMaximumSize(QSize(60, 25));

        formLayout_12->setWidget(0, QFormLayout::LabelRole, lineEdit_26);

        horizontalSlider_12 = new QSlider(manualAltitudeGroup);
        horizontalSlider_12->setObjectName(QStringLiteral("horizontalSlider_12"));
        horizontalSlider_12->setMinimumSize(QSize(0, 10));
        horizontalSlider_12->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_12->setMinimum(1);
        horizontalSlider_12->setMaximum(100);
        horizontalSlider_12->setValue(50);
        horizontalSlider_12->setOrientation(Qt::Horizontal);
        horizontalSlider_12->setInvertedAppearance(false);

        formLayout_12->setWidget(0, QFormLayout::FieldRole, horizontalSlider_12);


        verticalLayout_7->addWidget(manualAltitudeGroup);

        manualCameraControlGroup = new QGroupBox(manualControlsPage);
        manualCameraControlGroup->setObjectName(QStringLiteral("manualCameraControlGroup"));
        horizontalLayout_2 = new QHBoxLayout(manualCameraControlGroup);
        horizontalLayout_2->setSpacing(6);
        horizontalLayout_2->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        checkBox = new QCheckBox(manualCameraControlGroup);
        checkBox->setObjectName(QStringLiteral("checkBox"));
        checkBox->setEnabled(true);

        horizontalLayout_2->addWidget(checkBox);


        verticalLayout_7->addWidget(manualCameraControlGroup);

        resetCameraButton = new QPushButton(manualControlsPage);
        resetCameraButton->setObjectName(QStringLiteral("resetCameraButton"));
        QSizePolicy sizePolicy3(QSizePolicy::Preferred, QSizePolicy::Fixed);
        sizePolicy3.setHorizontalStretch(0);
        sizePolicy3.setVerticalStretch(0);
        sizePolicy3.setHeightForWidth(resetCameraButton->sizePolicy().hasHeightForWidth());
        resetCameraButton->setSizePolicy(sizePolicy3);
        resetCameraButton->setMinimumSize(QSize(160, 0));
        resetCameraButton->setMaximumSize(QSize(16777215, 16777215));
        resetCameraButton->setBaseSize(QSize(160, 0));
        resetCameraButton->setStyleSheet(QStringLiteral(""));

        verticalLayout_7->addWidget(resetCameraButton);

        verticalSpacer_3 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_7->addItem(verticalSpacer_3);

        menuToolBox->addItem(manualControlsPage, QStringLiteral("Manual"));
        playbackPage = new QWidget();
        playbackPage->setObjectName(QStringLiteral("playbackPage"));
        playbackPage->setGeometry(QRect(0, 0, 190, 557));
        verticalLayout_10 = new QVBoxLayout(playbackPage);
        verticalLayout_10->setSpacing(6);
        verticalLayout_10->setContentsMargins(11, 11, 11, 11);
        verticalLayout_10->setObjectName(QStringLiteral("verticalLayout_10"));
        verticalLayout_10->setContentsMargins(0, -1, 0, -1);
        groupBox_20 = new QGroupBox(playbackPage);
        groupBox_20->setObjectName(QStringLiteral("groupBox_20"));
        formLayout_17 = new QFormLayout(groupBox_20);
        formLayout_17->setSpacing(6);
        formLayout_17->setContentsMargins(11, 11, 11, 11);
        formLayout_17->setObjectName(QStringLiteral("formLayout_17"));
        radioButton_15 = new QRadioButton(groupBox_20);
        radioButton_15->setObjectName(QStringLiteral("radioButton_15"));

        formLayout_17->setWidget(0, QFormLayout::LabelRole, radioButton_15);

        radioButton_16 = new QRadioButton(groupBox_20);
        radioButton_16->setObjectName(QStringLiteral("radioButton_16"));

        formLayout_17->setWidget(0, QFormLayout::FieldRole, radioButton_16);


        verticalLayout_10->addWidget(groupBox_20);

        playbackSimDataGroup = new QGroupBox(playbackPage);
        playbackSimDataGroup->setObjectName(QStringLiteral("playbackSimDataGroup"));
        verticalLayout_8 = new QVBoxLayout(playbackSimDataGroup);
        verticalLayout_8->setSpacing(6);
        verticalLayout_8->setContentsMargins(11, 11, 11, 11);
        verticalLayout_8->setObjectName(QStringLiteral("verticalLayout_8"));
        comboBox = new QComboBox(playbackSimDataGroup);
        comboBox->setObjectName(QStringLiteral("comboBox"));
        comboBox->setMinimumSize(QSize(87, 25));
        comboBox->setMaximumSize(QSize(16777215, 25));

        verticalLayout_8->addWidget(comboBox);

        pushButton_2 = new QPushButton(playbackSimDataGroup);
        pushButton_2->setObjectName(QStringLiteral("pushButton_2"));

        verticalLayout_8->addWidget(pushButton_2);


        verticalLayout_10->addWidget(playbackSimDataGroup);

        playbackTimingGroup = new QGroupBox(playbackPage);
        playbackTimingGroup->setObjectName(QStringLiteral("playbackTimingGroup"));
        gridLayout = new QGridLayout(playbackTimingGroup);
        gridLayout->setSpacing(6);
        gridLayout->setContentsMargins(11, 11, 11, 11);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        label_11 = new QLabel(playbackTimingGroup);
        label_11->setObjectName(QStringLiteral("label_11"));

        gridLayout->addWidget(label_11, 0, 0, 1, 1);

        label_12 = new QLabel(playbackTimingGroup);
        label_12->setObjectName(QStringLiteral("label_12"));

        gridLayout->addWidget(label_12, 0, 1, 1, 1);

        lineEdit_28 = new QLineEdit(playbackTimingGroup);
        lineEdit_28->setObjectName(QStringLiteral("lineEdit_28"));
        lineEdit_28->setMinimumSize(QSize(0, 25));
        lineEdit_28->setMaximumSize(QSize(16777215, 25));

        gridLayout->addWidget(lineEdit_28, 1, 0, 1, 1);

        lineEdit_27 = new QLineEdit(playbackTimingGroup);
        lineEdit_27->setObjectName(QStringLiteral("lineEdit_27"));
        lineEdit_27->setMinimumSize(QSize(0, 25));
        lineEdit_27->setMaximumSize(QSize(16777215, 25));

        gridLayout->addWidget(lineEdit_27, 1, 1, 1, 1);

        label_10 = new QLabel(playbackTimingGroup);
        label_10->setObjectName(QStringLiteral("label_10"));
        sizePolicy1.setHeightForWidth(label_10->sizePolicy().hasHeightForWidth());
        label_10->setSizePolicy(sizePolicy1);

        gridLayout->addWidget(label_10, 3, 0, 1, 1);

        lineEdit_29 = new QLineEdit(playbackTimingGroup);
        lineEdit_29->setObjectName(QStringLiteral("lineEdit_29"));
        QSizePolicy sizePolicy4(QSizePolicy::Expanding, QSizePolicy::Fixed);
        sizePolicy4.setHorizontalStretch(0);
        sizePolicy4.setVerticalStretch(0);
        sizePolicy4.setHeightForWidth(lineEdit_29->sizePolicy().hasHeightForWidth());
        lineEdit_29->setSizePolicy(sizePolicy4);
        lineEdit_29->setMinimumSize(QSize(0, 25));
        lineEdit_29->setMaximumSize(QSize(16777215, 25));

        gridLayout->addWidget(lineEdit_29, 3, 1, 1, 1);

        horizontalSlider_13 = new QSlider(playbackTimingGroup);
        horizontalSlider_13->setObjectName(QStringLiteral("horizontalSlider_13"));
        horizontalSlider_13->setMinimumSize(QSize(0, 10));
        horizontalSlider_13->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_13->setOrientation(Qt::Horizontal);

        gridLayout->addWidget(horizontalSlider_13, 2, 0, 1, 2);

        horizontalSlider_15 = new QSlider(playbackTimingGroup);
        horizontalSlider_15->setObjectName(QStringLiteral("horizontalSlider_15"));
        horizontalSlider_15->setMinimumSize(QSize(0, 10));
        horizontalSlider_15->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_15->setValue(50);
        horizontalSlider_15->setOrientation(Qt::Horizontal);

        gridLayout->addWidget(horizontalSlider_15, 4, 0, 1, 2);


        verticalLayout_10->addWidget(playbackTimingGroup);

        groupBox_15 = new QGroupBox(playbackPage);
        groupBox_15->setObjectName(QStringLiteral("groupBox_15"));
        verticalLayout_9 = new QVBoxLayout(groupBox_15);
        verticalLayout_9->setSpacing(6);
        verticalLayout_9->setContentsMargins(11, 11, 11, 11);
        verticalLayout_9->setObjectName(QStringLiteral("verticalLayout_9"));
        checkBox_2 = new QCheckBox(groupBox_15);
        checkBox_2->setObjectName(QStringLiteral("checkBox_2"));

        verticalLayout_9->addWidget(checkBox_2);


        verticalLayout_10->addWidget(groupBox_15);

        pushButton_6 = new QPushButton(playbackPage);
        pushButton_6->setObjectName(QStringLiteral("pushButton_6"));

        verticalLayout_10->addWidget(pushButton_6);

        verticalSpacer_4 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_10->addItem(verticalSpacer_4);

        menuToolBox->addItem(playbackPage, QStringLiteral("Playback"));
        reconstructionPage = new QWidget();
        reconstructionPage->setObjectName(QStringLiteral("reconstructionPage"));
        reconstructionPage->setGeometry(QRect(0, 0, 190, 557));
        verticalLayout_12 = new QVBoxLayout(reconstructionPage);
        verticalLayout_12->setSpacing(6);
        verticalLayout_12->setContentsMargins(11, 11, 11, 11);
        verticalLayout_12->setObjectName(QStringLiteral("verticalLayout_12"));
        verticalLayout_12->setContentsMargins(0, -1, 0, -1);
        reconstructionSimModeGroup = new QGroupBox(reconstructionPage);
        reconstructionSimModeGroup->setObjectName(QStringLiteral("reconstructionSimModeGroup"));
        horizontalLayout_3 = new QHBoxLayout(reconstructionSimModeGroup);
        horizontalLayout_3->setSpacing(6);
        horizontalLayout_3->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_3->setObjectName(QStringLiteral("horizontalLayout_3"));
        radioButton_17 = new QRadioButton(reconstructionSimModeGroup);
        radioButton_17->setObjectName(QStringLiteral("radioButton_17"));

        horizontalLayout_3->addWidget(radioButton_17);

        radioButton_18 = new QRadioButton(reconstructionSimModeGroup);
        radioButton_18->setObjectName(QStringLiteral("radioButton_18"));

        horizontalLayout_3->addWidget(radioButton_18);


        verticalLayout_12->addWidget(reconstructionSimModeGroup);

        reconstructionSimDataGroup = new QGroupBox(reconstructionPage);
        reconstructionSimDataGroup->setObjectName(QStringLiteral("reconstructionSimDataGroup"));
        verticalLayout_11 = new QVBoxLayout(reconstructionSimDataGroup);
        verticalLayout_11->setSpacing(6);
        verticalLayout_11->setContentsMargins(11, 11, 11, 11);
        verticalLayout_11->setObjectName(QStringLiteral("verticalLayout_11"));
        comboBox_4 = new QComboBox(reconstructionSimDataGroup);
        comboBox_4->setObjectName(QStringLiteral("comboBox_4"));
        comboBox_4->setMinimumSize(QSize(87, 25));
        comboBox_4->setMaximumSize(QSize(16777215, 25));

        verticalLayout_11->addWidget(comboBox_4);

        pushButton_3 = new QPushButton(reconstructionSimDataGroup);
        pushButton_3->setObjectName(QStringLiteral("pushButton_3"));

        verticalLayout_11->addWidget(pushButton_3);


        verticalLayout_12->addWidget(reconstructionSimDataGroup);

        groupBox_4 = new QGroupBox(reconstructionPage);
        groupBox_4->setObjectName(QStringLiteral("groupBox_4"));
        formLayout_2 = new QFormLayout(groupBox_4);
        formLayout_2->setSpacing(6);
        formLayout_2->setContentsMargins(11, 11, 11, 11);
        formLayout_2->setObjectName(QStringLiteral("formLayout_2"));
        label_26 = new QLabel(groupBox_4);
        label_26->setObjectName(QStringLiteral("label_26"));

        formLayout_2->setWidget(0, QFormLayout::LabelRole, label_26);

        lineEdit_39 = new QLineEdit(groupBox_4);
        lineEdit_39->setObjectName(QStringLiteral("lineEdit_39"));
        lineEdit_39->setMinimumSize(QSize(0, 25));
        lineEdit_39->setMaximumSize(QSize(16777215, 25));

        formLayout_2->setWidget(0, QFormLayout::FieldRole, lineEdit_39);

        lineEdit_40 = new QLineEdit(groupBox_4);
        lineEdit_40->setObjectName(QStringLiteral("lineEdit_40"));
        lineEdit_40->setMinimumSize(QSize(0, 25));
        lineEdit_40->setMaximumSize(QSize(16777215, 25));

        formLayout_2->setWidget(2, QFormLayout::FieldRole, lineEdit_40);

        label_27 = new QLabel(groupBox_4);
        label_27->setObjectName(QStringLiteral("label_27"));

        formLayout_2->setWidget(2, QFormLayout::LabelRole, label_27);

        horizontalSlider_14 = new QSlider(groupBox_4);
        horizontalSlider_14->setObjectName(QStringLiteral("horizontalSlider_14"));
        horizontalSlider_14->setMinimumSize(QSize(0, 10));
        horizontalSlider_14->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_14->setOrientation(Qt::Horizontal);

        formLayout_2->setWidget(1, QFormLayout::SpanningRole, horizontalSlider_14);

        horizontalSlider_16 = new QSlider(groupBox_4);
        horizontalSlider_16->setObjectName(QStringLiteral("horizontalSlider_16"));
        horizontalSlider_16->setMinimumSize(QSize(0, 10));
        horizontalSlider_16->setMaximumSize(QSize(16777215, 10));
        horizontalSlider_16->setOrientation(Qt::Horizontal);

        formLayout_2->setWidget(3, QFormLayout::SpanningRole, horizontalSlider_16);


        verticalLayout_12->addWidget(groupBox_4);

        progressBar_2 = new QProgressBar(reconstructionPage);
        progressBar_2->setObjectName(QStringLiteral("progressBar_2"));
        progressBar_2->setValue(50);
        progressBar_2->setAlignment(Qt::AlignCenter);

        verticalLayout_12->addWidget(progressBar_2);

        verticalSpacer_5 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_12->addItem(verticalSpacer_5);

        menuToolBox->addItem(reconstructionPage, QStringLiteral("Reconstruction"));

        menuLayout->addWidget(menuToolBox);

        runButton = new QPushButton(centralWidget);
        runButton->setObjectName(QStringLiteral("runButton"));
        sizePolicy3.setHeightForWidth(runButton->sizePolicy().hasHeightForWidth());
        runButton->setSizePolicy(sizePolicy3);
        runButton->setMinimumSize(QSize(160, 0));
        runButton->setMaximumSize(QSize(16777215, 16777215));
        runButton->setBaseSize(QSize(160, 0));

        menuLayout->addWidget(runButton);

        stopButton = new QPushButton(centralWidget);
        stopButton->setObjectName(QStringLiteral("stopButton"));
        sizePolicy3.setHeightForWidth(stopButton->sizePolicy().hasHeightForWidth());
        stopButton->setSizePolicy(sizePolicy3);
        stopButton->setMinimumSize(QSize(160, 0));
        stopButton->setMaximumSize(QSize(16777215, 16777215));
        stopButton->setBaseSize(QSize(160, 0));

        menuLayout->addWidget(stopButton);

        resetButton = new QPushButton(centralWidget);
        resetButton->setObjectName(QStringLiteral("resetButton"));

        menuLayout->addWidget(resetButton);

        exitButton = new QPushButton(centralWidget);
        exitButton->setObjectName(QStringLiteral("exitButton"));
        sizePolicy3.setHeightForWidth(exitButton->sizePolicy().hasHeightForWidth());
        exitButton->setSizePolicy(sizePolicy3);
        exitButton->setMinimumSize(QSize(160, 0));
        exitButton->setMaximumSize(QSize(16777215, 16777215));
        exitButton->setBaseSize(QSize(160, 0));

        menuLayout->addWidget(exitButton);


        horizontalLayout->addLayout(menuLayout);

        simLayout = new QVBoxLayout();
        simLayout->setSpacing(6);
        simLayout->setObjectName(QStringLiteral("simLayout"));
        cpsSim = new CpsWidget(centralWidget);
        cpsSim->setObjectName(QStringLiteral("cpsSim"));
        sizePolicy.setHeightForWidth(cpsSim->sizePolicy().hasHeightForWidth());
        cpsSim->setSizePolicy(sizePolicy);
        cpsSim->setMinimumSize(QSize(880, 880));
        cpsSim->setMaximumSize(QSize(900, 900));
        cpsSim->setCursor(QCursor(Qt::CrossCursor));
        cpsSim->setAutoFillBackground(false);
        horizontalLayout_4 = new QHBoxLayout(cpsSim);
        horizontalLayout_4->setSpacing(0);
        horizontalLayout_4->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_4->setObjectName(QStringLiteral("horizontalLayout_4"));
        horizontalLayout_4->setContentsMargins(0, 0, 0, 0);
        CpsLogo = new QLabel(cpsSim);
        CpsLogo->setObjectName(QStringLiteral("CpsLogo"));
        CpsLogo->setAutoFillBackground(false);
        CpsLogo->setStyleSheet(QLatin1String("border-image : url(:/res/images/CpsLogo.png);\n"
"background-color : rgba(0,0,0,255);"));

        horizontalLayout_4->addWidget(CpsLogo);


        simLayout->addWidget(cpsSim);


        horizontalLayout->addLayout(simLayout);

        GraphConsoleLayout = new QVBoxLayout();
        GraphConsoleLayout->setSpacing(6);
        GraphConsoleLayout->setObjectName(QStringLiteral("GraphConsoleLayout"));
        cpsGraph = new QWidget(centralWidget);
        cpsGraph->setObjectName(QStringLiteral("cpsGraph"));

        GraphConsoleLayout->addWidget(cpsGraph);

        consoleScrollArea = new QScrollArea(centralWidget);
        consoleScrollArea->setObjectName(QStringLiteral("consoleScrollArea"));
        consoleScrollArea->setMinimumSize(QSize(0, 200));
        consoleScrollArea->setMaximumSize(QSize(16777215, 200));
        consoleScrollArea->setVerticalScrollBarPolicy(Qt::ScrollBarAlwaysOn);
        consoleScrollArea->setHorizontalScrollBarPolicy(Qt::ScrollBarAlwaysOn);
        consoleScrollArea->setWidgetResizable(true);
        consoleLayout = new QWidget();
        consoleLayout->setObjectName(QStringLiteral("consoleLayout"));
        consoleLayout->setGeometry(QRect(0, 0, 467, 183));
        verticalLayout = new QVBoxLayout(consoleLayout);
        verticalLayout->setSpacing(6);
        verticalLayout->setContentsMargins(11, 11, 11, 11);
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        console = new QLabel(consoleLayout);
        console->setObjectName(QStringLiteral("console"));
        console->setAlignment(Qt::AlignLeading|Qt::AlignLeft|Qt::AlignTop);

        verticalLayout->addWidget(console);

        consoleScrollArea->setWidget(consoleLayout);

        GraphConsoleLayout->addWidget(consoleScrollArea);


        horizontalLayout->addLayout(GraphConsoleLayout);

        CpsWindow->setCentralWidget(centralWidget);

        retranslateUi(CpsWindow);

        menuToolBox->setCurrentIndex(3);


        QMetaObject::connectSlotsByName(CpsWindow);
    } // setupUi

    void retranslateUi(QMainWindow *CpsWindow)
    {
        CpsWindow->setWindowTitle(QApplication::translate("CpsWindow", "COMPASS", Q_NULLPTR));
        satelliteSelectionGroup->setTitle(QApplication::translate("CpsWindow", "Selection", Q_NULLPTR));
        label_13->setText(QApplication::translate("CpsWindow", "Satellite", Q_NULLPTR));
        label_14->setText(QApplication::translate("CpsWindow", "Configuration", Q_NULLPTR));
        pushButton_4->setText(QApplication::translate("CpsWindow", "Browse", Q_NULLPTR));
        pushButton_5->setText(QApplication::translate("CpsWindow", "Add New", Q_NULLPTR));
        satelliteInformationGroup->setTitle(QApplication::translate("CpsWindow", "Information", Q_NULLPTR));
        label_15->setText(QApplication::translate("CpsWindow", "Number:", Q_NULLPTR));
        label_16->setText(QApplication::translate("CpsWindow", "TLE:", Q_NULLPTR));
        label_17->setText(QApplication::translate("CpsWindow", "Orbital Elements:", Q_NULLPTR));
        label_18->setText(QApplication::translate("CpsWindow", "Eccentricity", Q_NULLPTR));
        label_19->setText(QApplication::translate("CpsWindow", "Semi Maj Axis", Q_NULLPTR));
        label_20->setText(QApplication::translate("CpsWindow", "Inclination", Q_NULLPTR));
        label_21->setText(QApplication::translate("CpsWindow", "LAN", Q_NULLPTR));
        label_22->setText(QApplication::translate("CpsWindow", "Arg Periapsis", Q_NULLPTR));
        label_23->setText(QApplication::translate("CpsWindow", "True Anomaly", Q_NULLPTR));
        satellitePreviewButton->setText(QApplication::translate("CpsWindow", "Preview", Q_NULLPTR));
        menuToolBox->setItemText(menuToolBox->indexOf(satellitePage), QApplication::translate("CpsWindow", "Satellite", Q_NULLPTR));
        telescopeSensorGroup->setTitle(QApplication::translate("CpsWindow", "Sensor Options", Q_NULLPTR));
        label_25->setText(QApplication::translate("CpsWindow", "Sample Rate", Q_NULLPTR));
        menuToolBox->setItemText(menuToolBox->indexOf(telescopePage), QApplication::translate("CpsWindow", "Telescope", Q_NULLPTR));
        graphScaleGroup->setTitle(QApplication::translate("CpsWindow", "Scale", Q_NULLPTR));
        label_28->setText(QApplication::translate("CpsWindow", "Scale Factor   ", Q_NULLPTR));
        radioButton->setText(QApplication::translate("CpsWindow", "Manual", Q_NULLPTR));
        radioButton_2->setText(QApplication::translate("CpsWindow", "Auto", Q_NULLPTR));
        graphOptionsGroup->setTitle(QApplication::translate("CpsWindow", "Options", Q_NULLPTR));
        checkBox_3->setText(QApplication::translate("CpsWindow", "Hide Connecting Lines", Q_NULLPTR));
        checkBox_4->setText(QApplication::translate("CpsWindow", "Spline Mode", Q_NULLPTR));
        graphLoadDataGroup->setTitle(QApplication::translate("CpsWindow", "Load Simulation Data", Q_NULLPTR));
        pushButton_7->setText(QApplication::translate("CpsWindow", "Browse", Q_NULLPTR));
        graphButton->setText(QApplication::translate("CpsWindow", "Graph", Q_NULLPTR));
        menuToolBox->setItemText(menuToolBox->indexOf(graphPage), QApplication::translate("CpsWindow", "Graph", Q_NULLPTR));
        runSimMode->setTitle(QApplication::translate("CpsWindow", "Simulation Mode", Q_NULLPTR));
        radioButton_11->setText(QApplication::translate("CpsWindow", "Real-Time", Q_NULLPTR));
        radioButton_12->setText(QApplication::translate("CpsWindow", "Back-End", Q_NULLPTR));
        runRenderMode->setTitle(QApplication::translate("CpsWindow", "Render Mode", Q_NULLPTR));
        radioButton_13->setText(QApplication::translate("CpsWindow", "OSCOM", Q_NULLPTR));
        radioButton_14->setText(QApplication::translate("CpsWindow", "Photometry", Q_NULLPTR));
        runTLEGroup->setTitle(QApplication::translate("CpsWindow", "TLE", Q_NULLPTR));
        label_2->setText(QApplication::translate("CpsWindow", "TLE", Q_NULLPTR));
        pushButton->setText(QApplication::translate("CpsWindow", "Search", Q_NULLPTR));
        label_3->setText(QApplication::translate("CpsWindow", "Sat #", Q_NULLPTR));
        runObserverLocationGroup->setTitle(QApplication::translate("CpsWindow", "Observer Location", Q_NULLPTR));
        label_4->setText(QApplication::translate("CpsWindow", "Lat", Q_NULLPTR));
        label_5->setText(QApplication::translate("CpsWindow", "Lon", Q_NULLPTR));
        runObserverTimeGroup->setTitle(QApplication::translate("CpsWindow", "Observation Time", Q_NULLPTR));
        label_6->setText(QApplication::translate("CpsWindow", "J-Date", Q_NULLPTR));
        label_9->setText(QApplication::translate("CpsWindow", "Duration", Q_NULLPTR));
        runRotationGrou->setTitle(QApplication::translate("CpsWindow", "Rotation", Q_NULLPTR));
        label_7->setText(QApplication::translate("CpsWindow", "Initial Attitude", Q_NULLPTR));
        label_8->setText(QApplication::translate("CpsWindow", "Angular Velocity", Q_NULLPTR));
        menuToolBox->setItemText(menuToolBox->indexOf(passPage), QApplication::translate("CpsWindow", "Pass", Q_NULLPTR));
        manualLightDirectionGroup->setTitle(QApplication::translate("CpsWindow", "Light Direction", Q_NULLPTR));
        manualAttitudeGroup->setTitle(QApplication::translate("CpsWindow", "Attitude", Q_NULLPTR));
        manualAngularVelocityGroup->setTitle(QApplication::translate("CpsWindow", "Angular Velocity", Q_NULLPTR));
        manualAltitudeGroup->setTitle(QApplication::translate("CpsWindow", "Altitude", Q_NULLPTR));
        manualCameraControlGroup->setTitle(QApplication::translate("CpsWindow", "Camera Control", Q_NULLPTR));
        checkBox->setText(QApplication::translate("CpsWindow", "Enabled", Q_NULLPTR));
        resetCameraButton->setText(QApplication::translate("CpsWindow", "Reset Camera", Q_NULLPTR));
        menuToolBox->setItemText(menuToolBox->indexOf(manualControlsPage), QApplication::translate("CpsWindow", "Manual", Q_NULLPTR));
        groupBox_20->setTitle(QApplication::translate("CpsWindow", "Render Mode", Q_NULLPTR));
        radioButton_15->setText(QApplication::translate("CpsWindow", "OSCOM", Q_NULLPTR));
        radioButton_16->setText(QApplication::translate("CpsWindow", "Photometry", Q_NULLPTR));
        playbackSimDataGroup->setTitle(QApplication::translate("CpsWindow", "Load Simulation Data", Q_NULLPTR));
        pushButton_2->setText(QApplication::translate("CpsWindow", "Browse", Q_NULLPTR));
        playbackTimingGroup->setTitle(QApplication::translate("CpsWindow", "Timing", Q_NULLPTR));
        label_11->setText(QApplication::translate("CpsWindow", "J-Date", Q_NULLPTR));
        label_12->setText(QApplication::translate("CpsWindow", "Sim Time", Q_NULLPTR));
        label_10->setText(QApplication::translate("CpsWindow", "Simulation Rate", Q_NULLPTR));
        groupBox_15->setTitle(QApplication::translate("CpsWindow", "Camera Control", Q_NULLPTR));
        checkBox_2->setText(QApplication::translate("CpsWindow", "Enabled", Q_NULLPTR));
        pushButton_6->setText(QApplication::translate("CpsWindow", "Reset Camera", Q_NULLPTR));
        menuToolBox->setItemText(menuToolBox->indexOf(playbackPage), QApplication::translate("CpsWindow", "Playback", Q_NULLPTR));
        reconstructionSimModeGroup->setTitle(QApplication::translate("CpsWindow", "Simulation Mode", Q_NULLPTR));
        radioButton_17->setText(QApplication::translate("CpsWindow", "Real-Time", Q_NULLPTR));
        radioButton_18->setText(QApplication::translate("CpsWindow", "Back-End", Q_NULLPTR));
        reconstructionSimDataGroup->setTitle(QApplication::translate("CpsWindow", "Load Simulation Data", Q_NULLPTR));
        pushButton_3->setText(QApplication::translate("CpsWindow", "Browse", Q_NULLPTR));
        groupBox_4->setTitle(QApplication::translate("CpsWindow", "Simulation Timing", Q_NULLPTR));
        label_26->setText(QApplication::translate("CpsWindow", "Start Time", Q_NULLPTR));
        label_27->setText(QApplication::translate("CpsWindow", "End Time", Q_NULLPTR));
        menuToolBox->setItemText(menuToolBox->indexOf(reconstructionPage), QApplication::translate("CpsWindow", "Reconstruction", Q_NULLPTR));
        runButton->setText(QApplication::translate("CpsWindow", "Run", Q_NULLPTR));
        stopButton->setText(QApplication::translate("CpsWindow", "Stop", Q_NULLPTR));
        resetButton->setText(QApplication::translate("CpsWindow", "Reset", Q_NULLPTR));
        exitButton->setText(QApplication::translate("CpsWindow", "Exit", Q_NULLPTR));
        CpsLogo->setText(QString());
        console->setText(QApplication::translate("CpsWindow", "Output Console", Q_NULLPTR));
    } // retranslateUi

};

namespace Ui {
    class CpsWindow: public Ui_CpsWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CPSWINDOW_H
