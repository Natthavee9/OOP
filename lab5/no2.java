import java.util.*;
class Star{
      public void addStars(ArrayList<String> str){
            for(int i = 0 ;i<str.size();i=i+2){
                  str.add(i+1,"*");
            }
      }

      public void removeStars(ArrayList<String> str){
            
            str.removeIf(s -> s.equals("*"));    
            
      }
}

public class no2 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<String> list = new ArrayList<String>();
            while (sc.hasNext()) {
                  if (sc.hasNextInt()) {
                        break;
                  }
                  list.add(sc.next());
            }

            
            Star s = new Star();

            while(sc.hasNext()){
                  int cmd =  sc.nextInt();

                  if(cmd == 1){
                        s.addStars(list);
                  }
                  else if(cmd == 2){
                        s.removeStars(list);
                  }
                  else{
                        break;
                  }

                  System.out.println(list);
            }
            sc.close();
      }  
}