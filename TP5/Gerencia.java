import java.util.ArrayList;

/**
 * Gestiona un conjunto de alojamientos turísticos alquilados.
 * Permite agregar y quitar alojamientos, contar la cantidad por tipo
 * y generar una liquidación de todos los alquileres.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Gerencia {
    private String nombre;
    private ArrayList<Alojamiento> alojamientosAlquilados = new ArrayList<>();

    /**
     * Constructor que inicializa la gerencia con un nombre y una lista de
     * alojamientos alquilados.
     *
     * @param p_nombre            Nombre de la gerencia.
     * @param p_alojamientosAlqui Lista inicial de alojamientos alquilados.
     */
    public Gerencia(String p_nombre, ArrayList<Alojamiento> p_alojamientosAlqui) {
        this.setNombre(p_nombre);
        this.setAlojamientosAlqui(p_alojamientosAlqui);
    }

    /**
     * Constructor que inicializa la gerencia con un nombre, creando una lista
     * de alojamientos vacía.
     *
     * @param p_nombre Nombre de la gerencia.
     */
    public Gerencia(String p_nombre) {
        this.setNombre(p_nombre);
    }

    /**
     * Asigna el nombre de la gerencia.
     *
     * @param p_nombre Nombre a establecer.
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Asigna la lista de alojamientos alquilados.
     *
     * @param p_alojamientoAlqui Lista de alojamientos.
     */
    private void setAlojamientosAlqui(ArrayList<Alojamiento> p_alojamientoAlqui) {
        this.alojamientosAlquilados = p_alojamientoAlqui;
    }

    /**
     * Devuelve el nombre de la gerencia.
     *
     * @return El nombre de la gerencia.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve la lista de alojamientos alquilados.
     *
     * @return Una lista de objetos Alojamiento.
     */
    public ArrayList<Alojamiento> getAlojamientosAlqui() {
        return this.alojamientosAlquilados;
    }

    /**
     * Agrega un alojamiento a la lista de gestión.
     *
     * @param p_alojamiento Alojamiento a agregar.
     * @return `true` si el alojamiento fue agregado exitosamente.
     */
    public boolean agregarAlojamiento(Alojamiento p_alojamiento) {
        return this.getAlojamientosAlqui().add(p_alojamiento);
    }

    /**
     * Quita un alojamiento de la lista de gestión.
     *
     * @param p_alojamiento Alojamiento a quitar.
     * @return `true` si el alojamiento fue removido exitosamente.
     */
    public boolean quitarAlojamiento(Alojamiento p_alojamiento) {
        return this.getAlojamientosAlqui().remove(p_alojamiento);
    }

    /**
     * Cuenta la cantidad de alojamientos de un tipo específico (ej. "Hotel", "Cabana").
     *
     * @param tipoAlojamiento Cadena que representa el tipo de alojamiento a contar.
     * @return La cantidad de alojamientos que coinciden con el tipo especificado.
     */
    public int contarAlojamientos(String tipoAlojamiento) {
        int cantAlojamientos = 0;
        for (Alojamiento unAlojamiento : alojamientosAlquilados) {
            cantAlojamientos += unAlojamiento.contar(tipoAlojamiento);
        }
        return cantAlojamientos;
    }

    /**
     * Procesa la liquidación para cada uno de los alojamientos gestionados.
     */
    public void liquidar() {
        for (Alojamiento unAlojamiento : alojamientosAlquilados) {
            unAlojamiento.liquidar();
        }
    }

    /**
     * Imprime en consola un reporte de liquidación general para todos los
     * alojamientos gestionados.
     */
    public void mostrarLiquidacion() {
        System.out.println("Gerencia: " + this.getNombre());
        System.out.println("Liquidacion------------------");
        this.liquidar();
    }
}
