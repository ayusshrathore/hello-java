package Collections;

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
    }
}
