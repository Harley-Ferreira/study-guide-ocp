package chapter_14_io.path_file;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * Característica	                            File (java.io)	    Path (java.Aways to create.file)
 * Criada na versão	                            Java 1.0	        Java 7 (NIO.2)
 * Suporte a sistemas de arquivos avançados	    ❌ Não	            ✅ Sim
 * Manipulação de links simbólicos	            ❌ Não	            ✅ Sim
 * Métodos modernos para operações	            ❌ Não	            ✅ Sim (Files.copy, Files.move)
 *
 * In this section we will use NIO. Many methods in this section declared IOException.
 * Common causes of a method throwing this exception include the following.
 * - Loss of communication to the underlying file system.
 * - File or directory exists but cannot be accessed or modified.
 * - File exists but cannot be accessed or modified.
 * - File or directory is required but does not exist.
 */
public class Ex1CreatingFileOrPath {

    public static void main(String[] args) {
        // Aways to create a File
        File file1 = new File("/home/tiger/data/stripes.txt");
        File file2 = new File("/home/tiger", "/data/stripes.txt");
        File file3 = new File(new File("/home/tiger"), "/data/stripes.txt");
        System.out.println("Arquivo existe? " + file1.exists()); // false
        System.out.println("É um diretório? " + file2.isDirectory()); // false
        System.out.println("Tamanho: " + file3.length() + " bytes"); // 0 bytes
        System.out.println();

        /**
         * Just like String values, Path instances are immutable. path.resolve("something") won't work
         */
        // Away to create a Path
        Path path1 = Path.of("/home/tiger/data/stripes.txt");
        path1.resolve("something");
        Path path2 = Path.of("/home","tiger", "data", "stripes.txt");
        Path path3 = Paths.get("/home/tiger/stripes.txt");
        Path path4 = Paths.get("/home","tiger", "data", "stripes.txt");
        System.out.println("Caminho: " + path1); // \home\tiger\data\stripes.txt
        System.out.println("Absoluto? " + path2.isAbsolute()); // false
        System.out.println("Absoluto real: " + path3.toAbsolutePath()); // C:\home\tiger\stripes.txt
        System.out.println("Nome do arquivo: " + path4.getFileName()); // stripes.txt
        System.out.println("Diretório pai: " + path4.getParent()); // \home\tiger\data

        // Many older libraries use File, making it convenient to be able to get a File from a Path and vice versa.
        File file = new File("rabbit");
        Path nowPath = file.toPath();
        File backToFile = nowPath.toFile();

        // OBTAINING A PATH FROM THE FileSystem CLASS - PAG. 791
        Path path5 = FileSystems.getDefault().getPath("/home/tiger/data/stripes.txt");
        Path path6 = FileSystems.getDefault().getPath("/home","tiger", "data", "stripes.txt");

        for (int i = 0; i < path1.getNameCount(); i++) { // don't consider root as a path
            System.out.printf(" Element %d is: %s \n", i, path1.getName(i));
        }
    }
}
