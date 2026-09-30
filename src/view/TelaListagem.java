package src.view;

import src.SistemaController;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

public class TelaListagem extends JFrame {
    private final SistemaController sistema;
    private final JComboBox<String> comboCampus;
    private final DefaultListModel<String> modeloLista;
    private final JLabel titulo;

    public TelaListagem(SistemaController sistema) {
        this.sistema = sistema;

        setTitle("Listar Alunos do Campus");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        comboCampus = new JComboBox<>(sistema.getCampi().toArray(new String[0]));
        JButton botaoListar = new JButton("Listar");
        modeloLista = new DefaultListModel<>();
        JList<String> lista = new JList<>(modeloLista);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        titulo = new JLabel("Selecione um campus e clique em Listar");

        botaoListar.addActionListener(e -> listar());

        javax.swing.JPanel topo = new javax.swing.JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topo.add(new JLabel("Campus:"));
        topo.add(comboCampus);
        topo.add(botaoListar);

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBorder(BorderFactory.createTitledBorder("Alunos em ordem alfabética"));

        setLayout(new BorderLayout(10, 10));
        add(topo, BorderLayout.NORTH);
        add(titulo, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        // Mantém o título acima da lista e permite que a lista ocupe o espaço principal.
        getContentPane().removeAll();
        javax.swing.JPanel centro = new javax.swing.JPanel(new BorderLayout(5, 5));
        centro.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centro.add(titulo, BorderLayout.NORTH);
        centro.add(scroll, BorderLayout.CENTER);
        add(topo, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
    }

    private void listar() {
        String campus = (String) comboCampus.getSelectedItem();
        List<String> alunos = sistema.listarCampus(campus);
        modeloLista.clear();

        for (String aluno : alunos) {
            modeloLista.addElement(aluno);
        }

        titulo.setText("Campus: " + campus + " — " + alunos.size() + " aluno(s)");

        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Não há alunos cadastrados neste campus.",
                "Lista vazia",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
