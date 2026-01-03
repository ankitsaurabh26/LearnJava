import java.util.HashSet;
import java.util.Set;
// import java.util.TreeSet;

public class Demo22 {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<Integer>(); // No duplicate elements, no sorted order
        // Set<Integer> nums = new TreeSet<Integer>(); // For sorted value
        nums.add(11);
        nums.add(14);
        nums.add(29);
        nums.add(11);
        nums.add(11);
        nums.add(43);
        nums.add(14);

        for (int n:nums){
            System.out.println(n);
        }
    }
}
