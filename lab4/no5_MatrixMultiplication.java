import java.util.*;

class MatrixMultiplication {
      Scanner sc = new Scanner(System.in);

      public void multiMatrix(int[][] A, int[][] B) {
            int M, N, L;
            N = A.length;
            M = B[0].length;
            L = A[0].length;

            int[][] C = new int[N][M];
            for (int i = 0; i < N; i++) {
                  for (int j = 0; j < M; j++) {
                        for (int k = 0; k < L; k++) {
                              C[i][j] += A[i][k] * B[k][j];
                        }
                  }
            }

            printArray(C);
      }

      public void printArray(int[][] C) {
            for (int i = 0; i < C.length; i++) {
                  for (int j = 0; j < C[0].length; j++) {
                        System.out.print(C[i][j] + " ");
                  }
                  System.out.println();
            }

      }

      public void input_array(int[][] a, int n, int l) {
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < l; j++) {
                        a[i][j] = sc.nextInt();
                  }
            }
      }
}

public class no5_MatrixMultiplication {
      public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            MatrixMultiplication mt = new MatrixMultiplication();

            int Na = sc.nextInt();
            int La = sc.nextInt();
            int[][] a = new int[Na][La];

            mt.input_array(a, Na, La);

            int Nb = sc.nextInt();
            int Lb = sc.nextInt();
            int[][] b = new int[Nb][Lb];

            mt.input_array(b, Nb, Lb);
            
            System.out.println();
            mt.multiMatrix(a, b);
            sc.close();
      }
}

