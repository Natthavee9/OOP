import  java.util.Scanner;
class LinearEqution {
      private double a, b, c, d, e, f;

      public LinearEqution(double a, double b, double c, double d, double e, double f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
      }

      public double getA() {
            return a;
      }

      public double getB() {
            return b;
      }

      public double getC() {
            return c;
      }

      public double getD() {
            return d;
      }

      public double getE() {
            return e;
      }

      public double getF() {
            return f;
      }

      boolean isSolve() {
            return ((a * d) - (b * c)) != 0;
      }

      double getX(){
            return ( ((e*d)-(b*f))/ ((a*d)-(b*c)));
      }
      double getY(){
            return ( ((a*f)-(e*c))/ ((a*d)-(b*c)));
      }
}

public class No5 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Enter a b c d e f: ");
            double a= sc.nextDouble();
            double b= sc.nextDouble();
            double c= sc.nextDouble();
            double d= sc.nextDouble();
            double e= sc.nextDouble();
            double f= sc.nextDouble();

            LinearEqution linearEq = new LinearEqution(a, b, c, d, e, f);

            if(linearEq.isSolve()){
                  System.out.println("x is " + linearEq.getX() + " and " + "y is " + linearEq.getY());
            }else{
                  System.out.println("The equation has no solution");
            }

            sc.close();
      }
}
