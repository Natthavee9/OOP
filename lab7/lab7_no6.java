import java.util.*;

class Positon {
    int row;
    int col;

    public Positon(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class MazeSol {
    int m;
    int n;

    
}

public class lab7_no6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] map = getInputMap(M, N);

        sc.close();
    }

    public static int[][] getInputMap(int m, int n) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        return a;
    }
}
