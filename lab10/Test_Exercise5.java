import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Test_Exercise5 extends JFrame {

      public Test_Exercise5() {
            add(new BalloonGamePanel());
      }

      public static void main(String[] args) {
            Test_Exercise5 frame = new Test_Exercise5();
            frame.setTitle("Exercise");
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
      }
}

class BalloonGamePanel extends JPanel {
      // พารามิเตอร์ของปืน
      private final int gunLength = 30; // ความยาวลำกล้องปืน
      private double angle = Math.PI / 2; // มุมเริ่มต้น 90 องศา (ชี้ตรงขึ้นฟ้า)

      // พารามิเตอร์ของกระสุน
      private double bulletX;
      private double bulletY;
      private double bulletVx;
      private double bulletVy;
      private final int bulletRadius = 4;
      private boolean isShooting = false;

      // พารามิเตอร์ของเป้าหมายเฮลิคอปเตอร์
      private int heliX;
      private final int heliY = 25; // บินบริเวณส่วนบนของจอ
      private final int heliHitRadius = 18; // รัศมีสำหรับตรวจจับการชนของกระสุน
      private final Random random = new Random();

      // ตัวแปรสำหรับนับคะแนน
      private int score = 0;

      private Timer timer;

      public BalloonGamePanel() {
            // สุ่มตำแหน่งเฮลิคอปเตอร์เริ่มต้น
            resetHeli();

            setFocusable(true);

            // ดักจับการกดปุ่มคีย์บอร์ด
            addKeyListener(new KeyAdapter() {
                  @Override
                  public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                              // ปุ่มซ้าย: เอียงมุมปืนไปทางซ้าย
                              if (angle < Math.PI - 0.15) {
                                    angle += 0.08;
                              }
                        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                              // ปุ่มขวา: เอียงมุมปืนไปทางขวา
                              if (angle > 0.15) {
                                    angle -= 0.08;
                              }
                        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                              // ปุ่มขึ้น: ยิงกระสุนออกไปตามมุมของปืน
                              if (!isShooting) {
                                    isShooting = true;
                                    int gunBaseX = getWidth() / 2;
                                    int gunBaseY = getHeight();

                                    // จุดเริ่มต้นของกระสุนที่ปลายกระบอกปืน
                                    bulletX = gunBaseX + gunLength * Math.cos(angle);
                                    bulletY = gunBaseY - gunLength * Math.sin(angle);

                                    // คำนวณเวกเตอร์ความเร็ว
                                    double speed = 8.0;
                                    bulletVx = speed * Math.cos(angle);
                                    bulletVy = -speed * Math.sin(angle);
                              }
                        }
                        repaint();
                  }
            });

            // Timer สำหรับเคลื่อนที่กระสุนและตรวจสอบการชน
            timer = new Timer(15, new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        if (isShooting) {
                              bulletX += bulletVx;
                              bulletY += bulletVy;

                              // จุดศูนย์กลางของตัวเครื่องเฮลิคอปเตอร์
                              int heliCenterX = heliX + 20;
                              int heliCenterY = heliY + 8;
                              double distance = Math.hypot(bulletX - heliCenterX, bulletY - heliCenterY);

                              // ยิงโดนเฮลิคอปเตอร์
                              if (distance <= heliHitRadius + bulletRadius) {
                                    score++; // ได้ 1 คะแนน
                                    isShooting = false;
                                    resetHeli(); // สุ่มจุดเกิดใหม่
                              }

                              // พ้นขอบจอ
                              if (bulletY < 0 || bulletX < 0 || bulletX > getWidth()) {
                                    isShooting = false;
                              }

                              repaint();
                        }
                  }
            });
            timer.start();
      }

      // เมธอดสุ่มตำแหน่งเฮลิคอปเตอร์ใหม่
      private void resetHeli() {
            int panelWidth = (getWidth() > 0) ? getWidth() : 380;
            heliX = random.nextInt(Math.max(1, panelWidth - 70)) + 15;
      }

      // เมธอดสำหรับวาดรูปเฮลิคอปเตอร์
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

            // 4. ขาสกีสำหรับลงจอด (Skids)
            g.drawLine(x + 12, y + 16, x + 12, y + 20); // ขาค้ำหน้า
            g.drawLine(x + 24, y + 16, x + 24, y + 20); // ขาค้ำหลัง
            g.drawLine(x + 5, y + 20, x + 32, y + 20); // ฐานสกี
      }

      @Override
      protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 1. แสดงคะแนน (Score) ที่มุมบนขวา
            g.setColor(Color.BLACK);
            g.setFont(new Font("Tahoma", Font.BOLD, 14));
            String scoreText = "Score: " + score;
            int textWidth = g.getFontMetrics().stringWidth(scoreText);
            g.drawString(scoreText, getWidth() - textWidth - 20, 25);

            // 2. วาดรูปเฮลิคอปเตอร์
            drawHelicopter(g, heliX, heliY);

            // 3. วาดปืน (เส้นตรงหมุนตามมุม)
            int gunBaseX = getWidth() / 2;
            int gunBaseY = getHeight();
            int gunEndX = (int) (gunBaseX + gunLength * Math.cos(angle));
            int gunEndY = (int) (gunBaseY - gunLength * Math.sin(angle));

            g.drawLine(gunBaseX, gunBaseY, gunEndX, gunEndY);
            g.drawLine(gunBaseX - 1, gunBaseY, gunEndX - 1, gunEndY);
            g.drawLine(gunBaseX + 1, gunBaseY, gunEndX + 1, gunEndY);

            // 4. วาดกระสุนปืน
            if (isShooting) {
                  g.fillOval((int) (bulletX - bulletRadius), (int) (bulletY - bulletRadius),bulletRadius * 2, bulletRadius * 2);
            }
      }
}