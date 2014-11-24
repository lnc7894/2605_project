import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Random;
public class ScatterPlots extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(ScatterPlots.class, args);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Scatter Plot of Det vs Trace");
        final NumberAxis xAxis = new NumberAxis(-8, 8, 2);
        final NumberAxis yAxis = new NumberAxis(-8, 8, 2);
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
            if (aReturn != null) {
                double absEValueMax = Math.abs(aReturn.getValue()); // this is part b bullet 2
            }
            detData[i] = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
            traceData[i] = matrix[0][0] + matrix[1][1];
            if (aReturn != null) {
                iterations[i] = aReturn.getIterations();
            }
            
            double data1 = detData[i];
            double data2 = traceData[i];
            double data3 = iterations[i] / 100 + 0.0;
            
            if (aReturn != null) {
                series.getData().add(new XYChart.Data(data1, data2, data3));
            }

            if (data1 == 0) {
                i--;
            }
            
            // Inverse Matrix
            matrix = mathproject.inverse(matrix);
            PowerReturn bReturn = mathproject.power_method(matrix, vector, .00005, 100);
            if (bReturn != null) {
                double absEValueMin = Math.abs(bReturn.getValue()); // this is part b bullet 3
            }
            detInverseData[i] = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
            traceInverseData[i] = matrix[0][0] + matrix[1][1];
            if (bReturn != null) {
                iterationsInverse[i] = bReturn.getIterations();
            }
        }

        series.setName("Mo' Iterations Mo' Size");
                       
        Scene scene  = new Scene(blc);
        blc.getData().addAll(series);           
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new CreateStage(detInverseData, traceInverseData, iterationsInverse);
    }

    class CreateStage {

        @SuppressWarnings({ "rawtypes", "unchecked" })
		public CreateStage(double[] dI, double[] tI, double[] iI) {
            //creates the stage and sets it up
            Stage stage = new Stage();
            stage.setTitle("Scatter Plot of Det vs Trace for Inverse");
            final NumberAxis xAxis = new NumberAxis(-8, 8, 2);
            final NumberAxis yAxis = new NumberAxis(-8, 8, 2);
            final BubbleChart<Number,Number> blc = new
                BubbleChart<Number,Number>(xAxis,yAxis);
            xAxis.setLabel("Det of Inverse");
            yAxis.setLabel("Trace of Inverse");
            blc.setTitle("Det vs Trace of Inverse");
            
            //creates the chart and imports the data;
            XYChart.Series series = new XYChart.Series();
            for(int i = 0; i < dI.length; i++) {
                series.getData().add(new XYChart.Data(dI[i],tI[i] ,iI[i] / 100 + 0.0));
            }
            series.setName("Mo' Iterations Mo' Size");
            
            //creates scene & displays stage
            Scene scene  = new Scene(blc);
            blc.getData().addAll(series);           
            stage.setScene(scene);
            stage.show();
       }
    }
}