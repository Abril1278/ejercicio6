public class WeatherWidget implements Widget, IInteractivo {

    private int id;
    private String nombre;
    private double memoria;
    private double temperatura;
    private String ciudad;
    private boolean celsius;

    public WeatherWidget(int id, String nombre, double memoria,
                         double temperatura, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.temperatura = temperatura;
        this.ciudad = ciudad;
        this.celsius = true;
    }

    @Override
    public void renderizar() {
        if (celsius) {
            System.out.println(ciudad + ": " + temperatura + " °C");
        } else {
            double tempF = (temperatura * 9.0 / 5.0) + 32;
            System.out.println(ciudad + ": " + tempF + " °F");
        }
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

    @Override
    public void click() {
        celsius = !celsius;
        System.out.println("Unidad cambiada");
    }
}
