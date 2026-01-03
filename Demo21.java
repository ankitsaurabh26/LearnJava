import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo21 {
    public static void main(String[] args) {

        Collection<Integer> nums = new ArrayList<Integer>(); // NOTE: Collection is an interface.

        nums.add(5);
        nums.add(3);
        nums.add(9);
        nums.add(1);

        for(int n: nums){
            System.out.println(n);
        }

        List<Integer> num1 = new ArrayList<Integer>(); // List supports index value
        num1.add(56);
        num1.add(64);
        num1.add(87);
        num1.add(90);

        System.out.println(num1.get(2));
        System.out.println(num1.indexOf(64));

    }
}
