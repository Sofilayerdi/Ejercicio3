import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

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

        switch (op) {
            case 1:
                System.out.println("Ingresa tu miembro ID: ");
                int id = scanner.nextInt();
                System.out.println("Ingresa el ISBN del libro que deseas prestar: ");
                int libroID = scanner.nextInt();
                break;
            case 2:
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