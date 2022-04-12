package bg.newhorizons;

import java.util.Scanner;

public class Shots {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a whole number ");
        int number = scanner.nextInt();

        // 1. Write a while-do cycle by the time the user enters a valid whole number greater than 0
        // if user enters a number less than 0, then print a message to the user inviting him/her to enter
        // a number greater than 0

        while (number <= 0) {
            System.out.println("Please, enter a number greater than 0");
            number = scanner.nextInt();
        }

        oneNthCalculator(number);
        sumAverage(number);
        sumOffLastDigits(number);
    }

    //2. Write a program to calculate the sum of following series
    //1 + 1/2 + 1/3 + 1/4 + 1/5 +…………1/n
    public static void oneNthCalculator(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1d / i;
        }
        System.out.println("The result of oneNthCalculator = " + sum);
    }

    // 3. Write a program to sum the number between 1 and n and calculate the average of all numbers
    // Let's print the result - th sum and the average
    // There should be a check if n is greater than 0
    public static void sumAverage(int n) {
        if (n <= 0) {
            System.out.println("the parameter n should be greater than 0");
            return;
        }

        long sum = ((1 + (long)n) * (long)n) / 2;
        double avg = ((double)sum) / n;
        System.out.println("Sum = " + sum);
        System.out.println("Avg = " + avg);
    }

    // 4. Sum all digits in a number n passed
    // E.g. if n is 782 then the function should print 7 + 8 + 2 = 17
    // Hint: taking the last digit from a number you can use lastDigit = n % 10; (e.g. for 676 it will take 6)
    // You need to take the reminder of the number n and take all other digits as well
    // In order to take the left digits of a number u need to use n = n / 10; (e.g. for 676 it will take 67)
    // use a while loop for taking of all digits and sum them
    public static void sumOffLastDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println("Sum of digits = " + sum);
    }
}
