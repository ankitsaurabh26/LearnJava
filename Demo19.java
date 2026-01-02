class A implements Runnable{
    public void run(){
        for(int i = 0; i<6; i++){
            System.out.println("Hi");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class B implements Runnable{
    public void run(){
        for(int i = 0; i<6; i++){
            System.out.println("Hello");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}

public class Demo19 {
    public static void main(String[] args) {
        A obj1 = new A(); // here obj1 is Runnable object
        B obj2 = new B();
        
        Thread t1 = new Thread(obj1); // Thread also take Runnable as a parameter
        Thread t2 = new Thread(obj2);

        t1.start(); // start() works with "Thread" class
        t2.start();

    }
}
