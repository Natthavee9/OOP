import java.util.Scanner;
public class CheckTriangle {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double x0 = sc.nextDouble();
            double y0 = sc.nextDouble();
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();

            if (OnTheSameLine(x0, y0, x1, y1, x2, y2)) {
                  System.out.println(0);

            }else if(leftOfTheLine(x0, y0, x1, y1, x2, y2)){
                  System.out.println(1);
            }else{
                  System.out.println(2);
            }
            sc.close();
      }

      public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
            return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) > 0;
      }

      public static boolean OnTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {
            return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) == 0;
      }

      public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {
            if (!OnTheSameLine(x0, y0, x1, y1, x2, y2)) {
                  return false;
            }

            boolean isXBetween = Math.min(x0, x1) <= x2 && x2 <= Math.max(x0, x1);
            boolean isYBetween = Math.min(y0, y1) <= y2 && y2 <= Math.max(y0, y1);

            return isXBetween && isYBetween;
      }
}
