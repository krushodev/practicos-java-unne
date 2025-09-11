/**
 * Representa una Escuela con su nombre, domicilio y director.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Escuela
{
    private String nombre;
    private String domicilio;
    private String director;

    /**
     * Constructor para crear un objeto Escuela.
     * @param p_nombre Nombre de la escuela.
     * @param p_domicilio Domicilio de la escuela.
     * @param p_director Nombre del director.
     */
    public Escuela(String p_nombre, String p_domicilio, String p_director) {
        this.nombre = p_nombre;
        this.domicilio = p_domicilio;
        this.director = p_director;
    }


    /** Asigna el director. @param p_director Director a asignar. */
    private void setDirector(String p_director) {  
        this.director = p_director;
    }

    /** Asigna el domicilio. @param p_domicilio Domicilio a asignar. */
    private void setDomicilio(String p_domicilio) {
        this.domicilio = p_domicilio;
    }

    /** Asigna el nombre. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {  
        this.nombre = p_nombre;
    }
    
    /** @return Devuelve el nombre de la escuela. */
    public String getNombre() {
        return this.nombre;
    }

    /** @return Devuelve el domicilio de la escuela. */
    public String getDomicilio() {
        return this.domicilio;
    }

    /** @return Devuelve el nombre del director. */
    public String getDirector() {
        return this.director;
    }   

    /**
     * Imprime por consola un recibo de sueldo para un docente específico.
     * @param p_docente El docente para el cual se genera el recibo.
     */
    public void imprimirRecibo(Docente p_docente) {
        System.out.println("Escuela: " + this.getNombre() + "\t Domicilio: " + this.getDomicilio() + "\t Director: " + this.getDirector());
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Docente: " + p_docente.getNombre());
        System.out.println("Sueldo: .......... $" + p_docente.calcularSueldo());
        System.out.println("Sueldo Básico: .......... $" + p_docente.getSueldoBasico());
        System.out.println("Asignación familiar: .......... $" + p_docente.getAsignacionFamiliar());
    }

}
