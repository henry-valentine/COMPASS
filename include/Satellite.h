/********************************************************
* Computational Photometry Analyzer for Small Satellites
* Copyright ©, 2017 Embry-Riddle Aeronautical University
*
* File: Satellite.h
*
* @author Henry Valentine
* @version 12/05/2017
*
* Represents a Satellite Object
*
* TODO: Angular Acceleration. Initial Rotation.
* 
********************************************************/

#ifndef SATELLITE_H
#define SATELLITE_H

#include <Ogre.h>
#include <iostream>

using namespace Ogre;

class Satellite
{

public:
	/* Constructor - Destructor */
	Satellite(SceneManager* scnMgr);
	Satellite();
	~Satellite();

	/* Update Object */
	void update(int frameNumber);

	/* Scale Object */
	void scale(float x, float y, float z);

	/* Rotate Object */
	void rotate(Ogre::Vector3 axis, float angle);

	/** Getters and Setters **/
	void setEntity(Entity* entity);
	Entity* getEntity() const;

	void setNode(SceneNode* node);
	SceneNode* getNode() const;

	void setRotationAxis(Vector3 rAxis);
	Vector3 getRotationAxis() const;

	void setAngularVelocity(float angVel);
	float getAngularVelocity() const;

	void setAngularDisplacement(float angDisp);
	float getAngularDisplacement() const;

private:

	/* Instance Variables */
	SceneNode*		m_node;		// Scene node
	Entity*			m_entity;	// Entity
	Vector3			m_rAxis;	// Rotation Axis
	float			m_angVel;	// Angular Velocity in Degrees per Second
	float			m_angDisp;	// Angular Displacement in Degrees

	// Add a Vector3 Position. Only Accessed by getters and setters though so the Node Position is always updated.

};


#endif // SATELLITE_H