import java.util.Scanner;

class Subway {
    private int[][] lines;
    private int[][] StationToLines;
    private int total_line;
    private int[] lineCount; // line count pass

    public Subway(int n, int m) {
        this.total_line = m;
        this.lines = new int[m + 1][];

        this.StationToLines = new int[n + 1][20];
        this.lineCount = new int[n + 1];

    }

    public void addLine(int lineID, int[] stations) {
        lines[lineID] = stations;
        for (int i = 0; i < stations.length; i++) {
            int station = stations[i];

            // store line number in station
            int current_idx = lineCount[station];
            StationToLines[station][current_idx] = lineID;

            // +1 for next time move to the next slot
            lineCount[station]++;
        }
    }

    public int findMinTransfer(int start, int end) {
        if (start == end) {
            return 0;
        }

        int[] q = new int[total_line + 1];
        int head = 0, tail = 0;

        int[] transfers = new int[total_line + 1];
        for (int i = 0; i <= total_line; i++) {
            transfers[i] = -1;
        }

        // Number of trains passing through the start station from lineCounts
        for (int i = 0; i < lineCount[start]; i++) {
            int line = StationToLines[start][i]; //
            q[tail++] = line;
            transfers[line] = 0;
        }

        while (head < tail) {
            int currentLine = q[head++];

            for (int i = 0; i < lines[currentLine].length; i++) {
                int station = lines[currentLine][i];
                if (station == end) {
                    return transfers[currentLine];
                }

                // Number of trains passing through the "current station"
                for (int j = 0; j < lineCount[station]; j++) {
                    int nextLine = StationToLines[station][j];
                    if (transfers[nextLine] == -1) {
                        q[tail++] = nextLine;
                        transfers[nextLine] = transfers[currentLine] + 1;
                    }
                }

            }

        }
        return -1;
    }
}

public class lab8_no7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Subway subway = new Subway(n, m);

        for (int i = 1; i <= m; i++) {
            int s = sc.nextInt();
            int[] station = new int[s];
            for (int j = 0; j < s; j++) {
                station[j] = sc.nextInt();
            }
            subway.addLine(i, station);
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            int ans = subway.findMinTransfer(start, end);

            if (ans == -1) {
                System.out.println("impossible");
            } else {
                System.out.println(ans);
            }
        }

    }
}