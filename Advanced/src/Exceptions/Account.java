package Exceptions;

import java.io.IOException;

public class Account {
    public static void deposit(float value) throws IOException {
        // Defensive programming preventing rest of the code from being executed
        // Adding this validation logic add some bit of noise to our code it makes it much longer
        // & verbose it is better to use this type of programming while taking input from user
        // or building a library or framework for others to use, don't pollute the every application
        // with data validation
        if(value <=0) throw new IOException();
    }
}
