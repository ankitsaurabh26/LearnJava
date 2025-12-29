class Calculator {

    int variable; // Instance variable

    public int add(int a, int b) { // Method to add two numbers
        return a + b;
    }    

}

public class AboutClass {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        int sum = num1 + num2;
        
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

        // Let's use the Calculator class and create an object
        Calculator calc = new Calculator(); // Imagine Calculator as a type in the L.H.S and an object in the R.H.S

        int result = calc.add(1,2); // Calling the add method
        
        System.out.println("The result from Calculator's add method is: " + result);
    }
}
