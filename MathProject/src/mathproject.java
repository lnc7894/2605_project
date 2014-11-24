import org.apache.commons.math3.linear.*;
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
     * Finds Inverse of a 2x2
     * @param matrix
     * @return
     */
    public static double[][] inverse(double[][] matrix) {
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
               //HHunit[a][b] = unit.getEntry(0) * getRow(unitTrans);
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
            RealMatrix Ri = An; // need to subtract m - n rows
            System.out.println("R " + Ri);
            RealMatrix Qa = Q.transpose(); //need to subtract m - n cols
            System.out.println("Q " + Qa);
            double[][] rparam = new double[n][n];
            for (int rows = 0; rows < n; rows++) {
                for (int cols = 0; cols < n; cols++) {
                    rparam[rows][cols] = Ri.getEntry(rows, cols);
                }
            }
            RealMatrix R = new Array2DRowRealMatrix(rparam);
            System.out.println("R new: " + R);
            double[][] qparam = new double[n][m];
            System.out.println("n + m " + n + " " + m);
            //i need q but i dont have it
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
        double[][] matrix = {{1,0,1},{0,1,1},{6,0,2},{4,3,2}};
        //double[][] matrix = {{1,0},{0,1},{6,0}};
        double[] vect = {1,0};
        //System.out.println("M stuff idk : " + qr_fact_givens(matrix));
        //thousandGen();
        //System.out.println("Iterations: " + power_method(matrix, vect, eps, iter).getIterations());
        //System.out.println("Eigenvalue: " + power_method(matrix, vect, eps, iter).getValue());
        //System.out.println("Eigenvector: " + power_method(matrix, vect, eps, iter).getVector());
    }
    
    
}