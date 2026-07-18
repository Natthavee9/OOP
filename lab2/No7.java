import java.util.Scanner;

class Rectangle {
      private double h, w, x, y;

      public Rectangle(double h, double w, double x, double y) {
            this.h = h;
            this.w = w;
            this.x = x;
            this.y = y;
      }

      public boolean  overlap(Rectangle r){
            double dx =  Math.abs(this.x - r.x);
            double dy =  Math.abs(this.y - r.y);

            return (dx <= (this.w + r.w)/2) &&(dy <= (this.h + r.h)/2);
      }

      public boolean contain(Rectangle r){
            double dx = Math.abs(this.x - r.x);
            double dy = Math.abs(this.y - r.y);

            return (dx + r.w/2 <= this.w/2)&& (dy + r.h/2 <= this.h/2);
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
            Rectangle r1 = new Rectangle(h1, w1, x1, y1);

            System.out.print("Enter r2 center x- ,y-condinate,width and height: ");
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double h2 = sc.nextDouble();
            double w2 = sc.nextDouble();
            Rectangle r2 =new Rectangle(h2, w2, x2, y2);

            if(r1.contain(r2)){
                  System.out.println("r2 is inside r1");
            }
            else if(r1.overlap(r2)){
                  System.out.println("r2 overlap r1");
            }
            else{
                  System.out.println("r2 not overlap r1");
            }
          sc.close();
      }
}
//2.5 4 2.5 43
//1.5 5 0.5 3