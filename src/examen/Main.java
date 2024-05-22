package examen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Crear empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Borrar empleado por DNI");
            System.out.println("4. Encontrar empleado con mayor media de parámetros");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    listarEmpleados();
                    break;
                case 3:
                    borrarEmpleadoPorDNI();
                    break;
                case 4:
                    encontrarEmpleadoConMayorMedia();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void crearEmpleado() {
        System.out.println("Ingrese el nombre del empleado:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el DNI del empleado:");
        String dni = scanner.nextLine();
        System.out.println("Ingrese el número de empleado:");
        int numeroEmpleado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        Empleado empleado = new Empleado(nombre, dni, numeroEmpleado);
        listaEmpleados.add(empleado);
        System.out.println("Empleado creado exitosamente.");
    }

    private static void listarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados para listar.");
        } else {
            System.out.println("Lista de empleados:");
            for (Empleado empleado : listaEmpleados) {
                System.out.println("Nombre: " + empleado.getNombre() + ", DNI: " + empleado.getDNI() + ", Número de empleado: " + empleado.getNumeroEmpleado());
            }
        }
    }

    private static void borrarEmpleadoPorDNI() {
        System.out.println("Ingrese el DNI del empleado a borrar:");
        String dni = scanner.nextLine();

        boolean empleadoEncontrado = false;
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getDNI().equals(dni)) {
                listaEmpleados.remove(empleado);
                System.out.println("Empleado con DNI " + dni + " borrado exitosamente.");
                empleadoEncontrado = true;
                break;
            }
        }
        if (!empleadoEncontrado) {
            System.out.println("No se encontró ningún empleado con el DNI especificado.");
        }
    }

    private static void encontrarEmpleadoConMayorMedia() {
        Empleado empleadoMaxMedia = Empleado.max(listaEmpleados);
        if (empleadoMaxMedia != null) {
            System.out.println("Empleado con mayor media de parámetros:");
            System.out.println("Nombre: " + empleadoMaxMedia.getNombre() + ", DNI: " + empleadoMaxMedia.getDNI() + ", Número de empleado: " + empleadoMaxMedia.getNumeroEmpleado());
            System.out.println("Media de parámetros: " + empleadoMaxMedia.calcularMedia());
        } else {
            System.out.println("No hay empleados para calcular la media.");
        }
    }
}
