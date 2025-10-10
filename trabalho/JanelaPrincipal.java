import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class JanelaPrincipal extends JFrame {
  private JTextField txtTitulo, txtDescricao, txtCriador, txtBusca, txtNumeroConteudo;
  private JComboBox<String> cbTipo;
  private JTextArea txtArea;
  private GerenciadorItens gerenciador = new GerenciadorItens();

  public JanelaPrincipal() {
    setTitle("Gerenciador de Itens");
    setSize(700, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(10, 10));
    getTitle();

    JPanel painelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
    painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    painelFormulario.add(new JLabel("Titulo:"));
    txtTitulo = new JTextField();
    painelFormulario.add(txtTitulo);
    painelFormulario.setBackground(Color.decode("#648264")); // cor)

    painelFormulario.add(new JLabel("Descricao:"));
    txtDescricao = new JTextField();
    painelFormulario.add(txtDescricao);

    painelFormulario.add(new JLabel("Tipo:"));
    cbTipo = new JComboBox<>(new String[] { "Livro", "Filme" });
    painelFormulario.add(cbTipo);

    JLabel lblCriador = new JLabel("Autor:");
    painelFormulario.add(lblCriador);
    txtCriador = new JTextField();
    painelFormulario.add(txtCriador);

    JLabel lblNumeroConteudo = new JLabel("Numero de paginas:");
    painelFormulario.add(lblNumeroConteudo);
    txtNumeroConteudo = new JTextField();
    painelFormulario.add(txtNumeroConteudo);

    JPanel painelBotoes = new JPanel(new GridLayout(4, 1, 30, 54));
    painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton btnAdicionar = new JButton("Adicionar");
    JButton btnListar = new JButton("Listar");
    JButton btnImportar = new JButton("Importar");
    JButton btnExportar = new JButton("Exportar");
    painelBotoes.add(btnAdicionar);
    painelBotoes.add(btnListar);
    painelBotoes.add(btnExportar);
    painelBotoes.add(btnImportar);
    painelBotoes.setBackground(Color.decode("#648264")); // cor)

    JPanel painelFiltro = new JPanel();
    txtBusca = new JTextField(15);
    JButton btnFiltrar = new JButton("Filtrar");
    painelFiltro.add(new JLabel("Busca:"));
    painelFiltro.add(txtBusca);
    painelFiltro.add(btnFiltrar);

    txtArea = new JTextArea();
    txtArea.setEditable(false);

    add(painelFormulario, BorderLayout.NORTH);
    add(new JScrollPane(txtArea), BorderLayout.CENTER);
    add(painelBotoes, BorderLayout.EAST);
    add(painelFiltro, BorderLayout.SOUTH);

    cbTipo.addActionListener(_ -> {
      String tipo = cbTipo.getSelectedItem().toString();
      lblCriador.setText(tipo.equals("Livro") ? "Autor:" : "Diretor:");
      lblNumeroConteudo.setText(tipo.equals("Livro") ? "Numero de paginas:" : "Duracao (em minutos):");
    });

    btnAdicionar.addActionListener(_ -> {
      try {
        String titulo = txtTitulo.getText();
        String descricao = txtDescricao.getText();
        String criador = txtCriador.getText();
        int numeroConteudo = Integer.parseInt(txtNumeroConteudo.getText());
        LocalDate data = LocalDate.now();

        if (titulo.isEmpty())
          throw new Exception("Titulo vazio");

        Item item;
        if (cbTipo.getSelectedItem().toString().equals("Livro")) {
          item = new Livro(titulo, descricao, data, criador, numeroConteudo);
        } else {
          item = new Filme(titulo, descricao, data, criador, numeroConteudo);
        }

        gerenciador.adicionarItem(item);
        txtTitulo.setText("");
        txtDescricao.setText("");
        txtCriador.setText("");
        txtNumeroConteudo.setText("");
        txtArea.setText("Item adicionado!");
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
      }
    });

    btnListar.addActionListener(_ -> {
      txtArea.setText("");
      List<Item> itens = gerenciador.listarTodos();
      for (Item i : itens) {
        String detalhes = i instanceof Livro ? ((Livro) i).exibirDetalhes()
            : i instanceof Filme ? ((Filme) i).exibirDetalhes() : "";
        txtArea.append(i.getTitulo() + " - " + i.getDescricao() + " (" + detalhes + ")\n");
      }
    });

    btnFiltrar.addActionListener(_ -> {
      txtArea.setText("");
      List<Item> filtrados = gerenciador.buscarPorTitulo(txtBusca.getText());
      for (Item i : filtrados) {
        String detalhes = i instanceof Livro ? ((Livro) i).exibirDetalhes()
            : i instanceof Filme ? ((Filme) i).exibirDetalhes() : "";
        txtArea.append(i.getTitulo() + " - " + i.getDescricao() + " (" + detalhes + ")\n");
      }
    });

    btnExportar.addActionListener(_ -> {
      JFileChooser chooser = new JFileChooser();
      if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        String caminho = chooser.getSelectedFile().getAbsolutePath();
        gerenciador.exportarParaArquivo(caminho);
        txtArea.setText("Itens exportados para: " + caminho);
      }
    });

    btnImportar.addActionListener(_ -> {
      JFileChooser chooser = new JFileChooser();
      if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        String caminho = chooser.getSelectedFile().getAbsolutePath();
        gerenciador.importarDeArquivo(caminho);
        txtArea.setText("Itens importados de: " + caminho);
      }
    });

    setVisible(true);
  }

  public static void main(String[] args) {
    new JanelaPrincipal();
  }
}
