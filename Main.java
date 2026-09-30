import javax.swing.SwingUtilities;
import src.SistemaController;
import src.view.TelaPrincipal;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaController sistema = new SistemaController();
            new TelaPrincipal(sistema).setVisible(true);
        });
    }
}
