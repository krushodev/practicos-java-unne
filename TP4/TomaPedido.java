import java.util.Scanner;
import java.util.*;

/**
 * Clase ejecutable que simula una interfaz de consola para un sistema de toma de pedidos.
 * El flujo principal incluye la creación de un cliente, la presentación de un menú
 * de opciones para interactuar con un pedido, y la gestión de la adición de productos.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class TomaPedido {
    /**
     * Punto de entrada principal para la aplicación de toma de pedidos.
     * Inicializa los datos de prueba (laboratorio, productos), gestiona
     * la creación del cliente y el pedido, y procesa las opciones del menú
     * seleccionadas por el usuario.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Laboratorio lab = new Laboratorio("LabTech", "Av. Cazadores", "1234-5678");

        Producto producto1 = new Producto(1, "Tecnología", "Pendrive", 9702.68, lab);
        Producto producto2 = new Producto(2, "Libros", "Libro-POO", 9330.36, lab);
        Producto producto3 = new Producto(3, "Revistas", "Revista-user", 5205.36, lab);

        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        int opcion = 0;
        Cliente clienteActual = null;

        System.out.println("------ BIENVENIDO AL SISTEMA DE TOMA DE PEDIDOS ------");
        System.out.println("\nPrimero debe agregar un cliente:");
        System.out.print("Ingrese el DNI del cliente: ");
        int dni = teclado.nextInt();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = teclado.next();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el saldo inicial del cliente: ");
        double saldo = teclado.nextDouble();
        clienteActual = new Cliente(dni, apellido, nombre, saldo);

        System.out.println("\nCliente agregado correctamente: " + clienteActual.nomYApe());
        Pedido pedido = new Pedido(Calendar.getInstance(), clienteActual, new ArrayList<Producto>());

        do {
            System.out.println("\n--- Menú de Toma de Pedido ---");
            System.out.println("1. Ver productos disponibles");
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Ver resumen del pedido");
            System.out.println("4. Ver datos del cliente");
            System.out.println("5. Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nProductos disponibles:");
                    System.out.println("1. " + producto1.getDescripcion() + " - " + producto1.precioLista() + " - " + producto1.precioContado());
                    System.out.println("2. " + producto2.getDescripcion() + " - " + producto2.precioLista() + " - " + producto2.precioContado());
                    System.out.println("3. " + producto3.getDescripcion() + " - " + producto3.precioLista() + " - " + producto3.precioContado());    
                    break;
                case 2:
                    System.out.println("\nSeleccione el número de producto que desea agregar al pedido:");
                    System.out.println("1. " + producto1.getDescripcion() + " - " + producto1.precioLista() + " - " + producto1.precioContado());
                    System.out.println("2. " + producto2.getDescripcion() + " - " + producto2.precioLista() + " - " + producto2.precioContado());
                    System.out.println("3. " + producto3.getDescripcion() + " - " + producto3.precioLista() + " - " + producto3.precioContado());
                    System.out.print("Ingrese el número de producto: ");
                    int prodSeleccionado = teclado.nextInt();
                    Producto productoElegido = null;

                    switch (prodSeleccionado) {
                        case 1:
                            productoElegido = producto1;
                            break;
                        case 2:
                            productoElegido = producto2;
                            break;
                        case 3:
                            productoElegido = producto3;
                            break;
                        default:
                            System.out.println("Producto inválido.");
                            break;
                    }

                    if (productoElegido.precioLista() > clienteActual.getSaldo()) {
                        System.out.println("Saldo insuficiente.");
                        break;
                    }


                    if (productoElegido != null) {
                        boolean fueAgregado = pedido.agregarProducto(productoElegido);
                        if (fueAgregado) {
                            System.out.println("Producto agregado al pedido correctamente.");
                        } else {
                            System.out.println("No se pudo agregar el producto al pedido");
                        }
                    }
                case 3:
                    pedido.mostrarPedido();
                    break;

                case 4:
                    System.out.println("\n--- Datos del Cliente ---");
                    clienteActual.mostrar();
                    break;
                case 5:
                    System.out.println("Pedido finalizado");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}

