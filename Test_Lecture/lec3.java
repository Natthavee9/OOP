
import java.util.Scanner;

public class lec3 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            A a = new A();
            a.g(); // static -> non-static
            A.h(); // static -> static
            

            System.out.println(""+a.toString());



      }

}


// non-static ใช้ได้เมื่อ ต้องการใช้ เฉพาะ method
// static ใช้เมื่อต้องการให้ทุก method เห็น
class A {
      int x;
      static int y;  // static variable  , class variable ทุก obj มองเห็นได้ 

      //method overiding
      @Override
      public String toString(){
            return "Inside obj a.x : " + this.x;
      }





      void f() { // non-static method
            //x = 10;
            y = 100;

      }

      void g() { // if non-static == non-static you can aready call
            f();
            h(); // non-static can call static
      }

      static void h() {
            // x = 20; // ใช้ไม่ได้ เพราะ ยังไม่มี วัตถุเกิด ต้อง new obj ขึ้นมาก่อน

            
            A a = new A();
            a.f();
            a.x = 20;
      } // static method , static can not call non-static because must create obj

      static void p() {
            h();
      }// if static == static you can aready call

}
