class A{
    int age;
    public void show(){
        System.out.println("Inside cls A");
    }
    class B{
        public void config(){
            System.out.println("Inner cls B");
        }
    }
}

public class Demo14 {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

        A.B obj1 = obj.new B(); // Making object of inner class
        obj1.config();
    }
}
