import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int op;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**Bienvenido**");
        System.out.println("Elije la opcion que desees realizar:");
        System.out.println("1. Solicitar prestamo");
        System.out.println("2. Devolver libro");
        System.out.println("3. Agregar sucursal");
        System.out.println("4. Generar reporte");
        System.out.println("5. Salir");
        int op = scanner.nextInt();
        scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader("libros.csv"))) {
            switch (op) {
                case 1:
                    System.out.println("Ingresa tu miembro ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.println("Ingresa tu nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa la sucursal: ");
                    int sucursal = scanner.nextInt();
                    System.out.println("Ingresa el ISBN del libro que deseas prestar: ");
                    String libroID = scanner.nextLine();
                    scanner.nextLine(); 

                    Miembro miembro = new Miembro(id, nombre);
                    String rutaCSV = "libros.csv"; 

                    try {
                        String nombreLibro = miembro.buscarLibro(sucursal, libroID, rutaCSV);

                        if (nombreLibro != null) {
                            LocalDate fechaPrestamo = LocalDate.now();
                            miembro.solicitarLibro(libroID, fechaPrestamo);

                            System.out.println("El prestamo fue realizado exitosamente");
                            System.out.println("Libro: " + nombreLibro);
                            System.out.println("Fecha de prestamo: " + miembro.getFechaP());
                            System.out.println("Fecha de devolucion: " + miembro.getFechaD());
                        } else {
                            System.out.println("No se encontró el libro con ISBN: " + libroID);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: El archivo CSV no fue encontrado.");
                    } catch (IOException e) {
                        System.out.println("Error: Ocurrió un problema al leer el archivo CSV.");
                    }
                    break;
                        
                case 2:
                    System.out.println("Ingresa tu miembro ID: ");
                    int m_id = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.println("Ingresa tu nombre: ");
                    String m_nombre = scanner.nextLine();
                    System.out.println("Ingresa la sucursal: ");
                    int m_sucursal = scanner.nextInt();
                    System.out.println("Ingresa el ISBN del libro que deseas devolver: ");
                    String m_libroID = scanner.nextLine();
                    scanner.nextLine(); 

                    
                    String d_rutaCSV = "libros.csv"; 

                    try {
                        String nombreLibro1 = miembro.buscarLibro(m_sucursal, m_libroID, d_rutaCSV);

                        if (nombreLibro1 != null) {
                            LocalDate fechaPrestamo = LocalDate.now();
                            miembro.devolucion(m_libroID);

                            System.out.println("La devolucion fue realizado exitosamente");
                            System.out.println("Libro: " + nombreLibro1);
                            
                        } else {
                            System.out.println("No se encontró el libro con ISBN: " + libroID);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: El archivo CSV no fue encontrado.");
                    } catch (IOException e) {
                        System.out.println("Error: Ocurrió un problema al leer el archivo CSV.");
                    }
                    break;

                case 3:
                    System.out.println("Ingresa el nombre de la nueva sucursal: ");
                    String name = scanner.nextLine();
                    System.out.println("I");
                    break;
                
                case 4:
                    break;
                    
                case 5:
                    break;
            
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        
    }
}
}