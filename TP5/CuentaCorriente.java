/**
 * Representa una Cuenta Corriente, un tipo de cuenta bancaria que permite
 * un límite de descubierto.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class CuentaCorriente extends CuentaBancaria {
    private double limiteDescubierto;

    /**
     * Constructor para crear una Cuenta Corriente con saldo inicial cero y
     * un límite de descubierto por defecto de 500.
     *
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular   Objeto Persona que es titular de la cuenta.
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular, 0.0);
        this.setLimiteDescubierto(500);
    }

    /**
     * Constructor para crear una Cuenta Corriente con un saldo inicial específico
     * y un límite de descubierto por defecto de 500.
     *
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular   Objeto Persona que es titular de la cuenta.
     * @param p_saldo     Saldo inicial de la cuenta.
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setLimiteDescubierto(500);
    }

    /**
     * Asigna el límite de descubierto.
     * @param p_limiteDescubierto Límite a asignar.
     */
    private void setLimiteDescubierto(double p_limiteDescubierto) {
        this.limiteDescubierto = p_limiteDescubierto;
    }

    /**
     * Devuelve el límite de descubierto de la cuenta.
     * @return El límite de descubierto.
     */
    public double getLimiteDescubierto() {
        return this.limiteDescubierto;
    }

    /**
     * Evalúa si es posible realizar una extracción, considerando el saldo actual
     * más el límite de descubierto.
     *
     * @param p_importe El monto que se desea extraer.
     * @return `true` si la extracción es viable, `false` en caso contrario.
     */
    private boolean puedeExtraer(double p_importe) {
        return p_importe <= (this.getSaldo() + this.getLimiteDescubierto());
    }

    /**
     * Intenta realizar una extracción de la cuenta. La operación es exitosa
     * solo si el importe no supera el saldo más el límite de descubierto.
     *
     * @param p_importe El monto a extraer.
     * @return `true` si la extracción se realizó con éxito, `false` en caso contrario.
     */
    public boolean extraer(double p_importe) {
        if (!this.puedeExtraer(p_importe)) {
            System.out.println("El importe de extraccion sobrepasa el límite de descubierto!");
            return false;
        }

        return super.extraer(p_importe);
    }

    /**
     * Imprime en consola un resumen detallado de la cuenta corriente, incluyendo
     * su titular, saldo y límite de descubierto.
     */
    public void mostrar() {
        System.out.println("- Cuenta Corriente - ");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + " - Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
        System.out.println("Descubierto: " + this.getLimiteDescubierto());
    }

    /**
     * Proporciona un mensaje explicativo sobre por qué una extracción no pudo
     * realizarse.
     *
     * @param p_importe El monto que se intentó extraer.
     * @return Un String con el motivo del fallo, o una cadena vacía si no hay error.
     */
    public String xQNoPuedeExtraer(double p_importe) {
        if (p_importe > (this.getSaldo() + this.getLimiteDescubierto())) {
            return "El importe de extraccion sobrepasa el límite de descubierto!";
        }

        return super.xQNoPuedeExtraer(p_importe);
    }
}
