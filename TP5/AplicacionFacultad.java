import java.util.Scanner;
import java.util.*;

/**
 * Clase ejecutable que simula una interfaz de consola para la gestión de una Facultad.
 * Provee un menú para la creación de profesores y cargos, así como para la
 * visualización de nóminas y listados detallados.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class AplicacionFacultad {
    /**
     * Punto de entrada principal para la aplicación de gestión de la facultad.
     * Gestiona la interacción con el usuario para crear una facultad,
     * registrar profesores, cargos y mostrar información consolidada.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        ArrayList<Profesor> profesores = new ArrayList<>();
        ArrayList<Cargo> cargos = new ArrayList<>();
        int opcion = 0;

        System.out.println("\n--- Crear Facultad ---");
        System.out.println("Ingrese el nombre de la facultad: ");
        String nombreFacultad = teclado.next();
        Facultad facultad = new Facultad(nombreFacultad, profesores);
        System.out.println("Facultad creada correctamente: " + facultad.getNombre());

        do {
            System.out.println("\n--- Menú de Gestión de Facultad " + facultad.getNombre() + " ---");
            System.out.println("1. Crear profesor");
            System.out.println("2. Crear cargo");
            System.out.println("3. Mostrar profesores");
            System.out.println("4. Mostrar cargos");
            System.out.println("5. Mostrar nomina de profesores");
            System.out.println("6. Mostrar listado de profesores y cargos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    if (cargos.size() == 0) {
                        System.out.println(
                                "No hay cargos registrados. Por favor, cree un cargo antes de crear un profesor.");
                        break;
                    }

                    System.out.println("\n--- Crear Profesor ---");
                    System.out.println("Ingrese el DNI del profesor: ");
                    int dniProfesor = teclado.nextInt();
                    System.out.println("Ingrese el nombre del profesor: ");
                    String nombreProfesor = teclado.next();
                    System.out.println("Ingrese el apellido del profesor: ");
                    String apellidoProfesor = teclado.next();
                    System.out.println("Ingrese la fecha de nacimiento del profesor: ");
                    System.out.println("\t Día: ");
                    int diaProfesor = teclado.nextInt();
                    System.out.println("\t Mes: ");
                    int mesProfesor = teclado.nextInt();
                    System.out.println("\t Año: ");
                    int anioProfesor = teclado.nextInt();
                    Calendar fechaProfesor = new GregorianCalendar(anioProfesor, mesProfesor, diaProfesor);
                    System.out.println("Ingrese el titulo del profesor: ");
                    String tituloProfesor = teclado.next();

                    Cargo[] cargosProfesor = new Cargo[3];

                    System.out.println("Cargos disponibles: ");
                    for (int i = 0; i < cargos.size(); i++) {
                        System.out.println(i + 1 + ": " + cargos.get(i).getNombreCargo());
                    }

                    int contadorCargos = 0;
                    String respuesta;
                    do {
                        System.out.println("Ingrese el numero del cargo que desea asignar al profesor: ");
                        int numeroCargoProfesor = teclado.nextInt();
                        Cargo cargoSeleccionadoProfesor = cargos.get(numeroCargoProfesor - 1);
                        cargosProfesor[contadorCargos] = cargoSeleccionadoProfesor;
                        contadorCargos++;

                        if (contadorCargos < 3) {
                            System.out.println("¿Desea agregar otro cargo al profesor? (s/n): ");
                            respuesta = teclado.next();
                        } else {
                            respuesta = "n"; // Ya tiene 3 cargos
                        }
                    } while (respuesta.equalsIgnoreCase("s") && contadorCargos < 3);

                    Profesor profesor = new Profesor(dniProfesor, nombreProfesor, apellidoProfesor, fechaProfesor,
                            tituloProfesor, cargosProfesor);
                    System.out.println("Profesor creado correctamente: " + profesor.nomYApe());
                    profesores.add(profesor);
                    break;

                case 2:
                    System.out.println("\n--- Crear Cargo ---");
                    System.out.println("Ingrese el nombre del cargo: ");
                    String nombreCargo = teclado.next();
                    System.out.println("Ingrese el sueldo basico del cargo: ");
                    double sueldoBasicoCargo = teclado.nextDouble();
                    System.out.println("Ingrese el año de ingreso al cargo: ");
                    int anioIngresoCargo = teclado.nextInt();
                    System.out.println("Ingrese las horas de docencia del cargo: ");
                    int horasDocenciaCargo = teclado.nextInt();
                    System.out.println("Ingrese el tipo de cargo (1: Exclusivo, 2: SemiExclusivo, 3: Común): ");
                    int tipoCargo = teclado.nextInt();
                    Cargo cargo;
                    if (tipoCargo == 1) {
                        System.out.println("Ingrese las horas de investigacion del cargo: ");
                        int horasInvestigacionCargo = teclado.nextInt();
                        System.out.println("Ingrese las horas de extension del cargo: ");
                        int horasExtensionCargo = teclado.nextInt();
                        cargo = new Exclusivo(nombreCargo, sueldoBasicoCargo, anioIngresoCargo, horasDocenciaCargo,
                                horasInvestigacionCargo, horasExtensionCargo);
                    } else if (tipoCargo == 2) {
                        System.out.println("Ingrese las horas de investigacion del cargo: ");
                        int horasInvestigacionCargo = teclado.nextInt();
                        cargo = new SemiExclusivo(nombreCargo, sueldoBasicoCargo, anioIngresoCargo, horasDocenciaCargo,
                                horasInvestigacionCargo);
                    } else {
                        cargo = new Cargo(nombreCargo, sueldoBasicoCargo, anioIngresoCargo, horasDocenciaCargo);
                    }
                    System.out.println("Cargo creado correctamente: " + cargo.getNombreCargo());
                    cargos.add(cargo);

                case 3:
                    System.out.println("\n--- Mostrar Profesores ---");
                    if (profesores.size() == 0) {
                        System.out.println("No hay profesores registrados.");
                        break;
                    }
                    for (int i = 0; i < profesores.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        profesores.get(i).mostrar();
                    }
                    break;

                case 4:
                    System.out.println("\n--- Mostrar Cargos ---");
                    if (cargos.size() == 0) {
                        System.out.println("No hay cargos registrados.");
                        break;
                    }
                    for (int i = 0; i < cargos.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        cargos.get(i).mostrarCargo();
                    }
                    break;

                case 5:
                    System.out.println("\n--- Mostrar Nomina de Profesores ---");
                    facultad.nominaProfesores();
                    break;

                case 6:
                    System.out.println("\n--- Mostrar Listado de Profesores y Cargos ---");
                    facultad.listarProfesorCargos();
                    break;

                case 7:
                    System.out.println("Has salido del sistema de gestión de profesores y cargos.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 7);
        teclado.close();
    }
}
