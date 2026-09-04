import java.awt.*;
import javax.swing.*;

abstract class AbstractDrawFunction extends JPanel {
      /** Polygon to hold the points */
      private Polygon p = new Polygon(); 

      /** Default constructor */
      protected AbstractDrawFunction() {
            drawFunction();
            setBackground(Color.black);
      }

      /** Draw the function */
      public abstract double f(double x);

      /** Obtain points for x coordinates 100, 101, ..., 300 */
      public void drawFunction() {
            for (int x = -100; x <= 100; x++) {
                  p.addPoint(x + 200, 200 - (int) f(x));
            }
      }

      /** Paint the function diagram */
      public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.yellow);
            
            // Draw x axis
            g.drawLine(10, 200, 390, 200);
            // Draw y axis
            g.drawLine(200, 30, 200, 390);
            // Draw arrows on x axis
            g.drawLine(390, 200, 370, 190);
            g.drawLine(390, 200, 370, 210);
            // Draw arrows on y axis
            g.drawLine(200, 30, 190, 50);
            g.drawLine(200, 30, 210, 50);
            // Draw x, y
            g.drawString("X", 370, 170);
            g.drawString("Y", 220, 40);
            // Draw a polygon line by connecting the points in the polygon
            g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
      }
}

class DrawX_squre extends AbstractDrawFunction{ //a
      @Override
      public double f(double x) {
            return x*x;
      }
}

class DrawSine extends AbstractDrawFunction { //b

      @Override
      public double f(double x) {
            return 5* Math.sin(Math.toRadians(x));
      }
}

class DrawCos extends AbstractDrawFunction{

      @Override
      public double f(double x) {
            return 5 * Math.cos(Math.toRadians(x));
      }

}

class DrawTan extends AbstractDrawFunction{

      @Override
      public double f(double x) {
            return 5 * Math.tan(Math.toRadians(x));
      }

}
class DrawCosSin extends AbstractDrawFunction{

      @Override
      public double f(double x) {
            return 5 * (Math.cos(Math.toRadians(x)) + (5* Math.sin(Math.toRadians(x))));
      }

}
class Draw5CosSin extends AbstractDrawFunction{

      @Override
      public double f(double x) {
            return 5 * (5*(Math.cos(Math.toRadians(x)) + ( Math.sin(Math.toRadians(x)))));
      }

}
class Drawlog extends AbstractDrawFunction{

      @Override
      public double f(double x) {
            return  5*((Math.log(Math.toRadians(x)) + ( x*x)));
      }

}

public class Test1 extends JFrame {
      public Test1() {
            getContentPane().setLayout(new GridLayout(3, 2, 5, 5));
            getContentPane().add(new DrawX_squre()); //a
            getContentPane().add(new DrawSine()); //b
            getContentPane().add(new DrawCos()); //c
            getContentPane().add(new DrawTan()); //d
            getContentPane().add(new DrawCosSin()); //e
            getContentPane().add(new Draw5CosSin()); //f
            getContentPane().add(new Drawlog()); //g

            
      }

      public static void main(String[] args) {
            Test1 frame = new Test1();
            frame.setSize(400, 400);
            frame.setTitle("Exercise 10.10");
            frame.setVisible(true);
      }
}
