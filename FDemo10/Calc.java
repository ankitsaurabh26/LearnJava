package FDemo10; // Folder name is FDemo10 which has Calc.java
import FDemo10.Demo10other.*; // Importing Animal class from FDemo10.Demo10other package

public class Calc extends Animal {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }

    public void demo() {
        
        rank = 67;
        System.out.println("Rank: " + rank); // Accessing public member from parent class

        System.out.println("Accessing protected member 'habitat' from Calc class which extends Animal class: " + this.habitat); // Accessing protected member from parent class

        System.out.println("--- Demo of Calc class ends here ---");
    }
}
