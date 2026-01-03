import java.util.HashMap;
import java.util.Map;

public class Demo23 {
    public static void main(String[] args) {

        Map<String, Integer> Students = new HashMap<>(); // doesn't follow any order
            Students.put("Navneet", 56);
            Students.put("Kishan", 76);
            Students.put("Travis", 11);
            Students.put("Rohit", 90);
            Students.put("Kishan", 16);

        System.out.println(Students);
        System.out.println(Students.get("Kishan"));
        System.out.println(Students.keySet());

        for(String key : Students.keySet()){
            System.out.println(key + ":"+Students.get(key));
        }

    }
}
