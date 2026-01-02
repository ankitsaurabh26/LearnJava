abstract class Car{
    public abstract void drive(); // abstract method can only be in abstract class, hence: abstract class Car
    public abstract void fly();
    public void playMusic(){
        System.out.println("Playing Music");
    }
}

// Important: the class must implement all the abstract methods, otherwise it will also become an abstract class
abstract class BMBablu extends Car{
    public void drive(){
        System.out.println("BM-Babloo driving...");
    }
}

class UpdatedBMW extends BMBablu{ // Concrete Class
    public void fly(){
        System.out.println("Flying yrr...");
    }
}

public class Demo13 {
    public static void main(String[] args) {
        // Car obj = new Car(); // You cannot create an object of abstract class
        Car obj = new UpdatedBMW();
        obj.drive();
        obj.playMusic();
        obj.fly();
    } 
}