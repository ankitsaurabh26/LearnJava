// Functional Interface is an interface with only one method

@FunctionalInterface
interface A {
    void show();
}

@FunctionalInterface
interface B{
    void tell(int n);
}

public class Demo16 {
    public static void main(String[] args) { 
        
        // A obj = new A() {
        //     public void show() {
        // Instead of doing all the above just use "->" : Lambda expression

        // Lambda expressions only work with Functional Interfaces.
        A obj = () ->
            System.out.println("In show");

        // };

        obj.show(); 

        // Lambda with parameters
        B objectB = (i) ->
            System.out.println("Printing value in tell : "+i);
        
        objectB.tell(67);

    }
}