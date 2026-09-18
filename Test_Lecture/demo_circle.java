
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class demo_circle extends JFrame {
      JButton jbnEnlarge = new JButton("Enlarge");
      JButton jbnShrink = new JButton("Shrink");
      DrawArea drawArea = new DrawArea();
      JPanel p =new JPanel();
      public demo_circle(){
            setLayout(new BorderLayout());
            p.add(jbnEnlarge);
            p.add(jbnShrink);
            add(p,BorderLayout.SOUTH);
            add(drawArea,BorderLayout.CENTER );
            ButtonListe spy =new ButtonListe();
            jbnEnlarge.addActionListener(spy);
            jbnShrink.addActionListener(spy);
      }

      //inner class
      class ButtonListe implements ActionListener{
            @Override 
            public void actionPerformed(ActionEvent e){
                  if(e.getActionCommand().equals("Enlarge")){
                        drawArea.Enlarge();
                  }
                  else if(e.getActionCommand().equals("Shrink")){
                        drawArea.Shrink();
                  }

            }
      }

      public static void main(String[] args) {
            JFrame demo = new demo_circle();
            demo.setSize(200, 200);
            demo.setTitle("Demo Drawn Circle");
            demo.setLocationRelativeTo(null);
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setVisible(true);

      }

}

class DrawArea extends JPanel {
      int radius = 5;

      void Enlarge(){
            radius+=5;
            repaint();
      }

      void Shrink(){
            radius-=5;
            repaint();
      }

      @Override
      public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawOval((getWidth() / 2) - radius, (getHeight() / 2) - radius, 2 * radius, 2 * radius);
      }

}
