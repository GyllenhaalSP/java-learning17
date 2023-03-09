package EV2.OOP.C_20230309;

public class Ternarias {
    public static void main(String[] args) {
        int[] arrayPrecios = {50, 99, 100, 200};
        for (int i = 0; i < 4; i++) {
            System.out.println("Precio: "
                    + (arrayPrecios[i] < 100 ? arrayPrecios[i] : String.format("%.2f", arrayPrecios[i] / 100.0))
                    + ((arrayPrecios[i] > 99 ? arrayPrecios[i] == 100 ? " euro" : " euros" : " céntimos")));
        }

        System.out.println("---------------------------");

        for (int i = 0; i < 4; i++) {
            if (arrayPrecios[i] < 100){
                System.out.println("Precio: " + arrayPrecios[i] + " céntimos");
            }else if (arrayPrecios[i] == 100){
                System.out.println("Precio: " + String.format("%.2f", arrayPrecios[i] / 100.0) + " euro");
            }else{
                System.out.println("Precio: " + String.format("%.2f", arrayPrecios[i] / 100.0) + " euros");
            }
        }
    }
}
