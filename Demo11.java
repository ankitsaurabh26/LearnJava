// In Java, you can only have ONE "public" class per file. Also, the name of that public class must match the filename exactly. 

// public class Computer{...} <- hence this is wrong

class Computer {
    final int ram = 16; // final variable: cannot be changed once assigned
    // "fianl" can be used with classes,and methods as well
    // when you make final class, it cannot be inherited
    // when you make final method, it cannot be overridden
    int storage;
    // public final void show(){
    public void show(){
        System.out.println("This is a computer");
    }
}

class Laptop extends Computer {
    String brand;
    double price;
    public void show(){
        System.out.println("This is a laptop");
    }
}

public class Demo11 {
    public static void main(String[] args) {
        Computer C1 = new Laptop(); // Upcasting: this is allowed

        System.out.println("Polymorphism - Method Overriding");

        C1.show(); // This will call the Laptop's show() method due to method overriding because of dynamic method dispatch which is a runtime polymorphism feature in Java.

        C1 = new Computer(); // Now C1 references a Computer object
        C1.show(); // This will call the Computer's show() method because C1 now references a Computer object

        // Whoever's object is being referenced at runtime, their overridden method will be called.
    }
}
