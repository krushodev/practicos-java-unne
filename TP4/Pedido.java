import java.util.*;

/**
 * Representa un pedido comercial que asocia un cliente con una colección de productos.
 * La clase gestiona la fecha del pedido, los productos incluidos y calcula los
 * montos totales según la modalidad de pago.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Pedido
{
    private Cliente cliente;
    private Calendar fecha;
    private ArrayList<Producto> productos;
    
    /**
     * Constructor para inicializar un objeto Pedido con una lista de productos preexistente.
     * @param p_fecha La fecha en que se realiza el pedido.
     * @param p_cliente El cliente que efectúa el pedido.
     * @param p_productos Una colección ArrayList de productos.
     */
    public Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList<Producto> p_productos) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }

    /**
     * Constructor para inicializar un objeto Pedido con un único producto.
     * Internamente, crea la colección de productos y añade el producto proporcionado.
     * @param p_fecha La fecha en que se realiza el pedido.
     * @param p_cliente El cliente que efectúa el pedido.
     * @param p_producto El producto inicial a agregar al pedido.
     */
    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList<Producto>());
        this.getProductos().add(p_producto);
    }

    /** Asigna el cliente asociado al pedido. @param p_cliente Objeto Cliente a asignar. */
    private void setCliente(Cliente p_cliente) {
        this.cliente = p_cliente;
    }
    /** Asigna la fecha del pedido. @param p_fecha Objeto Calendar a asignar. */
    private void setFecha(Calendar p_fecha) {
        this.fecha = p_fecha;
    }
    /** Asigna la colección de productos. @param p_productos Colección ArrayList a asignar. */
    private void setProductos(ArrayList<Producto> p_productos) {
        this.productos = p_productos;
    }

    /** @return Devuelve el objeto Cliente asociado al pedido. */
    public Cliente getCliente() {
        return this.cliente;
    }
    /** @return Devuelve el objeto Calendar con la fecha del pedido. */
    public Calendar getFecha() {
        return this.fecha;
    }
    /** @return Devuelve la colección ArrayList de productos del pedido. */
    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    /**
     * Calcula la suma de los precios de contado de todos los productos en el pedido.
     * @return El importe total del pedido para pago al contado.
     */
    public double totalAlContado() {
        double total = 0.0;
        
        for (Producto producto: this.getProductos()) {
            total += producto.precioContado();
        }
        
        return total;
    }
    
    /**
     * Calcula la suma de los precios de lista de todos los productos en el pedido.
     * @return El importe total del pedido para pago financiado.
     */
    public double totalFinanciado() {
        double total = 0.0;
        
        for (Producto producto: this.getProductos()) {
            total += producto.precioLista();
        }
        
        return total;
    }
    
    /**
     * Añade un producto a la colección de productos del pedido.
     * @param p_producto El objeto Producto a ser agregado.
     * @return `true` si la adición fue exitosa.
     */
    public boolean agregarProducto(Producto p_producto) {
        return this.getProductos().add(p_producto);
    }
    
    /**
     * Remueve un producto de la colección de productos del pedido.
     * @param p_producto El objeto Producto a ser removido.
     * @return `true` si la remoción fue exitosa.
     */
    public boolean quitarProducto(Producto p_producto) {
        return this.getProductos().remove(p_producto);
    }
    
    /**
     * Imprime en la consola un resumen formateado del pedido.
     * Muestra la fecha, el detalle de cada producto con sus precios,
     * y los importes totales (financiado y al contado).
     */
    public void mostrarPedido() {
        Calendar fecha = Calendar.getInstance();
        System.out.format("******* Detalle del pedido ******* Fecha: %tB %te, %tY%n", fecha, fecha, fecha);
        System.out.println("\n Producto\t Precio Lista\t Precio Contado");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Producto producto: this.getProductos()) {
            System.out.println(producto.mostrarLinea());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        
        System.out.println("*** Total ------ \t" + this.totalFinanciado() + "\t" + this.totalAlContado());
    }
    
}

