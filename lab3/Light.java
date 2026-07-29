import  java.util.*;
public class Light {
      public static void main(String[] args) {
          try(Scanner sc = new Scanner(System.in)){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] start = new int[N];
            int[] end = new int[N];

            for(int i=0 ;i<N;i++){
                  int p1 = sc.nextInt();
                  int p2 = sc.nextInt();

                  start[i] = Math.min(p1,p2);
                  end[i] = Math.max(p1,p2);
            }

            int total_hit=0;
            for(int i=0;i<M;i++){
                  int ligh = sc.nextInt();
                  total_hit+=Hit(start, end, ligh);
            }

            System.out.println(total_hit);
          }
      }

      public static int Hit(int[] start ,int[] end,int lightX){
            int hit = 0;
            for(int i = 0;i<start.length;i++){
                  if(lightX > start[i] && lightX <end[i]){
                        hit++;
                  }
            }
            return hit;
      }      
}
