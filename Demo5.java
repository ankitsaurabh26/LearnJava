class Mobile{
    String brand;
    int price;
    String name;
    static String category = "Electronics"; // static variable shared by all instances

    public void showDetails(){
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("-------------------");
    }

    // --- ⭐ THE STATIC METHOD ---
    public static void showCategory() {
        // This belongs to the Class. It doesn't care about m1 or m2.
        System.out.println("All mobiles belong to: " + category);
        // Note: Static methods cannot access instance variables directly
        // System.out.println("Brand: " + brand); // This would cause an error
        // They can only access static variables directly
    }

}

public class Demo5 {
    public static void main(String[] args) {

        Mobile m1 = new Mobile();
        m1.brand = "Apple";
        m1.price = 90000; 
        m1.name = "Iphone 14";
        
        Mobile m2 = new Mobile();
        m2.brand = "Samsung";
        m2.price = 70000;
        m2.name = "Galaxy S22";
        
        m1.showDetails();
        m2.showDetails();

        // Good practice is to use class name to access static variables like: 
        Mobile.category = "Gadgets";
        
        // m1.category = "Gadgets"; // This is also valid but not recommended
        
        m2.showDetails();
        Mobile.showCategory(); // Calling static method using class name
    }
}
