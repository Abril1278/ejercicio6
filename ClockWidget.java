import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockWidget implements Widget {

    @Override
    public void renderizar() {
        String hora = LocalTime.now().format(
            DateTimeFormatter.ofPattern("HH:mm:ss")
        );

        System.out.println("Hora actual: " + hora);
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
