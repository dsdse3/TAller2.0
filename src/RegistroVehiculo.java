import java.util.Scanner;

/**
 * Clase que permite el registro de un nuevo vehículo en el registro.
 */
public class RegistroVehiculo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registro de Nuevo Vehículo");
        System.out.print("Patente: ");
        String patente = scanner.nextLine();

        // Crear una instancia de RegistroVehiculos
        RegistroVehiculos registro = new RegistroVehiculos();

        if (registro.vehiculoExiste(patente)) {
            System.out.println("El vehículo con patente " + patente + " ya está registrado.");
        } else {
            // Si el vehículo no está registrado previamente, procede a la inscripción
            System.out.print("Número de Ruedas: ");
            int numRuedas = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea pendiente después de nextInt
            System.out.print("Tipo de Vehículo: ");
            String tipoVehiculo = scanner.nextLine();
            System.out.print("Número de Asientos: ");
            int numAsientos = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea pendiente después de nextInt
            System.out.print("Estado (Nuevo/Usado): ");
            String estado = scanner.nextLine();

            // Crear una instancia de Vehiculo
            Vehiculo nuevoVehiculo = new Vehiculo(patente, numRuedas, tipoVehiculo, numAsientos, estado);

            // Agregar el nuevo vehículo al registro
            registro.registrarVehiculo(nuevoVehiculo);

            System.out.println("Vehículo registrado con éxito.");
        }
    }
}
