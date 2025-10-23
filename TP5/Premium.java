/**
 * Representa una etiqueta de tipo premium.
 * El precio de este tipo de etiqueta se ve afectado por la cantidad de colores
 * utilizados, aplicando un recargo porcentual sobre el costo base.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Premium extends Etiqueta {
    private int colores;

    /**
     * Constructor para inicializar una etiqueta premium.
     *
     * @param p_costo   Costo base por unidad.
     * @param p_colores Cantidad de colores de la etiqueta.
     */
    public Premium(double p_costo, int p_colores) {
        super(p_costo);
        this.setColores(p_colores);
    }

    /**
     * Asigna la cantidad de colores de la etiqueta.
     *
     * @param p_colores Número de colores a asignar.
     */
    private void setColores(int p_colores) {
        this.colores = p_colores;
    }

    /**
     * Devuelve la cantidad de colores de la etiqueta.
     *
     * @return El número de colores.
     */
    public int getColores() {
        return this.colores;
    }

    /**
     * Calcula el precio total para una cantidad `q` de etiquetas, sumando
     * el recargo por colores al costo base antes de multiplicar.
     *
     * @param q Cantidad de etiquetas.
     * @return El precio total calculado.
     */
    public double precio(int q) {
        return ((this.getCosto() + this.plus()) * q);
    }

    /**
     * Calcula el recargo porcentual a aplicar sobre el costo base, según la
     * cantidad de colores.
     *
     * @return El monto del recargo por colores.
     */
    private double plus() {
        if (this.getColores() == 2) {
            return (this.getCosto() * 0.05);
        } else if (this.getColores() == 3) {
            return (this.getCosto() * 0.07);
        } else if (this.getColores() > 3) {
            return (this.getCosto() * 0.03 * this.getColores());
        }
        return 0;
    }

    /**
     * Devuelve el tipo de la etiqueta.
     *
     * @return La cadena "Premium".
     */
    protected String tipo() {
        return "Premium";
    }

    /**
     * Devuelve una representación en cadena de la etiqueta, incluyendo la cantidad de colores.
     *
     * @return Una cadena formateada con la descripción de la etiqueta.
     */
    public String toString() {
        return (super.toString() + " - Colores:" + this.getColores());
    }
}
