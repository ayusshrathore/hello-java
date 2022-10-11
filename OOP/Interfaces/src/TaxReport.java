public class TaxReport {
    private TaxCalculator2021 calculator;

    // This class should not be concerned in creating the calculator obj, it should be only using it
    // creating a object and using it are two different concerns, this is what is known as separation of concerns
    // we would create another class and that class would be responsible for creating a calculator obj and give
    // Report class a calculator obj this is what is known as dependency injection that another class will inject a dependency
    public TaxReport(){
        // as soon as we add another parameter in TaxCalculator constructor
        // we go on breaking changes in his TaxReport class this is coupling in action
        calculator = new TaxCalculator2021(100_000);
    }
    public void show(){
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }
}
