import java.util.Scanner;

public class no6 {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          double[][] p = new double[n][2];
          input_arr(p, n);
          System.out.println();
          System.out.println(String.format("%.2f",cal(p)));
          sc.close();
      }

      public static void input_arr(double [][]a,int n){
            Scanner sc = new Scanner(System.in);
            for(int i = 0;i<n;i++){
                  for(int j=0;j<2;j++){
                        a[i][j] = sc.nextDouble();
                  }
            }
            sc.close();
      }

      public static double cal(double [][]p){
            double min_distance = 50;

            for(int i=0 ;i<p.length;i++){
                  for(int j=i+1 ;j<p.length;j++){
                        double dis_x = p[i][0] - p[j][0];
                        double dis_y = p[i][1] - p[j][1];

                        double distance = Math.sqrt(Math.pow(dis_x,2)+Math.pow(dis_y,2));

                        if(distance< min_distance){
                              min_distance = distance;

                        }
                  }
            }
            return min_distance;
      }
}


/*



*/