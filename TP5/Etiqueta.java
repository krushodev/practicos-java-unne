/**
 * Clase abstracta que representa una etiqueta genérica.
 * Define la estructura base para distintos tipos de etiquetas, estableciendo
 * un costo y un comportamiento común para el cálculo de precios.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public abstract class Etiqueta {
    private double costo;

    /**
     * Constructor para inicializar una etiqueta con su costo base.
     *
     * @param p_costo Costo base de la etiqueta.
     */
    public Etiqueta(double p_costo) {
        this.setCosto(p_costo);
    }

    /**
     * Asigna el costo base de la etiqueta.
     *
     * @param p_costo Costo a asignar.
     */
    private void setCosto(double p_costo) {
        this.costo = p_costo;
    }

    /**
     * Devuelve el costo base de la etiqueta.
     *
     * @return El costo de la etiqueta.
     */
    public double getCosto() {
        return this.costo;
    }

    /**
     * Devuelve una representación en cadena de la etiqueta, incluyendo su tipo y costo base.
     *
     * @return Una cadena formateada con la descripción de la etiqueta.
     */
    public String toString() {
        return ("tipo " + this.tipo() + " - Costo: $" + this.getCosto());
    }

    /**
     * Método abstracto para calcular el precio total según la cantidad de etiquetas.
     *
     * @param q Cantidad de etiquetas.
     * @return El precio total calculado.
     */
    public abstract double precio(int q);

    /**
     * Método abstracto que devuelve el tipo de etiqueta.
     *
     * @return Una cadena que identifica el tipo de etiqueta (ej. "Comun", "Premium").
     */
    protected abstract String tipo();
}
