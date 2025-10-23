/**
 * Clase abstracta que modela las características y comportamientos comunes
 * de los artefactos del hogar. Define atributos básicos como marca, precio y stock.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public abstract class ArtefactoHogar {
    private String marca;
    private float precio;
    private int stock;

    /**
     * Constructor para inicializar un objeto ArtefactoHogar.
     * @param p_marca  Marca del artefacto.
     * @param p_precio Precio de venta.
     * @param p_stock  Unidades disponibles en stock.
     */
    public ArtefactoHogar(String p_marca, float p_precio, int p_stock) {
        this.setMarca(p_marca);
        this.setPrecio(p_precio);
        this.setStock(p_stock);
    }

    /** Asigna la marca del artefacto. @param p_marca La marca a asignar. */
    private void setMarca(String p_marca) {
        this.marca = p_marca;
    }

    /** @return Devuelve la marca del artefacto. */
    public String getMarca() {
        return this.marca;
    }

    /** Asigna el precio del artefacto. @param p_precio El precio a asignar. */
    private void setPrecio(float p_precio) {
        this.precio = p_precio;
    }

    /** @return Devuelve el precio del artefacto. */
    public float getPrecio() {
        return this.precio;
    }

    /** Asigna el stock disponible. @param p_stock La cantidad en stock a asignar. */
    private void setStock(int p_stock) {
        this.stock = p_stock;
    }

    /** @return Devuelve el stock disponible. */
    public int getStock() {
        return this.stock;
    }

    /**
     * Imprime en consola los datos básicos del artefacto: marca, precio y stock.
     */
    public void imprimir() {
        System.out.println("Marca: " + this.getMarca() +
                " - Precio: " + this.getPrecio() +
                " - Stock: " + this.getStock());
    }

    /**
     * Calcula el valor de una cuota de crédito simple.
     * @param p_cuotas  Número de cuotas.
     * @param p_interes Interés total a aplicar sobre el precio.
     * @return El valor de cada cuota.
     */
    public float cuotaCredito(int p_cuotas, float p_interes) {
        return (this.getPrecio() + p_interes) / p_cuotas;
    }

    /**
     * Método abstracto para calcular el valor de una cuota de crédito con
     * posibles costos o descuentos adicionales, a ser implementado por las subclases.
     *
     * @param p_cuota   Número de cuotas.
     * @param p_interes Interés total a aplicar sobre el precio.
     * @return El valor final de la cuota con adicionales.
     */
    abstract public float creditoConAdicional(int p_cuota, float p_interes);
}
