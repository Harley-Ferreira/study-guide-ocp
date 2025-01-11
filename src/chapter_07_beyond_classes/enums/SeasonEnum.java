package chapter_07_beyond_classes.enums;

import java.util.List;
import java.util.Locale;

/**
 * Working with Enums
 * ------------------
 * We can use equals or == to compare enum.
 * Enum constructors are implicitly private.
 * An enum can contain an abstract method.
 * An enum can even implement an interface.
 * ---------------------------------------
 * Commons methods values(), name() and ordinal().
 */
public enum SeasonEnum implements Season {

    WINTER, SPRING, SUMMER, FALL;

    @Override
    public String getDescription() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public static void main(String[] args) {
        title("Enums");
        print(SeasonEnum.SPRING.ordinal()); // 1
        print(SeasonEnum.WINTER.name()); // WINTER
        print(List.of(SeasonEnum.values())); // [WINTER, SPRING, SUMMER, FALL]
        print(SeasonEnum.SUMMER.getDescription()); // summer
        print(SeasonEnum.valueOf("FALL")); // FALL
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}


