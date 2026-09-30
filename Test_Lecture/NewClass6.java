import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class NewClass6 extends JFrame { 
  public static void main(String args[]){
      NewClass6 a = new NewClass6();
      a.setSize(600,500);
      a.setVisible(true);
   }

  private BalloonPanel paintPanel = new BalloonPanel();
   public NewClass6(){
	  setLayout(new BorderLayout());
	  add(paintPanel);
	  setSize(500,500);  
    setLocationRelativeTo(null);
  }
  class BalloonPanel extends JPanel {
    final static int BALLOON_RADIUS = 10;
    final static int BALL_RADIUS = 20;
    final static int GUN_LENGTH = 25;
    final static int PANEL_WIDTH = 200;
    final static int PANEL_HEIGHT = 100;
    
    private int x_Balloon = 0;
    private int y_Balloon = 80;
    private int speedX = 2;
   
    private int angle = 90;  
    private int tm = 10;  

    private LinkedList<SmallBall> list = new LinkedList<SmallBall>();

    private int score = 0; //add score
    
    class SmallBall {
      int length;
      int angle;
      
      SmallBall(int length, int angle) {
        this.length = length;
        this.angle = angle;
      }
    }
    
    private Timer timer = new Timer(10, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        x_Balloon += speedX;

        
        if (x_Balloon > getWidth() - 40) {
          speedX = -Math.abs(speedX);
        } else if (x_Balloon < 20) {
          speedX = Math.abs(speedX); 
        }
        repaint();
      }
    });

    private Timer timer1 = new Timer(1000, new ActionListener() {
      @Override 
      public void actionPerformed(ActionEvent e) {
        if (tm > 0) {
          tm--;
        } else {
          timer1.stop();
          timer.stop();

          JOptionPane.showMessageDialog(BalloonPanel.this,
              "Game Over!\nYour Score: " + score,
              "Game Over",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }

    });
    

    public BalloonPanel() {      
      setFocusable(true);
      
      this.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (angle < 180) angle += 3;
          }
          else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (angle > 0) angle -= 3;
          }
          else if (e.getKeyCode() == KeyEvent.VK_UP) {
            // Launch a small ball
            list.add(new SmallBall(GUN_LENGTH, angle));
          }
          
          repaint();
        }
      });
      timer.start();
      timer1.start();
    }

    private void drawHelicopter(Graphics g, int x, int y) {
      g.setColor(Color.BLACK);

      // 1. ใบพัดหลักและแกนหมุนด้านบน
      g.drawLine(x + 10, y - 5, x + 30, y - 5); // ใบพัดหลัก
      g.drawLine(x + 20, y - 5, x + 20, y); // แกนต่อใบพัด

      // 2. ตัวลำเครื่อง (Cabin) และหน้าต่างกระจก
      g.drawOval(x + 5, y, 30, 16); // โครงลำตัว
      g.drawArc(x + 20, y + 2, 12, 12, -40, 120); // กระจกหน้า

      // 3. หางและใบพัดหาง
      g.drawLine(x + 5, y + 8, x - 15, y + 8); // คานหาง
      g.drawLine(x - 15, y + 3, x - 15, y + 13); // ใบพัดท้าย

      
      g.drawLine(x + 12, y + 16, x + 12, y + 20); // ขาค้ำหน้า
      g.drawLine(x + 24, y + 16, x + 24, y + 20); // ขาค้ำหลัง
      g.drawLine(x + 5, y + 20, x + 32, y + 20); // ฐานสกี
    }
    
    boolean hit = false;
    
    /** Paint message */
    @Override 
    public void paint(Graphics g) {
      super.paintComponent(g);

      g.drawString("Score : "+score,10,30);
      g.drawString("Time :  " +tm,getWidth()-80,30);
            
      // Display the gun
      int x = (int)(GUN_LENGTH * Math.cos(Math.toRadians(angle)) + 
        getWidth() / 2);
      int y = (int)(getHeight() - 
        GUN_LENGTH * Math.sin(Math.toRadians(angle)));
      g.drawLine(getWidth() / 2, getHeight(), x, y);
      g.drawLine(getWidth() / 2 - 1, getHeight(), x - 1, y);
      g.drawLine(getWidth() / 2 - 2, getHeight(), x - 2 , y);
      g.drawLine(getWidth() / 2 + 1, getHeight(), x + 1, y);
      g.drawLine(getWidth() / 2 + 2, getHeight(), x + 2, y);  
      
      if (hit) {
        // Display three small pieces
        g.drawOval(x_Balloon - BALLOON_RADIUS / 2 - 5, 
            y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS, 
            BALLOON_RADIUS);
        g.drawOval(x_Balloon  + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2, 
            y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS, 
            BALLOON_RADIUS);        
        g.drawOval(x_Balloon - BALLOON_RADIUS / 2, 
        y_Balloon + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS, 
            BALLOON_RADIUS);              
        g.drawOval(x_Balloon - BALLOON_RADIUS / 2, 
        y_Balloon - 2 * BALLOON_RADIUS - 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS, 
            BALLOON_RADIUS); 
       
        hit = false;
        
       

        return;
      }
      
      // g.drawOval(x_Balloon - BALLOON_RADIUS, 
      //   y_Balloon- BALLOON_RADIUS, 2 * BALLOON_RADIUS, 
      //   2 * BALLOON_RADIUS);//love ajansatid;

      drawHelicopter(g, x_Balloon, y_Balloon);
            
      // Draw small hitting balls
      for (int i = 0; i < list.size(); i++) {
        SmallBall ball = list.get(i);//eiei
        ball.length += 5;//yeye
        
        x = (int)(ball.length * Math.cos(Math.toRadians(ball.angle)) + 
          getWidth() / 2);
        y = (int)(getHeight() - 
            ball.length * Math.sin(Math.toRadians(ball.angle)));
          
        g.fillOval(x - BALL_RADIUS, y - BALL_RADIUS, 2 * BALL_RADIUS, 
            2 * BALL_RADIUS);
        
        if (overlaps(x, y, BALL_RADIUS, 
            x_Balloon, y_Balloon, BALLOON_RADIUS)) {
          list.remove(i);
          hit = true;
          score+=10; //add score
        }
        
        if (x > getWidth() || x < 0 || y < 0)
          list.remove(i);         
      }
    }
  }
  public static boolean overlaps(double x1, double y1, double radius1,
      double x2, double y2, double radius2) {    
    return Math.sqrt((x1 - x2) * (x1 - x2)
      + (y1 - y2) * (y1 - y2)) <= radius1 + radius2;
  }
}

