package Lambdas;

public class LambdasDemo {
    public String suffix = ".";
    public void show(){
        greet(new ConsolePrinter());

        // Anonymous inner class: referred to as inner class as it is used inside a method
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        // Lambda expression -> One liners, they are essentially objects which can be used to represent
        // anonymous functions
        greet(message -> System.out.println(message));
        // greet(System.out::println); lambda with method references

        // we can store a lambda expression inside a variable too
        Printer printer = message -> System.out.println(message);

        // Variable capture : we can make use of local variables of enclosing class or method inside a lambda expression
        String prefix = "~";
        // we can also make use of instance fields & static fields inside a lambda expression
        greet(message -> System.out.println(prefix + message));

        // Major difference in anonymous inner class & lambda expressions is that:
        greet(message -> System.out.println(message+this.suffix));
        // this keyword in lambdaExpression references LambdasDemo class but in anonymous inner class it references
        // that inner class, also in anonymous inner classes we can store fields & data whereas in lambda expressions
        // we can't

        // Method references -> with this we can write compact and easier to read lambda expressions
        // Class/Object::method (here method doesn't involve () because here we make a reference to that method instead
        // of calling that method
        // greet(System.out::println);
        greet(message -> print(message));
        greet(LambdasDemo::print); // method reference

        // for instance methods
        // LambdasDemo demo = new LambdasDemo();
        // greet(message -> demo.print(message));
        // greet(demo::print);

        // Passing a value to a constructor
        greet(message -> new LambdasDemo(message));
        greet(LambdasDemo::new);
    }
    public LambdasDemo(String message){

    }
    public static void print(String message){};
    public static void greet(Printer printer){
        printer.print("Hello World");
    }
}
