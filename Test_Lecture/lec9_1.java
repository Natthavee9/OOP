
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class MyFrame extends JFrame{
      //component
      JLabel jlbName = new JLabel("name");
      JTextField jtfName = new JTextField(10);
      JLabel jlbSurname = new JLabel("Surname");
      JTextField jtfSurname = new JTextField(10);
      JLabel jlbAge = new JLabel("age");
      JTextField jtfAge = new JTextField(3);
      
      //Button
      JButton jbnOk = new JButton("OK");
      JButton jbnCancel = new JButton("Cancel");

      JPanel p =new JPanel(new GridLayout(4,2));

    public MyFrame() {
      p.add(jlbName);
      p.add(jtfName);
      p.add(jlbSurname);
      p.add(jtfSurname);
      p.add(jlbAge);
      p.add(jtfAge);


      p.add(jbnOk);
      p.add(jbnCancel);

      add(p);
      Listener spyObj = new Listener();
      jbnOk.addActionListener(spyObj);
      jbnCancel.addActionListener(spyObj);
      
    }

    //inner class
    class Listener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jbnOk){
                  String name = jtfName.getText();
                  String surname = jtfSurname.getText();
                  int age = Integer.parseInt(jtfAge.getText());
                  JOptionPane.showMessageDialog(null, "Info: "+name + " " + surname + " " + age);
            }
            else if(e.getSource() == jbnCancel){
                  jtfName.setText(" ");
                  jtfSurname.setText(" ");
                  jtfAge.setText(" ");

            }
            
      }
      

    }

      




}



public class lec9_1 {
      public static void main(String[] args) {
          JFrame f = new MyFrame();
          f.setSize(400,250);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setLocationRelativeTo(null);
          f.setVisible(true);
      }
      
}
