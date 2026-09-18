
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hangman2 extends JFrame {
      HangmanPanel hangmanPanel = new HangmanPanel();
      JButton btn1 = new JButton("1");
      JButton btn2 = new JButton("2");

      public Hangman2() {
            JPanel buttonPanel = new JPanel(new GridLayout(2, 1));

            buttonPanel.add(btn1);
            buttonPanel.add(btn2);

            setLayout(new BorderLayout());

            add(hangmanPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.EAST);

            
            btn1.addActionListener(new ButtonListener());
            btn2.addActionListener(new ButtonListener());

            setUI();
      }
      
      void setUI(){
            setTitle("Hangman");
            setSize(450, 500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

      }

      class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                  
                  if (e.getSource() == btn1) {

                        hangmanPanel.swinging = true;
                        hangmanPanel.spinning = false;

                        hangmanPanel.startTimer();
                  }
                  else if (e.getSource() == btn2) {

                        hangmanPanel.swinging = false;
                        hangmanPanel.spinning = true;

                        hangmanPanel.startTimer();
                  }
            }
      }

      
      class HangmanPanel extends JPanel {

            int pivotX = 160;
            int pivotY = 20;

            
            boolean swinging = false;
            boolean spinning = false;

            double angle = 0;

           
            double time = 0;

            
            Timer timer = new Timer(16, new TimerListener());


            class TimerListener implements ActionListener {

                  @Override
                  public void actionPerformed(ActionEvent e) {
                        if (swinging) {

                              time += 0.05;
                              angle = Math.toRadians(90)* Math.sin(time);
                        }
                        else if (spinning) {

                              angle += Math.toRadians(4);

                              // 360
                              if (angle >= Math.PI * 2) {

                                    angle -= Math.PI * 2;
                              }
                        }
                        repaint();
                  }
            }
            
            void startTimer() {

                  if (!timer.isRunning()) {

                        timer.start();
                  }
            }

            //calculate x after spin
            int rotateX(int x, int y) {

                  return (int) (pivotX+ (x - pivotX) * Math.cos(angle)- (y - pivotY) * Math.sin(angle));
            }

            // calculate y after spin
            int rotateY(int x, int y) {

                  return (int) (pivotY + (x - pivotX) * Math.sin(angle)+ (y - pivotY) * Math.cos(angle));
            }

            //pain line pass spin
            void drawRotateLine(Graphics g,int x1, int y1,int x2, int y2) {
                  int newX1 = rotateX(x1, y1);
                  int newY1 = rotateY(x1, y1);

                  int newX2 = rotateX(x2, y2);
                  int newY2 = rotateY(x2, y2);

                  g.drawLine( newX1,newY1,newX2,newY2);
            }

            // paintComponent
            @Override
            protected void paintComponent(Graphics g) {

                  super.paintComponent(g);
                  g.drawArc(20,220,80,40, 0,180); //podium
                  g.drawLine(20 + 40,220,20 + 40,20);//shaft
                  g.drawLine(20 + 40,20,20 + 40 + 100,20);// beam

                  int radius = 20;// radius of head
                  drawRotateLine( g,pivotX, 20,pivotX,40);//rope

                  int headX = rotateX(pivotX,40 + radius);
                  int headY = rotateY(pivotX,40 + radius);

                  g.drawOval(headX - radius,headY - radius,radius * 2,radius * 2);

                  int shoulderLX = pivotX- (int) (radius* Math.cos(Math.toRadians(45)));

                  int shoulderLY = 40 + radius+ (int) (radius* Math.sin(Math.toRadians(45)));

                  int shoulderRX = pivotX+ (int) (radius * Math.cos(Math.toRadians(45)));

                  int shoulderRY = 40 + radius+ (int) (radius* Math.sin(Math.toRadians(45)));

                  drawRotateLine( g,shoulderLX,shoulderLY,pivotX - 60,40 + radius + 60);//armLeft

                  drawRotateLine( g,shoulderRX,shoulderRY,pivotX + 60,40 + radius + 60);//armRight

                  drawRotateLine(g,pivotX,40 + 2 * radius,pivotX,40 + radius + 80);//body
                  
                  drawRotateLine(g,pivotX,40 + radius + 80,pivotX - 40,40 + radius + 80 + 40);//legLeft
                  drawRotateLine(g,pivotX,40 + radius + 80,pivotX + 40,40 + radius + 80 + 40);//legRight
            }
      }
    public static void main(String[] args) {
        new Hangman2();
    }
}