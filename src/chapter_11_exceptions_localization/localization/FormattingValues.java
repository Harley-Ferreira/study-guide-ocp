package chapter_11_exceptions_localization.localization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class FormattingValues {

    public static void main(String[] args) {
        title("Formatting Numbers");
        double d = 1234.567;
        NumberFormat f1 = new DecimalFormat("###,###,###.0");
        print(f1.format(d)); // 1.234,6

        NumberFormat f2 = new DecimalFormat("000,000,000.00000");
        print(f2.format(d)); // 000.001.234,56700

        NumberFormat f3 = new DecimalFormat("Your Balance $#,###,###.##");
        print(f3.format(d)); // Your Balance $1.234,57

        title("Formatting Dates and Times");
        LocalDate date = LocalDate.of(2024, Month.DECEMBER, 25);
        LocalTime time = LocalTime.of(12, 30, 25);
        LocalDateTime dt = LocalDateTime.of(date, time);
        print(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2024-12-25
        print(time.format(DateTimeFormatter.ISO_LOCAL_TIME)); // 12:30:25
        print(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2024-12-25T12:30:25

        var formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"); // 25/12/2024 12:30:25
        print(formatter1.format(dt));
        var formatter2 = DateTimeFormatter.ofPattern("MMM_yyyy_-_dd"); // dez._2024_-_25
        var formatter22 = DateTimeFormatter.ofPattern("MMMM_yyyy_-_dd"); // dezembro_2024_-_25
        print(formatter2.format(date));
        print(formatter22.format(date));
        var formatter3 = DateTimeFormatter.ofPattern("hh:mm -----> ss"); // 12:30 -----> 25
        // var formatter3 = DateTimeFormatter.ofPattern("Time is: hh:mm:ss"); Exception thrown
        print(formatter3.format(time));

    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
