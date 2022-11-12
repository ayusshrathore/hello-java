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
        list.add(new User());

        // Below code will generate a runtime error (this is the problem with this type of implementation)
        // Instead of using Object type we should make use of generics
        int num =(int) list.get(0);

        // This Generic class ensures every element to be an integer also it enables compile time type safety
        // also we don't need explicit casts
        var list2 = new GenericList<Integer>();
        list2.add(1);
        list2.get(0);
    }
}
