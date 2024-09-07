import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        String rutaCSV = "libros.csv";
        biblioteca.cargarLibrosDesdeCSV(rutaCSV);

        Miembro miembro1 = new Miembro(1, "Juan");
        Miembro miembro2 = new Miembro(2, "Ana");
        
        biblioteca.agregarMiembro(miembro1);
        biblioteca.agregarMiembro(miembro2);

        System.out.println("**Bienvenido**");
        System.out.println("Elije la opción que desees realizar:");
        System.out.println("1. Solicitar préstamo");
        System.out.println("2. Devolver libro");
        System.out.println("3. Agregar sucursal");
        System.out.println("4. Generar reporte");
        System.out.println("5. Salir");

        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1:
                System.out.println("Ingresa tu miembro ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();  
                System.out.println("Ingresa la sucursal: ");
                int sucursal = scanner.nextInt();
                System.out.println("Ingresa el ISBN del libro que deseas prestar: ");
                int libroID = scanner.nextInt();
                scanner.nextLine(); 

                Miembro miembro = biblioteca.getMiembroPorID(id);
                if (miembro != null) {
                    LocalDate fechaPrestamo = LocalDate.now();
                    miembro.solicitarLibro(libroID, fechaPrestamo);

                    System.out.println("El préstamo fue realizado exitosamente");
                    System.out.println("Fecha de préstamo: " + miembro.getFechaP());
                    System.out.println("Fecha de devolución: " + miembro.getFechaD());
                } else {
                    System.out.println("No se encontró el miembro con ID: " + id);
                }
                break;

            case 2:
                System.out.println("Ingresa tu miembro ID: ");
                int m_id = scanner.nextInt();
                scanner.nextLine();  
                System.out.println("Ingresa la sucursal: ");
                int m_sucursal = scanner.nextInt();
                System.out.println("Ingresa el ISBN del libro que deseas devolver: ");
                int m_libroID = scanner.nextInt();
                scanner.nextLine(); 

                Miembro miembroDevolver = biblioteca.getMiembroPorID(m_id);
                if (miembroDevolver != null) {
                    miembroDevolver.devolucion(m_libroID);

                    System.out.println("La devolución fue realizada exitosamente");
                } else {
                    System.out.println("No se encontró el miembro con ID: " + m_id);
                }
                break;

            case 3:
                System.out.println("Ingresa el nombre de la nueva sucursal: ");
                String name = scanner.nextLine();
                biblioteca.agregarSucursales(name);
                System.out.println("La sucursal " + name + " fue añadida con éxito");
                break;

            case 4:
                System.out.println("Ingresa el mes para el reporte (formato YYYY-MM): ");
                String fecha = scanner.nextLine();
                LocalDate mes = LocalDate.parse(fecha + "-01");
                biblioteca.generarReporte(mes);
                break;

            case 5:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }

        scanner.close();
    }
}
