import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Miembro {
    private int ID;
    private String nombre;
    private LocalDate fechaP; 
    private LocalDate fechaD; 
    private ArrayList<String> prestamosActivos; 
    private ArrayList<String> prestamos;

    public Miembro(int ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
        this.fechaP = null;
        this.fechaD = null;
        this.prestamosActivos = new ArrayList<>();
        this.prestamos = new ArrayList<>(); 
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaP() {
        return fechaP;
    }

    public LocalDate getFechaD() {
        return fechaD;
    }

    public ArrayList<String> getPrestamos() {
        return prestamos;
    }

    public ArrayList<String> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void solicitarLibro(String libroID, LocalDate fechaP) {
        this.prestamos.add(libroID);
        this.prestamosActivos.add(libroID);
        this.fechaP = fechaP;
        this.fechaD = fechaP.plusDays(30);
    }

    public void devolucion(String libroID) {
        this.prestamosActivos.remove(libroID);
    }

    public String buscarLibro(int sucursal, String libroID, String rutaCSV) {
        String nombreLibro = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaCSV))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String b_sucursal = parts[5];

                if (b_sucursal.equals(String.valueOf(sucursal))) {
                    String isbn = parts[0];
                    if (isbn.equals(libroID)) {
                        nombreLibro = parts[1];
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: No se pudo leer el archivo CSV.");
        }

        return nombreLibro;
    }
}

