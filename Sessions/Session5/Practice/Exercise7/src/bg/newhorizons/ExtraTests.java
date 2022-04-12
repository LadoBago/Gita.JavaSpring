package bg.newhorizons;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;

public class ExtraTests {

    public static void main(String[] args) {
        String str = "Java"; // java will looks inthe String pool
        // - it will see that it is not there and it will put the "Java" into it and return it

        StringBuilder sb = new StringBuilder("Java"); // new - new memory allocation


        System.out.println(
                str.equals(sb)
                        + " " + sb.equals(str)
                        + " " + str.equals(sb.toString())
                    + " " + (str == sb.toString()));


        LocalTime lt = LocalTime.of(16, 30); // ?:
        String amPm = lt.getHour() >= 12 ? (lt.getHour() == 12 ? "PM" :  "PM")  : "AM" ;
        StringBuilder sb2 = new StringBuilder(100);
        System.out.println(sb2);
        System.out.println(sb2.length());

        LocalDate newYear = LocalDate.of(2018, 1, 1);
        System.out.println(newYear);

        Period period = Period.of(0, 0, 0);
        System.out.println(period);

        StringBuilder sbt = new StringBuilder();
        String str3 = null;
        Object obj = null;
        StringBuilder asb = null;
        //System.out.println(sbt.append(null));


        String s = "Hello";
        String t = new String(s);
        if ("Hello".equals(s)) System.out.println("one");

        if (t == s) System.out.println("two");

        if (t.equals(s)) System.out.println("three");

        if ("Hello" == s) System.out.println("four");

        if ("Hello" == t) System.out.println("five");

        System.out.println("********************");

        String letters = "abcdef";
        System.out.println(letters.length());
        System.out.println(letters.charAt(3));
       // System.out.println(letters.charAt(6));

        int total = 0;
        StringBuilder letterss = new StringBuilder("abcdefg");
        total += letterss.substring(1, 2).length();
        total += letterss.substring(6, 6).length();
        total += letterss.substring(6, 5).length();//Exception
        System.out.println(total);

        int month = Calendar.JUNE;
        month = Month.JUNE.getValue();

        String name = "Peter";
        name = "K";


    }

}
