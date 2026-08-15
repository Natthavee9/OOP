
import java.util.ArrayList;


class Employee{
      private String firstname;
      private String lastname;
      private String id;
      private  double salary;

      public Employee(String firstname,String lastname,String id, double sal){
            this.firstname = firstname;
            this.lastname =lastname;
            this.id = id;
            this.salary = sal;
      }

      public double earning(){
            double tax = salary *0.05;
            double total_salary = this.salary - tax;
            return total_salary;
      }

      public double bonus(int year){
            if(year>5){
                  return this.salary*12;

            }
            else{
                  return this.salary * 6;  
            }
      }

      public String getFirstname() {return firstname;}

      public String getLastname() {return lastname;}
      


      public static void  printEmp(ArrayList<Employee> a){
            
            for(Employee emp:a){
                  int year = 7;
                  System.out.println(emp.getFirstname()+" "+emp.getLastname()+" "+
                                    emp.earning()+" "+emp.bonus(year));

            }
      }

}
      

public class no5{
      public static void main(String[] args) {

            ArrayList<Employee> emp = new ArrayList<>();

            emp.add(new Employee("A", "B", "0001", 10000));
            emp.add(new Employee("C", "D", "0002", 100000));
            emp.add(new Employee("E", "F", "0003", 25000));
            emp.add(new Employee("G", "H", "0004", 10000));

            Employee.printEmp(emp);
      }
}






