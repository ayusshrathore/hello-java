public class Employee {
    // encapsulated fields and their methods into single class
    private int baseSalary;
    private int hourlyRate;
    public int extraHours;

    // static field
    public static int numberOfEmployees;

    // constructor to initialize the fields
    public Employee(int baseSalary, int hourlyRate) {
        // but with this method wee can still set the // values to zero
        // this.baseSalary = baseSalary;
        // this.hourlyRate = hourlyRate;

        // so making use of setters
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++; // everytime we create an object, numberOfEmployees is incremented
    }

    // static method
    public static void printNumberOfEmployees() {
        System.out.println("Number of employees: " + numberOfEmployees);
        // static methods can only call other static methods.
        // as we can't call calculateWage() method here

        // in order to use that method we need to create Employee object new Employee()

    }

    // overloading constructor
    public Employee(int baseSalary) {
        // first approach
        // setBaseSalary(baseSalary);
        // setHourlyRate(0);

        // 2nd approach
        this(baseSalary, 0); // reusing the logic of first constructor
    }

    public int calculateWage(int extraHours) {
        return baseSalary + (extraHours * hourlyRate);
    }

    // overloading the calculateWage method
    // in first implementation we pass extraHours in 2nd we didn't
    // too much overloading will lead code to be highly unmaintainable

    // public int calculateWage() {
    // return calculateWage(0);
    // }

    // Overloading should be done when dealing with completely different parameter
    // types

    private void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0) // preventing the baseSalary from going into an invalid state
            throw new IllegalArgumentException("Base salary cannot be negative or zero!");
        this.baseSalary = baseSalary;
    }

    private int getBaseSalary() {
        return baseSalary;
    }

    private int getHourlyRate() {
        return this.hourlyRate;
    }

    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate < 0)
            throw new IllegalArgumentException("Hourly rate cannot be negative or zero!");
        this.hourlyRate = hourlyRate;
    }

}
