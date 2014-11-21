import org.apache.commons.math3.linear.*;

import java.util.Random;
import java.util.Scanner;
public class mathproject {
	/**
	 * Power Method
	 * @param matrix
	 * @param vector
	 * @param epsilon
	 * @param iterations
	 */
    public static PowerReturn power_method(double[][] matrix, double[] vector, double epsilon, int iterations) {
    	RealMatrix a = new Array2DRowRealMatrix(matrix);
    	RealVector v = new ArrayRealVector(vector);
    	RealVector y = new ArrayRealVector(vector);
    	RealMatrix b = new Array2DRowRealMatrix(matrix);
    	RealVector prevV = new ArrayRealVector(vector);;
    	double prevEvalue = 0;
    	int numIterations = 1;
    	for(int i = 0; i <= iterations - 1; i++) {
    	    //System.out.println(a);
    	    //System.out.println(b);
    	    b = b.multiply(a);
    	    //System.out.println(b);
    	    //System.out.println(v);
            v = b.operate(y);
            //System.out.println(v);
            //System.out.println("Iteration" + " " + numIterations);
            numIterations++;
        	double Evalue = v.dotProduct(y) / prevV.dotProduct(y);
        	//System.out.println("Eigenvalue" + " " + Evalue);
        	if (Evalue - prevEvalue <= epsilon & i > 1) {
        		// when the method has worked
        	    prevEvalue = Evalue;
        	    //numIterations = i;
        	    prevV = v;
        	    PowerReturn trieu = new PowerReturn(prevEvalue, numIterations, prevV); // method worked trieu = true
        	    return trieu; // returns the necessary values
        	} else {
        		// for when more iterations are needed
        	    prevEvalue = Evalue;
        	    prevV = v;
        	}
            //System.out.println();
    	}
		return null; // should never reach this
    	
    }

    public static void thousandGen() {
        for (int i = 0; i < 1000; i++) {
            Random rand = new Random();
            double ii = rand.nextDouble() * 4 - 2;
            double ij = rand.nextDouble() * 4 - 2;
            double ji = rand.nextDouble() * 4 - 2;
            double jj = rand.nextDouble() * 4 - 2;
            double[][] matrix = {{ii, ij}, {ji, jj}};
            double[] vector = {1, 0};
            PowerReturn aReturn = power_method(matrix, vector, .00005, 100);
            double absEValueMax = Math.abs(aReturn.getValue()); // this is part b bullet 2
            matrix = inverse(matrix);
            double absEValueMin = Math.abs(power_method(matrix, vector, .00005, 100).getValue()); // this is part b bullet 3
        }
    }

    /**
     * Finds Inverse of a 2x2
     * @param matrix
     * @return
     */
    private static double[][] inverse(double[][] matrix) {
        double det = matrix[0][0] - matrix[1][1];
        double upleft = matrix[0][0];
        double downright = matrix[1][1];
        double upright = -1 * matrix[0][1];
        double downleft = -1 * matrix[1][0];
        matrix[0][0] = downright / det;
        matrix[1][1] = upleft / det;
        matrix[0][1] = upright / det;
        matrix[1][0] = downleft / det;
        return matrix;
    }

    public void gn_qua() { //not void, just void for now
        Scanner scan = new Scanner(System.in);
        //forgot how to do text files
        
        //prompt user for guesses
        System.out.println("Enter initial guesses for a, b, c");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        
        // get number of iterations
        System.out.println("Enter number of iterations");
        int iter = scan.nextInt();
    }
    
    public void gn_exp() {
        
    }
    
    public void gn_log() {
        // base 10 log
    }
    
    public void gn_rat() {
        
    }
    
    public double[][] qr_fact_househ(double[][] matrix) {
        //need magnitude
        double[] subMatrix = {matrix[1][1],matrix[2][1],matrix[3][1]};
        double magSubMatrix = magnitude(subMatrix);
        if (subMatrix[1] < 0) {
            double[] subMatrixB = {subMatrix[1] + magSubMatrix, subMatrix[2], subMatrix[3]};
        }
        return null;
    }
    
    public double[][] qr_fact_givens(double[][] matrix) {
        // initialized indexes
        double[][] A = matrix;
        int i = 0;
        int j = 0;
        int n = matrix.length;
        if (isSquare(A)) {
            n = n - 1;
        }
        return null;
    }
    
    //okay so i thought i needed this but probably not but if we need it later here we go
    public double determinant(double[][] matrix) {
        double det = 0;
        if (matrix.length != matrix[0].length) {
            return Double.MAX_VALUE; // not sure if we should throw an exception or not
        }
        // when 2x2
        if (matrix.length == 2 && matrix[0].length == 2) {
            double a = matrix[0][0];
            double b = matrix[0][1];
            double c = matrix[1][0];
            double d = matrix[1][1];
            det = 1/((a*d) - (b*c));
        }
        
        // when 3x3 and up
        if (matrix.length > 2 && matrix[0].length > 2) {
            // do stuff
        }
        return det;
    }
    
    //check to see if the matrix is mxm
    public boolean isSquare(double[][] matrix) {
        return (matrix.length == matrix[0].length);
    }
    
    // was making this for householder and was going to do first column, but should we do this for vectors as well?
    public double magnitude(double[] vector) {
        double norm = 0;
        for (int i = 0; i < vector.length; i++) {
            norm += Math.pow(vector[i], 2);
        }
        return (double) Math.sqrt(norm);
    }
    
    public static void main(String[] args) {
        int iter = 5;
        double eps = .1;
        double[][] matrix = {{2,1},{4,5}};
        double[] vect = {1,0};
        thousandGen();
        //System.out.println("Iterations: " + power_method(matrix, vect, eps, iter).getIterations());
        //System.out.println("Eigenvalue: " + power_method(matrix, vect, eps, iter).getValue());
        //System.out.println("Eigenvector: " + power_method(matrix, vect, eps, iter).getVector());
    }
    
    
}