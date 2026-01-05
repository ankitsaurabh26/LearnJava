import java.util.Arrays;

public class LearnArraysClass {
    public static void main(String[] args) {
        Integer[] numbers = { 10, 2, 32, 12, 15, 76, 17, 89, 54 };
        System.out.println("Before sorting: ");
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();

        Arrays.sort(numbers); // sorts the array
        System.out.println("After sorting: ");
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();

        int idx = Arrays.binarySearch(numbers, 15); // BinarySearch works on sorted array only
        System.out.println("The index of element 15 in the array: " + idx);

        Arrays.fill(numbers, -1); // fills the array with the value provided -> used in DP
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
