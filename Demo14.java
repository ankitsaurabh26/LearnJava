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

        // Anonymous class can have only methods which are already there in the main class if you are storing it in a variable. You can add features to it with some helper function though
        A anonymous = new A(){
            public void show(){
                System.out.println("Modified the show in anonymous cls");
                helper();
            }
            public void helper(){
                System.out.println("Added more features to the show");
            }
        };


        anonymous.show();

        // This works because we haven't stored it in a 'Type A' variable yet!
        new A(){
            public void hey(){
                System.out.println("Hello Anonymous Class");
            }
        }.hey();
        
    }
}
