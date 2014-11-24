import org.apache.commons.math3.linear.*;

public class qr_fact_givens {
    
    private RealMatrix Q,R,G,Gn,A,An,Qi,Ri;
    
    public qr_fact_givens(RealMatrix A) {
        this.A = A;
        An = A;
        givens(A);
    }
    
    private void givens(RealMatrix A) {
        int inc;
        G = mathproject.identityMatrix(A.getRowDimension());
        if (A.isSquare()) {
            inc = A.getColumnDimension() - 1;
        } else {
            inc = A.getColumnDimension();
        }
        for (int i = 0; i < inc; i++) {
            double row = An.getEntry(i, i);
            for (int j = 0; j < A.getRowDimension(); j++) {
                    if (i != j && j > i) {
                        Gn = mathproject.identityMatrix(A.getRowDimension());
                        double col = An.getEntry(j, i);
                        double c = (row) / (Math.sqrt((Math.pow(row, 2)) + Math.pow(col, 2)));
                        double s = -1 * (col) / (Math.sqrt((Math.pow(row, 2)) + Math.pow(col, 2)));
                        Gn.setEntry(i, i, c);
                        Gn.setEntry(j, j, c);
                        Gn.setEntry(i, j, -s);
                        Gn.setEntry(j, i, s);
                        An = Gn.multiply(An);
                        G = G.multiply(Gn.transpose());

                    }
            }
            Qi = G;
            Ri = An;
            double[][] rparam = new double[A.getColumnDimension()][A.getColumnDimension()];
            for (int rows = 0; rows < A.getColumnDimension(); rows++) {
                for (int cols = 0; cols < A.getColumnDimension(); cols++) {
                    rparam[rows][cols] = Ri.getEntry(rows, cols);
                }
            }
            R = new Array2DRowRealMatrix(rparam);
            double[][] qparam = new double[A.getRowDimension()][A.getColumnDimension()];
            for (int rows = 0; rows < A.getRowDimension(); rows++) {
                for (int cols = 0; cols < A.getColumnDimension(); cols++) {
                    qparam[rows][cols] = Qi.getEntry(rows, cols);
                }
            }
            Q = new Array2DRowRealMatrix(qparam);
        }
    }
    
    public RealMatrix getQ() {
        return Q;
    }
    
    public RealMatrix getR() {
        return R;
    }
}
