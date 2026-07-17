import java.util.Scanner;

class Circle {
      // attribute
      private double radius = 0; // encapsulation
      private double area = 0.0;
      private double perimeter = 0.0;

      // Constructer
      Circle() {
            radius = 0;
            area = 0;
            perimeter = 0;
      }

      Circle(double radius) {
            this.radius = radius;

      }

      // setter ---change value in object---
      public void setRadius(double radius) {
            if (radius < 0) {
                  System.err.println("radius less more than 0");
            } else {
                  this.radius = radius;
            }

      }

      public double getRadius() {
            return this.radius;
      }

      public double getArea() {
            calArea();
            return this.area;

      }

      public double getPerimeter() {
            calPerimeter();
            return this.perimeter;
      }

      void calArea() {
            this.area = 3.14 * this.radius * this.radius;
      }

      void calPerimeter() {
            this.perimeter = 2 * 3.14 * this.radius;
      }

      void printCircle() {
            calArea();
            calPerimeter();
            System.out.println("Circle radius= " + this.radius +
                        " \nArea = " + this.area + " \nPerimeter = " + this.perimeter);
      }

}

public class Sec2_lec2 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            /*
             * Circle c1 = new Circle();
             * c1.printCircle();
             */

            System.out.println("Input radius");

            Circle c2 = new Circle();
            double radius = sc.nextDouble();
            c2.setRadius(radius);
            System.out.println("Area " + c2.getArea());

            // c2.radius = 20;
            // c2.printCircle();

            sc.close();
      }

}