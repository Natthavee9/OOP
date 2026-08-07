
import java.util.Scanner;

class Circle {
      double radius;
      double area;
      double perimeter;

    Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
        //this.area = area;
        //this.perimeter = perimeter;
    }

    public void calArea(){
      this.area = 3.14*radius*radius;
    }

    public void calPeri(){
      this.perimeter = 2*3.14*radius;
    }

    public String toString(){
      return "radius " +this.radius +"area " + this.area;
    }
      
      
}

public class TestCicleArea{
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("input number: ");
      int n = sc.nextInt();
      Circle [] arrCir = new Circle[n];
      for(int i=0 ; i<arrCir.length;i++){
        System.out.println("input radius: ");
        double radius = sc.nextDouble();
        arrCir[i] = new Circle(radius);


      }
      //display output
      prinArr(arrCir);
      



      sc.close();
  }
  public static  Circle ()

  public static void prinArr(Circle[] arrCir){
    for (int i = 0; i < arrCir.length; i++) {
      arrCir[i].calArea();
      arrCir[i].calPeri();
      System.out.println("" + arrCir[i].toString());
    }

  }
      
}
