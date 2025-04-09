package chapter_14_io.advance_apis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

/** Quando usar?
 🔹Ao listar arquivos e querer exibir informações extras
 🔹Para verificar se arquivos mudaram (ex: backup, sincronização)
 🔹Para implementar filtros (ex: "arquivos modificados hoje")
 🔹Em ferramentas como exploradores de arquivos ou apps de gerenciamento*/
public class AttributesInterface {

    public static void main(String[] args) throws IOException {
        var pathh = Paths.get("src/chapter_14_io/files/zoo.txt");
        BasicFileAttributes data = Files.readAttributes(pathh, BasicFileAttributes.class);
        System.out.println("Is a directory? " + data.isDirectory());
        System.out.println("Is a regular file? " + data.isRegularFile());
        System.out.println("Is a symbolic link? " + data.isSymbolicLink());
        System.out.println("Size (in bytes): " + data.size());
        System.out.println("Last modified: " + data.lastModifiedTime());
        System.out.println("Creation time: " + data.creationTime());

        Path pasta = Paths.get("."); // Caminho atual

        try (Stream<Path> arquivos = Files.list(pasta)) {
            System.out.printf("%-25s %-10s %-10s %-25s %-25s%n",
                    "Nome", "Tipo", "Tamanho", "Criado em", "Modificado em");

            System.out.println("=".repeat(100));

            arquivos.forEach(path -> {
                try {
                    BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

                    String nome = path.getFileName().toString();
                    String tipo = attr.isDirectory() ? "Diretório" :
                            attr.isRegularFile() ? "Arquivo" :
                                    attr.isSymbolicLink() ? "Link" : "Outro";

                    long tamanho = attr.size();
                    String criado = attr.creationTime().toString();
                    String modificado = attr.lastModifiedTime().toString();

                    System.out.printf("%-25s %-10s %-10d %-25s %-25s%n",
                            nome, tipo, tamanho, criado, modificado);

                } catch (IOException e) {
                    System.err.println("Erro ao ler atributos: " + path);
                }
            });
            System.out.println("\uD83D\uDE01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
