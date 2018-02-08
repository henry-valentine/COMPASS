/********************************************************
* Computational Photometry Analyzer for Small Satellites
* Copyright ©, 2017 Embry-Riddle Aeronautical University
*
* File: Satellite.cpp
*
* @author Henry Valentine
* @version 12/28/2017
*
* Contains the implementation of Satellite
*
********************************************************/

#include "Satellite.h"

Satellite::Satellite(SceneManager* scnMgr)
{
	m_node = scnMgr->getRootSceneNode()->createChildSceneNode();
	m_rAxis = Vector3(1, 1, 0);									// TAG
	m_angDisp = 0;						
	m_angVel = 0.6;///////////////////////////////TEMP               TAG
}

Satellite::Satellite()
{
	m_rAxis = Vector3(0, 1, 0);
	m_angDisp = 0;
	m_angVel = 0.01;
}

Satellite::~Satellite()
{

}

void 
Satellite::update(int frameNumber)
{
	// Constrain Angular Displacement
	if (m_angDisp >= 360)
	{
		m_angDisp = 0;
	}
	else if (m_angDisp < 0)
	{
		m_angDisp = 359;
	}

	// Apply Angular Velocity
	m_angDisp += m_angVel;

	// Rotate
	rotate(m_rAxis, m_angDisp);

	// Move Satellite //////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Clean Up Later
	float anglePerFrame = 0.00133333333333; // Angle Per Frame in Degrees. Calculate this better in future.      TAG

	float theta = -20 + (frameNumber * anglePerFrame);  // Angular Displacement        TAG

	float alt = 100; // Fixed Altitude of the Satellite

	//Calculate X and Z Coordinates
	float x = alt * Math::Sin(Radian(theta * Math::PI / 180));

	float z = alt * Math::Cos(Radian(theta * Math::PI / 180));

	float y = 0;

	m_node->setPosition(x, y, z);

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

} // End Update

void
Satellite::scale(float x, float y, float z)
{

	m_node->scale(x, y, z);

} // End Scale

void 
Satellite::rotate(Ogre::Vector3 axis, float angle)
{

	m_node->rotate(axis, Degree(angle));

} // End Rotate

/** Getters and Setters **/
void
Satellite::setEntity(Entity* entity)
{
	m_entity = entity;
	m_node->attachObject(entity);
}

Entity* 
Satellite::getEntity() const
{
	return m_entity;
}

void 
Satellite::setNode(SceneNode* node)
{
	m_node = node;
}

SceneNode*
Satellite::getNode() const
{
	return m_node;
}

void 
Satellite::setRotationAxis(Vector3 rAxis)
{
	m_rAxis = rAxis;
}

Vector3 
Satellite::getRotationAxis() const
{
	return m_rAxis;
}

void 
Satellite::setAngularVelocity(float angVel)
{
	m_angVel = angVel;
}

float 
Satellite::getAngularVelocity() const
{
	return m_angVel;
}

void 
Satellite::setAngularDisplacement(float angDisp)
{
	m_angDisp = angDisp;
}

float 
Satellite::getAngularDisplacement() const
{
	return m_angDisp;
}