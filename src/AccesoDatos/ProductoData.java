/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.*;
import Entidades.Producto;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariano
 */
public class ProductoData {
    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarProducto(Producto producto){
        String sql = "INSERT INTO producto (nombreProducto, descripcion, precioActual, stock, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto añadido con exito.");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto" + ex.getMessage());
        }
    }
    
    public void buscarProducto(int id){
        Producto producto = null;
        String sql = "SELECT nombreProducto, descripcion, precioActual, stock, estado FROM producto WHERE idProducto = ? AND estado = 1";
        PreparedStatement ps;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                producto = new Producto();
                producto.setIdProducto(id);
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el producto");
                ps.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto" + ex.getMessage());
        }
    }
}
