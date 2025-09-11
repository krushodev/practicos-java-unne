/**
 * Representa una Localidad con su nombre y la provincia a la que pertenece.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Localidad
{
    private String nombre;
    private String provincia;

    /**
     * Constructor para crear un objeto Localidad.
     * @param p_nombre Nombre de la localidad.
     * @param p_provincia Nombre de la provincia.
     */
    public Localidad(String p_nombre, String p_provincia) {
        this.setNombre(p_nombre);
        this.setProvincia(p_provincia);
    }

    /** Asigna el nombre de la localidad. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /** Asigna el nombre de la provincia. @param p_provincia Provincia a asignar. */
    private void setProvincia(String p_provincia) {
        this.provincia = p_provincia;
    }

    /** @return Devuelve el nombre de la localidad. */
    public String getNombre() {
        return this.nombre;
    }

    /** @return Devuelve el nombre de la provincia. */
    public String getProvincia() {
        return this.provincia;
    }
    
    /**
     * Devuelve un String con los datos de la localidad formateados.
     * @return Un String con el nombre de la localidad y la provincia.
     */
    public String mostrar() {
        return "Localidad: " + this.getNombre() + "\t Provincia: " + this.getProvincia();
    }
}
