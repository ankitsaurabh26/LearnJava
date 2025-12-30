// By default EVERY CONSTRUCTOR will have its first thing as super(); -> Note, here super doesn't have any parameter

class A{
    // EVERY class in JAVA extends the Object class
    // So here class A{} can be rewritten as class A extends Object{}
    // Hence, the super() of parent class means it is calling the constructor of Object class
    public A(){
        // super();
        System.out.println("Constructor of class A is called");
    }
    public A(int n){
        // super();
        System.out.println("int n = " + n + " is called");
    }
}

class B extends A{
    public B(){
        // super();
        System.out.println("Constructor of class B is called");
    }
    public B(int x){
        // super(); // here since no parameter is there so default super class constructor is called

        super(x); // this will call the super class (which is class A in this case) and since we have sent a parameter here, so paramaterized constructor will be called
        
        // this(); // this statement here will call the default constructor of class B

        System.out.println("int x = " + x + " is called");
    }
}

public class Demo9Inheritance {
    public static void main(String[] args) {
        B ob1 = new B(5);
    }
}
