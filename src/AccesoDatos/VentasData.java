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
        String sql = "INSERT INTO venta (idCliente, idempleado, fechaVenta, estado ) VALUES (? , ?, ?, ?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getCliente().getIdCliente());
            ps.setInt(2, venta.getEmpleado().getIdEmpleado());
            ps.setDate(3, Date.valueOf(venta.getFechaVenta()));
            ps.setBoolean(4, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                venta.setIdVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "La venta añadida con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ventas " + ex.getMessage());
        }
    }

    //Listar todas las ventas en una fecha.
    public List<Venta> listarVentasPorFecha(LocalDate fecha) {
        List<Venta> listaventas = new ArrayList<>();
        ClienteData clienteData = new ClienteData();
        EmpleadoData empleadoData = new EmpleadoData(); //////////////////////////////////////7
        String sql = "SELECT * FROM venta WHERE fechaVenta = ? "; //ORDER BY idVenta ASC
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            boolean cont = false;
            while (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setCliente(clienteData.buscarCliente(rs.getInt("idCliente")));
                venta.setEmpleado(empleadoData.buscarEmpleadoPorId(rs.getInt("idempleado"))); ////////////////////
                venta.setFechaVenta((rs.getDate("fechaVenta").toLocalDate()));
                venta.setEstado(rs.getBoolean("estado"));
                listaventas.add(venta);
                cont = true;
            }
            if (!cont) {
                JOptionPane.showMessageDialog(null, "No hay ventas para esa fecha ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta " + ex.getMessage());
        }
        return listaventas;
    }

    //Listar todas las ventas a un Cliente X.
    public List<Venta> listarVentasDeCliente(Cliente cliente) {
        List<Venta> ventas = new ArrayList<>();
        ClienteData clienteD = new ClienteData();
        EmpleadoData empleadoD = new EmpleadoData(); //////////////////////////////////////7
        String sql = "SELECT venta.idVenta, venta.idCliente, venta.idempleado, "
                + "venta.fechaVenta, venta.estado FROM venta JOIN detalledeventa "
                + "ON (venta.idVenta = detalledeventa.idVenta) JOIN producto "
                + "ON (detalledeventa.idProducto = producto.idProducto) JOIN cliente "
                + "ON (venta.idCliente = cliente.idCliente) "
                + "WHERE venta.idcliente = ? AND venta.estado = 1 AND detalledeventa.estado = 1 "
                + "AND producto.estado = 1 AND cliente.estado = 1 ORDER BY venta.idVenta ASC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setCliente(clienteD.buscarCliente(rs.getInt("idCliente")));
                venta.setEmpleado(empleadoD.buscarEmpleadoPorId(rs.getInt("idempleado"))); //////////////////////////////////////7
                venta.setFechaVenta((rs.getDate("fechaVenta").toLocalDate()));
                venta.setEstado(rs.getBoolean("estado"));
                ventas.add(venta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta " + ex.getMessage());
        }
        return ventas;
    }

//Mostrar que clientes compraron el  producto X.
    public List<Cliente> obtenerClientesPorProducto(Producto producto) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT cliente.idCliente, cliente.apellido, cliente.nombre, cliente.domicilio, cliente.telefono,"
                + "cliente.estado "
                + "FROM cliente JOIN venta ON (cliente.idCliente = venta.idCliente) "
                + "JOIN detalledeventa ON (venta.idVenta = detalledeventa.idVenta) "
                + "JOIN producto ON (detalledeventa.idProducto = producto.idProducto) "
                + "WHERE detalledeventa.idProducto = ? AND cliente.estado = 1 AND producto.estado = 1 "
                + "AND venta.estado = 1 AND detalledeventa.estado = 1 ORDER BY cliente.idCliente ASC ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            ResultSet rs = ps.executeQuery();
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
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente " + ex.getMessage());
        }
        return clientes;
    }

