package EV2.OOP.C_20230201;

import java.util.Scanner;

public class EjemploReferenciasPerro {
  public static void main(String[] args) {
    Perro milu = new Perro("Milu", 94, "grand fox terrier");
    Perro lassie = new Perro("Lassie", 85, "collie");

    Perro referenciaPerro = null;
    Scanner scan_in = new Scanner(System.in);

    System.out.println("\n===> EjemploReferenciasPerro\n");
    System.out.println(">> Vamos a jugar con referenciaPerro:");
    System.out.println("# milu:            " + milu);
    System.out.println("# lassie:          " + lassie);
    System.out.println("# referenciaPerro: " + referenciaPerro);
    
    System.out.println("Pulsa ENTER para continuar...");
    scan_in.nextLine();
    System.out.println(">> referenciaPerro = milu;");
    referenciaPerro = milu;
    System.out.println("# milu:            " + milu);
    System.out.println("# lassie:          " + lassie);
    System.out.println("# referenciaPerro: " + referenciaPerro);

    System.out.println("Pulsa ENTER para continuar...");
    scan_in.nextLine();
    System.out.println(">> referenciaPerro.edad = 20;");
    referenciaPerro.edad = 20;
    System.out.println("# milu:            " + milu);
    System.out.println("# lassie:          " + lassie);
    System.out.println("# referenciaPerro: " + referenciaPerro);

    System.out.println("Pulsa ENTER para continuar...");
    scan_in.nextLine();
    System.out.println(">> referenciaPerro = lassie;");
    referenciaPerro = lassie;
    System.out.println("# milu:            " + milu);
    System.out.println("# lassie:          " + lassie);
    System.out.println("# referenciaPerro: " + referenciaPerro);


    System.out.println("Pulsa ENTER para continuar...");
    scan_in.nextLine();
    System.out.println(">> referenciaPerro.nombre = \"LASSIE\";");
    referenciaPerro.nombre = "LASSIE";
    System.out.println("# milu:            " + milu);
    System.out.println("# lassie:          " + lassie);
    System.out.println("# referenciaPerro: " + referenciaPerro);

    System.out.println("Pulsa ENTER para continuar...");
    scan_in.nextLine();

    System.out.println(">> RIZANDO EL RIZO: vamos a intercambiar las referencias para "
                       + "que milu haga referencia al objeto lassie y lassie haga "
                       + "referencia al objeto lassie:");
    System.out.println(">>");
    System.out.println(">> referenciaPerro = milu;");
    System.out.println(">> milu = lassie;");
    System.out.println(">> lassie = referenciaPerro;");

    referenciaPerro = milu;
    milu = lassie;
    lassie = referenciaPerro;
    referenciaPerro = null;
    
    System.out.println("# milu:            " + milu);
    System.out.println("# lassie:          " + lassie);
    System.out.println("# referenciaPerro: " + referenciaPerro);
    scan_in.close();
    System.out.println("\n===> Bye, bye\n");
  }

}