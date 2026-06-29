import java.util.Scanner;
public class No6 {
      public static void main(String[] args) {
            try(Scanner sc = new Scanner(System.in)){
                  System.out.print("Please input number of columns and rows: ");
                  int row = sc.nextInt();
                  int col = sc.nextInt();

                  System.out.print("     ");
                  for (int i = 2; i <= col; i++) {
                        System.out.printf("%5d", i);
                  }
                  System.out.println();

                  for (int i = 2; i <= row; i++) {
                        System.out.printf("%5d", i);

                        for (int j = 2; j <= col; j++) {
                              System.out.printf("%5d", i * j);
                        }
                        System.out.println();
                  }
            }  
      }
}
