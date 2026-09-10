import java.awt.*;
import javax.swing.*;

public class testGUI {
      
      public static void main(String[] args) {
            JLabel lb = new JLabel();
            JFrame frame = new JFrame();
            frame.setTitle("Test");
            frame.setSize(600, 400);// higth,width
            
            //layout
            frame.setLayout(new FlowLayout());

            //button
            JButton bt = new JButton();
            
            bt.setText("AO");

            //event
            //bt.addActionListener(e-> lb.setText("Hi Hi"));
            //bt.addActionListener(e-> System.exit(0));
            
            // (null,massage in block ,title)
            bt.addActionListener(e-> JOptionPane.showMessageDialog(null, "Hello world","Alert",JOptionPane.PLAIN_MESSAGE));



            //label
            lb.setText("text");
            //add Component
            frame.add(lb);
            
            frame.add(bt);
            
            
            

            frame.setResizable(true);
            frame.setLocationRelativeTo(null);// set to center monitor
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            lb.setText("Hi");

      }
}
