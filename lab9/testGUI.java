import java.awt.*;
import javax.swing.*;

public class testGUI {

      public static void main(String[] args) {
            JLabel lb = new JLabel();
            JFrame frame = new JFrame();
            frame.setTitle("Test");
            frame.setSize(600, 400);

            frame.setLayout(new FlowLayout());

            JButton bt = new JButton();

            bt.setText("AO");

            bt.addActionListener(
                        e -> JOptionPane.showMessageDialog(null, "Hello world", "Alert", JOptionPane.PLAIN_MESSAGE));

            lb.setText("text");
            frame.add(lb);

            frame.add(bt);

            frame.setResizable(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            lb.setText("Hi");

      }
}
