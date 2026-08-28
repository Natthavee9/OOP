
class Employee {
  protected int id;
  protected String name;
  protected double salary;
  protected Address address;

  public int getId() {
    return id;
  }

  public int setId(int id) {
    return this.id = id;
  }

  public String getName() {
    return name;
  }

  public String setName(String name) {
    return this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public Address setAddress(Address address) {
    return this.address = address;
  }

  public double getSalary() {
    return salary;
  }

  public double setSalary(double salary) {
    return this.salary = salary;
  }

  public String getDetail() {
    return "ID: " + getId() + "\nName: " + getName();

  }
}

class Manager extends Employee {
  String parkingNO;

  public String getParkingNo() {
    return parkingNO;
  }

  public void setParkingNO(String parkingNO) {
    this.parkingNO = parkingNO;
  }

  @Override
  public String getDetail() {
    return super.getDetail()+"\nParking no: " + getParkingNo();
  }

}

class Address {
  String street;
  String city;

  public void setStreet(String street) {
    this.street = street;
  }

  public String getStreet() {
    return street;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCity() {
    return city;
  }

  public String getDressinfo() {
    return "City: " + getCity() + "\nStreet: " + getStreet();
  }
}

public class lab7_no5 {
  public static void main(String[] args) {
    Address add = new Address();
    add.setStreet("samsen road");
    add.setCity("USA");

    Employee emp = new Manager();

    emp.setSalary(10000);
    emp.setId(11);
    emp.setName("Natthavee");
    emp.setAddress(add);

    if(emp instanceof Manager){
      ((Manager)emp).setParkingNO("A1");
    }

    System.out.println("Detail");
    System.out.println(emp.getDetail());

  }
}