import java.util.*;

class Pokemon {
      Scanner sc = new Scanner(System.in);
      int H;
      int W;
      int[][] A = new int[H][W];

      Pokemon(int[][] A, int H, int W) {
            this.A = A;
            this.H = H;
            this.W = W;
      }

      public int[] FindePokemon() {
            int ansRow = -1;
            int ansCol = -1;
            int maxSum = -1;

            for (int i = 0; i < H; i++) {
                  for (int j = 0; j < W-1; j++) {
                        int diff = Math.abs(A[i][j] - A[i][j + 1]);

                        if (diff <= 10) {
                              int sum = A[i][j] + A[i][j + 1];
                              if (sum > maxSum) {
                                    maxSum = sum;
                                    ansRow = i;
                                    ansCol = j;
                              }
                        }
                  }
            }
            //

            // col
            for (int i = 0; i < H-1; i++) {
                  for (int j = 0; j < W; j++) {
                        int diff = Math.abs(A[i][j] - A[i + 1][j]);

                        if (diff <= 10) {
                              int sum = A[i][j] + A[i + 1][j];
                              if (sum > maxSum) {
                                    maxSum = sum;
                                    ansRow = i;
                                    ansCol = j;
                              }
                        }
                  }
            }

            if (maxSum != -1) {
                  int[] found = { ansRow + 1, ansCol + 1 };
                  return found;
            } else {
                  int[] notFound = { -1, -1 };
                  return notFound;
            }

      }

      public static void input_arr2D(int[][] A) {

      }

}

public class no8_FindPokemon {
      public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int H = sc.nextInt();
            int W = sc.nextInt();
            int[][] A = new int[H][W];
            for (int i = 0; i < H; i++) {
                  for (int j = 0; j < W; j++) {
                        A[i][j] = sc.nextInt();
                  }
            }

            Pokemon pk = new Pokemon(A,H,W);
            int[] answer = pk.FindePokemon();
            System.out.println(answer[0] + " " + answer[1]);

            sc.close();
      }
}