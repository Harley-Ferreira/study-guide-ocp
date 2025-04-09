package chapter_14_io.interacting_users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Java includes numerous classes for interacting with the user
 */
public class PrintingData {
    public static void main(String[] args) {
        // System.err and System.out are the same thing, they just differ in color that are printed
        System.err.println("File not found"); // Usually System.err is used in printStackTrace
        System.out.println("Found file");


        // Reading Input
        var reader = new BufferedReader(new InputStreamReader((System.in)));
        String userInput;
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("You entered: " + userInput);

        /**
         * Note that we never created or closed System.out, System.err and System.in when we used them.
         * These are the only I/O streams in the entire chapter that we did not use a try-with-resources block on!
         * It happens because, they are shared by entire application, so the JVM creates and opens them for us
         */

        /*
         This example bellow shows why we can't use try-with-resources.
         This makes the System streams permanently unavailable for all threads.
         */
        try (var out = System.out) {}

        System.out.println("Hello!");
        System.out.println("Hello!");
    }
}
