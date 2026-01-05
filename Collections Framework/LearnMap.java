import java.util.HashMap;
import java.util.Map;

public class LearnMap {
    public static void main(String[] args) {
        Map<String, Integer> mpp = new HashMap<>(); // TreeMap sorts on the basis of keys
        mpp.put("One", 1);
        mpp.put("Two", 2);
        mpp.put("Three", 3);

        if (!mpp.containsKey("Two")) {
            mpp.put("Four", 4);
        }

        mpp.putIfAbsent("Five", 5);

        mpp.remove("Two");
        System.out.println(mpp);
        System.out.println(mpp.containsValue(45));
        System.out.println(mpp.isEmpty());
        System.out.println("-----------------------------");

        for (Map.Entry<String, Integer> e : mpp.entrySet()) {
            System.out.println(e);
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println("**************************");
        }
    }
}
