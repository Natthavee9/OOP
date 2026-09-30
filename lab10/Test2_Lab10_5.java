import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

// คลาสหลักที่สืบทอดมาจาก JFrame เพื่อใช้สร้างหน้าต่างหลักของเกม
public class Test2_Lab10_5 extends JFrame {
  public static void main(String args[]) {
    Test2_Lab10_5 a = new Test2_Lab10_5();
    a.setSize(600, 500); // กำหนดขนาดของหน้าต่างโปรแกรม
    a.setVisible(true); // แสดงผลหน้าต่างบนหน้าจอ
  }

  // สร้างอ็อบเจกต์ของ BalloonPanel เพื่อนำมาแสดงในเฟรม
  private BalloonPanel paintPanel = new BalloonPanel();

  public Test2_Lab10_5() {
    setLayout(new BorderLayout()); // ตั้งค่า Layout แบบ BorderLayout
    add(paintPanel); // เพิ่มพื้นที่วาดภาพ (Panel) ลงใน Frame
    setSize(500, 500); // กำหนดขนาดเริ่มต้น
  }

  // คลาสภายในที่สืบทอดจาก JPanel ทำหน้าที่จัดการเกม วาดภาพ และรับอินพุต
  class BalloonPanel extends JPanel {
    // กำหนดค่าคงที่ต่าง ๆ ของวัตถุในเกม
    final static int BALLOON_RADIUS = 10; // รัศมีของลูกโป่ง
    final static int BALL_RADIUS = 5; // รัศมีของลูกกระสุน
    final static int GUN_LENGTH = 25; // ความยาวของกระบอกปืน
    final static int PANEL_WIDTH = 200; // ขอบเขตความกว้างสูงสุดสำหรับการสุ่มพิกัดบอลลูน
    final static int PANEL_HEIGHT = 100; // ขอบเขตความสูงสูงสุดสำหรับการสุ่มพิกัดบอลลูน

    // สุ่มพิกัดเริ่มต้นของลูกโป่ง (บอลลูน)
    private int x_Balloon = (int) (Math.random() * PANEL_WIDTH);
    private int y_Balloon = (int) (Math.random() * PANEL_HEIGHT);

    // มุมการเล็งของปืน (เริ่มต้นที่ 90 องศา คือชี้ตรงขึ้นด้านบน)
    private int angle = 90;

    // โครงสร้างข้อมูล LinkedList ใช้สำหรับเก็บลูกกระสุนทุกลูกที่ถูกยิงออกมา
    private LinkedList<SmallBall> list = new LinkedList<SmallBall>();

    // คลาสสำหรับเก็บข้อมูลของลูกกระสุนแต่ละนัด (ระยะการเคลื่อนที่
    // และทิศทางมุมที่ยิง)
    class SmallBall {
      int length; // ระยะห่างจากจุดกำเนิด (โคนกระบอกปืน)
      int angle; // มุมที่ลูกกระสุนพุ่งไป

      SmallBall(int length, int angle) {
        this.length = length;
        this.angle = angle;
      }
    }

