
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.*;
import javax.swing.*;



public class lecture10 extends  JFrame{

    public lecture10(){
      URL bgUrl = getClass().getResource("image\\bg.jpg");
      Image imBG = new ImageIcon(bgUrl).getImage();
      URL actotUrl = getClass().getResource("image\\tiger.jpg");
      Image imA = new ImageIcon(actotUrl).getImage();
      add(new DrawGamePanel(imBG, imA));

    }
    //inner class
    class DrawGamePanel extends JPanel{
      Image bgImage = null;
      Image acImage = null;
      int xActor = 1000;
      int yActor = 100;
      //Timer time = new Timer (60, new TimeListe());

        

      //inner class 
      class TimeListe implements ActionListener{
            @Override 
            public void actionPerformed(ActionEvent e){
                  repaint();
            }

      }

      DrawGamePanel(Image imgBG,Image imgAC) {
            setFocusable(true);
            this.bgImage = imgBG;
            this.acImage = imgAC;
            //time.start();
            addMouseMotionListener(new MouseMotionListener() {  
                @Override
                public void mouseDragged(MouseEvent e) {
                  xActor = e.getX();
                  yActor = e.getY();
                  repaint();
                    
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    
                }
                  
            });// anonymous listener Mouse
            

            //keyboard input
            addKeyListener(new KeyAdapter() {
                  @Override 
                  public void keyPressed(KeyEvent e){
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_DOWN:yActor+=10;break;
                            case KeyEvent.VK_UP:yActor-=10;break;
                            case KeyEvent.VK_LEFT:xActor-=10;break;
                            case KeyEvent.VK_RIGHT:xActor+=10;break;
                                
                            default:
                                throw new AssertionError();
                        }
                        repaint();     
                  }
                  
            });
      }

      @Override 
      public void paintComponent(Graphics g){
            super.paintComponent(g); //delete old picture
            g.drawImage(bgImage, 0, 0, getWidth(),getHeight(),this);
            

            if (xActor <=100){
                  xActor = getWidth();
            }
            else{
                  xActor -= 50;
                  yActor+=1;
            }
            g.drawImage(acImage, xActor, yActor, 200,100,this);
            g.setColor(Color.RED);
            g.drawString("Position x,y: " + xActor + ", " + yActor, xActor, yActor - 90);
            




      }

      
    }

      
      public static void main(String[] args) {
          JFrame demoG = new lecture10(); 
          demoG.setSize(1700,1500);
          demoG.setTitle("test Graphic");
          demoG.setLocationRelativeTo(null);//set center
          demoG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          demoG.setVisible(true);
      }
      
}
