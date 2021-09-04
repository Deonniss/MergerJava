package comparators;

/**
 * MyComparator class-compares objects
 */
public class MyComparator {

    public static  <T extends Comparable<T>> int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
