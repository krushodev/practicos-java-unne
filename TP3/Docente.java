/**
 * Representa a un Docente con sus datos laborales.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Docente
{
    private String nombre;
    private String grado;
    private double sueldoBasico;
    private double asignacionFamiliar;

    /**
     * Constructor para crear un objeto Docente.
     * @param p_nombre Nombre del docente.
     * @param p_grado Grado que enseña el docente.
     * @param p_sueldoBasico Sueldo básico del docente.
     * @param p_asignacionFamiliar Monto de la asignación familiar.
     */
    public Docente(String p_nombre, String p_grado, double p_sueldoBasico, double p_asignacionFamiliar) {
        this.setNombre(p_nombre);
        this.setGrado(p_grado);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAsignacionFamiliar(p_asignacionFamiliar);
    }
    
    /** Asigna el nombre. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /** Asigna el grado. @param p_grado Grado a asignar. */
    private void setGrado(String p_grado) {
        this.grado = p_grado;
    }
    
    /** Asigna el sueldo básico. @param p_sueldoBasico Sueldo a asignar. */
    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }

    /** Asigna la asignación familiar. @param p_asignacionFamiliar Monto a asignar. */
    private void setAsignacionFamiliar(double p_asignacionFamiliar) {
        this.asignacionFamiliar = p_asignacionFamiliar;
    }
    
    /** @return Devuelve el nombre del docente. */
    public String getNombre() {
        return this.nombre;
    }

    /** @return Devuelve el grado del docente. */
    public String getGrado() {
        return this.grado;
    }
    
    /** @return Devuelve el sueldo básico. */
    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    /** @return Devuelve la asignación familiar. */
    public double getAsignacionFamiliar() {
        return this.asignacionFamiliar;
    }
    
    /**
     * Calcula el sueldo total del docente sumando el básico y la asignación familiar.
     * @return El sueldo total.
     */
    public double calcularSueldo() {
        return this.getSueldoBasico() + this.getAsignacionFamiliar();
    }
}
