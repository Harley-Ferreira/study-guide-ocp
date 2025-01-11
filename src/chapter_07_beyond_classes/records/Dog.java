package chapter_07_beyond_classes.records;

/**
 * Record
 * ------
 * Records don't have setters. Just as interface are implicitly abstract, records are also implicitly final.
 * Like enums you can't extend or inherit a record.
 * A record can implement a regular or sealed interface
 */
public record Dog(String name, Integer age) implements Mammal {

    // It's not possible to declare two record constructors that call each other.
    // Record DO NOT SUPPORT instance initializers.
    public Dog(String name, Integer age) {
        if (age > 30) throw new IllegalArgumentException();
        this.name = name;
        this.age = age;
    }

//    public Dog {
//        if (age > 30) throw new IllegalArgumentException();
//    }
}
