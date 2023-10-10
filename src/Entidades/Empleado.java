/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author rober
 */
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private int dni;
    private String cargo;
    private String usuario;
    private String contraenia;
    private boolean estado;
    
    
    public Empleado(){
    }

    public Empleado(String nombre, String apellido, int dni,  String cargo, String usuario, String contraenia, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.cargo = cargo;
        this.usuario = usuario;
        this.contraenia = contraenia;
        this.estado= estado;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, int dni,  String cargo, String usuario, String contraenia, boolean estado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.cargo = cargo;
        this.usuario = usuario;
        this.contraenia = contraenia;
        this.estado = estado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraenia() {
        return contraenia;
    }

    public void setContraenia(String contraenia) {
        this.contraenia = contraenia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
       

    @Override
    public String toString() {
        return idEmpleado + ", " + nombre + ", " + apellido + ", " + dni+  ", " +cargo + ", " + usuario + ", " + contraenia + ", " + estado;
    }
    
    
    
    
    
}
