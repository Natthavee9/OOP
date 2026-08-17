class Rectangle {
      double width;
      double height;
      double x;
      double y;

      public Rectangle() {
            this.width = 1.0;
            this.height = 1.0;
            this.x = 0.0;
            this.y = 0.0;
      }

      public Rectangle(double width, double height, double x, double y) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
      }

      public double getArea(Rectangle a) {
            return a.width * a.height;
      }
}

class Line {
      double x1, y1;
      double x2, y2;

      public Line() {
            this.x1 = 0.0;
            this.y1 = 0.0;
            this.x2 = 1.0;
            this.y2 = 1.0;
      }

      public Line(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
      }

      public double getLong(Line a) {
            return Math.sqrt(Math.pow(a.x2 - a.x1, 2) + Math.pow(a.y2 - a.y1, 2));
      }
}


public class lab6_no8 {
      public static void main(String[] args) {

            Rectangle rect1 = new Rectangle(10, 10, 0, 0);
            Rectangle rect2 = new Rectangle(5, 5, 8, 8);

            Line line1 = new Line(2, 2, 8, 8);
            Line line2 = new Line(8, 2, 2, 8);
            Line line3 = new Line(15, 15, 20, 20);

            System.out.println("Area of rect1: " + rect1.getArea(rect1));
            System.out.println("Length of line1: " + line1.getLong(line1));

            System.out.println("Is line1 contained in rect1? : " + contains(line1, rect1));

            System.out.println("Is line3 contained in rect1? : " + contains(line3, rect1));

            System.out.println("Do line1 and line2 cross? : " + cross(line1, line2));

            System.out.println("Do line1 and line3 cross? : " + cross(line1, line3));

            System.out.println("Does rect1 overlap with rect2? : " + overlaps(rect1, rect2));

            System.out.println("Distance between center of line1 and center of rect1: " + distance(line1, rect1));
      }

      public static int contains(Line a, Rectangle b) {
            boolean p1Inside = (a.x1 >= b.x && a.x1 <= b.x + b.width) && (a.y1 >= b.y && a.y1 <= b.y + b.height);
            boolean p2Inside = (a.x2 >= b.x && a.x2 <= b.x + b.width) && (a.y2 >= b.y && a.y2 <= b.y + b.height);

            if (p1Inside && p2Inside) {
                  return 1;
            }
            return 0;
      }

      public static int cross(Line a, Line b) {
            double d1 = direction(b.x1, b.y1, b.x2, b.y2, a.x1, a.y1);
            double d2 = direction(b.x1, b.y1, b.x2, b.y2, a.x2, a.y2);
            double d3 = direction(a.x1, a.y1, a.x2, a.y2, b.x1, b.y1);
            double d4 = direction(a.x1, a.y1, a.x2, a.y2, b.x2, b.y2);

            // Check if the lines straddle each other 
            if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) &&
                        ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
                  return 1;
            }
            return 0;
      }

      public static double direction(double xi, double yi, double xj, double yj, double xk, double yk) {
            return (xk - xi) * (yj - yi) - (xj - xi) * (yk - yi);
      }

      public static int overlaps(Rectangle a, Rectangle b) {

            if (a.x >= b.x + b.width || b.x >= a.x + a.width) {
                  return 0;
            }
            if (a.y >= b.y + b.height || b.y >= a.y + a.height) {
                  return 0;
            }
            return 1;
      }

      public static double distance(Line a, Rectangle b) {
            double lineMidX = (a.x1 + a.x2) / 2.0;
            double lineMidY = (a.y1 + a.y2) / 2.0;

            double rectMidX = b.x + (b.width / 2.0);
            double rectMidY = b.y + (b.height / 2.0);

            return Math.sqrt(Math.pow(rectMidX - lineMidX, 2) + Math.pow(rectMidY - lineMidY, 2));
      }
}