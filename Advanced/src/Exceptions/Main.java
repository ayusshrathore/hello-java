package Exceptions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // An exception is an object which contains the information about the error
        try {
            ExceptionsDemo.show();
        } catch (Throwable e) {
            System.out.println("An unexpected error occurred.");
        }
    }
}
