
import AccesoDatos.ClienteData;
import AccesoDatos.ProductoData;
import Entidades.Cliente;
import Entidades.Producto;
import java.util.ArrayList;
import java.util.List;

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

        // **********************************Clientes: ********************************************
        ClienteData clienteD = new ClienteData();
        Cliente c1 = new Cliente("Alvarez", "Juan", "Parana 345, CABA", "1187675234");

        // Agregar Clientes a la BD
        clienteD.guardarCliente(c1);

        // Buscar Cliente id
        Cliente cli2 = clienteD.buscarCliente(2);
        System.out.println(cli2.toString());
        
        // Modificar Cliente
        Cliente cli3 = new Cliente("Fernandez", "Carlos", "Tucuman 1890, CABA", "1121765544");
         clienteD.modicifarCliente(cli3); 
         System.out.println(cli3);       
                
        //Eliminar Cliente
        clienteD.eliminarCliente(3);
        clienteD.buscarCliente(3); // da error por que no esta

                //Listar Cliente
            List<Cliente> listaClientes = clienteD.listarClientes();
            int cont = 0;
            for (Cliente listaCliente : listaClientes) {
                cont++;
                System.out.println("Cliente: "+cont + ", "+listaCliente.getApellido() +"\n "+ listaCliente.getNombre());
        }
            
            
            
 
    }

}
