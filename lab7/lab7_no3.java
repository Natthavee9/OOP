class Fruit{}

class Apple extends Fruit{
      public void makeApple(){
            System.out.println("call makeApple");
      }
      
}

class Orange extends Fruit{
      public void makeOrangeJuice(){
            System.out.println("call makeOrangeJuice");
      }
}

class GlodenDelicious extends Apple{}

class Mcintosh extends Apple{}
public class lab7_no3 {
      public static void main(String[] args) {
          Fruit fruit = new GlodenDelicious();
          Orange orange = new Orange();

          System.out.println("1. Is fruit instanceof Orange?: " + (fruit instanceof Orange));
          System.out.println("2. Is fruit instanceof Apple?: " + (fruit instanceof Apple));
          System.out.println("3. Is fruit instanceof GoldenDelicious?: " + (fruit instanceof GlodenDelicious));
          System.out.println("4. Is fruit instanceof Macintosh?: " + (fruit instanceof Mcintosh));
          System.out.println("5. Is orange instanceof Orange?: " + (orange instanceof Orange));
          System.out.println("6. Is orange instanceof Fruit?: " + (orange instanceof Fruit));
          //System.out.println("7. Is orange instanceof Apple?: " + (orange instanceof Apple));
          
          if(fruit instanceof Apple){
            ((Apple)fruit).makeApple(); // ได้
          } 
          
          /*if(orange instanceof Apple){
            ((Apple)orange).makeApple();
          }*/

          if(orange instanceof Orange){
            ((Orange)orange).makeOrangeJuice(); // ได้
          } 
          
          if(fruit instanceof Orange){
            ((Orange)fruit).makeOrangeJuice(); 
          }



          
          
      }
      
}
