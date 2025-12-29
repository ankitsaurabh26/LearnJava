class Hello {
public static void main(String a[] ) {
    int num1 = 5_000; // You can use underscores in numeric literals to make them more readable
    float num2 = 10.3f;
    // When you write float num = 10.3;, Java looks at the right side of the = first. It sees 10.3 and immediately creates it as a Double (the high-quality version - more precision).
    double num = num1 + num2; 
    byte byt = 127; // byte can hold values from -128 to 127
    boolean bull = true;
    char ch = 'A'; // char holds a single character/letter or ASCII values
    ch++;
    System.out.println(ch);
    System.out.println(num);
    }
}