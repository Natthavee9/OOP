
import javax.swing.JOptionPane;

//import javax.swing.JOptionPane;
public class no1 {
      public static void main(String[] args){
             String fahrenheit = JOptionPane.showInputDialog(null, "Input Fahrenheit", 
             "Fahrenheit to Celsius",JOptionPane.QUESTION_MESSAGE);
            double fahren = Double.parseDouble(fahrenheit);
            double celsius = (5.0/9.0)*(fahren -32);
            JOptionPane.showMessageDialog(null,"Celsius: "+ String.format("%.2f",celsius) , "Fahrenheit to Celsius",JOptionPane.INFORMATION_MESSAGE);
      }
}
