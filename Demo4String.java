public class Demo4String {
    public static void main(String[] args) {
        String name = new String();
        // String name = "Amy";
        name = "Alice";
        System.out.println(name);
        System.out.println(name.hashCode());
        System.out.println(name.charAt(0));

        // Demonstrating string interning: If two string literals have the same content,
        // they refer to the same object in the string pool.
        System.out.println("----- String Interning -----");
        String s1 = "alice";
        String s2 = "alice";
        System.out.println(s1 == s2); // true, same reference
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println("----- String Immutable -----");
        // Strings are immutable in Java. Any modification creates a new string object.
        String s3 = s1.toUpperCase();  
        System.out.println(s3); // "ALICE"
        System.out.println(s1); // "alice"

        System.out.println("----- StringBuffer -----");
        // StringBuffer is mutable and can be modified without creating new objects. -> It gives 16 bits of extra space
        StringBuffer sb1 = new StringBuffer("Amine");
        StringBuffer sb2 = sb1;
        System.out.println(sb1.capacity()); // 21 (16 + length of initial string)
        System.out.println(sb1.length()); // 5
        sb1.deleteCharAt(2); // Deletes characters from index 2 to 3
        System.out.println(sb1); // "Amne"
        System.out.println(sb2); // "Amne"
        sb1.insert(1,"j"); // Inserts 'j' at index 1
        System.out.println(sb1); // "Ajmne"

        // StringBuilder is not thread-safe but faster than StringBuffer for single-threaded operations which means it doesn't have synchronized methods. In simple words, multiple threads can access StringBuilder object simultaneously.

        System.out.println("----- StringBuilder -----");    
        StringBuilder sbd1 = new StringBuilder("Hello");
        StringBuilder sbd2 = sbd1;
        sbd1.deleteCharAt(1);
        System.out.println(sbd1); // "Hllo"
        System.out.println(sbd2); // "Hllo"

    }
}
