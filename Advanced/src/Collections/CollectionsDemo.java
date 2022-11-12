package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show(){
        Collection<String> collection = new ArrayList<>();
        // The collections utility class is part of java.util package

        // utility methods:
        Collections.addAll(collection, "a", "b", "c");
        System.out.println(collection.size());
        System.out.println(collection.contains("a"));
        collection.remove("a");
        System.out.println(collection.isEmpty());

        // cloning collections
        var stringArray = collection.toArray(new String[0]);
        System.out.println(stringArray[0].toUpperCase());

        // equality operator
        Collection<String> other = new ArrayList<>();
        other.addAll(collection);

        System.out.println(collection == other);
        System.out.println(collection.equals(other));
    }
}
