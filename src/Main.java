
import AccesoDatos.ClienteData;
import AccesoDatos.DetalleVentasData;
import AccesoDatos.EmpleadoData;
import AccesoDatos.ProductoData;
import AccesoDatos.VentasData;
import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.Empleado;
import Entidades.Producto;
import Entidades.Venta;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
        ProductoData p1 = new ProductoData();
       Producto p = p1.buscarProducto(1);
        p.setNombreProducto("Heladera");
        p.setPrecioActual(600000);
      //  p1.modificarProducto(p);
        Producto p2 = new Producto(45, "Microondas", "Electrico", 500000, true);
     //    p1.guardarProducto(p2);
        // p1.eliminarProducto(1);

        // **********************************Clientes: ********************************************
        ClienteData clienteD = new ClienteData();
        Cliente c1 = new Cliente("Salgan", "Pablo", "Verutti 432, CABA", "1121878650");

        // Agregar Clientes a la BD
        // clienteD.guardarCliente(c1);
        // Buscar Cliente id
//        Cliente cli2 = clienteD.buscarCliente(2);
//        System.out.println(cli2.toString());
        // Modificar Cliente
//        Cliente cli3 = new Cliente(8, "Salgan", "Paula", "Verutti 432, CABA", "1121878650");
//        clienteD.modicifarCliente(cli3); 
//         System.out.println(cli3.toString());  
//        
//         Cliente cli4 = new Cliente(2, "Rivera", "Roberto", "Av. Rivadavia 2899", "1134567890", true);
//        clienteD.modicifarCliente(cli4);
//        System.out.println(cli4.toString());
//           
        //Eliminar Cliente
//        clienteD.eliminarCliente(2);
//        System.out.println(clienteD.buscarCliente(2).toString()); // da error por que no esta
        //Listar Cliente
//            List<Cliente> listaClientes = clienteD.listarClientes();
//            int cont = 0;
//            for (Cliente listaCliente : listaClientes) {
//                cont++;
//                System.out.println("Cliente: "+cont + ", "+listaCliente.toString());
//        }
        // **********************************Empleado: ********************************************
        EmpleadoData empleadoD = new EmpleadoData();

        // Guardar Empleado
        Empleado e1 = new Empleado("Gerardo", "Fabiani", 43567567, "Vendedor", "GerardoFabiani", "Fabiani2023", true);
//            empleadoD.guardarEmpleado(e1);
//        
        // Buscar Empelado
        //   System.out.println(empleadoD.buscarEmpleadoPorId(3).toString());

        //Modificar Empleado
//              Empleado e1= new Empleado(7, "Genaro", "Almeida", 43567567, "Vendedor", "GerardoFabiani", "Fabiani2023", true);
//              empleadoD.modificarEmpleadoPorId(e1);
//                               
        // Listar Empleados
//                     List<Empleado> listaempleados = empleadoD.listarEmpleado();
//                 for (Empleado listaempleado : listaempleados) {
//                     System.out.println(listaempleado.toString());
//        }
        //Eliminar Empleado
//                        empleadoD.eliminarEmpleadoPorId(7);
//                        System.out.println(empleadoD.buscarEmpleadoPorId(7));
        



                    // **********************************Ventas: ********************************************
        VentasData ventasD = new VentasData();
        Empleado e9 = empleadoD.buscarEmpleadoPorId(3);
        Cliente c9 = clienteD.buscarCliente(2);
        // Guardar Venta
          Venta v1= new Venta(c9, e9, LocalDate.of(2023, Month.OCTOBER, 10)); /// MODIFICAAAAR
//            ventasD.guardarVenta(v1);

        // Buscar Venta
//            System.out.println(ventasD.buscarVentaId(1));
        //Modificar Venta
//              Venta v1= new Venta(3, c9, e9, LocalDate.of(2023, Month.OCTOBER, 07));
//              ventasD.modificarVenta(v1);
//                               
        // Listar Venta Por Cliente
