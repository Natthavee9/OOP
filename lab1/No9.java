import java.util.Scanner;
public class No9{
      public static void main(String[] args) {
            try(Scanner sc = new Scanner(System.in)){
                  System.out.print("input: ");
                  int n = sc.nextInt();
                  int count = 1;
                  int max = n;
                  while(true){
                        int num = sc.nextInt();
                        if(num == 0){
                              break;
                        }

                        if(num > max){
                              max = num;
                              count = 1;
                        }
                        else if(num == max){
                              count++;
                        }
                  }
                  System.out.print(max+" "+count);
            }    
      }   
}