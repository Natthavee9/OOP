import java.util.Scanner;

public class lab4_no11 {
      static int m, n;
      static char[][] grid;
      static boolean[][] visited;

      static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
      static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextInt()) {
                  m = sc.nextInt();
                  if (m == 0)
                        break;
                  n = sc.nextInt();

                  grid = new char[m][n];
                  visited = new boolean[m][n];

                  for (int i = 0; i < m; i++) {
                        String line = sc.next();
                        grid[i] = line.toCharArray();
                  }

                  int count = 0;
                  for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                              if (grid[i][j] == '@' && !visited[i][j]) {
                                    dfs(i, j);
                                    count++;
                              }
                        }
                  }
                  System.out.println(count);
            }
            sc.close();
      }

      public static void dfs(int r, int c) {
            visited[r][c] = true;
            for (int i = 0; i < 8; i++) {
                  int nr = r + dr[i];
                  int nc = c + dc[i];
                  if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == '@' && !visited[nr][nc]) {
                              dfs(nr, nc);
                        }
                  }
            }
      }
}