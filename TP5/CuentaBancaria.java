/**
 * Representa una cuenta bancaria genérica.
 * Contiene información básica como número de cuenta, saldo y el titular
 * asociado.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class CuentaBancaria {
    private int nroCuenta;
    private double saldo;
    private Persona titular;

    /**
     * Constructor para crear una cuenta bancaria con saldo inicial cero.
     *
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular   Objeto Persona que es titular de la cuenta.
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0.0);
    }

    /**
     * Constructor para crear una cuenta bancaria con un saldo inicial específico.
     *
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular   Objeto Persona que es titular de la cuenta.
     * @param p_saldo     Saldo inicial de la cuenta.
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }

    /** Asigna el número de cuenta. @param p_nroCuenta Número a asignar. */
    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }

    /**
     * Asigna el saldo de la cuenta.
     * * @param p_saldo Saldo a asignar.
     */
    protected void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }

    /** Asigna el titular. @param p_titular Titular a asignar. */
    private void setTitular(Persona p_titular) {
        this.titular = p_titular;
    }

    /**
     * Devuelve el número de cuenta.
     * * @return El número de cuenta.
     */
    public int getNroCuenta() {
        return this.nroCuenta;
    }

    /**
     * Devuelve el saldo actual de la cuenta.
     * * @return El saldo de la cuenta.
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Devuelve el objeto Persona titular de la cuenta.
     * * @return El titular de la cuenta.
     */
    public Persona getTitular() {
        return this.titular;
    }

    /**
     * Deposita un importe en la cuenta, incrementando el saldo.
     *
     * @param p_importe Monto a depositar (debe ser mayor a cero).
     * @return El nuevo saldo de la cuenta.
     */
    public double depositar(double p_importe) {
        if (p_importe > 0) {
            this.setSaldo(this.getSaldo() + p_importe);
        }
        return this.getSaldo();
    }

    /**
     * Extrae un importe de la cuenta, decrementando el saldo.
     * La operación solo se realiza si el importe es positivo.
     *
     * @param p_importe Monto a extraer.
     * @return `true` si la extracción fue posible (importe positivo), `false` en caso contrario.
     */
    public boolean extraer(double p_importe) {
        if (p_importe > 0) {
            this.setSaldo(this.getSaldo() - p_importe);
            return true;
        }
        return false;
    }

    /**
     * Imprime en consola los datos de la cuenta bancaria, incluyendo titular y saldo.
     */
    public void mostrar() {
        System.out.println("- Cuenta Bancaria -");
        System.out.println("Titular: " + this.getTitular().nomYApe() + "(" + this.getTitular().edad() + " años)");
        System.out.println("Saldo: " + this.getSaldo());
    }

    /**
     * Devuelve una representación en formato String de la cuenta.
     *
     * @return Un String con número de cuenta, nombre del titular y saldo.
     */
    public String toString() {
        return this.getNroCuenta() + "\t" + this.getTitular().nomYApe() + "\t" + this.getSaldo();
    }
    
    /**
     * Proporciona un mensaje explicativo sobre por qué una extracción no pudo
     * realizarse.
     *
     * @param p_importe El monto que se intentó extraer.
     * @return Un String con el motivo del fallo, o una cadena vacía si no hay error.
     */
    public String xQNoPuedeExtraer(double p_importe) {
        if (p_importe <= 0) {
            return "El importe a extraer debe ser mayor a cero.";
        }
        
        if (this.getSaldo() < p_importe) {
            return "Saldo insuficiente.";
        }

        return "";
    }

}
