import java.util.Scanner;
public class No8 {
      public  long cal(long k,long a0, long a1){

            if(k==0){
                  return a0;
            }
            if(k==1){
                  return a1;
            }
            long squre = k*k;
            long tree_sq =  (long) Math.pow(3,k);

            return squre*cal(k-1,a0,a1)-cal(k-2,a0,a1) + tree_sq;
      }
      public static void main(String[] args) {
            try (Scanner sc = new Scanner(System.in)) {
                  System.out.print("Please input n,a0 and a1: ");
                  long n = sc.nextLong();
                  long a0= sc.nextLong();
                  long a1 = sc.nextLong();
                  
                  No8 m = new No8();
                  
                  System.out.print("Output is: ");
                  for(int i=0;i<=n;i++){
                        System.out.print(m.cal(i,a0,a1) + " ");
                  }
                  System.out.println();
            }
      }
}
