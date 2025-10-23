/**
 * Representa una figura de Círculo, que es un caso especial de Elipse.
 * Hereda de la clase Elipse, donde los semiejes mayor y menor son iguales (el radio).
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Circulo extends Elipse {
    /**
     * Constructor para instanciar un Círculo a partir de su radio y centro.
     * Invoca al constructor de Elipse con el radio como valor para ambos semiejes.
     *
     * @param p_radio  Radio del círculo.
     * @param p_centro Punto central del círculo.
     */
    public Circulo(double p_radio, Punto p_centro) {
        super(p_radio, p_radio, p_centro);
    }

    /**
     * Constructor por defecto. Instancia un círculo de radio 0 en el origen de coordenadas.
     */
    public Circulo() {
        super(0.0, 0.0, new Punto(0.0, 0.0));
    }

    /** @return Devuelve el radio del círculo. */
    public double getRadio() {
        return this.getSEjeMayor();
    }

    /**
     * Desplaza el centro del círculo en el plano.
     * @param p_dx Cantidad a desplazar en el eje X.
     * @param p_dy Cantidad a desplazar en el eje Y.
     */
    public void desplazar(double p_dx, double p_dy) {
        this.getOrigen().desplazar(p_dx, p_dy);
    }

    /**
     * Imprime en consola las características del círculo, incluyendo su centro,
     * radio, superficie y perímetro.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        System.out.println("Centro: " + this.getOrigen().coordenadas() + " - Radio: " + this.getRadio());
        System.out.println("Superficie: " + this.superficie() + "  - Perímetro: " + this.perimetro());
    }

    /**
     * Calcula el perímetro del círculo (circunferencia).
     * @return El perímetro del círculo.
     */
    public double perimetro() {
        return 2 * Math.PI * this.getRadio();
    }

    /**
     * Calcula la superficie del círculo.
     * @return La superficie del círculo.
     */
    public double superficie() {
        return Math.PI * Math.pow(this.getRadio(), 2);
    }

    /**
     * Calcula la distancia euclidiana entre el centro de este círculo y otro.
     * @param otroCirculo El otro círculo para la comparación.
     * @return La distancia entre los centros.
     */
    public double distanciaA(Circulo otroCirculo) {
        return this.getOrigen().distanciaA(otroCirculo.getOrigen());
    }

    /**
     * Compara la superficie de este círculo con otro y devuelve el de mayor área.
     * @param otroCirculo El otro círculo para la comparación.
     * @return El objeto Circulo con la mayor superficie.
     */
    public Circulo elMayor(Circulo otroCirculo) {
        if (this.superficie() >= otroCirculo.superficie()) {
            return this;
        } else {
            return otroCirculo;
        }
    }

    /**
     * Devuelve el nombre de la figura.
     * @return Una cadena de texto que identifica a la figura como "Círculo".
     */
    public String nombreFigura() {
        return "****** Circulo ******";
    }

    /**
     * Imprime en consola la superficie del círculo.
     */
    public void mostrarSuperficie() {
        System.out.println(this.nombreFigura());
        System.out.println("Superficie: " + this.superficie());
    }

}
