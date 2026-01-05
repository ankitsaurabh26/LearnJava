import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LearnSet {
    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<>();
        mySet.add(5);
        mySet.add(32);
        mySet.add(2);
        mySet.add(12);
        mySet.add(32);

        System.out.println(mySet); // prints in random order
        mySet.remove(5); // remove 5 from the set
        System.out.println(mySet);
        System.out.println(mySet.contains(100));
        System.out.println(mySet.isEmpty());
        System.out.println("Size of the set is : " + mySet.size());
        mySet.clear();
        System.out.println(mySet);

        Set<Integer> lhSet = new LinkedHashSet<>(); // order will be same in which is add element
        lhSet.add(5);
        lhSet.add(32);
        lhSet.add(2);
        lhSet.add(12);
        lhSet.add(32);

        System.out.println("Linked-Hashed Set: " + lhSet);

        Set<Integer> tst = new TreeSet<>(); // elements will be sorted
        tst.add(5);
        tst.add(32);
        tst.add(2);
        tst.add(12);
        tst.add(32);

        System.out.println("Tree-Hashed Set: " + tst);
    }
}
