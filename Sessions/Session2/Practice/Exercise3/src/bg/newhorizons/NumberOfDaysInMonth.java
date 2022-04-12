package bg.newhorizons;

import java.util.Scanner;

public class NumberOfDaysInMonth {

    // Write a program which find and prints the number of day for a month and year entered by the user
    // Hint: for February use next statement block for checking if it is 28 or 29
    // if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
    //    number_Of_DaysInMonth = 29;
    // } else {
    //    number_Of_DaysInMonth = 28;
    //}
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int year = reader.nextInt();
        int month = reader.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Entered month is not in a valid range (1-12)");
            return;
        }

        int number_Of_DaysInMonth = 31;

        if (month == 2) {
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                number_Of_DaysInMonth = 29;
            } else {
                number_Of_DaysInMonth = 28;
            }
        }
        else if (month < 7 && month % 2 == 0 || month > 7 && month % 2 == 1) {
            number_Of_DaysInMonth = 30;
        }

        System.out.println("number_Of_DaysInMonth = " + number_Of_DaysInMonth);
    }
}
