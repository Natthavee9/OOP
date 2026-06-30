import java.util.Scanner;
public class No7 {
      public static void main(String[] args) {
            try(Scanner sc = new Scanner(System.in)){
                  System.out.print("Please input x,n: ");
                  long x = sc.nextLong();
                  long n = sc.nextLong();
                  long sum = 0;
                  for(int i=0 ;i<=n;i++){
                        sum+=Math.pow(x,i);
                  }
                  System.out.println("Output is: "+sum);
            }
      }
}
