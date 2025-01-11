package chapter_11_exceptions_localization.rousorce_bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class Zoo {


    public static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("rousorce_bundle/Zoo", locale);
        System.out.println(locale.getCountry());
        System.out.println(rb.getString("hello") + ", " + rb.getString("open"));
    }
    public static void main(String[] args) {
        var us = new Locale("en", "US");
        var france = new Locale("fr", "FR");
        printWelcomeMessage(us);
        printWelcomeMessage(france);
        printWelcomeMessage(Locale.getDefault());
        printWelcomeMessage(Locale.GERMANY);
    }
}
