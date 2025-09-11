/**
 * Representa un Producto farmacéutico o de otro tipo. 
 * Contiene información de contacto y datos comerciales como el costo, stock, 
 * porcentaje de punto de reposición y existencia mínima. 
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Producto
{
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;

    /**
     * Constructor completo de Producto.
     * @param p_codigo Código del producto.
     * @param p_rubro Rubro del producto.
     * @param p_desc Descripción del producto.
     * @param p_costo Costo del producto.
     * @param p_porcPtoRepo Porcentaje de punto de reposición.
     * @param p_existMinima Existencia mínima.
     * @param p_lab Laboratorio asociado.
     */
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMinima, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMinima);
        this.setLaboratorio(p_lab);
    }

    /**
     * Constructor de Producto sin porcentaje de punto de reposición ni existencia mínima.
     * @param p_codigo Código del producto.
     * @param p_rubro Rubro del producto.
     * @param p_desc Descripción del producto.
     * @param p_costo Costo del producto.
     * @param p_lab Laboratorio asociado.
     */
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setPorcPtoRepo(0.0);
        this.setExistMinima(0);
        this.setLaboratorio(p_lab);
    }

    
    /** Asigna el código. @param p_codigo Código a asignar. */
    private void setCodigo(int p_codigo) {
        this.codigo = p_codigo;
    }
    
    /** Asigna el rubro. @param p_rubro Rubro a asignar. */
    private void setRubro(String p_rubro) {
        this.rubro = p_rubro;
    }
    
    /** Asigna la descripción. @param p_descripcion Descripción a asignar. */
    private void setDescripcion(String p_descripcion) {
        this.descripcion = p_descripcion;
    }

    /** Asigna el costo. @param p_costo Costo a asignar. */
    private void setCosto(double p_costo) {
        this.costo = p_costo;
    }
    
    /** Asigna el stock. @param p_stock Stock a asignar. */
    private void setStock(int p_stock) {
        this.stock = p_stock;
    }
    
    /** Asigna el porcentaje de punto de reposición. @param p_porcPtoRepo Porcentaje a asignar. */
    private void setPorcPtoRepo(double p_porcPtoRepo) {
        this.porcPtoRepo = p_porcPtoRepo;
    }
    
    /** Asigna la existencia mínima. @param p_existMinima Existencia a asignar. */
    private void setExistMinima(int p_existMinima) {
        this.existMinima = p_existMinima;
    }

    /** Asigna el laboratorio. @param p_lab Laboratorio a asignar. */
    private void setLaboratorio(Laboratorio p_lab) {
        this.laboratorio = p_lab;
    }

    /** @return Devuelve el código del producto. */
    public int getCodigo() {    
        return this.codigo;
    }
    
    /** @return Devuelve el rubro del producto. */
    public String getRubro() {
        return this.rubro;
    }
    
    /** @return Devuelve la descripción del producto. */
    public String getDescripcion() {
        return this.descripcion;
    }
    
    /** @return Devuelve el costo del producto. */
    public double getCosto() {
        return this.costo;
    }
    
    /** @return Devuelve el stock actual. */
    public int getStock() {
        return this.stock;
    }

    /** @return Devuelve el porcentaje de punto de reposición. */
    public double getPorcPtoRepo() {
        return this.porcPtoRepo;
    }
    
    /** @return Devuelve la existencia mínima. */
    public int getExistMinima() {
        return this.existMinima;
    }   

    /** @return Devuelve el laboratorio asociado. */
    public Laboratorio getLaboratorio() {
        return this.laboratorio;
    }
    
    
    /**
     * Muestra por consola la información detallada del producto y su laboratorio.
     */
    public void mostrar() {
        System.out.println(this.getLaboratorio().mostrar());  
        System.out.println("\n" + "Rubro: " + this.getRubro());
        System.out.println("Descripción: " + this.getDescripcion());
        System.out.println("Precio Costo:: " + this.getCosto());
        System.out.println("Stock: " + this.getStock() + "  -  Stock Valorizado: $" + this.stockValorizado());
    }

    /**
     * Ajusta el stock actual sumando o restando una cantidad.
     * @param p_cantidad La cantidad a agregar (si es positiva) o quitar (si es negativa).
     */
    public void ajuste(int p_cantidad) {
        this.setStock(this.getStock() + p_cantidad);
    }

    /**
     * Calcula el valor total del stock actual, aplicando un 12% de valorización.
     * @return El valor del stock.
     */
    public double stockValorizado() {
        double resultado = (this.getCosto() * this.getStock());
        
        return (resultado + (resultado * 0.12));
    }

    /**
     * Calcula el precio de lista del producto (costo + 12%).
     * @return El precio de lista.
     */
    public double precioLista() {
        return (this.getCosto() + (this.getCosto() * 0.12));
    }

    /**
     * Calcula el precio de contado del producto (precio de lista - 5%).
     * @return El precio de contado.
     */
    public double precioContado() {
       return (this.precioLista() * 0.95);
    }

    /**
     * Devuelve una línea de texto con la descripción y los precios del producto.
     * @return Un String formateado para listados.
     */
    public String mostrarLinea() {
        return this.getDescripcion() + "\t" + this.precioLista() + "\t" + this.precioContado(); 
    }

    /**
     * Ajusta el porcentaje del punto de reposición.
     * @param p_porce El nuevo porcentaje a establecer.
     */
    public void ajustarPtoRepo(double p_porce) {
        this.setPorcPtoRepo(p_porce);
    }

    /**
     * Ajusta la cantidad de existencia mínima.
     * @param p_cantidad La nueva cantidad a establecer.
     */
    public void ajustarExistMin(int p_cantidad) {
        this.setExistMinima(p_cantidad);
    }
}
