import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
class Account{
      String id ,money,interestRate;
      String openDay,openMonth,openYear;
      String firstName,lastName;
      String birthDay,birthMonth,birthYear;
      String age;
      
      public Account(String id, String money, String interestRate, String openDay, String openMonth, String openYear,
                  String firstName, String lastName, String birthDay, String birthMonth, String birthYear, String age) {
            this.id = id;
            this.money = money;
            this.interestRate = interestRate;
            this.openDay = openDay;
            this.openMonth = openMonth;
            this.openYear = openYear;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDay = birthDay;
            this.birthMonth = birthMonth;
            this.birthYear = birthYear;
            this.age = age;
      }  
}

class AccGUI extends JFrame{
      JTextField txtID = new JTextField(15);
      JTextField txtMoney = new JTextField(15);
      JTextField txtRate = new JTextField(15);
      JTextField txtFristName = new JTextField(15);
      JTextField txtLastName = new JTextField(15);
      JTextField txtAge = new JTextField(15);

      String[] days = { "day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                  "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

      String[] months = { "month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
      String[] years = {"year", "2020", "2021", "2022", "2023", "2024", "2025", "2026" };


      JComboBox<String> dropDay = new JComboBox<>(days);
      JComboBox<String> dropMonth = new JComboBox<>(months);
      JComboBox<String> dropYear = new JComboBox<>(years);
      
      JComboBox<String> dropBirthDay = new JComboBox<>(days);
      JComboBox<String> dropBirthMon = new JComboBox<>(months);
      JComboBox<String> dropBirthYear =new JComboBox<>(years);

      JButton btnSave = new JButton("save");
      JButton btnShow = new JButton("show");

      ArrayList<Account> accountList = new ArrayList<>();

      JPanel mainPanel = new JPanel();


      AccGUI(){
            setUI();

            //set main panel and fix titleborder
            
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(new TitledBorder("ACCOUNT MONEY"));

            //label Title
            JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pTitle.add(new JLabel("Enter Data Account Money"));
            pTitle.add(pTitle);

            //id,money
            JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p1.add(new JLabel("ID : "));
            p1.add(txtID);
            p1.add(new JLabel(" MONNEY : "));
            p1.add(txtMoney);
            p1.add(new JLabel(" BATH : "));
            mainPanel.add(p1);

            //annualiterate rate
            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p2.add(new JLabel("ANNUALINTERATE RATE : "));
            p2.add(txtRate);
            mainPanel.add(p2);

            //day open account
            JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p3.add(new JLabel("DAY OPEN ACCOUNT : "));
            p3.add(dropBirthDay);
            p3.add(dropBirthMon);
            p3.add(dropBirthYear);
            mainPanel.add(p3);

            //firstname
            JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p4.add(new JLabel("FIRST NAME : "));
            p4.add(txtFristName);
            mainPanel.add(p4);

            //lastname
            JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p5.add(new JLabel("LASTNAME : "));
            p5.add(txtLastName);
            mainPanel.add(p5);

            //brith day
            JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p6.add(new JLabel("BIRTH DAY : "));
            p6.add(dropBirthDay);
            p6.add(dropBirthMon);
            p6.add(dropBirthYear);
            mainPanel.add(p6);


            //

            



      }

      void setUI(){
            setTitle("Show Detail Account");
            setSize(450,500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }

      







}
public class lab9_no7 {
      public static void main(String[] args) {
            new AccGUI();
            
          
      }
}


