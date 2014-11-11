/**
 * Immutable abstraction of Matrix.
 *
 * @author Michael Maurer
 * @version 1.2
 */
public class Matrix {

    /*
    Create final instance variables
    */
    private final float[][] matrix;
    private final int width;
    private final int height;
    /**
     * Initialize instance variables
     * @param matrix 2D array representation of Matrix
     */
    public Matrix(float[][] matrix) {
        this.matrix = matrix;
        height = matrix.length;
        width = matrix[0].length;
    }
    /**
     * Get's the height of the matrix.
     * @return number of rows in matrix
     */
    public int getHeight() {
        return matrix.length;
    }
    /**
     * Gets the width of the matrix.
     * @return number of columns in matrix
     */
    public int getWidth() {
        return matrix[0].length;
    }
    /**
     * Gets String representation of matrix.
     * Columns separated by tabs, rows by new lines.
     * @return String representation of matrix.
     */
    public String toString() {
        String aString = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                aString = aString + matrix[i][j] + "\t";
            }
            aString = aString + "\n";
        }
        return aString;
    }
}
