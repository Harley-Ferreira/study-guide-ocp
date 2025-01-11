package chapter_04_core_apis;

import java.util.Arrays;

/**
 * Undertanding Arrays
 */
public class Example2 {
    public static void main(String[] args) {
        title("Creating an Array of Primitives");
        int[] numbers = new int[3];
        print(numbers); // [0, 0, 0]
        int[] moreNumbers = new int[] {420, 14, 3167};
        print(moreNumbers); // [420, 14, 316]
        int[] othersNumbers = {19, 21, 11};
        print(othersNumbers); // [19, 21, 11]

        title("Sorting");
        Arrays.sort(moreNumbers);
        print(moreNumbers); // [14, 316, 420]

        title("Searching");
        print(Arrays.binarySearch(moreNumbers, 1)); // -1
        print(Arrays.binarySearch(moreNumbers, 14)); // -1
        print(Arrays.binarySearch(moreNumbers, 15)); // -2
        print(Arrays.binarySearch(moreNumbers, 316)); // 0 (index)
        print(Arrays.binarySearch(moreNumbers, 420)); // 0 (index)
        print(Arrays.binarySearch(moreNumbers, 50000)); // -4 (index)
        // why is -4?
        // Java thinks this number should be inserted after in index 3.
        // So a calculator is done: (i * (-1) - 1) = (3 * (-1) - 1) = -4

        title("Comparing");
        print(Arrays.compare(moreNumbers, othersNumbers)); // -1
        print(Arrays.compare(moreNumbers, moreNumbers)); // 0
        print(Arrays.compare(moreNumbers, numbers)); // 1
        // A negative number means the first array is smaller than the second
        // A zero the arrays are equal
        // A positive number means the first array is larger than the second

        title("Mismatch");
        print(Arrays.mismatch(moreNumbers, othersNumbers)); // 0
        print(Arrays.mismatch(moreNumbers, moreNumbers)); // -1
        print(Arrays.mismatch(moreNumbers, numbers)); // 0

        title("Multidimensional Arrays");
        int[][] array1 = new int[4][1]; //2D
        int[][][] array2 = new int[4][2][2]; //3D

    }

    public static void print(int[] o) {
        System.out.println(Arrays.toString(o));
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
