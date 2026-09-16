import javax.swing.*;
class Account extends JFrame{

      public Account(){
            setUI(this);

      }

      
      
      
      
      
      
      
      void setUI(JFrame jf){
            jf.setSize(500, 300);
            jf.setTitle("Show Detail.Account");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);
      }

}
public class lab9_no7 {
      public static void main(String[] args) {
            new Account();
          
      }
}
