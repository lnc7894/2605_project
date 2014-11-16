/**
 * Immutable abstraction for Vector
 *
 * @author Michael Maurer
 * @version 1.2
 */
public class Vector {
    /*
    Create final instance variables
    */
    private final float[] vector;
    private final int length;
    /**
     * Initialize instance variables
     * @param vector array representation of vector
     */
    public Vector(float[] vector) {
        length = vector.length;
        this.vector = vector;
    }
    /**
     * Gets value located at specified index
     * @param i index in vector
     * @return float located at index 'i' in vector
     */
    public float get(int i) {
//        if (i >= vector.length) {
//            throw new VectorIndexOutOfBoundsException("Index Out of Bounds!");
//        } else {
            return vector[i];
    }
    /**
     * Gets the length of the Vector.
     * @return number of components in vector
     */
    public int getLength() {
        return length;
    }
    /**
     * String representation of vector with components
     * separated by tabs
     * @return String representation of vector
     */
    public String toString() {
        String aString = "";
        for (int i = 0; i < length; i++) {
            aString = aString + vector[i] + "\t";
        }
        return aString;
    }
}
