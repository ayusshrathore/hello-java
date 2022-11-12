package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void show(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        // we can't do this with collections interface because they didn't support indexing
        list.add(0, "!");

        Collections.addAll(list, "d", "e", "f");
        System.out.println(list);
        System.out.println(list.get(0));

        list.set(0, "@");
        list.remove(0);
        System.out.println(list.indexOf("@"));
        list.add("b");
        System.out.println(list.lastIndexOf("b"));

        System.out.println(list.subList(1, list.size()));
    }
}
