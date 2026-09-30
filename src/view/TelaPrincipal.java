package src.view;

import src.SistemaController;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class TelaPrincipal extends JFrame {
    private final SistemaController sistema;

    public TelaPrincipal(SistemaController sistema) {
        this.sistema = sistema;

        setTitle("Sistema de Controle de Alunos - UNICSUL");
        setSize(550, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel titulo = new JLabel("Sistema de Controle de Alunos", JLabel.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(25, 10, 15, 10));

        JButton cadastrar = new JButton("1 - Cadastrar novo aluno");
        JButton localizar = new JButton("2 - Localizar aluno");
        JButton listar = new JButton("3 - Listar alunos do campus");
        JButton sair = new JButton("4 - Sair");

        cadastrar.addActionListener(e -> new TelaCadastro(sistema).setVisible(true));
        localizar.addActionListener(e -> new TelaBusca(sistema).setVisible(true));
        listar.addActionListener(e -> new TelaListagem(sistema).setVisible(true));
        sair.addActionListener(e -> confirmarSaida());

        JPanel menu = new JPanel(new GridLayout(4, 1, 10, 10));
        menu.setBorder(BorderFactory.createEmptyBorder(10, 80, 25, 80));
        menu.add(cadastrar);
        menu.add(localizar);
        menu.add(listar);
        menu.add(sair);

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(menu, BorderLayout.CENTER);
    }

    private void confirmarSaida() {
        int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente sair?",
            "Sair",
            JOptionPane.YES_NO_OPTION
        );

        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
