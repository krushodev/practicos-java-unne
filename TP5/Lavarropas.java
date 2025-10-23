/**
 * Representa un lavarropas, extendiendo la clase ArtefactoHogar para incluir
 * atributos específicos como cantidad de programas, capacidad de carga y si es automático.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Lavarropas extends ArtefactoHogar
{
    private int programas;
    private float kilos;
    private boolean automatico;

    /**
     * Constructor para instanciar un objeto Lavarropas con todos sus atributos.
     * @param p_marca      Marca del lavarropas.
     * @param p_precio     Precio de venta.
     * @param p_stock      Unidades disponibles en stock.
     * @param p_programas  Cantidad de programas de lavado.
     * @param p_kilos      Capacidad de carga en kilogramos.
     * @param p_automatico Indicador de si es automático (true/false).
     */
    public Lavarropas(String p_marca, float p_precio, int p_stock, int p_programas, 
                      float p_kilos, boolean p_automatico)
    {
        super(p_marca, p_precio, p_stock);
        this.setProgramas(p_programas);
        this.setKilos(p_kilos);
        this.setAutomatico(p_automatico);
    }

    /** Asigna la cantidad de programas. @param p_programas El número de programas a asignar. */
    private void setProgramas(int p_programas){
        this.programas = p_programas;
    }

    /** @return Devuelve la cantidad de programas. */
    public int getProgramas(){
        return this.programas;
    }

    /** Asigna la capacidad de carga. @param p_kilos La capacidad en kilogramos a asignar. */
    private void setKilos(float p_kilos){
        this.kilos = p_kilos;
    }

    /** @return Devuelve la capacidad de carga en kilogramos. */
    public float getKilos(){
        return this.kilos;
    }

    /** Asigna el modo de funcionamiento. @param p_automatico `true` si es automático, `false` si no. */
    private void setAutomatico(boolean p_automatico){
        this.automatico = p_automatico;
    }

    /** @return Devuelve `true` si es automático, `false` en caso contrario. */
    public boolean getAutomatico(){
        return this.automatico;
    }

    /**
     * Imprime en consola un resumen con los datos del lavarropas,
     * incluyendo los atributos heredados de ArtefactoHogar.
     */
    public void imprimir(){
        System.out.println("**** Lavarropas ****");
        super.imprimir();
        System.out.println("Programas: " + this.getProgramas());
        System.out.println("Kilos: " + this.getKilos());
        System.out.println("Automatico: " + this.getAutomatico());
    }

    /**
     * Calcula el valor de la cuota de un crédito, aplicando un descuento si el
     * lavarropas no es automático. El descuento es del 2% sobre el valor de la cuota.
     *
     * @param p_cuotas  Número de cuotas para el crédito.
     * @param p_interes Interés total a aplicar sobre el precio.
     * @return El valor final de la cuota, incluyendo el descuento si corresponde.
     */
    public float creditoConAdicional(int p_cuotas, float p_interes){
        float cuotas = this.cuotaCredito(p_cuotas, p_interes);
        if(this.getAutomatico()){
            return cuotas;   
        } else {
            return cuotas * 0.98f; // 2% de descuento
        }
    }
}
