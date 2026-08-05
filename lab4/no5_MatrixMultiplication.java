import java.util.Scanner;
class MatrixMultiplication{
      public void multiMatrix(int[][] A,int[][] B){
            int M,N,L;
            N = A.length;
            M = A[0].length;
            L = A[0].length;
            
            int [][] C = new int[N][M];
            for(int i=0;i<N;i++){
                  for(int j=0;j<M;j++){
                        for(int k=0 ;k<L;k++){
                              C[i][j]+=A[i][k]*B[k][j];
                        }
                  }
            }

            printArray(C);
      }
      
      public void printArray(int[][]C){
            for(int i = 0 ;i<C.length;i++){
                  for(int j = 0;j<C[0].length;j++){
                        System.out.print(C[i][j]);
                  }
                  System.out.println();
            }

      }
}
public class no5_MatrixMultiplication{
      public static void main(String args []){
            try(Scanner sc = new Scanner(System.in)){
                  MatrixMultiplication mt = new MatrixMultiplication();
                  int N = sc.nextInt();
                  int L = sc.nextInt();

            }

      }

}