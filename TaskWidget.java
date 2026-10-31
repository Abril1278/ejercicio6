public class TaskWidget implements Widget, IInteractivo {

    private String tarea;

    public TaskWidget() {
        tarea = "Estudiar UML";
    }

    @Override
    public void renderizar() {
        System.out.println("Tarea: " + tarea);
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

    @Override
    public void click() {
        tarea = "Completada";
    }
}
