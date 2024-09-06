import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class Main {
    private int op1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**Bienvenido**");
        System.out.println("Elije la opcion que desees realizar:");
        System.out.println("1. Registrar datos de un libro");
        System.out.println("2. Solicitar prestamo");
        System.out.println("3. Devolver libro");
        System.out.println("4. Agregar sucursal");
        System.out.println("5. Generar reporte");
        System.out.println("6. Salir");
        int op1 = scanner.nextInt();
        scanner.nextLine();

        switch (op1) {
            case 1:
                System.out.println("Ingresa los datos solicitados:");
                System.out.println("ISBN del libro: ");
                int isbn = scanner.nextInt();
                System.out.println("Titulo del libro: ");
                String titulo = scanner.nextLine();
                System.out.println("Autor del libro: ");
                String autor = scanner.nextLine();
                System.out.println("Año del libro ");
                int ano = scanner.nextInt();
                System.out.println("Género del libro: ");
                String genero = scanner.nextLine();
                System.out.println("Sucursal del libro:");
                int sucursal = scanner.nextInt();
                Libro libro = new Libro(isbn, titulo, autor, ano, genero, sucursal);
                break;
                

            case 2:
                System.out.println("Ingresa tu miembro ID: ");
                int id = scanner.nextInt();
                System.out.println("Ingresa el ISBN del libro que deseas prestar: ");
                int libroID = scanner.nextInt();
                break;

            default:
                break;
        }


    }
}
