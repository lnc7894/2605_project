public class mathproject {
	/**
	 * Power Method
	 * @param matrix
	 * @param vector
	 * @param epsilon
	 * @param iterations
	 */
    public void power_method(Matrix matrix, Vector vector, float epsilon, int iterations) {
        //code
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