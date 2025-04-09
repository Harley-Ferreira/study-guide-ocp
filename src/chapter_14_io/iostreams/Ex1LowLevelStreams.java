package chapter_14_io.iostreams;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** Low-Level Streams connects directly with the source of the data, such as a file, an array or a String.
 * Examples:
 * 🔹 FileInputStream and FileOutputStream → Work with binary files.
 * 🔹 ByteArrayInputStream and ByteArrayOutputStream → Work with byte arrays.
 * 🔹 SocketInputStream and SocketOutputStream → Handle network connections.
 *-
 * Characteristics:
 * 🔹 Direct access to data sources.
 * 🔹 Work with raw bytes or characters.
 * 🔹 Require more code for efficient processing.
 * */
public class Ex1LowLevelStreams {
    public static void main(String[] args) {
        //  Disadvantage: Since it reads and writes one byte at a time, it may be inefficient for large files.
        try(FileInputStream fis = new FileInputStream("src/chapter_14_io/files/zoo.txt");
            FileOutputStream fos = new FileOutputStream("src/chapter_14_io/files/output.txt")) {
            int byteData;
            while((byteData = fis.read()) != -1) {
                System.out.println(byteData); // output fist print: 78 (Correspond N in table ascii)
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Why use int instead byte? (page 818)
         * The authors of Java decided to use a larger data type, int,
         * so that special value like -1 would indicate the end of an I/O stream.
         */
    }
}
