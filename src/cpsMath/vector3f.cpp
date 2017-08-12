/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: vector3f.cpp
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * Contains the implementation of Vector3f
 ********************************************************/

#include "include/cpsMath/vector3f.h"

Vector3f::Vector3f(float x, float y, float z)
{
    m_x = x;
    m_y = y;
    m_z = z;
}

float Vector3f::dot(const Vector3f &r)
{
    return m_x * r.getX() + m_y * r.getY() + m_z * r.getZ();
}

Vector3f Vector3f::cross(const Vector3f &r)
{

}

Vector3f Vector3f::rotate(const Vector3f &axis, float angle)
{

}

Vector3f Vector3f::normalized()
{

}

float Vector3f::getLength()
{

}

Vector3f Vector3f::add(const Vector3f &r)
{

}

Vector3f Vector3f::add(float r)
{

}

Vector3f Vector3f::subtract(const Vector3f &r)
{

}

Vector3f Vector3f::subtract(float r)
{

}

Vector3f Vector3f::multiply(const Vector3f &r)
{

}

Vector3f Vector3f::multiply(float r)
{

}

void Vector3f::set(float x, float y, float z)
{

}

void Vector3f::setX(float x)
{

}

float Vector3f::getX() const
{
    return m_x;
}

void Vector3f::setY(float y)
{

}

float Vector3f::getY() const
{
    return m_y;
}

void Vector3f::setZ(float z)
{

}

float Vector3f::getZ() const
{
    return m_z;
}
