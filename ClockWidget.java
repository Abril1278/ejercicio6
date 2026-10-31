import java.awt.BorderLayout;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ClockWidget implements Widget {

    private JPanel panel;
    private JLabel etiqueta;
    private Timer temporizador;

    public ClockWidget() {
        panel = new JPanel(new BorderLayout());
        etiqueta = new JLabel();

        panel.add(etiqueta, BorderLayout.CENTER);

        renderizar();

        // Actualizar la hora cada segundo.
        temporizador = new Timer(1000, e -> renderizar());
        temporizador.start();
    }

    @Override
    public void renderizar() {
        String hora = LocalTime.now().format(
            DateTimeFormatter.ofPattern("HH:mm:ss")
        );

        etiqueta.setText("Hora actual: " + hora);
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    @Override
    public int getId() {
        return 5;
    }

    @Override
    public String getNombre() {
        return "ClockWidget";
    }

    @Override
    public double getMemoria() {
        return 20;
    }
}