    // Timer สำหรับลูปการทำงานของเกม สั่งให้เรียก repaint() ทุก ๆ 10 มิลลิวินาที
    private Timer timer = new Timer(10, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        repaint(); // สั่งให้อัปเดตและวาดหน้าจอใหม่
      }
    });

    public BalloonPanel() {
      setFocusable(true); // อนุญาตให้ Panel นี้รับการโฟกัสจากคีย์บอร์ดได้

      // ดักจับเหตุการณ์การกดปุ่มจากคีย์บอร์ด
      this.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // กดลูกศรซ้าย: เพิ่มมุม (หมุนปืนเอียงไปทางซ้าย สูงสุดไม่เกิน 180 องศา)
            if (angle < 180)
              angle += 3;
          } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // กดลูกศรขวา: ลดมุม (หมุนปืนเอียงไปทางขวา ต่ำสุดไม่ต่ำกว่า 0 องศา)
            if (angle > 0)
              angle -= 3;
          } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            // กดลูกศรขึ้น: ยิงลูกกระสุนใหม่ โดยเริ่มที่ปลายกระบอกปืนตามมุมปัจจุบัน
            list.add(new SmallBall(GUN_LENGTH, angle));
          }

          repaint(); // อัปเดตมุมมองหลังการกดปุ่มทันที
        }
      });
      timer.start(); // เริ่มให้ตัวนับเวลาทำงาน
    }

    // ตัวแปรเก็บสถานะว่ายิงโดนบอลลูนหรือไม่
    boolean hit = false;

    /** เมธอดสำหรับวาดส่วนประกอบต่าง ๆ ของเกม */
    public void paint(Graphics g) {
      super.paintComponent(g); // เคลียร์หน้าจอเดิมก่อนวาดใหม่

      // คำนวณพิกัดปลายกระบอกปืนด้วยสูตรตรีโกณมิติ
      int x = (int) (GUN_LENGTH * Math.cos(Math.toRadians(angle)) + getWidth() / 2);
      int y = (int) (getHeight() - GUN_LENGTH * Math.sin(Math.toRadians(angle)));

      // วาดเส้นกระบอกปืนซ้อนกันหลายเส้นเพื่อให้มีความหนา
      g.drawLine(getWidth() / 2, getHeight(), x, y);
      g.drawLine(getWidth() / 2 - 1, getHeight(), x - 1, y);
      g.drawLine(getWidth() / 2 - 2, getHeight(), x - 2, y);
      g.drawLine(getWidth() / 2 + 1, getHeight(), x + 1, y);
      g.drawLine(getWidth() / 2 + 2, getHeight(), x + 2, y);

      // กรณีที่ยิงถูกบอลลูน: ให้แสดงเอฟเฟกต์ลูกโป่งแตกกระจายเป็น 4 ชิ้นส่วน
      if (hit) {
        // วาดชิ้นส่วนแตกด้านซ้าย
        g.drawOval(x_Balloon - BALLOON_RADIUS / 2 - 5,
            y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS, BALLOON_RADIUS);
        // วาดชิ้นส่วนแตกด้านขวา
        g.drawOval(x_Balloon + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2,
            y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS, BALLOON_RADIUS);
        // วาดชิ้นส่วนแตกด้านล่าง
        g.drawOval(x_Balloon - BALLOON_RADIUS / 2,
            y_Balloon + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS, BALLOON_RADIUS);
        // วาดชิ้นส่วนแตกด้านบน
        g.drawOval(x_Balloon - BALLOON_RADIUS / 2,
            y_Balloon - 2 * BALLOON_RADIUS - 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS, BALLOON_RADIUS);

        hit = false; // รีเซ็ตสถานะการชน

        // สุ่มหาตำแหน่งพิกัดใหม่ให้กับบอลลูน
        x_Balloon = (int) (Math.random() * PANEL_WIDTH);
        y_Balloon = (int) (Math.random() * PANEL_HEIGHT);

        return; // จบการวาดเฟรมนี้ทันทีเพื่อรอวาดบอลลูนใหม่ในเฟรมถัดไป
      }

      // วาดรูปลูกโป่ง (วงกลมโปร่งใส) ที่พิกัดปัจจุบัน
      g.drawOval(x_Balloon - BALLOON_RADIUS,
          y_Balloon - BALLOON_RADIUS, 2 * BALLOON_RADIUS, 2 * BALLOON_RADIUS);

      // วนลูปเพื่ออัปเดตตำแหน่งและวาดลูกกระสุนทุกลูกที่กำลังบิน
      for (int i = 0; i < list.size(); i++) {
        SmallBall ball = list.get(i);
        ball.length += 5; // เพิ่มระยะทางให้ลูกกระสุนพุ่งออกไปทีละ 5 หน่วย

        // คำนวณพิกัด X, Y ปัจจุบันของลูกกระสุนตามมุมที่ถูกยิง
        x = (int) (ball.length * Math.cos(Math.toRadians(ball.angle)) + getWidth() / 2);
        y = (int) (getHeight() - ball.length * Math.sin(Math.toRadians(ball.angle)));

        // วาดลูกกระสุน (วงกลมทึบสีดำ)
        g.fillOval(x - BALL_RADIUS, y - BALL_RADIUS, 2 * BALL_RADIUS, 2 * BALL_RADIUS);

        // ตรวจสอบว่าลูกกระสุนชนกับลูกโป่งหรือไม่
        if (overlaps(x, y, BALL_RADIUS, x_Balloon, y_Balloon, BALLOON_RADIUS)) {
          list.remove(i); // ลบลูกกระสุนที่ยิงโดนออกจากรายการ
          hit = true; // ตั้งค่าสถานะว่ายิงโดนเป้าหมาย
        }

        // หากลูกกระสุนบินหลุดออกนอกขอบจอ (ซ้าย ขวา หรือบน) ให้ลบออกจากรายการ
        if (x > getWidth() || x < 0 || y < 0)
          list.remove(i);
      }
    }
  }

  /**
   * เมธอดตรวจสอบการทับซ้อน/ชนกันของวงกลม 2 วง
   * โดยใช้สูตรคำนวณระยะห่างระหว่างจุดสองจุดแบบยูคลิด
   * หากระยะห่างระหว่างจุดกึ่งกลางน้อยกว่าหรือเท่ากับผลบวกของรัศมีทั้งสอง
   * ถือว่าเกิดการชนกัน
   */
  public static boolean overlaps(double x1, double y1, double radius1,
      double x2, double y2, double radius2) {
    return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= radius1 + radius2;
  }
}