package chapter_14_io.advance_apis;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputStreamManipulation {
    public static void main(String[] args) throws Exception {
        byte[] data = "Hello, world!".getBytes();
        InputStream input = new ByteArrayInputStream(data);

        System.out.println("markSupported: " + input.markSupported());

        // Lê alguns bytes
        System.out.print((char) input.read()); // H
        System.out.print((char) input.read()); // e

        // Marca a posição após ler "He"
        input.mark(5); // Pode ler até 5 bytes antes que a marca expire

        System.out.print((char) input.read()); // l
        System.out.print((char) input.read()); // l
        System.out.print((char) input.read()); // o

        // Redefine para a posição marcada (antes do primeiro 'l')
        input.reset();

        System.out.print((char) input.read()); // l
        System.out.print((char) input.read()); // l

        // Pula um byte (deveria ser o 'o')
        input.skip(1);

        System.out.print((char) input.read()); // ,

        input.close();
    }
}
