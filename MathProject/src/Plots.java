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
        final NumberAxis xAxis = new NumberAxis(-8, 4, 1);
        final NumberAxis yAxis = new NumberAxis(-8, 1, 1);
        final BubbleChart<Number,Number> blc = new
            BubbleChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Det");
        yAxis.setLabel("Trace");
        blc.setTitle("Det vs Trace");

        //For First Plot
        double[] detData = new double[999]; // x
        double[] traceData = new double[999]; // y
        double[] iterations = new double[999];

        //For Second Plot
        double[] detInverseData = new double[999]; // x
        double[] traceInverseData = new double[99]; // y
        double[] iterationsInverse = new double[999];

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

            // Inverse Matrix
            matrix = mathproject.inverse(matrix);
            PowerReturn bReturn = power_method(matrix, vector, .00005, 100);
            double absEValueMin = Math.abs(bReturn.getValue()); // this is part b bullet 3
            detInverseData = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
            traceInverseData[i] = matrix[0][0] + matrix[1][1];
            iterationsInverst[i] = bReturn.getIterations();
        }

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Product 1");
        series1.getData().add(new XYChart.Data(3, 35));
        series1.getData().add(new XYChart.Data(12, 60));
        series1.getData().add(new XYChart.Data(15, 15));
        series1.getData().add(new XYChart.Data(22, 30));
        series1.getData().add(new XYChart.Data(28, 20));
        series1.getData().add(new XYChart.Data(35, 41));
        series1.getData().add(new XYChart.Data(42, 17));
        series1.getData().add(new XYChart.Data(49, 30));
                       
        Scene scene  = new Scene(blc);
        blc.getData().addAll(series1);           
        stage.setScene(scene);
        stage.show();
    }

    }
	public static void main(String[] args) {
        launch(args);
    }
}
