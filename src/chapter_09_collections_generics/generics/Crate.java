package chapter_09_collections_generics.generics;

/**
 * Don't worry if you can't think of a use for generic class of your own.
 * Unless you are writing a library for others to reuse.
 * It's common to see generics in streams or spring jpa
 *
 * Naming Conventions for Generics
 * E for an element
 * K for a map key
 * V for a map value
 * N for a number
 * T for a generic data type
 * S, U, V, and so forth for multiple generics types
 */
public class Crate<T> {

    private T contents;

    public T lookInCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }
}
