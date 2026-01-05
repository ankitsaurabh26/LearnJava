import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(5);
        nums.add(19); // adds 19 at the end of the List
        System.out.println(nums);

        nums.add(1, 2); // adds 50 at index 1
        System.out.println(nums);

        List<Integer> newList = new ArrayList<>();
        newList.add(123);
        newList.add(611);

        nums.addAll(newList); // This will add all the elements of newList at the end of nums
        System.out.println(nums);

        System.out.println(nums.get(4)); // get element at index index 4

        nums.remove(2); // removes the element present at index 2
        System.out.println(nums);

        nums.remove(Integer.valueOf(19)); // removes the Integer whose value is 19
        System.out.println(nums);

        nums.set(2, 1000); // replaces the element at index 2 with value 1000
        System.out.println(nums);

        System.out.println(nums.contains(50)); // checks if an element is present or not

        for (int i = 0; i < nums.size(); i++) {
            System.out.println("The element is : " + nums.get(i));
        }

        for (Integer element : nums) {
            System.out.println("for each loop : " + element);
        }

        Iterator<Integer> it = nums.iterator();

        while (it.hasNext()) {
            System.out.println("Iterator : " + it.next());
        }

        nums.clear(); // clears the entire list
        System.out.println(nums); // Empty list

    }
}
