import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.*;
import java.awt.font.GraphicAttribute;
import javax.swing.*;

public class lab11_no5 extends JFrame {
      public lab11_no5() {
            add(new RaceCar());
      }

      public static void main(String[] args) {
            lab11_no5 f = new lab11_no5();
            f.setTitle("Exercise");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(200, 100);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
      }

      class RaceCar extends JPanel implements Runnable{
            private int xBase = 0;
            private int delay = 10;

            // edit timer to thread
            private Thread thread = new Thread( this);

            public RaceCar() {
                  thread.start();
                  this.setFocusable(true);
                  this.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                              if (e.isControlDown() && e.getKeyCode() == 61) {
                                    if (delay > 5) {
                                          delay-=5;
                                    }
                              } else if (e.isControlDown() && e.getKeyCode() == 45) {
                                    delay += 1;
                                    
                              }
                        }
                  });
            }

            
            @Override
            public void run() {
                  try {
                        while (true) {
                              repaint();
                              Thread.sleep(delay);
                        }
                  } catch (InterruptedException ex) {
                  }
            }
            
            @Override 
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  int yBase = getHeight();
                  if (xBase > getWidth()) {
                        xBase = -20;

                  } else {
                        xBase += 1;
                  }

                  g.setColor(Color.BLACK);
                  g.fillOval(xBase + 10, yBase - 10, 10, 10);
                  g.fillOval(xBase + 30, yBase - 10, 10, 10);

                  g.setColor(Color.GREEN);
                  g.fillRect(xBase, yBase - 20, 50, 10);

                  g.setColor(Color.RED);
                  Polygon polygon = new Polygon();
                  polygon.addPoint(xBase + 10, yBase - 20);
                  polygon.addPoint(xBase + 20, yBase - 30);
                  polygon.addPoint(xBase + 30, yBase - 30);
                  polygon.addPoint(xBase + 40, yBase - 20);
                  g.fillPolygon(polygon);

            }
      }

}
