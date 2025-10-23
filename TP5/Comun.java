/**
 * Representa una etiqueta de tipo común.
 * Este tipo de etiqueta incluye un costo adicional fijo por diseño ("plus") y
 * aplica descuentos progresivos según la cantidad solicitada.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Comun extends Etiqueta {
    private double plus;

    /**
     * Constructor para inicializar una etiqueta común con su costo base y un
     * costo adicional por diseño.
     *
     * @param p_costo Costo base por unidad.
     * @param p_plus  Costo adicional fijo por diseño.
     */
    public Comun(double p_costo, double p_plus) {
        super(p_costo);
        this.setPlus(p_plus);
    }

    /**
     * Asigna el valor del costo adicional por diseño.
     *
     * @param p_plus Costo adicional a asignar.
     */
    private void setPlus(double p_plus) {
        this.plus = p_plus;
    }

    /**
     * Devuelve el valor del costo adicional por diseño.
     *
     * @return El costo del plus de diseño.
     */
    public double getPlus() {
        return this.plus;
    }

    /**
     * Calcula el precio total para una cantidad `q` de etiquetas, aplicando
     * el descuento correspondiente y sumando el costo de diseño.
     *
     * @param q Cantidad de etiquetas.
     * @return El precio total calculado.
     */
    public double precio(int q) {
        return (((this.getCosto() * q) - this.descuento(q)) + this.getPlus());
    }

    /**
     * Calcula el monto del descuento aplicable según la cantidad de etiquetas.
     *
     * @param q Cantidad de etiquetas.
     * @return El monto del descuento a aplicar.
     */
    private double descuento(int q) {
        if (q <= 10) {
            return 0;
        } else if (q > 10 && q <= 50) {
            return ((this.getCosto() * q) * 0.02);
        } else if (q > 50 && q <= 100) {
            return ((this.getCosto() * q) * 0.05);
        }
        return ((this.getCosto() * q) * (0.01 * (q / 10)));
    }

    /**
     * Devuelve una representación en cadena de la etiqueta, incluyendo el plus de diseño.
     *
     * @return Una cadena formateada con la descripción de la etiqueta.
     */
    public String toString() {
        return (super.toString() + "- Diseño: $" + this.getPlus());
    }

    /**
     * Devuelve el tipo de la etiqueta.
     *
     * @return La cadena "Comun".
     */
    protected String tipo() {
        return "Comun";
    }
}
