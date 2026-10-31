import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeatherWidget implements Widget, IInteractivo {

    private int id;
    private String nombre;
    private double memoria;
    private double temperatura;
    private String ciudad;
    private boolean celsius;

    private JPanel panel;
    private JLabel etiqueta;
    private JButton boton;

    public WeatherWidget(int id, String nombre, double memoria,
                         double temperatura, String ciudad) {

        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.temperatura = temperatura;
        this.ciudad = ciudad;
        this.celsius = true;

        // Construir el panel visual.
        panel = new JPanel(new BorderLayout());

        etiqueta = new JLabel();
        boton = new JButton("Cambiar unidad");

        panel.add(etiqueta, BorderLayout.CENTER);
        panel.add(boton, BorderLayout.SOUTH);

        // El botón llama al método de interacción.
        boton.addActionListener(e -> click());

        renderizar();
    }

    @Override
    public void renderizar() {
        if (celsius) {
            etiqueta.setText(ciudad + ": " + temperatura + " °C");
        } else {
            double temperaturaF = temperatura * 9.0 / 5.0 + 32;
            etiqueta.setText(ciudad + ": " + temperaturaF + " °F");
        }
    }

    @Override
    public void click() {
        celsius = !celsius;
        renderizar();
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getMemoria() {
        return memoria;
    }
}