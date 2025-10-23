/**
 * Representa una figura de Rectángulo en un plano 2D.
 * Hereda de FiguraGeometrica, definiendo sus propiedades a partir de un punto
 * de origen, un ancho y un alto.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Rectangulo extends FiguraGeometrica {
    private double ancho;
    private double alto;

    /**
     * Constructor para instanciar un Rectángulo a partir de su origen, ancho y alto.
     *
     * @param p_origen Punto de origen del rectángulo (esquina superior izquierda).
     * @param p_ancho  Ancho del rectángulo.
     * @param p_alto   Alto del rectángulo.
     */
    public Rectangulo(Punto p_origen, double p_ancho, double p_alto) {
        super(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }

    /**
     * Constructor para instanciar un Rectángulo con un ancho y alto específicos,
     * ubicado en el origen de coordenadas (0,0).
     *
     * @param p_ancho Ancho del rectángulo.
     * @param p_alto  Alto del rectángulo.
     */
    public Rectangulo(double p_ancho, double p_alto) {
        super(new Punto(0.0, 0.0));
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }

    /** Asigna el ancho del rectángulo. @param p_ancho El ancho a asignar. */
    private void setAncho(double p_ancho) {
        this.ancho = p_ancho;
    }

    /** Asigna el alto del rectángulo. @param p_alto El alto a asignar. */
    private void setAlto(double p_alto) {
        this.alto = p_alto;
    }

    /** @return Devuelve el ancho del rectángulo. */
    public double getAncho() {
        return this.ancho;
    }

    /** @return Devuelve el alto del rectángulo. */
    public double getAlto() {
        return this.alto;
    }

    /**
     * Desplaza el origen del rectángulo en el plano.
     * @param p_dx Cantidad a desplazar en el eje X.
     * @param p_dy Cantidad a desplazar en el eje Y.
     */
    public void desplazar(double p_dx, double p_dy) {
        this.getOrigen().desplazar(p_dx, p_dy);
    }

    /**
     * Imprime en consola las características del rectángulo, incluyendo su origen,
     * dimensiones, superficie y perímetro.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        System.out
                .println("Origen: " + this.getOrigen().coordenadas() + " - Alto: " + this.getAlto() + " - Ancho: " + this.getAncho());
        System.out.println("Superficie: " + this.superficie() + "  - Perímetro: " + this.perimetro());
    }

    /**
     * Calcula el perímetro del rectángulo.
     * @return El perímetro del rectángulo.
     */
    public double perimetro() {
        return 2 * (this.getAncho() + this.getAlto());
    }

    /**
     * Calcula la superficie del rectángulo.
     * @return La superficie del rectángulo.
     */
    public double superficie() {
        return this.getAncho() * this.getAlto();
    }

    /**
     * Calcula la distancia euclidiana entre el origen de este rectángulo y otro.
     * @param otroRectangulo El otro rectángulo para la comparación.
     * @return La distancia entre los puntos de origen.
     */
    public double distanciaA(Rectangulo otroRectangulo) {
        return this.getOrigen().distanciaA(otroRectangulo.getOrigen());
    }

    /**
     * Compara la superficie de este rectángulo con otro y devuelve el de mayor área.
     * @param otroRectangulo El otro rectángulo para la comparación.
     * @return El objeto Rectangulo con la mayor superficie.
     */
    public Rectangulo elMayor(Rectangulo otroRectangulo) {
        if (this.superficie() >= otroRectangulo.superficie()) {
            return this;
        } else {
            return otroRectangulo;
        }
    }

    /**
     * Devuelve el nombre de la figura.
     * @return Una cadena de texto que identifica a la figura como "Rectángulo".
     */
    public String nombreFigura() {
        return "****** Rectángulo ******";
    }

    /**
     * Imprime en consola la superficie del rectángulo.
     */
    public void mostrarSuperficie() {
        System.out.println(this.nombreFigura());
        System.out.println("Superficie: " + this.superficie());
    }

}
