import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Microwave extends JFrame {
      JTextField screen = new JTextField(10);

      Microwave() {
            setLayout(new BorderLayout());
            MyListener spyLis = new MyListener();
            JPanel p1 = new JPanel();
            JPanel p2 = new JPanel();
            p1.setLayout(new GridLayout(4, 3));
            p2.setLayout(new BorderLayout());
            for (int i = 1; i <= 9; i++) {
                  JButton jbn = new JButton("" + i);
                  p1.add(jbn);
                  jbn.addActionListener(spyLis);
            }
            JButton jbnZero = new JButton("0");
            JButton jbnStart = new JButton("start");
            JButton jbnStop = new JButton("stop");
            p1.add(jbnZero);
            jbnZero.addActionListener(spyLis);
            jbnStart.addActionListener(spyLis);
            jbnStop.addActionListener(spyLis);
            p1.add(jbnStart);
            p1.add(jbnStop);
            p2.add(screen, BorderLayout.NORTH);
            screen.setEditable(false);
            screen.setHorizontalAlignment(JTextField.RIGHT);
            screen.setBackground(Color.white);
            p2.add(p1, BorderLayout.CENTER);
            add(p2, BorderLayout.EAST);
            JButton jbnPress = new JButton("Press me");
            jbnPress.addActionListener(spyLis);
            add(jbnPress, BorderLayout.CENTER);
      }

      class MyListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                  for (int i = 0; i <= 9; i++) {
                        if (e.getActionCommand().equals("" + i)) {
                              screen.setBackground(Color.GRAY);
                              screen.setText(screen.getText() + "" + i);
                        }
                  }
                  if (e.getActionCommand().equals("start")) {
                        screen.setBackground(Color.green);
                        screen.setText("start......");
                  }
                  if (e.getActionCommand().equals("stop")) {
                        screen.setBackground(Color.red);
                        screen.setText("stop!!!!!!");
                  }
                  if (e.getActionCommand().equals("Press me")) {
                        screen.setBackground(Color.MAGENTA);
                        screen.setText("Working!!!!!!!!!");
                  }

            }
      }

      public static void main(String[] args) {
            JFrame microwave = new Microwave();
            microwave.setSize(400, 250);
            microwave.setTitle("Demo Microwave");
            microwave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            microwave.setLocationRelativeTo(null);
            microwave.setVisible(true);

      }

}
