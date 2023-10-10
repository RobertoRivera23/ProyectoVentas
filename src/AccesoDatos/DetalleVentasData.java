/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.DetalleVenta;
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
   
   
public DetalleVentasData(){
    con = Conexion.getConexion();
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
   }
   
   
   

