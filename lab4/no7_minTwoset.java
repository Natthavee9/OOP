import java.util.*;
class minTwoset{
      private  int[] arr;
      public minTwoset(int[] arr) {
            this.arr = arr;
      }

      public int findMin(){
            int total = 0;
            int n = arr.length;
           
            for(int i = 0 ;i<n;i++){
                  total+=arr[i];
            }

            boolean dp[] = new boolean[total +1];
            dp[0] = true;
            for(int j=0;j<n;j++){
                  for(int k = total;k>= arr[j];k--){
                        if(dp[k - arr[j]]){
                              dp[k] = true;
                        }
                  }
            }

            int min =  total;

            for(int sumA = 0 ;sumA<=total/2 ;sumA++){
                  if(dp[sumA]){
                        int sumB = total - sumA;
                        int diff = Math.abs(sumA - sumB);

                        if(diff <min ){
                              min = diff;
                        }
                  }

            }

            return min;
      }
     
}

public class no7_minTwoset {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int[] arr = new int[n];
          input_arr(arr, n);
          
          minTwoset mt = new minTwoset(arr);
          int result =  mt.findMin();
           System.out.println(result);
          sc.close();
      }
      
      public static void input_arr(int[] a, int n) {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < n; i++) {
                  a[i] = sc.nextInt();
            }
            sc.close();
      }
}