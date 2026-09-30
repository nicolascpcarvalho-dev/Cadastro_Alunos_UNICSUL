package src.view;

import src.SistemaController;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class TelaBusca extends JFrame {
    private final SistemaController sistema;
    private final JTextField campoNome;
    private final JLabel resultado;

    public TelaBusca(SistemaController sistema) {
        this.sistema = sistema;

        setTitle("Localizar Aluno");
        setSize(500, 230);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        campoNome = new JTextField(25);
        JButton botaoBuscar = new JButton("Buscar");
        resultado = new JLabel(" ");
        resultado.setBorder(BorderFactory.createTitledBorder("Resultado"));

        botaoBuscar.addActionListener(e -> buscar());

        JPanelBusca painel = new JPanelBusca();
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painel.add(new JLabel("Nome do aluno:"));
        painel.add(campoNome);
        painel.add(botaoBuscar);

        setLayout(new BorderLayout(10, 10));
        add(painel, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);

        getRootPane().setDefaultButton(botaoBuscar);
    }

    private void buscar() {
        String nome = campoNome.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do aluno.", "Atenção", JOptionPane.WARNING_MESSAGE);
            campoNome.requestFocus();
            return;
        }

        String campus = sistema.localizarAluno(nome);

        if (campus == null) {
            resultado.setText("Aluno não localizado.");
        } else {
            resultado.setText("Aluno encontrado: " + nome + " | Campus: " + campus);
        }
    }

    private static class JPanelBusca extends javax.swing.JPanel {
        JPanelBusca() {
            super(new FlowLayout(FlowLayout.CENTER, 8, 8));
        }
    }
}
