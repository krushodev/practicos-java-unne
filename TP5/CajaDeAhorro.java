/**
 * Representa una Caja de Ahorro, un tipo de cuenta bancaria con un límite de
 * extracciones.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class CajaDeAhorro extends CuentaBancaria {
    private int extraccionesPosibles;

    /**
     * Constructor para crear una Caja de Ahorro con saldo inicial cero y un
     * límite de 10 extracciones.
     *
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular   Objeto Persona que es titular de la cuenta.
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular, 0.0);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Constructor para crear una Caja de Ahorro con un saldo inicial específico
     * y un límite de 10 extracciones.
     *
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular   Objeto Persona que es titular de la cuenta.
     * @param p_saldo     Saldo inicial de la cuenta.
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Asigna la cantidad de extracciones permitidas.
     * * @param p_extraccionesPosibles Cantidad de extracciones a asignar.
     */
    private void setExtraccionesPosibles(int p_extraccionesPosibles) {
        this.extraccionesPosibles = p_extraccionesPosibles;
    }

    /**
     * Devuelve la cantidad de extracciones restantes.
     * * @return El número de extracciones posibles.
     */
    public int getExtraccionesPosibles() {
        return this.extraccionesPosibles;
    }

    /**
     * Evalúa si es posible realizar una extracción, considerando el saldo disponible
     * y el límite de extracciones.
     *
     * @param p_importe El monto que se desea extraer.
     * @return `true` si la extracción es viable, `false` en caso contrario.
     */
    private boolean puedeExtraer(double p_importe) {
        return (p_importe <= this.getSaldo()) && (this.getExtraccionesPosibles() > 0);
    }

    /**
     * Intenta realizar una extracción de la cuenta. La operación es exitosa
     * solo si el importe es válido, hay saldo suficiente y quedan extracciones
     * disponibles.
     *
     * @param p_importe El monto a extraer.
     * @return `true` si la extracción se realizó con éxito, `false` en caso contrario.
     */
    public boolean extraer(double p_importe) {
        if (this.puedeExtraer(p_importe)) {
            // Decrementa el contador solo si la extracción es exitosa
            if(super.extraer(p_importe)){
                this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
                return true;
            }
        }
        return false;
    }

    /**
     * Imprime en consola un resumen detallado de la caja de ahorro, incluyendo
     * su titular, saldo y extracciones restantes.
     */
    public void mostrar() {
        System.out.println("- Caja de Ahorro - ");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + " - Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
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

        if (this.getExtraccionesPosibles() <= 0) {
            return "No tiene habilitadas mas extracciones.";
        }

        return super.xQNoPuedeExtraer(p_importe);
    }
}
