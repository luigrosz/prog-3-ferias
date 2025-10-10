import javax.swing.*;
import java.awt.event.*;

public class JanelaLogin extends JFrame {
  public JanelaLogin() {
    setTitle("Tela de Login");
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

    JLabel lblUsuario = new JLabel("Usuario:");
    lblUsuario.setBounds(30, 30, 80, 20);
    add(lblUsuario);

    JTextField txtUsuario = new JTextField();
    txtUsuario.setBounds(110, 30, 140, 20);
    add(txtUsuario);

    JLabel lblSenha = new JLabel("Senha:");
    lblSenha.setBounds(30, 70, 80, 20);
    add(lblSenha);

    JPasswordField txtSenha = new JPasswordField();
    txtSenha.setBounds(110, 70, 140, 20);
    add(txtSenha);

    JButton btnEntrar = new JButton("Entrar");
    btnEntrar.setBounds(90, 110, 100, 25);
    add(btnEntrar);

    btnEntrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String usuario = txtUsuario.getText();
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + usuario + "!");
      }
    });

    setVisible(true);
  }

  public static void main(String[] args) {
    new JanelaLogin();
  }
}
