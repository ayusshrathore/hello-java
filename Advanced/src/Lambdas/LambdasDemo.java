package Lambdas;

import java.util.List;
import java.util.function.*;

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


        //Consumer Interface
        List<Integer> list = List.of(1,2,3);

        // Imperative programming -> implementing logics using instructions (for, if/else, switch/case)
        for(var item: list)
            System.out.println(item);

        // Declarative programming instead of instructions to specify how it needs to be done, we mention only what's
        // need to be done
        // forEach excepts a consumer object of type integer it is of type (IntConsumer)
        list.forEach(item -> System.out.println(item));

        // Chaining consumers
        List<String> list1 = List.of("a", "b", "c");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());
        list1.forEach(print.andThen(printUpperCase));

        // Supplier interface
        Supplier<Double> getRandom = () -> Math.random();
        var random = getRandom.get(); // this getRandom method do not get executed until we explicitly call this method
        // this is termed as lazy evaluation
        System.out.println(random);
        // Also Supplier interface do have some specializations in order to work with primitives such as
        // DoubleSupplier
        // BooleanSupplier, etc...
        // with these we don't really need to sacrifice for the cost of autoBoxing


        // Function interface
        Function<String, Integer> map = str -> str.length();
        var len = map.apply("sky");
        System.out.println(len);

        // Composing functions -> combining smaller functions to build large and complex functions
        // "key:value"
        // "key=value" // first transformation
        // "{key=value}" // second transformation
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        // 2 Ways of composing functions, e.g. of declarative programming
        // 1:
        var result = replaceColon.
                    andThen(addBraces).
                    apply("key:value");
        System.out.println(result);
        // 2:
        var result1 = addBraces.compose(replaceColon).apply("key:value");
        System.out.println(result1);


        // Predicate interface
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        var res = isLongerThan5.test("sky");
        System.out.println(res);

        // combining predicates to build complex predicates
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        var hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);
        var result2 = hasLeftAndRightBraces.test("{key:value}");
        System.out.println(result2);

        var leftOrRightBrace = hasLeftBrace.or(hasRightBrace);
        var noLeftBrace = hasLeftBrace.negate();

        // BinaryOperator Interface
        BinaryOperator<Integer> add = (a, b) -> a + b;
        var result3 = add.apply(1, 2); // since primitive integer need to be autoboxed inside instances of an
        // Integer class it is ideal to use IntBinaryOperator instead which is cost-efficient
        Function<Integer, Integer> squares = a -> a * a;
        var result4 = add.andThen(squares).apply(1,2);
        System.out.println(result4);

        // UnaryOperator Interface
        UnaryOperator<Integer> square = n -> n * n;
        UnaryOperator<Integer> increment = n -> n + 1;

        var result5 = increment.andThen(square).apply(1);
        System.out.println(result5);
    }
    public LambdasDemo(){};
    public LambdasDemo(String message){

    }
    public static void print(String message){};
    public static void greet(Printer printer){
        printer.print("Hello World");
    }
}
