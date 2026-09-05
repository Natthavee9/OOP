//lab 8 no 5
abstract class GeometricObj {
      private String color = "white";
      private boolean filled;

      protected GeometricObj() {

      }

      protected GeometricObj(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
      }

      public String getColor() {
            return color;
      }

      public boolean isFilled() {
            return filled;
      }

      public void setColor(String color) {
            this.color = color;
      }

      public void setFilled(boolean filled) {
            this.filled = filled;
      }

      public abstract double getArea();

      public abstract double getPerimeter();

}

class Circle extends GeometricObj implements Comparable<Circle> {
      private double r;

      public Circle(double r) {
            this.r = r;
      }

      @Override
      public double getArea() {
            return Math.PI * r * r;
      }

      @Override
      public double getPerimeter() {
            return 2 * Math.PI * r;
      }

      @Override
      public int compareTo(Circle o) {

            return Double.compare(this.r, o.r);
      }

      @Override
      public boolean equals(Object obj) {
            if (obj instanceof Circle) {
                  return this.r == ((Circle) obj).r;
            } else {
                  return false;
            }

      }

      public double getR() {
            return r;
      }
}

class Rectangle extends GeometricObj implements Comparable<Rectangle> {
      private double width;
      private double height;

      public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
      }

      @Override
      public double getArea() {
            return width * height;
      }

      @Override
      public double getPerimeter() {
            return 2 * (width + height);
      }

      @Override
      public int compareTo(Rectangle o) {
            return Double.compare(this.getArea(), o.getArea());
      }

      @Override
      public boolean equals(Object obj) {
            if (obj instanceof Rectangle) {
                  return this.getArea() == ((Rectangle) obj).getArea();
            } else {
                  return false;
            }

      }
}

class Octagon extends GeometricObj implements Comparable<Octagon> {
      private double side;

      public Octagon(double side) {
            this.side = side;
      }

      @Override
      public double getArea() {
            return (2 + (4 / Math.sqrt(2))) * side * side;
      }

      @Override
      public double getPerimeter() {
            return 8 * side;
      }

      @Override
      public boolean equals(Object obj) {
            if (obj instanceof Octagon) {
                  return this.getArea() == ((Octagon) obj).getArea();
            }
            return false;
      }

      @Override
      public int compareTo(Octagon o) {
            return Double.compare(this.getArea(), o.getArea());
      }
}

class ComparableCircle extends Circle {

      public ComparableCircle(double r) {
            super(r);
      }

      @Override
      public int compareTo(Circle o) {
            return Double.compare(this.getArea(), o.getArea());
      }
}

public class GeometricObject {
      public static void main(String[] args) {
            Circle c1 = new Circle(10);
            Circle c2 = new Circle(10);
            System.out.println("Area of Circle1: " + c1.getArea());
            System.out.println("Perimeter of Circle1: " + c1.getPerimeter());
            System.out.println("Area of Circle2: " + c2.getPerimeter());
            System.out.println("Perimeter of Circle2: " + c1.getPerimeter());
            System.out.println("Circle 1 = Circle 2 : " + c1.equals(c2));
            if(c1.compareTo(c2)>0){
                  System.out.println("Circle 1 bigger than Circle 2");
            }
            else{
                  System.out.println("Circle 2 bigger than Circle 1");
            }

            System.out.println();

            Rectangle r1 = new Rectangle(10, 20);
            Rectangle r2 = new Rectangle(5, 5);
            System.out.println("Area of Rectangle1 : "+r1.getArea());
            System.out.println("Perimeter of Rectangle1 : "+r1.getPerimeter());
            System.out.println("Area of Rectangle2 : "+r2.getArea());
            System.out.println("Perimeter of Rectangle2 : "+r2.getPerimeter());
            System.out.println("Rectangle1 = Rectangle2 : " + r1.equals(r2));
            if (r1.compareTo(r2) > 0) {
                  System.out.println("Rectangle 1 bigger than Rectangle 2");
            } else {
                  System.out.println("Rectangle 2 bigger than Rectangle 1");
            }

            System.out.println();

            Octagon oct1 = new Octagon(10);
            Octagon oct2 =  new Octagon(20);
            System.out.println("Area of Octagon1 : " + oct1.getArea());
            System.out.println("Perimeter of Octagon1 : " + oct1.getPerimeter());
            System.out.println("Area of Octagon2 : " + oct2.getArea());
            System.out.println("Perimeter of Octagon2 : " + oct2.getPerimeter());
            System.out.println("Octagon1 = Octagon2 : " + oct1.equals(oct2));
            
            System.out.println();

            ComparableCircle cc1 = new ComparableCircle(4);
            ComparableCircle cc2 = new ComparableCircle(6);
            ComparableCircle largest = (cc1.compareTo(cc2) > 0) ? cc1 : cc2;
            System.out.println("The largest circle has area: " + largest.getArea());
      }
}
