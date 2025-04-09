package chapter_14_io.serializing_data;

import java.io.Serializable;

/**
 * Serialization is the process of converting an in-memory object to a byte stream.
 * To serialize an object using the I/O API, the object must implement the Serialize interface.
 * Serialize interface is a maker interface, which means it does not have any methods.
 *-
 * Why Use Serialization?
 * Serialization is useful in scenarios like:
 * 🔹 Saving objects to a file or database (e.g., saving user preferences).
 * 🔹 Sending objects over a network (e.g., in distributed applications).
 * 🔹 Caching objects for later use.
 */
public class Person implements Serializable {

    /**
    🔹A classe pode mudar no futuro, mas precisa manter compatibilidade com objetos antigos.
      MELHOR OPCÃO: 1L (ou um número fixo escolhido manualmente)
    🔹Preciso garantir que só objetos da versão exata da classe sejam aceitos
      MELHOR OPCÃO: Número gerado automaticamente (-7479280894813459011L)

      Quero evitar problemas de compatibilidade sem pensar muito - Gerar o UID com o IDE
     */
    private static final long serialVersionUID = 1L;
//    private static final long serialVersionUID = 2L;


    private String name;
    private int age;
    private Boolean friendly;

    // Transient modifier can be usedfor sensitive data of the class.
    // Any field that is marked transient will not be saved to an I/o stream
    private transient String password;

    private static String type;

    public Person(String name, int age, Boolean friendly, String password, String type) {
        this.name = name;
        this.age = age;
        this.friendly = friendly;
        this.password = password;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendly=" + friendly +
                ", password='" + password + '\'' +
                '}' + type;
    }
}
