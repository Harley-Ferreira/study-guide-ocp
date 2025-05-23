package chapter_09_collections_generics.sorting;

import java.util.Comparator;
import java.util.TreeSet;

public record Sorted(int num, String text) implements Comparable<Sorted>, Comparator<Sorted> {
    @Override
    public int compareTo(Sorted o) {
        return text.compareTo(o.text);
    }

    @Override
    public int compare(Sorted o1, Sorted o2) {
        return o1.num - o2.num;
    }

    public static void main(String[] args) {
        var s1 = new Sorted(88, "a");
        var s2 = new Sorted(55, "b");
        var t1 = new TreeSet<Sorted>();
        t1.add(s1); t1.add(s2);
        var t2 = new TreeSet<Sorted>(s1);
        t2.add(s1); t2.add(s2);
        System.out.println(t1 + " " + t2); // [88, 55] [55, 88]
    }

    @Override
    public String toString() {
        return "" + num;
    }
}
