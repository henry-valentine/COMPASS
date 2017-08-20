*******************************************************************************
**                                                                           **
**           Computational Photemtry Analyzer for Small Satellites           **
**                                                                           **
*******************************************************************************
Copyright ©, 2017 Embry-Riddle Aeronautical University
Space and Atmospheric Instrumentation Lab
COMPASS - V 1.0.0 - 08/15/17

*******************************************************************************
Project Description
-------------------
The  Computational  Photometry  Analyzer  for  Small  Satellites(COMPASS)  is a 
desktop-based  rendering  engine  written  in  C++  and  OpenGL used to produce 
accurate graphical  representations  of  RSOs (resident space objects)and their 
environments  as  observed  by  ground-based  telescopes.  These renderings are 
generated  and  processed  within  the  program  in  order  to infer additional 
information about the system including  photometry data, RSO attitude, rotation 
frequency, etc. and provide a platform for testing image processing algorithms. 
An intuitive user interface  is  provided  in order to visually correlate these 
renderings to the associated photometry data.

*******************************************************************************
License Information
-------------------
This project remains open source under the General Public License, Version 3.
See LICENSE.txt for further details.

*******************************************************************************
Instructions
------------

    @TODO

*******************************************************************************
Project Documentation
---------------------
Documentation for this program is located in the COMPASS/documentation 
directory. Available documentation consists of the following files:
    - Project Overview
    - Software Design Document
    - User Guide
    - Change Log*
    - LICENSE*
* Change Log and LICENSE are located in the base program directory.
    
*******************************************************************************
Version History
---------------
 - 0.9.1 : Bug fixes. Code tidying. Updated simulation parameters.
 - 0.9.0 : Initial release. Simulations created one at a time and rendered in a 
           separate window. Graphing Utilities implemented. Written in Java.

*******************************************************************************
Bug Reporting and Contact Information
-------------------------------------
The developers of this software may be reached with the email address provided 
at the following URL:

    https://github.com/henry-valentine

Bug reports, feature requests, and suggestions are welcomed and greatly 
appreciated. Direct all corespondance to the same email.    
   
*******************************************************************************
Known Bugs
----------
 - Using the Escape key to end a simulation prevents a new one from being 
   created [RESOLVED : 0.9.1]
 - ChildObject Translations are not consistent with the orientation of the 
   parent object. [RESOLVED : 0.9.2]

*******************************************************************************
Libraries and Resources
-----------------------
All libraries and resources used within this program are Open Source and freely
available.

    OpenGL         - https://www.opengl.org/ 
    QT             - https://www.qt.io/
    GitHub         - https://github.com/
    QSS Stylesheet - https://github.com/ColinDuquesnoy/QDarkStyleSheet (Under MIT License. See qDarkStyle.qss)

*******************************************************************************