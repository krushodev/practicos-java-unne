/**
 * Representa una cuenta bancaria genérica.
 * Contiene información básica como número de cuenta, saldo y el titular asociado.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class CuentaBancaria
{
    private int nroCuenta;
    private double saldo;
    private Persona titular;

    /**
     * Constructor para crear una cuenta bancaria con saldo inicial cero.
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular Objeto Persona que es titular de la cuenta.
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0.0);
    }
    
    /**
     * Constructor para crear una cuenta bancaria con un saldo inicial específico.
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular Objeto Persona que es titular de la cuenta.
     * @param p_saldo Saldo inicial de la cuenta.
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }
    
    /** Asigna el número de cuenta. @param p_nroCuenta Número a asignar. */
    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }
    
    /** Asigna el saldo. @param p_saldo Saldo a asignar. */
    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
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
    
    /** @return Devuelve el titular de la cuenta. */
    public Persona getTitular() {
        return this.titular;
    }
    
    /**
     * Deposita un importe en la cuenta, incrementando el saldo.
     * @param p_importe Monto a depositar (debe ser mayor a cero).
     * @return El nuevo saldo de la cuenta.
     */
    public double depositar(double p_importe) {
        if (p_importe <= 0) {
            return 0.0;
        }
        
        double nuevoSaldo = this.getSaldo() + p_importe;
        
        setSaldo(nuevoSaldo);
        
        return nuevoSaldo;
    }
    
    /**
     * Extrae un importe de la cuenta, decrementando el saldo.
     * @param p_importe Monto a extraer (debe ser mayor a cero).
     * @return El nuevo saldo de la cuenta.
     */
    public double extraer(double p_importe) {
        if (p_importe <= 0) {
            return 0.0;
        }
        
        double nuevoSaldo = this.getSaldo() - p_importe;
        
        setSaldo(nuevoSaldo);
        
        return nuevoSaldo;
    }
    
    /**
     * Muestra por consola los datos de la cuenta bancaria.
     */
    public void mostrar() {
        System.out.println("- Cuenta Bancaria -");
        System.out.println("Titular: " + this.getTitular().nomYApe() + "(" + this.getTitular().edad() + " años)");
        System.out.println("Saldo: " + this.getSaldo());
    }
    
    /**
     * Devuelve una representación en String de la cuenta para resúmenes.
     * @return Un String con número de cuenta, titular y saldo.
     */
    public String toString() {
        return this.getNroCuenta() + "\t" + this.getTitular().nomYApe() + "\t" + this.getSaldo();
    }
    
}
