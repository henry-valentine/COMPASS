/********************************************************
 * Computational Photometry Analyzer for Small Satellites
 * Embry-Riddle Aeronautical University
 *
 * File: vector3f.h
 *
 * @author Henry Valentine
 * @version 8/11/2017
 *
 * The Vector3f class reprsents a 3-Dimensional vector
 * consisting of X, Y, and Z components.
 *
 * @TODO:
 *  - toPositionMatrix and toRotationMatrix functions.
 ********************************************************/

#ifndef VECTOR3F_H
#define VECTOR3F_H

class Vector3f
{
public:
    /**
     * Constructor
     * Creates a new Vector3f
     * @param x : X Component of this Vector
     * @param y : Y Component of this Vector
     * @param z : Z Component of this Vector
     */
    Vector3f(float x, float y, float z);

    /**
     * Calculates the Dot product of two vectors.
     * @param r : Input Vector.
     * @return dot product of this vector and input vector.
     */
    float dot(const Vector3f& r);

    /**
     * Calculates cross product between this vector and
     * the input vector.
     * @param r : Input Vector.
     * @return  : New Vector3f after cross product.
     */
    Vector3f cross(const Vector3f& r);

    /**
     * Rotates this vector about the given axis by
     * the given amount.
     * @param axis  : Rotation axis Vector.
     * @param angle : Rotation angle.
     * @return New Vector3f after rotation.
     */
    Vector3f rotate(const Vector3f& axis, float angle);

    /**
     * Normalize this vector.
     * @return New Vector after normalization.
     */
    Vector3f normalized();

    /**
     * Calculates length of this vector.
     * @return Vector length.
     */
    float getLength();

    /**
     * Add input Vector to this vector.
     * @param r : Input Vector.
     * @return New Vector after addition.
     */
    Vector3f add(const Vector3f& r);

    /**
     * Add scalar to components of this Vector.
     * @param r : Input Scalar.
     * @return New Vector after addition.
     */
    Vector3f add(float r);

    /**
     * Subtract input Vector from this vector.
     * @param r : Input Vector.
     * @return New Vector after subtraction.
     */
    Vector3f subtract(const Vector3f& r);

    /**
     * Subtract scalar from components of this Vector.
     * @param r : Input Scalar.
     * @return New Vector after subtraction.
     */
    Vector3f subtract(float r);

    /**
     * Multiply components of vector by
     * the components of the input vector.
     * @param r : Input Vector.
     * @return New Vector after multiplication.
     */
    Vector3f multiply(const Vector3f& r);

    /**
     * Multiply components of this vector by input scalar.
     * @param r : Input Scalar.
     * @return New Vector after multiplication.
     */
    Vector3f multiply(float r);


    /** Getters and Setters **/
    void set(float x, float y, float z);

    void setX(float x);
    float getX() const;

    void setY(float y);
    float getY() const;

    void setZ(float z);
    float getZ() const;

private:
    /** Components of this Vector **/
    float m_x, m_y, m_z;
};
#endif // VECTOR3F_H