//Mostrar que Producto se vendieron en la Fecha X.
    public List<Producto> obtenerProductosPorFecha(LocalDate fechaVenta) {
        List<Producto> prodPorFecha = new ArrayList<>();
        String sql = " SELECT producto.idProducto, producto.nombreProducto, producto.descripcion, "
                + "producto.precioActual, producto.stock, producto.estado FROM producto JOIN detalledeventa "
                + "ON (producto.idProducto = detalledeventa.idProducto) "
                + "JOIN venta ON (detalledeventa.idVenta = venta.idVenta) "
                + "WHERE venta.fechaVenta = ? AND producto.estado = 1 "
                + "AND detalledeventa.estado = 1 AND venta.estado = 1 ORDER BY producto.idProducto ASC ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaVenta));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setStock(rs.getInt("stock"));
                prod.setEstado(rs.getBoolean("estado"));
                prodPorFecha.add(prod);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return prodPorFecha;
    }

    public Venta buscarVentaId(int idVenta) {
        String sql = "SELECT idCliente, idEmpleado, fechaVenta, estado FROM venta "
                + "WHERE idVenta = ?";
        ClienteData c1 = new ClienteData();
        EmpleadoData e1 = new EmpleadoData();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(idVenta);
                cliente = c1.buscarCliente(rs.getInt("idCliente"));
                venta.setCliente(cliente);
                empleado = e1.buscarEmpleadoPorId(rs.getInt("idEmpleado"));
                venta.setEmpleado(empleado);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("estado"));
            } else if (rs.getBoolean("estado")) {
                JOptionPane.showMessageDialog(null, "Venta dada de baja");
            } else {
                JOptionPane.showMessageDialog(null, "No existe la Venta");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Venta " + ex.getMessage());
        }
        return venta;
    }

    public void modificarVenta(Venta venta1) {
        Venta v1 = buscarVentaId(venta1.getIdVenta());
        String sql = "UPDATE venta SET idCliente = ?, idempleado = ?, fechaVenta = ?, estado = ? WHERE idVenta = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venta1.getCliente().getIdCliente());
            ps.setInt(2, venta1.getEmpleado().getIdEmpleado());
            ps.setDate(3, Date.valueOf(venta1.getFechaVenta()));
            ps.setBoolean(4, venta1.isEstado());
            ps.setInt(5, v1.getIdVenta());
            int modificado = ps.executeUpdate();
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "Venta modificada Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La venta no pudo modificarse");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Venta " + ex.getMessage());
        }
    }

    public List<Venta> listaVenta() {
        List<Venta> listaV = new ArrayList<>();
        ClienteData cd = new ClienteData();
        EmpleadoData ed = new EmpleadoData();
        String sql = "SELECT venta.idVenta, venta.idCliente, venta.idEmpleado,"
                + " venta.fechaVenta, venta.estado FROM venta JOIN empleado "
                + "ON (venta.idEmpleado = empleado.idEmpleado) JOIN cliente "
                + "ON (venta.idCliente = cliente.idCliente) JOIN detalledeventa "
                + "ON (venta.idVenta = detalledeventa.idVenta) "
                + "WHERE venta.estado = 1 AND empleado.estado = 1 AND cliente.estado = 1 "
                + "AND detalledeventa.estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                cliente = cd.buscarCliente(rs.getInt("idCliente"));
                venta.setCliente(cliente);
                empleado = ed.buscarEmpleadoPorId(rs.getInt("idEmpleado"));
                venta.setEmpleado(empleado);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("estado"));
                listaV.add(venta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta " + ex.getMessage());
        }
        return listaV;
    }

    // Eliminado Logico
    public void eliminarVentaId(int idVenta) {
        String sql = "UPDATE venta SET estado = 0 WHERE idVenta = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            int op = ps.executeUpdate();
            if (op == 1) {
                JOptionPane.showMessageDialog(null, "Venta Eliminada Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Venta no pudo ser Eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta " + ex.getMessage());
        }
    }

    // Eliminado BD
    public void eliminarVentaIdBD(int idVenta) {
        String sql = "DELETE FROM  venta WHERE idVenta = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            int op = ps.executeUpdate();
            if (op == 1) {
                JOptionPane.showMessageDialog(null, "Venta Eliminada Exitosamente de la BD.");
            } else {
                JOptionPane.showMessageDialog(null, "Venta no pudo ser Eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta " + ex.getMessage());
        }
    }

    public List<Venta> listaVentaBaja() {
        List<Venta> listaV = new ArrayList<>();
        ClienteData cd = new ClienteData();
        EmpleadoData ed = new EmpleadoData();
        String sql = "SELECT * FROM venta WHERE estado = 0";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                cliente = cd.buscarCliente(rs.getInt("idCliente"));
                venta.setCliente(cliente);
                empleado = ed.buscarEmpleadoPorId(rs.getInt("idEmpleado"));
                venta.setEmpleado(empleado);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("estado"));
                listaV.add(venta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta " + ex.getMessage());
        }
        return listaV;
    }
}
