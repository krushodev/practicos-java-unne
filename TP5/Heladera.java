/**
 * Representa una heladera, extendiendo la clase ArtefactoHogar para incluir
 * atributos específicos como capacidad, número de puertas y si posee compresor.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Heladera extends ArtefactoHogar {
    private int pies;
    private int puertas;
    private boolean compresor;

    /**
     * Constructor para instanciar un objeto Heladera con todos sus atributos.
     * @param p_marca     Marca de la heladera.
     * @param p_precio    Precio de venta.
     * @param p_stock     Unidades disponibles en stock.
     * @param p_pies      Capacidad en pies cúbicos.
     * @param p_puertas   Número de puertas.
     * @param p_compresor Indicador de si posee compresor (true/false).
     */
    public Heladera(String p_marca, float p_precio, int p_stock, int p_pies, int p_puertas, boolean p_compresor) {
        super(p_marca, p_precio, p_stock);
        this.setPies(p_pies);
        this.setPuertas(p_puertas);
        this.setCompresor(p_compresor);
    }

    /** Asigna la capacidad en pies cúbicos. @param p_pies La capacidad a asignar. */
    private void setPies(int p_pies) {
        this.pies = p_pies;
    }

    /** @return Devuelve la capacidad en pies cúbicos. */
    public int getPies() {
        return this.pies;
    }

    /** Asigna el número de puertas. @param p_puertas La cantidad de puertas a asignar. */
    private void setPuertas(int p_puertas) {
        this.puertas = p_puertas;
    }

    /** @return Devuelve el número de puertas. */
    public int getPuertas() {
        return this.puertas;
    }

    /** Asigna el estado del compresor. @param p_compresor `true` si posee, `false` si no. */
    private void setCompresor(boolean p_compresor) {
        this.compresor = p_compresor;
    }

    /** @return Devuelve `true` si posee compresor, `false` en caso contrario. */
    public boolean getCompresor() {
        return this.compresor;
    }

    /**
     * Imprime en consola un resumen con los datos de la heladera,
     * incluyendo los atributos heredados de ArtefactoHogar.
     */
    public void imprimir() {
        System.out.println("**** Heladera ****");
        super.imprimir();
        System.out.println("Pies: " + this.getPies());
        System.out.println("Puertas: " + this.getPuertas());
        System.out.println("Compresor: " + this.getCompresor());
    }

    /**
     * Calcula el valor de la cuota de un crédito, agregando un costo adicional
     * si la heladera posee compresor. El adicional es de $50 por cuota.
     *
     * @param p_cuotas  Número de cuotas para el crédito.
     * @param p_interes Interés total a aplicar sobre el precio.
     * @return El valor final de la cuota, incluyendo el adicional si corresponde.
     */
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        float cuotas = this.cuotaCredito(p_cuotas, p_interes);
        if (this.getCompresor()) {
            return cuotas + (50 * p_cuotas);
        }
        return cuotas;
    }
}
