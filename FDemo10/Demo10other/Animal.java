package FDemo10.Demo10other;

public class Animal {
    int speed = 100; // default access modifier: can be accessed within the "same package"
    public int rank = 2; // public access modifier

    private String type = "Mammal"; // private access modifier: only accessible "within class", nowhere else

    protected String habitat = "Forest"; // protected access modifier: accessible "within package and subclasses"

    // Kind of getter method to access private member 'type' from outside the class
    public String showType() {
        return type;
    }

}
