import java.util.*;
class CityServiceArea {
      private ArrayList<ArrayList<Integer>> grid;
      private int r;
      private int c;

      
      public CityServiceArea(int r, int c, ArrayList<ArrayList<Integer>> grid) {
            this.r = r;
            this.c = c;
            this.grid = grid;
      }

      
      public int findMaxPopulation(int K) {
            int maxPopulation = 0;

            for (int i = 0; i <= r - K; i++) {
                  for (int j = 0; j <= c - K; j++) {

                        int currentSum = 0;
                        for (int rr = i; rr < i + K; rr++) {
                              for (int cc = j; cc < j + K; cc++) {
                                    currentSum += grid.get(rr).get(cc);
                              }
                        }

                        if (currentSum > maxPopulation) {
                              maxPopulation = currentSum;
                        }
                  }
            }
            return maxPopulation;
      }
}

public class no4 {
      public static void main(String[] args) {
          Scanner sc =  new Scanner(System.in);
          ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
          int M = sc.nextInt();
          int N = sc.nextInt();
          int K = sc.nextInt();

          input_ArrayList(grid, M, N, sc);

          CityServiceArea cta = new CityServiceArea(M, N, grid);
          int result = cta.findMaxPopulation(K);
          System.out.println(result);

          sc.close();

      }

      public static void input_ArrayList(ArrayList<ArrayList<Integer>> a,int r,int c,Scanner sc){
            for (int i = 0; i < r; i++) {
                  ArrayList<Integer> rowList = new ArrayList<>();
                  for (int j = 0; j < c; j++) {
                        int n = sc.nextInt();
                        rowList.add(n);
                  }
                  a.add(rowList);
            }
      }
      
}