//                     List<Venta> listaVentas = ventasD.listarVentasDeCliente(c9);
//                 for (Venta lista : listaVentas) {
//                     System.out.println(lista.toString());
//        }

        // Listar Venta Por Fecha    VER CLASE VENTAS DATAAAAA hay COMENtARIO)
//                     List<Venta> listaVentas = ventasD.listarVentasPorFecha(v1);
//                 for (Venta lista : listaVentas) {
//                     System.out.println(lista.toString());
//                 }

        //Eliminar Venta
//                       Venta v1= new Venta(1, c9, e9, LocalDate.of(2023, Month.OCTOBER, 10), true);
//                       ventasD.modificarVenta(v1);
//                        System.out.println(ventasD.buscarVentaId(v1.getIdVenta()));
//    }

        //    Listar obtenerClientesPorProducto                     // VER AL CARGAR DETALLE DE VENTAS 
//                     List<Cliente> listaCliente = ventasD.obtenerClientesPorProducto(p2);
//                 for (Cliente lista : listaCliente) {
//                     System.out.println(lista.toString());
//        }
        
                        //Listar Productos Por Fecha    // VER NO FUNCIONAAAAAAA
//                     List<Producto> listaProductos = ventasD.obtenerProductosPorFecha(LocalDate.of(2023, Month.OCTOBER, 10));
//                 for (Producto lista : listaProductos) {
//                     System.out.println(lista.toString());
//                 }

        // **********************************Detalle de Venta: ********************************************
        DetalleVentasData detalleVentasD = new DetalleVentasData();

        // Guardar Detalle de Venta
          Venta v3 = ventasD.buscarVentaId(1);
//        DetalleVenta detalleV1 = new DetalleVenta(1, v3, 250000, p);
//         detalleVentasD.guardarDetalleVenta(detalleV1);
        
        // Buscar Detalle de Venta
//           System.out.println(detalleVentasD.buscarDetalleVenta(1).toString());

        //Modificar Detalle de Venta
              
//              int idDetVta = detalleVentasD.buscarDetalleVenta(1).getIdDetalleVenta();
//              DetalleVenta detalleV2= new DetalleVenta( idDetVta, 1, v3, 345987, p);
//              detalleVentasD.modificarDetalleVenta(detalleV2);
                               
        // Listar Detalle deVenta Por Producto
//                    ProductoData pd = new ProductoData();
//                    Producto prod4 = pd.buscarProducto(2);
//                    System.out.println("HOLA:  "+pd.buscarProducto(2).getIdProducto());
//                     List<DetalleVenta> listaDetalleVenta= detalleVentasD.listarDetalleVentaPorProducto(prod4);
//                 for (DetalleVenta prod : listaDetalleVenta ) {
//                     System.out.println(listaDetalleVenta.toString());
//        }

        //Eliminar Detalle de Venta
//                       detalleVentasD.eliminarDetalleVentaPorId(5);
//                        System.out.println(detalleVentasD.buscarDetalleVenta(5));
//                     

                 
                 
                 //INSERT INTO `detalledeventa`(`idDetalleVenta`, `cantidad`, `idVenta`, `precioVenta`, `idProducto`, `estado`) VALUES (null, 1, 1, 500000, 2, 1)

                 
                 
                 
                 ClienteData clienteDat = new ClienteData();
                 String Hola = "hola";
            if (Hola.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede haber campos vacios.");
            } else {
                System.out.println("-.------");
                try{
                Cliente cli = clienteD.buscarClientePorTel("1120232023");
                System.out.println("ver "+ cli.toString());
                if (cli == null) {
                    cli.setApellido("Ricardo");
                    cli.setNombre("Darin");
                    cli.setDomicilio("Pavon 244, CABA");
                    cli.setTelefono("1120232023");
                    System.out.println("Guardar "+ cli.getNombre());
                    clienteD.guardarCliente(cli);
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un producto similar, si desea modificar el producto"
                            + "vaya a la pestaña Modificar.");
                } 
                } catch (NullPointerException ex) {
        }
            }
                 
    }
}
