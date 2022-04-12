package bg.newhorizons;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerNumbers {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args) {
        int[] numbers = readNumbers();

        printNumbers(numbers);

        double average = getAverage(numbers);
        System.out.println("average : " + average);

        double min = getMin(numbers);
        System.out.println("min " + min);
        // implement the other functions and call them here
        // follow the java dic for guidance of what to do
    }

    public static int[] readNumbers() {
        System.out.println("Enter 3 numbers ");
        int[] numbers = new int[3];
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = scanner.nextInt();
        }

        return numbers;
    }

    public static void printNumbers(int[] numbers) {
        for (int index=0; index < numbers.length; index++) {
            System.out.println(numbers[index]);
        }
    }

    /**
     * Calculate the average sum of the numbers in the array being passed
     */
    public static double getAverage(int[] numbers) {
        // implement the logic

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum / numbers.length;
    }

    /**
     *  Calculate and return the minimum in the array
     */
    public static int getMin(int[] numbers) {
        // implement the logic

        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }

        return min;
    }

    /**
     *  Calculate and return the maximum in the array
     */
    public static double getMax(int[] numbers) {
        // implement the logic

        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        return max;
    }

    /**
     *  Reverse the numbers in the array and return the reversed array in a new instance
     */
    public static int[] reverse(int[] list) {
        int[] res = new int[list.length];
        for (int i = 0; i < list.length; i++){
            res[i] = list[list.length - i - 1];
        }
        return res;
    }

    /**
     *  Sort the arrays in descending order and return the sorted array
     */
    public static int[] sort(int[] numbers) {
        // implement logic

        Arrays.sort(numbers);
        int[] res = reverse(numbers);

        return res;
    }
}
