package chapter_06_class_design;

/**
 * Class Design
 * ------------
 * When a class is extended your constructor is called
 */

public class Mammal extends Animal {
    // Every class has a default constructor. So if you don't include one Java will do it.


    public Mammal(String name) {
        super(name, 0); // Accessing constructor of father class
        System.out.println("Initializing Mammal Constructor");
    }

    public void run() throws IllegalStateException {
        print("No Run...");
    }
}
