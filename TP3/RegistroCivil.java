import java.util.Scanner;

/**
 * Clase ejecutable que simula un Registro Civil.
 * Permite al usuario registrar un Hombre o una Mujer y realizar operaciones
 * como casarse, divorciarse y consultar datos a través de un menú interactivo.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class RegistroCivil
{
    /**
     * Método principal que inicia la simulación del registro civil.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        System.out.println("Bienvenido al Registro Civil");
        System.out.println("¿Desea registrarse como Hombre o como Mujer?\n");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Hombre");
        System.out.println("2. Mujer");
        
        int opcion = teclado.nextInt();

        if (opcion == 1) {
            System.out.println("Ingrese su nombre:");
            String nombre = teclado.next();
            System.out.println("Ingrese su apellido:");
            String apellido = teclado.next();
            System.out.println("Ingrese su edad:");
            int edad = teclado.nextInt();
            Hombre hombre = new Hombre(nombre, apellido, edad);

            int op;
            do {
                System.out.println("\n--- Menú Hombre ---\n");
                System.out.println("Seleccione una opción: ");
                System.out.println("1. Casarse");
                System.out.println("2. Mostrar estado civil");
                System.out.println("3. Mostrar con quién está casado");
                System.out.println("4. Divorciarse");
                System.out.println("5. Mostrar datos");
                System.out.println("6. Salir");
                
                op = teclado.nextInt();

                switch(op) {
                    case 1:
                        System.out.println("Ingrese el nombre de la mujer con la que desea casarse:");
                        String nombreMujer = teclado.next();
                        System.out.println("Ingrese el apellido de la mujer con la que desea casarse:");
                        String apellidoMujer = teclado.next();
                        System.out.println("Ingrese la edad de la mujer con la que desea casarse:");
                        int edadMujer = teclado.nextInt();
                        Mujer mujer = new Mujer(nombreMujer, apellidoMujer, edadMujer);

                        hombre.casarseCon(mujer);
                        break;
                    case 2:
                        hombre.mostrarEstadoCivil();
                        break;
                    case 3:
                        hombre.casadoCon();
                        break;
                    case 4:
                        hombre.divorcio();
                        System.out.println("Ahora está divorciado.");
                        break;
                    case 5:
                        System.out.println(hombre.datos());
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } while(op != 6);

        } else if (opcion == 2) {
            System.out.println("Ingrese su nombre:");
            String nombre = teclado.next();
            System.out.println("Ingrese su apellido:");
            String apellido = teclado.next();
            System.out.println("Ingrese su edad:");
            int edad = teclado.nextInt();
            Mujer mujer = new Mujer(nombre, apellido, edad);

            int op;
            do {
                System.out.println("\n--- Menú Mujer ---\n");
                System.out.println("Seleccione una opción: ");
                System.out.println("1. Casarse");
                System.out.println("2. Mostrar estado civil");
                System.out.println("3. Mostrar con quién está casado");
                System.out.println("4. Divorciarse");
                System.out.println("5. Mostrar datos");
                System.out.println("6. Salir");
                
                op = teclado.nextInt();

                switch(op) {
                    case 1:
                        System.out.println("Ingrese el nombre del hombre con el que desea casarse:");
                        String nombreHombre = teclado.next();
                        System.out.println("Ingrese el apellido del hombre con el que desea casarse:");
                        String apellidoHombre = teclado.next();
                        System.out.println("Ingrese la edad del hombre con el que desea casarse:");
                        int edadHombre = teclado.nextInt();
                        Hombre hombre = new Hombre(nombreHombre, apellidoHombre, edadHombre);

                        mujer.casarseCon(hombre);
                        break;
                    case 2:
                        mujer.mostrarEstadoCivil();
                        break;
                    case 3:
                        mujer.casadoCon();
                        break;
                    case 4:
                        mujer.divorcio();
                        System.out.println("Ahora está divorciada.");
                        break;
                    case 5:
                        System.out.println(mujer.datos());
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } while(op != 6);

        } else {
            System.out.println("Opción inválida. Saliendo.");
        }
    }
}
