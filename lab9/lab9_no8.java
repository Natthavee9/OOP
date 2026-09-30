
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


//angry bird
public class lab9_no8 extends JFrame {
      JTextField jftYposition = new JTextField();
      JTextField jftSpeed = new JTextField();
      JTextField jftAngle = new JTextField() ;
      JTextField jftScore = new JTextField() ;
      JButton jbtOk  = new JButton("OK");

      int score = 0;
      int pigX;
      int bird_start;

      lab9_no8(){
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(4,3,5,5));

            p.add(new JLabel("Bird Position in y-axis"));
            p.add(jftYposition);
            p.add(new JLabel("m"));

            p.add(new JLabel("Shooting speed"));
            p.add(jftSpeed);
            p.add(new JLabel("m/s"));

            p.add(new JLabel("Angle"));
            p.add(jftAngle);
            p.add(new JLabel("degree"));

            p.add(new JLabel(""));
            p.add(jbtOk);
            p.add(new JLabel(""));


            JPanel topPanel = new JPanel(new BorderLayout());
            JLabel scneLabel = new JLabel("SCENE 1:At Tokyo",JLabel.LEFT);

            JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            scorePanel.add(new JLabel("Score"));
            jftScore = new JTextField("0",5);
            jftScore.setEditable(false);
            scorePanel.add(jftScore);

            topPanel.add(scneLabel,BorderLayout.WEST);
            topPanel.add(scorePanel,BorderLayout.EAST);


            Panel gamePanel = new Panel();
            randomPigPosition();

            setLayout(new BorderLayout());
            add(topPanel,BorderLayout.NORTH);
            add(gamePanel,BorderLayout.CENTER);
            add(p,BorderLayout.SOUTH);

            jbtOk.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e){
                        calculatedProjectile();
                  }
            });






            setUI();
      }

      void calculatedProjectile(){
            double sy = Double.parseDouble(jftYposition.getText());
            double u = Double.parseDouble(jftSpeed.getText());
            double angleDeg = Double.parseDouble(jftAngle.getText());
            
            double angleRad = Math.toRadians(angleDeg);

            double a = 5.0;
            double b = -(u * Math.sin(angleRad));
            double c = sy;

            double discriminant = (b*b) - (4*a*c);

            if(discriminant >= 0){
                  //
                  double t = (-b + Math.sqrt(discriminant)) / (2*a);

                  //
                  double sx = u*Math.cos(angleRad)*t;


                  double finalX = bird_start +sx;

                  if(Math.abs(finalX - pigX) <=20){
                        score+=10;
                        jftScore.setText(String.valueOf(score));
                        JOptionPane.showMessageDialog(this,"Hit! Score +100\nLanded at x = " + String.format("%.2f", finalX));
                        randomPigPosition();
                  }
                  else{
                        JOptionPane.showMessageDialog(this, "Missed! Landed at x = " + String.format("%.2f", finalX)+ "\nPig is at x = " + pigX);
                  }
            }else{
                  JOptionPane.showMessageDialog(this, "Invalid Projectile Trajectory (Will not hit the ground).");
            }
      }


      void randomPigPosition(){
            Random rand = new Random();
            pigX = 350 + rand.nextInt(400);
            repaint();
      }

      void setUI(){
            setSize(1100,900);
            setVisible(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }



      public static void main(String[] args) {
          new lab9_no8();
      }


      class Panel extends JPanel {
            Image bgImage;
            Image birdImage;
            Image pigImage;

            Panel() {
                  bgImage = new ImageIcon("photo_no8\\oska.jpg").getImage();
                  birdImage = new ImageIcon("photo_no8\\bird.png").getImage();
                  pigImage = new ImageIcon("photo_no8\\pig.png").getImage();
            }

            @Override
            public void paint(Graphics g) {
                  super.paint(g);
                  
                  if(bgImage != null){
                      g.drawImage(bgImage, 0, 0, getWidth(),getHeight(),this);  
                  }

                  if(birdImage != null){
                        g.drawImage(birdImage, bird_start, 210, 40,40,this);
                  }

                  if(pigImage!=null){
                        g.drawImage(pigImage, pigX, 210, 40,40,this);
                  }

            }

      }





      
      
}