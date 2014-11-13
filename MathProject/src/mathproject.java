import java.util.Scanner;
import java.util.Vector;


public class mathproject {
    
    //Vector<Float> v = new Vector<>();
    public void power_method(Matrix matrix, float[] vector, float epsilon, int iterations) {
        for (int i = 0; i <= iterations; i++) {
            Matrix temp = matrix.multiply(matrix, matrix);
            float[] vtemp = vector;
            //in order to multiply the matrix and the vector for the power method,
            // we need judy's linearalgebra and vector files, so i added them
            //but they are messed up and I'm not quite sure how to fix them.
            
            //need to add in judy's files for matrix multiplication etc.
        }
    }
    
    public void gn_qua() { //not void, just void for now
        Scanner scan = new Scanner(System.in);
        //forgot how to do text files
        
        //prompt user for guesses
        System.out.println("Enter initial guesses for a, b, c");
        float a = scan.nextFloat();
        float b = scan.nextFloat();
        float c = scan.nextFloat();
        
        // get number of iterations
        System.out.println("Enter number of iterations");
        int iter = scan.nextInt();
    }
    
    public void gn_exp() {
        
    }
    
    public void gn_log() {
        
    }
    
    public void gn_rat() {
        
    }
    
    public float[][] qr_fact_househ(float[][] matrix) {
        //need determinant
        return null;
    }
    
    public float[][] qr_fact_givens(float[][] matrix) {
        
        return null;
    }
    
    public float determinant(float[][] matrix) {
        float det = 0;
        if (matrix.length != matrix[0].length) {
            return Float.MAX_VALUE; // not sure if we should throw an exception or not
        }
        // when 2x2
        if (matrix.length == 2 && matrix[0].length == 2) {
            float a = matrix[0][0];
            float b = matrix[0][1];
            float c = matrix[1][0];
            float d = matrix[1][1];
            det = 1/((a*d) - (b*c));
        }
        
        // when 3x3 and up
        if (matrix.length > 2 && matrix[0].length > 2) {
            // do stuff
        }
        return det;
    }
    
}
