/**
 * Representa un renglón o ítem dentro de un pedido.
 * Cada renglón asocia una cantidad específica de un tipo de Etiqueta
 * y un importe relacionado.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Renglon {
    private int cantidad;
    private double importe;
    private Etiqueta item;

    /**
     * Constructor para inicializar un renglón de pedido.
     *
     * @param p_cantidad La cantidad de etiquetas para este renglón.
     * @param p_importe  El importe asociado al renglón.
     * @param p_item     La instancia de Etiqueta para este renglón.
     */
    public Renglon(int p_cantidad, double p_importe, Etiqueta p_item) {
        this.setCantidad(p_cantidad);
        this.setImporte(p_importe);
        this.setItem(p_item);
    }

    /**
     * Asigna la cantidad de etiquetas del renglón.
     *
     * @param p_cantidad Cantidad de etiquetas.
     */
    private void setCantidad(int p_cantidad) {
        this.cantidad = p_cantidad;
    }

    /**
     * Asigna el importe del renglón.
     *
     * @param p_importe Importe a asignar.
     */
    private void setImporte(double p_importe) {
        this.importe = p_importe;
    }

    /**
     * Asigna la etiqueta asociada al renglón.
     *
     * @param p_item La instancia de Etiqueta.
     */
    private void setItem(Etiqueta p_item) {
        this.item = p_item;
    }

    /**
     * Devuelve la cantidad de etiquetas de este renglón.
     *
     * @return La cantidad de etiquetas.
     */
    public int getCantidad() {
        return this.cantidad;
    }

    /**
     * Devuelve el importe asociado a este renglón.
     *
     * @return El importe del renglón.
     */
    public double getImporte() {
        return this.importe;
    }

    /**
     * Devuelve la etiqueta asociada a este renglón.
     *
     * @return El objeto Etiqueta.
     */
    public Etiqueta getItem() {
        return this.item;
    }

    /**
     * Imprime en consola una descripción del renglón, incluyendo la cantidad
     * y los detalles de la etiqueta asociada.
     */
    public void mostrar() {
        System.out.println(" " + this.getCantidad() + " Etiqueta de " + this.getItem().toString());
    }
}
