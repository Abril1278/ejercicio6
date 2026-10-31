import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TaskWidget implements Widget, IInteractivo {

    private List<String> tareas;
    private int completadas;

    private JPanel panel;
    private JLabel etiqueta;
    private JButton boton;

    public TaskWidget() {
        tareas = new ArrayList<>();
        tareas.add("Estudiar UML");
        tareas.add("Programar interfaces");

        completadas = 0;

        panel = new JPanel(new BorderLayout());
        etiqueta = new JLabel();
        boton = new JButton("Completar siguiente tarea");

        panel.add(etiqueta, BorderLayout.CENTER);
        panel.add(boton, BorderLayout.SOUTH);

        boton.addActionListener(e -> click());

        renderizar();
    }

    @Override
    public void renderizar() {
        StringBuilder contenido = new StringBuilder("<html>");

        for (int i = 0; i < tareas.size(); i++) {
            if (i < completadas) {
                contenido.append("[Completada] ");
            } else {
                contenido.append("[Pendiente] ");
            }

            contenido.append(tareas.get(i)).append("<br>");
        }

        contenido.append("</html>");
        etiqueta.setText(contenido.toString());

        boton.setEnabled(completadas < tareas.size());
    }

    @Override
    public void click() {
        if (completadas < tareas.size()) {
            completadas++;
        }

        renderizar();
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public String getNombre() {
        return "TaskWidget";
    }

    @Override
    public double getMemoria() {
        return 50;
    }
}
