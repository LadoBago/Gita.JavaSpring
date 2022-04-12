package bg.newhorizons;

import java.util.Arrays;

/**
 * 1. Show two ways to concatenate the following two strings together to get the string "Hi, mom.":
 * String hi = "Hi, ";
 * String mom = "mom.";
 *
 * 2. Write a function that computes your initials from your full name and displays them.
 *
 * 3. Write a function to make a new string from two given string in such a way that, each character of two string will come respectively.
 * Eg. for both strings
 * String arg1 = “House”;
 * String arg2 = “Town”
 *
 * The response should be: “HToouwsne”
 *
 * 4. For function test() change the variables in the first section, so that each if statement resolves as true.
 *
 */
public class StringTester {

    public static void main(String[] args) {
        test1();
        test2("Vladimer Bagoshvili");
        test3("House", "Town");
        test();
    }

    public static void test1(){
        System.out.println("---Start test1---");

        String hi = "Hi, ";
        String mom = "mom.";

        String res1 = hi + mom;
        String res2 = String.join("", hi, mom);
        String res3 = new StringBuilder(hi).append(mom).toString();

        System.out.println("res1=" + res1);
        System.out.println("res2=" + res2);
        System.out.println("res3=" + res3);
    }

    public static void test2(String fullName){
        System.out.println("---Start test2---");
        String[] tokens = fullName.split("\\s");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < tokens.length; i++){
            res.append(tokens[i].substring(0,1));
        }
        System.out.println(res.toString());
    }

    public static  void test3(String arg1, String arg2) {
        System.out.println("---Start test3---");

        if (arg1 == null || arg2 == null) {
            throw new IllegalArgumentException();
        }

        StringBuilder res = new StringBuilder();

        int i1 = 0;
        int i2 = 0;

        while (i1 < arg1.length()) {
            res.append(arg1.charAt(i1++));
            if (i2 < arg2.length()) {
                res.append(arg2.charAt(i2++));
            }
        }

        if (i2 < arg2.length()){
            res.append(arg2.substring(i2));
        }

        System.out.println(res.toString());
    }

    // Change the variables in the first section, so that each if statement resolves as true.
    public static void test() {
        System.out.println("---Start test---");

        String a =  new String("Wow");
        String b = "Wow";
        String c =  a;
        String d =  c;

        a = "Wow";
        d = "Wow!";
        c = d;

        boolean b1 = a == b;
        boolean b2 = d.equals(b + "!");
        boolean b3 = !c.equals(a);

        if (b1 && b2 && b3) {
            System.out.println("Success!");
        }
    }
}
