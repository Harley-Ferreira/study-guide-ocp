package chapter_14_io.iostreams;

import java.io.*;

/**
 * High-Level Stream is build on top of another I/O stream using wrapping.
 * Examples:
 * 🔹 BufferedInputStream and BufferedOutputStream → Improve byte stream efficiency.
 * 🔹 BufferedReader and BufferedWriter → Allow reading/writing text files efficiently.
 * 🔹 DataInputStream and DataOutputStream → Handle primitive data types.
 *-
 * Characteristics:
 * 🔹 Wrap low-level streams for easier handling.
 * 🔹 Improve performance by using buffers.
 * 🔹 Provide convenient methods for data processing.
 */
public class Ex2HighLevelStreams {
    public static void main(String[] args) {

        //  Advantage: Uses buffers to read and write data more efficiently, making processing faster.
        try(BufferedReader br = new BufferedReader(new FileReader("src/chapter_14_io/files/zoo.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // output fist print: Nome	Idade	Cidade
//                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * SOME CHARACTERS TABLE ASCII
     * A	65	0100 0001
     * B	66	0100 0010
     * C	67	0100 0011
     * D	68	0100 0100
     * E	69	0100 0101
     * F	70	0100 0110
     * G	71	0100 0111
     * H	72	0100 1000
     * I	73	0100 1001
     * J	74	0100 1010
     * K	75	0100 1011
     * L	76	0100 1100
     * M	77	0100 1101
     * N	78	0100 1110
     * O	79	0100 1111
     * P	80	0101 0000
     * Q	81	0101 0001
     * R	82	0101 0010
     * S	83	0101 0011
     * T	84	0101 0100
     * U	85	0101 0101
     * V	86	0101 0110
     * W	87	0101 0111
     * X	88	0101 1000
     * Y	89	0101 1001
     * Z	90	0101 1010
     */
}
