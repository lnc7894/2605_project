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
