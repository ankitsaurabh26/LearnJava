class Human{
    private String name;
    private int age;

    // ALWAYS do operations inside methods, not directly in class body

    // Constructor: Constructor name must be same as class name
    // it's like function but no return type

    // Default Constructor
    public Human(){
        age = 18;
        name = "Unknown";
        System.out.println("--- Inside default constructor ---");
    } // Everytime an object is created, constructor is called

    // Parameterized Constructor
    public Human(String n, int a){
        name = n;
        age = a;
        System.out.println("--- Inside the parameterized constructor ---");
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
}


public class Demo8 {
    public static void main(String[] args){
        Human h1 = new Human();
        Human h2 = new Human("Bob", 34);

        System.out.println(h1.getName());
        System.out.println(h1.getAge());

        System.out.println(h2.getName());
        System.out.println(h2.getAge());

        System.out.println("--- End of main ---");
    }
}
