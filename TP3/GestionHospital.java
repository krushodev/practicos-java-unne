import java.util.Scanner;
import java.util.Random;

/**
 * Clase ejecutable para probar la interacción entre Hospital, Paciente y Localidad.
 * Permite ingresar por teclado los datos de un paciente y sus localidades,
 * para luego realizar una consulta de datos filiatorios.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class GestionHospital
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        
        Hospital hospital = new Hospital("Garrahan", "Leopoldo Ruiz");
        
        System.out.println("Ingrese el nombre del paciente:");
        String nombrePaciente = teclado.next();
        System.out.println("Ingrese el domicilio del paciente:");
        String domicilioPaciente = teclado.next();
        System.out.println("Ingrese la historia clínica del paciente:");
        int historiaClinica = teclado.nextInt();
        System.out.println("-- Localidad Nacimiento --");
        System.out.println("Ingrese el nombre de localidad de nacimiento del paciente:");
        String localidadNacimientoNombre = teclado.next();
        System.out.println("Ingrese el nombre de la provincia de nacimiento del paciente:");
        String localidadNacimientoProvincia = teclado.next();
        Localidad localidadNacimiento = new Localidad(localidadNacimientoNombre, localidadNacimientoProvincia);
        System.out.println("-- Localidad Residencia --");
        System.out.println("Ingrese el nombre de localidad de residencia del paciente:");
        String localidadResidenciaNombre = teclado.next();
        System.out.println("Ingrese el nombre de la provincia de residencia del paciente:");
        String localidadResidenciaProvincia = teclado.next();
        Localidad localidadResidencia = new Localidad(localidadResidenciaNombre, localidadResidenciaProvincia);
        
        Paciente paciente = new Paciente(historiaClinica, nombrePaciente, domicilioPaciente, localidadNacimiento, localidadResidencia);
        
        hospital.consultaDatosFiliatorios(paciente);
        
        System.out.println("\n");
        System.out.println(paciente.cadenaDeDatos());
    }
}
