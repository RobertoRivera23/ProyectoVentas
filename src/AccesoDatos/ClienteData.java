/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Entidades.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diosito
 */
public class ClienteData {

    private Connection con = null;
    private Cliente cliente;

    public ClienteData() {
        con = Conexion.getConexion();
    }

    public void guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (apellido, nombre, domicilio, telefono, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getApellido());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDomicilio());
            ps.setString(4, cliente.getTelefono());
            ps.setBoolean(5, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ha añadido al cliente con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente " + ex.getMessage());
        }
    }

    public Cliente buscarCliente(int idCliente) {
        String sql = "SELECT apellido, nombre, domicilio, telefono, estado FROM cliente WHERE idCliente = ? AND estado = 1";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getBoolean("estado")); //  no deberiamos setear el estado al crearlo? aca estamos buscando uno que ya esta
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Cliente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente " + ex.getMessage());
        }
        return cliente;
    }
// Modificar para restaurar (al Modificar demas datos mantiene en true)
    public void modicifarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET apellido = ? , nombre = ? , domicilio = ? , telefono = ?, estado = ? WHERE idCliente = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getApellido());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDomicilio());
            ps.setString(4, cliente.getTelefono());
            ps.setBoolean(5, cliente.isEstado());
            ps.setInt(6, cliente.getIdCliente());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Cliente no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente " + ex.getMessage());
        }
    }
    // Elimina de modo Logico
    public void eliminarCliente(int id) {
        String sql = "UPDATE cliente SET estado = 0 WHERE idCliente = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Cliente " + ex.getMessage());
        }
    }
    // Elimina de BD
    public void eliminarClienteDB(int id) {
        String sql = "DELETE FROM cliente WHERE idCliente = ? AND estado = 0";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado de la BD.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Cliente " + ex.getMessage());
        }
    }
    
    public List<Cliente> listarClientes(){
        List<Cliente> listaC = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE estado = 1 ORDER BY idCliente ASC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                listaC.add(cliente);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la table Cliente " + ex.getMessage());
        }
        return listaC;
    }
    
    public Cliente buscarClientePorTel(String telefono){
        String sql = "SELECT * FROM cliente WHERE telefono = ? AND estado = 1";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, telefono);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Cliente");
                cliente = null;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente " + ex.getMessage());
        }
        return cliente;
    }
    
    public List<Cliente> listarClientesBaja(){
        List<Cliente> listaC = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE estado = 0 ORDER BY idCliente ASC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                listaC.add(cliente);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la table Cliente " + ex.getMessage());
        }
        return listaC;
    }
}
