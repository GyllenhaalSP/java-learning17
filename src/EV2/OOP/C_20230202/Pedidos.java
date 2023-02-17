package EV2.OOP.C_20230202;

/**
 * Clase que simula un Pedido.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Pedidos {
    private final Cliente cliente;
    private final Pizza pizza;
    private final int pedidoNumObj;
    private static int pedidoNum = 0;

    public Pedidos(Cliente cliente, String size, String type) {
        this.cliente = cliente;
        this.pizza =  new Pizza(size, type);
        pedidoNum++;
        this.pedidoNumObj = pedidoNum+1;
    }

    public boolean pedidoServido(){
        if(pizza == null){
            System.out.println("Error: Este pedido es nulo. Pedido: " + this);
            return false;
        }
        return pizza.servida();
    }

    public boolean servirPedido(){
        if(pizza == null){
            System.out.println("Error: Este pedido es nulo. Pedido: " + this);
            return false;
        }
        return pizza.servirPizza();
    }

    @Override
    public String toString() {
        return "Pedido: {\nCliente: " + cliente + "\nPizza:" + pizza + "\nPedido número: " + pedidoNumObj + " }";
    }


}
