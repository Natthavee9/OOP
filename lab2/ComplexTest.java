class Complex {
  private double r, i;

  Complex(double r, double i) {
    this.r = r;
    this.i = i;
  }

  Complex(Complex c) {
    this(c.r, c.i);
  }

  public void add(Complex c) {
    this.r += c.r;
    this.i += c.i;
  }

  public void minus(Complex c) {
    this.r -= c.r;
    this.i -= c.i;
  }

  public void multiply(Complex c) {
    // (ac - bd) + (ad + bc)i
    double tempR = (this.r * c.r) - (this.i * c.i);
    double tempI = (this.r * c.i) + (this.i * c.r);
    this.r = tempR;
    this.i = tempI;
  }

  public void divide(Complex c) {
    double denominator = Math.pow(c.r, 2) + Math.pow(c.i, 2);
    double tempR = ((this.r * c.r) - (this.i * c.i)) / denominator;
    double tempI = ((this.r * c.i) + (this.i * c.r)) / denominator;
    this.r = tempR;
    this.i = tempI;
  }

  public void print() {
    System.out.println(r + " + " + i + "i");
  }

}

class ComplexTest {
  public static void main(String args[]) {
    Complex a = new Complex(1.0, 2.0);
    Complex b = new Complex(3.0, 4.0);

    System.out.print("Add: ");
    Complex c1 = new Complex(a);
    c1.add(b);
    c1.print();

    System.out.print("\nSubtraction: ");
    Complex c2 = new Complex(a);
    c2.minus(b);
    c2.print();

    System.out.print("\nMultiply: ");
    Complex c3 = new Complex(a);
    c3.multiply(b);
    c3.print();

    System.out.print("\nDivided: ");
    Complex c4 = new Complex(a);
    c4.divide(b);
    c4.print();

  }
}
