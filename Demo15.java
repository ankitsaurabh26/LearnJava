// // One way of doing the things
// abstract class Computer{
//     abstract public void code();
// }

interface Computer {
    void code();    
    // All the variables inside an interface are by default final and static
    int age = 32;
    String area = "BLR";
}

// class Laptop extends Computer{
class Laptop implements Computer{  // in case of interface we use "implements", sort of similar to extends in method 1
    public void code(){
        System.out.println("Coding for you!");
    }
}

class Desktop implements Computer{
    public void code(){
        System.out.println("Coding for you fast!");
    }
}

class Developer{
    public void devApp(Computer lappy){
        lappy.code();
    }
}

public class Demo15 {
    public static void main(String[] args) {

        Computer mac = new Laptop();
        Computer Dt = new Desktop();
        Developer BamBahadur = new Developer();
        BamBahadur.devApp(mac);
        BamBahadur.devApp(Dt);

        System.out.println(Computer.area);
    }
}
