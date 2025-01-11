package chapter_04_core_apis;

/**
 * Calculating with Math APIs
 */
public class Example3 {
    public static void main(String[] args) {
        title("Min and Max");
        double x = 534.33;
        double y = 443.36;
        print(Math.min(x, y)); // 443.36
        print(Math.max(x, y)); // 534.33

        title("Rounding Numbers");
        print(Math.ceil(x)); // 535.0
        print(Math.floor(x)); // 534.0

        title("Exponents");
        print(Math.pow(5, 3)); // 125.0

        title("Random Numbers");
        print(Math.random());

        title("Calculator");
        print(Math.log10(100)); // 2.0
        print(Math.subtractExact(100, 43)); // 57
        print(Math.multiplyExact(100, 43)); // 4300
        print(Math.addExact(100, 43)); // 143
        print(Math.floorDiv(149, 3)); // 49
        print(Math.sqrt(49)); // 7.0
        print(Math.abs(-987)); // 987
        print(Math.decrementExact(6)); // 5
        print(Math.incrementExact(6)); // 7



    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
