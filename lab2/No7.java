import java.util.Scanner;

class Rectangle {
      private double h, w, x, y;

      public Rectangle(double h, double w, double x, double y) {
            this.h = h;
            this.w = w;
            this.x = x;
            this.y = y;
      }


      public double overlap(Rectangle r){
            double dx =  Math.abs(this.x - r.x);
            double dy =  Math.abs(this.y - r.y);

      }





}

public class No7 {
      public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);
            System.out.print("Enter r1 center x- ,y-condinate,width and height: ");
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double h1 = sc.nextDouble();
            double w1 = sc.nextDouble();

          
      }

}
