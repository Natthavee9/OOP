//lab 8 no 5
abstract class GeometricObj{
      private String color = "white";
      private boolean filled ;
      protected GeometricObj(){

      }
      protected  GeometricObj(String color, boolean filled) {
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

class Circle extends GeometricObj implements Comparable<Circle>{
      private double r;
      
      public Circle(double r){
            this.r =r;
      }
      
      
      @Override
      public double getArea() {
            return Math.PI *r*r;
      }


      @Override
      public double getPerimeter() {
            return 2*Math.PI*r;
      }


      @Override
      public int compareTo(Circle o) {
            
            return Double.compare(this.r, o.r);
      }


      @Override 
      public  boolean equals(Object obj){
            if( obj instanceof Circle){
                  return this.r == ((Circle)obj).r;
            }
            else{
                  return false;
            }

      }

      public double getR() {
            return r;
      }   
}

class Rectangle extends GeometricObj implements Comparable<Rectangle>{
      private double width;
      private double height;

      public Rectangle(double width,double height){
            this.width = width;
            this.height = height;
      }


      @Override
      public double getArea() {
            return width * height;
      }

      @Override
      public double getPerimeter() {
            return 2*(width+height);
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

class Octagon extends GeometricObj implements Comparable<Octagon>{
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
          
      }
      
}
