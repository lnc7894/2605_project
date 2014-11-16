import org.apache.commons.math3.linear.*;
public class mathproject {
	/**
	 * Power Method
	 * @param matrix
	 * @param vector
	 * @param epsilon
	 * @param iterations
	 */
    public PowerReturn power_method(double[][] matrix, double[] vector, double epsilon, int iterations) {
    	RealMatrix a = new Array2DRowRealMatrix(matrix);
    	RealVector v = new ArrayRealVector(vector);
    	RealVector y = v;
    	RealMatrix b = a;
    	RealVector prevV = v;
    	double prevEvalue = 0;
    	int numIterations = 0;
    	for(int i = 1; i <= iterations; i++) {
    	    b = b.multiply(a);
            v = b.operate(y);
        	double Evalue = v.dotProduct(y) / prevV.dotProduct(y);
        	if (Evalue - prevEvalue <= epsilon & i > 1) {
        		// when the method has worked
        	    prevEvalue = Evalue;
        	    numIterations = i;
        	    prevV = v;
        	    PowerReturn trieu = new PowerReturn(prevEvalue, numIterations, prevV); // method worked trieu = true
        	    return trieu; // returns the necessary values
        	} else {
        		// for when more iterations are needed
        	    prevEvalue = Evalue;
        	    prevV = v;
        	}
        	if (i == iterations) {
        		// for when the method has not worked and we have done the amount of iterations passed in
        	    PowerReturn failure = new PowerReturn(-1);
        	    return failure; //returns failure
        	}
    	}
		return null; // should never reach this
    	
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
        //need magnitude
        float[] subMatrix = {matrix[1][1],matrix[2][1],matrix[3][1]};
        float magSubMatrix = magnitude(subMatrix);
        if (subMatrix[1] < 0) {
            float[] subMatrixB = {subMatrix[1] + magSubMatrix, subMatrix[2], subMatrix[3]};
        }
        return null;
    }
    
    public float[][] qr_fact_givens(float[][] matrix) {
        
        return null;
    }
    
    //okay so i thought i needed this but probably not but if we need it later here we go
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
    
    // was making this for householder and was going to do first column, but should we do this for vectors as well?
    public float magnitude(float[] vector) {
        float norm = 0;
        for (int i = 0; i < vector.length; i++) {
            norm += Math.pow(vector[i], 2);
        }
        return (float) Math.sqrt(norm);
    }
    
}