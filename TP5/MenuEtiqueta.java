import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase ejecutable que simula un menú interactivo para la gestión de pedidos de etiquetas.
 * Permite al usuario crear y agregar etiquetas de tipo Común o Premium a un pedido,
 * así como visualizar el estado actual del mismo.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class MenuEtiqueta {
    /**
     * Punto de entrada principal de la aplicación.
     * Inicia un bucle de menú que permite al usuario interactuar con el sistema
     * para crear etiquetas y gestionar un pedido.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Premium etiquetaPremium = new Premium(200, 10);
        Comun etiquetaComun = new Comun(100, 100);
        Renglon unRenglon = new Renglon(7, 200, etiquetaPremium);

        ArrayList<Renglon> listaPedido = new ArrayList<>();
        listaPedido.add(unRenglon);
        Pedido unPedido = new Pedido(listaPedido);

        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nIngrese la opcion que desea realizar");
            System.out.println("1-Crear etiqueta comun \n" +
                    "2-Crear etiqueta premium \n" +
                    "3-Mostrar Pedido \n" +
                    "4-Salir");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el costo de la etiqueta:");
                    double costo = leer.nextDouble();
                    System.out.println("Ingrese el plus de la etiqueta:");
                    double plus = leer.nextDouble();
                    System.out.println("Ingrese la cantidad :");
                    int cantidad = leer.nextInt();

                    Renglon otroRenglon = new Renglon(cantidad, 100, new Comun(costo, plus));
                    unPedido.agregarRenglon(otroRenglon);
                    break;

                case 2:
                    System.out.println("Ingrese el costo de la etiqueta:");
                    double costoEtiqueta = leer.nextDouble();
                    System.out.println("Ingrese la cantidad de colores:");
                    int colores = leer.nextInt();
                    System.out.println("Ingrese la cantidad :");
                    int cantidadEtiquetas = leer.nextInt();

                    Renglon tercerRenglon = new Renglon(cantidadEtiquetas, 200, new Premium(costoEtiqueta, colores));
                    unPedido.agregarRenglon(tercerRenglon);
                    break;

                case 3:
                    unPedido.mostrar();
                    break;

                case 4:
                    opcion = 0; // Se cambia a 0 para salir del bucle
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
        leer.close();
    }
}
