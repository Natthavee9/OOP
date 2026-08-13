class Account {
      private int id;
      private double balance;
      private double annualInterestRate;
      private Date dateCreated;
      public Account() {
            this.id = 0;
            this.balance = 0.0;
            this.annualInterestRate = 0.0;
            this.dateCreated = new Date();
      }

      public Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
      }

      // get set
      public int getId() {
            return id;
      }

      public double getBalance() {
            return balance;
      }

      public double getAnnualInterestRate() {
            return annualInterestRate;
      }

      public Date getDateCreated() {
            return dateCreated;
      }

      public void setId(int id) {
            this.id = id;
      }

      public void setBalance(double balance) {
            this.balance = balance;
      }

      public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
      }

      public void setDateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
      }

      // main method
      public double deposit(double money) {
            return balance += money;
      }

      public double withdraw(double money) {
            return balance -= money;
      }

      public double getMontlyInterestRate() {
            return (annualInterestRate / 100) / 12;
      }

      public double getMontlyInterest() {
            return balance * getMontlyInterestRate();
      }

}

class Date{
      private int day;
      private String month;
      private int year;


      public Date() {
      }


      public Date(int day, String month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
      }


      public int getYear() {
            return year;
      }

      public String toString(){
            return day+" "+ month +" "+ year;
      }
}

class Person{
      private String name;
      private String surname;
      private int age;
      private String year;
      private Date bDate;
      
      public Person(){

      }
      public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
      }
      
      public int getAge() {
            return age;
      }


      public void setAge(int age){
            this.age = age;
      }
      
      public String toString(){
            return "name: " +name+" surname: "+surname+" age: "+ age; 
      }
     
}

class SavingAccount extends Account{

      public SavingAccount(int id, double balance) {
            super(id, balance);
      }
      

}

class FixAccount extends  Account{

      public FixAccount(int id, double balance) {
            super(id, balance);
      }

}
public class lab6_no6 {
      
}
