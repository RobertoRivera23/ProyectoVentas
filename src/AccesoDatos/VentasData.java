package AccesoDatos;

import Entidades.Cliente;
import Entidades.Empleado;
import Entidades.Producto;
import Entidades.Venta;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentasData {

    private Connection con = null;
    private Cliente cliente;
    private Empleado empleado;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    

// Guardar ventas
    public void guardarVenta(Venta venta) { 
        String sql = "INSERT INTO (idCliente, idempleado, fechaVenta, estado ) VALUES (? , ?, ?, ?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getIdCliente());
            ps.setInt(2, venta.getEmpleado().getIdEmpleado());
            ps.setDate(3, Date.valueOf(venta.getFechaVenta()));
            ps.setBoolean(4, true);
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
        EmpleadoData empleadoData = new EmpleadoData(); //////////////////////////////////////7
        String sql = "SELECT * FROM venta WHERE fechaVenta = ? ORDER BY idVenta ASC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf("fechaVenta"));
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No hay ventas para esa fecha ");
            } else {
                while (rs.next()) {
                    venta = new Venta();
                    venta.setIdVenta(rs.getInt("idVenta"));
                    venta.setCliente(clienteData.buscarCliente(rs.getInt("idCliente")));
                    venta.setEmpleado(empleadoData.buscarEmpleadoPorId(rs.getInt("idempleado"))); ////////////////////
                    venta.setFechaVenta((rs.getDate("fechaVenta").toLocalDate()));
                    venta.setEstado(rs.getBoolean("estado"));
                    ventas.add(venta);
                }
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta");
        }
        return ventas;
    }

    //Listar todas las ventas a un Cliente X.
    public List<Venta> listarVentasDeCliente(Cliente cliente) {
        List<Venta> ventas = new ArrayList<>();
        ClienteData clienteD = new ClienteData();
        EmpleadoData empleadoD = new EmpleadoData(); //////////////////////////////////////7
        String sql = "SELECT * FROM venta WHERE idcliente = ? ORDER BY idVenta ASC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No hay ventas para ese cliente " + cliente.getApellido() + ", " + cliente.getNombre());
            } else {
                while (rs.next()) {
                    venta = new Venta();
                    venta.setIdVenta(rs.getInt("idVenta"));
                    venta.setCliente(clienteD.buscarCliente(rs.getInt("idCliente")));
                    venta.setEmpleado(empleadoD.buscarEmpleadoPorId(rs.getInt("idempleado"))); //////////////////////////////////////7
                    venta.setFechaVenta((rs.getDate("fechaVenta").toLocalDate()));
                    venta.setEstado(rs.getBoolean("estado"));
                    ventas.add(venta);
                }
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta");
        }
        return ventas;
    }

//Mostrar que clientes compraron el  producto X.
    public List<Cliente> obtenerClientesPorProducto(Producto producto) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT cliente.apellido, cliente.nombre, cliente.domicilio, cliente.telefono "
                + "FROM cliente, producto WHERE idProducto = ? ORDER BY cliente.idCliente ASC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Ningun cliente compro el producto " + producto.getNombreProducto());
            } else {
                while (rs.next()) {
                    cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("idCliente"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setDomicilio(rs.getString("domicilio"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setEstado(rs.getBoolean("estado"));
                    clientes.add(cliente);
                }
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
        return clientes;
    }

// Listar todos los productos de una venta en una fecha específica.
    public List<Producto> obtenerProductosPorFecha(LocalDate fechaVenta) {
        List<Producto> prodPorFecha = new ArrayList<>();
        String sql = "SELECT producto.nombreProducto, detalleventa.cantidad FROM producto, detalledeventa "
                + "JOIN venta ON (venta.idVenta = detalledeventa.idVenta) "
                + "WHERE venta.fechaVenta = ? ORDER BY producto.idProducto ASC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaVenta));
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No hay productos en esa fecha");
            } else {
                while (rs.next()) {
                    Producto prod = new Producto();
                    prod.setIdProducto(rs.getInt("idProducto"));
                    prod.setNombreProducto(rs.getString("nombre"));
                    prod.setDescripcion(rs.getString("descripcion"));
                    prod.setPrecioActual(rs.getDouble("precioActual"));
                    prod.setStock(rs.getInt("stock"));
                    prod.setEstado(rs.getBoolean("estado"));
                    prodPorFecha.add(prod);
                }
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return prodPorFecha;
    }
}
