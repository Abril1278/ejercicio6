import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlertWidget implements Widget, IInteractivo {

    private String mensaje;
    private String prioridad;
    private boolean leida;

    private JPanel panel;
    private JLabel etiqueta;
    private JButton boton;

    public AlertWidget(String mensaje, String prioridad) {
        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.leida = false;

        panel = new JPanel(new BorderLayout());
        etiqueta = new JLabel();
        boton = new JButton("Marcar como leída");

        panel.add(etiqueta, BorderLayout.CENTER);
        panel.add(boton, BorderLayout.SOUTH);

        boton.addActionListener(e -> click());

        renderizar();
    }

    @Override
    public void renderizar() {
        etiqueta.setText(
            "<html>Alerta: " + mensaje
            + "<br>Prioridad: " + prioridad
            + "<br>Estado: " + (leida ? "Leída" : "Pendiente")
            + "</html>"
        );

        boton.setEnabled(!leida);
    }

    @Override
    public void click() {
        leida = true;
        renderizar();
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public String getNombre() {
        return "AlertWidget";
    }

    @Override
    public double getMemoria() {
        return 30;
    }
}