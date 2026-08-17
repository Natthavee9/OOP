import java.util.*;

class ArrayChecker {

      public boolean isConsecutiveFour(ArrayList<ArrayList<Integer>> a) {
            int r = a.size();
            int c = a.get(0).size();

            // แนวนอน
            for (int i = 0; i < r; i++) {
                  for (int j = 0; j <= c - 4; j++) {
                        if (a.get(i).get(j) == a.get(i).get(j+1) && a.get(i).get(j) == a.get(i).get(j+2)&& a.get(i).get(j) == a.get(i).get(j+3)){
                              return true;
                        }     
                  }
            }
            
            // แนวตั้ง
            for (int i = 0; i <= r - 4; i++) {
                  for (int j = 0; j < c; j++) {
                        if (a.get(i).get(j) == a.get(i+1).get(j) && a.get(i).get(j) == a.get(i+2).get(j) && a.get(i).get(j) == a.get(i+3).get(j)){
                              return true;
                        }         
                  }
            }
           
            //แนวทแยงซ้ายไปขวา
            for (int i = 0; i <= r - 4; i++) {
                  for (int j = 0; j <= c - 4; j++) {
                        if (a.get(i).get(j) == a.get(i+1).get(j+1) && a.get(i).get(j) == a.get(i+2).get(j+2) && a.get(i).get(j) == a.get(i+3).get(j+3)){
                              return true;
                        }    
                  }
            }
            
            //แนวทแยงซ้ายไปขวา
            for (int i = 0; i <= r - 4; i++) {
                  for (int j = 3; j < c; j++) {
                        if (a.get(i).get(j) == a.get(i+1).get(j-1) && a.get(i).get(j) == a.get(i+2).get(j-2) && a.get(i).get(j) == a.get(i+3).get(j-3)){
                              return true;
                        }       
                  }
            }
            
            return false;
      }
}
public class no6 {
      public static void main(String[] args) {
          Scanner sc =  new Scanner(System.in);
          ArrayList<ArrayList<Integer>> values = new ArrayList<>();
          int r =  sc.nextInt();
          int c =  sc.nextInt();
          input_ArrayList(values, r, c, sc);

          ArrayChecker arc = new ArrayChecker();
          if(arc.isConsecutiveFour(values)){
            System.out.println(1);
          }
          else{
            System.out.println(0);

          }
          sc.close();
      }

      public static void input_ArrayList(ArrayList<ArrayList<Integer>> a,int r,int c,Scanner sc){
            for (int i = 0; i < r; i++) {
                  ArrayList<Integer> rowList = new ArrayList<>();
                  for (int j = 0; j < c; j++) {
                        int n = sc.nextInt();
                        rowList.add(n);
                  }
                  a.add(rowList);
            }
      }
      
}
