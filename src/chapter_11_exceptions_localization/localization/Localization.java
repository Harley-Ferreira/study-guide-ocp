package chapter_11_exceptions_localization.localization;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Supporting Internationalization and Localization
 */
public class Localization {

    public static void main(String[] args) {
        title("Picking a Locale");
        Locale locale = Locale.getDefault();
        print(locale); // pt_BR
        print(Locale.CANADA); // en_CA
        print(Locale.GERMAN); // de
        print(Locale.GERMANY); // de_DE
        print(new Locale("hi", "BE")); // hi_BE (random);
        print(new Locale.Builder().setLanguage("pt").setRegion("BR").build()); // pt_BR

        title("Formatting Numbers");
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear * 12;

        var br = NumberFormat.getInstance(Locale.forLanguageTag("pt-BR"));
        print(br.format(attendeesPerMonth)); // 38.400.000

        var us = NumberFormat.getInstance(Locale.US);
        print(us.format(attendeesPerMonth)); // 38,400,000

        var gr = NumberFormat.getInstance(Locale.GERMANY);
        print(gr.format(attendeesPerMonth)); // 38.400.000

        var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        print(ca.format(attendeesPerMonth)); // 38 400 000

        title("Formatting Currency");
        BigDecimal price = BigDecimal.valueOf(48.98);
        var usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
        print(usCurrency.format(price)); // $48.98

        var enCurrency = NumberFormat.getCurrencyInstance(Locale.UK);
        print(enCurrency.format(price)); // £48.98

        var brCurrency = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        print(brCurrency.format(price)); // R$ 48,98

        title("Formatting Percent");
        BigDecimal successRate = BigDecimal.valueOf(0.8021);
        var usRate = NumberFormat.getPercentInstance(Locale.US);
        print(usRate.format(successRate)); // 80%

        var brRate = NumberFormat.getPercentInstance(new Locale("pt", "BR"));
        print(brRate.format(successRate)); // 80%

        var grRate = NumberFormat.getPercentInstance(Locale.GERMANY);
        print(grRate.format(successRate)); // 80 %

        title("Formatting with CompactNumberFormat");
        var formatters = Stream.of(
                NumberFormat.getCompactNumberInstance(), // 7 mi
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.SHORT), // 7 mi
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG), // 7 milhões
                NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT), // 7 Mio.
                NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.LONG), // 7 Millionen
                NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG), // 7 million
                NumberFormat.getNumberInstance()); // 7.123.456
        formatters.map(s -> s.format(7_123_456)).forEach(Localization::print);

        title("Localizing Dates");
        var italy = new Locale("it", "IT");
        var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 15, 12, 34);

        print(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(dt)); // 20/10/2022 15:12
        print(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(italy).format(dt)); // 20/10/22, 15:12

        title("Specifying a Locale Category");
        var spain = new Locale("es", "ES");
        var money =  1.23;
//        Locale.setDefault(Locale.Category.DISPLAY, spain);
        print(NumberFormat.getCurrencyInstance().format(money) + ", " + spain.getDisplayLanguage());
        Locale.setDefault(Locale.Category.FORMAT, spain);
        print(NumberFormat.getCurrencyInstance().format(money) + ", " + spain.getDisplayLanguage()); // 1,23 €, espanhol
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
