Referencias y Objetos
===

Reutilizamos el ejemplo de la clase Perro del resumen del Tema 6 para explicar la diferencia entre referencias y objetos.
Le hemos hecho las siguientes modificaciones para facilitar la comprensión del ejemplo:
* Además de *nombre*, el atributo *edad* también es *public*.
* Hemos eliminado el método *imprimeDetalles()* y hemos añadido el método *toString()* para permitir imprimir los detalles de los objetos de tipo Perro concatenando las referencias.

Creamos las instancias de Perro milu y lassie, y creamos una referencia a la clase Perro llamada *referenciaPerro* que utilizaremos para demostrar cómo varias referencias pueden apuntar al mismo objeto. También demostraremos que las referencias milu y lassie son diferentes a los objetos, de forma que podemos hacer que lassie apunte al objeto milu y milu apunte al objeto lassie.
