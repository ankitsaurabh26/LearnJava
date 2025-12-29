class Computer{
    public void playMusic(){
        System.out.println("Playing music...");
    }
    public String getMePen(int money){
        if (money < 10){
            return "No Pen";
        }
        
        return "Here is your Pen";

    }
}

public class Demo {
    public static void main(String[] args) {

    Computer obj = new Computer();
    obj.playMusic();
    String penStatus = obj.getMePen(15);
    System.out.println(penStatus);
    }
}
