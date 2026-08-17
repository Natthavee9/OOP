
import java.util.Scanner;

public class lab4_no10 {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int m = sc.nextInt();
          int lane = sc.nextInt();
          int t = sc.nextInt();
          int[][] arr = new int[t][m];

          input_arr2D(arr, t, m, sc);

          check(arr, t, m, lane);
      }

      public static void input_arr2D(int[][] arr ,int r ,int c,Scanner sc){
            for(int i=0 ;i<r;i++){
                  for(int j =0 ;j<c;j++){
                        arr[i][j] = sc.nextInt();
                  }
            }
      }

      public static void check(int[][] arr,int t,int m,int lane){
            int[] resultPath = new int[t];
            findSafePath(arr, t, m, lane - 1, 0, resultPath);
            
      }

      public static boolean findSafePath(int[][] arr, int t, int m, int current, int time, int[] path) {
            
            if (time == t) {
                  for (int i = 0; i < t; i++) {
                        System.out.println(path[i]);
                  }
                  return true;
            }

            //chenge to left
            if (current - 1 >= 0 && arr[time][current - 1] == 0) {
                  path[time] = 1;
                  if (findSafePath(arr, t, m, current - 1, time + 1, path))
                        return true;
            }

            //chang to right 
            if (current + 1 < m && arr[time][current + 1] == 0) {
                  path[time] = 2;
                  if (findSafePath(arr, t, m, current + 1, time + 1, path))
                        return true;
            }

            
            if (arr[time][current] == 0) {
                  path[time] = 3;
                  if (findSafePath(arr, t, m, current, time + 1, path))
                        return true;
            }

            
            return false;
      } 
}
