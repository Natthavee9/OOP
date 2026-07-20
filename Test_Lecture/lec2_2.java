import java.util.Scanner;
class Student{
      String name;
      String surname;
      int id;
      double gpa;
      
      public Student(){
            this.name="";
            this.surname="";
            this.id = 0;
            this.gpa=0.0;

      }
      public Student(String name, String surname,int id,double gpa){
            this.name=name;
            this.surname= surname;
            this.id = id;
            this.gpa= gpa;

      }

      public void printStudentDetail(){
            System.out.println("name: " +this.name +" surname: "+ this.surname+
                                " ID " + this.id +" GPA " +this.gpa);

      }


       
       
       
       
       
       
}
public class lec2_2 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input Number ");
            int n =sc.nextInt();
            for(int i =0 ;i<n;i++){
                  System.out.println("name: ");
                  String name = sc.next();
                  System.out.println("surname: ");
                  String surname = sc.next();
                  System.out.println("ID: ");
                  int id = sc.nextInt();
                  System.out.println("GPA: ");
                  double gpa = sc.nextDouble();
                  Student s = new Student(name,surname,id,gpa);
                  s.printStudentDetail();

            }

            sc.close();
          
      }
      
}
