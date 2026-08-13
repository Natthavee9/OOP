import java.util.Scanner;
class Account {
      protected int id;
      protected double balance;
      protected double annualInterestRate;
      protected Date dateCreated;
      protected Person objPerson;

      public Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
      }

      public Account(double annualInterestRate, double balance, Date dateCreated, int id, Person objPerson) {
            this.annualInterestRate = annualInterestRate;
            this.balance = balance;
            this.dateCreated = dateCreated;
            this.id = id;
            this.objPerson = objPerson;
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

      public double getMontlyInterest(int current_year) {

            int year_pass = current_year - dateCreated.getYear();
            int month_pass;
            if (year_pass > 0) {
                  month_pass = year_pass * 12;

            } else {
                  month_pass = 1;
            }

            return balance * getMontlyInterestRate() * month_pass;
      }

      public void transferMoney(Account acc, double money) {
            if (balance >= money) {
                  balance -= money;
                  acc.deposit(money);
                  System.out.println("Success");
            }
      }

    public void setObjPerson(Person objPerson) {
        this.objPerson = objPerson;
    }
}

class Date {
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

      @Override
      public String toString() {
            return day + " " + month + " " + year;
      }
}

class Person {
      private String name;
      private String surname;
      private int age;
      private String year;
      private Date bDate;

      public Person() {

      }

    public Person(String name, String surname,int age, Date bDate ) {
      this.name = name;
        this.surname = surname;  
      this.age = age;
        this.bDate = bDate;
        
    }

      public int getAge() {
            return age;
      }

      public void setAge(int age) {
            this.age = age;
      }

      @Override
      public String toString() {
            return "name: " + name + " surname: " + surname + " age: " + age;
      }

}

class SavingAccount extends Account {

      public SavingAccount(int id, double balance) {
            super(id, balance);
      }

      @Override
      public void transferMoney(Account acc, double money) {
            double total_transfer = money + 20;
            if (balance >= total_transfer) {
                  
                  this.withdraw(total_transfer);
                  acc.deposit(money);
                  System.out.println("Success");
            }
      }
}

class FixAccount extends Account {

      public FixAccount(int id, double balance) {
            super(id, balance);
      }

      public void withdraw(double monney, int current_year) {
            if (current_year - dateCreated.getYear() >= 1) {
                  super.withdraw(monney);
            }
      }

      @Override
      public void transferMoney(Account acc, double money) {
            System.out.println("Cannot transfer");
      }
}

public class lab6_no6 {

      // 6.1
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int current_year = 2026;
            Account target = new Account(1100, 0);
            Person p1 = new Person("A", "B", 20, new Date(1, "june", 2005));
            Person p2 = new Person("B", "C", 30, new Date(15, "june", 2000));

            SavingAccount s1 = new SavingAccount(1123, 20000);
            s1.setAnnualInterestRate(4.5);
            s1.setDateCreated(new Date(1, "june", 2026));
            s1.setObjPerson(p1);

            s1.withdraw(2500);
            s1.deposit(3000);
            s1.transferMoney(target, 1000);

            System.out.println("6.1 Balance: " + s1.getBalance());
            System.out.println("6.1 Monthly Interest: " + s1.getMontlyInterest(current_year));


            System.out.println();
            FixAccount f = new FixAccount(1124, 20000);
            f.setAnnualInterestRate(7.0);
            f.setDateCreated(new Date(1, "june", 2028));
            f.setObjPerson(p2);
            

            f.withdraw(2500,current_year);
            f.deposit(3000);
            f.transferMoney(target, 1000);

            
            System.out.println("6.2 Balance: " + f.getBalance());
            System.out.println("6.2 Monthly Interest: " + f.getMontlyInterest(current_year));
            sc.close();
      }

}
