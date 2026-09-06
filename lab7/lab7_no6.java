import java.util.*;
class Posi {
    int row;
    int col;

    public Posi(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class MazeSol {
    private  int row;
    private int col;
    private int[][] map;

    //way we can  up,down,left,righ
    private int[]dR =  {-1,1,0,0}; 
    private int[] dC =  {0,0,-1,1};
    public MazeSol(int row, int col, int[][] map) {
        this.row = row;
        this.col = col;
        this.map = map;
    } 

    //method help check is way in boudaries and check point ?
    public boolean isWalkable(int r,int c){
        return r >= 0 && r<row && c >=0 && c <col && map[r][c] ==1; 
    }

    
    // find the distance from any point to every space that can be moved. 
    public int[][] CalDistance(Posi po_start){
        int[][] distan =  new int[row][col];
        Queue<Posi> q = new LinkedList<>();

        q.add(po_start);
        distan[po_start.row][po_start.col] = 1;

        while(!q.isEmpty()){
            Posi current =  q.poll();

            for(int i=0;i<4;i++){
                int nextR =  current.row + dR[i];
                int nextC = current.col + dC[i];

                if(isWalkable(nextR, nextC) && distan[nextR][nextC] == 0){
                    distan[nextR][nextC] = distan[current.row][current.col] +1;
                    q.add(new Posi(nextR, nextC));
                }

            }
        }
        return  distan;
    }

    //find  number of wall that can bom and find a short path 
    public void sol(Posi start ,Posi end){
        int[][] distanStart = CalDistance(start);
        int[][] distanEnd = CalDistance(end);

        int posibleWall = 0;
        int minDistace = -1;

        //loop find wall=0 
        for(int r=0;r<row;r++){
            for(int c =0;c<col;c++){
                if(map[r][c] == 0){
                    int minFromStart = -1;
                    int minFromEnd = -1;
                    for (int i = 0; i < 4; i++) {
                        int adjR = r + dR[i];
                        int adjC = c + dC[i];

                        if (isWalkable(adjR, adjC)) {
                            if (distanStart[adjR][adjC] > 0) {
                                minFromStart = Math.min(minFromStart, distanStart[adjR][adjC]);
                            }
                            if (distanEnd[adjR][adjC] > 0) {
                                minFromEnd = Math.min(minFromEnd, distanEnd[adjR][adjC]);

                            }
                        }
                    }
                    // Look at the walkways around the four walls.
                    if (minFromStart != -1 && minFromEnd != -1) {
                        posibleWall++;
                        int totalDistan =   minFromStart+minFromEnd+1;//+1 for count wall
                        minDistace =  Math.min(totalDistan, minDistace);

                    }
                } 
            }
        }
        System.out.println(posibleWall);
        System.out.println(minDistace);
    }

    

    
}

public class lab7_no6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        
        int startRow = sc.nextInt();
        int startCol = sc.nextInt();
        int endRow = sc.nextInt(); // เพิ่มบรรทัดนี้
        int endCol = sc.nextInt();

        Posi start = new Posi(startRow -1 , startCol-1);
        Posi end = new Posi(endRow -1 , endCol-1);
        int[][] map = getInputMap(M, N);
        MazeSol m_Sol = new MazeSol(M, N, map);
        m_Sol.sol(start, end);

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
