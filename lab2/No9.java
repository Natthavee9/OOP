//Maximum Prime Number
import java.util.Scanner;
class Prime{
      private int max_prime = -1;
      private  int count;
      
      boolean Prime_number(int n){
            if(n <= 1){return false;}

            for(int i = 2 ;i<n;i++){
                  if(n%i ==0){
                        return  false;
                  }
            }

            return true;
      }

      public void Check_Prime(int n){
            if(Prime_number(n)){
                  if(n > max_prime){
                        max_prime = n;
                        count = 1;
                  }
                  else if(n == max_prime){
                        count++;
                  }
            }
      }

      public void printResult(){
            System.out.println("Max Prime Number: " + max_prime);
            System.out.println("Count: " + count);
      }   
}
public class No9{
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Prime p = new Prime();
            while(true){
                  int n = sc.nextInt();
                  if(n == 0){
                        break;
                  }
                  p.Check_Prime(n);
            }
            p.printResult();
            sc.close();
          
      }
}