import java.util.Date;
class Account{
      private int id;
      private double balance;
      private  double  annual;
      private Date dateCreate;

    Account() {
          this.dateCreate = new Date();

    }
    Account(int id, double balance) {
      this.id = id;
      this.balance = balance;
    }

    public int getID(){return id;}
    public void setID(int id){this.id = id;}
    
    public double getBalance(){return balance;}
    public void setBalance(double balance){this.balance = balance;}

    public double getAnnual(){return annual;}
    public void setAnnual(double annual){this.annual=annual;}

    public Date getDate(){return dateCreate;}
    public void setDate(Date dateCreate){this.dateCreate=dateCreate;}

    public double getMonthlyInterestRate(){
      double annualRate = (annual/100) /12;
      return  annualRate;
    }

    public double getMonthlyInterest(){
      double monthInt = balance*getMonthlyInterestRate();
      return monthInt;
    }

    public void withdraw(double money){
      if(balance>=money){
            balance-=money;
      }
      else{
            System.err.println("money not enouge");
      }
    }
    public void deposit(double money){
            balance+=money;
    }  
}
public class No6 {
      public static void main(String[] args) {
            Account acc = new Account(1122,20000);
            acc.setAnnual(4.5);
            acc.withdraw(2500);
            acc.deposit(3000);
            System.out.println("balance: "+acc.getBalance()+"\nMoney Interest: "+acc.getMonthlyInterest());
          
      }
}
