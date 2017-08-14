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
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenu>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>
#include "include/cpsGUI/cpsWidget.h"

QT_BEGIN_NAMESPACE

class Ui_CpsWindow
{
public:
    QWidget *centralWidget;
    QHBoxLayout *horizontalLayout;
    QVBoxLayout *verticalLayout_2;
    QVBoxLayout *verticalLayout;
    QSpacerItem *verticalSpacer;
    QPushButton *exitButton;
    CpsWidget *CpsSim;
    QMenuBar *menuBar;
    QMenu *menuFile;
    QMenu *menuHelp;

    void setupUi(QMainWindow *CpsWindow)
    {
        if (CpsWindow->objectName().isEmpty())
            CpsWindow->setObjectName(QStringLiteral("CpsWindow"));
        CpsWindow->resize(800, 600);
        CpsWindow->setMinimumSize(QSize(800, 600));
        centralWidget = new QWidget(CpsWindow);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        horizontalLayout = new QHBoxLayout(centralWidget);
        horizontalLayout->setSpacing(6);
        horizontalLayout->setContentsMargins(11, 11, 11, 11);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2->setSpacing(6);
        verticalLayout_2->setObjectName(QStringLiteral("verticalLayout_2"));
        verticalLayout = new QVBoxLayout();
        verticalLayout->setSpacing(6);
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout->addItem(verticalSpacer);

        exitButton = new QPushButton(centralWidget);
        exitButton->setObjectName(QStringLiteral("exitButton"));

        verticalLayout->addWidget(exitButton);


        verticalLayout_2->addLayout(verticalLayout);


        horizontalLayout->addLayout(verticalLayout_2);

        CpsSim = new CpsWidget(centralWidget);
        CpsSim->setObjectName(QStringLiteral("CpsSim"));
        CpsSim->setEnabled(true);
        QSizePolicy sizePolicy(QSizePolicy::Expanding, QSizePolicy::Preferred);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(CpsSim->sizePolicy().hasHeightForWidth());
        CpsSim->setSizePolicy(sizePolicy);
        CpsSim->setMinimumSize(QSize(512, 512));

        horizontalLayout->addWidget(CpsSim);

        CpsWindow->setCentralWidget(centralWidget);
        menuBar = new QMenuBar(CpsWindow);
        menuBar->setObjectName(QStringLiteral("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 800, 26));
        menuFile = new QMenu(menuBar);
        menuFile->setObjectName(QStringLiteral("menuFile"));
        menuHelp = new QMenu(menuBar);
        menuHelp->setObjectName(QStringLiteral("menuHelp"));
        CpsWindow->setMenuBar(menuBar);

        menuBar->addAction(menuFile->menuAction());
        menuBar->addAction(menuHelp->menuAction());

        retranslateUi(CpsWindow);
        QObject::connect(exitButton, SIGNAL(released()), CpsWindow, SLOT(close()));

        QMetaObject::connectSlotsByName(CpsWindow);
    } // setupUi

    void retranslateUi(QMainWindow *CpsWindow)
    {
        CpsWindow->setWindowTitle(QApplication::translate("CpsWindow", "COMPASS", Q_NULLPTR));
        exitButton->setText(QApplication::translate("CpsWindow", "Exit", Q_NULLPTR));
        menuFile->setTitle(QApplication::translate("CpsWindow", "File", Q_NULLPTR));
        menuHelp->setTitle(QApplication::translate("CpsWindow", "Help", Q_NULLPTR));
    } // retranslateUi

};

namespace Ui {
    class CpsWindow: public Ui_CpsWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CPSWINDOW_H
