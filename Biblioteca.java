package Ejercicio_3.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nameSucursal;
    private int sucursal;
    private List<Biblioteca> sucursales;


    public Biblioteca(){
        this.sucursales = new ArrayList<>();
    }

    public Biblioteca(String nameSucursal,int sucursal){
        this.nameSucursal = nameSucursal;
        this.sucursal = sucursal;
    }

    public void generarReporteGeneroMasSolicitado(String filesucursal){

    }
    public void agregarSucursales(String nameSucursal){
        sucursal = sucursales.size() + 1;
        Biblioteca sucursalnueva = new Biblioteca(nameSucursal, sucursal);
        sucursales.add(sucursalnueva);
    }

    public List<Biblioteca> getSucursales(){
        return sucursales;
    }
}
