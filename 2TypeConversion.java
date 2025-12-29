class CastingMasterclass {
    public static void main(String args[]) {
        
        System.out.println("---  SCENARIO 1: WIDENING (Safe & Automatic) ---");
        // Rule: Small Container -> Big Container. No data loss!
        byte smallCup = 10;
        int bigBucket = smallCup;   // byte (8-bit) fits easily into int (32-bit)
        long giantTank = bigBucket; // int fits into long (64-bit)
        float swimmingPool = giantTank; // Long fits into float (uses scientific notation)

        System.out.println("byte to int: " + bigBucket);
        System.out.println("long to float: " + swimmingPool);
        System.out.println();


        System.out.println("---  SCENARIO 2: NARROWING (Risky & Manual) ---");
        // Rule: Big Container -> Small Container. Must use (type) "permit"!
        double ocean = 99.99;
        int glass = (int) ocean; // Data Loss! The .99 is chopped off (truncation) 🪚
        
        System.out.println("double 99.99 to int: " + glass);

        // The "Modulo" Effect (Overflow)
        int a = 259;
        byte b = (byte) a; // byte range is 256 values (-128 to 127)
        // Math: 259 % 256 = 3
        System.out.println("int 259 to byte: " + b + " (Wrap-around effect!)");
        System.out.println();


        System.out.println("---  SCENARIO 3: THE DECIMAL TRAP ---");
        // Rule: All decimals are 'double' by default. Need 'f' for float!
        // float price = 19.99; // ❌ This would fail
        float price = 19.99f;   // ✅ Added the 'f' tag
        
        System.out.println("Float price with 'f' tag: " + price);
        System.out.println();


        System.out.println("---  SCENARIO 4: TYPE PROMOTION IN MATH ---");
        // Rule: Java promotes byte/short/char to 'int' during math operations!
        byte v1 = 10;
        byte v2 = 20;

        // int result = v1 * v2; // ✅ Works! Result is automatically an int.
        int product = v1 * v2; 
        
        // Forced back to byte (The Overflow Example)
        byte overflowed = (byte)(v1 * v2); // 200 becomes -56 due to wrap-around
        
        System.out.println("Normal Product (int): " + product);
        System.out.println("Overflowed Product (byte): " + overflowed + " (10*20 = 200, which is > 127!)");
    }
}