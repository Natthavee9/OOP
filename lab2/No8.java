class RegularPolygon {
      private int n = 3;
      private double side = 1;
      private double x = 0;
      private double y = 0;

      public RegularPolygon() {

      }

      public RegularPolygon(int n, double side) {
            this.n = n;
            this.side = side;
            this.x = 0;
            this.y = 0;
      }

      public RegularPolygon(int n, double side, double x, double y) {
            this.n = n;
            this.side = side;
            this.x = x;
            this.y = y;
      }

      public int getN() {
            return n;
      }

      public void setN(int n) {
            this.n = n;
      }

      public double getSide() {
            return side;
      }

      public void setSide(double side) {
            this.side = side;
      }

      public double getX() {
            return x;
      }

      public void setX(double x) {
            this.x = x;
      }

      public double getY() {
            return y;
      }

      public void setY(double y) {
            this.y = y;
      }

      public double getArea() {
            return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
      }

      public double getPerimeter() {
            return n * side;
      }
}

public class No8 {
      public static void main(String[] args) {
            RegularPolygon r1 = new RegularPolygon();
            RegularPolygon r2 = new RegularPolygon(6, 4);
            RegularPolygon r3 = new RegularPolygon(10,4, 5.6, 7.8);

            System.out.print("\tPolygon 1");
            System.out.print("\nPerimeter: " + String.format("%.3f", r1.getPerimeter()));
            System.out.print("\nArea: " + String.format("%.3f", r1.getArea()));
            
            System.out.print("\n\n\tPolygon 2");
            System.out.print("\nPerimeter: " + r2.getPerimeter());
            System.out.print("\nArea: " + String.format("%.3f",r2.getArea()));
            
            System.out.print("\n\n\tPolygon 3");
            System.out.print("\nPerimeter: " + r3.getPerimeter());
            System.out.print("\nArea: " + String.format("%.3f",r3.getArea()));
      }
}