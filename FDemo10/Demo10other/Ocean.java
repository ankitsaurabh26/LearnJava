package FDemo10.Demo10other;

class Ocean{
    public void display(){
        System.out.println("--- Welcome to the Ocean class ---");

        Animal obj = new Animal(); // "Animal" class is in the same package as Ocean class, so it can be accessed here also it is public

        System.out.println("Rank: " + obj.rank); // Accessible because rank is public
        System.out.println("Habitat: "+obj.habitat); // Accessible because Ocean is in the same package as Animal
        System.out.println("Speed: "+obj.speed); // Accessible because speed has default access and Ocean is in the same package
    }
    
}
