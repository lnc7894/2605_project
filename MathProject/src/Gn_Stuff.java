import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
        double parameterA = scan.nextDouble();

        System.out.println("Guess the parameter B");
        double parameterB = scan.nextDouble();
        
        System.out.println("Guess the paraneter C");
        double parameterC = scan.nextDouble();

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
        double parameterA = scan.nextDouble();

        System.out.println("Guess the parameter B");
        double parameterB = scan.nextDouble();
        
        System.out.println("Guess the paraneter C");
        double parameterC = scan.nextDouble();

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
        double parameterA = scan.nextDouble();

        System.out.println("Guess the parameter B");
        double parameterB = scan.nextDouble();
        
        System.out.println("Guess the paraneter C");
        double parameterC = scan.nextDouble();

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
        double parameterA = scan.nextDouble();

        System.out.println("Guess the parameter B");
        double parameterB = scan.nextDouble();
        
        System.out.println("Guess the paraneter C");
        double parameterC = scan.nextDouble();

        System.out.println("Guess the number of iterations");
        double numberOfIterations = scan.nextDouble();
    }
    
    public static void main(String[] args) {
        gn_qua();
    }
}
