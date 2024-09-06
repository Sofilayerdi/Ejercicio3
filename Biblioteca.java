package Ejercicio_3.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private int sucursal;
    private List<Biblioteca> sucursales;

    public Biblioteca(){
        this.sucursales = new ArrayList<>();
    }

    public Biblioteca(int sucursal){
        this.sucursal = sucursal;
    }

    public void generarReporteGeneroMasSolicitado(String filesucursal){

    }
    public void agregarSucursales(int sucursal){
        Biblioteca sucursalnueva = new Biblioteca(sucursal);
        sucursales.add(sucursalnueva);
    }
}
