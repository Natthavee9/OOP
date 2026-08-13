import java.util.*;
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

      //get set
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

      //main method
      public double deposit(double money){
            return balance+=money;
      }

      public double withdraw(double money){
            return balance-=money;
      }

      public double getMontlyInterestRate(){
            return (annualInterestRate/100) /12;
      }
      public double getMontlyInterest(){
            return balance*getMontlyInterestRate();
      }

}

public class lab6_no5 {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Account acc = new Account(1122,20000);
            acc.setAnnualInterestRate(4.5);

            acc.withdraw(2500);
            acc.deposit(3000);

            System.out.println("Balance: " +acc.getBalance());
            System.out.println("Mothly interest Rate: " +acc.getMontlyInterest());

            sc.close();

      }
}