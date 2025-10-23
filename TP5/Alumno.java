import java.util.*;

/**
 * Representa un alumno, extendiendo la clase Persona para incluir
 * atributos académicos como Libreta Universitaria (LU) y notas.
 * Provee funcionalidades para calcular el promedio y determinar la condición académica.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Alumno extends Persona {
    private int lu;
    private double nota1;
    private double nota2;

    /**
     * Constructor para instanciar un objeto Alumno con sus datos personales y académicos.
     * Las notas se inicializan en 0.0 por defecto.
     *
     * @param p_dni      Número de Documento Nacional de Identidad.
     * @param p_lu       Número de Libreta Universitaria.
     * @param p_nombre   Nombre de pila del alumno.
     * @param p_apellido Apellido del alumno.
     * @param p_fecha    Fecha de nacimiento como objeto Calendar.
     */
    public Alumno(int p_dni, int p_lu, String p_nombre, String p_apellido, Calendar p_fecha) {
        super(p_dni, p_nombre, p_apellido, p_fecha);
        this.setLu(p_lu);
        this.setNota1(0.0);
        this.setNota2(0.0);
    }

    /** Asigna el número de Libreta Universitaria. @param p_lu Valor de LU a asignar. */
    private void setLu(int p_lu) {
        this.lu = p_lu;
    }

    /** Asigna la primera nota parcial. @param p_nota Valor de la nota a asignar. */
    public void setNota1(double p_nota) {
        this.nota1 = p_nota;
    }

    /** Asigna la segunda nota parcial. @param p_nota Valor de la nota a asignar. */
    public void setNota2(double p_nota) {
        this.nota2 = p_nota;
    }

    /** @return Devuelve el número de Libreta Universitaria. */
    public int getLu() {
        return this.lu;
    }

    /** @return Devuelve la primera nota parcial. */
    public double getNota1() {
        return this.nota1;
    }

    /** @return Devuelve la segunda nota parcial. */
    public double getNota2() {
        return this.nota2;
    }

    /**
     * Calcula el promedio aritmético entre las dos notas parciales del alumno.
     * @return El promedio de las notas.
     */
    public double promedio() {
        return ((this.getNota1() + this.getNota2()) / 2);
    }

    /**
     * Evalúa si la condición académica del alumno es de aprobación.
     * El criterio de aprobación es un promedio mayor o igual a 8.
     * @return `true` si el promedio cumple el criterio, `false` en caso contrario.
     */
    private boolean aprueba() {
        if (this.promedio() >= 8) {
            return true;
        }

        return false;
    }

    /**
     * Genera una cadena de texto que indica la condición académica del alumno.
     * @return "APROBADO" o "DESAPROBADO" según el resultado del método aprueba().
     */
    public String leyendaAprueba() {
        if (this.aprueba()) {
            return "APROBADO";
        }

        return "DESAPROBADO";
    }

    /**
     * Concatena el apellido y el nombre del alumno.
     * @return Una cadena de texto con el formato "Apellido, Nombre".
     */
    public String apeYNom() {
        return this.getApellido() + " " + this.getNombre();
    }

    /**
     * Concatena el nombre y el apellido del alumno.
     * @return Una cadena de texto con el formato "Nombre Apellido".
     */
    public String nomYApe() {
        return this.getNombre() + " " + this.getApellido();
    }

    /**
     * Imprime en consola un resumen completo con los datos del alumno.
     * Muestra información personal (heredada de Persona) y académica
     * (LU, notas, promedio y condición).
     */
    public void mostrar() {
        super.mostrar();
        System.out.println("LU: " + this.getLu() + "\t" + "Notas: " + this.getNota1() + " - " + this.getNota2());
        System.out.println("Promedio: " + this.promedio() + " - " + this.leyendaAprueba());
    }
}
