class Demo {
    public static void main(String[] args) {

        int x = 0;
        
        // --- WHILE LOOP ---
        while(x < 5) {
            System.out.println("While Loop: " + x);
            x++;
        }
        System.out.println("Bye while loop!");

        // --- DO-WHILE LOOP ---
        do {
            System.out.println("Do-While Loop: " + x);
            x--;
        } while(x > 0);
        System.out.println("Bye do-while loop!");

        // --- FOR LOOP ---
        for(int i = 0; i < 5; i++) {
            System.out.println("For Loop: " + i);
        }
        System.out.println("Bye for loop!");

    }
}
