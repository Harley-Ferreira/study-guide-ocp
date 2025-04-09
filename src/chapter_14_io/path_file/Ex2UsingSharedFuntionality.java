package chapter_14_io.path_file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * USING SHARED FUNCTIONALITY - PAG. 793
 */
public class Ex2UsingSharedFuntionality {

    private static String PATH = "src/chapter_14_io/files/zoo.txt";

    public static void main(String[] args) {
        io();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");

        try {
            nio();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void io() {
        var file = new File(PATH);
        if (file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory()); // If a file returns false
            System.out.println("Parent Path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " + file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println(" " + subfile.getName());
                }
            }
        }
    }

    private static void nio() throws IOException {
        var path = Path.of(PATH);
        if (Files.exists(path)) { // false
            System.out.println("Absolute Path: " + path.toAbsolutePath()); // src\chapter_14_io\files
            System.out.println("Is Directory: " + Files.isDirectory(path)); // 137
            System.out.println("Parent Path: " + path.getParent()); // 2025-03-10T22:24:42.8882089Z
            if (Files.isRegularFile(path)) {
                System.out.println("Size: " + Files.size(path));
                System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p -> System.out.println(" " + p));
                }
            }
        }

        // Works as substring
        System.out.printf("subpath(0, 1): %s \n", path.subpath(0, 1)); // src
        System.out.printf("subpath(1, 3): %s \n", path.subpath(1, 3)); // chapter_14_io\files
    }

}


