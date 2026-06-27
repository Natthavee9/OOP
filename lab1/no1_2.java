import java.util.Scanner;
public class no1_2 {
      public static void main(String[] args) {
          Scanner sc =  new Scanner(System.in);
          double farenheit = sc.nextDouble();
          double celsius = (5.0/9.0)*(farenheit-32);
          System.out.printf("Celsius:  " + celsius);
          sc.close();
      }    
}
