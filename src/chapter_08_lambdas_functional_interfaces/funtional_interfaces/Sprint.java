package chapter_08_lambdas_functional_interfaces.funtional_interfaces;

/**
 * A Functional Interface is an interface that contains a single abstract method (SAM).
 * It's possible to ave others non-abstract methods like default and static.
 * Also, toString, hashCode and equals methods aren't counted because they are defined in Object class.
 */
@FunctionalInterface
public interface Sprint {
    public void sprint(int speed);

    // DEFAULT
    default void hello() {}

    // STATIC
    static int getSome() {
        return 1;
    }

    // OBJECT METHODS
    String toString();
    boolean equals(Object o);
    int hashCode();
}
