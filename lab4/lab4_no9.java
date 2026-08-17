
import java.util.Scanner;

public class lab4_no9 {
      public static void main(String[] args) {
          Scanner sc =  new Scanner(System.in);
          int r = sc.nextInt();
          int c = sc.nextInt();
          int[][] values = new int[r][c];

          input_arr2D(values, r, c,sc);

          if(isConsecutive(values)){
            System.out.println(1);
          }else{
            System.out.println(0);
          }
          sc.close();
      }

      public static boolean  isConsecutive(int[][] values){
            int row  = values.length;
            int col = values[0].length;

            for(int i=0;i<row;i++){
                  for(int j=0;j<col;j++){
                        int value = values[i][j];


                        // แนวนอน
                        if(j+3 < col){
                              if(values[i][j+1] == value && values[i][j+2] == value && values[i][j+3] == value ){
                                 return true;   
                              }
                        }


                        //แนวตั้ง
                        if(i+3 < row){
                              if (values[i+1][j] == value && values[i+2][j] == value && values[i + 3][j] == value) {
                                    return true;
                              }

                        }


                        //แนวทแยงลงขวา
                        if(i+3 <row && j+3 <col){
                              if (values[i + 1][j+ 1] == value && values[i + 2][j + 2] == value && values[i + 3][j+ 3] == value) {
                                    return true;
                              }
                        }
                        
                        
                        //แนวทแยงลงซ้าย
                        if(i+3 <row && j-3 >= 0){
                              if (values[i + 1][j- 1] == value && values[i + 2][j - 2] == value && values[i + 3][j- 3] == value) {
                                    return true;
                              }
                        }
                  }
            }

            return false;
      }

      public static void input_arr2D(int[][] a,int r, int c,Scanner sc){
            for(int i =0 ;i<r;i++){
                  for(int j =0 ;j<c;j++){
                        a[i][j] = sc.nextInt();

                  }
            }
            
      }
}
