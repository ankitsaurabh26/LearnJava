// In JAVA not everything is treated as an object. There are 8 primitive data types in JAVA: byte, short, int, long, float, double, char, boolean. These data types are not objects and do not have methods. However, sometimes we need to treat these primitive data types as objects. For this purpose, JAVA provides wrapper classes for each primitive data type such as Integer for int, Double for double, Character for char, etc.

public class Demo12 {
    public static void main(String[] args) {
        // Wrapper class
        int num = 11;
        // Integer is a class that wraps a primitive int, similar to this there are other wrapper classes like Double, Float, Character, etc. Why do we need wrapper classes? Because sometimes we need to treat primitive data types as objects, for example when working with collections like ArrayList which can only store objects.
        Integer wrapperNum = Integer.valueOf(num); // Boxing : Converting primitive to wrapper object
        Integer anotherWrapperNum = num; // Autoboxing : here num is automatically converted to Integer object, no need to explicitly call valueOf()
        
        int unboxedNum = wrapperNum.intValue(); // Unboxing : Converting wrapper object back to primitive
        int anotherUnboxedNum = anotherWrapperNum; // Auto-unboxing : here anotherWrapper, no need to explicitly call intValue() 

        System.out.println("Wrapped Integer: " + wrapperNum);
        System.out.println("Another Wrapped Integer (Autoboxing): " + anotherWrapperNum);
        System.out.println("Unboxed int: " + unboxedNum);
        System.out.println("Another Unboxed int (Auto-unboxing): " + anotherUnboxedNum);

        String strNum = "123";
        // Converting String to Integer using parseInt() method
        int parsedNum = Integer.parseInt(strNum); // here Integer.parseInt() converts String to primitive int
        System.out.println("Parsed int from String: " + parsedNum*10);
        // Here parseInt() is a static method of Integer class that converts a String to a primitive int.
    }
}
