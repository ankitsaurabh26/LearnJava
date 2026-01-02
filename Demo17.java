// import java.io.BufferedReader;
import java.io.IOException;
// import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo17 {
    public static void main(String[] args) throws IOException{
        // System.out.println(); // "out" is the object of PrintStream & this "out" object is created as a static variable under System class
        // int num = System.in.read(); // Gives ASCII value for the input
        
        System.out.print("Enter the number: ");
        
        // // METHOD 1: 
        // InputStreamReader in = new InputStreamReader(System.in);
        // BufferedReader bf = new BufferedReader(in);
        // int num = Integer.parseInt(bf.readLine()); // bf.readLine(); returns String
        // System.out.println(num);
        // bf.close();

        // METHOD 2:
        Scanner sc = new Scanner(System.in);
        int new_Num = sc.nextInt();
        System.out.println(new_Num);
        sc.close();
    }
}
