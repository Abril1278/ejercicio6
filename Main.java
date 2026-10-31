import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame("Dashboard");

            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(850, 500);
            ventana.setLocationRelativeTo(null);

            JPanel contenedor = new JPanel(
                new GridLayout(0, 2, 15, 15)
            );

            contenedor.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
            );

            List<Widget> widgets = new ArrayList<>();

            widgets.add(new WeatherWidget(
                1, "Clima", 40, 24, "Guatemala"
            ));

            widgets.add(new ClockWidget());
            widgets.add(new TaskWidget());

            widgets.add(new AlertWidget(
                "Hay una entrega pendiente", "Alta"
            ));

            widgets.add(new QuoteWidget());

            for (Widget widget : widgets) {
                JComponent vista = widget.obtenerVista();

                vista.setBorder(
                    BorderFactory.createTitledBorder(
                        widget.getNombre()
                    )
                );

                contenedor.add(vista);
            }

            ventana.add(contenedor);
            ventana.setVisible(true);
        });
    }
}