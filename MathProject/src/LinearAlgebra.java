/**
* Computes Linear Algebra
* @author Jeongbin Cho
* @version 1.0
**/

public class LinearAlgebra {
    /**
    * Multiplies a matrix and vector
    * @param m matrix
    * @param v vector
    * @return product of m * v
    **/

    public static Vector matrixVectorMultiply(Matrix m, Vector v) {

//        if (m.getWidth() != v.getLength()) {
//            throw new IllegalOperandException("You cannot multiply a matrix"
//                + " of width " + m.getWidth() + " with vector of length "
//                + v.getLength());
//        }
        float[] s0 = new float[v.getLength()];

        for (int i = 0; i < m.getHeight(); i++) {
            float sum = 0;
            for (int j = 0; j < m.getWidth(); j++) {
                float s1 = m.get(i, j) * v.get(j);
                sum = sum + s1;
            }
            s0[i] = sum;
        }
        Vector ans = new Vector(s0);
        return ans;

    }

    /**
    * Adds two matrices
    * @param m1 matrix 1
    * @param m2 matrix 2
    * @return sum of m1 + m2
    **/

    public static Matrix matrixAdd(Matrix m1, Matrix m2)
        throws IllegalOperandException {

        if (m1.getWidth() != m2.getWidth()) {
            throw new IllegalOperandException("Cannot add a matrix of width "
                + m1.getWidth() + " with a matrix of width " + m2.getWidth());
        } else if (m1.getHeight() != m2.getHeight()) {
            throw new IllegalOperandException("Cannot add a matrix of height "
                + m1.getHeight() + " with a matrix of height "
                + m2.getHeight());
        }

        float[][] s0 = new float[m1.getWidth()][m1.getHeight()];
        for (int i = 0; i < m1.getHeight(); i++) {
            for (int j = 0; j < m2.getHeight(); j++) {
                float s1 = m1.get(i, j) + m2.get(i, j);
                s0[i][j] = s1;
            }
        }
        Matrix ans = new Matrix(s0);
        return ans;
    }

    /**
    * Dot products two vectors
    * @param v1 vector 1
    * @param v2 vector 2
    * @return dot product of v1 and v2
    **/

    public static float dotProduct(Vector v1, Vector v2)
        throws IllegalOperandException {

        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("Cannot dot product "
                + "a vector with length " + v1.getLength()
                + "with a vector of length " + v2.getLength());
        }

        float s0 = 0;
        for (int i = 0; i < v1.getLength(); i++) {
            float s1 = v1.get(i) * v2.get(i);
            s0 = s0 + s1;
        }

        return s0;
    }

    /**
    * Adds two vectors
    * @param v1 vector 1
    * @param v2 vector 2
    * @return sum of v1 + v2
    **/

    public static Vector vectorAdd(Vector v1, Vector v2)
        throws IllegalOperandException {

        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("Cannot add a vector with length "
                + v1.getLength() + "with a vector of length " + v2.getLength());
        }

        float[] s0 = new float[v1.getLength()];
        for (int i = 0; i < v1.getLength(); i++) {
            float s1 = v1.get(i) + v2.get(i);
            s0[i] = s1;
        }

        Vector ans = new Vector(s0);
        return ans;
    }
}
