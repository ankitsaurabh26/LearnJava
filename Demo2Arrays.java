class Calculator {
    public int add(int a, int b) {
        return a + b;
    }    
}


public class Demo2Arrays {
    public static void main(String[] args) {
        int nums[] = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;

        System.out.println("--- 1D Array ---");
        for (int i=0;i<5;i++) {
            System.out.println(nums[i]);
        }

        // 2D array
        System.out.println("--- 2D array ---");
        int table[][] = new int[3][4];
        for (int i=0;i<3;i++) {
            for (int j=0;j<4;j++) {
                table[i][j] = (int)(Math.random()*10);
            }
        }
        for (int i=0;i<3;i++) {
            for (int j=0;j<4;j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        // Using Enhanced for loop 1D array
        System.out.println("--- Enhanced for loop 1D ---");
        for (int x : nums) {
            System.out.println(x);
        }
        
        // Using Enhanced for loop 2D array
        System.out.println("--- Enhanced for loop 2D ---");
        for (int x[] : table) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        
        // Jagged array : 2D array with variable length rows
        System.out.println("--- Jagged array ---");
        int jagged[][] = new int[3][];
        jagged[0] = new int[2];
        jagged[1] = new int[4];
        jagged[2] = new int[3];
        
        for (int i=0;i<3;i++) {
            for (int j=0;j<jagged[i].length;j++) {
                jagged[i][j] = (int)(Math.random()*10);
            }
        }
        for (int i=0;i<3;i++) {
            for (int j=0;j<jagged[i].length;j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}
