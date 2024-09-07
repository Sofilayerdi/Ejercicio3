import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private String nameSucursal;
    private int sucursal;
    private List<Biblioteca> sucursales;
    private List<Libro> libros; 
    private List<Miembro> miembros; 

    public Biblioteca() {
        this.sucursales = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.miembros = new ArrayList<>();
    }

    public void cargarLibrosDesdeCSV(String rutaCSV) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaCSV))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 6) {
                    System.out.println("Formato incorrecto en la línea: " + line);
                    continue;
                }

                try {
                    int isbn = Integer.parseInt(parts[0].trim());
                    String titulo = parts[1].trim();
                    String autor = parts[2].trim();
                    int ano = Integer.parseInt(parts[3].trim());
                    String genero = parts[4].trim();
                    int sucursal = Integer.parseInt(parts[5].trim());

                    Libro libro = new Libro(isbn, titulo, autor, ano, genero, sucursal);
                    libros.add(libro);
                } catch (NumberFormatException e) {
                    System.out.println("Error en el formato numérico en la línea: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: No se pudo leer el archivo CSV. " + e.getMessage());
        }
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

    public Libro buscarLibroPorISBN(int isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null;
    }

    public void generarReporte(LocalDate mes) {
        Map<String, Integer> conteoGenero = new HashMap<>();
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

        int libroMasPrestadoISBN = conteoLibro.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(-1);

        Libro libroMasPrestado = buscarLibroPorISBN(libroMasPrestadoISBN);

    }
}
