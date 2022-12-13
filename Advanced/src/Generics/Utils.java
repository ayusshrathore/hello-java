package Generics;

public class Utils {
    // Common convention with utilities methods is to create them as static methods
    public static <T extends Comparable<T>> T max(T first, T second){
        return first.compareTo(second) > 0 ? first : second;
    }
    public static <K, V> void print(K key, V value){
        System.out.println(key + "=" + value);
    }

    public static void printUser(User user){
        System.out.println(user);
    }

    // wildcard "?" : represents unknown type while using these type java compiler will create
    // an anonymous type under the hood as  -> CAP#1 extends User{}, 1 represents number of wildcards also if we
    // use get method there we can only store the result inside a variable of CAP class or it's base class
    // i.e. Object class

    // In order to read from the list we should use GenericList<? extends User>
    // & in order to write to the list we should use GenericList<? super User> to imitate as Object class
    // which is the parent of User class
    public static void printUsers(GenericList<? super User> users){
        // User x = users.get(0); throws error as java compiler doesn't know as the object we are getting
        // is compatible with the User it could be string obj or a datetime obj etc...
        users.add(new Instructor(10));
        users.add(new User(20));
        Object x = users.get(0);
    }
}
