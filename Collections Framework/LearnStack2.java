import java.util.Stack;

public class LearnStack2 {
    public static void main(String[] args) {

        Stack<String> animals = new Stack<>();
        animals.push("Lion");
        animals.push("Donkey");
        animals.push("Horse");
        animals.push("Cat");

        System.out.println("Stack : " + animals);

        String top_element = animals.peek();
        System.out.println("Peak (top element): " + top_element);

        animals.pop(); // takes out the top element
        System.out.println(animals.peek());

    }
}
