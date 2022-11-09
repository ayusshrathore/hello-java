public abstract class AbstractTaxCalculator implements TaxCalculator{
    // Hide this implementation from others, while making it visible to classes that
    // inherits this abstract classes
    protected double getTaxableIncome(double income, double expenses){
        return income - expenses;
    }
}
