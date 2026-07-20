import java.util.Scanner;
class RoachPopulation{
      private int n;

      public RoachPopulation(int n) {
            this.n = n;
      }
      
      public void waitt(){
            this.n =  this.n*2;
      }

      public void spray(){
            int disease = this.n /10;
            this.n = this.n - disease;
      }

      public int  getRoaches(){
            return this.n;
      }
}
public class RoachPop{
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n  = sc.nextInt();
            int time  = sc.nextInt();
            RoachPopulation rp = new RoachPopulation(n);

            for(int i =0 ;i<time;i++){
                  rp.waitt();
                  rp.spray();
            }
            System.out.println(rp.getRoaches());
            sc.close();       
      }
}