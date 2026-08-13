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



/*
5 9 2 9 1 2 8 9 1 6
9 1 3 9 8 4 2 1 5 7
2 7 9 3 8 5 2 7 6 8
1 6 2 1 7 7 1 9 4 1
8 5 2 3 9 8 5 6 3 3
 */