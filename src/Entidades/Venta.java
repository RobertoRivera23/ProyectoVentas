package Entidades;


import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Diosito
 */
public class Venta {

    private int idVenta;
    private Cliente cliente;
    private Empleado empleado;
    private LocalDate fechaVenta;
    private boolean estado;

    public Venta(Cliente cliente, Empleado empleado, LocalDate fechaVenta) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaVenta = fechaVenta;
    }

    public Venta(int idVenta, Cliente cliente, Empleado empleado, LocalDate fechaVenta) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaVenta = fechaVenta;
    }
    
     public Venta(Cliente cliente, Empleado empleado, LocalDate fechaVenta, boolean estado) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

        public Venta(int idVenta, Cliente cliente, Empleado empleado, LocalDate fechaVenta, boolean estado) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public Venta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    public Integer getIdCliente(){
        return cliente.getIdCliente();
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    @Override
    public String toString(){
        return cliente.getTelefono() + ", " + empleado.getApellido() + ", " + fechaVenta;
    }
}
