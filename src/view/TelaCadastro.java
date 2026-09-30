package src.view;

import src.SistemaController;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class TelaCadastro extends JFrame {
    private final SistemaController sistema;
    private final JTextField campoNome;
    private final JComboBox<String> comboCampus;

    public TelaCadastro(SistemaController sistema) {
        this.sistema = sistema;

        setTitle("Cadastrar Novo Aluno");
        setSize(500, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        campoNome = new JTextField(22);
        comboCampus = new JComboBox<>(sistema.getCampi().toArray(new String[0]));
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoCancelar = new JButton("Cancelar");

        botaoCadastrar.addActionListener(e -> cadastrar());
        botaoCancelar.addActionListener(e -> dispose());

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel titulo = new JLabel("Cadastro de aluno");
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(titulo, c);

        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel("Nome do aluno:"), c);

        c.gridx = 1;
        add(campoNome, c);

        c.gridx = 0;
        c.gridy = 2;
        add(new JLabel("Campus:"), c);

        c.gridx = 1;
        add(comboCampus, c);

        c.gridx = 0;
        c.gridy = 3;
        add(botaoCancelar, c);

        c.gridx = 1;
        add(botaoCadastrar, c);

        getRootPane().setDefaultButton(botaoCadastrar);
    }

    private void cadastrar() {
        String nome = campoNome.getText().trim();
        String campus = (String) comboCampus.getSelectedItem();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do aluno.", "Atenção", JOptionPane.WARNING_MESSAGE);
            campoNome.requestFocus();
            return;
        }

        if (sistema.alunoExiste(nome)) {
            JOptionPane.showMessageDialog(
                this,
                "O aluno já está cadastrado em um dos campi.\nO cadastro foi impedido.",
                "Aluno já cadastrado",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        sistema.cadastrarAluno(nome, campus);
        JOptionPane.showMessageDialog(
            this,
            "Aluno cadastrado com sucesso!\nCampus: " + campus,
            "Cadastro realizado",
            JOptionPane.INFORMATION_MESSAGE
        );
        campoNome.setText("");
        campoNome.requestFocus();
    }
}
