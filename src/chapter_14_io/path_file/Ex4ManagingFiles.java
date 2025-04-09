package chapter_14_io.path_file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ex4ManagingFiles {
    public static void main(String[] args) {
        makingDirectory();
        copyingFile();
        movingFile();
        deletingPathOrFile();
    }

    private static void makingDirectory() {
        // The create method will throw an exception if it already exists.
        try {
            Files.createDirectory(Path.of("src/chapter_14_io/dirone"));
        } catch (IOException e) {
            System.out.println("FileAlreadyExistsException: src/chapter_14_io/dirone");
        }

        try {
            Files.createDirectories(Path.of("src/chapter_14_io/dirtwo"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyingFile() {
        // Without REPLACE_EXISTING this code throw an exception if the file already exist.
        try {
            Files.copy(Paths.get("src/chapter_14_io/files/zoo.txt"),
                    Path.of("src/chapter_14_io/dirone/copy.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void movingFile() {
        try {
            Files.move(Paths.get("src/chapter_14_io/dirone/copy.txt"),
                    Path.of("src/chapter_14_io/dirtwo/move.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * delete throw an exception if the file or path does not exist.
     * deleteIfExists return true or false
     */
    private static void deletingPathOrFile() {
        try {
            Files.delete(Path.of("src/chapter_14_io/dirtwo/move.txt")); // First it deletes the file
            Files.deleteIfExists(Path.of("src/chapter_14_io/dirtwo")); // So it deletes the path
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

