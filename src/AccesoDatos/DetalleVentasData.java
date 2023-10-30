/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.DetalleVenta;
import Entidades.Producto;
import Entidades.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class DetalleVentasData {

    private Connection con = null;
    private Venta venta;
    private Producto producto;
    private DetalleVenta dv;

    public DetalleVentasData() {
        con = Conexion.getConexion();
    }

    public DetalleVentasData(Venta venta, Producto producto) {
        this.venta = venta;
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void guardarDetalleVenta(DetalleVenta detalleVenta) {
        String sql = "INSERT INTO detalledeVenta (cantidad, idVenta, precioVenta, idProducto, estado) VALUES (?, ?, ?, ?, ?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalleVenta.getCantidad());
            ps.setInt(2, detalleVenta.getVenta().getIdVenta());
            ps.setDouble(3, detalleVenta.getPrecioVenta());
            ps.setInt(4, detalleVenta.getProducto().getIdProducto());
            ps.setBoolean(5, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                detalleVenta.setIdDetalleVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se añadio con exito el detalle de Venta");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la tabla Detalle de  Venta " + ex.getMessage());
        }
    }

    public DetalleVenta buscarDetalleVenta(int idDetalleVenta) {
        DetalleVenta detalleV = null;
        String sql = "SELECT * FROM detalledeVenta WHERE idVenta = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idDetalleVenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                detalleV = new DetalleVenta();
                VentasData ventasD = new VentasData();
                ProductoData productoD = new ProductoData();
                detalleV.setIdDetalleVenta(idDetalleVenta);
                detalleV.setCantidad(rs.getInt("cantidad"));
                detalleV.setVenta(ventasD.buscarVentaId(rs.getInt("idVenta")));
                detalleV.setPrecioVenta(rs.getDouble("precioVenta"));
                detalleV.setProducto(productoD.buscarProducto(rs.getInt("idProducto")));
                detalleV.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el Detalle de Venta");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla detalleVenta " + ex.getMessage());
        }
        return detalleV;
    }

    public void modificarDetalleVenta(DetalleVenta detalleVenta) {
        String sql = "UPDATE detalledeVenta SET cantidad = ?, idVenta = ?, precioVenta = ?, idProducto = ?, estado = ? WHERE idDetalleVenta = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, detalleVenta.getCantidad());
            ps.setInt(2, detalleVenta.getIdVenta());
            ps.setDouble(3, detalleVenta.getPrecioVenta());
            ps.setInt(4, detalleVenta.getIdProducto());
            ps.setBoolean(5, detalleVenta.isEstado());
            ps.setInt(6, detalleVenta.getIdDetalleVenta());

            int Exito = ps.executeUpdate();
            if (Exito == 1) {
                JOptionPane.showMessageDialog(null, "Detalle de Venta modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Detalle de Venta no se pudo modificar");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla detalleVenta " + ex.getMessage());
        }
    }

    public List<DetalleVenta> listarDetalleVentaPorProducto(Producto producto) {
        List<DetalleVenta> listaDetalleVenta = new ArrayList<>();
        String sql = "SELECT *  FROM detalledeVenta  WHERE idProducto = ? AND estado = 1 ORDER BY idDetalleVenta ASC ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            ResultSet rs = ps.executeQuery();
            boolean cont = false;
            while (rs.next()) { //cantidad, idVenta, precioVenta, idProducto, estado
                DetalleVenta detalleV = new DetalleVenta();
                VentasData ventasD = new VentasData();
                ProductoData productoD = new ProductoData();
                detalleV.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                detalleV.setCantidad(rs.getInt("cantidad"));
                detalleV.setVenta(ventasD.buscarVentaId(rs.getInt("idVenta")));
                detalleV.setPrecioVenta(rs.getDouble("precioVenta"));
                detalleV.setProducto(productoD.buscarProducto(rs.getInt("idProducto")));
                detalleV.setEstado(rs.getBoolean("estado"));
                cont = true;
                listaDetalleVenta.add(detalleV);
                if (!cont) {
                    JOptionPane.showMessageDialog(null, "No hay Detalle de Ventas para ese Producto ");
                }
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla detalleVenta " + ex.getMessage());
        }
        return listaDetalleVenta;
    }

    //Eliminado Logico
    public void eliminarDetalleVentaPorId(int IdDetalleVenta) {
        String sql = "UPDATE detalledeVenta SET estado = 0  WHERE idDetalleVenta = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IdDetalleVenta);
            int modificado = ps.executeUpdate();
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "Detalle de Venta Eliminado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Detalle de Venta no pudo ser Eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla detalleVenta " + ex.getMessage());
        }
    }

    //ELIMINA DE BD
    public void eliminarDetalleVentaPorIdBD(int IdDetalleVenta) {
        String sql = "DELETE FROM detalledeVenta WHERE idDetalleVenta = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IdDetalleVenta);
            int modificado = ps.executeUpdate();
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "Detalle de Venta Eliminado Exitosamente de la BD.");
            } else {
                JOptionPane.showMessageDialog(null, "El Detalle de Venta no pudo ser Eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla detalleVenta " + ex.getMessage());
        }
    }

    public DetalleVenta buscarDetalleProVenta(int idVenta) {
        VentasData vd = new VentasData();
        ProductoData pd = new ProductoData();
        String sql = "SELECT * FROM detalledeventa WHERE idVenta = ? AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dv = new DetalleVenta();
                dv.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                dv.setCantidad(rs.getInt("cantidad"));
                venta = vd.buscarVentaId(idVenta);
                dv.setVenta(venta);
                dv.setPrecioVenta(rs.getDouble("precioVenta"));
                producto = pd.buscarProducto(rs.getInt("idProducto"));
                dv.setProducto(producto);
                dv.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Detalle de Venta " + ex.getMessage());
        }
        return dv;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////777
    public DetalleVenta buscarDetalleProVentaBaja(int idVenta) {
        VentasData vd = new VentasData();
        ProductoData pd = new ProductoData();
        String sql = "SELECT * FROM detalledeventa WHERE idVenta = ? AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dv = new DetalleVenta();
                dv.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                dv.setCantidad(rs.getInt("cantidad"));
                venta = vd.buscarVentaId(idVenta);
                dv.setVenta(venta);
                dv.setPrecioVenta(rs.getDouble("precioVenta"));
                producto = pd.buscarProducto(rs.getInt("idProducto"));
                dv.setProducto(producto);
                dv.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Detalle de Venta " + ex.getMessage());
        }
        return dv;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
    
    public List<DetalleVenta> listaDV() {
        List<DetalleVenta> lista = new ArrayList<>();
        VentasData vd = new VentasData();
        ProductoData pd = new ProductoData();
        String sql = "SELECT detalledeventa.idDetalleVenta, detalledeventa.cantidad, "
                + "detalledeventa.idVenta, detalledeventa.precioVenta, detalledeventa.idProducto, "
                + "detalledeventa.estado FROM detalledeventa JOIN venta ON (detalledeventa.idVenta = venta.idVenta) "
                + "JOIN empleado ON (venta.idempleado = empleado.idempleado) JOIN cliente "
                + "ON (venta.idCliente = cliente.idCliente) JOIN producto "
                + "ON (detalledeventa.idProducto = producto.idProducto) "
                + "WHERE detalledeventa.estado = 1 AND venta.estado = 1 AND empleado.estado = 1 "
                + "AND producto.estado = 1 AND cliente.estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dv = new DetalleVenta();
                dv.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                dv.setCantidad(rs.getInt("cantidad"));
                venta = vd.buscarVentaId(rs.getInt("idVenta"));
                dv.setVenta(venta);
                dv.setPrecioVenta(rs.getDouble("precioVenta"));
                producto = pd.buscarProducto(rs.getInt("idProducto"));
                dv.setProducto(producto);
                dv.setEstado(rs.getBoolean("estado"));
                lista.add(dv);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Detalle de Venta " + ex.getMessage());
        }
        return lista;
    }
    
    public List<DetalleVenta> listaDVTodo() {
        List<DetalleVenta> lista = new ArrayList<>();
        VentasData vd = new VentasData();
        ProductoData pd = new ProductoData();
        String sql = "SELECT * FROM detalledeventa ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dv = new DetalleVenta();
                dv.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                dv.setCantidad(rs.getInt("cantidad"));
                venta = vd.buscarVentaId(rs.getInt("idVenta"));
                dv.setVenta(venta);
                dv.setPrecioVenta(rs.getDouble("precioVenta"));
                producto = pd.buscarProductoIdBaja(rs.getInt("idProducto"));
                dv.setProducto(producto);
                dv.setEstado(rs.getBoolean("estado"));
                lista.add(dv);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Detalle de Venta " + ex.getMessage());
        }
        return lista;
    }
}
