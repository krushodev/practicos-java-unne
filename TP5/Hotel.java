import java.util.ArrayList;

/**
 * Representa un Hotel, un tipo de Alojamiento cuyo costo varía según
 * el tipo de habitación (ej. "Single", "Doble").
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Hotel extends Alojamiento {
    private String tipoHabitacion;

    /**
     * Constructor para inicializar un hotel con una lista de servicios.
     *
     * @param p_nombre         Nombre del hotel.
     * @param p_precioBase     Precio base por día.
     * @param p_diasAlquiler   Cantidad de días de alquiler.
     * @param p_servicio       Lista de servicios adicionales.
     * @param p_tipoHabitacion Tipo de habitación (ej. "Single").
     */
    public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler,
            ArrayList<Servicio> p_servicio, String p_tipoHabitacion) {
        super(p_nombre, p_precioBase, p_diasAlquiler, p_servicio);
        this.setTipoHabitacion(p_tipoHabitacion);
    }

    /**
     * Constructor para inicializar un hotel sin servicios adicionales.
     *
     * @param p_nombre         Nombre del hotel.
     * @param p_precioBase     Precio base por día.
     * @param p_diasAlquiler   Cantidad de días de alquiler.
     * @param p_tipoHabitacion Tipo de habitación.
     */
    public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler,
            String p_tipoHabitacion) {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setTipoHabitacion(p_tipoHabitacion);
    }

    /**
     * Asigna el tipo de habitación del hotel.
     *
     * @param p_TipoHabitacion Tipo de habitación a asignar.
     */
    private void setTipoHabitacion(String p_TipoHabitacion) {
        this.tipoHabitacion = p_TipoHabitacion;
    }

    /**
     * Devuelve el tipo de habitación del hotel.
     *
     * @return El tipo de habitación.
     */
    public String getTipoHabitacion() {
        return this.tipoHabitacion;
    }

    /**
     * Calcula el costo total del alojamiento, aplicando un adicional según el
     * tipo de habitación.
     *
     * @return El costo total del alquiler del hotel.
     */
    public double costo() {
        if (this.getTipoHabitacion().equalsIgnoreCase("Single")) {
            return super.costo() + 20 * this.getDiasAlquiler();
        } else {
            return super.costo() + 35 * this.getDiasAlquiler();
        }
    }

    /**
     * Verifica si el tipo de alojamiento proporcionado corresponde a "Hotel".
     *
     * @param p_alojamiento Cadena que representa el tipo de alojamiento a verificar.
     * @return 1 si es un hotel, 0 en caso contrario.
     */
    public int contar(String p_alojamiento) {
        if (p_alojamiento.equalsIgnoreCase("Hotel")) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Imprime en consola un resumen de la liquidación del hotel, incluyendo
     * el costo del alquiler, los servicios y el total a pagar.
     */
    public void liquidar() {
        System.out.println("------------------------------------");
        super.liquidar();
        System.out.println("Habitacion " + this.getTipoHabitacion());
        System.out.println("Total a pagar ----------> $" + (this.costo() + this.costoServicios()));
    }
}
