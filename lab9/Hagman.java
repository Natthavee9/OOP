// lab9 no 6
import java.awt.*;
import javax.swing.*;
class DrawHangman extends JPanel{

      public DrawHangman(){
            JFrame f = new JFrame();
            f.add(this);
            setDefault(f);
      }
      @Override
      public void paintComponent(Graphics g){
            
            g.drawArc(20, 220, 80, 40, 0, 180);
            g.drawLine(20 + 40, 220, 20 + 40, 20);
            g.drawLine(20 + 40, 20, 20 + 40 + 100, 20);
            g.drawLine(20 + 40 + 100, 20, 20 + 40 + 100, 40);
            int radius = 20;
            g.drawOval(20 + 40 + 100 - radius, 40, 2 * radius, 2 * radius);
            g.drawLine(20 + 40 + 100 - (int) (radius *
                        Math.cos(Math.toRadians(45))),
                        40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
                        20 + 40 + 100 - 60, 40 + radius + 60);
            g.drawLine(20 + 40 + 100 + (int) (radius *
                        Math.cos(Math.toRadians(45))),
                        40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
                        20 + 40 + 100 + 60, 40 + radius + 60);
            g.drawLine(20 + 40 + 100, 40 + 2 * radius,
                        20 + 40 + 100, 40 + radius + 80);
            g.drawLine(20 + 40 + 100, 40 + radius + 80, 20 + 40 + 100 - 40,
                        40 + radius + 80 + 40);
            g.drawLine(20 + 40 + 100, 40 + radius + 80, 20 + 40 + 100 + 40,
                        40 + radius + 80 + 40);

      }

      void setDefault(JFrame windows) {
            windows.setTitle("Hangman");
            windows.setSize(350, 300);
            windows.setLocationRelativeTo(null);
            windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windows.setVisible(true);
      }

}
public class Hagman {
      public static void main(String[] args) {
            DrawHangman hangman = new DrawHangman();
          
      }
      
}
