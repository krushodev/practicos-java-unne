/**
 * Representa una cocina, extendiendo la clase ArtefactoHogar para incluir
 * atributos específicos como número de hornallas, capacidad calórica y dimensiones.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Cocina extends ArtefactoHogar {
    private int hornallas;
    private int calorias;
    private String dimensiones;

    /**
     * Constructor para instanciar un objeto Cocina con todos sus atributos.
     * @param p_marca       Marca de la cocina.
     * @param p_precio      Precio de venta.
     * @param p_stock       Unidades disponibles en stock.
     * @param p_hornallas   Número de hornallas.
     * @param p_calorias    Capacidad calórica.
     * @param p_dimensiones Dimensiones físicas en formato texto (e.g., "80x60x60cm").
     */
    public Cocina(String p_marca, float p_precio, int p_stock, int p_hornallas, int p_calorias, String p_dimensiones) {
        super(p_marca, p_precio, p_stock);
        this.setHornallas(p_hornallas);
        this.setCalorias(p_calorias);
        this.setDimensiones(p_dimensiones);
    }

    /** Asigna el número de hornallas. @param p_hornallas La cantidad de hornallas a asignar. */
    private void setHornallas(int p_hornallas) {
        this.hornallas = p_hornallas;
    }

    /** @return Devuelve el número de hornallas. */
    public int getHornallas() {
        return this.hornallas;
    }

    /** Asigna la capacidad calórica. @param p_calorias El valor de calorías a asignar. */
    private void setCalorias(int p_calorias) {
        this.calorias = p_calorias;
    }

    /** @return Devuelve la capacidad calórica. */
    public int getCalorias() {
        return this.calorias;
    }

    /** Asigna las dimensiones físicas. @param p_dimensiones El texto de las dimensiones a asignar. */
    private void setDimensiones(String p_dimensiones) {
        this.dimensiones = p_dimensiones;
    }

    /** @return Devuelve las dimensiones físicas como cadena de texto. */
    public String getDimensiones() {
        return this.dimensiones;
    }

    /**
     * Imprime en consola un resumen con los datos de la cocina,
     * incluyendo los atributos heredados de ArtefactoHogar.
     */
    public void imprimir() {
        System.out.println("**** Cocina ****");
        super.imprimir();
        System.out.println("Hornallas: " + this.getHornallas());
        System.out.println("Calorias: " + this.getCalorias());
        System.out.println("Dimensiones: " + this.getDimensiones());
    }

    /**
     * Calcula el valor de la cuota de un crédito. Para este artefacto, no se
     * aplican costos adicionales, por lo que el método invoca directamente al
     * cálculo de cuota de la clase padre.
     *
     * @param p_cuotas  Número de cuotas para el crédito.
     * @param p_interes Interés total a aplicar sobre el precio.
     * @return El valor final de la cuota.
     */
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        return this.cuotaCredito(p_cuotas, p_interes);
    }
}
