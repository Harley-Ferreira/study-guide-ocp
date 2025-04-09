package chapter_14_io.path_file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex3PathElements {

    public static void main(String[] args) {
        printPathInformation(Path.of("zoo"));
        printPathInformation(Path.of("/zoo/armadillo/shells.txt"));
        printPathInformation(Path.of("./armadillo/../shells.txt"));

        resolvingPaths();
        relativizingPath();
        normalizingPath();
    }

    private static void printPathInformation(Path path) {
        title("Path Information");
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());
        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null) {
            System.out.println("Current parent is: " + currentParent);
        }
        try {
            System.out.println(Paths.get("src/chapter_14_io/files/zoo.txt").toRealPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * If you want to concatenate path in a manner similar
     * to how we concatenate strings, use resolve() method
     */
    private static void resolvingPaths() {
        title("Resolving Paths");
        Path path1 = Path.of("/cats/../panther");
        Path path2 = Path.of("food"); // This is a relative path.
        Path path3 = Path.of("/food"); // This is an absolute path.
        /*  The output is different because '/food' IS NOT EQUALS 'food'.
            In the first we have a concat but in the seconds not.
            So it is not possible combine two absolute path using resolve() method */
        System.out.println(path1.resolve(path2)); // \cats\..\panther\food
        System.out.println(path1.resolve(path3)); // \food
    }

    /**
     * The idea is this: if you are pointed at a path in the file system,
     * what steps would you need to take to reach other path?
     * The relativize() method required both paths to be absolute or relative
     * and throws an exception if the types are mixed.
     */
    private static void relativizingPath() {
        title("Relativizing a Path");
        var path1 = Path.of("fish.txt");
        var path2 = Path.of("friendly/birds.txt");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));
    }

    /**
     * The normalize() method eliminates unnecessary redundancies in a path
     */
    private static void normalizingPath() {
        title("Normalizing a Path");
        var p1 = Path.of("./armadillo/../shells.txt");
        System.out.println(p1.normalize());

        var p2 = Path.of("/cats/../panther/food");
        System.out.println(p2.normalize());

        var p3 = Path.of("../../fish.txt");
        System.out.println(p3.normalize());

        // The normalize() method also allows us to compare equivalent paths.
        var p4 = Paths.get("/pony/../weather.txt");
        var p5 = Paths.get("/weather.txt");
        System.out.println("Without normalize: " + p4.equals(p5));
        System.out.println("With normalize: " + p4.normalize().equals(p5.normalize()));
    }

    public static void title(String title) {
        System.out.println();
        System.out.println(" - " + title + " - ");
    }
}
