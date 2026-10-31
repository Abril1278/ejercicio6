public class QuoteWidget implements Widget {

    private String frase = "Nunca es tarde para aprender.";

    @Override
    public void renderizar() {
        System.out.println(frase);
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
