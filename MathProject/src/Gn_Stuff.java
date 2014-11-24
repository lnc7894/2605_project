import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.math3.linear.*;

public class Gn_Stuff {

    public static void gn_qua() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Filename:");
        String fileName = scan.nextLine();
        String str = "";
        try {
            File inputFile = new File(fileName);
            FileReader reader = new FileReader(inputFile);
            BufferedReader in = new BufferedReader(reader);
            String temp;
            while((temp = in.readLine())!= null) {
                str = str + temp;
                str = str + ",";
            }
            in.close();
            //System.out.println(str);
            String[] s1 = str.split(",");
            double[] d1 = new double[s1.length];
            int i = 0;
            for (String s : s1) {
                d1[i] = Double.parseDouble(s);
                i++;
            }
            double[] x = new double[d1.length / 2];
            double[] y = new double[d1.length / 2];
            int k = 0;
            for (int j = 0; j < x.length; j++) {
                x[j] = d1[k];
                k += 2;
            }
            k = 1;
            for (int j1 = 0; j1 < y.length; j1++) {
                y[j1] = d1[k];
                k += 2;
            }
        } catch (IOException e) {
            e.printStackTrace();;
        }
        
        System.out.println("Guess the parameter A");
        double a0 = scan.nextDouble();

        System.out.println("Guess the parameter B");
        double b0 = scan.nextDouble();
        
        System.out.println("Guess the paraneter C");
        double c0 = scan.nextDouble();
        
        RealVector beta = new ArrayRealVector(new double[] {a0,b0,c0});

        System.out.println("Guess the number of iterations");
        double numberOfIterations = scan.nextDouble();
    }
    
    public static void gn_exp() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Filename:");
        String fileName = scan.nextLine();
        String str = "";
        try {
            File inputFile = new File(fileName);
            FileReader reader = new FileReader(inputFile);
            BufferedReader in = new BufferedReader(reader);
            String temp;
            while((temp = in.readLine())!= null) {
                str = str + temp;
                str = str + " ";
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();;
        }
        
        System.out.println("Guess the parameter A");
        double a0 = scan.nextDouble();

        System.out.println("Guess the parameter B");
        double b0 = scan.nextDouble();
        
        System.out.println("Guess the paraneter C");
        double c0 = scan.nextDouble();
        
        RealVector beta = new ArrayRealVector(new double[] {a0,b0,c0});

        System.out.println("Guess the number of iterations");
        double numberOfIterations = scan.nextDouble();
    }
    
    public static void gn_log() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Filename:");
        String fileName = scan.nextLine();
        String str = "";
        try {
            File inputFile = new File(fileName);
            FileReader reader = new FileReader(inputFile);
            BufferedReader in = new BufferedReader(reader);
            String temp;
            while((temp = in.readLine())!= null) {
                str = str + temp;
                str = str + " ";
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();;
        }
        
        System.out.println("Guess the parameter A");
        double a0 = scan.nextDouble();

        System.out.println("Guess the parameter B");
        double b0 = scan.nextDouble();
        
        System.out.println("Guess the paraneter C");
        double c0 = scan.nextDouble();
        
        RealVector beta = new ArrayRealVector(new double[] {a0,b0,c0});
        
        System.out.println("Guess the number of iterations");
        double numberOfIterations = scan.nextDouble();
    }
    
    public static void gn_rat() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Filename:");
        String fileName = scan.nextLine();
        String str = "";
        try {
            File inputFile = new File(fileName);
            FileReader reader = new FileReader(inputFile);
            BufferedReader in = new BufferedReader(reader);
            String temp;
            while((temp = in.readLine())!= null) {
                str = str + temp;
                str = str + " ";
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();;
        }
        
        System.out.println("Guess the parameter A");
        double a0 = scan.nextDouble();

        System.out.println("Guess the parameter B");
        double b0 = scan.nextDouble();
        
        System.out.println("Guess the paraneter C");
        double c0 = scan.nextDouble();
        
        RealVector beta = new ArrayRealVector(new double[] {a0,b0,c0});

        System.out.println("Guess the number of iterations");
        double numberOfIterations = scan.nextDouble();
    }
    
    public static void main(String[] args) {
        gn_qua();
    }
}
