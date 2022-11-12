package Collections;

import java.util.*;

// Set interface do not guarantee the order of elements
public class SetDemo {
    public static void show(){
        Set<String> set = new HashSet<>();
        set.add("Sky");
        set.add("is");
        set.add("blue");
        set.add("blue");
        System.out.println(set);

        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "Jimmy", "Timmy", "Jimmy","c");
        Set<String> set1 = new HashSet<>(collection);
        System.out.println(set1);

        Set<String> set2 = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e"));
        Set<String> set3 = new HashSet<>(Arrays.asList("b", "c", "d", "e", "f"));

        // Union
        set2.addAll(set3);
        System.out.println(set2);

        // Intersection
        set3.retainAll(set2);
        System.out.println(set3);

        // Difference
        set2.removeAll(set3);
        System.out.println(set2);

    }
}
