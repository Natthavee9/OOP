import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame {
      JPanel p1 = new JPanel();
      JPanel p2 = new JPanel(new BorderLayout());
      JTextField screen = new JTextField(10);
      Listener spy = new Listener();

      double num1 = 0;
      String operator = "";

      boolean isNewNumber = true;

      String[] button = {
                  "√", "x^2", "+/-", "C",
                  "7", "8", "9", "+",
                  "6", "5", "4", "-",
                  "1", "2", "3", "*",
                  "0", ".", "=", "/"
      };

      public Calculator() {
            setUI();
            setDefault(this);
      }

      void setUI() {
            setLayout(new BorderLayout());
            p1.setLayout(new GridLayout(5, 4));
            for (int i = 0; i < button.length; i++) {
                  JButton jbt = new JButton(button[i]);
                  p1.add(jbt);
                  jbt.addActionListener(spy);
            }
            p2.add(p1, BorderLayout.CENTER);
            p2.add(screen, BorderLayout.NORTH);
            screen.setHorizontalAlignment(JTextField.RIGHT);
            screen.setEditable(false);
            screen.setText("0");
            add(p2);
      }

      String formatNumber(double value) {
            if (value == (long) value) {
                  return String.valueOf((long) value);
            } else {
                  return String.valueOf(value);
            }
      }

      class Listener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                  String cmd = e.getActionCommand();

                  if (screen.getText().equals("Error") && !cmd.equals("C")) {
                        return;
                  }

                  if (cmd.equals("C")) {
                        screen.setText("0");
                        num1 = 0;
                        operator = "";
                        isNewNumber = true;

                  } else if (cmd.equals("√")) {
                        double value = Double.parseDouble(screen.getText());
                        screen.setText(formatNumber(Math.sqrt(value)));
                        isNewNumber = true;

                  } else if (cmd.equals("x^2")) {
                        double value = Double.parseDouble(screen.getText());
                        screen.setText(formatNumber(value * value));
                        isNewNumber = true;

                  } else if (cmd.equals("+/-")) {
                        double value = Double.parseDouble(screen.getText());
                        screen.setText(formatNumber(-value));

                  } else if (cmd.equals("+") || cmd.equals("-")
                              || cmd.equals("*") || cmd.equals("/")) {
                        num1 = Double.parseDouble(screen.getText());
                        operator = cmd;

                        isNewNumber = true;

                  } else if (cmd.equals("=")) {
                        if (!operator.isEmpty()) {
                              double num2 = Double.parseDouble(screen.getText());
                              double result = 0;

                              switch (operator) {
                                    case "+":
                                          result = num1 + num2;
                                          break;
                                    case "-":
                                          result = num1 - num2;
                                          break;
                                    case "*":
                                          result = num1 * num2;
                                          break;
                                    case "/":
                                          if (num2 != 0) {
                                                result = num1 / num2;
                                          } else {
                                                screen.setText("Error");
                                                operator = "";
                                                isNewNumber = true;
                                                return;
                                          }
                                          break;
                              }

                              screen.setText(formatNumber(result));
                              operator = "";
                              isNewNumber = true;
                        }

                  } else if (cmd.equals(".")) {
                        if (isNewNumber) {
                              screen.setText("0.");
                              isNewNumber = false;
                        } else if (!screen.getText().contains(".")) {
                              screen.setText(screen.getText() + cmd);
                        }

                  } else {
                        if (isNewNumber || screen.getText().equals("0")) {
                              screen.setText(cmd);
                              isNewNumber = false;
                        } else {
                              screen.setText(screen.getText() + cmd);
                        }
                  }
            }
      }

      void setDefault(JFrame frame) {
            frame.setTitle("Calculator");
            frame.setSize(300, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
      }

      public static void main(String[] args) {
            new Calculator();
      }
}