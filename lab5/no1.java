import  java.util.*;

public class no1{
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Integer> list = new ArrayList<Integer>(); 

            while(sc.hasNextInt()){
                  list.add(sc.nextInt());
            }

            double sum = sum(list);
            double avg = sum / list.size();
            int max = max(list);
            int  min = min(list);

            System.out.println(String.format("%.2f",avg));
            System.out.println(max);
            System.out.println(min);
            
            list.removeIf(n -> n%2 == 0);
            
            for(int i:list){
                  System.out.print(i+" ");
                  
            } 
            
            System.out.println();

      }

      public static int  max(ArrayList<Integer> a){
            int max = a.get(0);
            
            for(int i  :a){
                  if (a.get(i) > max){
                        max = i; 
                  }

                  
            }

            return max;
      }
      public static int  min(ArrayList<Integer> a){
            int min = a.get(0);
            
            for(int i  :a){
                  if (i < min){
                        min = i; 
                  }   
            }
            return min;
      }

      public static int sum(ArrayList<Integer> a){
            int s = 0;
            for(int i:a){
                  s+=i;
            }
            return s;
      }
}