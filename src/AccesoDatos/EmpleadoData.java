/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class EmpleadoData {
   
    private Connection con= null;

    public EmpleadoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarEmpleado(Empleado empleado){
       
        String sql = "INSERT INTO empleado (apellido, nombre, dni,  cargo, usuario, contraseña, estado) VALUES (?, ?, ?, ?, ?, ?, ?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
             ps.setString(1, empleado.getApellido());
            ps.setString(2, empleado.getNombre());
            ps.setInt(3, empleado.getDni());
            ps.setString(4, empleado.getCargo());
            ps.setString(5, empleado.getUsuario());
            ps.setString(6, empleado.getContraenia());
            ps.setBoolean(7, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
               empleado.setIdEmpleado(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se añadio con exito el empleado " + empleado.getApellido() + "\n " + empleado.getNombre());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la tabla Empleado" + ex.getMessage()); }
    }
    
    public Empleado buscarEmpleadoPorDni(int dni){
         Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE dni = ? AND estado = 1 ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                empleado= new Empleado();
                empleado.setIdEmpleado(rs.getInt("idempleado"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDni(rs.getInt("dni"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setUsuario(rs.getString("usuario"));
                empleado.setContraenia(rs.getString("contraseña"));
                empleado.setEstado(true);
            }else {
           JOptionPane.showMessageDialog(null, "No se econtro al Empleado"); 
            }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al conectar a la tabla Empleado" + ex.getMessage()); 
        }
        return empleado;
    }
    
    public Empleado buscarEmpleadoPorId(int idempleado){
      
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE idempleado = ? AND estado = 1 ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idempleado);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                empleado= new Empleado();
                empleado.setIdEmpleado(idempleado);
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDni(rs.getInt("dni"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setUsuario(rs.getString("usuario"));
                empleado.setContraenia(rs.getString("contraseña"));
                empleado.setEstado(true);
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al conectar a la tabla Empleado" + ex.getMessage()); 
        }
        return empleado;
    }
    
    public List<Empleado> listarEmpleado(){
        List<Empleado> empleados = new ArrayList<>();
        Empleado empleado= null;
         String sql = "SELECT * FROM empleado WHERE estado = 1 ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                empleado= new Empleado();
                empleado.setIdEmpleado(rs.getInt("idempleado"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDni(rs.getInt("dni"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setUsuario(rs.getString("usuario"));
                empleado.setContraenia(rs.getString("contraseña"));
                empleado.setEstado(rs.getBoolean("estado"));
                empleados.add(empleado);
            }
            ps.close();
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al conectar a la tabla Empleado" + ex.getMessage()); 
        }
        return empleados; 
    }
    
    public void modificarEmpleadoPorId(Empleado empleado1){
       
        Empleado empleado = buscarEmpleadoPorId(empleado1.getIdEmpleado()); // apellido, nombre, dni,  cargo, usuario, contraseña, estado
        String sql = "UPDATE  empleado SET apellido = ?, nombre = ?, dni = ?, cargo = ?, usuario = ?, contraseña = ?, estado = ?  WHERE idempleado = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getApellido());
            ps.setString(2, empleado.getNombre());
            ps.setInt(3, empleado.getDni());
            ps.setString(4, empleado.getCargo());
            ps.setString(5, empleado.getUsuario());
            ps.setString(6, empleado.getContraenia());
            ps.setBoolean(7, empleado.isEstado());
            ps.setInt(8, empleado.getIdEmpleado());
            
 
            int modificado = ps.executeUpdate();
            if(modificado == 1){
                 JOptionPane.showMessageDialog(null, "Empleado modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El empleado no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado " + ex.getMessage());
        }
    
    }
    
    public void eliminarEmpleadoPorId(int id){
             String sql = "UPDATE empleado SET estado = 0 WHERE idempleado = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if(rs == 1){
                JOptionPane.showMessageDialog(null, "Se elimino con exito al empleado.");
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Empleado. " + ex.getMessage());
        }
    }
    
}
