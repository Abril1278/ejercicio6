import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuoteWidget implements Widget {

    private String frase;
    private JPanel panel;
    private JLabel etiqueta;

    public QuoteWidget() {
        frase = "Nunca es tarde para aprender.";

        panel = new JPanel(new BorderLayout());
        etiqueta = new JLabel();

        panel.add(etiqueta, BorderLayout.CENTER);

        renderizar();
    }

    @Override
    public void renderizar() {
        etiqueta.setText("<html>" + frase + "</html>");
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    @Override
    public int getId() {
        return 6;
    }

    @Override
    public String getNombre() {
        return "QuoteWidget";
    }

    @Override
    public double getMemoria() {
        return 15;
    }
}