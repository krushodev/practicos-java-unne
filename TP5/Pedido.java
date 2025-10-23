import java.util.ArrayList;

/**
 * Representa un pedido compuesto por una colección de renglones.
 * Cada renglón especifica una cantidad de un tipo particular de etiqueta.
 * Permite agregar, quitar y mostrar los renglones del pedido.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Pedido {
    private ArrayList<Renglon> renglones;

    /**
     * Constructor que inicializa un pedido con una lista de renglones preexistente.
     *
     * @param p_renglones Lista de renglones para iniciar el pedido.
     */
    public Pedido(ArrayList<Renglon> p_renglones) {
        this.setRenglones(p_renglones);
    }

    /**
     * Constructor que inicializa un pedido con un único renglón.
     *
     * @param p_renglon El primer renglón del pedido.
     */
    public Pedido(Renglon p_renglon) {
        this.renglones = new ArrayList<>();
        this.agregarRenglon(p_renglon);
    }

    /**
     * Asigna la lista de renglones del pedido.
     *
     * @param p_renglones La lista de renglones a asignar.
     */
    private void setRenglones(ArrayList<Renglon> p_renglones) {
        this.renglones = p_renglones;
    }

    /**
     * Devuelve la lista de renglones del pedido.
     *
     * @return Una lista de objetos Renglon.
     */
    public ArrayList<Renglon> getRenglones() {
        return this.renglones;
    }

    /**
     * Agrega un nuevo renglón al pedido.
     *
     * @param p_renglon El renglón a agregar.
     * @return `true` si el renglón fue agregado exitosamente.
     */
    public boolean agregarRenglon(Renglon p_renglon) {
        return this.getRenglones().add(p_renglon);
    }

    /**
     * Quita un renglón del pedido. La operación solo se realiza si hay más de un renglón.
     *
     * @param p_renglon El renglón a quitar.
     * @return `true` si el renglón fue quitado, `false` en caso contrario.
     */
    public boolean quitarRenglon(Renglon p_renglon) {
        if (this.cantidadRenglones() > 1) {
            return this.getRenglones().remove(p_renglon);
        }
        return false;
    }

    /**
     * Devuelve la cantidad total de renglones que componen el pedido.
     *
     * @return El número de renglones.
     */
    public int cantidadRenglones() {
        return this.getRenglones().size();
    }

    /**
     * Imprime en consola un resumen detallado del pedido, incluyendo cada ítem,
     * el total de etiquetas y el importe final.
     */
    public void mostrar() {
        int totalEtiqueta = 0;
        double totalPedido = 0;

        System.out.println("\nPedido:");
        System.out.println("Cantidad de items: " + this.cantidadRenglones());
        System.out.println("---------------------------------------------");

        for (Renglon unRenglon : this.getRenglones()) {
            System.out.println("Item " + (this.getRenglones().indexOf(unRenglon) + 1) + ":");
            unRenglon.mostrar();
            System.out.println("Precio: $" + unRenglon.getItem().precio(unRenglon.getCantidad()));
            System.out.println(" ");
            totalEtiqueta += unRenglon.getCantidad();
            totalPedido += unRenglon.getItem().precio(unRenglon.getCantidad());
        }

        System.out.println("---------------------------------------------");
        System.out.println("--Total pedido: " + totalEtiqueta +
                " Etiquetas por un importe de $" + String.format("%.2f", totalPedido));
    }
}

