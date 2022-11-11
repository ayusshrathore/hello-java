package Exceptions;

import java.io.FileReader;
import java.util.Locale;

public class ExceptionsDemo {
    public  static void show(){
        sayHello(null);
    }
    public  static void sayHello(String name){
        System.out.println(name.toUpperCase());
    }
    // Java compiler knows that constructor of file reader will throw an exception if file doesn't exist
    var reader = new FileReader("file.txt");
}
