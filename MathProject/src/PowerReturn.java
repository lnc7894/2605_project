import org.apache.commons.math3.linear.RealVector;

public class PowerReturn {
    //instance variables
    private double eigenValue;
    private int numberOfIterations;
    private RealVector eigenVector;

    /**
     * Constructor for 3 parameters
     * @param value
     * @param n
     * @param vector
     */
    public PowerReturn(double value, int n, RealVector vector) {
        this.eigenValue = value;
        this.numberOfIterations = n;
        this.eigenVector = vector;
    }

    /**
     * Constructor for when Power Method fails
     * @param n
     */
    public PowerReturn(int n) {
        this.numberOfIterations = n;
    }

    /**
     * Gets EigenValue
     * @return
     */
    public double getValue() {
    	return eigenValue;
    }

    /**
     * Gets # of Iterations
     * @return
     */
    public int getIterations() {
        return numberOfIterations;
    }

    /**
     * Gets EigenVector
     * @return
     */
    public RealVector getVector() {
        return eigenVector;
    }
}
