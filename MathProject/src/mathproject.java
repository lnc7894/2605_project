import org.apache.commons.math3.linear.*;
import java.util.*;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

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

    public static void thousandGen() extends Application{
    	PlotFrame[] pf = new PlotFrame[4];
    	String[] key = {"1", "2", "3", "4", "5"};
    	double[] detData = new double[999]; // x
        double[] traceData = new double[999];// y
        double[] iterations = new double[999];
        double[] detInverseData = new double[999]; // x
        double[] traceInverseData = new double[99]; // y
        double[] iterationsInverse = new double[999];
        for (int i = 0; i < 1000; i++) {
            Random rand = new Random();
            double ii = rand.nextDouble() * 4 - 2;
            double ij = rand.nextDouble() * 4 - 2;
            double ji = rand.nextDouble() * 4 - 2;
            double jj = rand.nextDouble() * 4 - 2;
            double[][] matrix = {{ii, ij}, {ji, jj}};
            double trace = ii + jj;
            double det = (ii * jj) - (ji * ij);
            double[] vector = {1, 0};
            PowerReturn aReturn = power_method(matrix, vector, .00005, 100);
            detData[i] = det;
            traceData[i] = trace;
            iterations[i] = aReturn.getIterations();
            double absEValueMax = Math.abs(aReturn.getValue()); // this is part b bullet 2
            matrix = inverse(matrix);
            double traceInverse = ii + jj;
            double DetInverse = (ii * jj) - (ji * ij);
            PowerReturn bReturn = power_method(matrix, vector, .00005, 100);
            double absEValueMin = Math.abs(bReturn.getValue()); // this is part b bullet 3
            detInverseData[i] = DetInverse;
            traceInverseData[i] = traceInverse;
            iterationsInverse[i] = bReturn.getIterations();
        }
    	
        stage.setTitle("Power Method Graph 1");
        final NumberAxis xAxis = new NumberAxis(-8, 4, 1);
        final NumberAxis yAxis = new NumberAxis(-4, 4, 1);
        final BubbleChart<Number,Number> blc = new BubbleChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Determinant");
        yAxis.setLabel("Trace");
        blc.setTitle("Power Method Graph 1");
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Product 1");
        series1.getData().add(detData, traceData, iterations ));
                       
        Scene scene  = new Scene(blc);
        blc.getData().addAll(series1, series2);           
        stage.setScene(scene);
        stage.show();

        stage.setTitle("Power Method Graph 2");
        final NumberAxis xAxis = new NumberAxis(1, 53, 4);
        final NumberAxis yAxis = new NumberAxis(0, 80, 10);
        final BubbleChart<Number,Number> blc = new BubbleChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Determinant");
        yAxis.setLabel("Trace");
        blc.setTitle("Power Method Graph 2");
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Product 1");
        series1.getData().add(detData, traceData, iterationsInverse );
                       
        Scene scene  = new Scene(blc);
        blc.getData().addAll(series1, series2);           
        stage.setScene(scene);
        stage.show();
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
        
