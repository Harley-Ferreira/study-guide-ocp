package chapter_07_beyond_classes.interfaces;

/**
 *  A class cannot extend an interface just implement.
 *  When we have two methods equals in different interfaces, one implementation is enough.
 */
public class Bear implements Herbivore, Omnivore {

    // The method eatPlants exist in interfaces.Herbivore and interfaces.Omnivore, but in implementation
    // we use interfaces.Herbivore first, so we are using the eatPlants method of interfaces.Herbivore
    @Override
    public void eatPlants() {

    }
}
