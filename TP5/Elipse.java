/**
 * Representa una figura de Elipse en un plano 2D.
 * Hereda de FiguraGeometrica, definiéndose por un semieje mayor, un semieje menor
 * y un punto de origen que actúa como su centro.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Elipse extends FiguraGeometrica {
    private double sEjeMayor;
    private double sEjeMenor;

    /**
     * Constructor para instanciar una Elipse con dimensiones y centro específicos.
     *
     * @param p_sEjeMayor Longitud del semieje mayor.
     * @param p_sEjeMenor Longitud del semieje menor.
     * @param p_centro    Punto central de la elipse.
     */
    public Elipse(double p_sEjeMayor, double p_sEjeMenor, Punto p_centro) {
        super(p_centro);
        this.setSEjeMayor(p_sEjeMayor);
        this.setSEjeMenor(p_sEjeMenor);
    }

    /**
     * Constructor por defecto. Instancia una elipse de tamaño nulo en el origen de coordenadas.
     */
    public Elipse() {
        super(new Punto(0.0, 0.0));
        this.setSEjeMayor(0.0);
        this.setSEjeMenor(0.0);
    }

    /** Asigna la longitud del semieje mayor. @param p_sEjeMayor La longitud a asignar. */
    private void setSEjeMayor(double p_sEjeMayor) {
        this.sEjeMayor = p_sEjeMayor;
    }

    /** Asigna la longitud del semieje menor. @param p_sEjeMenor La longitud a asignar. */
    private void setSEjeMenor(double p_sEjeMenor) {
        this.sEjeMenor = p_sEjeMenor;
    }

    /** @return Devuelve la longitud del semieje mayor. */
    public double getSEjeMayor() {
        return this.sEjeMayor;
    }

    /** @return Devuelve la longitud del semieje menor. */
    public double getSEjeMenor() {
        return this.sEjeMenor;
    }

    /**
     * Desplaza el centro de la elipse en el plano.
     * @param p_dx Cantidad a desplazar en el eje X.
     * @param p_dy Cantidad a desplazar en el eje Y.
     */
    public void desplazar(double p_dx, double p_dy) {
        this.getOrigen().desplazar(p_dx, p_dy);
    }

    /**
     * Imprime en consola las características de la elipse, incluyendo su centro,
     * semiejes y superficie.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        System.out.println("Centro: " + this.getOrigen().coordenadas() + " - Semieje Mayor: " + this.sEjeMayor
                + " - Semieje Menor: " + this.sEjeMenor);
        System.out.println("Superficie: " + this.superficie());
    }

    /**
     * Calcula la superficie de la elipse.
     * @return La superficie de la elipse.
     */
    public double superficie() {
        return Math.PI * this.getSEjeMayor() * this.getSEjeMenor();
    }

    /**
     * Calcula la distancia euclidiana entre el centro de esta elipse y otra.
     * @param otroElipse La otra elipse para la comparación.
     * @return La distancia entre los centros.
     */
    public double distanciaA(Elipse otroElipse) {
        return this.getOrigen().distanciaA(otroElipse.getOrigen());
    }

    /**
     * Compara la superficie de esta elipse con otra y devuelve la de mayor área.
     * @param otroElipse La otra elipse para la comparación.
     * @return El objeto Elipse con la mayor superficie.
     */
    public Elipse elMayor(Elipse otroElipse) {
        if (this.superficie() >= otroElipse.superficie()) {
            return this;
        } else {
            return otroElipse;
        }
    }

    /**
     * Devuelve el nombre de la figura.
     * @return Una cadena de texto que identifica a la figura como "Elipse".
     */
    public String nombreFigura() {
        return "****** Elipse ******";
    }

    /**
     * Imprime en consola la superficie de la elipse.
     */
    public void mostrarSuperficie() {
        System.out.println(this.nombreFigura());
        System.out.println("Superficie: " + this.superficie());
    }

}
