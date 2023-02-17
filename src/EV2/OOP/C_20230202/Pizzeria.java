package EV2.OOP.C_20230202;

/**
 * Clase que simula una Pizzería.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Pizzeria {
    private final String nombrePizzeria;
    private final Cliente[] clientes;
    private final Pedidos[] pedidos;
    private static int numClientes;
    private static int numPedidos;
    private final int maxClientes;
    private final int maxPedidos;

    public Pizzeria(String nombrePizzeria, int maxClientes, int maxPedidos) {
        this.nombrePizzeria = nombrePizzeria;
        this.maxClientes = maxClientes;
        this.maxPedidos = maxPedidos;
        clientes = new Cliente[maxClientes];
        pedidos = new Pedidos[maxPedidos];
    }

    public int getNumClientes() {
        return numClientes;
    }

    public int getNumPedidos() {
        return numPedidos;
    }

    public int getMaxClientes() {
        return maxClientes;
    }

    public int getMaxPedidos() {
        return maxPedidos;
    }

    public boolean addCliente(String nombre, String apellidos, String dir, String tel) {
        if (numClientes < maxClientes) {
            Cliente cliente = new Cliente(nombre, apellidos, dir, tel);
            clientes[numClientes] = cliente;
            numClientes++;
            return true;
        }
        return false;
    }

    public boolean addPedido(int posicionCliente, String size, String type) {
        if (numPedidos < maxPedidos) {
            Cliente cliente = clientes[posicionCliente];
            Pedidos pedido = new Pedidos(cliente, size, type);
            pedidos[numPedidos] = pedido;
            System.out.println("\nPedido añadido: \n" + pedido);
            numPedidos++;
            return true;
        } else if (posicionCliente < 0 || posicionCliente >= numClientes) {
            System.out.println("Error: El cliente no existe.");
            return false;
        }else{
            System.out.println("Error: No se pueden añadir más pedidos.");
            return false;
        }
    }

    public boolean pedidoServido(int posicionPedido){
        if(posicionPedido < 0 || posicionPedido >= numPedidos){
            System.out.println("Error: El pedido no existe.");
            return false;
        }
        return pedidos[posicionPedido].servirPedido();
    }

    public String clientesToString(){
        StringBuilder clientesString = new StringBuilder("Clientes: ");
        for (int i = 0; i < numClientes; i++) {
            clientesString.append(clientes[i].toString());
        }
        return clientesString.toString();
    }

    @Override
    public String toString() {
        return "Pizzeria: \n\tNombre: " + nombrePizzeria + "\n\tClientes: " + numClientes + "\n\tPedidos: " + numPedidos + "\n";
    }

}
