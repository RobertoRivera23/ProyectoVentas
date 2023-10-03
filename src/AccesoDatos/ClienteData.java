/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Entidades.Cliente;
import java.sql.*;
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
                JOptionPane.showMessageDialog(null, "Se ha añadido al cliente con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente. " + ex.getMessage());
        }
    }

    public Cliente buscarCliente(int idCliente) {


        Cliente cliente = null;
        String sql = "SELECT apellido, nombre, domicilio, telefon FROM cliente WHERE idCliente = ?";
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
                cliente.setEstado(true); //  no deberiamos setear el estado al crearlo? aca estamos buscando uno que ya esta
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Cliente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente. " + ex.getMessage());
        }
        return cliente;
    }

    public void modicifarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET apellido = ? , nombre = ? , domicilio = ? , telefono = ? WHERE idCliente = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getApellido());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDomicilio());
            ps.setString(4, cliente.getTelefono());
            ps.setInt(5, cliente.getIdCliente());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Cliente no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente. " + ex.getMessage());
        }
    }

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
}
