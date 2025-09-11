/**
 * Representa una figura de Círculo en un plano 2D.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Circulo
{
    private double radio;
    private Punto centro;

    /**
     * Constructor que crea un círculo con un radio y centro específicos.
     * @param p_radio Radio del círculo.
     * @param p_centro Punto central del círculo.
     */
    public Circulo(double p_radio, Punto p_centro)
    {
        this.setRadio(p_radio);
        this.setCentro(p_centro);
    }
    
    /**
     * Constructor por defecto. Crea un círculo con radio 0 en el origen (0.0, 0.0).
     */
    public Circulo()
    {
        this.setRadio(0.0);
        this.setCentro(new Punto(0.0, 0.0));
    }
    
    /** Asigna el radio. @param p_radio Radio a asignar. */
    private void setRadio(double p_radio) {
        this.radio = p_radio;
    }
    
    /** Asigna el punto central. @param p_centro Punto a asignar como centro. */ 
    private void setCentro(Punto p_centro) {
        this.centro = p_centro;
    }
    
    /** @return Devuelve el radio del círculo. */
    public double getRadio() {
        return this.radio;
    }
    
    /** @return Devuelve el punto central del círculo. */
    public Punto getCentro() {
        return this.centro;
    }

    /**
     * Desplaza el centro del círculo una cantidad dada en X y Y.
     * @param p_dx Desplazamiento en X.
     * @param p_dy Desplazamiento en Y.
     */
    public void desplazar(double p_dx, double p_dy) {
        this.centro.desplazar(p_dx, p_dy);
    }

    /**
     * Muestra las características del círculo (centro, radio, superficie y perímetro).
     */
    public void caracteristicas() {
        System.out.println("****** Circulo ******"); 
        System.out.println("Centro: " + this.centro.coordenadas() + " - Radio: " + this.radio);
        System.out.println("Superficie: " + this.superficie() + "  - Perímetro: " + this.perimetro());
    }

    /**
     * Calcula y devuelve el perímetro del círculo.
     * @return El perímetro del círculo.
     */
    public double perimetro() {
        return 2 * Math.PI * this.radio;
    }

    /**
     * Calcula y devuelve la superficie del círculo.
     * @return La superficie del círculo.
     */
    public double superficie() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    /**
     * Calcula la distancia entre el centro de este círculo y el de otro círculo.
     * @param otroCirculo El otro círculo.
     * @return La distancia entre los centros.
     */
    public double distanciaA(Circulo otroCirculo) {
        return this.centro.distanciaA(otroCirculo.getCentro());
    }

    /**
     * Compara este círculo con otro y devuelve el de mayor superficie.
     * @param otroCirculo El otro círculo para comparar.
     * @return El círculo con mayor superficie.
     */
    public Circulo elMayor(Circulo otroCirculo) {
        if (this.superficie() >= otroCirculo.superficie()) {
            return this;
        } else {
            return otroCirculo;
        }
    }
    
}
