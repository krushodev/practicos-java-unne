/**
 * Representa una Cuenta Corriente, un tipo de cuenta bancaria con un límite de descubierto.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class CuentaCorriente
{
    private int nroCuenta;
    private double saldo;
    private double limiteDescubierto;
    private Persona titular;

    /**
     * Constructor para crear una Cuenta Corriente con saldo inicial cero y límite de descubierto por defecto.
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular Objeto Persona que es titular de la cuenta.
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(0.0);
        this.setLimiteDescubierto(500);
        this.setTitular(p_titular);
    }

    /**
     * Constructor para crear una Cuenta Corriente con un saldo inicial específico.
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular Objeto Persona que es titular de la cuenta.
     * @param p_saldo Saldo inicial de la cuenta.
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(p_saldo);
        this.setLimiteDescubierto(500);
        this.setTitular(p_titular);
    }

    /** Asigna el número de cuenta. @param p_nroCuenta Número a asignar. */
    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }
    /** Asigna el saldo. @param p_saldo Saldo a asignar. */
    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }
    /** Asigna el límite de descubierto. @param p_limiteDescubierto Límite a asignar. */
    private void setLimiteDescubierto(double p_limiteDescubierto) {
        this.limiteDescubierto = p_limiteDescubierto;
    }
    /** Asigna el titular. @param p_titular Titular a asignar. */
    private void setTitular(Persona p_titular) {
        this.titular = p_titular;
    }
    /** @return Devuelve el número de cuenta. */
    public int getNroCuenta() {
        return this.nroCuenta;
    }
    /** @return Devuelve el saldo de la cuenta. */
    public double getSaldo() {
        return this.saldo;
    }
    /** @return Devuelve el límite de descubierto. */
    public double getLimiteDescubierto() {
        return this.limiteDescubierto;
    }
    /** @return Devuelve el titular de la cuenta. */
    public Persona getTitular() {
        return this.titular;
    }

    /**
     * Verifica si se puede realizar una extracción considerando el saldo y el límite de descubierto.
     * @param p_importe El monto que se desea extraer.
     * @return `true` si la extracción es posible, `false` en caso contrario.
     */
    private boolean puedeExtraer(double p_importe) {
        if (p_importe > (this.getSaldo() + this.getLimiteDescubierto())) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Realiza la operación de extracción, disminuyendo el saldo.
     * @param p_importe El monto a extraer.
     */
    private void extraccion(double p_importe) {
        this.setSaldo(this.getSaldo() - p_importe);
    }
    
    /**
     * Intenta extraer un importe de la cuenta. Si no es posible, muestra un mensaje de error.
     * @param p_importe El monto a extraer.
     */
    public void extraer(double p_importe) {
        if (this.puedeExtraer(p_importe)) {
            this.extraccion(p_importe);
        } else {
            System.out.println("El importe de extraccion sobrepasa el límite de descubierto!");
        }
    }
    
    /**
     * Deposita un importe en la cuenta, incrementando el saldo.
     * @param p_importe El monto a depositar.
     */
    public void depositar(double p_importe) {
        this.setSaldo(this.getSaldo() + p_importe);
    }
    
    /**
     * Muestra por consola los datos de la cuenta corriente.
     */
    public void mostrar() {
        System.out.println("- Cuenta Corriente - ");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + " - Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
        System.out.println("Descubierto: " + this.getLimiteDescubierto());
    }
}
