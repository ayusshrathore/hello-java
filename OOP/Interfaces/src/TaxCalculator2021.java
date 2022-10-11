public class TaxCalculator2021 implements TaxCalculator {
  private double taxableIncome;

  public TaxCalculator2021(double taxableIncome) {
    this.taxableIncome = taxableIncome;
  }

  @Override // specifying the compiler that it is the implementation for the CalculateTax() method declared in interface
  public double calculateTax() {
    return taxableIncome * 0.3;
  }
}
