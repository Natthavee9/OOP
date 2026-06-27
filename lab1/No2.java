import java.util.Scanner;
class Med{
      double finacial(double value){
            double interest = 1+0.00417;
            double total =0.0;
            for(int i =1;i<7;i++){
                  total = (value + total) * interest;
            }
            return total;
      }  
}

public class No2 {
      public static void main(String[] args) {
            Med m = new Med();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the monthly saving amount:");
            double value = sc.nextInt();
            double total_sum = m.finacial(value);
            System.out.printf("After the sixth month, the account value is $ %.2f%n",total_sum);
            sc.close(); 
      }    
}
