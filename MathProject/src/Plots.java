import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Random;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Plots extends Application{
	
	@Override public void start(Stage stage) {
        stage.setTitle("Scatter Plot of Det vs Trace");
        final NumberAxis xAxis = new NumberAxis(-10, 8, 1);
        final NumberAxis yAxis = new NumberAxis(-10, 8, 1);
        final BubbleChart<Number,Number> blc = new
            BubbleChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Det");
        yAxis.setLabel("Trace");
        blc.setTitle("Det vs Trace");

        //For First Plot
        double[] detData = new double[1000]; // x
        double[] traceData = new double[1000]; // y
        double[] iterations = new double[1000];

        //For Second Plot
        double[] detInverseData = new double[1000]; // x
        double[] traceInverseData = new double[1000]; // y
        double[] iterationsInverse = new double[1000];

        XYChart.Series series = new XYChart.Series();
        XYChart.Series series1 = new XYChart.Series();

        //For getting data
        for (int i = 0; i < 1000; i++) {
                Random rand = new Random();
                double ii = rand.nextDouble() * 4 - 2;
                double ij = rand.nextDouble() * 4 - 2;
                double ji = rand.nextDouble() * 4 - 2;
                double jj = rand.nextDouble() * 4 - 2;
                double[][] matrix = {{ii, ij}, {ji, jj}};
                double[] vector = {1, 0};

                // Matrix 
                PowerReturn aReturn = mathproject.power_method(matrix, vector, .00005, 100);
                double absEValueMax = Math.abs(aReturn.getValue()); // this is part b bullet 2
                detData[i] = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
                traceData[i] = matrix[0][0] + matrix[1][1];
                iterations[i] = aReturn.getIterations();

                double data1 = detData[i];
                double data2 = traceData[i];
                double data3 = (iterations[i] / 100.0) + 0.0;
                series.getData().add(new XYChart.Data(data1, data2, data3));

                // Inverse Matrix
                matrix = mathproject.inverse(matrix);
                PowerReturn bReturn = mathproject.power_method(matrix, vector, .00005, 100);
                double absEValueMin = Math.abs(bReturn.getValue()); // this is part b bullet 3
                detInverseData[i] = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
                traceInverseData[i] = matrix[0][0] + matrix[1][1];
                iterationsInverse[i] = bReturn.getIterations();

                double data4 = detInverseData[i];
                double data5 = traceInverseData[i];
                double data6 = (iterationsInverse[i] / 100.0) + 0.0;
                series1.getData().add(new XYChart.Data(data4, data5, data6));
 
        }

        series.setName("More Iteratiosn #More Size");
                       
        Scene scene  = new Scene(blc);
        blc.getData().addAll(series);           
        stage.setScene(scene);
        stage.show();
    }

}
