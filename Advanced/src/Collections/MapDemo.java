package Collections;

import java.util.HashMap;
import java.util.Map;

// Just like the Set interface Map also do no guarantees order of elements
public class MapDemo {
    public static void show(){
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");
        var c3 = new Customer("c", "e3");

        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        System.out.println(map.get("e1"));

        var unknown = new Customer("Unknown", "");
        var customer = map.getOrDefault("e10", unknown);
        System.out.println(customer);

        var exists = map.containsKey("e11");
        System.out.println(exists);

        map.replace("e1", new Customer("A", "e1"));
        System.out.println(map);

        for (var key : map.keySet())
            System.out.println(key);

        for(var entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());

        for(var cst : map.values())
            System.out.println(cst);
    }
}
