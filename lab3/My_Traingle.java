
import java.util.*;
class MyTraingle{
      private double side1,side2,side3;

      public MyTraingle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
      }

      public boolean isValid(double side1,double side2,double side3){
            double sum_1_2 = side1 + side2;            
            double sum_1_3 = side1 + side3;
            double sum_2_3 = side2 + side3;

            if(sum_1_2 > side3 && sum_1_3 > side2 && sum_2_3 > side1){
                  return true;
            }
            return false;
      }

      public double area(double side1,double side2,double side3){
            double s = (side1+side2+side3)/2;
            double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
            return area;
      }

      
}

public class My_Traingle{
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          double s1 = sc.nextDouble();
          double s2 = sc.nextDouble();
          double s3 = sc.nextDouble();
          MyTraingle t = new MyTraingle(s1, s2, s3);

          if(t.isValid(s1, s2, s3)){
            System.out.println(1);
            System.out.println("area: " + String.format("%.2f",t.area(s1, s2, s3)));
          }else{
                System.out.println(0);
          }
          sc.close();
      }
}