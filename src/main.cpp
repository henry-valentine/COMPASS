#include "include/cpsGUI/gui.h"
#include <QApplication>

/**
 * TODO:
 *  - Create Comment Headers for each file. Create a standard header to use
 *  - Change Name of GUI class? My cause some issues/confusion, but I'm not sure...
 *  - Write out high-level program architecture: Consider primary functions and go from there...
 *  - Cereate GUI Design
 */

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    GUI w;
    w.show();

    return a.exec();
}
