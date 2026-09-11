import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class ConvertUS extends JFrame{
      private JButton btConvert = new JButton("Convert");
      private JTextField jtUS = new JTextField();
      private JTextField jtCA = new JTextField();

      public ConvertUS(){
            setUI();
            setDefault(this);
            
      }

      void setUI(){
            JPanel jp = new JPanel(new GridLayout(2, 2));
            jp.add(new JLabel("US Dollars"));
            jp.add(jtUS);
            jp.add(new JLabel("Canadian Dollars"));
            jp.add(jtCA);
            jtCA.setEditable(false);

            JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pSouth.add(btConvert);
            add(jp, BorderLayout.CENTER);
            add(pSouth, BorderLayout.SOUTH);
            
            Listener spyObj = new Listener();
            btConvert.addActionListener(spyObj);
      }

      class Listener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                  if(e.getSource() == btConvert){
                        double usd = Double.parseDouble(jtUS.getText());
                        double cad = usd * 1.5;
                        jtCA.setText(String.format("%.2f", cad));

                  }   
            } 
      }

      void setDefault(JFrame windows){
            windows.setTitle("Convert US Dollars to Canadian Dollars");
            windows.setSize(500, 150);
            windows.setLocationRelativeTo(null);
            windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windows.setVisible(true);
      }
}
public class USdollar {
      public static void main(String[] args) {
            ConvertUS conUS = new ConvertUS(); 
      }
}
