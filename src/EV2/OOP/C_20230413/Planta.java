package EV2.OOP.C_20230413;

public abstract class Planta implements SerVivo {

    @Override
    public void nacer() {
        System.out.println("Naciendo...");
    }

    @Override
    public void crecer() {
        System.out.println("Creciendo...");
    }

    @Override
    public void reproducirse() {
        System.out.println("Reproduciéndose...");
    }

    @Override
    public void morir() {
        System.out.println("Muerto");
    }

    public abstract void florecer();
}
