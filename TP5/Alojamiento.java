import java.util.ArrayList;

/**
 * Clase abstracta que representa un alojamiento genérico.
 * Define la estructura base para distintos tipos de alojamientos, incluyendo
 * nombre, precio base, días de alquiler y servicios adicionales.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public abstract class Alojamiento {
    private String nombre;
    private double precioBase;
    private int diasAlquiler;
    private ArrayList<Servicio> servicios = new ArrayList<>();

    /**
     * Constructor para inicializar un alojamiento con una lista de servicios.
     *
     * @param p_nombre       Nombre del alojamiento.
     * @param p_precioBase   Precio base por día.
     * @param p_diasAlquiler Cantidad de días de alquiler.
     * @param p_servicios    Lista de servicios adicionales.
     */
    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios) {
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);
        this.setServicios(p_servicios);
    }

    /**
     * Constructor para inicializar un alojamiento sin servicios adicionales.
     *
     * @param p_nombre       Nombre del alojamiento.
     * @param p_precioBase   Precio base por día.
     * @param p_diasAlquiler Cantidad de días de alquiler.
     */
    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler) {
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);
    }

    /**
     * Asigna el nombre del alojamiento.
     * @param p_nombre Nombre a asignar.
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Asigna el precio base por día.
     * @param p_precioBase Precio base a asignar.
     */
    private void setPrecioBase(double p_precioBase) {
        this.precioBase = p_precioBase;
    }

    /**
     * Asigna la cantidad de días de alquiler.
     * @param p_diasAlquilados Días de alquiler a asignar.
     */
    private void setDiasAlquiler(int p_diasAlquilados) {
        this.diasAlquiler = p_diasAlquilados;
    }

    /**
     * Asigna la lista de servicios.
     * @param p_servicios Lista de servicios a asignar.
     */
    private void setServicios(ArrayList<Servicio> p_servicios) {
        this.servicios = p_servicios;
    }

    /**
     * Devuelve el nombre del alojamiento.
     * @return El nombre del alojamiento.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve el precio base por día.
     * @return El precio base.
     */
    public double getPrecioBase() {
        return this.precioBase;
    }

    /**
     * Devuelve la cantidad de días de alquiler.
     * @return El número de días.
     */
    public int getDiasAlquiler() {
        return this.diasAlquiler;
    }

    /**
     * Devuelve la lista de servicios contratados.
     * @return Una lista de objetos Servicio.
     */
    public ArrayList<Servicio> getServicios() {
        return this.servicios;
    }

    /**
     * Agrega un servicio a la lista del alojamiento.
     *
     * @param p_servicio El servicio a agregar.
     * @return `true` si el servicio fue agregado exitosamente.
     */
    public boolean agregarServicio(Servicio p_servicio) {
        return this.getServicios().add(p_servicio);
    }

    /**
     * Quita un servicio de la lista del alojamiento.
     *
     * @param p_servicio El servicio a quitar.
     * @return `true` si el servicio fue removido exitosamente.
     */
    public boolean quitarServicio(Servicio p_servicio) {
        return this.getServicios().remove(p_servicio);
    }

    /**
     * Método abstracto para contar alojamientos por tipo.
     *
     * @param p_alojamiento Cadena que representa el tipo de alojamiento a contar.
     * @return Un número que representa la cantidad (ej. 1 si coincide, 0 si no).
     */
    public abstract int contar(String p_alojamiento);

    /**
     * Calcula el costo base del alquiler (precio base * días).
     *
     * @return El costo total del alquiler sin servicios.
     */
    public double costo() {
        return this.getPrecioBase() * this.getDiasAlquiler();
    }

    /**
     * Imprime en consola la lista de servicios contratados y sus precios.
     */
    public void listaServicios() {
        for (Servicio unServicio : servicios) {
            System.out.println(unServicio.getDescripcion() + ": $" + unServicio.getPrecio());
        }
    }

    /**
     * Calcula el costo total de todos los servicios adicionales contratados.
     *
     * @return La suma de los precios de todos los servicios.
     */
    public double costoServicios() {
        double costoTotal = 0;
        for (Servicio unServicio : servicios) {
            costoTotal += unServicio.getPrecio();
        }
        return costoTotal;
    }

    /**
     * Imprime en consola la información básica de liquidación del alojamiento.
     */
    public void liquidar() {
        System.out.println("Alojamiento: " + this.getNombre());
        System.out.println("Costo por " + this.getDiasAlquiler() + " dias: $" +
                this.costo() + " (alquiler)");
        this.listaServicios();
    }
}
