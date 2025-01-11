package chapter_06_class_design;

/**
 * Class Design
 * ------------
 * This class extends implicit the Object Ex: (public claas Animal extends Object {}) equals to (public class Animal {})
 * A class have some kinds of modifiers (final, abstract, sealed, non-sealed and static).
 * A class can contain many overloaded constructors.
 */

public class Animal extends Commom{

    protected String name;
    protected Integer age;

    // Overloading constructors
    public Animal() {
        System.out.println("Initializing Animal Constructor One");
    }

    public Animal(String name, Integer age) {
        System.out.println("Initializing Animal Constructor Two");
        this.name = name;
        this.age = age;
    }

    static void print(Object o) {
        System.out.println(o);
    }

    // Override abstract methods cannot be private
    @Override
    protected void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    void drink() {

    }
}
