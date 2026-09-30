import java.util.*;
class Power{
      private  ArrayList<Integer> arr = new ArrayList<Integer>();
      private int size;

      public Power(int size){
            this.size = size;
      }

      public void setArr(ArrayList<Integer> arr){
            this.arr = arr;
      }

      public int getpower(){
            ArrayList<Integer> temp = (ArrayList<Integer>) arr.clone();
            int sum = 0;
            int a = 0;
            int b = 0;
            int max;
            while(temp.size() > 1){
                  max = 0;
                  for(int i=0;i<temp.size()-1;i++){
                        
                        if(Math.abs(temp.get(i) - temp.get(i+1)) > max){
                              a = i;
                              b = i + 1;
                              max = Math.abs(temp.get(i) - temp.get(i+1));
                        }
                        else if(Math.abs(temp.get(i) - temp.get(i+1)) == max){
                              if(temp.get(i) > temp.get(i)){
                                    a= i;
                                    b = i+1;
                                    max = Math.abs(temp.get(i) - temp.get(i+1));
                              }
                        }
                  }
                  temp.remove(a);
                  temp.remove(b-1);
                  sum+=max;
            }
            return sum;
      }
}
public class lab9_no9 {
      public static void main(String[] args) {
          ArrayList<Integer> arr = new ArrayList<Integer>();
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          Power p = new Power(n);
          for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
          }
          p.setArr(arr);
          System.out.println("answer: "+p.getpower());
      }    
}