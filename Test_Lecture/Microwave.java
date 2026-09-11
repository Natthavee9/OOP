
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

 
public class Microwave  extends  JFrame{
      JTextField screen;
      MyListener spyLis = new MyListener();
    public Microwave() {
      setLayout(new BorderLayout());
      JPanel p1 = new JPanel();
      JPanel p2 =new JPanel();
      screen = new JTextField(10);
      

      p1.setLayout(new GridLayout(5,4));
      p2.setLayout(new BorderLayout());
      for(int i= 1;i<=9;i++){
            JButton jbn = new JButton(""+i);
            p1.add(jbn);
            jbn.addActionListener(spyLis);
      }

      JButton jbnZero = new JButton();
      p1.add(jbnZero);
      jbnZero.addActionListener(spyLis); 
      p1.add(new JButton("0"));
      p1.add(new JButton("Start"));
      p1.add(new JButton("Stop"));

      p2.add(screen,BorderLayout.NORTH);
      screen.setEditable(false);
      screen.setHorizontalAlignment(JTextField.RIGHT);
      p2.add(p1,BorderLayout.CENTER);
      add(p2,BorderLayout.EAST);
      add(new JButton("acc"),BorderLayout.CENTER);



    }

    class MyListener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
            for(int i = 0 ;i<=9;i++){
                  if (e.getActionCommand().equals(""+i)) {
                        screen.setText(""+i);
                  }
            }
      }
      
    }
      
      public static void main(String[] args) {
          JFrame microwave = new Microwave();
          microwave.setSize(400,250);
          microwave.setTitle("Demo micro");
          microwave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          microwave.setVisible(true);

      }
      
}
