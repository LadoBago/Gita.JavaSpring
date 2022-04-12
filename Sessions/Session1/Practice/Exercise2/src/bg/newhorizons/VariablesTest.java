package bg.newhorizons;

public class VariablesTest {
    
    // 1. write a new main method (static void and accepting array of  String)
    // 2. declare local method variables as:
    // one variable from type int and name number1 with value 10
    // one variable from type String and name title and value "Variables Test"
    // one variable from type int and name number2 with value 20
    // 3. Declare static class level variable with name number1 and value 20
    // 4. Add the line System.out.println(number1) - which value is being printed here? Why ?
    // 5. Print the value of number1 from the static class level variable
    // 6. Sum number1 and number2 local based variables and print the result
    // 7. Sum static class level variable number1 and number2 and print the result
    // 8. Create a new local based variable with  name sum from type long
    // 9. Let's sum is the sum of local based number1 and number2 variables
    // 10. Create new local based variable with name shortSum from tye short
    // 11. Let's shortSum is the sum of local based variables number1 and number2. Do u need to do something extra in order to make it compiled ?


    private static  int number1 = 20;

    public static void main(String[] args) {
        int number1 = 10;
        String title = "Variables Test";
        int number2 = 20;

        System.out.println(number1);
        System.out.println(VariablesTest.number1);
        System.out.println(number1 + number2);

        long sum = number1 + number2;
        short shortSum = (short) (number1 + number2);

        long l = Long.MAX_VALUE;
        float f = Float.MAX_VALUE;
        if (f > l) {
            System.out.println("f > l");
        }
        else {
            System.out.println("! (f > l)");
        }

        f = l;
        System.out.println(l);
        System.out.println(f);
        System.out.println((long)f);


    }


}
