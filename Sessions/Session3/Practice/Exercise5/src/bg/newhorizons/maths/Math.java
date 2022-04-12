package bg.newhorizons.maths;

/**
 * Rewrite the methods in class Math so that
 *
 * - Math class to have static methods
 * - Main class to use the static methods
 * Let’s make it so that the math has no mathematicianName filed anymore
 *
 * - Extends the functions of Math with next functions:
 *      - subtract(double a, double b),
 *      - divide(double a, double b) (here make required checks)
 *      - nth(double root, double n) - calculate root on degree n: e.g.  nth(5, 2) -> 25
 */
public class Math {

    private static String mathematicianName;

    public Math(String name) {
        this.mathematicianName = name;
    }

    public static double sum(double num1, double num2) {
        System.out.println("Mathematician name "
                + mathematicianName
                + " sum of " + num1 + " and " + num2);

        double result = num1 + num2;

        return result;
    }

    public static double subtract(double a, double b) {
        System.out.println("Mathematician name "
                + mathematicianName
                + "  " + a + " - " + b);

        double result = a - b;

        return result;
    }

    public static double divide(double a, double b) {
        System.out.println("Mathematician name "
                + mathematicianName
                + "  " + a + " / " + b);

        if (b == 0){
            System.out.println("error: b equals to zero.");
            throw new IllegalArgumentException();
        }

        double result = a / b;

        return result;
    }

    public static double nth(double root, double n) {
        System.out.println("Mathematician name "
                + mathematicianName
                + "  " + root + " power " + n);

        double result = java.lang.Math.pow(root, n);

        return result;
    }
}
