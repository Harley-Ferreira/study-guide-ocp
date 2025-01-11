package chapter_07_beyond_classes.interfaces;

/**
 * Beyond Classes
 * -------------------
 * An interface can extend another interface.
 * An interface cannot implement another interface.
 * An interface cannot extend a class.
 * It's not possible to use protected or private in interface,
 *
 */
public interface Herbivore extends Animal {

    void eatPlants();

    @Override
    default void sleep() {

    }
}
