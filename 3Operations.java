class ConditionalOperations {
    public static void main (String[] args) {
        int x = 8;
        int result = 0;

        // if (x%2 == 0) {
        //     result = x*2;
        // } else {
        //     result = x+1;
        // }

        result = (x % 2 == 0) ? x*2 : x+1;

        System.out.println("Result: " + result);

        switch (x) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;  
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;  
            default:
                System.out.println("Invalid day");
                break;
        }
    }
    
}
