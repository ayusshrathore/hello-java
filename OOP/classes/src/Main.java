public class Main {
    public static void main(String[] args) throws Exception {
        var textBox1 = new TextBox(); // instantiate a new TextBox object using var will automatically create a new
        // object of class type TextBox.
        // In java variables have static types and cannot be reassigned.
        textBox1.setText("Box 1"); // removing this line will give null as result because text is String and
        // Strings are refrence type, in order to fix this problem we should initialize
        // the text field with empty string.

        // System.out.println(textBox1.text.toUpperCase()); // this will raise an null
        // pointer exception if text is null
        System.out.println(textBox1.text);

        var textBox2 = new TextBox();
        textBox2.setText("Box 2");
        System.out.println(textBox2.text);

        // Memory management
        // In java, objects are created on the heap and are destroyed when they are no
        // longer needed.
        // Both below variables are pointing to the same object (i.e we have only one
        // object of type TextBox and 2 variables pointing to its memory address on
        // stack)
        var textBox3 = new TextBox();
        var textBox4 = textBox3; // rhs contains the address of the object on the heap which is coppied to lhs.
        textBox3.setText("Hello");
        System.out.println(textBox4.text);

        // Java automatically deallocates the memory to the variables store on stack
        // immediately after executing the main method.

        // Also for the object stored on head there is another process watching the
        // object and if object is not used for a specific time then it is destroyed.
        // This is called Garbage collection.
        // And is done by garbage collector.

        // Procedural programming
        // resultant code becomes to polluted and hard to maintain.
        int baseSalary = 50_000;
        int extraHours = 10;
        int hourlyRate = 20;

        int wage = calculateWage(baseSalary, extraHours, hourlyRate);
        System.out.println(wage);

        // Encapulation: Encapsulation is the process of wrapping the data and methods
        // into single unit.

        // OOP implementation of above procedural demo.

        // var employee = new Employee();
        // employee.baseSalary = 50_000;
        // employee.hourlyRate = 20;
        // int employeeWage = employee.calculateWage(10);
        // System.out.println(employeeWage);

        // Getters and setters: In Java we keep fields private and use getters and
        // setters upon them
        // Getters and setters are used to access and modify the encapsulated fields.
        // Adding some sort of validation to Employee class.
        var employee = new Employee(20_000, 20);
        // employee.setBaseSalary(-1);
        int employeeWage = employee.calculateWage(10);
        System.out.println(employeeWage);

        // Abstraction: Abstraction is the process of hiding the implementation details
        // and treat the class like blackbox

        // Coupling: Coupling is the process of having too many dependencies between
        // classes.

        // 4 coupling points
        // var employee = new Employee(); // 1
        // employee.setBaseSalary(-1); // 2
        // employee.setHourlyRate(20); // 3
        // int employeeWage = employee.calculateWage(10); // 4
        // System.out.println(employeeWage);

        // Reducing coupling
        var browser = new Browser();
        // hiding the implementation details from Main class such as sendHttpRequest and
        // findIpAddress methods which causes breaking of coupling.
        browser.navigate("google.com");

        // Constructor: In java, constructor is a special method which is called when an
        // object is created.

        // Constructor is used to initialize the fields of the class.
        // Default values of reference types are null.
        // Default values of primitive types are 0.
        // Default values of boolean type are false.
        var employee1 = new Employee(50_000, 20);
        var employee2 = new Employee(50_000); // constructor overloading
        int employeeWage1 = employee1.calculateWage(10);
        System.out.println(employeeWage1);

        // Method overloading: In java, methods can be overloaded, i.e. having same name
        // doing different things.

        // Static methods or members : In java, static methods are called without
        // creating an object.

        // Instance methods or members : In java, instance methods are called by
        // creating an object.

        // Purpose of static methods: Static methods are used to perform some common
        // tasks which are common to all the objects of the class.
        // such as Employee.numberOfEmployees();

        // static methods can only call other static methods.
        // Main method is created as static so to enable java to directly call it
        // without creating a new object
        Employee.printNumberOfEmployees();

        // examples of static fields and methods
        // System.out is a static field
        // Integer.parseInt is a static method
    }

    public static int calculateWage(int baseSalary, int extraHours, int hourlyRate) {
        return baseSalary + (extraHours * hourlyRate);
    }
}
