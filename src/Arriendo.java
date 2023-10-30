import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un arriendo de un vehículo.
 */
class Arriendo {
    private Vehiculo vehiculo;
    private Cliente cliente;
    private int diasArriendo;

    /**
     * Constructor para crear un objeto Arriendo.
     *
     * @param vehiculo      El vehículo que se arrienda.
     * @param cliente       El cliente que realiza el arriendo.
     * @param diasArriendo La duración del arriendo en días.
     */
    public Arriendo(Vehiculo vehiculo, Cliente cliente, int diasArriendo) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.diasArriendo = diasArriendo;
    }

    // Getters y setters para los atributos, si es necesario.

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getDiasArriendo() {
        return diasArriendo;
    }

    public void setDiasArriendo(int diasArriendo) {
        this.diasArriendo = diasArriendo;
    }

    /**
     * Clase interna que representa un cliente que realiza el arriendo.
     */
    static class Cliente {
        private String rut;
        private String nombre;
        private String apellido;
        private String fechaNacimiento;
        private String tipoLicencia;

        /**
         * Constructor para crear un objeto Cliente.
         *
         * @param rut            El RUT del cliente.
         * @param nombre         El nombre del cliente.
         * @param apellido       El apellido del cliente.
         * @param fechaNacimiento La fecha de nacimiento del cliente.
         * @param tipoLicencia   El tipo de licencia del cliente.
         */
        public Cliente(String rut, String nombre, String apellido, String fechaNacimiento, String tipoLicencia) {
            this.rut = rut;
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaNacimiento = fechaNacimiento;
            this.tipoLicencia = tipoLicencia;
        }

        // Getters y setters para los atributos, si es necesario.

        public String getRut() {
            return rut;
        }

        public void setRut(String rut) {
            this.rut = rut;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getTipoLicencia() {
            return tipoLicencia;
        }

        public void setTipoLicencia(String tipoLicencia) {
            this.tipoLicencia = tipoLicencia;
        }

        private List<Arriendo> arriendos = new ArrayList<>();

        /**
         * Agrega un arriendo a la lista de arriendos del cliente.
         *
         * @param arriendo El arriendo a agregar.
         */
        public void agregarArriendo(Arriendo arriendo) {
            arriendos.add(arriendo);
        }

        /**
         * Obtiene la lista de arriendos del cliente.
         *
         * @return Un arreglo de objetos Arriendo que representa los arriendos del cliente.
         */
        public Arriendo[] getArriendos() {
            return arriendos.toArray(new Arriendo[0]);
        }
    }
}
