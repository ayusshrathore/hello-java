package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Iterator interface
        var list = new GenericList<String>();
        var iterator = list.iterator();
        // The forEach loop is just the syntactical sugar around iterator object
        list.add("a");
        list.add("b");
        while(iterator.hasNext()){
            var current = iterator.next();
            System.out.println(current);
        }

        // The Collection Interface
        CollectionsDemo.show();

        // List Interface
        ListDemo.show();

        // Comparable Interface
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("b"));
        customers.add(new Customer("a"));
        customers.add(new Customer("c"));
        Collections.sort(customers);
        System.out.println(customers);
    }
}
