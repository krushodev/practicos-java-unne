import java.util.*;

/**
 * Representa una facultad que gestiona una colección de profesores.
 * Provee funcionalidades para administrar la nómina de profesores,
 * calcular el total de sueldos a pagar y generar listados.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Facultad {
    private String nombre;
    private ArrayList<Profesor> profesores = new ArrayList<>();;

    /**
     * Constructor para instanciar una Facultad con una nómina de profesores preexistente.
     * @param p_nombre      El nombre de la facultad.
     * @param p_profesores  Una colección ArrayList de objetos Profesor.
     */
    public Facultad(String p_nombre, ArrayList<Profesor> p_profesores) {
        this.setNombre(p_nombre);
        this.setProfesores(p_profesores);
    }

    /**
     * Constructor para instanciar una Facultad con un nombre y una nómina vacía.
     * @param p_nombre El nombre de la facultad.
     */
    public Facultad(String p_nombre) {
        this.setNombre(p_nombre);
        this.setProfesores(new ArrayList<>());
    }

    /** Asigna el nombre de la facultad. @param p_nombre El nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /** Asigna la colección de profesores. @param p_profesores La colección ArrayList a asignar. */
    private void setProfesores(ArrayList<Profesor> p_profesores) {
        this.profesores = p_profesores;
    }

    /**
     * Agrega un nuevo profesor a la nómina de la facultad.
     * @param p_profesor El objeto Profesor a agregar.
     */
    private void agregarProfesor(Profesor p_profesor) {
        this.profesores.add(p_profesor);
    }

    /**
     * Remueve un profesor existente de la nómina de la facultad.
     * @param p_profesor El objeto Profesor a remover.
     */
    private void eliminarProfesor(Profesor p_profesor) {
        this.profesores.remove(p_profesor);
    }

    /** @return Devuelve el nombre de la facultad. */
    public String getNombre() {
        return this.nombre;
    }

    /** @return Devuelve la colección ArrayList de profesores. */
    public ArrayList<Profesor> getProfesores() {
        return this.profesores;
    }

    /**
     * Imprime en consola la nómina completa de profesores de la facultad,
     * incluyendo el total de sueldos a pagar.
     */
    public void nominaProfesores() {
        System.out.println("*************** Nómina Facultad: " + this.getNombre() + " ***************");
        System.out.println("------------------------------------------------------------");
        for (Profesor profesor : this.getProfesores()) {
            System.out.println(profesor.mostrarLinea());
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("Total a pagar: $" + this.totalAPagar());
    }

    /**
     * Calcula la suma total de los sueldos de todos los profesores de la facultad.
     * @return El monto total a pagar en concepto de sueldos.
     */
    public double totalAPagar() {
        double totalAPagar = 0;
        for (Profesor profesor : this.getProfesores()) {
            totalAPagar += profesor.sueldoTotal();
        }
        return totalAPagar;
    }

    /**
     * Imprime en consola un listado detallado de cada profesor y sus cargos asignados.
     */
    public void listarProfesorCargos() {
        System.out.println(
                "*************** Listado de profesores y cargos de Facultad: " + this.getNombre() + " ***************");
        System.out.println("------------------------------------------------------------");
        for (Profesor profesor : this.getProfesores()) {
            profesor.mostrar();
            System.out.println("------------------ ****** ------------------");
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("Hay " + this.getProfesores().size() + " profesores");
    }
}
