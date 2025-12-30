class Human{
    private int age; // no one can access this variable directly outside this class
    private String name; // always keep your class variables private

    // GETTER METHODS
    public int getAge(){ // getter method to access private variable
        return age;
    }   
    public String getName(){ // getter method to access private variable
        return name;
    }

    // SETTER METHODS
    public void BeforethisSetAge(int age, Human obj){
        Human human1 = obj; // human1 is reference variable pointing to the object passed as argument
        human1.age = age; // setting value to private variable using reference variable
        // obj.age = age; // would also work here -- comment: Human human1 = obj; 
    } 

    public void setAge(int age){ // setter method to set value to private variable
        this.age = age; // 'this' keyword is used to refer to the current object's variable, [like human1.age = age_value;]
    }   

    // public void setAge(int a){ 
    //     age = a; 
    // }   // another way to write setter method

    public void setName(String name){ // setter method to set value to private variable
        this.name = name;
    }

}


public class Demo7Encapsulation {
    public static void main(String[] args) {
        Human h = new Human();

        // setting using BeforethisSetAge method
        h.BeforethisSetAge(74, h);
        System.out.println(h.getAge());

        // setting values using setter methods
        h.setName("Sama");
        h.setAge(25);

        // getting values using getter methods
        System.out.println(h.getName());
        System.out.println(h.getAge());

    }
}
