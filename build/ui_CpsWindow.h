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
#include <QtWidgets/QFormLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QRadioButton>
#include <QtWidgets/QScrollArea>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_CpsWindow
{
public:
    QWidget *centralWidget;
    QHBoxLayout *horizontalLayout;
    QFormLayout *MenuLayout;
    QPushButton *runButton;
    QPushButton *exitButton;
    QPushButton *stopButton;
    QPushButton *pushButton_4;
    QRadioButton *radioButton_2;
    QRadioButton *radioButton;
    QRadioButton *radioButton_3;
    QRadioButton *radioButton_4;
    QVBoxLayout *verticalLayout_3;
    QWidget *CpsSim;
    QVBoxLayout *GraphConsoleLayout;
    QWidget *CpsGraph;
    QScrollArea *scrollArea;
    QWidget *scrollAreaWidgetContents;
    QVBoxLayout *verticalLayout;
    QLabel *label;

    void setupUi(QMainWindow *CpsWindow)
    {
        if (CpsWindow->objectName().isEmpty())
            CpsWindow->setObjectName(QStringLiteral("CpsWindow"));
        CpsWindow->setEnabled(true);
        CpsWindow->resize(1600, 900);
        QSizePolicy sizePolicy(QSizePolicy::Preferred, QSizePolicy::Preferred);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(CpsWindow->sizePolicy().hasHeightForWidth());
        CpsWindow->setSizePolicy(sizePolicy);
        CpsWindow->setMinimumSize(QSize(1600, 900));
        CpsWindow->setMaximumSize(QSize(3000, 2000));
        centralWidget = new QWidget(CpsWindow);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        sizePolicy.setHeightForWidth(centralWidget->sizePolicy().hasHeightForWidth());
        centralWidget->setSizePolicy(sizePolicy);
        centralWidget->setMinimumSize(QSize(1600, 900));
        centralWidget->setMaximumSize(QSize(3000, 2000));
        horizontalLayout = new QHBoxLayout(centralWidget);
        horizontalLayout->setSpacing(6);
        horizontalLayout->setContentsMargins(11, 11, 11, 11);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        MenuLayout = new QFormLayout();
        MenuLayout->setSpacing(6);
        MenuLayout->setObjectName(QStringLiteral("MenuLayout"));
        MenuLayout->setLabelAlignment(Qt::AlignLeading|Qt::AlignLeft|Qt::AlignVCenter);
        runButton = new QPushButton(centralWidget);
        runButton->setObjectName(QStringLiteral("runButton"));

        MenuLayout->setWidget(0, QFormLayout::LabelRole, runButton);

        exitButton = new QPushButton(centralWidget);
        exitButton->setObjectName(QStringLiteral("exitButton"));

        MenuLayout->setWidget(0, QFormLayout::FieldRole, exitButton);

        stopButton = new QPushButton(centralWidget);
        stopButton->setObjectName(QStringLiteral("stopButton"));

        MenuLayout->setWidget(1, QFormLayout::LabelRole, stopButton);

        pushButton_4 = new QPushButton(centralWidget);
        pushButton_4->setObjectName(QStringLiteral("pushButton_4"));

        MenuLayout->setWidget(1, QFormLayout::FieldRole, pushButton_4);

        radioButton_2 = new QRadioButton(centralWidget);
        radioButton_2->setObjectName(QStringLiteral("radioButton_2"));

        MenuLayout->setWidget(2, QFormLayout::FieldRole, radioButton_2);

        radioButton = new QRadioButton(centralWidget);
        radioButton->setObjectName(QStringLiteral("radioButton"));

        MenuLayout->setWidget(2, QFormLayout::LabelRole, radioButton);

        radioButton_3 = new QRadioButton(centralWidget);
        radioButton_3->setObjectName(QStringLiteral("radioButton_3"));

        MenuLayout->setWidget(3, QFormLayout::FieldRole, radioButton_3);

        radioButton_4 = new QRadioButton(centralWidget);
        radioButton_4->setObjectName(QStringLiteral("radioButton_4"));

        MenuLayout->setWidget(3, QFormLayout::LabelRole, radioButton_4);


        horizontalLayout->addLayout(MenuLayout);

        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3->setSpacing(6);
        verticalLayout_3->setObjectName(QStringLiteral("verticalLayout_3"));
        CpsSim = new QWidget(centralWidget);
        CpsSim->setObjectName(QStringLiteral("CpsSim"));
        QSizePolicy sizePolicy1(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(CpsSim->sizePolicy().hasHeightForWidth());
        CpsSim->setSizePolicy(sizePolicy1);
        CpsSim->setMinimumSize(QSize(900, 900));
        CpsSim->setMaximumSize(QSize(900, 900));

        verticalLayout_3->addWidget(CpsSim);


        horizontalLayout->addLayout(verticalLayout_3);

        GraphConsoleLayout = new QVBoxLayout();
        GraphConsoleLayout->setSpacing(6);
        GraphConsoleLayout->setObjectName(QStringLiteral("GraphConsoleLayout"));
        CpsGraph = new QWidget(centralWidget);
        CpsGraph->setObjectName(QStringLiteral("CpsGraph"));

        GraphConsoleLayout->addWidget(CpsGraph);

        scrollArea = new QScrollArea(centralWidget);
        scrollArea->setObjectName(QStringLiteral("scrollArea"));
        scrollArea->setMinimumSize(QSize(0, 200));
        scrollArea->setMaximumSize(QSize(16777215, 200));
        scrollArea->setVerticalScrollBarPolicy(Qt::ScrollBarAlwaysOn);
        scrollArea->setHorizontalScrollBarPolicy(Qt::ScrollBarAlwaysOn);
        scrollArea->setWidgetResizable(true);
        scrollAreaWidgetContents = new QWidget();
        scrollAreaWidgetContents->setObjectName(QStringLiteral("scrollAreaWidgetContents"));
        scrollAreaWidgetContents->setGeometry(QRect(0, 0, 475, 181));
        verticalLayout = new QVBoxLayout(scrollAreaWidgetContents);
        verticalLayout->setSpacing(6);
        verticalLayout->setContentsMargins(11, 11, 11, 11);
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        label = new QLabel(scrollAreaWidgetContents);
        label->setObjectName(QStringLiteral("label"));
        label->setAlignment(Qt::AlignLeading|Qt::AlignLeft|Qt::AlignTop);

        verticalLayout->addWidget(label);

        scrollArea->setWidget(scrollAreaWidgetContents);

        GraphConsoleLayout->addWidget(scrollArea);


        horizontalLayout->addLayout(GraphConsoleLayout);

        CpsWindow->setCentralWidget(centralWidget);

        retranslateUi(CpsWindow);

        QMetaObject::connectSlotsByName(CpsWindow);
    } // setupUi

    void retranslateUi(QMainWindow *CpsWindow)
    {
        CpsWindow->setWindowTitle(QApplication::translate("CpsWindow", "COMPASS", Q_NULLPTR));
        runButton->setText(QApplication::translate("CpsWindow", "Run", Q_NULLPTR));
        exitButton->setText(QApplication::translate("CpsWindow", "Exit", Q_NULLPTR));
        stopButton->setText(QApplication::translate("CpsWindow", "Stop", Q_NULLPTR));
        pushButton_4->setText(QApplication::translate("CpsWindow", "PushButton", Q_NULLPTR));
        radioButton_2->setText(QApplication::translate("CpsWindow", "RadioButton", Q_NULLPTR));
        radioButton->setText(QApplication::translate("CpsWindow", "RadioButton", Q_NULLPTR));
        radioButton_3->setText(QApplication::translate("CpsWindow", "RadioButton", Q_NULLPTR));
        radioButton_4->setText(QApplication::translate("CpsWindow", "RadioButton", Q_NULLPTR));
        label->setText(QApplication::translate("CpsWindow", "TextLabel", Q_NULLPTR));
    } // retranslateUi

};

namespace Ui {
    class CpsWindow: public Ui_CpsWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CPSWINDOW_H
