//Instead of using Static methods inside an interface we should always prefer to use Abstract classes instead,
// as interface do not meant for implementing a logic, they are for what's not how's
public class TaxCalculator2021 extends AbstractTaxCalculator {
  private double taxableIncome;

  public TaxCalculator2021(double taxableIncome) {
    this.taxableIncome = taxableIncome;
  }

  @Override // specifying the compiler that it is the implementation for the CalculateTax() method declared in interface
  public double calculateTax() {
//    getTaxableIncome();
    return taxableIncome * 0.3;
  }
}
