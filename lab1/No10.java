import java.util.Scanner;

public class No10 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
                  double xc = sc.nextDouble();
                  double yc = sc.nextDouble();
                  double r = sc.nextDouble();
                  double v = sc.nextDouble();
                  
                  int n = sc.nextInt();

                  double[] Hx = new double[n];
                  double[] Hy = new double[n];
                  boolean[] affect = new boolean[n];

                  int count = 0;
                  
                  for(int i =0 ;i<n;i++){
                        Hx[i] = sc.nextDouble();
                        Hy[i] = sc.nextDouble();
                        affect[i] = false;
                  }

                  // The storm speed is greater than 1 km/h.
                  while(v>=1){
                        
                        //check home
                        for(int i=0;i<n;i++){

                              //// Inspect only houses that have not affected.
                              if(!affect[i]){
                                    double distance = Math.sqrt(Math.pow(Hx[i]-xc,2)) + Math.sqrt(Math.pow(Hy[i]-yc,2)); 
 
                                    if (distance <= r) {
                                          affect[i]=true;
                                          count++;
                                    }
                              }
                        }
                        // The storm is moving westward (X coordinate decreasing) a distance equal to speed v.
                        xc = xc - (v*100);
                        v = v*0.8;
                        r = r*0.8;
                  }
                  System.out.println(count);
            sc.close();
      }     
}