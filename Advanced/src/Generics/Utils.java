package Generics;

public class Utils {
    // Common convention with utilities methods is to create them as static methods
    public static <T extends Comparable<T>> T max(T first, T second){
        return first.compareTo(second) > 0 ? first : second;
    }
    public static <K, V> void print(K key, V value){
        System.out.println(key + "=" + value);
    }
}
