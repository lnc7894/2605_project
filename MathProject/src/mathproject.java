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
}
