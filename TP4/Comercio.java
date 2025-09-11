import java.util.*;

/**
 * Representa una entidad comercial que gestiona una nómina de empleados.
 * Utiliza una estructura de datos HashMap para un acceso y gestión eficientes
 * de los empleados, utilizando el CUIL como clave única.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Comercio {
    private String nombre;
    private HashMap<Long, Empleado> empleados;

    /**
     * Constructor para instanciar un objeto Comercio con un nombre y una nómina vacía.
     * @param p_nombre El nombre comercial a asignar.
     */
    public Comercio(String p_nombre) {
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap<Long, Empleado>());
    }

    /**
     * Constructor para instanciar un objeto Comercio con una nómina de empleados preexistente.
     * @param p_nombre El nombre comercial a asignar.
     * @param p_empleados Un objeto HashMap que contiene la nómina de empleados.
     */
    public Comercio(String p_nombre, HashMap<Long, Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }

    /** Asigna el nombre del comercio. @param p_nombre El nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /** Asigna la colección de empleados. @param p_empleados El objeto HashMap a asignar. */
    private void setEmpleados(HashMap<Long, Empleado> p_empleados) {
        this.empleados = p_empleados;
    }

    /** @return Devuelve el nombre del comercio. */
    public String getNombre() {
        return this.nombre;
    }

    /** @return Devuelve la colección HashMap de empleados. */
    public HashMap<Long, Empleado> getEmpleados() {
        return this.empleados;
    }

    /**
     * Agrega un nuevo empleado a la nómina del comercio.
     * El empleado es almacenado en el HashMap utilizando su CUIL como clave.
     * @param p_empleado El objeto Empleado a ser dado de alta.
     */
    public void altaEmpleado(Empleado p_empleado) {
        this.getEmpleados().put(p_empleado.getCuil(), p_empleado);
    }

    /**
     * Remueve un empleado de la nómina del comercio utilizando su CUIL.
     * @param p_cuil El CUIL del empleado a ser dado de baja.
     * @return El objeto Empleado que ha sido removido, o `null` si no se encontraba.
     */
    public Empleado bajaEmpleado(long p_cuil) {
        return this.getEmpleados().remove(p_cuil);
    }

    /**
     * Obtiene la cantidad total de empleados registrados en el comercio.
     * @return Un valor entero que representa el número de empleados.
     */
    public int cantidadDeEmpleados() {
        return this.getEmpleados().size();
    }

    /**
     * Verifica la existencia de un empleado en la nómina a partir de su CUIL.
     * @param p_cuil El CUIL del empleado a verificar.
     * @return `true` si el empleado se encuentra registrado, `false` en caso contrario.
     */
    public boolean esEmpleado(long p_cuil) {
        return this.getEmpleados().containsKey(p_cuil);
    }

    /**
     * Busca y devuelve un empleado de la nómina a partir de su CUIL.
     * @param p_cuil El CUIL del empleado a buscar.
     * @return El objeto Empleado correspondiente, o `null` si no se encuentra.
     */
    public Empleado buscarEmpleado(long p_cuil) {
        return this.getEmpleados().get(p_cuil);
    }

    /**
     * Imprime en consola el sueldo neto de un empleado específico.
     * @param p_cuil El CUIL del empleado cuyo sueldo neto se desea consultar.
     */
    public void sueldoNeto(long p_cuil) {
        Empleado empleado = this.buscarEmpleado(p_cuil);
        System.out.println("$" + empleado.sueldoNeto());
    }

    /**
     * Imprime en consola un reporte formateado con la nómina completa de empleados del comercio.
     */
    public void nomina() {
        System.out.println("****** Nomina de empleados de " + this.getNombre() + " ******");
        for (Empleado empleado : this.getEmpleados().values()) {
            System.out.println(empleado.mostrarLinea());
        }
    }

}

