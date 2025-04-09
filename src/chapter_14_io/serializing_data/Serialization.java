package chapter_14_io.serializing_data;

import java.io.*;

public class Serialization {

    public static void main(String[] args) {
        Person person = new Person("Harley", 25, true, "212", "human");
        Person person2 = new Person("Maria", 30, true, "222", "humano");
        /*
         * 📌 O que é um arquivo .ser em Java?
         * Um arquivo .ser (serialized file) é um arquivo binário que contém a representação de um objeto Java
         * que foi serializado usando a interface Serializable. Ele armazena o estado do objeto para que possa
         * ser recuperado posteriormente por meio da desserialização.
         * .ser é um arquivo binário, ele não é legível como um .txt ou .json
         */

        // Serializa
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/chapter_14_io/serializing_data/person.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(person);
            objectOutputStream.writeObject(person2);
            System.out.println("Objeto serializado com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Desserializa
        try (FileInputStream fileInputStream = new FileInputStream("src/chapter_14_io/serializing_data/person.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Person p1 = (Person) objectInputStream.readObject();
            Person p2 = (Person) objectInputStream.readObject();
            System.out.println("Objeto desserializado com sucesso: " + p1);
            System.out.println("Objeto desserializado com sucesso: " + p2);
            // Objeto desserializado com sucesso: Person{name='Harley', age=25, friendly=true, password='null'}humano
            // Objeto desserializado com sucesso: Person{name='Maria', age=30, friendly=true, password='null'}humano
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
