## Ejercicio Pizzería
Vamos a implementar el sistema de gestión de una Pizzería. El sistema va a permitir registrar los clientes con sus datos. También nos va a permitir crear pedidos. Cada pedido tendrá asociado un cliente y una pizza.

La guía para la implementación es la siguiente:

* Todos los atributos de las clases deben ser privados.
* Crea la clase Pizzeria, Pedido, Cliente y Pizza con los atributos y métodos necesarios.
* La clase Cliente debe almacenar el nombre, apellidos, dirección y teléfono de cada cliente.
* La clase Pizza necesita almacenar el tamaño (mediana o familiar), el tipo (margarita, cuatro quesos o funghi) y su estado (pedida o servida). Siempre que se crea una pizza nueva, su estado es “pedida”. La clase Pizza también debe almacenar información sobre el número total de pizzas que se han pedido y que se han servido.
* La clase Pedido debe almacenar una Pizza y un Cliente.
* La clase Pizzeria almacenará un nombre, un array de Cliente de tamaño 5 y un array de Pedido de tamaño 5.

**Pista**: Hará falta añadir más atributos en algunas clases.

* Crea una clase MainPizzeria, que contendrá el método main, que pida introducir el nombre de la pizzería, cree una instancia de Pizzeria y ofrezca un menú por teclado que permita:

  1. *Imprimir detalles*: Imprime toda la información de la pizzeria: Nombre de pizzeria, lista de clientes, total de pizzas pedidas, total de pizzas servidas y lista de pedidos. **Pista**: se recomienda implementar los métodos toString() de las clases para facilitar la impresión.
  2. *Añadir Cliente*: Habrá que comprobar si queda hueco en el array de tamaño 5 para añadir otro cliente. Si no queda hueco, se mostrará un mensaje de aviso y se volverá a mostrar el menú. Si hay hueco se pedirán todos los datos del cliente por teclado para crear la nueva instancia de Cliente.
  3. *Crear Pedido*: Habrá que comprobar si queda hueco en el array de tamaño 5 para añadir otro pedido. Si no queda hueco, se mostrará un mensaje de aviso y se volverá a mostrar el menúprincipal. Si hay hueco se mostrará la lista de clientes y se pedirá introducir el número (posición en el array) del Cliente. Después se pedirán los datos necesarios para crear la pizza (tamaño y tipo).
  4. *Servir Pedido*: Se mostrará un listado de los pedidos y se pedirá introducir el número (posición en el array) del Pedido. El estado de la pizza de ese pedido pasará de "pedida" a "servida". Si ya estaba servida, se mostrará un mensaje de aviso indicando que ese pedido ya ha sido servido y se volverá a mostrar el menú principal.
  5. *Salir*: Se imprimirá toda la información sobre la pizzería, como en el caso 1, y se saldrá del programa. 

**Pista**: Todos los métodos a los que se llamará desde el main serán de la clase Pizzeria. La clase Pizzería, internamente, utilizará las clases Cliente, Pizza y Pedido.
