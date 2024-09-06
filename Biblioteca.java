package Ejercicio_3.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private int sucursal;
    private List<Libro> libros;
    private List<Miembro> prestamos;

    public Biblioteca(int sucursal){
        this.sucursal = sucursal;
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro){
        libros.add(libro);
    }

    public void generarReporteGeneroMasSolicitado(String filesucursal){

    }

    public int getSucursal(){
        return sucursal;
    }
}
