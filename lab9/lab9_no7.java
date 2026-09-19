import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

class Account {
      String id, money, interestRate;
      String openDay, openMonth, openYear;
      String firstName, lastName;
      String birthDay, birthMonth, birthYear;
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

class AccGUI extends JFrame {
      JTextField txtID = new JTextField(15);
      JTextField txtMoney = new JTextField(15);
      JTextField txtRate = new JTextField(15);
      JTextField txtFristName = new JTextField(15);
      JTextField txtLastName = new JTextField(15);
      JTextField txtAge = new JTextField(15);

      String[] days = { "day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                  "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

      String[] months = { "month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
      String[] years = { "year", "2020", "2021", "2022", "2023", "2024", "2025", "2026" };

      JComboBox<String> dropDay = new JComboBox<>(days);
      JComboBox<String> dropMonth = new JComboBox<>(months);
      JComboBox<String> dropYear = new JComboBox<>(years);

      JComboBox<String> dropBirthDay = new JComboBox<>(days);
      JComboBox<String> dropBirthMon = new JComboBox<>(months);
      JComboBox<String> dropBirthYear = new JComboBox<>(years);

      JButton btnSave = new JButton("save");
      JButton btnShow = new JButton("show");

      ArrayList<Account> accountList = new ArrayList<>();

      JPanel mainPanel = new JPanel();

      AccGUI() {
            

            // set main panel and fix titleborder

            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(new TitledBorder("ACCOUNT MONEY"));

            // label Title
            JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pTitle.add(new JLabel("Enter Data Account Money"));
            //pTitle.add(pTitle);

            // id,money
            JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p1.add(new JLabel("ID : "));
            p1.add(txtID);
            p1.add(new JLabel(" MONNEY : "));
            p1.add(txtMoney);
            p1.add(new JLabel(" BATH : "));
            mainPanel.add(p1);

            // annualiterate rate
            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p2.add(new JLabel("ANNUALINTERATE RATE : "));
            p2.add(txtRate);
            mainPanel.add(p2);

            // day open account
            JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p3.add(new JLabel("DAY OPEN ACCOUNT : "));
            p3.add(dropBirthDay);
            p3.add(dropBirthMon);
            p3.add(dropBirthYear);
            mainPanel.add(p3);

            // firstname
            JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p4.add(new JLabel("FIRST NAME : "));
            p4.add(txtFristName);
            mainPanel.add(p4);

            // lastname
            JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p5.add(new JLabel("LASTNAME : "));
            p5.add(txtLastName);
            mainPanel.add(p5);

            // brith day
            JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p6.add(new JLabel("BIRTH DAY : "));
            p6.add(dropBirthDay);
            p6.add(dropBirthMon);
            p6.add(dropBirthYear);
            mainPanel.add(p6);

            // age
            JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p7.add(new JLabel("AGE : "));
            p7.add(txtAge);
            p7.add(new JLabel(" YEAR"));
            mainPanel.add(p7);

            // Button
            JPanel p8 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            p8.add(btnSave);
            p8.add(btnShow);
            mainPanel.add(p8);

            // main set in JFrame
            add(mainPanel);

            btnSave.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // get data
                        String id = txtID.getText();
                        String money = txtMoney.getText();
                        String rate = txtRate.getText();

                        String oDay = (String) dropDay.getSelectedItem();
                        String oMonth = (String) dropMonth.getSelectedItem();
                        String oYear = (String) dropMonth.getSelectedItem();

                        String fName = txtFristName.getText();
                        String lName = txtLastName.getText();

                        String bDay = (String) dropBirthDay.getSelectedItem();
                        String bMonth = (String) dropBirthMon.getSelectedItem();
                        String bYear = (String) dropBirthYear.getSelectedItem();
                        String age = txtAge.getText();

                        // build obj of account and store in arraylist
                        Account newAcc = new Account(id, money, rate, oDay, oMonth, oYear, fName, lName, bDay, bMonth,bYear, age);
                        accountList.add(newAcc);
                        
                        
                        // show confrim store
                        JOptionPane.showMessageDialog(null, "record of " + fName + " Confirm!", "Success",JOptionPane.INFORMATION_MESSAGE);

                        
                        
                        // show option on main panel
                        txtID.setText("");
                        txtMoney.setText("");
                        txtRate.setText("");
                        txtFristName.setText("");
                        txtLastName.setText("");
                        txtAge.setText("");
                        dropDay.setSelectedIndex(0);
                        dropMonth.setSelectedIndex(0);
                        dropYear.setSelectedIndex(0);
                        dropBirthDay.setSelectedIndex(0);
                        dropBirthMon.setSelectedIndex(0);
                        dropBirthYear.setSelectedIndex(0);
                  }

            });
            // เพิ่มคำสั่งดักจับเหตุการณ์ให้ปุ่ม SHOW
            btnShow.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // check arraylist 
                        if (accountList.isEmpty()) {
                              JOptionPane.showMessageDialog(null, "No Information", "Information",
                                          JOptionPane.INFORMATION_MESSAGE);
                              return;
                        }

                        
                        StringBuilder dataOutput = new StringBuilder();
                        for (int i = 0; i < accountList.size(); i++) {
                              Account acc = accountList.get(i);
                              dataOutput.append("ID: ").append(acc.id).append("\n");
                              dataOutput.append("Name: ").append(acc.firstName).append(" ").append(acc.lastName).append("\n");
                              dataOutput.append("Money: ").append(acc.money).append(" Baht\n");
                              dataOutput.append("---------------------------------\n");
                        }

                        // create can slide 
                        JTextArea textArea = new JTextArea(dataOutput.toString());
                        textArea.setEditable(false);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(300, 200));

                        // output
                        JOptionPane.showMessageDialog(null, scrollPane, "All Accounts Data",JOptionPane.INFORMATION_MESSAGE);
                  }
            });
            setUI();
      }

      void setUI() {
            setTitle("Show Detail Account");
            setSize(450, 500);
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