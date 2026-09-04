class Human{
      void walk(){}
      void sleep() {
      }
      void eat() {
      }
      void run() {
      }
      void fly() {
      }

}

class Spiderman extends Human implements Flyable,Fightable{
      @Override
      public void fly(){
            System.out.println("fly from spiderman");

      }

      @Override
      public void figth(){
            System.out.println("fight from spiderman");
      }



}

interface  Flyable{
      void fly();
}

interface  Fightable{
      void figth();

}

class Bird implements Flyable{
      @Override
      public void fly(){
            System.out.println("fly from bird");
      }
}


class Plain implements Flyable,Fightable{
      @Override
      public void fly() {
            System.out.println("fly from airPlain");
      }

      @Override
      public void figth() {
            System.out.println("fight from airPlain");
      }

}
public class t_lec8 {
      public static void main(String[] args) {
          Flyable s = new Spiderman();
          //s.eat();
          s.fly();

          Flyable ap = new Plain();
          ap.fly();


          Fightable o = new Spiderman();
          o.figth();

          o = new Plain();
          o.figth();


          A1 a=new A1();
          A1 c = new A1();
          System.out.println(a.equals(c)); // equals ตรวจสอบว่าอยู่ที่เดียวกันหรือไม่
      }
      
}

class A1{
      int x = 0;

      @Override
      public boolean equals(Object o){
            return this.x == ((A1)o).x;
      }
}
