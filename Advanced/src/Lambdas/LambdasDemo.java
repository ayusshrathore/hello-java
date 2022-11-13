package Lambdas;

public class LambdasDemo {
    public static void show(){
        greet(new ConsolePrinter());

        // Anonymous inner class: referred to as inner class as it is used inside a method
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }
    public static void greet(Printer printer){
        printer.print("Hello World");
    }
}
