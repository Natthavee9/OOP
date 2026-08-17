abstract class GeometricObject {
      private String color = "white";
      private boolean filled;

      protected GeometricObject() {
      }

      protected GeometricObject(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
      }

      public String getColor() {
            return color;
      }

      public void setColor(String color) {
            this.color = color;
      }

      public boolean isFilled() {
            return filled;
      }

      public void setFilled(boolean filled) {
            this.filled = filled;
      }

      public abstract double findArea();

      public abstract double findPerimeter();
}


class Rectangle extends GeometricObject {
      private double width;
      private double height;

      public Rectangle() {
      }

      public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
      }

      public Rectangle(double width, double height, String color, boolean filled) {
            super(color, filled);
            this.width = width;
            this.height = height;
      }

      public double getWidth() {
            return width;
      }

      public void setWidth(double width) {
            this.width = width;
      }

      public double getHeight() {
            return height;
      }

      public void setHeight(double height) {
            this.height = height;
      }

      public double getArea() {
            return width * height;
      }

      public double getPerimeter() {
            return 2 * (width + height);
      }

      
      @Override
      public double findArea() {
            return getArea();
      }

      @Override
      public double findPerimeter() {
            return getPerimeter();
      }
}

class MyRectangle2D {
      
      private double x;
      private double y;
      private double width;
      private double height;

      
      public MyRectangle2D() {
            this.x = 0;
            this.y = 0;
            this.width = 1;
            this.height = 1;
      }

      
      public MyRectangle2D(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
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

      public double getWidth() {
            return width;
      }

      public void setWidth(double width) {
            this.width = width;
      }

      public double getHeight() {
            return height;
      }

      public void setHeight(double height) {
            this.height = height;
      }

      
      public double getArea() {
            return width * height;
      }

      
      public double getPerimeter() {
            return 2 * (width + height);
      }

     
      public boolean contains(double px, double py) {
            
            return Math.abs(px - this.x) <= width / 2 && Math.abs(py - this.y) <= height / 2;
      }

      
      public boolean contains(MyRectangle2D r) {
            
            double rLeft = r.x - r.width / 2;
            double rRight = r.x + r.width / 2;
            double rTop = r.y + r.height / 2;
            double rBottom = r.y - r.height / 2;

            return contains(rLeft, rBottom) &&
                        contains(rRight, rBottom) &&
                        contains(rLeft, rTop) &&
                        contains(rRight, rTop);
      }

      
      public boolean overlaps(MyRectangle2D r) {
            
            boolean overlapX = Math.abs(this.x - r.x) <= (this.width + r.width) / 2;
            boolean overlapY = Math.abs(this.y - r.y) <= (this.height + r.height) / 2;

            return overlapX && overlapY;
      }
}
public class lab6_no7 {
      public static void main(String[] args) {
        
        MyRectangle2D r1 = new MyRectangle2D(0, 0, 10, 10);

        System.out.println("Area: " + r1.getArea());          
        System.out.println("Perimeter: " + r1.getPerimeter()); 

        System.out.println("r1 contain the point (3, 3)? : " + r1.contains(3, 3)); 
        
        System.out.println("r1 contain the point (6, 6)? : " + r1.contains(6, 6)); 

        MyRectangle2D r2 = new MyRectangle2D(0, 0, 4, 4); 
        System.out.println("r1 completely contain r2 (width 4, height 4)? : " + r1.contains(r2)); 
        MyRectangle2D r3 = new MyRectangle2D(4, 4, 4, 4);
        System.out.println("r1 completely contain r3 (width 4, height 4 at coords 4,4)? : " + r1.contains(r3)); 

        System.out.println("r1 overlap with r3? : " + r1.overlaps(r3)); 

        MyRectangle2D r4 = new MyRectangle2D(20, 20, 2, 2); 
        System.out.println("r1 overlap with r4 (at coords 20,20)? : " + r1.overlaps(r4)); 
      }
}