class A extends Thread{
    public void run(){
        for(int i = 0; i<30; i++){
            System.out.println("Hi");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class B extends Thread{
    public void run(){
        for(int i = 0; i<30; i++){
            System.out.println("Hello");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}

public class Demo18 {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        
        // The range of the thread priority goes from 1 (least) to 10 (highest), by default 5 (normal) is the value
        System.out.println(obj1.getPriority());

        // obj2.setPriority(Thread.MAX_PRIORITY); // or you can give some value between 1 to 10

        obj1.start();
        obj2.start();

    }
}
