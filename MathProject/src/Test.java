import org.apache.commons.math3.linear.*;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double[][] a = {{1,0,3},{0,3,1},{6,3,0},{3,5,6}};
        RealMatrix matrix = new Array2DRowRealMatrix(a);
        qr_fact_househ qr = new qr_fact_househ(matrix);
        System.out.println("Q: " + qr.getQ());
        System.out.println("R: " + qr.getR());

    }

}
