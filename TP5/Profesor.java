import java.util.*;

/**
 * Representa un profesor, extendiendo la clase Persona para incluir
 * atributos académicos como título y una colección de cargos asignados.
 * Provee funcionalidades para gestionar sus cargos y calcular el sueldo total.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Profesor extends Persona {
    private String titulo;
    private Cargo[] cargos = new Cargo[3];

    /**
     * Constructor para instanciar un objeto Profesor con sus datos personales,
     * académicos y una lista de cargos predefinida.
     *
     * @param p_dni      Número de Documento Nacional de Identidad.
     * @param p_nombre   Nombre de pila del profesor.
     * @param p_apellido Apellido del profesor.
     * @param p_fecha    Fecha de nacimiento como objeto Calendar.
     * @param p_titulo   Título profesional del profesor.
     * @param p_cargos   Array de objetos Cargo asignados al profesor.
     */
    public Profesor(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha, String p_titulo,
            Cargo[] p_cargos) {
        super(p_dni, p_nombre, p_apellido, p_fecha);
        this.setTitulo(p_titulo);
        this.setCargos(p_cargos);
    }

    /** Asigna el título profesional. @param p_titulo Título a asignar. */
    private void setTitulo(String p_titulo) {
        this.titulo = p_titulo;
    }

    /** @return Devuelve el título profesional. */
    public String getTitulo() {
        return this.titulo;
    }

    /** Asigna el array de cargos. @param p_cargos Array de Cargo a asignar. */
    private void setCargos(Cargo[] p_cargos) {
        this.cargos = p_cargos;
    }

    /**
     * Agrega un cargo al primer espacio disponible en el array de cargos del profesor.
     * @param p_cargo El objeto Cargo a ser agregado.
     */
    private void agregarCargo(Cargo p_cargo) {
        for (int i = 0; i < this.cargos.length; i++) {
            if (this.cargos[i] == null) {
                this.cargos[i] = p_cargo;
                break;
            }
        }
    }

    /**
     * Elimina un cargo específico del array de cargos del profesor, estableciendo su posición a null.
     * @param p_cargo El objeto Cargo a ser eliminado.
     */
    private void eliminarCargo(Cargo p_cargo) {
        for (int i = 0; i < this.cargos.length; i++) {
            if (this.cargos[i] == p_cargo) {
                this.cargos[i] = null;
                break;
            }
        }
    }

    /** @return Devuelve el array de cargos del profesor. */
    public Cargo[] getCargos() {
        return this.cargos;
    }

    /**
     * Imprime en consola un listado formateado de todos los cargos asignados al profesor.
     */
    public void listarCargos() {
        System.out.println("\n-***** Cargos Asignados *****-");
        System.out.println("------------------------------------------------------------");
        for (Cargo cargo : this.getCargos()) {
            cargo.mostrarCargo();
        }
    }

    /**
     * Calcula la suma de los sueldos de todos los cargos que posee el profesor.
     * @return El monto del sueldo total.
     */
    public double sueldoTotal() {
        double sueldoTotal = 0;
        for (Cargo cargo : this.getCargos()) {
            sueldoTotal += cargo.sueldoDelCargo();
        }
        return sueldoTotal;
    }

    /**
     * Genera una cadena de texto formateada para ser usada en nóminas o listados.
     * @return Un String con DNI, nombre completo y sueldo total del profesor.
     */
    public String mostrarLinea() {
        return "DNI: " + this.getDNI() + " - Nombre: " + this.getNombre() + " - Sueldo Total: " + this.sueldoTotal();
    }

    /**
     * Imprime en consola un resumen completo con los datos del profesor.
     * Muestra información personal (heredada de Persona), su título,
     * un listado de sus cargos y el sueldo total.
     */
    public void mostrar() {
        super.mostrar();
        System.out.println("Titulo: " + this.getTitulo());
        this.listarCargos();
        System.out.println("\n** Sueldo Total: $" + this.sueldoTotal() + " **");
    }
}
