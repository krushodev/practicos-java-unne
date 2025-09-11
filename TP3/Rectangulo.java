/**
 * Representa una figura de Rectángulo en un plano 2D.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Rectangulo
{
    private Punto origen;
    private double ancho;
    private double alto;
    
    /**
     * Constructor que crea un rectángulo con un origen, ancho y alto específicos.
     * @param p_origen Punto de origen del rectángulo (esquina superior izquierda).
     * @param p_ancho Ancho del rectángulo.
     * @param p_alto Alto del rectángulo.
     */
    public Rectangulo(Punto p_origen, double p_ancho, double p_alto)
    {
        this.setOrigen(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }
    
    /**
     * Constructor que crea un rectángulo con un ancho y alto específicos, en el origen (0,0).
     * @param p_ancho Ancho del rectángulo.
     * @param p_alto Alto del rectángulo.
     */
    public Rectangulo(double p_ancho, double p_alto)
    {
        this.setOrigen(new Punto(0.0, 0.0));
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }
    
    /** Asigna el punto de origen. @param p_origen Punto a asignar. */
    private void setOrigen(Punto p_origen) {
        this.origen = p_origen;
    }
    
    /** Asigna el ancho. @param p_ancho Ancho a asignar. */ 
    private void setAncho(double p_ancho) {
        this.ancho = p_ancho;
    }
    
    /** Asigna el alto. @param p_alto Alto a asignar. */ 
    private void setAlto(double p_alto) {
        this.alto = p_alto;
    }

    /** @return Devuelve el punto de origen del rectángulo. */
    public Punto getOrigen() {
        return this.origen;
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
     * Desplaza el origen del rectángulo una cantidad dada en X y Y.
     * @param p_dx Desplazamiento en X.
     * @param p_dy Desplazamiento en Y.
     */
    public void desplazar(double p_dx, double p_dy) {
        this.origen.desplazar(p_dx, p_dy);
    }

    /**
     * Muestra las características del rectángulo (origen, alto, ancho, superficie y perímetro).
     */
    public void caracteristicas() {
        System.out.println("****** Rectangulo ******"); 
        System.out.println("Origen: " + this.origen.coordenadas() + " - Alto: " + this.alto + " - Ancho: " + this.ancho);
        System.out.println("Superficie: " + this.superficie() + "  - Perímetro: " + this.perimetro());
    }

    /**
     * Calcula y devuelve el perímetro del rectángulo.
     * @return El perímetro del rectángulo.
     */
    public double perimetro() {
        return 2 * (this.ancho + this.alto);
    }

    /**
     * Calcula y devuelve la superficie del rectángulo.
     * @return La superficie del rectángulo.
     */
    public double superficie() {
        return this.ancho * this.alto;
    }

    /**
     * Calcula la distancia entre el origen de este rectángulo y el de otro.
     * @param otroRectangulo El otro rectángulo.
     * @return La distancia entre los orígenes.
     */
    public double distanciaA(Rectangulo otroRectangulo) {
        return this.origen.distanciaA(otroRectangulo.getOrigen());
    }

    /**
     * Compara este rectángulo con otro y devuelve el de mayor superficie.
     * @param otroRectangulo El otro rectángulo para comparar.
     * @return El rectángulo con mayor superficie.
     */
    public Rectangulo elMayor(Rectangulo otroRectangulo) {
        if (this.superficie() >= otroRectangulo.superficie()) {
            return this;
        } else {
            return otroRectangulo;
        }
    }
    
}
