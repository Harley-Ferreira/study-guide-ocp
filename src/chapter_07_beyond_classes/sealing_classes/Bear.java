package chapter_07_beyond_classes.sealing_classes;

/**
 * Sealing Classes
 * ---------------
 * Sealed classes are commonly declared with abstract modifier.
 * Sealed classes needs to be declared int the same package as its direct subclasses.
 * Every class that directly extends a sealed class MUST specify exactly one of the following three modifiers:
 * final, sealed or non-sealed
 */
public sealed class Bear permits Kadiak, Panda{
}
