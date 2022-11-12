package Generics;

public class Main {
    public static void main(String[] args) {
        var list = new List();
        // Reason we are able to store primitive inside a object (reference type) is that
        // when we compile this code java compiler will compile this code into
        // list.add(Integer.valueOf(1)) -> Integer class is a reference type which derives from object class
        // and it has a static method which return a primitive integer type similar to this we have wrapper class
        // to even Float, Boolean, Double, Character .... etc
        list.add(1);
        list.add("1");
        list.add(new User(1));

        // Below code will generate a runtime error (this is the problem with this type of implementation)
        // Instead of using Object type we should make use of generics
        int num =(int) list.get(0);

        // This Generic class ensures every element to be an integer also it enables compile time type safety
        // also we don't need explicit casts
        var list2 = new GenericList<Integer>();
        list2.add(1);
        list2.get(0);


        // Also as discussed earlier we can't just store the primitive types inside a generic class as
        // new GenericList<int> instead we need the wrapper class around primitive ones
        // Some wrapper classes around primitive ones
        // int -> Integer (reference type)
        // float -> Float (reference type)
        // Boolean -> Boolean (reference type)
        GenericList<Integer> numbers = new GenericList<>();
        numbers.add(1); // here we can directly pass a primitive as java compiler itself converts in into an instance
        // of Integer class internally this is termed as boxing as java compiler will put this value inside a box
        int num1 = numbers.get(0); // get the value of instance of Integer class (Unboxing)

        // Constraints
        // new GenericList<String>(); compilation error as GenericList<> class now Inherits from Number class

        // Implementing comparable interface
        User user1 = new User(20);
        User user2 = new User(10);
        if(user1.compareTo(user2) == 0) System.out.println("Both have equal points");
        if(user1.compareTo(user2) < 0) System.out.println("User1 have less points than User2");
        else System.out.println("User1 have more points than User 2");
    }
}
