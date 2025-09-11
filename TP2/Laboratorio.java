/**
 * Representa un Laboratorio farmacéutico o de productos.
 * Contiene información de contacto y datos comerciales como la compra mínima y día de entrega.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Laboratorio
{
    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima; 
    private int diaEntrega;

    /**
     * Constructor completo para crear un Laboratorio con todos sus datos.
     * @param p_nombre Nombre del laboratorio.
     * @param p_domicilio Domicilio del laboratorio.
     * @param p_telefono Teléfono de contacto.
     * @param p_compraMinima Monto de compra mínima.
     * @param p_diaEnt Día de entrega de pedidos.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMinima, int p_diaEnt)
    {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMinima(p_compraMinima);
        this.setDiaEntrega(p_diaEnt);
    }
    
    /**
     * Constructor para crear un Laboratorio con los datos de contacto básicos.
     * @param p_nombre Nombre del laboratorio.
     * @param p_domicilio Domicilio del laboratorio.
     * @param p_telefono Teléfono de contacto.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono)
    {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
    }
    
    /** Asigna el nombre. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
    /** Asigna el domicilio. @param p_domicilio Domicilio a asignar. */
    private void setDomicilio(String p_domicilio) {
        this.domicilio = p_domicilio;
    }
    
    /** Asigna el teléfono. @param p_telefono Teléfono a asignar. */
    private void setTelefono(String p_telefono) {
        this.telefono = p_telefono;
    }

    /** Asigna la compra mínima. @param p_compraMinima Monto a asignar. */
    private void setCompraMinima(int p_compraMinima) {
        this.compraMinima = p_compraMinima;
    }
    
    /** Asigna el día de entrega. @param p_diaEntrega Día a asignar. */
    private void setDiaEntrega(int p_diaEntrega) {
        this.diaEntrega = p_diaEntrega;
    }
    
    /** @return Devuelve el nombre del laboratorio. */
    public String getNombre() {
        return this.nombre;
    }
    
    /** @return Devuelve el domicilio del laboratorio. */
    public String getDomicilio() {
        return this.domicilio;
    }
    
    /** @return Devuelve el teléfono del laboratorio. */
    public String getTelefono() {
        return this.telefono;
    }
    
    /** @return Devuelve el monto de compra mínima. */
    public int getCompraMinima() {
        return this.compraMinima;
    }
    
    /** @return Devuelve el día de entrega. */
    public int getDiaEntrega() {
        return this.diaEntrega;
    }
    
    /**
     * Actualiza el valor de la compra mínima.
     * @param p_compraMin El nuevo monto de compra mínima.
     */
    public void nuevaCompraMinima(int p_compraMin) {
      this.setCompraMinima(p_compraMin);
    }
    
    /**
     * Actualiza el día de entrega.
     * @param p_diaEnt El nuevo día de entrega.
     */
    public void nuevoDiaEntrega(int p_diaEnt) {
       this.setDiaEntrega(p_diaEnt);
    }
    
    /**
     * Devuelve un resumen con los datos de contacto del laboratorio.
     * @return Un String formateado con nombre, domicilio y teléfono.
     */
    public String mostrar() {
        return "Laboratorio: " + this.getNombre() + "\n" + "Domicilio " + this.getDomicilio() + " - Teléfono: " + this.getTelefono(); 

    }
}
