
import AccesoDatos.ProductoData;
import Entidades.Producto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rober
 */

// Rojo 120 Verde 186 Azul 123 (120, 186, 123)

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ProductoData p1 = new ProductoData();
//        Producto p = p1.buscarProducto(1);
//        p.setNombreProducto("Heladera");
//        p.setPrecioActual(600000);
//        p1.modificarProducto(p);
        Producto p2 = new Producto(50, "Horno Electrico", "Electrico", 200000, true);
       // p1.guardarProducto(p2);
       // p1.eliminarProducto(1);
    }
    
}
