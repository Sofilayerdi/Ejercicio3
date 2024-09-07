import java.time.LocalDate;
import java.util.ArrayList;

public class Miembro {
    private int ID;
    private String nombre;
    private LocalDate fechaP; 
    private LocalDate fechaD; 
    private ArrayList<Integer> prestamosActivos; 
    private ArrayList<Integer> prestamos;

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

    public ArrayList<Integer> getPrestamos() {
        return prestamos;
    }

    public ArrayList<Integer> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void solicitarLibro(int isbn, LocalDate fechaP) {
        this.prestamos.add(isbn);
        this.prestamosActivos.add(isbn);
        this.fechaP = fechaP;
        this.fechaD = fechaP.plusDays(30);
    }

    public void devolucion(int isbn) {
        this.prestamosActivos.remove((Integer) isbn);
    }

    public ArrayList<Integer> getLibrosPrestadosMes(LocalDate mes) {
        ArrayList<Integer> librosMes = new ArrayList<>();
        for (int isbn : prestamos) {
            if (fechaP != null && fechaP.getMonth().equals(mes.getMonth()) && fechaP.getYear() == mes.getYear()) {
                librosMes.add(isbn);
            }
        }
        return librosMes;
    }
}