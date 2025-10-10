import javax.swing.*;
import java.awt.event.*;

public class JanelaBoasVindas extends JFrame {
  public JanelaBoasVindas() {
    setTitle("Bem-vindo!");
    setSize(300, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

    JLabel lbl = new JLabel("Seja bem-vindo ao programa!");
    lbl.setBounds(50, 30, 200, 20);
    add(lbl);

    JButton btnFechar = new JButton("Fechar");
    btnFechar.setBounds(100, 70, 100, 30);
    add(btnFechar);

    btnFechar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });

    setVisible(true);
  }

  public static void main(String[] args) {
    new JanelaBoasVindas();
  }
}
