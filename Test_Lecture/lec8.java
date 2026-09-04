abstract class Geometric {
      double x, y, r;
      double area, peremeter;

      public Geometric() {
      }

      public Geometric(double x, double y) {
            this.x = x;
            this.y = y;
      }

      abstract void calarea() ;

}

class Circle extends Geometric {
      Circle() {
            super();
      }
      
      Circle(double r) {
            super();
            this.r = r;
      }
}

class Rect extends Geometric {

      Rect() {
      }

      Rect(double x, double y) {
            super(x, y);

      }
}

public class lec8 {
      public static void main(String[] args) {
            Geometric o = new Rect(10, 10);
            o.calarea();
            System.out.println(o.area);
      }

}
