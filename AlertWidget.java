public class AlertWidget implements Widget, IInteractivo {

    private String mensaje;
    private String prioridad;
    private boolean leida;

    public AlertWidget(String mensaje, String prioridad) {
        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.leida = false;
    }

    @Override
    public void renderizar() {
        System.out.println("Alerta: " + mensaje);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Estado: " + (leida ? "Leída" : "Pendiente"));
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

    @Override
    public void click() {
        leida = true;
        System.out.println("Alerta marcada como leída");
    }
}
