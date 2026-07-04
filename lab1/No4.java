import java.util.Scanner;
public class No4 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter balance and interest rate (e.g.,3 for 3%): ");
            double balance = sc.nextDouble();
            double annualRate = sc.nextDouble();
            double interest = balance*(annualRate/1200);
            System.out.println("The interest is "+String.format("%.5f", interest));
            sc.close();
      }
      
}
