import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Fan extends JFrame {
      JButton jbn0 = new JButton("0");
      JButton jbn1 = new JButton("1");
      JButton jbn2 = new JButton("2");
      JButton jbn3 = new JButton("3");
      JPanel p = new JPanel();
      DrawArcPanel drawArcPanel = new DrawArcPanel();

      
      public Fan() {
            setLayout(new BorderLayout());
            p.add(jbn0);
            p.add(jbn1);
            p.add(jbn2);
            p.add(jbn3);
            add(p, BorderLayout.SOUTH);
            add(drawArcPanel, BorderLayout.CENTER);
            ButtonListe spy =new ButtonListe();
            jbn0.addActionListener(spy);
            jbn1.addActionListener(spy);
            jbn2.addActionListener(spy);
            jbn3.addActionListener(spy);
            
      }


      class ButtonListe implements ActionListener{
            @Override 
            public void actionPerformed(ActionEvent e){
                switch (e.getActionCommand()) {
                    case "0":
                        drawArcPanel.speed = 0;
                        break;
                    case "1":
                        drawArcPanel.speed = 2;
                        break;
                    case "2":
                        drawArcPanel.speed = 5;
                        break;
                    case "3":
                        drawArcPanel.speed = 10;
                        break;
                    default:
                        break;
                }
            }

      }
      public static void main(String[] args) {
            JFrame fan = new Fan();
            fan.setSize(250, 300);
            fan.setTitle("Fan Test");
            fan.setLocationRelativeTo(null);// set center
            fan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fan.setVisible(true);
      }
}

class DrawArcPanel extends JPanel {
      int degree = 0;
      Timer time = new Timer(1, new Listner());
      int speed = 0;

      class Listner implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  repaint();
            }
      }

      public DrawArcPanel() {
            time.start();
      }

      @Override
      public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int xcenter = getWidth() / 2;
            int ycenter = getHeight() / 2;
            int radius = (int) (Math.min(getWidth(), getHeight()) * 0.4);
            int x = xcenter - radius;
            int y = ycenter - radius;
            degree = degree + speed;
            g.fillArc(x, y, 2 * radius, 2 * radius, 0 + degree, 30);
            g.fillArc(x, y, 2 * radius, 2 * radius, 90 + degree, 30);
            g.fillArc(x, y, 2 * radius, 2 * radius, 180 + degree, 30);
            g.fillArc(x, y, 2 * radius, 2 * radius, 270 + degree, 30);
      }

      
}