package chapter_09_collections_generics.map;

import java.util.TreeMap;

public class ExempleTreeMap {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 10);
        treeMap.put(2, 20);
        treeMap.put(3, null);
        treeMap.merge(1, 3, (a, b) -> a + b);
        treeMap.merge(3, 3, (a, b) -> a + b);
        System.out.println(treeMap); // {1=13, 2=20, 3=3}
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
