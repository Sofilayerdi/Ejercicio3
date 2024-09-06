import java.util.ArrayList;
import java.util.Date;

public class Miembro {
    private int ID;
    private String nombre;
    private Date fechaP; 
    private Date fechaD; 
    private ArrayList<String> prestamos; 

    public Miembro(int ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
        this.fechaP = fechaP;
        this.fechaD = fechaD;
        this.prestamos = new ArrayList<>(); 
    }

    public int getID() {
        return ID;
    }


    public String getNombre() {
        return nombre;
    }

    public Date getFechaP() {
        return fechaP;
    }

    public Date getFechaD() {
        return fechaD;
    }

    public ArrayList<String> getPrestamos() {
        return prestamos;
    }


    public void solicitarLibro(String libro, Date fechaP, Date fechaD) {
        this.prestamos.add(libro);
        this.fechaP = fechaP;
        this.fechaD = fechaD + 30;
    }

    public void devolucion(String libro) {
        if (this.prestamos.contains(libro)) {
            this.prestamos.remove(libro);
        }

    }
}
