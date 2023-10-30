import java.util.Scanner;

/**
 * Clase que permite la inscripción de un nuevo cliente en el registro.
 */
public class RegistroCliente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inscripción de Nuevo Cliente");
        System.out.print("RUT: ");
        String rut = scanner.nextLine();

        // Crear una instancia de RegistroClientes
        RegistroClientes registro = new RegistroClientes();

        if (registro.clienteExiste(rut)) {
            System.out.println("El cliente con RUT " + rut + " ya está inscrito.");
        } else {
            // Si el cliente no existe, procede a la inscripción
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Fecha de Nacimiento (dd/mm/yyyy): ");
            String fechaNacimiento = scanner.nextLine();
            System.out.print("Tipo de Licencia: ");
            String tipoLicencia = scanner.nextLine();

            // Crear una instancia de Cliente
            Cliente nuevoCliente = new Cliente(rut, nombre, apellido, fechaNacimiento, tipoLicencia);

            // Agregar el nuevo cliente al registro
            registro.agregarCliente(nuevoCliente);

            System.out.println("Cliente inscrito con éxito.");
        }
    }

    /**
     * Verifica si un cliente tiene algún arriendo activo.
     *
     * @param cliente El objeto Cliente cuyos arriendos se deben verificar.
     * @return true si el cliente tiene arriendos activos, false si no tiene ninguno.
     */
    public boolean clienteTieneArriendo(Cliente cliente) {
        for (Arriendo arriendo : cliente.getArriendos()) {
            // Lógica para verificar si el cliente ya tiene un arriendo
            // Debe implementarse la lógica para determinar si el cliente tiene un arriendo activo.
        }
        return false;
    }
}
