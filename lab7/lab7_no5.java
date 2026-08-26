import java.util.*;

class Employee{
      protected int id;
      protected String name;
      protected double salary;
      protected Address address;

    public int getId() {
        return id;
    }
    public int setId(int id){
      return this.id = id;
    }
    
    public String getName(){
      return name;
    }
    public String setName(String name){
      return this.name = name;
    }


    public Address getAddress(){
      return address;
    }
    public Address setAddress(Address address){
      return this.address = address;
    }

    public double getSalary(){
      return salary;
    }

    public double setSalary(double salary){
      return this.salary = salary;
    }


      
}

class Address{

}
public class lab7_no5{
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
      }
}