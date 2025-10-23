import java.util.Scanner;

/**
 * Clase ejecutable que simula la interfaz de un comercio de electrodomésticos.
 * Permite al usuario seleccionar y cotizar diferentes artefactos del hogar como
 * cocinas, heladeras y lavarropas, calculando el valor de las cuotas
 * con y sin cargos adicionales.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Comercio {
    /**
     * Punto de entrada principal para la aplicación del comercio.
     * Gestiona la interacción con el usuario a través de un menú para seleccionar
     * productos, visualizar sus características y calcular planes de pago.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cocina cocina1 = new Cocina("Volcan", 600, 15, 4, 2000, "80*60*60cm");
        Cocina cocina2 = new Cocina("Volcan", 800, 20, 6, 4000, "100*80*80cm");

        Heladera heladera1 = new Heladera("Gafa", 1200, 8, 11, 2, true);
        Heladera heladera2 = new Heladera("Gafa", 1000, 8, 11, 2, false);

        Lavarropas lavarropa1 = new Lavarropas("Volcan", 900, 7, 3, 50, true);
        Lavarropas lavarropa2 = new Lavarropas("Volcan", 700, 5, 1, 45, false);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n*****Bienvenido*****");
            System.out.println("Que desea comprar: \n" +
                    "1-Cocina \n" +
                    "2-Heladera \n" +
                    "3-Lavarropa \n" +
                    "4-Salir");
            System.out.print("Ingrese opcion: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Cocinas:");
                    System.out.println("1- Cocina 1:");
                    cocina1.imprimir();
                    System.out.println("2- Cocina 2:");
                    cocina2.imprimir();
                    int opcion1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("En cuantas cuotas:");
                    int cuotas1 = Integer.parseInt(scanner.nextLine());

                    if (opcion1 == 1) {
                        cocina1.imprimir();
                        System.out.println("Cuotas: " + cuotas1 + " - Interes: 2.53%");
                        System.out.println("Valor cuota: " + cocina1.cuotaCredito(cuotas1, 2.53f));
                        System.out.println("Valor Cuota Con Adicionales: " + cocina1.creditoConAdicional(cuotas1, 2.53f));
                    } else {
                        cocina2.imprimir();
                        System.out.println("Cuotas: " + cuotas1 + " - Interes: 2.53%");
                        System.out.println("Valor cuota: " + cocina2.cuotaCredito(cuotas1, 2.53f));
                        System.out.println("Valor Cuota Con Adicionales: " + cocina2.creditoConAdicional(cuotas1, 2.53f));
                    }
                    break;

                case 2:
                    System.out.println("Heladeras:");
                    System.out.println("1- Heladera 1:");
                    heladera1.imprimir();
                    System.out.println("2- Heladera 2:");
                    heladera2.imprimir();
                    int opcion2 = Integer.parseInt(scanner.nextLine());
                    System.out.println("En cuantas cuotas:");
                    int cuotas2 = Integer.parseInt(scanner.nextLine());

                    if (opcion2 == 1) {
                        heladera1.imprimir();
                        System.out.println("Cuotas: " + cuotas2 + " - Interes: 2.53%");
                        System.out.println("Valor cuota: " + heladera1.cuotaCredito(cuotas2, 2.53f));
                        System.out.println("Valor Cuota Con Adicionales: " + heladera1.creditoConAdicional(cuotas2, 2.53f));
                    } else {
                        heladera2.imprimir();
                        System.out.println("Cuotas: " + cuotas2 + " - Interes: 2.53%");
                        System.out.println("Valor cuota: " + heladera2.cuotaCredito(cuotas2, 2.53f));
                        System.out.println("Valor Cuota Con Adicionales: " + heladera2.creditoConAdicional(cuotas2, 2.53f));
                    }
                    break;

                case 3:
                    System.out.println("Lavarropas:");
                    System.out.println("1- Lavarropa 1:");
                    lavarropa1.imprimir();
                    System.out.println("2- Lavarropa 2:");
                    lavarropa2.imprimir();
                    int opcion3 = Integer.parseInt(scanner.nextLine());
                    System.out.println("En cuantas cuotas:");
                    int cuotas3 = Integer.parseInt(scanner.nextLine());

                    if (opcion3 == 1) {
                        lavarropa1.imprimir();
                        System.out.println("Cuotas: " + cuotas3 + " - Interes: 2.53%");
                        System.out.println("Valor cuota: " + lavarropa1.cuotaCredito(cuotas3, 2.53f));
                        System.out.println("Valor Cuota Con Adicionales: " + lavarropa1.creditoConAdicional(cuotas3, 2.53f));
                    } else {
                        lavarropa2.imprimir();
                        System.out.println("Cuotas: " + cuotas3 + " - Interes: 2.53%");
                        System.out.println("Valor cuota: " + lavarropa2.cuotaCredito(cuotas3, 2.53f));
                        System.out.println("Valor Cuota Con Adicionales: " + lavarropa2.creditoConAdicional(cuotas3, 2.53f));
                    }
                    break;

                case 4:
                    salir = true;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }
}

