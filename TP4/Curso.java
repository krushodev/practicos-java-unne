import java.util.*;

/**
 * Representa un curso académico que gestiona una nómina de alumnos.
 * Utiliza una estructura de datos HashMap para almacenar y acceder a los
 * alumnos de forma eficiente mediante su número de Libreta Universitaria (LU) como clave.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Curso {
    private String nombre;
    private HashMap<Integer, Alumno> alumnos;

    /**
     * Constructor que inicializa un curso con un nombre específico y una nómina de alumnos vacía.
     * @param p_nombre El nombre asignado al curso.
     */
    public Curso(String p_nombre) {
        this.setNombre(p_nombre);
        this.setAlumnos(new HashMap<Integer, Alumno>());
    }

    /**
     * Constructor que inicializa un curso con un nombre y una nómina de alumnos preexistente.
     * @param p_nombre El nombre asignado al curso.
     * @param p_alumnos Un objeto HashMap que contiene los alumnos a inscribir.
     */
    public Curso(String p_nombre, HashMap<Integer, Alumno> p_alumnos) {
        this.setNombre(p_nombre);
        this.setAlumnos(p_alumnos);
    }

    /** Asigna el nombre del curso. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /** Asigna la colección de alumnos. @param p_alumnos Objeto HashMap a asignar. */
    private void setAlumnos(HashMap<Integer, Alumno> p_alumnos) {
        this.alumnos = p_alumnos;
    }

    /** @return Devuelve el nombre del curso. */
    public String getNombre() {
        return this.nombre;
    }

    /** @return Devuelve la colección HashMap de alumnos. */
    public HashMap<Integer, Alumno> getAlumnos() {
        return this.alumnos;
    }

    /**
     * Inscribe un nuevo alumno en la nómina del curso.
     * Utiliza el LU del alumno como clave en el HashMap.
     * @param p_alumno El objeto Alumno a ser inscrito.
     */
    public void inscribirAlumno(Alumno p_alumno) {
        this.getAlumnos().put(p_alumno.getLu(), p_alumno);
    }

    /**
     * Remueve un alumno de la nómina del curso utilizando su LU.
     * @param p_lu La Libreta Universitaria del alumno a remover.
     * @return El objeto Alumno que ha sido removido, o `null` si no se encuentra.
     */
    public Alumno quitarAlumno(int p_lu) {
        return this.getAlumnos().remove(p_lu);
    }

    /**
     * Devuelve la cantidad total de alumnos inscritos en el curso.
     * @return Un valor entero que representa el número de alumnos.
     */
    public int cantidadDeAlumnos() {
        return this.getAlumnos().size();
    }

    /**
     * Verifica si un alumno se encuentra inscrito en el curso mediante su LU.
     * @param p_lu La Libreta Universitaria a verificar.
     * @return `true` si el alumno está inscrito, `false` en caso contrario.
     */
    public boolean estaInscripto(int p_lu) {
        return this.getAlumnos().containsKey(p_lu);
    }

    /**
     * Verifica si un alumno específico se encuentra inscrito en el curso.
     * @param p_alumno El objeto Alumno a verificar.
     * @return `true` si el alumno está inscrito, `false` en caso contrario.
     */
    public boolean estaInscripto(Alumno p_alumno) {
        return this.getAlumnos().containsValue(p_alumno);
    }

    /**
     * Busca y devuelve un alumno de la nómina a partir de su LU.
     * @param p_lu La Libreta Universitaria del alumno a buscar.
     * @return El objeto Alumno correspondiente, o `null` si no se encuentra.
     */
    public Alumno buscarAlumno(int p_lu) {
        return this.getAlumnos().get(p_lu);
    }

    /**
     * Imprime en consola el promedio y la condición académica de un alumno.
     * @param p_lu La Libreta Universitaria del alumno a consultar.
     */
    public void imprimirPromedioDelAlumno(int p_lu) {
        System.out.println(this.getAlumnos().get(p_lu).promedio() + " - " + this.getAlumnos().get(p_lu).leyendaAprueba());
    }

    /**
     * Imprime en consola un listado con los datos de todos los alumnos inscritos.
     */
    public void mostrarInscriptos() {
        for (Alumno alumno : this.getAlumnos().values()) {
            alumno.mostrar();
        }
    }
}

