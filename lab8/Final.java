import java.util.*;
import javax.swing.*;
abstract class Employee {
      private final String firstname;
      private final String lastname;
      private final String id;

      public Employee(String firstname, String lastname, String id) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.id = id;
      }

      public String getFirstname() {
            return firstname;
      }

      public String getLastname() {
            return lastname;
      }

      public String getId() {
            return id;
      }

      public abstract double earning();

      public abstract double bonus(int year);
}

class SalariedEmployee extends Employee {
      private final double salary;

      public SalariedEmployee(String firstname, String lastname, String id, double sal) {
            super(firstname, lastname, id);
            this.salary = sal;
      }

      @Override
      public double bonus(int year) {
            if (year > 5) {
                  return salary * 12;
            } else {
                  return salary * 6;
            }
      }

      @Override
      public double earning() {
            return salary - (salary * 0.05);
      }
}

class ComEmployee extends Employee {
      private final double grossSale;
      private final double ComRate;

      public ComEmployee(String firstname, String lastname, String id, double sales, double percent) {
            super(firstname, lastname, id);
            this.grossSale = sales;
            this.ComRate = percent;
      }

      @Override
      public double bonus(int year) {
            if (year > 5) {
                  return grossSale * 6;
            } else {
                  return grossSale * 3;
            }
      }

      @Override
      public double earning() {
            double Comission = grossSale * ComRate;
            return grossSale + Comission;
      }
}

class Final { 
      public static void printEmp(ArrayList<Employee> a) {
            ArrayList<Employee> e = new ArrayList<Employee>();
            ArrayList<Double> earn = new ArrayList<Double>();
            ArrayList<Double> bo = new ArrayList<Double>();

            for(int i = 0;i<a.size();i++){
                  Employee emp = a.get(i);
                  double earning = emp.earning();
                  double bonus = emp.bonus(5+i);
                  e.add(emp);
                  earn.add(earning);
                  bo.add(bonus);
            }
            String output = "";
            for (int i = 0; i < a.size(); i++) {
                  Employee eget = a.get(i);

                  output+= eget.getFirstname() + " " + eget.getLastname() + " " + earn.get(i) + " " + bo.get(i)+"\n";

                  
              }
              JOptionPane.showMessageDialog(null,output);
             

                 
      }

      public static void main(String[] args) {
            ArrayList<Employee> em = new ArrayList<Employee>();
            em.add(new SalariedEmployee("A", "AAA", "01", 30000));
            em.add(new SalariedEmployee("C", "CCC", "02", 15000));
            em.add(new ComEmployee("B", "BBBB", "08", 50000, 0.20));
            em.add(new ComEmployee("D", "DDDD", "12", 50000, 0.60));
            printEmp(em);
      }
}

