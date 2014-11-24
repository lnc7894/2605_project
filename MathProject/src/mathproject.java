import org.apache.commons.math3.linear.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
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
        	double Evalue = v.dotProduct(y) / prevV.dotProduct(y);
        	//System.out.println("Eigenvalue" + " " + Evalue);
        	if (Evalue - prevEvalue <= epsilon && i > 1) {
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
            numIterations++;
            //System.out.println();
    	}
		return null; // should never reach this
    	
    }

    /**
     * Finds det of a 3x3 matrix yo
     * @param m
     * @return double that is the det
     */
    public static double dewy(RealMatrix m) {
    	double diana1 = m.getEntry(0, 0) * m.getEntry(1, 1) * m.getEntry(2, 2);
    	double diana2 = m.getEntry(0, 1) * m.getEntry(1, 2) * m.getEntry(2, 0);
    	double diana3 = m.getEntry(0, 1) * m.getEntry(1, 0) * m.getEntry(2, 1);
    	double diana4 = m.getEntry(2, 0) * m.getEntry(1, 1) * m.getEntry(0, 2);
    	double diana5 = m.getEntry(2, 1) * m.getEntry(1, 2) * m.getEntry(0, 0);
    	double diana6 = m.getEntry(2, 2) * m.getEntry(1, 0) * m.getEntry(0, 1);
    	double dianaFinal = (diana1 + diana2 + diana3) - (diana4 + diana5 + diana6);
    	return dianaFinal;
    }

    public static RealMatrix isabella(RealMatrix mary) {
    	//Stuff to put into Transpose
    	double A = mary.getEntry(1, 1) * mary.getEntry(2, 2) - mary.getEntry(1, 2) * mary.getEntry(2, 1);
    	double B = -(mary.getEntry(1, 0) * mary.getEntry(2, 2) - mary.getEntry(1, 2) * mary.getEntry(2, 0));
    	double C = mary.getEntry(1, 0) * mary.getEntry(2, 1) - mary.getEntry(1, 1) * mary.getEntry(2, 0);
    	double D = -(mary.getEntry(0, 1) * mary.getEntry(2, 2) - mary.getEntry(0, 2) * mary.getEntry(2, 1));
    	double E = mary.getEntry(0, 0) * mary.getEntry(2, 2) - mary.getEntry(0, 2) * mary.getEntry(2, 0);
    	double F = -(mary.getEntry(0, 0) * mary.getEntry(2, 1) - mary.getEntry(0, 1) * mary.getEntry(2, 0));
    	double G = mary.getEntry(0, 1) * mary.getEntry(1, 2) - mary.getEntry(0, 2) * mary.getEntry(1, 1);
    	double H = -(mary.getEntry(0, 0) * mary.getEntry(1, 2) - mary.getEntry(0, 2) * mary.getEntry(1, 0));
    	double I = mary.getEntry(0, 0) * mary.getEntry(1, 1) - mary.getEntry(0, 1) * mary.getEntry(1, 0);
        
    	//det
    	double daisy = dewy(mary);
        
        mary.setEntry(0, 0, A);
        mary.setEntry(0, 1, B);
        mary.setEntry(0, 2, C);
        mary.setEntry(1, 0, D);
        mary.setEntry(1, 1, E);
        mary.setEntry(1, 2, F);
        mary.setEntry(2, 0, G);
        mary.setEntry(2, 1, H);
        mary.setEntry(2, 2, I);
        mary = mary.transpose();
        
        //inverse
        mary = mary.scalarMultiply(1.0 / daisy);
        return mary;
    }

    /**
     * Finds Inverse of a 2x2
     * @param matrix
     * @return
     */
    static double[][] inverse(double[][] matrix) {
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
    
    public static RealMatrix identityMatrix(int x) {
        double[][] identity = new double[x][x];
        for (int j = 0; j < x; j++) {
            for (int i = 0; i < x; i++) {
                if (i == j) {
                    identity[i][j] = 1;                    
                }
            }
        }
        return new Array2DRowRealMatrix(identity);
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
    public static boolean isSquare(RealMatrix matrix) {
        double[][] dimensions = matrix.getData();
        return (dimensions.length == dimensions[0].length);
    }
    
    // was making this for householder and was going to do first column, but should we do this for vectors as well?
    public static double magnitude(RealVector vector) {
        double norm = 0;
        for (int i = 0; i < vector.getDimension(); i++) {
            norm += Math.pow(vector.getEntry(i), 2);
        }
        return (double) Math.sqrt(norm);
    }
    
    public static void main(String[] args) {
        double[][] m = {{1,2,3}, {0,5,6}, {0,0,9}};
        RealMatrix matthew = new Array2DRowRealMatrix(m);
        System.out.println("Inverse: " + isabella(matthew));
    }
    
    
    
}