//        double[] beta = {a,b,c};
//        RealVector Beta = new ArrayRealVector(beta);
//        // x is in the list of points we get from the folks
//        double[] P = {0}; // list of points we get from before. this is wehre we get x from
//        float x = 0;
//        double funct = a*(Math.pow(x, 2)) + b*x + c;
    }
    
    public void gn_exp() {
        
    }
    
    public void gn_log() {
        // base 10 log
    }
    
    public void gn_rat() {
        
    }
    
    //changed to output RealMatrix
    public static RealMatrix qr_fact_househ(double[][] matrix) {
        //need magnitude
        int m = matrix[0].length;
        int n = matrix.length;
        double[][] I = new double[matrix.length][matrix[0].length];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (i==j){
                    I[i][j] = 1;
                }
                else{
                    I[i][j] = 0;
                }
            }
        }
        double[] subMatrix = {matrix[0][0],matrix[1][0],matrix[2][0]};
        double magSubMatrix = magnitude(subMatrix);
        double[] subMatrixB = subMatrix;
        if (subMatrix[0] > 0) {
            subMatrixB[0] = subMatrix[0] + magSubMatrix;
        } else if (subMatrix[0] < 0) {
            subMatrixB[0] = subMatrix[0] - magSubMatrix;
        }
        RealVector sub = new ArrayRealVector(subMatrixB);
        RealVector unit = sub.mapDivide(magSubMatrix);
        int unitLength = unit.getDimension();
        double[][] M = new double[unitLength][unitLength];
        for(int j = 0; j < unitLength; j++) {
            for(int i = 0; i < unitLength; i++) {
                M[i][j] = unit.getEntry(j);
            }
        }
        RealMatrix unitTrans = new Array2DRowRealMatrix(M);
        Double[][] HHunit = new Double[unitLength][unitLength];
        for(int a = 0; a < unitLength; a++) {
           for(int b = 0; a < unitLength; b++) {
               //HHunit[a][b] = unit.getEntry(0) * unitTrans
           }
        }
        return unitTrans;
    }
    
    // changed from double[][] to RealMatrix
    public static RealMatrix qr_fact_givens(double[][] matrix) {
        // initialized indexes
        double[][] A = matrix;
        int m = matrix[0].length - 1;
        int n = matrix.length - 1;
        double[][] Gn = new double[matrix.length][matrix.length];
        double[][] Qi = new double[matrix.length][matrix.length];
        // make Gn the identity matrix
        if (isSquare(A)) {
            for (int i=0; i<m + 1; i++){ // + 1
                for (int j=0; j<n + 1; j++){ // + 1
                    if (i==j){
                        Gn[i][j] = 1;
                        Qi[i][j] = 1;
                    }
                    else{
                        Gn[i][j] = 0;
                        Qi[i][j] = 0;
                    }
                }
            }
            RealMatrix Q = new Array2DRowRealMatrix(Qi);
            RealMatrix An = new Array2DRowRealMatrix(A);
            if (isSquare(A)) {
                n = n - 1;
            }
            for (int j = 0; j < n + 1; j++) {
                for (int i = 0; i < m + 1; i++) {
                    if (i != j && i > j) {
                        // this loop will make Gn the identity again. k and l are i and j but i ran out of variables
                        for (int k=0; k<m + 1; k++){ // + 1
                            for (int l=0; l<n + 2; l++){ // + 2
                                if (k==l){
                                    Gn[k][l] = 1;
                                }
                                else{
                                    Gn[k][l] = 0;
                                }
                            }
                        }
                        System.out.println("i: " + i);
                        System.out.println("j: " + j);
                        double c = A[j][j]/(Math.sqrt(Math.pow(A[j][j], 2) + Math.pow(A[i][j], 2)));
                        double s = -A[i][j]/(Math.sqrt(Math.pow(A[j][j], 2) + Math.pow(A[i][j], 2)));
                        System.out.println("Ajj: " + A[j][j]);
                        System.out.println("c: " + c);
                        System.out.println("s: " + s);
                        int x = i;
                        int y = j;
                        //G is an mxn identity
                        //System.out.println("G before c + s: " + G);
                        Gn[y][y] = c;
                        Gn[y][x] = -s;
                        Gn[x][y] = s;
                        Gn[x][x] = c;
                        
                        RealMatrix G = new Array2DRowRealMatrix(Gn);
                        //using c and s
                        //A = Gn*A; 
                        System.out.println("G: " + G);
                        An = G.multiply(An);
                        System.out.println("An: " + An);
                        Q = Q.multiply(G.transpose());
                        System.out.println("Row Dim: " + An.getRowDimension());
                        System.out.println("Col Dim: " + An.getColumnDimension());
                        A = An.getData();
                        /*for (int a1 = 0; a1 < A[0].length; a1++) {
                            for (int b1 = 0; b1 < A.length; b1++) {
                                System.out.println(A[a1][b1]);
                            }
                        }*/ 
                    }
                }
            }
            RealMatrix R = An; // need to subtract m - n rows
            System.out.println("R " + R);
            RealMatrix Qn = Q; //need to subtract m - n cols
            System.out.println("Q " + Qn);
        }
        // non square
        else {
            for (int i=0; i<m + 2; i++){ // + 1
                for (int j=0; j<n + 1; j++){ // + 1
                    if (i==j){
                        Gn[i][j] = 1;
                        Qi[i][j] = 1;
                    }
                    else{
                        Gn[i][j] = 0;
                        Qi[i][j] = 0;
                    }
                }
            }
            RealMatrix Q = new Array2DRowRealMatrix(Qi);
            RealMatrix An = new Array2DRowRealMatrix(A);
            if (isSquare(A)) {
                n = n - 1;
            }
            for (int j = 0; j < n + 1; j++) {
                for (int i = 0; i < m + 2; i++) {
                    if (i != j && i > j) {
                        // this loop will make Gn the identity again. k and l are i and j but i ran out of variables
                        for (int k=0; k<m + 1; k++){ // + 1
                            for (int l=0; l<n + 1; l++){ // + 2
                                if (k==l){
                                    Gn[k][l] = 1;
                                }
                                else{
                                    Gn[k][l] = 0;
                                }
                            }
                        }
                        System.out.println("i: " + i);
                        System.out.println("j: " + j);
                        System.out.println("An: " + An);
                        double c = A[j][j]/(Math.sqrt(Math.pow(A[j][j], 2) + Math.pow(A[i][j], 2)));
                        double s = -A[i][j]/(Math.sqrt(Math.pow(A[j][j], 2) + Math.pow(A[i][j], 2)));
                        System.out.println("Aij: " + A[i][j]);
                        System.out.println("c: " + c);
                        System.out.println("s: " + s);
                        int x = i;
                        int y = j;
                        //G is an mxn identity
                        //System.out.println("G before c + s: " + G);
                        Gn[y][y] = c;
                        Gn[y][x] = -s;
                        Gn[x][y] = s;
                        Gn[x][x] = c;
                        
                        RealMatrix G = new Array2DRowRealMatrix(Gn);
                        //using c and s
                        //A = Gn*A; 
                        System.out.println("G: " + G);
                        //System.out.println("G row dimensions: " + G.getRowDimension());
                        //System.out.println("G col dimensions: " + G.getColumnDimension());
                        //System.out.println("An row dimensions: " + An.getRowDimension());
                        //System.out.println("An col dimensions: " + An.getColumnDimension());
                        An = G.multiply(An);
                        System.out.println("An: " + An);
                        Q = Q.multiply(G.transpose());
                        //System.out.println("Row Dim: " + An.getRowDimension());
                        //System.out.println("Col Dim: " + An.getColumnDimension());
                        A = An.getData();
                        /*for (int a1 = 0; a1 < A[0].length; a1++) {
                            for (int b1 = 0; b1 < A.length; b1++) {
                                System.out.println(A[a1][b1]);
                            }
                        }*/ 
                    }
                }
            }
            // cut off rows
            RealMatrix R = An; // need to subtract m - n rows
            System.out.println("R " + R);
            RealMatrix Qn = Q; //need to subtract m - n cols
            System.out.println("Q " + Q);
        }
        
        // probably needs to be an object because i need to return both Q and R. 
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
    public static boolean isSquare(double[][] matrix) {
        return (matrix.length == matrix[0].length);
    }
    
    // was making this for householder and was going to do first column, but should we do this for vectors as well?
    public static double magnitude(double[] vector) {
        double norm = 0;
        for (int i = 0; i < vector.length; i++) {
            norm += Math.pow(vector[i], 2);
        }
        return (double) Math.sqrt(norm);
    }
    
    public static void main(String[] args) {
        int iter = 5;
        double eps = .1;
        double[][] matrix = {{1,0},{0,1},{6,0}};
        double[] vect = {1,0};
        System.out.println("M stuff idk : " + qr_fact_givens(matrix));
        //thousandGen();
        //System.out.println("Iterations: " + power_method(matrix, vect, eps, iter).getIterations());
        //System.out.println("Eigenvalue: " + power_method(matrix, vect, eps, iter).getValue());
        //System.out.println("Eigenvector: " + power_method(matrix, vect, eps, iter).getVector());
    }
    
    
}