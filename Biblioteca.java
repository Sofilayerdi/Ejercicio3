import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private String nameSucursal;
    private int sucursal;
    private List<Biblioteca> sucursales;
    private List<Libro> libros; // Lista de libros en la biblioteca
    private List<Miembro> miembros; // Lista de miembros en la biblioteca

    public Biblioteca() {
        this.sucursales = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.miembros = new ArrayList<>();
    }

    public Biblioteca(String nameSucursal, int sucursal) {
        this.nameSucursal = nameSucursal;
        this.sucursal = sucursal;
        this.sucursales = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.miembros = new ArrayList<>();
    }

    public void agregarSucursales(String nameSucursal) {
        int nuevaSucursal = sucursales.size() + 1;
        Biblioteca sucursalNueva = new Biblioteca(nameSucursal, nuevaSucursal);
        sucursales.add(sucursalNueva);
    }

    public List<Biblioteca> getSucursales() {
        return sucursales;
    }

    // Métodos para gestionar libros y miembros
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    public Miembro getMiembroPorID(int id) {
        for (Miembro miembro : miembros) {
            if (miembro.getID() == id) {
                return miembro;
            }
        }
        return null;
    }

    // Método para generar reporte
    public void generarReporte(LocalDate mes) {
        // Mapa para contar los libros por género
        Map<String, Integer> conteoGenero = new HashMap<>();
        // Mapa para contar los libros por ISBN
        Map<Integer, Integer> conteoLibro = new HashMap<>();

        for (Miembro miembro : miembros) {
            ArrayList<Integer> librosPrestadosMes = miembro.getLibrosPrestadosMes(mes);
            for (int isbn : librosPrestadosMes) {
                Libro libro = buscarLibroPorISBN(isbn);
                if (libro != null) {
                    conteoLibro.put(isbn, conteoLibro.getOrDefault(isbn, 0) + 1);
                    conteoGenero.put(libro.getGenero(), conteoGenero.getOrDefault(libro.getGenero(), 0) + 1);
                }
            }
        }

        // Encontrar el libro más prestado
        int libroMasPrestadoISBN = conteoLibro.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(-1);

        Libro libroMasPrestado = buscarLibroPorISBN(libroMasPrestadoISBN);

        // Mostrar resultados
        System.out.println("Reporte de libros prestados en " + mes.getMonth() + " " + mes.getYear());
        System.out.println("Libros por género:");
        for (Map.Entry<String, Integer> entry : conteoGenero.entrySet()) {
            System.out.println("Género: " + entry.getKey() + ", Cantidad: " + entry.getValue());
        }
        System.out.println("Libro más prestado:");
        if (libroMasPrestado != null) {
            System.out.println("ISBN: " + libroMasPrestado.getIsbn() + ", Título: " + libroMasPrestado.getTitulo() + ", Género: " + libroMasPrestado.getGenero());
        }
    }

    private Libro buscarLibroPorISBN(int isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null;
    }
}
