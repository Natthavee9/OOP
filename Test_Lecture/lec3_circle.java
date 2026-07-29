 /*class lec3_circle {
      public static void main(String[] args) {
            Circle obj1 = new Circle(10);
            printCircle(obj1);
          
      }
      
      public static void printCircle(Circle c) {
            c.calArea();
            c.calPerimeter();
            System.out.println("Area " + c.area());

      }
      
}*/

class Circle{
      double radius;
      double area;
      double perimeter;

    Circle() {
      

    }
      
      public Circle(double radius, double area, double perimeter) {
          this.radius = radius;
          //this.area = area;
          //this.perimeter = perimeter;
     }

      public static void main(String[] args) {
            Circle c = new Circle(10);
            System.out.println("Inside c"+);
          
      }

      

    

      
}
