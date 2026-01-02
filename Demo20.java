// Thread Safe
class Counter{
    int count;
    public synchronized void increment(){ // synchronized makes sure only one thread work at a time with this method
        count++;
    }
}

public class Demo20 {
    public static void main(String[] args) throws InterruptedException{

        Counter c = new Counter();
        
        Runnable obj1 = () ->{
            for(int i = 0; i<10000 ; i++){
                c.increment();
            }
        };
        Runnable obj2 = () ->{
            for(int i = 0; i<10000 ; i++){
                c.increment();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);

    }
}
