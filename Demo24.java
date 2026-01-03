sealed class A permits B,C{
    public void show(){
        System.out.println("Heyy");
    }
}

non-sealed class B extends A{ // this can be final, non-sealed or sealed

}

final class C extends A{

}

class D{        // This can't inherit the class A

}

public class Demo24 {
    public static void main(String[] args) {
        System.out.println("How about selected inheritance!!");
    }
}
