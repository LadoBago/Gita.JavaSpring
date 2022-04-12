package bg.newhorizons;

import java.util.Scanner;

public class MeasureConverter {

    // 1. define a constant static final variable where defines that 1 mile is 1.60934 km
    // 2. define a constant static final variable where defines that 1 km is 0.621371 miles
    // 3. define a constant static final variable where defines that 1 pound is 0.453592 kg
    // 4. define a constant static final variable where defines that 1 kg is 2.20462 pounds

    static final double MILE_2_KM = 1.60934d;
    static final double KM_2_MILE = 0.621371d;
    static final double POUND_2_KG = 0.453592d;
    static final double KG_2_POUND = 2.20462d;



    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in); // reads the input entered by the user

        System.out.println("Please enter a measure converter you would like to operate where ");
        System.out.println("1 is for converting Km to Miles ");
        System.out.println("2 is for converting Miles to km ");
        System.out.println("3 is for converting Pounds to Kgs ");
        System.out.println("4 is for converting Kg to Pounds ");
        double enteredNumber = inputReader.nextDouble();
        // 9. make a check if the enteredNumber is between 1 and 4
        // 9.1. If it is between 1 and 4 then make a switch where
        //  - for 1: calls the convertKmToMiles(enteredNumber);
        //  - for 2: calls the convertMilesToKm(enteredNumber);
        //  - for 3: calls the convertPoundToKg(enteredNumber);
        //  - for 4: calls the convertKgToPounds(convertKgToPounds);
        // 9.2. if it is outside the range in between 1 and 4, then print an error message to the console and that's it

        // 10. Think what we need to do in order to avoid the first check for the range of the enteredNumber in 1 to 4 ?
        // 11. did u use the break clause ?

// 10th question:
// In order to avoid the first check for the range of the enteredNumber in 1 to 4, we should write "default statement in switch with printing error msg."

        if (enteredNumber >= 1 && enteredNumber <= 4) {
            switch ((int)enteredNumber) {
                case 1:
                    System.out.println(convertKmToMiles(enteredNumber));
                    break;
                case 2:
                    System.out.println(convertMilesToKm(enteredNumber));
                    break;
                case 3:
                    System.out.println(convertPoundToKg(enteredNumber));
                    break;
                case 4:
                    System.out.println(convertKgToPounds(enteredNumber));
                    break;
            }
        }
        else {
            System.out.println("error: enteredNumber is outside the range in between 1 and 4");
        }
    }

    // 5. Implements the function so that
    // 5.1. check if the double is greater than 0
    //  - if less than 0, then write in th console that the input is negative and returns 0
    //  - if greater than 0, then converts the km passed into miles using the constant defined
    public static double convertKmToMiles(double km) {
        if (km < 0) {
            System.out.println("the input is negative");
        }
        if (km > 0) {
            return km * KM_2_MILE;
        }
        return 0;
    }

    // 6. Implements the function so that
    // 6.1. check if the double is greater than 0
    //  - if less than 0, then write in th console that the input is negative and returns 0
    //  - if greater than 0, then converts the miles  passed into km using the constant defined
    public static double convertMilesToKm(double miles) {
        if (miles < 0) {
            System.out.println("the input is negative");
        }
        if (miles > 0) {
            return miles * MILE_2_KM;
        }
        return 0;
    }

    // 7. same logic as in 6 but for pound to kg
    public static double convertPoundToKg(double pounds) {
        if (pounds < 0) {
            System.out.println("the input is negative");
        }
        if (pounds > 0) {
            return pounds * POUND_2_KG;
        }
        return 0;
    }

    // 8. same logic as in 6 but for kg to pound
    public static double convertKgToPounds(double kg) {
        if (kg < 0) {
            System.out.println("the input is negative");
        }
        if (kg > 0) {
            return kg * KG_2_POUND;
        }
        return 0;
    }
}
