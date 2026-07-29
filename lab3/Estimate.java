import  java.util.*;
class Estimate_pi{
      double m(double i){
            double sum = 0;
            for(int j =1 ;j<=i;j++ ){
                  sum+=Math.pow(-1,j+1)/(2.0*j-1);
            }
            return 4 *sum;
      }
}
public class Estimate{
      public void main(String[] args){
            Scanner sc = new Scanner(System.in);
            double n = sc.nextDouble();
            Estimate_pi ep = new Estimate_pi();
            double result = ep.m(n);
            System.out.println(String.format("%.4f",result));

      }
}