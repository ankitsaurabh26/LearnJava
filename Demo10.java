import FDemo10.Calc; // Importing the Calc class from the FDemo10 package
import FDemo10.Demo10other.*; // Importing class A from the FDemo10.Demo10other package 
// * means all the files in that package
// In java . is used to denote packages and sub-packages

class AdvancedCalc extends Calc{

    public int multiply(int a, int b) {
        return a * b;
    }

}

// This [class SamePackageDemo extends Ocean{...}] will give error because Ocean is not public (it is default), so it cannot be accessed outside its package. But if Ocean is made public then it can be accessed here.

// class SamePackageDemo extends Ocean{
//     public void show(){
//         display();
//     }
// } 


public class Demo10 {
    public static void main(String[] args) {
        AdvancedCalc calculator = new AdvancedCalc();
        int product = calculator.add(5, 4);
        System.out.println("The sum is: " + product);
        System.out.println("--- Calling Demo method from Calc class ---" );
        calculator.demo();

        Animal obj = new Animal();
        System.out.println("Rank: " + obj.rank); // Accessing public member from another package

        // System.out.println("Speed: " + obj.speed); // Accessing default member from another package will give error

        // System.out.println("Habitat: " + obj.habitat); // Accessing protected member from another package will give error

        // System.out.println("Type: " + obj.type); // Accessing private member will give error

        System.out.print("Private variable 'Type' accessed via getter: "+obj.showType()); // Accessing private member via public method

        // ------------------------------------------------------------
        // Check "SamePackageDemo" class that extends Ocean class, Ocean class is default (not public) so it cannot be accessed here, it can only be accessed within its own package.

        // SamePackageDemo spd = new SamePackageDemo();
        // spd.show();

    }
}
