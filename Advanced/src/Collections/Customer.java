package Collections;

public class Customer implements  Comparable<Customer>{
    private String name;

    public Customer(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Customer other) {
        // this < other return -1
        // this == other return 0
        // this > other return 1
        return name.compareTo(other.name);
    }

    @Override
    public String toString(){
        return name;
    }
}
