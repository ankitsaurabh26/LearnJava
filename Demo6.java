class Mobile{
    String brand;
    int price;
    static String country;
    
    // constructor
    public Mobile() {
        brand = "Apple";
        price = 1000;
        System.out.println("Constructor executed");
    }
    
    // static block will be executed when the class is loaded. It is executed only once.
    static {
        country = "USA";
        System.out.println("Static block executed");
    }

    // static method
    public static void show(Mobile m) {
        // System.out.println("Brand: " + brand); // This will cause an error because static methods cannot access instance variables
        System.out.println("Brand: " + m.brand); // Accessing instance variable through object reference
    }

}

public class Demo6 {
    public static void main(String[] args) {
        // WHY IS MAIN STATIC?

        // If main was public void main, the Java Virtual Machine (JVM) would need to do this: Demo6 obj = new Demo6(); obj.main();
        // The main method is supposed to be the starting line of your code. If the JVM has to create an object before it even starts, where does it put the code to create that object?

        // ANSWER:
        // Static means the method belongs to the Class, not an object.
        // The JVM can call Demo6.main() directly as soon as the program loads into memory.


        Mobile mobile1 = new Mobile();
        System.out.println("Brand: " + mobile1.brand);

        System.out.println("--- Accessing instance variable through static method ---");
        Mobile.show(mobile1); // Calling static method

    }
}
