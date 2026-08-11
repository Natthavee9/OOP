import java.util.*;
public class no8_FindPokemon {
      public static void main(String args[]){
            Scanner sc =  new Scanner(System.in);
            int H = sc.nextInt();
            int W = sc.nextInt();
            int[][] A = new int[H][W];

            for(int i=0;i<A.length;i++){
                  for(int j= 0;j<A[0].length;j++){
                        A[i][j] = sc.nextInt();
                  }
            }
      }
      
      
}
