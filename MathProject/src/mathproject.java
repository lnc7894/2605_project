import java.util.Vector;


public class mathproject {
    
    //Vector<Float> v = new Vector<>();
    public void power_method(Matrix matrix, float[] vector, float epsilon, int iterations) {
        for (int i = 0; i <= iterations; i++) {
            Matrix temp = matrix.multiply(matrix, matrix);
            float[] vtemp = vector;
            
            //need to add in judy's files for matrix multiplication etc.
        }
    }

}
