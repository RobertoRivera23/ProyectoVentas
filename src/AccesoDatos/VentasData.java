package AccesoDatos;

import Entidades.Cliente;
import Entidades.Producto;
import Entidades.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class VentasData {

    private Connection con = null;
    private Cliente cliente;
    private Producto producto;
    private Venta venta;

    public VentasData() {
        con = Conexion.getConexion();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

// Guardar ventas
    public void guardarVenta(Venta venta) {
        String sql = "INSERT INTO (idCliente, fechaVenta ) VALUES (? , ?) ";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getIdVenta());
            ps.setDate(2, Date.valueOf(venta.getFechaVenta()));
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                venta.setIdVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "La venta añadida con exito.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ventas " + ex);
        }
    }
//Listar todas las ventas en una fecha.

    public List<Venta> listarVentasPorFecha(Venta venta) {
        List<Venta> ventas = new ArrayList<>();
        ClienteData clienteData = new ClienteData();
        String sql = "SELECT * FROM venta WHERE fechaVenta = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf("fechaVenta"));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setCliente(clienteData.buscarCliente(rs.getInt("idCliente")));
                venta.setFechaVenta((rs.getDate("fechaVenta")));
                ventas.add(venta);
            } else {
                JOptionPane.showMessageDialog(null, "No hay ventas para esa fecha ");
            } ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta");
        }

        return ventas;
    }

    //Listar todas las ventas a un Cliente X.
    public List<Venta> listarVentasDeCliente(Cliente cliente) {
        List<Venta> ventas = new ArrayList<>();
        ClienteData clienteD = new ClienteData();

        String sql = "SELECT * FROM venta WHERE idcliente = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setCliente(clienteD.buscarCliente(rs.getInt("cliente")));
                venta.setFechaVenta((rs.getDate("fechaVenta")));

                ventas.add(venta);
            } else {
                JOptionPane.showMessageDialog(null, "No hay ventas para ese cliente " + cliente.getApellido() +", "+cliente.getNombre());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta");
        }

        return ventas;
    }
//Mostrar que clientes compraron el  producto X.
public List<Cliente> obtenerClientesPorProducto(Producto producto){
List<Cliente> clientes = new ArrayList<>();

ClienteData clienteD = new ClienteData();

String sql = "SELECT cliente.apellido, cliente.nombre, cliente.domicilio, cliente.telefono " +
                        "FROM cliente, producto "+ "WHERE idProducto = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente= new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                
                clientes.add(cliente);
            } else{
                JOptionPane.showMessageDialog(null, "Ningun cliente compro el producto " + producto.getNombreProducto());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }

return clientes;
}

// Listar todos los productos de una venta en una fecha específica.
    public List<Producto> obtenerProductosPorFecha(LocalDate fechaVenta) {
        List<Producto> prodPorFecha = new ArrayList<>();
        ProductoData productoD = new ProductoData();

        String sql = "SELECT producto.nombreProducto, detalleventa.cantidad FROM producto, detalledeventa "
                + "JOIN venta ON (venta.idVenta = detalledeventa.idVenta) "
                + "WHERE venta.fechaVenta= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaVenta));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setStock(rs.getInt("stock"));
                prod.setEstado(rs.getBoolean("estado"));

                prodPorFecha.add(prod);
                  } else {
                JOptionPane.showMessageDialog(null, "No hay productos en esa fecha");
            }
                ps.close(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Producto " + ex.getMessage());

        }
        return prodPorFecha;
    }
}
