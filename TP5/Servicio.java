/**
 * Representa un servicio adicional que puede ser contratado en un alojamiento.
 * Contiene la descripción del servicio y su precio.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Servicio {
    private String descripcion;
    private double precio;

    /**
     * Constructor para inicializar un servicio con su descripción y precio.
     *
     * @param p_descripcion Descripción del servicio.
     * @param p_precio      Precio del servicio.
     */
    public Servicio(String p_descripcion, double p_precio) {
        this.setDescripcion(p_descripcion);
        this.setPrecio(p_precio);
    }

    /**
     * Asigna la descripción del servicio.
     *
     * @param p_descripcion La descripción a asignar.
     */
    private void setDescripcion(String p_descripcion) {
        this.descripcion = p_descripcion;
    }

    /**
     * Asigna el precio del servicio.
     *
     * @param p_precio El precio a asignar.
     */
    private void setPrecio(double p_precio) {
        this.precio = p_precio;
    }

    /**
     * Devuelve la descripción del servicio.
     *
     * @return La descripción del servicio.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Devuelve el precio del servicio.
     *
     * @return El precio del servicio.
     */
    public double getPrecio() {
        return this.precio;
    }
}
