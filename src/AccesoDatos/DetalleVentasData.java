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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class DetalleVentasData {
   private Connection con = null;
   private Venta venta;
   private Producto producto;

public DetalleVentasData(){
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


   public void guardarDetalleVenta(DetalleVenta detalleVenta){
       String sql = "INSET INTO detalleVenta (cantidad, idVenta, precioVenta, idProducto, estado) VALUES (?, ?, ?, ?, ?)";
       try {
           PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
           ps.setInt(1, detalleVenta.getCantidad());
           ps.setInt(2, detalleVenta.getIdDetalleVenta());
           ps.setDouble(3, detalleVenta.getPrecioVenta());
           ps.setInt(4, detalleVenta.getIdProducto());
           ps.setBoolean(5, true);
           ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
               detalleVenta.setIdDetalleVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se añadio con exito el detalle de Venta");
            }
          
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al conectar a la tabla Detalle de  Venta" + ex.getMessage()); }
       }
   
   public void buscarDetalleVenta(int idDetalleVenta){
       DetalleVenta detalleV = null;
       String sql ="SELECT * FROM detalleVenta WHERE idVenta = ? ";
   //cantidad, idVenta, precioVenta, idProducto, estado
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, idDetalleVenta);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
              detalleV = new DetalleVenta();
              VentasData ventasD = new VentasData();
              detalleV.setIdDetalleVenta(idDetalleVenta);
              detalleV.setCantidad(rs.getInt("cantidad"));
              detalleV.setVenta(ventasD.buscarVentasPorId(rs.getInt("idVenta")));// ESPERAR METODO BUSCAR POR ID
              detalleV.setPrecioVenta(idDetalleVenta);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(DetalleVentasData.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void modificarDetalleVenta(int idVenta){
       
   }
   
   
   }
   
   
   

