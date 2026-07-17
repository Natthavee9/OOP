import  java.util.Scanner;
class LinearEqution {
      private double a, b, c, d, e, f;
      private  double x,y;

      public LinearEqution(double a, double b, double c, double d, double e, double f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
      }

      public double getA() {return a;}
      public void setA(double a) {this.a =a;}
      public double getB() {return b;}
      public void setB(double b) {this.b =b;}
      public double getC() {return c;}
      public void setC(double c) {this.c =c;}
      public double getD() {return d;}
      public void setD(double d) {this.d =d;}
      public double getE() {return e;}
      public void setE(double e) {this.e =e;}
      public double getF() {return f;}
      public void setF(double f) {this.f =f;}

          
      boolean isSolve() {
            return ((a * d) - (b * c)) != 0?true:false;
      }

      public double getX(){
            return ( ((e*d)-(b*f))/ ((a*d)-(b*c)));
      }
      public double getY(){
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
           
            linearEq.getA();
            linearEq.setA(a);
            
            linearEq.getB();
            linearEq.setB(b);
            
            linearEq.getC();
            linearEq.setC(c);
            
            linearEq.getD();
            linearEq.setD(d);
            
            linearEq.getE();
            linearEq.setE(e);
            
            linearEq.getF();
            linearEq.setF(f);

            if(linearEq.isSolve()){
                  System.out.println("x is " + linearEq.getX() + " and " + "y is " + linearEq.getY());
            }else{
                  System.out.println("The equation has no solution");
            }

            sc.close();
      }
}
// 9.0 4.0 3.0 -5.0 -6.0 -21
// 8.0 4.0 3.0 -5.0 -6.0 -21
//1.0 2.0 2.0 4.0 4.0 5.0 