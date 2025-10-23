/**
 * Clase abstracta que representa una figura geométrica genérica.
 * Define la estructura base con un punto de origen y obliga a las subclases
 * a implementar métodos para calcular la superficie y mostrar su información.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public abstract class FiguraGeometrica {
    private Punto origen;

    /**
     * Constructor para inicializar una figura geométrica con su punto de origen.
     *
     * @param p_origen Punto de origen de la figura.
     */
    public FiguraGeometrica(Punto p_origen) {
        this.setOrigen(p_origen);
    }

    /**
     * Asigna el punto de origen de la figura.
     * @param p_origen Punto de origen a asignar.
     */
    private void setOrigen(Punto p_origen) {
        this.origen = p_origen;
    }

    /**
     * Devuelve el punto de origen de la figura.
     * @return El punto de origen.
     */
    public Punto getOrigen() {
        return this.origen;
    }

    /**
     * Método abstracto que debe devolver el nombre de la figura.
     *
     * @return El nombre de la figura (ej. "Cuadrado").
     */
    public abstract String nombreFigura();

    /**
     * Método abstracto para calcular la superficie (área) de la figura.
     *
     * @return La superficie de la figura.
     */
    public abstract double superficie();

    /**
     * Método abstracto para mostrar en consola los datos relevantes de la figura.
     */
    public abstract void mostrarSuperficie();
}
