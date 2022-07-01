import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.awt.*;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        // initializing variables
        byte age = 30;
        System.out.println(age);

        // Data types
        // Primitive: for storing simple values
        long myViewsCount = 3_123_456_789L;
        float price = 99.99F; // compilation error cause java by default sees 99.99 as double
        char letter = 'A';
        boolean isEligible = false;
        System.out.println(myViewsCount);

        // Reference (Non-Primitive): for storing complex values, in Reference types we
        // need to allocate memory for the objects

        Date now = new Date();
        System.out.println(now);

        // Difference between refrence and primitive types
        // Primitive types are copied by value
        // Reference types store the reference to the objects somewhere in the memory
        byte x = 10;
        byte y = x;
        x = 12;
        System.out.println(y);

        Point p1 = new Point(10, 20);
        Point p2 = p1;
        p1.x = 100;
        System.out.println(p2);

        // Strings: are reference types but as we use them more often we can use the
        // primitive type syntax
        String name = "John" + " " + "Doe";
        System.out.println(name);

        // Since String is a class we can use the dot notation to access the methods
        System.out.println(name.startsWith("John", 0));
        System.out.println(name.endsWith("Doe"));
        System.out.println(name.length());
        System.out.println(name.indexOf("o"));

        // Argument vs parameter
        // Argument: the value that is passed to the method
        // Parameter: the variable that is used to store the argument value

        // Since strings are immutable we can't change the value of a string hence this
        // returns a new string object
        System.out.println(name.replace("Doe", "Clinton"));
        System.out.println(name.toLowerCase());
        System.out.println(name.trim());

        // Escape Sequences
        // \n: new line
        // \t: tab
        // \b: backspace
        // \r: carriage return
        // \': single quote
        // \" double quote
        // \\: backslash
        System.out.println("Hello" + " \"" + name + "\"");
        System.out.println("\npath:\tc:\\Users\\John\\Documents\\");

        // Arrays: reference types
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;

        // numbers[6] = 3; // this will throw an exception (java way to report errors),
        // since the array is of size 5

        System.out.println(numbers); // output: [I@27f674d by default java return this string which is calculated
        // based on the address of the array object in the memory
        System.out.println(Arrays.toString(numbers)); // output: [1, 2, 0, 0, 0]

        // another method to initialize an array
        int[] nums = { 1, 4, 3, 2, 0 };
        System.out.println(nums.length);

        // In Java arrays have fixed size, so we can't add or remove additional elements
        // from them, in order to add or remove elements collection classes are used

        Arrays.sort(nums); // sorting using in-built sort method
        System.out.println(Arrays.toString(nums));

        // 2D Arrays
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        System.out.println(Arrays.deepToString(matrix)); // Deep to string: converts multidimensional arrays to string

        // another method to initialize a 2D array
        int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.deepToString(matrix2));

        // Constans: final variables can't be changed after initialization
        final float PI = 3.14F;
        System.out.println("PI value can't be changed:" + PI);

        // Arthematic operators
        // +, -, *, /, %, ++, --
        int x1 = 10;
        int y1 = x + 20;
        System.out.println("value of x1 is: " + x1);
        System.out.println("value of y1 is: " + y1);

        double y2 = (double) 10 / (double) 3;
        System.out.println("value of y2 is: " + y2);
        x1 = 10;
        x1++;
        System.out.println(x1);

        // Post increment with assignment
        int x2 = 30;
        int y3 = x2++;
        System.out.println(x2); // here x2 is 31 because the value of x2 is incremented before printing
        System.out.println(y3); // here y2 is 30 because the value of x2 is first copied into and then
        // incremented

        // Assignment operators (augmented/compound assignment operators)
        // =, +=, -=, *=, /=, %=
        int x3 = 10;
        x3 += 20;
        System.out.println("value of x3 is: " + x3);

        // Precedence and Associativity of operators
        // Precedence: the order in which operators are evaluated
        // Associativity: the order in which operators are grouped
        int z = 10 + 3 * 2;
        System.out.println(z); // output: 16
        z = (10 + 3) * 2;
        System.out.println(z); // output: 26

        // Conversion and casting
        // Explicit: explicit conversion is done by casting
        // Implicit: implicit conversion is done by compiler (no chance of data loss)

        // Casting: Implicit conversion done by copying the value of the variable into
        // the anonynous variable somewhere in the memory and then adding the number to
        // it
        // byte > short > int > long > float > double (for only numeric types)
        int a = 10;
        double b = a;
        short c = 1;
        int d = c + 2;
        System.out.println(d); // output: 3
        System.out.println(b); // output: 10.0

        // Explicit conversion:
        double e = 10.0;
        double f = e + 2;
        System.out.println(f); // output: 12.0

        double g = 1.1;
        int h = (int) g + 2; // here we are converting the double value to int (explicit casting)
        System.out.println(h);

        // In order to convert a string to an integer we make use of wrapper classes
        // such as Integer.parseInt(), Double.parseDouble(), etc.
        String str = "10";
        String num = "11.3";
        System.out.println(Integer.parseInt(str) + 4); // this will throw an exception if the string is not a number
        System.out.println(Double.parseDouble(num) + 3.5);

        // Math class
        // Math.round()
        int result = Math.round(10.5F); // this will round the value to the nearest integer
        System.out.println(result);

        // Math.ceil()
        int result2 = (int) Math.ceil(1.1F); // return smallest integer greater than or equal to the argument
        System.out.println(result2);

        // Math.floor()
        int result3 = (int) Math.floor(1.1F); // return largest integer less than or equal to the argument
        System.out.println(result3);

        // Math.max()
        int result4 = Math.max(10, 20);
        System.out.println(result4);

        // Math.min()
        int result5 = Math.min(10, 20);
        System.out.println(result5);

        // Math.random()
        double result6 = Math.random(); // this will return a random number between 0 and 1
        System.out.println(result6);

        result6 = Math.random() * 100; // this will return a random number between 1 and 100
        System.out.println(result6);
        System.out.println(Math.round(result6)); // this will round the value to the nearest integer

        int result7 = (int) Math.random() * 100;
        System.out.println(result7); // output: 0 because since we didn't included entire expression to cast we lose
        // the decimal part
        result7 = (int) (Math.random() * 100);
        System.out.println(result7);

        // Formatting numbers
        // NumberFormat currency = new NumberFormat(); // this gives a exception since
        // we are trying to create an instance from abstract class

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println((String) (currency.format(12345622.789))); // this will return $123,456.79

        // method chaining
        System.out.println((String) (NumberFormat.getPercentInstance().format(0.6))); // this will return 60%

        // Taking input from user
        Scanner scanner = new Scanner(System.in); // for terminal input
        System.out.print("Enter your age: ");
        // byte myage = scanner.nextByte();
        // System.out.println("age is: " + myage); // implicit conversion

        // System.out.print("Enter your name: ");
        // String myname = scanner.next(); // input: "John Doe" (two tokens)
        // System.out.println("name is: " + myname); // output: John, because next()
        // method reads the first token

        // In order to get rid of it either we call nex() method time the number of
        // token or we use nextLine()

        // String myname = scanner.nextLine().trim();
        // System.out.println("My name is: " + myname);

        // Comparison operators
        // ==, !=, >, <, >=, <=
        int x4 = 10;
        int y4 = 20;
        System.out.println(x4 == y4); // output: false
        System.out.println(x4 <= y4); // output: true
        System.out.println(x4 >= y4); // output: false
        System.out.println(x4 < y4); // output: true
        System.out.println(x4 > y4); // output: false
        System.out.println(x4 != y4); // output: true

        // Logical operators
        // &&, ||, !
        int temperature = 30;

        // evaluation order: !, &&, || (left to right)
        boolean isWarm = temperature > 20 && temperature <= 40;
        System.out.println(isWarm); // output: true

        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean areEligible = (hasGoodCredit || hasHighIncome) && !hasCriminalRecord;
        System.out.println(areEligible);

        // Conditional statements
        // if, else if, else

        int temp = 33;
        if (temp > 30)
            System.out.println("It is warm");
        else if (temp > 20)
            System.out.println("It is normal");
        else
            System.out.println("It is cold");

        // Simplyfing if statements
        int income = 120_0000;
        if (income > 100_000) // cumbersome way of writing the same thing
            System.out.println("You are eligible for loan");
        boolean haveHighIncome = (income > 100_000); // this is the same as above but an elegant way
        System.out.println(haveHighIncome);

        // Ternary operator
        int incomes = 120_000;
        String className = incomes > 100_000 ? "First" : "Economy";
        System.out.println(className);

        // Switch statements
        String role = "admin";
        if (role.equals("admin")) {
            System.out.println("You are an admin");
        } else if (role.equals("user")) {
            System.out.println("You are a user");
        } else {
            System.out.println("You are not an admin or user");
        }
        switch (role) {
            case "admin":
                System.out.println("You are an admin");
                break;
            case "user":
                System.out.println("You are a user");
                break;
            default:
                System.out.println("You are not an admin or user");
        }

        // FizzBuzz
        System.out.print("Number: ");
        int number = scanner.nextInt();

        // most specific condition first and then general condition
        if (number % 5 == 0 && number % 3 == 0)
            System.out.println("FizzBuzz");
        else if (number % 3 == 0)
            System.out.println("Fizz");
        else if (number % 5 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);

        // WRT DRY (Don't Repeat Yourself) code looks like this
        if (number % 5 == 0) {
            if (number % 3 == 0)
                System.out.println("FizzBuzz");
            else
                System.out.println("Buzz");
        } else if (number % 3 == 0)
            System.out.println("Fizz");
        else
            System.out.println(number);

        // Loops
        // for loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World " + i);
        }

        // while loop
        String input = "";
        while (!input.equals("exit")) { // this will raise an exception as String is reference type & we can't use
            // comparison operator on reference types because they will compare the address
            // not values
            System.out.print("Enter your name: ");
            input = scanner.next().toLowerCase();
            System.out.println(input.equals("exit") ? "Bye" : "Hello " + input);
        }

        // do while loop
        do {
            System.out.print("Enter your name: ");
            input = scanner.next().toLowerCase();
            System.out.println(input.equals("exit") ? "Bye" : "Hello " + input);
        } while (!input.equals("exit"));

        // continue and break statements
        while (true) {
            System.out.print("Enter your name: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass"))
                continue;
            if (input.equals("exit"))
                break;
            System.out.println(input);
        }

        // for each loop
        // limitations: it's always iterates in forward direction also we doesn't have
        // access to index of item
        // In Java we can't use a for each loop on String but we can convert the string
        // to charArray()
        String[] persons = { "John", "Jane", "Jack" };
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
        for (String person : persons) {
            System.out.println(person);
        }

        // creating methods
        String greet = printHello("John", "Dane");
        System.out.println(greet);

        // Debugging: process of finding and fixing errors in a program
        // callstack: methods stacked in reverse order of execution
        System.out.println("Start");
        printNumbers(4);
        System.out.println("End");

        // Deploying programs:
        // 1. Package code into jar file (Java Archive) - .jar is a package file format
        // that contains the entire code

        // execution of jar file: java -jar <jar file name>

        // Module: another level of abstraction over a package
        scanner.close();

    }

    public static String printHello(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    // function to print numbers from 0 to limit
    public static void printNumbers(int limit) {
        // FIXME: error in this loop
        // for (int i = 0; i < limit; i+=2) {
        // System.out.println(i);
        // }

        // FIXED:
        for (int i = 0; i <= limit; i++) {
            System.out.println(i);
        }
    }
}
