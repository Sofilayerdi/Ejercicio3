public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private int ano;
    private String genero;
    private int sucursal;

    public Libro(int isbn, String titulo, String autor, int ano, String genero, int sucursal){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.genero = genero;
        this.sucursal = sucursal;
    }
    public int getIsbn(){
        return isbn;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public int getAno(){
        return ano;
    }
    public String getGenero(){
        return genero;
    }
    public int getSucursal(){
        return sucursal;
    }
    public String toCSV(){
        return isbn + "," + titulo + "," + autor + "," + ano + "," + genero + "," + sucursal + "\n"; 
    }
}
