package bg.newhorizons;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 */
public class DateTester {


    public static void main(String [] args) {
        // cal all functions here
        dateInfo();
        addHoursMinutesAndSeconds(new Date());
        beforeAndAndAfterYear();
        remainingMonths();
        printNextAndPreviusMonday();
        printDaysDifference(new Date(), new GregorianCalendar(2022, Calendar.OCTOBER, 9).getTime());
    }

    /**
     * Write a Java program to get and display information (year, month, day, hour, minute) of a default calendar
     */
    public static void dateInfo() {
        Calendar now = Calendar.getInstance();
        System.out.println(now.get(Calendar.YEAR));
        System.out.println(now.get(Calendar.MONTH));
        System.out.println(now.get(Calendar.DAY_OF_MONTH));
        System.out.println(now.get(Calendar.HOUR_OF_DAY));
        System.out.println(now.get(Calendar.MINUTE));
    }

    /**
     *  Write a program add hours, minutes and seconds to the date and return the enw date
     */
    public static Date addHoursMinutesAndSeconds(Date date) {
        Date newDate = null;

        // 1. convert date to LocalDate ( ~ Did you mean LocalDateTime ? )
        // 2. add hours, minutes and seconds
        // 3. convert back to date
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime newDateTime = localDateTime.plusHours(1).plusMinutes(2).plusSeconds(3);
        newDate = Date.from(newDateTime.atZone(ZoneId.systemDefault()).toInstant());

        return newDate;
    }


    /**
     * Write a Java program to get a date before and after 1 year compares to the current date
     */
    public static void beforeAndAndAfterYear() {
        LocalDate now = LocalDate.now();
        LocalDate beforeOneYear = now.minusYears(1);
        LocalDate afterOneYear = now.plusYears(1);

        System.out.println("beforeOneYear=" + beforeOneYear);
        System.out.println("afterOneYear="+afterOneYear);

    }

    /**
     * Write a Java program to get the months remaining in the year.
     */
    public static void remainingMonths() {
        // 1. get LocalDate now
        // 2.  Use TemporalAdjusters to get last LocalDate of the year
        // 3. get Period between now and last date and for each to print months
        LocalDate now = LocalDate.now();
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.lastDayOfYear();
        LocalDate eoYear = now.with(temporalAdjuster);
        Period period = Period.between(now, eoYear);
        System.out.println("now.getMonth=" + now.getMonth());
        System.out.println("endOfYear.getMonth=" + eoYear.getMonth());
        System.out.println("period=" + period.toString());
    }

    /**
     * . Write a Java program to get the next and previous Friday
     */
    public static void printNextAndPreviusMonday() {
        LocalDate now = LocalDate.now();
        TemporalAdjuster adjPrev = TemporalAdjusters.previous(DayOfWeek.FRIDAY);
        TemporalAdjuster adjNext = TemporalAdjusters.next(DayOfWeek.FRIDAY);
        System.out.println("Previous friday=" + now.with(adjPrev).toString());
        System.out.println("Next friday=" + now.with(adjNext).toString());
    }

    /**
     * Write a Java program to calculate the difference between two dates in days
     */
    public static void printDaysDifference(Date start, Date end) {
        LocalDateTime localDateStart = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime localDateEnd = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        Duration duration = Duration.between(localDateStart, localDateEnd);
        System.out.println("Difference between " + localDateStart.toLocalDate() + " and " + localDateEnd.toLocalDate() + " are " + duration.toDays() + " days");
    }

}
