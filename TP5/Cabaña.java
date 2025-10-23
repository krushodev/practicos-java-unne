import java.util.ArrayList;

/**
 * Representa una Cabaña, un tipo de Alojamiento que se caracteriza por tener
 * un número específico de habitaciones, lo que influye en su costo final.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Cabaña extends Alojamiento {
    private int nroHabitaciones;

    /**
     * Constructor para inicializar una cabaña con servicios adicionales.
     *
     * @param p_nombre          Nombre de la cabaña.
     * @param p_precioBase      Precio base por día.
     * @param p_diasAlquiler    Cantidad de días de alquiler.
     * @param p_servicios       Lista de servicios adicionales.
     * @param p_nroHabitaciones Número de habitaciones.
     */
    public Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler,
            ArrayList<Servicio> p_servicios, int p_nroHabitaciones) {
        super(p_nombre, p_precioBase, p_diasAlquiler, p_servicios);
        this.setNroHabitaciones(p_nroHabitaciones);
    }

    /**
     * Constructor para inicializar una cabaña sin servicios adicionales.
     *
     * @param p_nombre          Nombre de la cabaña.
     * @param p_precioBase      Precio base por día.
     * @param p_diasAlquiler    Cantidad de días de alquiler.
     * @param p_nroHabitaciones Número de habitaciones.
     */
    public Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler,
            int p_nroHabitaciones) {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setNroHabitaciones(p_nroHabitaciones);
    }

    /**
     * Asigna el número de habitaciones de la cabaña.
     *
     * @param p_nroHabitaciones Número de habitaciones a asignar.
     */
    private void setNroHabitaciones(int p_nroHabitaciones) {
        this.nroHabitaciones = p_nroHabitaciones;
    }

    /**
     * Devuelve el número de habitaciones de la cabaña.
     *
     * @return El número de habitaciones.
     */
    public int getNroHabitaciones() {
        return this.nroHabitaciones;
    }

    /**
     * Calcula el costo total del alojamiento, añadiendo un cargo de $30 por
     * día y por cada habitación.
     *
     * @return El costo total del alquiler de la cabaña.
     */
    public double costo() {
        return super.costo() + 30 * this.getDiasAlquiler() * this.getNroHabitaciones();
    }

    /**
     * Verifica si el tipo de alojamiento proporcionado corresponde a "Cabana".
     *
     * @param p_alojamiento Cadena que representa el tipo de alojamiento a verificar.
     * @return 1 si es una cabaña, 0 en caso contrario.
     */
    public int contar(String p_alojamiento) {
        if (p_alojamiento.equalsIgnoreCase("Cabana")) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Imprime en consola un resumen de la liquidación de la cabaña, incluyendo
     * el costo del alquiler, los servicios y el total a pagar.
     */
    public void liquidar() {
        System.out.println("------------------------------------");
        super.liquidar();
        System.out.println("Cabaña con " + this.getNroHabitaciones() + " habitaciones");
        System.out.println("Total a pagar ----------> $" + (this.costo() + this.costoServicios()));
    }
}
