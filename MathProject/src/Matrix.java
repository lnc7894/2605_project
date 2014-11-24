import org.apache.commons.math3.linear.*;

public class Matrix extends Array2DRowRealMatrix{
    
   int m, n; 
   Matrix(double[][] matrix) {
       super(matrix);
       m = matrix[0].length;
       n = matrix.length; 
   }
   
   public int getM() {
       return m;
   }
   
   public int getN() {
       return n;
   }
}
