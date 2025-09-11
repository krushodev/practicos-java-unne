import java.util.Scanner;
import java.util.*;

/**
 * Clase ejecutable que provee una interfaz de consola para interactuar con un sistema bancario.
 * Permite la creación y gestión de personas, empleados y cuentas bancarias a través de un menú
 * de opciones dirigido al usuario.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class AplicacionBanco {
    /**
     * Punto de entrada principal para la aplicación de gestión del banco.
     * Inicializa el entorno y procesa las interacciones del usuario con el menú principal.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        Localidad localidad = new Localidad("Saladas", "Corrientes");
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
        ArrayList<Persona> personas = new ArrayList<Persona>();

        Banco banco = new Banco("RIO", localidad, 3, empleados, cuentas);

        int opcion = 0;

        System.out.println("------ BIENVENIDO AL SISTEMA BANCARIO ------");
        System.out.println("Banco: " + banco.getNombre() + " - Sucursal: " + banco.getNroSucursal());
        System.out.println(banco.getLocalidad().mostrar());

        do {
            System.out.println("\n--- Menú del Sistema Bancario ---");
            System.out.println("1. Crear persona");
            System.out.println("2. Crear empleado");
            System.out.println("3. Crear cuenta bancaria");
            System.out.println("4. Operaciones de cuenta (depositar/extraer)");
            System.out.println("5. Listar empleados");
            System.out.println("6. Mostrar resumen del banco");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Crear Persona ---");
                    System.out.print("Ingrese el DNI de la persona: ");
                    int dni = teclado.nextInt();
                    System.out.print("Ingrese el nombre de la persona: ");
                    String nombre = teclado.next();
                    System.out.print("Ingrese el apellido de la persona: ");
                    String apellido = teclado.next();
                    System.out.println("Ingrese la fecha de nacimiento: ");
                    System.out.println("  - Ingrese el día: ");
                    int dia = teclado.nextInt();
                    System.out.println("  - Ingrese el mes (número): ");
                    int mes = teclado.nextInt();
                    System.out.println("  - Ingrese el año: ");
                    int anio = teclado.nextInt();
                    Calendar fechaNacimiento = new GregorianCalendar();
                    fechaNacimiento.set(Calendar.DAY_OF_MONTH, dia);
                    fechaNacimiento.set(Calendar.MONTH, mes - 1);
                    fechaNacimiento.set(Calendar.YEAR, anio);

                    Persona persona = new Persona(dni, nombre, apellido, fechaNacimiento);
                    personas.add(persona);
                    System.out.println("Persona creada correctamente: " + persona.nomYApe());
                    break;
                case 2:
                    System.out.println("\n--- Crear Empleado ---");
                    System.out.print("Ingrese el CUIL del empleado: ");
                    long cuil = teclado.nextLong();
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombreEmp = teclado.next();
                    System.out.print("Ingrese el apellido del empleado: ");
                    String apellidoEmp = teclado.next();
                    System.out.print("Ingrese el sueldo básico: ");
                    double sueldoBasico = 0.0;
                    sueldoBasico = teclado.nextDouble();
                    System.out.print("Ingrese el año de ingreso: ");
                    int anioIngreso = 0;
                    anioIngreso = teclado.nextInt();

                    Empleado empleado = new Empleado(cuil, apellidoEmp, nombreEmp, sueldoBasico, anioIngreso);
                    banco.agregarEmpleado(empleado);
                    System.out.println("Empleado creado correctamente: " + empleado.nomYApe());
                    break;

                case 3:
                    if (personas.isEmpty()) {
                        System.out.println("\nNo hay personas registradas. Debe crear una persona primero.");
                        break;
                    }

                    System.out.println("\n--- Crear Cuenta Bancaria ---");
                    System.out.println("Personas disponibles:");
                    for (int i = 0; i < personas.size(); i++) {
                        System.out.println((i + 1) + ". " + personas.get(i).nomYApe() + " (DNI: "
                                + personas.get(i).getDNI() + ")");
                    }
                    System.out.print("Seleccione el número de persona: ");
                    int indicePersona = 0;
                    indicePersona = teclado.nextInt() - 1;

                    if (indicePersona < 0 || indicePersona >= personas.size()) {
                        System.out.println("Número de persona inválido.");
                        break;
                    }

                    System.out.print("Ingrese el número de cuenta: ");
                    int nroCuenta = 0;
                    nroCuenta = teclado.nextInt();

                    System.out.print("Ingrese el saldo inicial (0 si no tiene): ");
                    double saldoInicial = 0.0;
                    saldoInicial = teclado.nextDouble();

                    CuentaBancaria cuenta = new CuentaBancaria(nroCuenta, personas.get(indicePersona), saldoInicial);
                    banco.agregarCuentaBancaria(cuenta);
                    System.out.println(
                            "Cuenta bancaria creada correctamente para: " + personas.get(indicePersona).nomYApe());
                    break;

                case 4:
                    if (banco.getCuentasBancarias().isEmpty()) {
                        System.out.println("\nNo hay cuentas bancarias registradas.");
                        break;
                    }

                    System.out.println("\n--- Operaciones de Cuenta ---");
                    System.out.println("Cuentas disponibles:");
                    for (int i = 0; i < banco.getCuentasBancarias().size(); i++) {
                        CuentaBancaria cuentaLista = banco.getCuentasBancarias().get(i);
                        System.out.println((i + 1) + ". Cuenta " + cuentaLista.getNroCuenta() + " - " +
                                cuentaLista.getTitular().nomYApe() + " - Saldo: $" + cuentaLista.getSaldo());
                    }
                    System.out.print("Seleccione el número de cuenta: ");
                    int indiceCuenta = 0;
                    indiceCuenta = teclado.nextInt() - 1;

                    if (indiceCuenta < 0 || indiceCuenta >= banco.getCuentasBancarias().size()) {
                        System.out.println("Número de cuenta inválido.");
                        break;
                    }

                    CuentaBancaria cuentaSeleccionada = banco.getCuentasBancarias().get(indiceCuenta);
                    System.out.println("Cuenta seleccionada: " + cuentaSeleccionada.getNroCuenta() +
                            " - " + cuentaSeleccionada.getTitular().nomYApe());
                    System.out.println("Saldo actual: $" + cuentaSeleccionada.getSaldo());

                    System.out.println("\n1. Depositar");
                    System.out.println("2. Extraer");
                    System.out.print("Seleccione la operación: ");
                    int operacion = 0;
                    operacion = teclado.nextInt();

                    System.out.print("Ingrese el monto: ");
                    double monto = 0.0;
                    monto = teclado.nextDouble();

                    if (operacion == 1) {
                        double nuevoSaldo = cuentaSeleccionada.depositar(monto);
                        System.out.println("Depósito realizado. Nuevo saldo: $" + nuevoSaldo);
                    } else if (operacion == 2) {
                        if (monto > cuentaSeleccionada.getSaldo()) {
                            System.out.println("Saldo insuficiente para realizar la extracción.");
                        } else {
                            double nuevoSaldo = cuentaSeleccionada.extraer(monto);
                            System.out.println("Extracción realizada. Nuevo saldo: $" + nuevoSaldo);
                        }
                    } else {
                        System.out.println("Operación inválida.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Lista de Empleados ---");
                    if (banco.getEmpleados().isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                    } else {
                        banco.listarSueldos();
                        System.out.println("\nTotal a pagar: $" + banco.sueldosAPagar());
                    }
                    break;

                case 6:
                    System.out.println("\n--- Resumen del Banco ---");
                    banco.mostrarResumen();
                    break;

                case 7:
                    System.out.println("Has salido del sistema bancario.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 7);
    }
}

