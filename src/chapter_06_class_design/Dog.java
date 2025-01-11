package chapter_06_class_design;

/**
 * Class Design
 * ------------
 * A class just can be declared using public or package.
 * Java does not allow cyclic constructor calls.
 * super is different of super() - super() can only be used one time e may be the first statement.
 * this is different of this() - this() can only be used one time e may be the first statement.
 */

// The final modifier prevents a class from being extended any further.
public final class Dog extends Mammal {
    // Java does not support multiple inheritance in the language because multiple inheritance can lead to complex.

    // Overloading constructors
    public Dog(String name) {
        super(name); // Accessing constructor of father class.
        print(name);
        super.name = "Billu"; // super allow to access members of the father class.
    }

    public Dog() {
        this("Max"); // Calling the constructor above.
        this.age = 0; // If age does not exist in this class so will get of the dad.
    }

    private void increaseAge() {
        super.age++;
    }

    public static void main(String[] args) {
        print("Design Class");
        var dog = new Dog();
        dog.increaseAge();
        System.out.println(dog);
        dog.run();
    }

    // Overriding a method
    @Override
    public void run() throws IllegalStateException {
        super.run();
        print("Running...");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
