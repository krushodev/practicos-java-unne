/**
 * Modela un Cliente con sus datos personales y un saldo asociado.
 * Permite gestionar el saldo a través de diferentes operaciones.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Cliente
{
    private int nroDNI;
    private String apellido;
    private String nombre;
    private double saldo;

    /**
     * Constructor para crear un nuevo Cliente.
     * @param p_nroDni DNI del cliente.
     * @param p_apellido Apellido del cliente.
     * @param p_nombre Nombre del cliente.
     * @param p_importe Saldo inicial del cliente.
     */
    public Cliente(int p_nroDni, String p_apellido, String p_nombre, double p_importe)
    {
        this.setNroDNI(p_nroDni);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSaldo(p_importe);
    }
    
    /** Asigna el DNI. @param p_nroDni DNI a asignar. */
    private void setNroDNI(int p_nroDni) {
        this.nroDNI = p_nroDni;
    }
    
    /** Asigna el apellido. @param p_apellido Apellido a asignar. */
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }
    
    /** Asigna el nombre. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /** Asigna el saldo. @param p_saldo Saldo a asignar. */
    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }

    /** @return Devuelve el DNI del cliente. */
    public int getNroDni() {
        return this.nroDNI;
    }
    
    /** @return Devuelve el nombre del cliente. */
    public String getNombre() {
        return this.nombre;
    }
    
    /** @return Devuelve el apellido del cliente. */
    public String getApellido() {
        return this.apellido;
    }
    
    /** @return Devuelve el saldo actual del cliente. */
    public double getSaldo() {
        return this.saldo;
    }
    
    /**
     * Reemplaza el saldo actual por un nuevo valor.
     * @param p_importe El nuevo saldo a establecer.
     * @return El nuevo saldo que fue establecido.
     */
    public double nuevoSaldo(double p_importe) {
      this.setSaldo(p_importe);
      
      return p_importe;
    }
    
    /**
     * Suma un importe al saldo actual del cliente.
     * @param p_importe El monto a agregar al saldo.
     * @return El saldo actualizado después de la suma.
     */
    public double agregaSaldo(double p_importe) {
       double nuevoSaldo = (this.getSaldo() + p_importe);
       this.setSaldo(nuevoSaldo);
       
       return nuevoSaldo;
    }
    
    /**
     * Concatena el apellido y el nombre del cliente.
     * @return Un String con el formato "Apellido Nombre".
     */
    public String apeYNom() {
       return this.getApellido() + " " + this.getNombre();
    }
    
    /**
     * Concatena el nombre y el apellido del cliente.
     * @return Un String con el formato "Nombre Apellido".
     */
    public String nomYApe() {
       return this.getNombre() + " " + this.getApellido();
    }
    
    /**
     * Muestra por consola la información del cliente, incluyendo DNI y saldo.
     */
    public void mostrar() {
        System.out.println("- Cliente -");
        System.out.println("Nombre y Apellido: " + this.nomYApe() + "(" + this.getNroDni() + ")");
        System.out.println("Saldo: $" + this.getSaldo());
    }
}
