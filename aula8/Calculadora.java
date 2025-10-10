import javax.swing.*;
import java.awt.event.*;

public class Calculadora extends JFrame {
  public Calculadora() {
    setTitle("Calculadora");
    setSize(300, 250);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

    JLabel lblNum1 = new JLabel("Numero 1:");
    lblNum1.setBounds(30, 30, 80, 20);
    add(lblNum1);

    JTextField txtNum1 = new JTextField();
    txtNum1.setBounds(120, 30, 120, 20);
    add(txtNum1);

    JLabel lblNum2 = new JLabel("Numero 2:");
    lblNum2.setBounds(30, 70, 80, 20);
    add(lblNum2);

    JTextField txtNum2 = new JTextField();
    txtNum2.setBounds(120, 70, 120, 20);
    add(txtNum2);

    String[] operacoes = { "Somar", "Subtrair", "Multiplicar", "Dividir" };
    JComboBox<String> cbOperacao = new JComboBox<>(operacoes);
    cbOperacao.setBounds(80, 110, 120, 25);
    add(cbOperacao);

    JCheckBox chkMensagem = new JCheckBox("Mostrar em JOptionPane");
    chkMensagem.setBounds(50, 140, 200, 25);
    add(chkMensagem);

    JButton btnCalcular = new JButton("Calcular");
    btnCalcular.setBounds(90, 170, 100, 25);
    add(btnCalcular);

    btnCalcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          double n1 = Double.parseDouble(txtNum1.getText());
          double n2 = Double.parseDouble(txtNum2.getText());
          double resultado = 0;

          String op = (String) cbOperacao.getSelectedItem();
          if (op.equals("Somar"))
            resultado = n1 + n2;
          else if (op.equals("Subtrair"))
            resultado = n1 - n2;
          else if (op.equals("Multiplicar"))
            resultado = n1 * n2;
          else if (op.equals("Dividir"))
            resultado = n2 != 0 ? n1 / n2 : Double.NaN;

          if (chkMensagem.isSelected()) {
            JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
          } else {
            System.out.println("Resultado: " + resultado);
          }
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(null, "Digite numeros validos.");
        }
      }
    });

    setVisible(true);
  }

  public static void main(String[] args) {
    new Calculadora();
  }
}
