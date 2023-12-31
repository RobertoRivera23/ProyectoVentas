/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.ClienteData;
import AccesoDatos.DetalleVentasData;
import AccesoDatos.EmpleadoData;
import AccesoDatos.ProductoData;
import AccesoDatos.VentasData;
import Entidades.*;
import Utilidades.TablaFraveMax;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROMI
 */
public class Menu extends javax.swing.JFrame {

    private ProductoData pd = new ProductoData();
    private ClienteData cD = new ClienteData();
    private VentasData vd = new VentasData();
    private DetalleVentasData dvd = new DetalleVentasData();
    private EmpleadoData ed = new EmpleadoData();
    private int xMouse, yMouse;
    public static Color verdeBase = new Color(0, 150, 136);
    public static Color verdeClaro = new Color(10, 170, 140);
    public static Color grisBase = new Color(51, 51, 76);
    public static Color grisClaro = new Color(66, 66, 76);
    private double precioTotal;
    private DefaultListModel Mlist = new DefaultListModel();

//Modelos tablas    
    public DefaultTableModel Modelo;
    public DefaultTableModel Modelo1;
    public DefaultTableModel Modelo2;
    public DefaultTableModel Modelo3;
    public DefaultTableModel Modelo4;
    public DefaultTableModel Modelo5;

//Modelos tablas de Papelera
    public DefaultTableModel ModeloP = new DefaultTableModel(null, new String[]{
        "ID", "Nombre", "Descripcion", "Precio Actual", "Stock"
    }
    ) {
        public boolean isCellEditable(int fila, int column) {
            return false;
        }

        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
        };

        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };

    public DefaultTableModel ModeloV = new DefaultTableModel(null, new String[]{
        "ID", "Telefono Cliente", "Datos Empleado", "Fecha de Venta"
    }
    ) {
        public boolean isCellEditable(int fila, int column) {
            return false;
        }

        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.time.LocalDate.class
        };

        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };

    public DefaultTableModel ModeloC = new DefaultTableModel(null, new String[]{
        "ID", "Apellido", "Nombre", "Domicilio", "Telefono"
    }
    ) {
        public boolean isCellEditable(int fila, int column) {
            return false;
        }

        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
        };

        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };

    public DefaultTableModel ModeloE = new DefaultTableModel(null, new String[]{
        "ID", "Apellido", "Nombre", "DNI", "Cargo", "Usuario", "Contraseña"
    }
    ) {
        public boolean isCellEditable(int fila, int column) {
            return false;
        }

        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class
        };

        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public DefaultTableModel ModeloVentaProd = new DefaultTableModel(null, new String[]{
        "Id Producto", "Nombre", "Descripción", "Cantidad", "Precio", "Subtotal"
    }
    ) {
        public boolean isCellEditable(int fila, int column) {
            return false;
        }

        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class,
            java.lang.Double.class
        };

        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };
    ////////////////////////////////////////////////77777777777/////////////////////////////////////////

    private void llenarTabla() {
        borrarFila();
        for (Producto pro : pd.listarProducto()) {
            Modelo.addRow(new Object[]{pro.getIdProducto(), pro.getNombreProducto(),
                pro.getDescripcion(), pro.getPrecioActual(), pro.getStock()});
            jtListaPro.setModel(Modelo);
        }
    }

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        jtListaPro.setModel(Modelo);
        jtListClien.setModel(Modelo1);
        jtListEmpleado.setModel(Modelo2);
        llenarText();
//        llenarCombo();
//        llenarComboCliente();
//        llenarComboV();
//        llenarComboEmpleado();
//        llenarComboCargo();
        empleadosVisible(); // PARA MOSTRAR JLEMPLEADOS 
        jlNombreUsuario.setText(Login.empleado.getNombre() + " " + Login.empleado.getApellido());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        jPanelCabecera = new javax.swing.JPanel();
        jlNombreUsuario = new javax.swing.JLabel();
        fravemaxLogo = new javax.swing.JLabel();
        jlMinimizar = new javax.swing.JLabel();
        jlSalir = new javax.swing.JLabel();
        jlCabecera = new javax.swing.JLabel();
        jPanelOpciones = new javax.swing.JPanel();
        jlProductos = new javax.swing.JLabel();
        jlClientes = new javax.swing.JLabel();
        jlVentas = new javax.swing.JLabel();
        jlCerrarSesion = new javax.swing.JLabel();
        jlInicio = new javax.swing.JLabel();
        jLEmpleados = new javax.swing.JLabel();
        jlPapeleraMenu = new javax.swing.JLabel();
        jtpEscritorio = new javax.swing.JTabbedPane();
        jtpInicio = new javax.swing.JPanel();
        jlIconPro = new javax.swing.JLabel();
        jlIconVenta = new javax.swing.JLabel();
        jlIconCliente = new javax.swing.JLabel();
        jlClentesIn = new javax.swing.JLabel();
        jlVentasIn = new javax.swing.JLabel();
        jlProIn = new javax.swing.JLabel();
        verMasC = new javax.swing.JLabel();
        verMasV = new javax.swing.JLabel();
        verMasP = new javax.swing.JLabel();
        text3 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        jlGestionDe = new javax.swing.JLabel();
        rectanguloIn1 = new javax.swing.JLabel();
        rectanguloIn2 = new javax.swing.JLabel();
        rectanguloIn3 = new javax.swing.JLabel();
        jtpVentas = new javax.swing.JPanel();
        jlGestionV = new javax.swing.JLabel();
        jlVentaIcon1 = new javax.swing.JLabel();
        jlRegistrar = new javax.swing.JLabel();
        textVentaA = new javax.swing.JLabel();
        textVentaD = new javax.swing.JLabel();
        textVentaE = new javax.swing.JLabel();
        RegistrarVenta = new javax.swing.JLabel();
        DetVenta = new javax.swing.JLabel();
        EliminarVenta = new javax.swing.JLabel();
        jlEliminarVenta = new javax.swing.JLabel();
        jlVentaIcon3 = new javax.swing.JLabel();
        rectanguloV1 = new javax.swing.JLabel();
        jlVentaIcon2 = new javax.swing.JLabel();
        jlDetalles = new javax.swing.JLabel();
        rectanguloV2 = new javax.swing.JLabel();
        rectanguloV3 = new javax.swing.JLabel();
        jlListarVenta = new javax.swing.JLabel();
        jtpClientes = new javax.swing.JPanel();
        jlListarCliente = new javax.swing.JLabel();
        jlIconEliCli = new javax.swing.JLabel();
        jlIconAgreCli = new javax.swing.JLabel();
        jlIconModCli = new javax.swing.JLabel();
        jlAgregarCliente = new javax.swing.JLabel();
        jlModificarCliente = new javax.swing.JLabel();
        jlEliminarCliente = new javax.swing.JLabel();
        jlGestionClientes = new javax.swing.JLabel();
        textClienteE = new javax.swing.JLabel();
        textClienteM = new javax.swing.JLabel();
        textClienteA = new javax.swing.JLabel();
        jlModClientes = new javax.swing.JLabel();
        jlEliminarClientes = new javax.swing.JLabel();
        jlAgregarClientes = new javax.swing.JLabel();
        rectanguloCli1 = new javax.swing.JLabel();
        rectanguloCli2 = new javax.swing.JLabel();
        rectanguloCli3 = new javax.swing.JLabel();
        jtpProductos = new javax.swing.JPanel();
        jlListar = new javax.swing.JLabel();
        jlEliminar = new javax.swing.JLabel();
        jlIconoBorrarPro = new javax.swing.JLabel();
        jlIconoAgregarPro = new javax.swing.JLabel();
        jlIconoModPro = new javax.swing.JLabel();
        jlAgregar = new javax.swing.JLabel();
        jlModificar = new javax.swing.JLabel();
        jlGestionPro = new javax.swing.JLabel();
        textE = new javax.swing.JLabel();
        textM = new javax.swing.JLabel();
        textA = new javax.swing.JLabel();
        jlModPro = new javax.swing.JLabel();
        jlEliminarPro = new javax.swing.JLabel();
        jlAgregarPro = new javax.swing.JLabel();
        rectangulo1Pro = new javax.swing.JLabel();
        rectangulo2Pro = new javax.swing.JLabel();
        rectangulo3Pro = new javax.swing.JLabel();
        jtpListaP = new javax.swing.JPanel();
        jlListaProAc = new javax.swing.JLabel();
        Scroll = new javax.swing.JScrollPane();
        jtListaPro = new TablaFraveMax();
        jtfBuscador = new javax.swing.JTextField();
        jlBusqueda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtpAgregarPro = new javax.swing.JPanel();
        jLAgregarProducto = new javax.swing.JLabel();
        jLNombreProductoAP = new javax.swing.JLabel();
        jSAgrProd1 = new javax.swing.JSeparator();
        jSAgrProd2 = new javax.swing.JSeparator();
        jLDescripcionAP = new javax.swing.JLabel();
        jSAgrProd3 = new javax.swing.JSeparator();
        jLPrecioActualAP = new javax.swing.JLabel();
        jSAgrProd4 = new javax.swing.JSeparator();
        jLStockAP = new javax.swing.JLabel();
        jLBtnAgregarProd = new javax.swing.JLabel();
        jTFNombreProductoAgrProd = new javax.swing.JTextField();
        jTFDescripcionAgrProd = new javax.swing.JTextField();
        jTFPrecioActualAgrProd = new javax.swing.JTextField();
        jTFStockAgrProd = new javax.swing.JTextField();
        jlIconoAgregarPro1 = new javax.swing.JLabel();
        jtpEliminarPro = new javax.swing.JPanel();
        jLTituloEliminarProducto = new javax.swing.JLabel();
        jLBuscarProdElimProd = new javax.swing.JLabel();
        jCBBuscarProdElimProd = new javax.swing.JComboBox<>();
        jLNombreProdElimProd = new javax.swing.JLabel();
        jTFNombreProdElimProd = new javax.swing.JTextField();
        jLPrecioActualElimProd = new javax.swing.JLabel();
        jSElimProd1 = new javax.swing.JSeparator();
        jTFPrecioActuaElimProd = new javax.swing.JTextField();
        jSElimProd2 = new javax.swing.JSeparator();
        jTFStockElimProd = new javax.swing.JTextField();
        jSElimProd3 = new javax.swing.JSeparator();
        jLStockElimProd = new javax.swing.JLabel();
        jTFDescripcionElimProd = new javax.swing.JTextField();
        jSElimProd4 = new javax.swing.JSeparator();
        jLDescripcionElimProd = new javax.swing.JLabel();
        jLBtnEliminarElimProd = new javax.swing.JLabel();
        jlIconoBorrarPro1 = new javax.swing.JLabel();
        jtpModPro = new javax.swing.JPanel();
        jLModificarProd = new javax.swing.JLabel();
        jLBuscarProdModProd = new javax.swing.JLabel();
        jSModProd1 = new javax.swing.JSeparator();
        jTFNombreProdModProd = new javax.swing.JTextField();
        jSModProd2 = new javax.swing.JSeparator();
        jTFDescripcionModProd = new javax.swing.JTextField();
        jSModProd3 = new javax.swing.JSeparator();
        jTFPrecioActualModProd = new javax.swing.JTextField();
        jSModProd4 = new javax.swing.JSeparator();
        jTFStockModProd = new javax.swing.JTextField();
        jLNombreProdModProd = new javax.swing.JLabel();
        jLDescripcionModProd = new javax.swing.JLabel();
        jLPrecioActualModProd = new javax.swing.JLabel();
        jLStockModProd = new javax.swing.JLabel();
        jLBtnModificarModProd = new javax.swing.JLabel();
        jcbProductos = new javax.swing.JComboBox<>();
        jlIconoModPro1 = new javax.swing.JLabel();
        jtpAgrClien = new javax.swing.JPanel();
        jLTituloAgrClien = new javax.swing.JLabel();
        jLNombreClienteAgrClien = new javax.swing.JLabel();
        jSAgrClien1 = new javax.swing.JSeparator();
        jSAgrClien2 = new javax.swing.JSeparator();
        jLApellidoClienteAgrClien = new javax.swing.JLabel();
        jSAgrClien3 = new javax.swing.JSeparator();
        jLDomicilioClienteAgrClien = new javax.swing.JLabel();
        jSAgrClien4 = new javax.swing.JSeparator();
        jLTelefonoClienteAgrClien = new javax.swing.JLabel();
        jTFNombreClienteAgrClien = new javax.swing.JTextField();
        jTFTelefonoClienteAg = new javax.swing.JTextField();
        jTFDomicilioClienteAgrClien = new javax.swing.JTextField();
        jTFApellidoClienteAgrClien = new javax.swing.JTextField();
        jLBtnAgregarCliente = new javax.swing.JLabel();
        jlIconAgreCli1 = new javax.swing.JLabel();
        jtpModClien = new javax.swing.JPanel();
        jLTituloModClien = new javax.swing.JLabel();
        jLBuscarClienModClien = new javax.swing.JLabel();
        jSModClien1 = new javax.swing.JSeparator();
        jTFNombreClienModClien = new javax.swing.JTextField();
        jSModClien2 = new javax.swing.JSeparator();
        jTFApellidoModClien = new javax.swing.JTextField();
        jSModClien3 = new javax.swing.JSeparator();
        jTFDomicilioModClien = new javax.swing.JTextField();
        jSModClien4 = new javax.swing.JSeparator();
        jTFTelefonoModClien = new javax.swing.JTextField();
        jLNombreClienModClien = new javax.swing.JLabel();
        jLApellidoModClien = new javax.swing.JLabel();
        jLDomicilioModClien = new javax.swing.JLabel();
        jLTelefonoModClien = new javax.swing.JLabel();
        jLBtnModificarModClien = new javax.swing.JLabel();
        jcbClienteModifCli = new javax.swing.JComboBox<>();
        jlIconModCli1 = new javax.swing.JLabel();
        jtpElimClien = new javax.swing.JPanel();
        jLDomicilioElimClien = new javax.swing.JLabel();
        jTFNombreClienElimClien = new javax.swing.JTextField();
        jLBtnEliminarElimClien = new javax.swing.JLabel();
        jLNombreClienElimClien = new javax.swing.JLabel();
        jLApellidoElimClien = new javax.swing.JLabel();
        jCBBuscarClienElimClien = new javax.swing.JComboBox<>();
        jSElimClien1 = new javax.swing.JSeparator();
        jTFApellidoClienElimClien = new javax.swing.JTextField();
        jLBuscarClienElimClien = new javax.swing.JLabel();
        jLTituloEliminarCliente = new javax.swing.JLabel();
        jLTelefonoElimClien = new javax.swing.JLabel();
        jSElimClien2 = new javax.swing.JSeparator();
        jTFTelefonoElimClien = new javax.swing.JTextField();
        jSElimClien3 = new javax.swing.JSeparator();
        jTFDomicilioElimClien = new javax.swing.JTextField();
        jSElimClien4 = new javax.swing.JSeparator();
        jlIconEliCli1 = new javax.swing.JLabel();
        jtpListClien = new javax.swing.JPanel();
        jLTituloListaClien = new javax.swing.JLabel();
        ScrollListClien = new javax.swing.JScrollPane();
        jtListClien = new TablaFraveMax();
        jtfBuscadorClienListClien = new javax.swing.JTextField();
        jlImgBusqueda = new javax.swing.JLabel();
        jlBusquedaCliente = new javax.swing.JLabel();
        jtpAgrVenta = new javax.swing.JPanel();
        jlAgrVentas = new javax.swing.JLabel();
        jlSelecProVenta = new javax.swing.JLabel();
        jcbProVenta = new javax.swing.JComboBox<>();
        jlCantidadVenta = new javax.swing.JLabel();
        jtfCantidadVenta = new javax.swing.JTextField();
        jlFechaVenta = new javax.swing.JLabel();
        jlTelCliente = new javax.swing.JLabel();
        jtfTelCliente = new javax.swing.JTextField();
        jlPrecioVenta = new javax.swing.JLabel();
        jtfPrecioVenta = new javax.swing.JTextField();
        jlRealizarVenta = new javax.swing.JLabel();
        jlNombreEmp = new javax.swing.JLabel();
        jtfNombreEmpVenta = new javax.swing.JTextField();
        jlIconVentaAgr = new javax.swing.JLabel();
        jdcAgrVenta = new com.toedter.calendar.JDateChooser();
        ScrollTablaVentas1 = new javax.swing.JScrollPane();
        jtListaGuardVentas = new TablaFraveMax();
        jlEliminarProdTabla1 = new javax.swing.JLabel();
        jLimpiarTablaAaVen = new javax.swing.JLabel();
        jlAgregarProdTabla = new javax.swing.JLabel();
        jtpListaVentas = new javax.swing.JPanel();
        jlListaVenta = new javax.swing.JLabel();
        ScrollTablaVentas = new javax.swing.JScrollPane();
        jtListaVentas = new TablaFraveMax();
        jlSelecFechaVenta = new javax.swing.JLabel();
        jdcBusquedaVentas = new com.toedter.calendar.JDateChooser();
        jlIconBuscarVenta = new javax.swing.JLabel();
        jtpDetallesVenta = new javax.swing.JPanel();
        jlDetallesVenta = new javax.swing.JLabel();
        ScrollTablaDetalles = new javax.swing.JScrollPane();
        jtListaDetalles = new TablaFraveMax();
        jcbVentasXCliente = new javax.swing.JComboBox<>();
        jlSelecPro = new javax.swing.JLabel();
        jlSelecFecha = new javax.swing.JLabel();
        jlTelCliDetalles = new javax.swing.JLabel();
        jSep2 = new javax.swing.JSeparator();
        jlIconBuscar2 = new javax.swing.JLabel();
        jlIconBuscar1 = new javax.swing.JLabel();
        jlIconBuscar = new javax.swing.JLabel();
        jlClientesxPro = new javax.swing.JLabel();
        jlVentasCli = new javax.swing.JLabel();
        jSep1 = new javax.swing.JSeparator();
        jdcFechaPro = new com.toedter.calendar.JDateChooser();
        jlProXFecha = new javax.swing.JLabel();
        jcbProXCliente = new javax.swing.JComboBox<>();
        jtpEliminarVenta = new javax.swing.JPanel();
        jlBorrarVenta = new javax.swing.JLabel();
        jlBuscarVenta = new javax.swing.JLabel();
        jcbBuscarVenta = new javax.swing.JComboBox<>();
        jlNombreProEliminar = new javax.swing.JLabel();
        jtfTelClienteEliminar = new javax.swing.JLabel();
        jtfTelCliEliminar = new javax.swing.JTextField();
        jSElimProd6 = new javax.swing.JSeparator();
        jtfNombreEmpleadoEliminar = new javax.swing.JTextField();
        jSElimProd7 = new javax.swing.JSeparator();
        jlNombreEmpleadoEliminar = new javax.swing.JLabel();
        jlFechaVentaEliminar = new javax.swing.JLabel();
        jlEliminarVentaBorrar = new javax.swing.JLabel();
        jlVentaIconEliminar = new javax.swing.JLabel();
        jdcElimVenta = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProductosElim = new javax.swing.JList<>();
        jPGestionEmpleados = new javax.swing.JPanel();
        jlGestionEmpleado1 = new javax.swing.JLabel();
        jlIconAgreEmpl = new javax.swing.JLabel();
        jlAgregarEmpleado = new javax.swing.JLabel();
        jlAgregarEmpl = new javax.swing.JLabel();
        textEmpleadoA = new javax.swing.JLabel();
        rectanguloAgEmpl = new javax.swing.JLabel();
        textEmpleadoM = new javax.swing.JLabel();
        jlModificarEmpleado = new javax.swing.JLabel();
        jlModEmpl = new javax.swing.JLabel();
        jlIconModEmpl = new javax.swing.JLabel();
        rectanguloModifEmpl = new javax.swing.JLabel();
        jlEliminarEmp = new javax.swing.JLabel();
        textEmpleadoElim = new javax.swing.JLabel();
        jlEliminarEmpleado = new javax.swing.JLabel();
        jlIconEliEmpl = new javax.swing.JLabel();
        jlListarEmpleado = new javax.swing.JLabel();
        rectanguloElimEmpl = new javax.swing.JLabel();
        jtpModificarEmpleado = new javax.swing.JPanel();
        jLTituloModEmpl = new javax.swing.JLabel();
        jLBuscarEmpleadoModEmpl = new javax.swing.JLabel();
        jCBModificarEmpleado = new javax.swing.JComboBox<>();
        jLNombreEmpModEmp1 = new javax.swing.JLabel();
        jSModEmpl5 = new javax.swing.JSeparator();
        jTFNombreEmpleadoModEmp = new javax.swing.JTextField();
        jLDniModEmp = new javax.swing.JLabel();
        jTFDniModEmp = new javax.swing.JTextField();
        jSModEmp7 = new javax.swing.JSeparator();
        jLUsuarioModEmp = new javax.swing.JLabel();
        jSModEmp9 = new javax.swing.JSeparator();
        jTFUsuarioModEmp = new javax.swing.JTextField();
        jLBtnModificarModEmp = new javax.swing.JLabel();
        jSModEmp = new javax.swing.JSeparator();
        jTFContraseñaModEmp = new javax.swing.JTextField();
        jLContraseñaModEmp = new javax.swing.JLabel();
        jCBCargoModifEmp = new javax.swing.JComboBox<>();
        jLCargoModEmp = new javax.swing.JLabel();
        jSModEmp6 = new javax.swing.JSeparator();
        jTFApellidoModEmp = new javax.swing.JTextField();
        jLApellidoModEmp = new javax.swing.JLabel();
        jtpEliminarEmpleado = new javax.swing.JPanel();
        jLTituloElimEmpleado = new javax.swing.JLabel();
        jLEliminarEmpleado = new javax.swing.JLabel();
        jCBEliminarEmpleado = new javax.swing.JComboBox<>();
        jLNombreEmpElimEmp = new javax.swing.JLabel();
        jTFNombreEmpleadoElimEmp = new javax.swing.JTextField();
        jSModEmpl6 = new javax.swing.JSeparator();
        jLDniElimEmp = new javax.swing.JLabel();
        jTFDniElimEmp = new javax.swing.JTextField();
        jSModEmp8 = new javax.swing.JSeparator();
        jLUsuarioElimEmp = new javax.swing.JLabel();
        jTFUsuarioElimEmp = new javax.swing.JTextField();
        jSModEmp10 = new javax.swing.JSeparator();
        jLContraseñaElimEmp = new javax.swing.JLabel();
        jTFContraseñaElimEmp = new javax.swing.JTextField();
        jSModEmp1 = new javax.swing.JSeparator();
        jLCargoElimEmp = new javax.swing.JLabel();
        jCBCargoElimEmp = new javax.swing.JComboBox<>();
        jLApellidoElimEmp = new javax.swing.JLabel();
        jTFApellidoElimEmp = new javax.swing.JTextField();
        jSModEmp11 = new javax.swing.JSeparator();
        jLBtnEliminarEmpleado = new javax.swing.JLabel();
        jtpListaEmp = new javax.swing.JPanel();
        jLTituloListaEmpleados = new javax.swing.JLabel();
        jlImgBusquedaEmpl = new javax.swing.JLabel();
        jtfBuscadorEmpleadosListEmp = new javax.swing.JTextField();
        ScrollListClien1 = new javax.swing.JScrollPane();
        jtListEmpleado = new TablaFraveMax();
        jlBusquedaEmp = new javax.swing.JLabel();
        jtpPapelera = new javax.swing.JPanel();
        jlVentaPapelera = new javax.swing.JLabel();
        jlCliente = new javax.swing.JLabel();
        jlProductoPapelera = new javax.swing.JLabel();
        jlEmpleadoPapelera = new javax.swing.JLabel();
        jlEliminarPapelera = new javax.swing.JLabel();
        jlRestaurarPapelera = new javax.swing.JLabel();
        jScrollPanePapelera = new javax.swing.JScrollPane();
        jTablePapelera = new javax.swing.JTable();
        jlPapelera = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 500));

        BackGround.setBackground(new java.awt.Color(255, 255, 255));
        BackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlNombreUsuario.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombreUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/circulo-de-usuario.png"))); // NOI18N
        jlNombreUsuario.setText("Nombre de Usuario");
        jlNombreUsuario.setToolTipText("");
        jlNombreUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlNombreUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlNombreUsuario.setIconTextGap(6);
        jlNombreUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanelCabecera.add(jlNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 100));

        fravemaxLogo.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        fravemaxLogo.setForeground(new java.awt.Color(255, 255, 255));
        fravemaxLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fravemaxLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fravemax.png"))); // NOI18N
        fravemaxLogo.setText("BIENVENIDO A FRAVEMAX");
        fravemaxLogo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        fravemaxLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fravemaxLogo.setIconTextGap(0);
        fravemaxLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanelCabecera.add(fravemaxLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 170, 100));

        jlMinimizar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jlMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        jlMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMinimizar.setText("_");
        jlMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlMinimizarMouseExited(evt);
            }
        });
        jPanelCabecera.add(jlMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 30, 30));

        jlSalir.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jlSalir.setForeground(new java.awt.Color(255, 255, 255));
        jlSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSalir.setText("X");
        jlSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlSalirMouseExited(evt);
            }
        });
        jPanelCabecera.add(jlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 30));

        jlCabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Cabecera.png"))); // NOI18N
        jlCabecera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), null, null));
        jlCabecera.setOpaque(true);
        jlCabecera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jlCabeceraMouseDragged(evt);
            }
        });
        jlCabecera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlCabeceraMousePressed(evt);
            }
        });
        jPanelCabecera.add(jlCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        BackGround.add(jPanelCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        jPanelOpciones.setBackground(new java.awt.Color(51, 51, 76));
        jPanelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlProductos.setBackground(new java.awt.Color(51, 51, 76));
        jlProductos.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlProductos.setForeground(new java.awt.Color(255, 255, 255));
        jlProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Productos.png"))); // NOI18N
        jlProductos.setText("Productos");
        jlProductos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 25, 1, 1));
        jlProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlProductos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlProductos.setIconTextGap(15);
        jlProductos.setOpaque(true);
        jlProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlProductosMouseExited(evt);
            }
        });
        jPanelOpciones.add(jlProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 40));

        jlClientes.setBackground(new java.awt.Color(51, 51, 76));
        jlClientes.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlClientes.setForeground(new java.awt.Color(255, 255, 255));
        jlClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/usuarios.png"))); // NOI18N
        jlClientes.setText("Clientes");
        jlClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 25, 1, 1));
        jlClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlClientes.setIconTextGap(15);
        jlClientes.setOpaque(true);
        jlClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlClientesMouseExited(evt);
            }
        });
        jPanelOpciones.add(jlClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, 40));

        jlVentas.setBackground(new java.awt.Color(51, 51, 76));
        jlVentas.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlVentas.setForeground(new java.awt.Color(255, 255, 255));
        jlVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/carrito-de-compras.png"))); // NOI18N
        jlVentas.setText("Ventas");
        jlVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 25, 1, 1));
        jlVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlVentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlVentas.setIconTextGap(15);
        jlVentas.setOpaque(true);
        jlVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlVentasMouseExited(evt);
            }
        });
        jPanelOpciones.add(jlVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 40));

        jlCerrarSesion.setBackground(new java.awt.Color(51, 51, 76));
        jlCerrarSesion.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jlCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salir-alt.png"))); // NOI18N
        jlCerrarSesion.setText("Cerrar Sesion");
        jlCerrarSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 25, 1, 1));
        jlCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlCerrarSesion.setIconTextGap(15);
        jlCerrarSesion.setOpaque(true);
        jlCerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlCerrarSesionMouseExited(evt);
            }
        });
        jPanelOpciones.add(jlCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, 40));

        jlInicio.setBackground(new java.awt.Color(51, 51, 76));
        jlInicio.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlInicio.setForeground(new java.awt.Color(255, 255, 255));
        jlInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Inicio.png"))); // NOI18N
        jlInicio.setText("Inicio");
        jlInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 25, 1, 1));
        jlInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlInicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlInicio.setIconTextGap(15);
        jlInicio.setOpaque(true);
        jlInicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlInicioMouseExited(evt);
            }
        });
        jPanelOpciones.add(jlInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 40));

        jLEmpleados.setBackground(new java.awt.Color(51, 51, 76));
        jLEmpleados.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        jLEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/empleado_1.png"))); // NOI18N
        jLEmpleados.setText("Empleados");
        jLEmpleados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 25, 1, 1));
        jLEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLEmpleados.setIconTextGap(15);
        jLEmpleados.setOpaque(true);
        jLEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLEmpleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLEmpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLEmpleadosMouseExited(evt);
            }
        });
        jPanelOpciones.add(jLEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 200, 40));

        jlPapeleraMenu.setBackground(new java.awt.Color(51, 51, 76));
        jlPapeleraMenu.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlPapeleraMenu.setForeground(new java.awt.Color(255, 255, 255));
        jlPapeleraMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reciclar.png"))); // NOI18N
        jlPapeleraMenu.setText("Papelera");
        jlPapeleraMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 25, 1, 1));
        jlPapeleraMenu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlPapeleraMenu.setIconTextGap(15);
        jlPapeleraMenu.setOpaque(true);
        jlPapeleraMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlPapeleraMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlPapeleraMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlPapeleraMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlPapeleraMenuMouseExited(evt);
            }
        });
        jPanelOpciones.add(jlPapeleraMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 40));

        BackGround.add(jPanelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 83, 200, 420));

        jtpInicio.setBackground(new java.awt.Color(255, 255, 255));
        jtpInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlIconPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/electrodomestico.png"))); // NOI18N
        jtpInicio.add(jlIconPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 150));

        jlIconVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/flecha-del-carrito-hacia-abajo.png"))); // NOI18N
        jtpInicio.add(jlIconVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 180, 150));

        jlIconCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/usuarios-alt.png"))); // NOI18N
        jtpInicio.add(jlIconCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 180, 150));

        jlClentesIn.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlClentesIn.setForeground(new java.awt.Color(102, 102, 102));
        jlClentesIn.setText("Clientes");
        jtpInicio.add(jlClentesIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jlVentasIn.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlVentasIn.setForeground(new java.awt.Color(102, 102, 102));
        jlVentasIn.setText("Ventas");
        jtpInicio.add(jlVentasIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jlProIn.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlProIn.setForeground(new java.awt.Color(102, 102, 102));
        jlProIn.setText("Productos");
        jtpInicio.add(jlProIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        verMasC.setBackground(new java.awt.Color(0, 150, 136));
        verMasC.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        verMasC.setForeground(new java.awt.Color(255, 255, 255));
        verMasC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verMasC.setText("Ver mas");
        verMasC.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        verMasC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        verMasC.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        verMasC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        verMasC.setOpaque(true);
        verMasC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        verMasC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMasCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verMasCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verMasCMouseExited(evt);
            }
        });
        jtpInicio.add(verMasC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 80, 30));

        verMasV.setBackground(new java.awt.Color(0, 150, 136));
        verMasV.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        verMasV.setForeground(new java.awt.Color(255, 255, 255));
        verMasV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verMasV.setText("Ver mas");
        verMasV.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        verMasV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        verMasV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        verMasV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        verMasV.setOpaque(true);
        verMasV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        verMasV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMasVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verMasVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verMasVMouseExited(evt);
            }
        });
        jtpInicio.add(verMasV, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 80, 30));

        verMasP.setBackground(new java.awt.Color(0, 150, 136));
        verMasP.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        verMasP.setForeground(new java.awt.Color(255, 255, 255));
        verMasP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verMasP.setText("Ver mas");
        verMasP.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        verMasP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        verMasP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        verMasP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        verMasP.setOpaque(true);
        verMasP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        verMasP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMasPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verMasPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verMasPMouseExited(evt);
            }
        });
        jtpInicio.add(verMasP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 80, 30));

        text3.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        text3.setForeground(new java.awt.Color(153, 153, 153));
        text3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpInicio.add(text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 150, 90));

        text2.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        text2.setForeground(new java.awt.Color(153, 153, 153));
        text2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpInicio.add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 150, 90));

        text1.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        text1.setForeground(new java.awt.Color(153, 153, 153));
        text1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        text1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jtpInicio.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 90));

        jlGestionDe.setBackground(new java.awt.Color(102, 102, 102));
        jlGestionDe.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jlGestionDe.setForeground(new java.awt.Color(153, 153, 153));
        jlGestionDe.setText("Gestion de ...");
        jtpInicio.add(jlGestionDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 30));

        rectanguloIn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpInicio.add(rectanguloIn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        rectanguloIn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpInicio.add(rectanguloIn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        rectanguloIn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpInicio.add(rectanguloIn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jtpEscritorio.addTab("tab1", jtpInicio);

        jtpVentas.setBackground(new java.awt.Color(255, 255, 255));
        jtpVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlGestionV.setBackground(new java.awt.Color(102, 102, 102));
        jlGestionV.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jlGestionV.setForeground(new java.awt.Color(153, 153, 153));
        jlGestionV.setText("Gestion de Ventas");
        jtpVentas.add(jlGestionV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 30));

        jlVentaIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlVentaIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/lista-del-portapapeles.png"))); // NOI18N
        jtpVentas.add(jlVentaIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 150));

        jlRegistrar.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlRegistrar.setForeground(new java.awt.Color(102, 102, 102));
        jlRegistrar.setText("Registrar");
        jtpVentas.add(jlRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        textVentaA.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        textVentaA.setForeground(new java.awt.Color(153, 153, 153));
        textVentaA.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        textVentaA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jtpVentas.add(textVentaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 90));

        textVentaD.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        textVentaD.setForeground(new java.awt.Color(153, 153, 153));
        textVentaD.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpVentas.add(textVentaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 150, 90));

        textVentaE.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        textVentaE.setForeground(new java.awt.Color(153, 153, 153));
        textVentaE.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpVentas.add(textVentaE, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 150, 90));

        RegistrarVenta.setBackground(new java.awt.Color(0, 150, 136));
        RegistrarVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        RegistrarVenta.setForeground(new java.awt.Color(255, 255, 255));
        RegistrarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegistrarVenta.setText("Registrar");
        RegistrarVenta.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        RegistrarVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        RegistrarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RegistrarVenta.setOpaque(true);
        RegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RegistrarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegistrarVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarVentaMouseExited(evt);
            }
        });
        jtpVentas.add(RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 80, 30));

        DetVenta.setBackground(new java.awt.Color(0, 150, 136));
        DetVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        DetVenta.setForeground(new java.awt.Color(255, 255, 255));
        DetVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DetVenta.setText("Detallar");
        DetVenta.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        DetVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        DetVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DetVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DetVenta.setOpaque(true);
        DetVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DetVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DetVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DetVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DetVentaMouseExited(evt);
            }
        });
        jtpVentas.add(DetVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 80, 30));

        EliminarVenta.setBackground(new java.awt.Color(0, 150, 136));
        EliminarVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        EliminarVenta.setForeground(new java.awt.Color(255, 255, 255));
        EliminarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EliminarVenta.setText("Eliminar");
        EliminarVenta.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        EliminarVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        EliminarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EliminarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarVenta.setOpaque(true);
        EliminarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EliminarVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EliminarVentaMouseExited(evt);
            }
        });
        jtpVentas.add(EliminarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 80, 30));

        jlEliminarVenta.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlEliminarVenta.setForeground(new java.awt.Color(102, 102, 102));
        jlEliminarVenta.setText("Eliminar");
        jtpVentas.add(jlEliminarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jlVentaIcon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlVentaIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/archivo-menos.png"))); // NOI18N
        jtpVentas.add(jlVentaIcon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 180, 150));

        rectanguloV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpVentas.add(rectanguloV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        jlVentaIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlVentaIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/informacion-del-circulo-de-archivos.png"))); // NOI18N
        jtpVentas.add(jlVentaIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 180, 150));

        jlDetalles.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlDetalles.setForeground(new java.awt.Color(102, 102, 102));
        jlDetalles.setText("Detalles");
        jtpVentas.add(jlDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        rectanguloV2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpVentas.add(rectanguloV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        rectanguloV3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpVentas.add(rectanguloV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jlListarVenta.setBackground(new java.awt.Color(0, 150, 136));
        jlListarVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlListarVenta.setForeground(new java.awt.Color(255, 255, 255));
        jlListarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListarVenta.setText("Listar Ventas");
        jlListarVenta.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlListarVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        jlListarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlListarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlListarVenta.setOpaque(true);
        jlListarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlListarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlListarVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlListarVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlListarVentaMouseExited(evt);
            }
        });
        jtpVentas.add(jlListarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 120, 30));

        jtpEscritorio.addTab("tab2", jtpVentas);

        jtpClientes.setBackground(new java.awt.Color(255, 255, 255));
        jtpClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlListarCliente.setBackground(new java.awt.Color(0, 150, 136));
        jlListarCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlListarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jlListarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListarCliente.setText("Listar Clientes");
        jlListarCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlListarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        jlListarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlListarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlListarCliente.setOpaque(true);
        jlListarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlListarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlListarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlListarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlListarClienteMouseExited(evt);
            }
        });
        jtpClientes.add(jlListarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 120, 30));

        jlIconEliCli.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconEliCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/borrar-usuario.png"))); // NOI18N
        jtpClientes.add(jlIconEliCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 180, 150));

        jlIconAgreCli.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconAgreCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/agregar-usuario.png"))); // NOI18N
        jtpClientes.add(jlIconAgreCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 150));

        jlIconModCli.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconModCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/editar-usuario.png"))); // NOI18N
        jtpClientes.add(jlIconModCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 180, 150));

        jlAgregarCliente.setBackground(new java.awt.Color(0, 150, 136));
        jlAgregarCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jlAgregarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAgregarCliente.setText("Agregar");
        jlAgregarCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlAgregarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        jlAgregarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlAgregarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlAgregarCliente.setOpaque(true);
        jlAgregarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlAgregarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAgregarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlAgregarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlAgregarClienteMouseExited(evt);
            }
        });
        jtpClientes.add(jlAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 80, 30));

        jlModificarCliente.setBackground(new java.awt.Color(0, 150, 136));
        jlModificarCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlModificarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jlModificarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlModificarCliente.setText("Modificar");
        jlModificarCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlModificarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        jlModificarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlModificarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlModificarCliente.setOpaque(true);
        jlModificarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlModificarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlModificarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlModificarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlModificarClienteMouseExited(evt);
            }
        });
        jtpClientes.add(jlModificarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 80, 30));

        jlEliminarCliente.setBackground(new java.awt.Color(0, 150, 136));
        jlEliminarCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jlEliminarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEliminarCliente.setText("Eliminar");
        jlEliminarCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlEliminarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        jlEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlEliminarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlEliminarCliente.setOpaque(true);
        jlEliminarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlEliminarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlEliminarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlEliminarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlEliminarClienteMouseExited(evt);
            }
        });
        jtpClientes.add(jlEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 80, 30));

        jlGestionClientes.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jlGestionClientes.setForeground(new java.awt.Color(153, 153, 153));
        jlGestionClientes.setText("Gestion de Clientes");
        jtpClientes.add(jlGestionClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, 30));

        textClienteE.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        textClienteE.setForeground(new java.awt.Color(153, 153, 153));
        textClienteE.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpClientes.add(textClienteE, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 150, 90));

        textClienteM.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        textClienteM.setForeground(new java.awt.Color(153, 153, 153));
        textClienteM.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpClientes.add(textClienteM, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 150, 90));

        textClienteA.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        textClienteA.setForeground(new java.awt.Color(153, 153, 153));
        textClienteA.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpClientes.add(textClienteA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 90));

        jlModClientes.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlModClientes.setForeground(new java.awt.Color(102, 102, 102));
        jlModClientes.setText("Modificar ");
        jtpClientes.add(jlModClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 80, -1));

        jlEliminarClientes.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlEliminarClientes.setForeground(new java.awt.Color(102, 102, 102));
        jlEliminarClientes.setText("Eliminar ");
        jtpClientes.add(jlEliminarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jlAgregarClientes.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlAgregarClientes.setForeground(new java.awt.Color(102, 102, 102));
        jlAgregarClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAgregarClientes.setText("Agregar ");
        jtpClientes.add(jlAgregarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        rectanguloCli1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rectanguloCli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpClientes.add(rectanguloCli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        rectanguloCli2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rectanguloCli2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpClientes.add(rectanguloCli2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        rectanguloCli3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rectanguloCli3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpClientes.add(rectanguloCli3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jtpEscritorio.addTab("tab3", jtpClientes);

        jtpProductos.setBackground(new java.awt.Color(255, 255, 255));
        jtpProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlListar.setBackground(new java.awt.Color(0, 150, 136));
        jlListar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlListar.setForeground(new java.awt.Color(255, 255, 255));
        jlListar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListar.setText("Listar Productos");
        jlListar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlListar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        jlListar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlListar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlListar.setOpaque(true);
        jlListar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlListarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlListarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlListarMouseExited(evt);
            }
        });
        jtpProductos.add(jlListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 120, 30));

        jlEliminar.setBackground(new java.awt.Color(0, 150, 136));
        jlEliminar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jlEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEliminar.setText("Eliminar");
        jlEliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        jlEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlEliminar.setOpaque(true);
        jlEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlEliminarMouseExited(evt);
            }
        });
        jtpProductos.add(jlEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 80, 30));

        jlIconoBorrarPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconoBorrarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/basura.png"))); // NOI18N
        jtpProductos.add(jlIconoBorrarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 180, 150));

        jlIconoAgregarPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconoAgregarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/agregar-documento.png"))); // NOI18N
        jtpProductos.add(jlIconoAgregarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 150));

        jlIconoModPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconoModPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/archivo-de-edicion.png"))); // NOI18N
        jtpProductos.add(jlIconoModPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 180, 150));

        jlAgregar.setBackground(new java.awt.Color(0, 150, 136));
        jlAgregar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jlAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAgregar.setText("Agregar");
        jlAgregar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        jlAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlAgregar.setOpaque(true);
        jlAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlAgregarMouseExited(evt);
            }
        });
        jtpProductos.add(jlAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 80, 30));

        jlModificar.setBackground(new java.awt.Color(0, 150, 136));
        jlModificar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlModificar.setForeground(new java.awt.Color(255, 255, 255));
        jlModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlModificar.setText("Modificar");
        jlModificar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
        jlModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlModificar.setOpaque(true);
        jlModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlModificarMouseExited(evt);
            }
        });
        jtpProductos.add(jlModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 80, 30));

        jlGestionPro.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jlGestionPro.setForeground(new java.awt.Color(153, 153, 153));
        jlGestionPro.setText("Gestion de Productos");
        jtpProductos.add(jlGestionPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, 30));

        textE.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        textE.setForeground(new java.awt.Color(153, 153, 153));
        textE.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpProductos.add(textE, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 150, 90));

        textM.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        textM.setForeground(new java.awt.Color(153, 153, 153));
        textM.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpProductos.add(textM, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 150, 90));

        textA.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        textA.setForeground(new java.awt.Color(153, 153, 153));
        textA.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jtpProductos.add(textA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 90));

        jlModPro.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlModPro.setForeground(new java.awt.Color(102, 102, 102));
        jlModPro.setText("Modificar ");
        jtpProductos.add(jlModPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 80, -1));

        jlEliminarPro.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlEliminarPro.setForeground(new java.awt.Color(102, 102, 102));
        jlEliminarPro.setText("Eliminar ");
        jtpProductos.add(jlEliminarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jlAgregarPro.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlAgregarPro.setForeground(new java.awt.Color(102, 102, 102));
        jlAgregarPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAgregarPro.setText("Agregar ");
        jtpProductos.add(jlAgregarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        rectangulo1Pro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rectangulo1Pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpProductos.add(rectangulo1Pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        rectangulo2Pro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rectangulo2Pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpProductos.add(rectangulo2Pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        rectangulo3Pro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rectangulo3Pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
        jtpProductos.add(rectangulo3Pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jtpEscritorio.addTab("tab4", jtpProductos);

        jtpListaP.setBackground(new java.awt.Color(255, 255, 255));
        jtpListaP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlListaProAc.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jlListaProAc.setForeground(new java.awt.Color(153, 153, 153));
        jlListaProAc.setText("Lista de Productos activos");
        jtpListaP.add(jlListaProAc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        Scroll.setBackground(new java.awt.Color(255, 255, 255));
        Scroll.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        jtListaPro.setBackground(new java.awt.Color(204, 204, 204));
        jtListaPro.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtListaPro.setModel(Modelo = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String[]{
                "ID", "Nombre", "Descripcion", "Precio Actual", "Stock"
            }
        ) {
            public boolean isCellEditable(int fila, int column) {
                return false;
            }

            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jtListaPro.setGridColor(new java.awt.Color(0, 102, 102));
        jtListaPro.setMinimumSize(new java.awt.Dimension(60, 60));
        Scroll.setViewportView(jtListaPro);

        jtpListaP.add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 120, 570, 290));

        jtfBuscador.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtpListaP.add(jtfBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 160, 30));

        jlBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        jlBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/busqueda - gris.png"))); // NOI18N
        jlBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlBusqueda.setOpaque(true);
        jlBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlBusquedaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlBusquedaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlBusquedaMouseExited(evt);
            }
        });
        jtpListaP.add(jlBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 40, 30));

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Busqueda por Nombre");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jtpListaP.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 30));

        jtpEscritorio.addTab("tab5", jtpListaP);

        jtpAgregarPro.setBackground(new java.awt.Color(255, 255, 255));
        jtpAgregarPro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLAgregarProducto.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jLAgregarProducto.setForeground(new java.awt.Color(153, 153, 153));
        jLAgregarProducto.setText("Agregar producto");
        jtpAgregarPro.add(jLAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 38));

        jLNombreProductoAP.setBackground(new java.awt.Color(153, 153, 153));
        jLNombreProductoAP.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLNombreProductoAP.setForeground(new java.awt.Color(153, 153, 153));
        jLNombreProductoAP.setText("Nombre de el producto");
        jtpAgregarPro.add(jLNombreProductoAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 24));

        jSAgrProd1.setBackground(new java.awt.Color(0, 150, 136));
        jtpAgregarPro.add(jSAgrProd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 10));

        jSAgrProd2.setBackground(new java.awt.Color(0, 150, 136));
        jtpAgregarPro.add(jSAgrProd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 210, 20));

        jLDescripcionAP.setBackground(new java.awt.Color(153, 153, 153));
        jLDescripcionAP.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLDescripcionAP.setForeground(new java.awt.Color(153, 153, 153));
        jLDescripcionAP.setText("Descripción");
        jtpAgregarPro.add(jLDescripcionAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 24));

        jSAgrProd3.setBackground(new java.awt.Color(0, 150, 136));
        jtpAgregarPro.add(jSAgrProd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 210, 10));

        jLPrecioActualAP.setBackground(new java.awt.Color(153, 153, 153));
        jLPrecioActualAP.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLPrecioActualAP.setForeground(new java.awt.Color(153, 153, 153));
        jLPrecioActualAP.setText("Precio Actual");
        jtpAgregarPro.add(jLPrecioActualAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, 24));

        jSAgrProd4.setBackground(new java.awt.Color(0, 150, 136));
        jtpAgregarPro.add(jSAgrProd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 210, 20));

        jLStockAP.setBackground(new java.awt.Color(153, 153, 153));
        jLStockAP.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLStockAP.setForeground(new java.awt.Color(153, 153, 153));
        jLStockAP.setText("Stock:");
        jtpAgregarPro.add(jLStockAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, 24));

        jLBtnAgregarProd.setBackground(new java.awt.Color(0, 150, 136));
        jLBtnAgregarProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBtnAgregarProd.setForeground(new java.awt.Color(255, 255, 255));
        jLBtnAgregarProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBtnAgregarProd.setText("Agregar");
        jLBtnAgregarProd.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLBtnAgregarProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLBtnAgregarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLBtnAgregarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLBtnAgregarProd.setOpaque(true);
        jLBtnAgregarProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBtnAgregarProdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBtnAgregarProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBtnAgregarProdMouseExited(evt);
            }
        });
        jtpAgregarPro.add(jLBtnAgregarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 80, 30));

        jTFNombreProductoAgrProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFNombreProductoAgrProd.setBorder(null);
        jTFNombreProductoAgrProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreProductoAgrProdKeyTyped(evt);
            }
        });
        jtpAgregarPro.add(jTFNombreProductoAgrProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 210, 30));

        jTFDescripcionAgrProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFDescripcionAgrProd.setBorder(null);
        jtpAgregarPro.add(jTFDescripcionAgrProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 210, 30));

        jTFPrecioActualAgrProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFPrecioActualAgrProd.setBorder(null);
        jTFPrecioActualAgrProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPrecioActualAgrProdKeyTyped(evt);
            }
        });
        jtpAgregarPro.add(jTFPrecioActualAgrProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 210, 30));

        jTFStockAgrProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFStockAgrProd.setBorder(null);
        jTFStockAgrProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFStockAgrProdKeyTyped(evt);
            }
        });
        jtpAgregarPro.add(jTFStockAgrProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 210, 30));

        jlIconoAgregarPro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconoAgregarPro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/agregar-documento.png"))); // NOI18N
        jtpAgregarPro.add(jlIconoAgregarPro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 230, 150));

        jtpEscritorio.addTab("tab6", jtpAgregarPro);

        jtpEliminarPro.setBackground(new java.awt.Color(255, 255, 255));
        jtpEliminarPro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLTituloEliminarProducto.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jLTituloEliminarProducto.setForeground(new java.awt.Color(153, 153, 153));
        jLTituloEliminarProducto.setText("Eliminar producto");
        jtpEliminarPro.add(jLTituloEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLBuscarProdElimProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBuscarProdElimProd.setForeground(new java.awt.Color(153, 153, 153));
        jLBuscarProdElimProd.setText("Buscar producto");
        jtpEliminarPro.add(jLBuscarProdElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jCBBuscarProdElimProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jCBBuscarProdElimProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBuscarProdElimProdActionPerformed(evt);
            }
        });
        jtpEliminarPro.add(jCBBuscarProdElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 200, 30));

        jLNombreProdElimProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLNombreProdElimProd.setForeground(new java.awt.Color(153, 153, 153));
        jLNombreProdElimProd.setText("Nombre producto");
        jtpEliminarPro.add(jLNombreProdElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jTFNombreProdElimProd.setEditable(false);
        jTFNombreProdElimProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFNombreProdElimProd.setBorder(null);
        jTFNombreProdElimProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreProdElimProdKeyTyped(evt);
            }
        });
        jtpEliminarPro.add(jTFNombreProdElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, 30));

        jLPrecioActualElimProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLPrecioActualElimProd.setForeground(new java.awt.Color(153, 153, 153));
        jLPrecioActualElimProd.setText("Precio Actual");
        jtpEliminarPro.add(jLPrecioActualElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jSElimProd1.setBackground(new java.awt.Color(0, 150, 136));
        jSElimProd1.setOpaque(true);
        jSElimProd1.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpEliminarPro.add(jSElimProd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 200, -1));

        jTFPrecioActuaElimProd.setEditable(false);
        jTFPrecioActuaElimProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFPrecioActuaElimProd.setBorder(null);
        jTFPrecioActuaElimProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPrecioActuaElimProdKeyTyped(evt);
            }
        });
        jtpEliminarPro.add(jTFPrecioActuaElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 200, 30));

        jSElimProd2.setBackground(new java.awt.Color(0, 150, 136));
        jSElimProd2.setOpaque(true);
        jSElimProd2.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpEliminarPro.add(jSElimProd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 200, -1));

        jTFStockElimProd.setEditable(false);
        jTFStockElimProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFStockElimProd.setBorder(null);
        jTFStockElimProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFStockElimProdKeyTyped(evt);
            }
        });
        jtpEliminarPro.add(jTFStockElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 200, 30));

        jSElimProd3.setBackground(new java.awt.Color(0, 150, 136));
        jSElimProd3.setOpaque(true);
        jSElimProd3.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpEliminarPro.add(jSElimProd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 200, -1));

        jLStockElimProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLStockElimProd.setForeground(new java.awt.Color(153, 153, 153));
        jLStockElimProd.setText("Stock");
        jtpEliminarPro.add(jLStockElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        jTFDescripcionElimProd.setEditable(false);
        jTFDescripcionElimProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFDescripcionElimProd.setBorder(null);
        jtpEliminarPro.add(jTFDescripcionElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 200, 30));

        jSElimProd4.setBackground(new java.awt.Color(0, 150, 136));
        jSElimProd4.setOpaque(true);
        jSElimProd4.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpEliminarPro.add(jSElimProd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 200, -1));

        jLDescripcionElimProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLDescripcionElimProd.setForeground(new java.awt.Color(153, 153, 153));
        jLDescripcionElimProd.setText("Descripción");
        jtpEliminarPro.add(jLDescripcionElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLBtnEliminarElimProd.setBackground(new java.awt.Color(0, 150, 136));
        jLBtnEliminarElimProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBtnEliminarElimProd.setForeground(new java.awt.Color(255, 255, 255));
        jLBtnEliminarElimProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBtnEliminarElimProd.setText("Eliminar");
        jLBtnEliminarElimProd.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLBtnEliminarElimProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLBtnEliminarElimProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLBtnEliminarElimProd.setOpaque(true);
        jLBtnEliminarElimProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBtnEliminarElimProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBtnEliminarElimProdMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLBtnEliminarElimProdMousePressed(evt);
            }
        });
        jtpEliminarPro.add(jLBtnEliminarElimProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 100, 30));

        jlIconoBorrarPro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconoBorrarPro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/basura.png"))); // NOI18N
        jtpEliminarPro.add(jlIconoBorrarPro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 200, 150));

        jtpEscritorio.addTab("tab7", jtpEliminarPro);

        jtpModPro.setBackground(new java.awt.Color(255, 255, 255));
        jtpModPro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLModificarProd.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jLModificarProd.setForeground(new java.awt.Color(153, 153, 153));
        jLModificarProd.setText("Modificar producto");
        jtpModPro.add(jLModificarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLBuscarProdModProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBuscarProdModProd.setForeground(new java.awt.Color(153, 153, 153));
        jLBuscarProdModProd.setText("Buscar producto");
        jtpModPro.add(jLBuscarProdModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jSModProd1.setBackground(new java.awt.Color(0, 150, 136));
        jSModProd1.setOpaque(true);
        jSModProd1.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpModPro.add(jSModProd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 200, -1));

        jTFNombreProdModProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFNombreProdModProd.setBorder(null);
        jTFNombreProdModProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreProdModProdKeyTyped(evt);
            }
        });
        jtpModPro.add(jTFNombreProdModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, 30));

        jSModProd2.setBackground(new java.awt.Color(0, 150, 136));
        jSModProd2.setOpaque(true);
        jSModProd2.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpModPro.add(jSModProd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 200, -1));

        jTFDescripcionModProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFDescripcionModProd.setBorder(null);
        jtpModPro.add(jTFDescripcionModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 200, 30));

        jSModProd3.setBackground(new java.awt.Color(0, 150, 136));
        jSModProd3.setOpaque(true);
        jSModProd3.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpModPro.add(jSModProd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 200, -1));

        jTFPrecioActualModProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFPrecioActualModProd.setBorder(null);
        jTFPrecioActualModProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPrecioActualModProdKeyTyped(evt);
            }
        });
        jtpModPro.add(jTFPrecioActualModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 200, 30));

        jSModProd4.setBackground(new java.awt.Color(0, 150, 136));
        jSModProd4.setOpaque(true);
        jSModProd4.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpModPro.add(jSModProd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 200, -1));

        jTFStockModProd.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFStockModProd.setBorder(null);
        jTFStockModProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFStockModProdKeyTyped(evt);
            }
        });
        jtpModPro.add(jTFStockModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 200, 30));

        jLNombreProdModProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLNombreProdModProd.setForeground(new java.awt.Color(153, 153, 153));
        jLNombreProdModProd.setText("Nombre producto");
        jtpModPro.add(jLNombreProdModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLDescripcionModProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLDescripcionModProd.setForeground(new java.awt.Color(153, 153, 153));
        jLDescripcionModProd.setText("Descripción");
        jtpModPro.add(jLDescripcionModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLPrecioActualModProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLPrecioActualModProd.setForeground(new java.awt.Color(153, 153, 153));
        jLPrecioActualModProd.setText("Precio Actual");
        jtpModPro.add(jLPrecioActualModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLStockModProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLStockModProd.setForeground(new java.awt.Color(153, 153, 153));
        jLStockModProd.setText("Stock");
        jtpModPro.add(jLStockModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        jLBtnModificarModProd.setBackground(new java.awt.Color(0, 150, 136));
        jLBtnModificarModProd.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBtnModificarModProd.setForeground(new java.awt.Color(255, 255, 255));
        jLBtnModificarModProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBtnModificarModProd.setText("Modificar");
        jLBtnModificarModProd.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLBtnModificarModProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLBtnModificarModProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLBtnModificarModProd.setOpaque(true);
        jLBtnModificarModProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBtnModificarModProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBtnModificarModProdMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLBtnModificarModProdMousePressed(evt);
            }
        });
        jtpModPro.add(jLBtnModificarModProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 100, 30));

        jcbProductos.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jcbProductos.setForeground(new java.awt.Color(0, 102, 102));
        jcbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProductosActionPerformed(evt);
            }
        });
        jtpModPro.add(jcbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 200, 30));

        jlIconoModPro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconoModPro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/archivo-de-edicion.png"))); // NOI18N
        jtpModPro.add(jlIconoModPro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 200, 150));

        jtpEscritorio.addTab("tab8", jtpModPro);

        jtpAgrClien.setBackground(new java.awt.Color(255, 255, 255));
        jtpAgrClien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLTituloAgrClien.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jLTituloAgrClien.setForeground(new java.awt.Color(153, 153, 153));
        jLTituloAgrClien.setText("Agregar cliente");
        jtpAgrClien.add(jLTituloAgrClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLNombreClienteAgrClien.setBackground(new java.awt.Color(153, 153, 153));
        jLNombreClienteAgrClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLNombreClienteAgrClien.setForeground(new java.awt.Color(153, 153, 153));
        jLNombreClienteAgrClien.setText("Nombre de el cliente");
        jtpAgrClien.add(jLNombreClienteAgrClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 24));

        jSAgrClien1.setBackground(new java.awt.Color(0, 150, 136));
        jtpAgrClien.add(jSAgrClien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 10));

        jSAgrClien2.setBackground(new java.awt.Color(0, 150, 136));
        jtpAgrClien.add(jSAgrClien2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 210, 20));

        jLApellidoClienteAgrClien.setBackground(new java.awt.Color(153, 153, 153));
        jLApellidoClienteAgrClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLApellidoClienteAgrClien.setForeground(new java.awt.Color(153, 153, 153));
        jLApellidoClienteAgrClien.setText("Apellido de el cliente");
        jtpAgrClien.add(jLApellidoClienteAgrClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 24));

        jSAgrClien3.setBackground(new java.awt.Color(0, 150, 136));
        jtpAgrClien.add(jSAgrClien3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 210, 10));

        jLDomicilioClienteAgrClien.setBackground(new java.awt.Color(153, 153, 153));
        jLDomicilioClienteAgrClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLDomicilioClienteAgrClien.setForeground(new java.awt.Color(153, 153, 153));
        jLDomicilioClienteAgrClien.setText("Domicilio");
        jtpAgrClien.add(jLDomicilioClienteAgrClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, 24));

        jSAgrClien4.setBackground(new java.awt.Color(0, 150, 136));
        jtpAgrClien.add(jSAgrClien4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 210, 20));

        jLTelefonoClienteAgrClien.setBackground(new java.awt.Color(153, 153, 153));
        jLTelefonoClienteAgrClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLTelefonoClienteAgrClien.setForeground(new java.awt.Color(153, 153, 153));
        jLTelefonoClienteAgrClien.setText("Telefono");
        jtpAgrClien.add(jLTelefonoClienteAgrClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, 24));

        jTFNombreClienteAgrClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFNombreClienteAgrClien.setBorder(null);
        jTFNombreClienteAgrClien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreClienteAgrClienKeyTyped(evt);
            }
        });
        jtpAgrClien.add(jTFNombreClienteAgrClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 210, 30));

        jTFTelefonoClienteAg.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFTelefonoClienteAg.setBorder(null);
        jTFTelefonoClienteAg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefonoClienteAgKeyTyped(evt);
            }
        });
        jtpAgrClien.add(jTFTelefonoClienteAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 210, 30));

        jTFDomicilioClienteAgrClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFDomicilioClienteAgrClien.setBorder(null);
        jtpAgrClien.add(jTFDomicilioClienteAgrClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 210, 30));

        jTFApellidoClienteAgrClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFApellidoClienteAgrClien.setBorder(null);
        jTFApellidoClienteAgrClien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFApellidoClienteAgrClienKeyTyped(evt);
            }
        });
        jtpAgrClien.add(jTFApellidoClienteAgrClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 210, 30));

        jLBtnAgregarCliente.setBackground(new java.awt.Color(0, 150, 136));
        jLBtnAgregarCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBtnAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLBtnAgregarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBtnAgregarCliente.setText("Agregar");
        jLBtnAgregarCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLBtnAgregarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLBtnAgregarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLBtnAgregarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLBtnAgregarCliente.setOpaque(true);
        jLBtnAgregarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBtnAgregarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBtnAgregarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBtnAgregarClienteMouseExited(evt);
            }
        });
        jtpAgrClien.add(jLBtnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 80, 30));

        jlIconAgreCli1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconAgreCli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/agregar-usuario.png"))); // NOI18N
        jtpAgrClien.add(jlIconAgreCli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 230, 150));

        jtpEscritorio.addTab("tab9", jtpAgrClien);

        jtpModClien.setBackground(new java.awt.Color(255, 255, 255));
        jtpModClien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLTituloModClien.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jLTituloModClien.setForeground(new java.awt.Color(153, 153, 153));
        jLTituloModClien.setText("Modificar cliente");
        jtpModClien.add(jLTituloModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLBuscarClienModClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBuscarClienModClien.setForeground(new java.awt.Color(153, 153, 153));
        jLBuscarClienModClien.setText("Buscar cliente");
        jtpModClien.add(jLBuscarClienModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jSModClien1.setBackground(new java.awt.Color(0, 150, 136));
        jSModClien1.setOpaque(true);
        jSModClien1.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpModClien.add(jSModClien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 200, -1));

        jTFNombreClienModClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFNombreClienModClien.setBorder(null);
        jTFNombreClienModClien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreClienModClienKeyTyped(evt);
            }
        });
        jtpModClien.add(jTFNombreClienModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, 30));

        jSModClien2.setBackground(new java.awt.Color(0, 150, 136));
        jSModClien2.setOpaque(true);
        jSModClien2.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpModClien.add(jSModClien2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 200, -1));

        jTFApellidoModClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFApellidoModClien.setBorder(null);
        jTFApellidoModClien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFApellidoModClienKeyTyped(evt);
            }
        });
        jtpModClien.add(jTFApellidoModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 200, 30));

        jSModClien3.setBackground(new java.awt.Color(0, 150, 136));
        jSModClien3.setOpaque(true);
        jSModClien3.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpModClien.add(jSModClien3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 200, -1));

        jTFDomicilioModClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFDomicilioModClien.setBorder(null);
        jtpModClien.add(jTFDomicilioModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 200, 30));

        jSModClien4.setBackground(new java.awt.Color(0, 150, 136));
        jSModClien4.setOpaque(true);
        jSModClien4.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpModClien.add(jSModClien4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 200, -1));

        jTFTelefonoModClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFTelefonoModClien.setBorder(null);
        jTFTelefonoModClien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefonoModClienKeyTyped(evt);
            }
        });
        jtpModClien.add(jTFTelefonoModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 200, 30));

        jLNombreClienModClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLNombreClienModClien.setForeground(new java.awt.Color(153, 153, 153));
        jLNombreClienModClien.setText("Nombre cliente");
        jtpModClien.add(jLNombreClienModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLApellidoModClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLApellidoModClien.setForeground(new java.awt.Color(153, 153, 153));
        jLApellidoModClien.setText("Apellido cliente");
        jtpModClien.add(jLApellidoModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLDomicilioModClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLDomicilioModClien.setForeground(new java.awt.Color(153, 153, 153));
        jLDomicilioModClien.setText("Domicilio");
        jtpModClien.add(jLDomicilioModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLTelefonoModClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLTelefonoModClien.setForeground(new java.awt.Color(153, 153, 153));
        jLTelefonoModClien.setText("Telefono");
        jtpModClien.add(jLTelefonoModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        jLBtnModificarModClien.setBackground(new java.awt.Color(0, 150, 136));
        jLBtnModificarModClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBtnModificarModClien.setForeground(new java.awt.Color(255, 255, 255));
        jLBtnModificarModClien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBtnModificarModClien.setText("Modificar");
        jLBtnModificarModClien.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLBtnModificarModClien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLBtnModificarModClien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLBtnModificarModClien.setOpaque(true);
        jLBtnModificarModClien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBtnModificarModClienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBtnModificarModClienMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLBtnModificarModClienMousePressed(evt);
            }
        });
        jtpModClien.add(jLBtnModificarModClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 100, 30));

        jcbClienteModifCli.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jcbClienteModifCli.setForeground(new java.awt.Color(0, 102, 102));
        jcbClienteModifCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteModifCliActionPerformed(evt);
            }
        });
        jtpModClien.add(jcbClienteModifCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 290, 30));

        jlIconModCli1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconModCli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/editar-usuario.png"))); // NOI18N
        jtpModClien.add(jlIconModCli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 200, 150));

        jtpEscritorio.addTab("tab10", jtpModClien);

        jtpElimClien.setBackground(new java.awt.Color(255, 255, 255));
        jtpElimClien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLDomicilioElimClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLDomicilioElimClien.setForeground(new java.awt.Color(153, 153, 153));
        jLDomicilioElimClien.setText("Domicilio");
        jtpElimClien.add(jLDomicilioElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jTFNombreClienElimClien.setEditable(false);
        jTFNombreClienElimClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFNombreClienElimClien.setBorder(null);
        jtpElimClien.add(jTFNombreClienElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, 30));

        jLBtnEliminarElimClien.setBackground(new java.awt.Color(0, 150, 136));
        jLBtnEliminarElimClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBtnEliminarElimClien.setForeground(new java.awt.Color(255, 255, 255));
        jLBtnEliminarElimClien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBtnEliminarElimClien.setText("Eliminar");
        jLBtnEliminarElimClien.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLBtnEliminarElimClien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLBtnEliminarElimClien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLBtnEliminarElimClien.setOpaque(true);
        jLBtnEliminarElimClien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBtnEliminarElimClienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBtnEliminarElimClienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBtnEliminarElimClienMouseExited(evt);
            }
        });
        jtpElimClien.add(jLBtnEliminarElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 100, 30));

        jLNombreClienElimClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLNombreClienElimClien.setForeground(new java.awt.Color(153, 153, 153));
        jLNombreClienElimClien.setText("Nombre cliente");
        jtpElimClien.add(jLNombreClienElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLApellidoElimClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLApellidoElimClien.setForeground(new java.awt.Color(153, 153, 153));
        jLApellidoElimClien.setText("Apellido cliente");
        jtpElimClien.add(jLApellidoElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jCBBuscarClienElimClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jCBBuscarClienElimClien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBuscarClienElimClienActionPerformed(evt);
            }
        });
        jtpElimClien.add(jCBBuscarClienElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 200, 30));

        jSElimClien1.setBackground(new java.awt.Color(0, 150, 136));
        jSElimClien1.setOpaque(true);
        jSElimClien1.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpElimClien.add(jSElimClien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 200, -1));

        jTFApellidoClienElimClien.setEditable(false);
        jTFApellidoClienElimClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFApellidoClienElimClien.setBorder(null);
        jtpElimClien.add(jTFApellidoClienElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 200, 30));

        jLBuscarClienElimClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBuscarClienElimClien.setForeground(new java.awt.Color(153, 153, 153));
        jLBuscarClienElimClien.setText("Buscar cliente");
        jtpElimClien.add(jLBuscarClienElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLTituloEliminarCliente.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jLTituloEliminarCliente.setForeground(new java.awt.Color(153, 153, 153));
        jLTituloEliminarCliente.setText("Eliminar cliente");
        jtpElimClien.add(jLTituloEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLTelefonoElimClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLTelefonoElimClien.setForeground(new java.awt.Color(153, 153, 153));
        jLTelefonoElimClien.setText("Telefono");
        jtpElimClien.add(jLTelefonoElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        jSElimClien2.setBackground(new java.awt.Color(0, 150, 136));
        jSElimClien2.setOpaque(true);
        jSElimClien2.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpElimClien.add(jSElimClien2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 200, -1));

        jTFTelefonoElimClien.setEditable(false);
        jTFTelefonoElimClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFTelefonoElimClien.setBorder(null);
        jtpElimClien.add(jTFTelefonoElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 200, 30));

        jSElimClien3.setBackground(new java.awt.Color(0, 150, 136));
        jSElimClien3.setOpaque(true);
        jSElimClien3.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpElimClien.add(jSElimClien3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 200, -1));

        jTFDomicilioElimClien.setEditable(false);
        jTFDomicilioElimClien.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jTFDomicilioElimClien.setBorder(null);
        jtpElimClien.add(jTFDomicilioElimClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 200, 30));

        jSElimClien4.setBackground(new java.awt.Color(0, 150, 136));
        jSElimClien4.setOpaque(true);
        jSElimClien4.setPreferredSize(new java.awt.Dimension(50, 2));
        jtpElimClien.add(jSElimClien4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 200, -1));

        jlIconEliCli1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconEliCli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/borrar-usuario.png"))); // NOI18N
        jtpElimClien.add(jlIconEliCli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 200, 150));

        jtpEscritorio.addTab("tab11", jtpElimClien);

        jtpListClien.setBackground(new java.awt.Color(255, 255, 255));
        jtpListClien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLTituloListaClien.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jLTituloListaClien.setForeground(new java.awt.Color(153, 153, 153));
        jLTituloListaClien.setText("Lista de clientes  ");
        jtpListClien.add(jLTituloListaClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        ScrollListClien.setBackground(new java.awt.Color(255, 255, 255));
        ScrollListClien.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        jtListClien.setBackground(new java.awt.Color(204, 204, 204));
        jtListClien.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtListClien.setModel(Modelo1 = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String[]{
                "ID", "Apellido", "Nombre", "Domicilio", "Telefono"
            }
        ) {
            public boolean isCellEditable(int fila, int column) {
                return false;
            }

            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jtListClien.setGridColor(new java.awt.Color(0, 102, 102));
        jtListClien.setMinimumSize(new java.awt.Dimension(60, 60));
        ScrollListClien.setViewportView(jtListClien);

        jtpListClien.add(ScrollListClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 120, 570, 290));

        jtfBuscadorClienListClien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtfBuscadorClienListClien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfBuscadorClienListClienKeyTyped(evt);
            }
        });
        jtpListClien.add(jtfBuscadorClienListClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 160, 30));

        jlImgBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        jlImgBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImgBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/busqueda - gris.png"))); // NOI18N
        jlImgBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlImgBusqueda.setOpaque(true);
        jlImgBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlImgBusquedaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlImgBusquedaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlImgBusquedaMouseExited(evt);
            }
        });
        jtpListClien.add(jlImgBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 40, 30));

        jlBusquedaCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlBusquedaCliente.setForeground(new java.awt.Color(153, 153, 153));
        jlBusquedaCliente.setText("Busqueda por Telefono");
        jlBusquedaCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jtpListClien.add(jlBusquedaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 30));

        jtpEscritorio.addTab("tab12", jtpListClien);

        jtpAgrVenta.setBackground(new java.awt.Color(255, 255, 255));
        jtpAgrVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlAgrVentas.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jlAgrVentas.setForeground(new java.awt.Color(153, 153, 153));
        jlAgrVentas.setText("Agregar Venta");
        jtpAgrVenta.add(jlAgrVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jlSelecProVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlSelecProVenta.setForeground(new java.awt.Color(153, 153, 153));
        jlSelecProVenta.setText("Seleccione el Producto en Venta");
        jtpAgrVenta.add(jlSelecProVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, -1));

        jcbProVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtpAgrVenta.add(jcbProVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, 30));

        jlCantidadVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlCantidadVenta.setForeground(new java.awt.Color(153, 153, 153));
        jlCantidadVenta.setText("Ingrese la cantidad");
        jtpAgrVenta.add(jlCantidadVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 140, -1));

        jtfCantidadVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtfCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadVentaKeyTyped(evt);
            }
        });
        jtpAgrVenta.add(jtfCantidadVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 130, 30));

        jlFechaVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlFechaVenta.setForeground(new java.awt.Color(153, 153, 153));
        jlFechaVenta.setText("Selecciones la Fecha de la Venta");
        jtpAgrVenta.add(jlFechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jlTelCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlTelCliente.setForeground(new java.awt.Color(153, 153, 153));
        jlTelCliente.setText("Ingrese el Telefono del Cliente");
        jtpAgrVenta.add(jlTelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jtfTelCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtfTelCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelClienteKeyTyped(evt);
            }
        });
        jtpAgrVenta.add(jtfTelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 200, 30));

        jlPrecioVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlPrecioVenta.setForeground(new java.awt.Color(153, 153, 153));
        jlPrecioVenta.setText("Precio Total de Venta");
        jtpAgrVenta.add(jlPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 140, 30));

        jtfPrecioVenta.setEditable(false);
        jtfPrecioVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtpAgrVenta.add(jtfPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 362, 160, 30));

        jlRealizarVenta.setBackground(new java.awt.Color(0, 150, 136));
        jlRealizarVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlRealizarVenta.setForeground(new java.awt.Color(255, 255, 255));
        jlRealizarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlRealizarVenta.setText("Realizar Venta");
        jlRealizarVenta.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlRealizarVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlRealizarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlRealizarVenta.setOpaque(true);
        jlRealizarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlRealizarVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlRealizarVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlRealizarVentaMouseExited(evt);
            }
        });
        jtpAgrVenta.add(jlRealizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 110, 30));

        jlNombreEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlNombreEmp.setForeground(new java.awt.Color(153, 153, 153));
        jlNombreEmp.setText("Ingrese el Nombre del Empleado");
        jtpAgrVenta.add(jlNombreEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jtfNombreEmpVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtfNombreEmpVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreEmpVentaKeyTyped(evt);
            }
        });
        jtpAgrVenta.add(jtfNombreEmpVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 200, 30));

        jlIconVentaAgr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconVentaAgr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/flecha-del-carrito-hacia-abajo.png"))); // NOI18N
        jtpAgrVenta.add(jlIconVentaAgr, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, -10, 210, 150));

        jdcAgrVenta.setEnabled(false);
        jtpAgrVenta.add(jdcAgrVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 200, 30));

        ScrollTablaVentas1.setBackground(new java.awt.Color(255, 255, 255));
        ScrollTablaVentas1.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        jtListaGuardVentas.setBackground(new java.awt.Color(204, 204, 204));
        jtListaGuardVentas.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtListaGuardVentas.setModel(Modelo5 = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Producto", "Nombre", "Descripción", "Cantidad", "Precio", "Subtotal"
            }
        ) {
            public boolean isCellEditable(int fila, int column) {
                return false;
            }

            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class,
                java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jtListaGuardVentas.setGridColor(new java.awt.Color(0, 102, 102));
        jtListaGuardVentas.setMinimumSize(new java.awt.Dimension(60, 60));
        ScrollTablaVentas1.setViewportView(jtListaGuardVentas);

        jtpAgrVenta.add(ScrollTablaVentas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 570, 150));

        jlEliminarProdTabla1.setBackground(new java.awt.Color(0, 150, 136));
        jlEliminarProdTabla1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlEliminarProdTabla1.setForeground(new java.awt.Color(255, 255, 255));
        jlEliminarProdTabla1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEliminarProdTabla1.setText("Eliminar");
        jlEliminarProdTabla1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlEliminarProdTabla1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlEliminarProdTabla1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlEliminarProdTabla1.setOpaque(true);
        jlEliminarProdTabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlEliminarProdTabla1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlEliminarProdTabla1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlEliminarProdTabla1MouseExited(evt);
            }
        });
        jtpAgrVenta.add(jlEliminarProdTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 80, 30));

        jLimpiarTablaAaVen.setBackground(new java.awt.Color(0, 150, 136));
        jLimpiarTablaAaVen.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLimpiarTablaAaVen.setForeground(new java.awt.Color(255, 255, 255));
        jLimpiarTablaAaVen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLimpiarTablaAaVen.setText("Limpiar");
        jLimpiarTablaAaVen.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLimpiarTablaAaVen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLimpiarTablaAaVen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLimpiarTablaAaVen.setOpaque(true);
        jLimpiarTablaAaVen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLimpiarTablaAaVenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLimpiarTablaAaVenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLimpiarTablaAaVenMouseExited(evt);
            }
        });
        jtpAgrVenta.add(jLimpiarTablaAaVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 80, 30));

        jlAgregarProdTabla.setBackground(new java.awt.Color(0, 150, 136));
        jlAgregarProdTabla.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlAgregarProdTabla.setForeground(new java.awt.Color(255, 255, 255));
        jlAgregarProdTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAgregarProdTabla.setText("Agregar");
        jlAgregarProdTabla.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlAgregarProdTabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlAgregarProdTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlAgregarProdTabla.setOpaque(true);
        jlAgregarProdTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAgregarProdTablaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlAgregarProdTablaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlAgregarProdTablaMouseExited(evt);
            }
        });
        jtpAgrVenta.add(jlAgregarProdTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 80, 30));

        jtpEscritorio.addTab("tab13", jtpAgrVenta);

        jtpListaVentas.setBackground(new java.awt.Color(255, 255, 255));
        jtpListaVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlListaVenta.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jlListaVenta.setForeground(new java.awt.Color(153, 153, 153));
        jlListaVenta.setText("Lista de Ventas");
        jtpListaVentas.add(jlListaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        ScrollTablaVentas.setBackground(new java.awt.Color(255, 255, 255));
        ScrollTablaVentas.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        jtListaVentas.setBackground(new java.awt.Color(204, 204, 204));
        jtListaVentas.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtListaVentas.setModel(Modelo4 = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Detalle", "ID Venta", "Producto", "Telefono Cliente", "Fecha de Venta", "Cantidad", "Precio Venta"
            }
        ){
            public boolean isCellEditable(int fila, int column) {
                return false;
            }

            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.time.LocalDate.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jtListaVentas.setGridColor(new java.awt.Color(0, 102, 102));
        jtListaVentas.setMinimumSize(new java.awt.Dimension(60, 60));
        ScrollTablaVentas.setViewportView(jtListaVentas);

        jtpListaVentas.add(ScrollTablaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 120, 570, 290));

        jlSelecFechaVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlSelecFechaVenta.setForeground(new java.awt.Color(153, 153, 153));
        jlSelecFechaVenta.setText("Seleccione la Fecha de la Venta");
        jlSelecFechaVenta.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jtpListaVentas.add(jlSelecFechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 30));
        jtpListaVentas.add(jdcBusquedaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 160, 30));

        jlIconBuscarVenta.setBackground(new java.awt.Color(255, 255, 255));
        jlIconBuscarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconBuscarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/busqueda - gris.png"))); // NOI18N
        jlIconBuscarVenta.setOpaque(true);
        jlIconBuscarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlIconBuscarVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlIconBuscarVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlIconBuscarVentaMouseExited(evt);
            }
        });
        jtpListaVentas.add(jlIconBuscarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 40, 30));

        jtpEscritorio.addTab("tab14", jtpListaVentas);

        jtpDetallesVenta.setBackground(new java.awt.Color(255, 255, 255));
        jtpDetallesVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlDetallesVenta.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
        jlDetallesVenta.setForeground(new java.awt.Color(153, 153, 153));
        jlDetallesVenta.setText("Detalles de Ventas");
        jtpDetallesVenta.add(jlDetallesVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        ScrollTablaDetalles.setBackground(new java.awt.Color(255, 255, 255));
        ScrollTablaDetalles.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        jtListaDetalles.setBackground(new java.awt.Color(204, 204, 204));
        jtListaDetalles.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jtListaDetalles.setModel(Modelo3 = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Detalle", "ID venta", "Producto", "Telefono Cliente", "Fecha de Venta", "Cantidad", "Precio Total"
            }
        ){
            public boolean isCellEditable(int fila, int column) {
                return false;
            }

            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.time.LocalDate.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        }
    );
    jtListaDetalles.setGridColor(new java.awt.Color(0, 102, 102));
    jtListaDetalles.setMinimumSize(new java.awt.Dimension(60, 60));
    ScrollTablaDetalles.setViewportView(jtListaDetalles);

    jtpDetallesVenta.add(ScrollTablaDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 170, 570, 240));

    jcbVentasXCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jcbVentasXCliente.setEnabled(false);
    jtpDetallesVenta.add(jcbVentasXCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 30));

    jlSelecPro.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlSelecPro.setForeground(new java.awt.Color(153, 153, 153));
    jlSelecPro.setText("Seleccione un Producto");
    jlSelecPro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jtpDetallesVenta.add(jlSelecPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 180, 30));

    jlSelecFecha.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlSelecFecha.setForeground(new java.awt.Color(153, 153, 153));
    jlSelecFecha.setText("Seleccione una fecha");
    jlSelecFecha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jtpDetallesVenta.add(jlSelecFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 180, 30));

    jlTelCliDetalles.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlTelCliDetalles.setForeground(new java.awt.Color(153, 153, 153));
    jlTelCliDetalles.setText("Seleccione un Cliente");
    jlTelCliDetalles.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jtpDetallesVenta.add(jlTelCliDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 180, 30));

    jSep2.setOrientation(javax.swing.SwingConstants.VERTICAL);
    jtpDetallesVenta.add(jSep2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 10, 100));

    jlIconBuscar2.setBackground(new java.awt.Color(255, 255, 255));
    jlIconBuscar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlIconBuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/busqueda - gris.png"))); // NOI18N
    jlIconBuscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlIconBuscar2.setEnabled(false);
    jlIconBuscar2.setOpaque(true);
    jlIconBuscar2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlIconBuscar2MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlIconBuscar2MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlIconBuscar2MouseExited(evt);
        }
    });
    jtpDetallesVenta.add(jlIconBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 40, 30));

    jlIconBuscar1.setBackground(new java.awt.Color(255, 255, 255));
    jlIconBuscar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlIconBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/busqueda - gris.png"))); // NOI18N
    jlIconBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlIconBuscar1.setEnabled(false);
    jlIconBuscar1.setOpaque(true);
    jlIconBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlIconBuscar1MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlIconBuscar1MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlIconBuscar1MouseExited(evt);
        }
    });
    jtpDetallesVenta.add(jlIconBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 40, 30));

    jlIconBuscar.setBackground(new java.awt.Color(255, 255, 255));
    jlIconBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlIconBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/busqueda - gris.png"))); // NOI18N
    jlIconBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlIconBuscar.setEnabled(false);
    jlIconBuscar.setOpaque(true);
    jlIconBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlIconBuscarMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlIconBuscarMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlIconBuscarMouseExited(evt);
        }
    });
    jtpDetallesVenta.add(jlIconBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 40, 30));

    jlClientesxPro.setBackground(new java.awt.Color(0, 150, 136));
    jlClientesxPro.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlClientesxPro.setForeground(new java.awt.Color(255, 255, 255));
    jlClientesxPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlClientesxPro.setText("Clientes por Productos");
    jlClientesxPro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlClientesxPro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), null, null));
    jlClientesxPro.setOpaque(true);
    jlClientesxPro.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlClientesxProMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlClientesxProMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlClientesxProMouseExited(evt);
        }
    });
    jtpDetallesVenta.add(jlClientesxPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 150, 30));

    jlVentasCli.setBackground(new java.awt.Color(0, 150, 136));
    jlVentasCli.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlVentasCli.setForeground(new java.awt.Color(255, 255, 255));
    jlVentasCli.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlVentasCli.setText("Ventas de Clientes");
    jlVentasCli.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlVentasCli.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), null, null));
    jlVentasCli.setOpaque(true);
    jlVentasCli.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlVentasCliMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlVentasCliMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlVentasCliMouseExited(evt);
        }
    });
    jtpDetallesVenta.add(jlVentasCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

    jSep1.setOrientation(javax.swing.SwingConstants.VERTICAL);
    jtpDetallesVenta.add(jSep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 10, 100));

    jdcFechaPro.setEnabled(false);
    jdcFechaPro.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jtpDetallesVenta.add(jdcFechaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 120, 30));

    jlProXFecha.setBackground(new java.awt.Color(0, 150, 136));
    jlProXFecha.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlProXFecha.setForeground(new java.awt.Color(255, 255, 255));
    jlProXFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlProXFecha.setText("Productos por Fecha");
    jlProXFecha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlProXFecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), null, null));
    jlProXFecha.setOpaque(true);
    jlProXFecha.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlProXFechaMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlProXFechaMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlProXFechaMouseExited(evt);
        }
    });
    jtpDetallesVenta.add(jlProXFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 140, 30));

    jcbProXCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jcbProXCliente.setEnabled(false);
    jtpDetallesVenta.add(jcbProXCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 120, 30));

    jtpEscritorio.addTab("tab15", jtpDetallesVenta);

    jtpEliminarVenta.setBackground(new java.awt.Color(255, 255, 255));
    jtpEliminarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jlBorrarVenta.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
    jlBorrarVenta.setForeground(new java.awt.Color(153, 153, 153));
    jlBorrarVenta.setText("Eliminar Venta");
    jtpEliminarVenta.add(jlBorrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

    jlBuscarVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlBuscarVenta.setForeground(new java.awt.Color(153, 153, 153));
    jlBuscarVenta.setText("Buscar venta");
    jtpEliminarVenta.add(jlBuscarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

    jcbBuscarVenta.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jcbBuscarVenta.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jcbBuscarVentaItemStateChanged(evt);
        }
    });
    jtpEliminarVenta.add(jcbBuscarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 280, 30));

    jlNombreProEliminar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlNombreProEliminar.setForeground(new java.awt.Color(153, 153, 153));
    jlNombreProEliminar.setText("Productos Vendidos");
    jtpEliminarVenta.add(jlNombreProEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

    jtfTelClienteEliminar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jtfTelClienteEliminar.setForeground(new java.awt.Color(153, 153, 153));
    jtfTelClienteEliminar.setText("Telefono cliente");
    jtpEliminarVenta.add(jtfTelClienteEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

    jtfTelCliEliminar.setEditable(false);
    jtfTelCliEliminar.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jtfTelCliEliminar.setBorder(null);
    jtfTelCliEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jtfTelCliEliminarKeyTyped(evt);
        }
    });
    jtpEliminarVenta.add(jtfTelCliEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 200, 30));

    jSElimProd6.setBackground(new java.awt.Color(0, 150, 136));
    jSElimProd6.setOpaque(true);
    jSElimProd6.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpEliminarVenta.add(jSElimProd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 200, -1));

    jtfNombreEmpleadoEliminar.setEditable(false);
    jtfNombreEmpleadoEliminar.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jtfNombreEmpleadoEliminar.setBorder(null);
    jtfNombreEmpleadoEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jtfNombreEmpleadoEliminarKeyTyped(evt);
        }
    });
    jtpEliminarVenta.add(jtfNombreEmpleadoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 200, 30));

    jSElimProd7.setBackground(new java.awt.Color(0, 150, 136));
    jSElimProd7.setOpaque(true);
    jSElimProd7.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpEliminarVenta.add(jSElimProd7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 200, -1));

    jlNombreEmpleadoEliminar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlNombreEmpleadoEliminar.setForeground(new java.awt.Color(153, 153, 153));
    jlNombreEmpleadoEliminar.setText("Nombre de empleado");
    jtpEliminarVenta.add(jlNombreEmpleadoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

    jlFechaVentaEliminar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlFechaVentaEliminar.setForeground(new java.awt.Color(153, 153, 153));
    jlFechaVentaEliminar.setText("Fecha de venta");
    jtpEliminarVenta.add(jlFechaVentaEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

    jlEliminarVentaBorrar.setBackground(new java.awt.Color(0, 150, 136));
    jlEliminarVentaBorrar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlEliminarVentaBorrar.setForeground(new java.awt.Color(255, 255, 255));
    jlEliminarVentaBorrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlEliminarVentaBorrar.setText("Eliminar");
    jlEliminarVentaBorrar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlEliminarVentaBorrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jlEliminarVentaBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlEliminarVentaBorrar.setOpaque(true);
    jlEliminarVentaBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlEliminarVentaBorrarMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlEliminarVentaBorrarMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlEliminarVentaBorrarMouseExited(evt);
        }
    });
    jtpEliminarVenta.add(jlEliminarVentaBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 100, 30));

    jlVentaIconEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlVentaIconEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/archivo-menos.png"))); // NOI18N
    jtpEliminarVenta.add(jlVentaIconEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 200, 150));

    jdcElimVenta.setEnabled(false);
    jtpEliminarVenta.add(jdcElimVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 200, 30));

    jListProductosElim.setModel(Mlist);
    jListProductosElim.setEnabled(false);
    jScrollPane1.setViewportView(jListProductosElim);

    jtpEliminarVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 280, 130));

    jtpEscritorio.addTab("tab16", jtpEliminarVenta);

    jPGestionEmpleados.setBackground(new java.awt.Color(255, 255, 255));
    jPGestionEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jlGestionEmpleado1.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
    jlGestionEmpleado1.setForeground(new java.awt.Color(153, 153, 153));
    jlGestionEmpleado1.setText("Gestion de Empleados");
    jPGestionEmpleados.add(jlGestionEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, 30));

    jlIconAgreEmpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlIconAgreEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/agregar_empleado.png"))); // NOI18N
    jPGestionEmpleados.add(jlIconAgreEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 150));

    jlAgregarEmpleado.setBackground(new java.awt.Color(0, 150, 136));
    jlAgregarEmpleado.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlAgregarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
    jlAgregarEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlAgregarEmpleado.setText("Agregar");
    jlAgregarEmpleado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlAgregarEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlAgregarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlAgregarEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlAgregarEmpleado.setOpaque(true);
    jlAgregarEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlAgregarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlAgregarEmpleadoMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlAgregarEmpleadoMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlAgregarEmpleadoMouseExited(evt);
        }
    });
    jPGestionEmpleados.add(jlAgregarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 80, 30));

    jlAgregarEmpl.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    jlAgregarEmpl.setForeground(new java.awt.Color(102, 102, 102));
    jlAgregarEmpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlAgregarEmpl.setText("Agregar ");
    jPGestionEmpleados.add(jlAgregarEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

    textEmpleadoA.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
    textEmpleadoA.setForeground(new java.awt.Color(153, 153, 153));
    textEmpleadoA.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jPGestionEmpleados.add(textEmpleadoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 90));

    rectanguloAgEmpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    rectanguloAgEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
    jPGestionEmpleados.add(rectanguloAgEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

    textEmpleadoM.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
    textEmpleadoM.setForeground(new java.awt.Color(153, 153, 153));
    textEmpleadoM.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jPGestionEmpleados.add(textEmpleadoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 150, 90));

    jlModificarEmpleado.setBackground(new java.awt.Color(0, 150, 136));
    jlModificarEmpleado.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlModificarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
    jlModificarEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlModificarEmpleado.setText("Modificar");
    jlModificarEmpleado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlModificarEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlModificarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlModificarEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlModificarEmpleado.setOpaque(true);
    jlModificarEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlModificarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlModificarEmpleadoMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlModificarEmpleadoMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlModificarEmpleadoMouseExited(evt);
        }
    });
    jPGestionEmpleados.add(jlModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 80, 30));

    jlModEmpl.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    jlModEmpl.setForeground(new java.awt.Color(102, 102, 102));
    jlModEmpl.setText("Modificar ");
    jPGestionEmpleados.add(jlModEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 80, -1));

    jlIconModEmpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlIconModEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/editar_empleado.png"))); // NOI18N
    jPGestionEmpleados.add(jlIconModEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 180, 150));

    rectanguloModifEmpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    rectanguloModifEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
    jPGestionEmpleados.add(rectanguloModifEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

    jlEliminarEmp.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    jlEliminarEmp.setForeground(new java.awt.Color(102, 102, 102));
    jlEliminarEmp.setText("Eliminar ");
    jPGestionEmpleados.add(jlEliminarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

    textEmpleadoElim.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
    textEmpleadoElim.setForeground(new java.awt.Color(153, 153, 153));
    textEmpleadoElim.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jPGestionEmpleados.add(textEmpleadoElim, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 150, 90));

    jlEliminarEmpleado.setBackground(new java.awt.Color(0, 150, 136));
    jlEliminarEmpleado.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlEliminarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
    jlEliminarEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlEliminarEmpleado.setText("Eliminar");
    jlEliminarEmpleado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlEliminarEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlEliminarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlEliminarEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlEliminarEmpleado.setOpaque(true);
    jlEliminarEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlEliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlEliminarEmpleadoMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlEliminarEmpleadoMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlEliminarEmpleadoMouseExited(evt);
        }
    });
    jPGestionEmpleados.add(jlEliminarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 80, 30));

    jlIconEliEmpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlIconEliEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/borrar_empleado.png"))); // NOI18N
    jPGestionEmpleados.add(jlIconEliEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 180, 150));

    jlListarEmpleado.setBackground(new java.awt.Color(0, 150, 136));
    jlListarEmpleado.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlListarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
    jlListarEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlListarEmpleado.setText("Listar Empleados");
    jlListarEmpleado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlListarEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlListarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlListarEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlListarEmpleado.setOpaque(true);
    jlListarEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlListarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlListarEmpleadoMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlListarEmpleadoMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlListarEmpleadoMouseExited(evt);
        }
    });
    jPGestionEmpleados.add(jlListarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 120, 30));

    rectanguloElimEmpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    rectanguloElimEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rectangulo.jpg"))); // NOI18N
    jPGestionEmpleados.add(rectanguloElimEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

    jtpEscritorio.addTab("tab17", jPGestionEmpleados);

    jtpModificarEmpleado.setBackground(new java.awt.Color(255, 255, 255));
    jtpModificarEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLTituloModEmpl.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
    jLTituloModEmpl.setForeground(new java.awt.Color(153, 153, 153));
    jLTituloModEmpl.setText("Modificar Empleado");
    jtpModificarEmpleado.add(jLTituloModEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

    jLBuscarEmpleadoModEmpl.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLBuscarEmpleadoModEmpl.setForeground(new java.awt.Color(153, 153, 153));
    jLBuscarEmpleadoModEmpl.setText("Buscar Empleado");
    jtpModificarEmpleado.add(jLBuscarEmpleadoModEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

    jCBModificarEmpleado.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jCBModificarEmpleado.setForeground(new java.awt.Color(0, 102, 102));
    jCBModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCBModificarEmpleadoActionPerformed(evt);
        }
    });
    jtpModificarEmpleado.add(jCBModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 290, 30));

    jLNombreEmpModEmp1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLNombreEmpModEmp1.setForeground(new java.awt.Color(153, 153, 153));
    jLNombreEmpModEmp1.setText("Nombre empleado");
    jtpModificarEmpleado.add(jLNombreEmpModEmp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

    jSModEmpl5.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmpl5.setOpaque(true);
    jSModEmpl5.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpModificarEmpleado.add(jSModEmpl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, -1));

    jTFNombreEmpleadoModEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFNombreEmpleadoModEmp.setBorder(null);
    jTFNombreEmpleadoModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTFNombreEmpleadoModEmpKeyTyped(evt);
        }
    });
    jtpModificarEmpleado.add(jTFNombreEmpleadoModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 200, 30));

    jLDniModEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLDniModEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLDniModEmp.setText("DNI");
    jtpModificarEmpleado.add(jLDniModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

    jTFDniModEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFDniModEmp.setBorder(null);
    jTFDniModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTFDniModEmpKeyTyped(evt);
        }
    });
    jtpModificarEmpleado.add(jTFDniModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 200, 30));

    jSModEmp7.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmp7.setOpaque(true);
    jSModEmp7.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpModificarEmpleado.add(jSModEmp7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 200, -1));

    jLUsuarioModEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLUsuarioModEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLUsuarioModEmp.setText("Usuario");
    jtpModificarEmpleado.add(jLUsuarioModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

    jSModEmp9.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmp9.setOpaque(true);
    jSModEmp9.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpModificarEmpleado.add(jSModEmp9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 200, -1));

    jTFUsuarioModEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFUsuarioModEmp.setBorder(null);
    jtpModificarEmpleado.add(jTFUsuarioModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 200, 30));

    jLBtnModificarModEmp.setBackground(new java.awt.Color(0, 150, 136));
    jLBtnModificarModEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLBtnModificarModEmp.setForeground(new java.awt.Color(255, 255, 255));
    jLBtnModificarModEmp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLBtnModificarModEmp.setText("Modificar");
    jLBtnModificarModEmp.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jLBtnModificarModEmp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jLBtnModificarModEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jLBtnModificarModEmp.setOpaque(true);
    jLBtnModificarModEmp.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLBtnModificarModEmpMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLBtnModificarModEmpMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLBtnModificarModEmpMouseExited(evt);
        }
    });
    jtpModificarEmpleado.add(jLBtnModificarModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 100, 30));

    jSModEmp.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmp.setOpaque(true);
    jSModEmp.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpModificarEmpleado.add(jSModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 200, -1));

    jTFContraseñaModEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFContraseñaModEmp.setBorder(null);
    jtpModificarEmpleado.add(jTFContraseñaModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 200, 30));

    jLContraseñaModEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLContraseñaModEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLContraseñaModEmp.setText("Contraseña");
    jtpModificarEmpleado.add(jLContraseñaModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

    jtpModificarEmpleado.add(jCBCargoModifEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 200, 30));

    jLCargoModEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLCargoModEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLCargoModEmp.setText("Cargo");
    jtpModificarEmpleado.add(jLCargoModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

    jSModEmp6.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmp6.setOpaque(true);
    jSModEmp6.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpModificarEmpleado.add(jSModEmp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 200, -1));

    jTFApellidoModEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFApellidoModEmp.setBorder(null);
    jTFApellidoModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTFApellidoModEmpKeyTyped(evt);
        }
    });
    jtpModificarEmpleado.add(jTFApellidoModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 200, 30));

    jLApellidoModEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLApellidoModEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLApellidoModEmp.setText("Apellido empleado");
    jtpModificarEmpleado.add(jLApellidoModEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

    jtpEscritorio.addTab("tab18", jtpModificarEmpleado);

    jtpEliminarEmpleado.setBackground(new java.awt.Color(255, 255, 255));
    jtpEliminarEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLTituloElimEmpleado.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
    jLTituloElimEmpleado.setForeground(new java.awt.Color(153, 153, 153));
    jLTituloElimEmpleado.setText("Eliminar Empleado");
    jtpEliminarEmpleado.add(jLTituloElimEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

    jLEliminarEmpleado.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLEliminarEmpleado.setForeground(new java.awt.Color(153, 153, 153));
    jLEliminarEmpleado.setText("Buscar Empleado");
    jtpEliminarEmpleado.add(jLEliminarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

    jCBEliminarEmpleado.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jCBEliminarEmpleado.setForeground(new java.awt.Color(0, 102, 102));
    jCBEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCBEliminarEmpleadoActionPerformed(evt);
        }
    });
    jtpEliminarEmpleado.add(jCBEliminarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 290, 30));

    jLNombreEmpElimEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLNombreEmpElimEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLNombreEmpElimEmp.setText("Nombre empleado");
    jtpEliminarEmpleado.add(jLNombreEmpElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

    jTFNombreEmpleadoElimEmp.setEditable(false);
    jTFNombreEmpleadoElimEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFNombreEmpleadoElimEmp.setBorder(null);
    jTFNombreEmpleadoElimEmp.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTFNombreEmpleadoElimEmpKeyTyped(evt);
        }
    });
    jtpEliminarEmpleado.add(jTFNombreEmpleadoElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 200, 30));

    jSModEmpl6.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmpl6.setOpaque(true);
    jSModEmpl6.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpEliminarEmpleado.add(jSModEmpl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, -1));

    jLDniElimEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLDniElimEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLDniElimEmp.setText("DNI");
    jtpEliminarEmpleado.add(jLDniElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

    jTFDniElimEmp.setEditable(false);
    jTFDniElimEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFDniElimEmp.setBorder(null);
    jTFDniElimEmp.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTFDniElimEmpKeyTyped(evt);
        }
    });
    jtpEliminarEmpleado.add(jTFDniElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 200, 30));

    jSModEmp8.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmp8.setOpaque(true);
    jSModEmp8.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpEliminarEmpleado.add(jSModEmp8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 200, -1));

    jLUsuarioElimEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLUsuarioElimEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLUsuarioElimEmp.setText("Usuario");
    jtpEliminarEmpleado.add(jLUsuarioElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

    jTFUsuarioElimEmp.setEditable(false);
    jTFUsuarioElimEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFUsuarioElimEmp.setBorder(null);
    jtpEliminarEmpleado.add(jTFUsuarioElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 200, 30));

    jSModEmp10.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmp10.setOpaque(true);
    jSModEmp10.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpEliminarEmpleado.add(jSModEmp10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 200, -1));

    jLContraseñaElimEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLContraseñaElimEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLContraseñaElimEmp.setText("Contraseña");
    jtpEliminarEmpleado.add(jLContraseñaElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

    jTFContraseñaElimEmp.setEditable(false);
    jTFContraseñaElimEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFContraseñaElimEmp.setBorder(null);
    jtpEliminarEmpleado.add(jTFContraseñaElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 200, 30));

    jSModEmp1.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmp1.setOpaque(true);
    jSModEmp1.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpEliminarEmpleado.add(jSModEmp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 200, -1));

    jLCargoElimEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLCargoElimEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLCargoElimEmp.setText("Cargo");
    jtpEliminarEmpleado.add(jLCargoElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

    jCBCargoElimEmp.setEnabled(false);
    jtpEliminarEmpleado.add(jCBCargoElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 200, 30));

    jLApellidoElimEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLApellidoElimEmp.setForeground(new java.awt.Color(153, 153, 153));
    jLApellidoElimEmp.setText("Apellido empleado");
    jtpEliminarEmpleado.add(jLApellidoElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

    jTFApellidoElimEmp.setEditable(false);
    jTFApellidoElimEmp.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    jTFApellidoElimEmp.setBorder(null);
    jTFApellidoElimEmp.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTFApellidoElimEmpKeyTyped(evt);
        }
    });
    jtpEliminarEmpleado.add(jTFApellidoElimEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 200, 30));

    jSModEmp11.setBackground(new java.awt.Color(0, 150, 136));
    jSModEmp11.setOpaque(true);
    jSModEmp11.setPreferredSize(new java.awt.Dimension(50, 2));
    jtpEliminarEmpleado.add(jSModEmp11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 200, -1));

    jLBtnEliminarEmpleado.setBackground(new java.awt.Color(0, 150, 136));
    jLBtnEliminarEmpleado.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jLBtnEliminarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
    jLBtnEliminarEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLBtnEliminarEmpleado.setText("Eliminar");
    jLBtnEliminarEmpleado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jLBtnEliminarEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jLBtnEliminarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jLBtnEliminarEmpleado.setOpaque(true);
    jLBtnEliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLBtnEliminarEmpleadoMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLBtnEliminarEmpleadoMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLBtnEliminarEmpleadoMouseExited(evt);
        }
    });
    jtpEliminarEmpleado.add(jLBtnEliminarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 100, 30));

    jtpEscritorio.addTab("tab19", jtpEliminarEmpleado);

    jtpListaEmp.setBackground(new java.awt.Color(255, 255, 255));
    jtpListaEmp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLTituloListaEmpleados.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
    jLTituloListaEmpleados.setForeground(new java.awt.Color(153, 153, 153));
    jLTituloListaEmpleados.setText("Lista de Empleados  ");
    jtpListaEmp.add(jLTituloListaEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

    jlImgBusquedaEmpl.setBackground(new java.awt.Color(255, 255, 255));
    jlImgBusquedaEmpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlImgBusquedaEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/busqueda - gris.png"))); // NOI18N
    jlImgBusquedaEmpl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlImgBusquedaEmpl.setOpaque(true);
    jlImgBusquedaEmpl.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlImgBusquedaEmplMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlImgBusquedaEmplMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlImgBusquedaEmplMouseExited(evt);
        }
    });
    jtpListaEmp.add(jlImgBusquedaEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 40, 30));

    jtfBuscadorEmpleadosListEmp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    jtfBuscadorEmpleadosListEmp.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jtfBuscadorEmpleadosListEmpKeyTyped(evt);
        }
    });
    jtpListaEmp.add(jtfBuscadorEmpleadosListEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 160, 30));

    ScrollListClien1.setBackground(new java.awt.Color(255, 255, 255));
    ScrollListClien1.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

    jtListEmpleado.setBackground(new java.awt.Color(204, 204, 204));
    jtListEmpleado.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jtListEmpleado.setModel(Modelo2 = new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String[]{
            "ID", "Apellido", "Nombre", "DNI", "Cargo", "Usuario", "Contraseña"
        }
    ) {
        public boolean isCellEditable(int fila, int column) {
            return false;
        }

        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class
        };

        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    });
    jtListEmpleado.setGridColor(new java.awt.Color(0, 102, 102));
    jtListEmpleado.setMinimumSize(new java.awt.Dimension(60, 60));
    ScrollListClien1.setViewportView(jtListEmpleado);

    jtpListaEmp.add(ScrollListClien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 120, 570, 290));

    jlBusquedaEmp.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlBusquedaEmp.setForeground(new java.awt.Color(153, 153, 153));
    jlBusquedaEmp.setText("Busqueda por Apellido");
    jlBusquedaEmp.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jtpListaEmp.add(jlBusquedaEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 30));

    jtpEscritorio.addTab("tab20", jtpListaEmp);

    jtpPapelera.setBackground(new java.awt.Color(255, 255, 255));
    jtpPapelera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jlVentaPapelera.setBackground(new java.awt.Color(0, 150, 136));
    jlVentaPapelera.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlVentaPapelera.setForeground(new java.awt.Color(255, 255, 255));
    jlVentaPapelera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlVentaPapelera.setText("Venta");
    jlVentaPapelera.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlVentaPapelera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlVentaPapelera.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlVentaPapelera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlVentaPapelera.setOpaque(true);
    jlVentaPapelera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlVentaPapelera.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlVentaPapeleraMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlVentaPapeleraMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlVentaPapeleraMouseExited(evt);
        }
    });
    jtpPapelera.add(jlVentaPapelera, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 80, 30));

    jlCliente.setBackground(new java.awt.Color(0, 150, 136));
    jlCliente.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlCliente.setForeground(new java.awt.Color(255, 255, 255));
    jlCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlCliente.setText("Cliente");
    jlCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlCliente.setOpaque(true);
    jlCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlCliente.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlClienteMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlClienteMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlClienteMouseExited(evt);
        }
    });
    jtpPapelera.add(jlCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 80, 30));

    jlProductoPapelera.setBackground(new java.awt.Color(0, 150, 136));
    jlProductoPapelera.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlProductoPapelera.setForeground(new java.awt.Color(255, 255, 255));
    jlProductoPapelera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlProductoPapelera.setText("Producto");
    jlProductoPapelera.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlProductoPapelera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlProductoPapelera.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlProductoPapelera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlProductoPapelera.setOpaque(true);
    jlProductoPapelera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlProductoPapelera.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlProductoPapeleraMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlProductoPapeleraMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlProductoPapeleraMouseExited(evt);
        }
    });
    jtpPapelera.add(jlProductoPapelera, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 80, 30));

    jlEmpleadoPapelera.setBackground(new java.awt.Color(0, 150, 136));
    jlEmpleadoPapelera.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlEmpleadoPapelera.setForeground(new java.awt.Color(255, 255, 255));
    jlEmpleadoPapelera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlEmpleadoPapelera.setText("Empleado");
    jlEmpleadoPapelera.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlEmpleadoPapelera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlEmpleadoPapelera.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlEmpleadoPapelera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlEmpleadoPapelera.setOpaque(true);
    jlEmpleadoPapelera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlEmpleadoPapelera.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlEmpleadoPapeleraMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlEmpleadoPapeleraMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlEmpleadoPapeleraMouseExited(evt);
        }
    });
    jtpPapelera.add(jlEmpleadoPapelera, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 80, 30));

    jlEliminarPapelera.setBackground(new java.awt.Color(0, 150, 136));
    jlEliminarPapelera.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlEliminarPapelera.setForeground(new java.awt.Color(255, 255, 255));
    jlEliminarPapelera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlEliminarPapelera.setText("Eliminar");
    jlEliminarPapelera.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlEliminarPapelera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlEliminarPapelera.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlEliminarPapelera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlEliminarPapelera.setOpaque(true);
    jlEliminarPapelera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlEliminarPapelera.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlEliminarPapeleraMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlEliminarPapeleraMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlEliminarPapeleraMouseExited(evt);
        }
    });
    jtpPapelera.add(jlEliminarPapelera, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 80, 30));

    jlRestaurarPapelera.setBackground(new java.awt.Color(0, 150, 136));
    jlRestaurarPapelera.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
    jlRestaurarPapelera.setForeground(new java.awt.Color(255, 255, 255));
    jlRestaurarPapelera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlRestaurarPapelera.setText("Restaurar");
    jlRestaurarPapelera.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jlRestaurarPapelera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 150, 136), null, null));
    jlRestaurarPapelera.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jlRestaurarPapelera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jlRestaurarPapelera.setOpaque(true);
    jlRestaurarPapelera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jlRestaurarPapelera.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlRestaurarPapeleraMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jlRestaurarPapeleraMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jlRestaurarPapeleraMouseExited(evt);
        }
    });
    jtpPapelera.add(jlRestaurarPapelera, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 80, 30));

    jTablePapelera.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {},
            {},
            {},
            {}
        },
        new String [] {

        }
    ));
    jScrollPanePapelera.setViewportView(jTablePapelera);

    jtpPapelera.add(jScrollPanePapelera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 560, 200));

    jlPapelera.setFont(new java.awt.Font("Corbel", 1, 30)); // NOI18N
    jlPapelera.setForeground(new java.awt.Color(153, 153, 153));
    jlPapelera.setText("Papelera");
    jtpPapelera.add(jlPapelera, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

    jtpEscritorio.addTab("tab21", jtpPapelera);

    BackGround.add(jtpEscritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 43, 600, 460));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentasMouseEntered
        jlVentas.setBackground(grisClaro);
    }//GEN-LAST:event_jlVentasMouseEntered

    private void jlVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentasMouseExited
        jlVentas.setBackground(grisBase);
    }//GEN-LAST:event_jlVentasMouseExited

    private void jlClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClientesMouseEntered
        jlClientes.setBackground(grisClaro);
    }//GEN-LAST:event_jlClientesMouseEntered

    private void jlClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClientesMouseExited
        jlClientes.setBackground(grisBase);
    }//GEN-LAST:event_jlClientesMouseExited

    private void jlCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarSesionMouseEntered
        jlCerrarSesion.setBackground(grisClaro);
    }//GEN-LAST:event_jlCerrarSesionMouseEntered

    private void jlCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarSesionMouseExited
        jlCerrarSesion.setBackground(grisBase);
    }//GEN-LAST:event_jlCerrarSesionMouseExited

    private void jlVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentasMouseClicked
        jtpEscritorio.setSelectedIndex(1);
    }//GEN-LAST:event_jlVentasMouseClicked

    private void jlClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClientesMouseClicked
        jtpEscritorio.setSelectedIndex(2);
    }//GEN-LAST:event_jlClientesMouseClicked

    private void jlInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlInicioMouseEntered
        jlInicio.setBackground(grisClaro);
    }//GEN-LAST:event_jlInicioMouseEntered

    private void jlInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlInicioMouseExited
        jlInicio.setBackground(grisBase);
    }//GEN-LAST:event_jlInicioMouseExited

    private void jlInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlInicioMouseClicked
        jtpEscritorio.setSelectedIndex(0);
    }//GEN-LAST:event_jlInicioMouseClicked

    private void verMasPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMasPMouseEntered
        verMasP.setBackground(verdeClaro);
    }//GEN-LAST:event_verMasPMouseEntered

    private void verMasPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMasPMouseExited
        verMasP.setBackground(verdeBase);
    }//GEN-LAST:event_verMasPMouseExited

    private void verMasVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMasVMouseEntered
        verMasV.setBackground(verdeClaro);
    }//GEN-LAST:event_verMasVMouseEntered

    private void verMasVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMasVMouseExited
        verMasV.setBackground(verdeBase);
    }//GEN-LAST:event_verMasVMouseExited

    private void verMasCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMasCMouseEntered
        verMasC.setBackground(verdeClaro);
    }//GEN-LAST:event_verMasCMouseEntered

    private void verMasCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMasCMouseExited
        verMasC.setBackground(verdeBase);
    }//GEN-LAST:event_verMasCMouseExited

    private void verMasPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMasPMouseClicked
        jlProductosMouseClicked(evt);
    }//GEN-LAST:event_verMasPMouseClicked

    private void verMasVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMasVMouseClicked
        jlVentasMouseClicked(evt);
    }//GEN-LAST:event_verMasVMouseClicked

    private void verMasCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMasCMouseClicked
        jlClientesMouseClicked(evt);
    }//GEN-LAST:event_verMasCMouseClicked

    private void jlAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarMouseEntered
        jlAgregar.setBackground(verdeClaro);
    }//GEN-LAST:event_jlAgregarMouseEntered

    private void jlAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarMouseExited
        jlAgregar.setBackground(verdeBase);
    }//GEN-LAST:event_jlAgregarMouseExited

    private void jlModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarMouseEntered
        jlModificar.setBackground(verdeClaro);
    }//GEN-LAST:event_jlModificarMouseEntered

    private void jlModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarMouseExited
        jlModificar.setBackground(verdeBase);
    }//GEN-LAST:event_jlModificarMouseExited

    private void jlListarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarMouseEntered
        jlListar.setBackground(verdeClaro);
    }//GEN-LAST:event_jlListarMouseEntered

    private void jlListarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarMouseExited
        jlListar.setBackground(verdeBase);
    }//GEN-LAST:event_jlListarMouseExited

    private void jlCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarSesionMouseClicked
        Login log = new Login();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_jlCerrarSesionMouseClicked

    private void jlListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarMouseClicked
        jtpEscritorio.setSelectedIndex(4);
        llenarTabla();
    }//GEN-LAST:event_jlListarMouseClicked

    private void jlListarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarClienteMouseClicked
        jtpEscritorio.setSelectedIndex(11);
        llenarTablaCli();
    }//GEN-LAST:event_jlListarClienteMouseClicked

    private void jlListarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarClienteMouseEntered
        jlListarCliente.setBackground(verdeClaro);
    }//GEN-LAST:event_jlListarClienteMouseEntered

    private void jlListarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarClienteMouseExited
        jlListarCliente.setBackground(verdeBase);
    }//GEN-LAST:event_jlListarClienteMouseExited

    private void jlAgregarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarClienteMouseEntered
        jlAgregarCliente.setBackground(verdeClaro);
    }//GEN-LAST:event_jlAgregarClienteMouseEntered

    private void jlAgregarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarClienteMouseExited
        jlAgregarCliente.setBackground(verdeBase);
    }//GEN-LAST:event_jlAgregarClienteMouseExited

    private void jlModificarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarClienteMouseEntered
        jlModificarCliente.setBackground(verdeClaro);
    }//GEN-LAST:event_jlModificarClienteMouseEntered

    private void jlModificarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarClienteMouseExited
        jlModificarCliente.setBackground(verdeBase);
    }//GEN-LAST:event_jlModificarClienteMouseExited

    private void jlEliminarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarClienteMouseEntered
        jlEliminarCliente.setBackground(verdeClaro);
    }//GEN-LAST:event_jlEliminarClienteMouseEntered

    private void jlEliminarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarClienteMouseExited
        jlEliminarCliente.setBackground(verdeBase);
    }//GEN-LAST:event_jlEliminarClienteMouseExited

    private void RegistrarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarVentaMouseClicked
        try {
            jtpEscritorio.setSelectedIndex(12);
            LocalDate hoy = LocalDate.now();
            jdcAgrVenta.setDate(Date.valueOf(hoy));
            llenarCombo();
            borrarFilaAPV();
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }//GEN-LAST:event_RegistrarVentaMouseClicked

    private void RegistrarVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarVentaMouseEntered
        RegistrarVenta.setBackground(verdeClaro);
    }//GEN-LAST:event_RegistrarVentaMouseEntered

    private void RegistrarVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarVentaMouseExited
        RegistrarVenta.setBackground(verdeBase);
    }//GEN-LAST:event_RegistrarVentaMouseExited

    private void DetVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetVentaMouseClicked
        jtpEscritorio.setSelectedIndex(14);
        llenarComboCliente();
        llenarCombo();
    }//GEN-LAST:event_DetVentaMouseClicked

    private void DetVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetVentaMouseEntered
        DetVenta.setBackground(verdeClaro);
    }//GEN-LAST:event_DetVentaMouseEntered

    private void DetVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetVentaMouseExited
        DetVenta.setBackground(verdeBase);
    }//GEN-LAST:event_DetVentaMouseExited

    private void EliminarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarVentaMouseClicked
        jtpEscritorio.setSelectedIndex(15);
        llenarComboV();
    }//GEN-LAST:event_EliminarVentaMouseClicked

    private void EliminarVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarVentaMouseEntered
        EliminarVenta.setBackground(verdeClaro);
    }//GEN-LAST:event_EliminarVentaMouseEntered

    private void EliminarVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarVentaMouseExited
        EliminarVenta.setBackground(verdeBase);
    }//GEN-LAST:event_EliminarVentaMouseExited

    private void jlProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductosMouseExited
        jlProductos.setBackground(grisBase);
    }//GEN-LAST:event_jlProductosMouseExited

    private void jlProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductosMouseEntered
        jlProductos.setBackground(grisClaro);
    }//GEN-LAST:event_jlProductosMouseEntered

    private void jlProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductosMouseClicked
        jtpEscritorio.setSelectedIndex(3);
    }//GEN-LAST:event_jlProductosMouseClicked

    private void jlListarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarVentaMouseClicked
        jtpEscritorio.setSelectedIndex(13);
        llenarTablaVen();
    }//GEN-LAST:event_jlListarVentaMouseClicked

    private void jlListarVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarVentaMouseEntered
        jlListarVenta.setBackground(verdeClaro);
    }//GEN-LAST:event_jlListarVentaMouseEntered

    private void jlListarVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarVentaMouseExited
        jlListarVenta.setBackground(verdeBase);
    }//GEN-LAST:event_jlListarVentaMouseExited

    private void jlBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlBusquedaMouseEntered
        jlBusqueda.setBackground(verdeClaro);
        jlBusqueda.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - blanco.png")));
    }//GEN-LAST:event_jlBusquedaMouseEntered

    private void jlBusquedaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlBusquedaMouseExited
        jlBusqueda.setBackground(Color.white);
        jlBusqueda.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - gris.png")));
    }//GEN-LAST:event_jlBusquedaMouseExited

    private void jlBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlBusquedaMouseClicked
        borrarFila();
        for (Producto pro : pd.listarProducto()) {
            if (pro.getNombreProducto().toLowerCase().contains(jtfBuscador.getText()) || pro.getNombreProducto().toUpperCase().contains(jtfBuscador.getText())) {
                Modelo.addRow(new Object[]{
                    pro.getIdProducto(),
                    pro.getNombreProducto(),
                    pro.getDescripcion(),
                    pro.getPrecioActual(),
                    pro.getStock()
                });
            }
        }
    }//GEN-LAST:event_jlBusquedaMouseClicked

    private void jlAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarMouseClicked
        jtpEscritorio.setSelectedIndex(5);
    }//GEN-LAST:event_jlAgregarMouseClicked

    private void jLBtnAgregarProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnAgregarProdMouseEntered
        jLBtnAgregarProd.setBackground(verdeClaro);
    }//GEN-LAST:event_jLBtnAgregarProdMouseEntered

    private void jLBtnAgregarProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnAgregarProdMouseExited
        jLBtnAgregarProd.setBackground(verdeBase);
    }//GEN-LAST:event_jLBtnAgregarProdMouseExited

    private void jlModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarMouseClicked
        jtpEscritorio.setSelectedIndex(7);
        llenarCombo();
    }//GEN-LAST:event_jlModificarMouseClicked

    private void jLBtnModificarModProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnModificarModProdMouseEntered
        jLBtnModificarModProd.setBackground(verdeClaro);
    }//GEN-LAST:event_jLBtnModificarModProdMouseEntered

    private void jLBtnModificarModProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnModificarModProdMouseExited
        jLBtnModificarModProd.setBackground(verdeBase);
    }//GEN-LAST:event_jLBtnModificarModProdMouseExited

    private void jLBtnEliminarElimProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnEliminarElimProdMouseEntered
        jLBtnEliminarElimProd.setBackground(verdeClaro);
    }//GEN-LAST:event_jLBtnEliminarElimProdMouseEntered

    private void jLBtnEliminarElimProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnEliminarElimProdMouseExited
        jLBtnEliminarElimProd.setBackground(verdeBase);
    }//GEN-LAST:event_jLBtnEliminarElimProdMouseExited

    private void jLBtnModificarModClienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnModificarModClienMouseEntered
        jLBtnModificarModClien.setBackground(verdeClaro);
    }//GEN-LAST:event_jLBtnModificarModClienMouseEntered

    private void jLBtnModificarModClienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnModificarModClienMouseExited
        jLBtnModificarModClien.setBackground(verdeBase);
    }//GEN-LAST:event_jLBtnModificarModClienMouseExited

    private void jLBtnEliminarElimClienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnEliminarElimClienMouseEntered
        jLBtnEliminarElimClien.setBackground(verdeClaro);
    }//GEN-LAST:event_jLBtnEliminarElimClienMouseEntered

    private void jLBtnEliminarElimClienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnEliminarElimClienMouseExited
        jLBtnEliminarElimClien.setBackground(verdeBase);
    }//GEN-LAST:event_jLBtnEliminarElimClienMouseExited

    private void jlImgBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImgBusquedaMouseClicked
        borrarFilaC();
        String tel = jtfBuscadorClienListClien.getText().toUpperCase();
        for (Cliente cli : cD.listarClientes()) {
            if (cli.getTelefono().trim().toUpperCase().contains(tel)) {
                Modelo1.addRow(new Object[]{cli.getIdCliente(), cli.getApellido(), cli.getNombre(), cli.getDomicilio(), cli.getTelefono()});
            }
        }
    }//GEN-LAST:event_jlImgBusquedaMouseClicked

    private void jlImgBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImgBusquedaMouseEntered
        jlImgBusqueda.setBackground(verdeClaro);
        jlImgBusqueda.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - blanco.png")));
    }//GEN-LAST:event_jlImgBusquedaMouseEntered

    private void jlImgBusquedaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImgBusquedaMouseExited
        jlImgBusqueda.setBackground(Color.white);
        jlImgBusqueda.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - gris.png")));
    }//GEN-LAST:event_jlImgBusquedaMouseExited

    private void jlCabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCabeceraMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jlCabeceraMousePressed

    private void jlCabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCabeceraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jlCabeceraMouseDragged

    private void jlSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMouseEntered
        jlSalir.setOpaque(true);
        jlSalir.setBackground(Color.red);
    }//GEN-LAST:event_jlSalirMouseEntered

    private void jlSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMouseExited
        jlSalir.setOpaque(false);
        jlSalir.setBackground(verdeBase);
    }//GEN-LAST:event_jlSalirMouseExited

    private void jlMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimizarMouseEntered
        jlMinimizar.setOpaque(true);
        jlMinimizar.setBackground(verdeClaro);
    }//GEN-LAST:event_jlMinimizarMouseEntered

    private void jlMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimizarMouseExited
        jlMinimizar.setOpaque(false);
        jlMinimizar.setBackground(verdeBase);
    }//GEN-LAST:event_jlMinimizarMouseExited

    private void jlSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jlSalirMouseClicked

    private void jlMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimizarMouseClicked
        this.setExtendedState(1);
    }//GEN-LAST:event_jlMinimizarMouseClicked

    private void jlRealizarVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRealizarVentaMouseEntered
        jlRealizarVenta.setBackground(verdeClaro);
    }//GEN-LAST:event_jlRealizarVentaMouseEntered

    private void jlRealizarVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRealizarVentaMouseExited
        jlRealizarVenta.setBackground(verdeBase);
    }//GEN-LAST:event_jlRealizarVentaMouseExited

    private void jlIconBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscarMouseClicked
        try {
            Cliente c1 = (Cliente) jcbVentasXCliente.getSelectedItem();
            borrarFilaDV();
            for (Venta v : vd.listarVentasDeCliente(c1)) {
                DetalleVenta det = dvd.buscarDetalleProVenta(v.getIdVenta());
                Modelo3.addRow(new Object[]{det.getIdDetalleVenta(), det.getIdVenta(),
                    det.getProducto().getNombreProducto(), c1.getTelefono(), v.getFechaVenta(),
                    det.getCantidad(), det.getPrecioVenta()
                });
            }
            jtListaDetalles.setModel(Modelo3);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Cliente");
        }
    }//GEN-LAST:event_jlIconBuscarMouseClicked

    private void jlIconBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscarMouseEntered
        jlIconBuscar.setBackground(verdeClaro);
        jlIconBuscar.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - blanco.png")));
    }//GEN-LAST:event_jlIconBuscarMouseEntered

    private void jlIconBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscarMouseExited
        jlIconBuscar.setBackground(Color.white);
        jlIconBuscar.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - gris.png")));
    }//GEN-LAST:event_jlIconBuscarMouseExited

    private void jlEliminarVentaBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarVentaBorrarMouseEntered
        jlEliminarVentaBorrar.setBackground(verdeClaro);
    }//GEN-LAST:event_jlEliminarVentaBorrarMouseEntered

    private void jlEliminarVentaBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarVentaBorrarMouseExited
        jlEliminarVentaBorrar.setBackground(verdeBase);
    }//GEN-LAST:event_jlEliminarVentaBorrarMouseExited

    private void jlEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarMouseEntered
        jlEliminar.setBackground(verdeClaro);
    }//GEN-LAST:event_jlEliminarMouseEntered

    private void jlEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarMouseExited
        jlEliminar.setBackground(verdeBase);
    }//GEN-LAST:event_jlEliminarMouseExited

    private void jlEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarMouseClicked
        jtpEscritorio.setSelectedIndex(6);
        llenarCombo();
    }//GEN-LAST:event_jlEliminarMouseClicked

    private void jlAgregarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarClienteMouseClicked
        jtpEscritorio.setSelectedIndex(8);
    }//GEN-LAST:event_jlAgregarClienteMouseClicked

    private void jlModificarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarClienteMouseClicked
        jtpEscritorio.setSelectedIndex(9);
        llenarComboCliente();
    }//GEN-LAST:event_jlModificarClienteMouseClicked

    private void jlEliminarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarClienteMouseClicked
        jtpEscritorio.setSelectedIndex(10);
        llenarComboCliente();
    }//GEN-LAST:event_jlEliminarClienteMouseClicked

    private void jTFNombreClienteAgrClienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreClienteAgrClienKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFNombreClienteAgrClienKeyTyped

    private void jTFApellidoClienteAgrClienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoClienteAgrClienKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFApellidoClienteAgrClienKeyTyped

    private void jTFTelefonoClienteAgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoClienteAgKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFTelefonoClienteAgKeyTyped

    private void jLBtnAgregarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnAgregarClienteMouseEntered
        jLBtnAgregarCliente.setBackground(verdeClaro);
    }//GEN-LAST:event_jLBtnAgregarClienteMouseEntered

    private void jLBtnAgregarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnAgregarClienteMouseExited
        jLBtnAgregarCliente.setBackground(verdeBase);
    }//GEN-LAST:event_jLBtnAgregarClienteMouseExited

    private void jLBtnAgregarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnAgregarClienteMouseClicked
        if (jTFTelefonoClienteAg.getText().trim().isEmpty() || jTFNombreClienteAgrClien.getText().trim().isEmpty()
                || jTFDomicilioClienteAgrClien.getText().trim().isEmpty() || jTFApellidoClienteAgrClien.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puede haber campos vacios.");
        } else {
            try {
                Cliente cli = cD.buscarClientePorTel(jTFApellidoClienteAgrClien.getText());
                if (cli == null) {
                    Cliente c1 = new Cliente();
                    c1.setApellido(jTFApellidoClienteAgrClien.getText());
                    c1.setNombre(jTFNombreClienteAgrClien.getText());
                    c1.setDomicilio(jTFDomicilioClienteAgrClien.getText());
                    c1.setTelefono(jTFTelefonoClienteAg.getText());
                    cD.guardarCliente(c1);
                    borrarCamposAgCliente();
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un producto similar, si desea modificar el producto"
                            + "vaya a la pestaña Modificar.");
                }
            } catch (NullPointerException ex) {
            }
        }
    }//GEN-LAST:event_jLBtnAgregarClienteMouseClicked

    private void jcbClienteModifCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteModifCliActionPerformed
        try {
            Cliente cli = (Cliente) jcbClienteModifCli.getSelectedItem();
            jTFApellidoModClien.setText(cli.getApellido());
            jTFNombreClienModClien.setText(cli.getNombre());
            jTFDomicilioModClien.setText(cli.getDomicilio());
            jTFTelefonoModClien.setText(cli.getTelefono());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jcbClienteModifCliActionPerformed

    private void jLBtnModificarModClienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnModificarModClienMousePressed
        try {
            Cliente cli = (Cliente) jcbClienteModifCli.getSelectedItem();
            if (jTFApellidoModClien.getText().trim().isEmpty() || jTFNombreClienModClien.getText().trim().isEmpty()
                    || jTFDomicilioModClien.getText().trim().isEmpty() || jTFTelefonoModClien.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No pude haber campos vacios.");
            } else {
                if (!jTFNombreClienModClien.getText().equalsIgnoreCase(cli.getApellido())
                        || !jTFApellidoModClien.getText().equalsIgnoreCase(cli.getApellido())
                        || !jTFDomicilioModClien.getText().equalsIgnoreCase(cli.getDomicilio())
                        || !jTFTelefonoModClien.getText().equalsIgnoreCase(cli.getTelefono())) {
                    int opcion = JOptionPane.showConfirmDialog(this, "¿Desea Modificar los Datos?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                    switch (opcion) {
                        case 0:
                            cli.setApellido(jTFApellidoModClien.getText());
                            cli.setNombre(jTFNombreClienModClien.getText());
                            cli.setDomicilio(jTFDomicilioModClien.getText());
                            cli.setTelefono(jTFTelefonoModClien.getText());
                            cli.setEstado(true);
                            cD.modicifarCliente(cli);
                        case 1:
                            break;
                    }
                }
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jLBtnModificarModClienMousePressed

    private void jCBBuscarClienElimClienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBuscarClienElimClienActionPerformed
        try {
            Cliente cli = (Cliente) jCBBuscarClienElimClien.getSelectedItem();
            jTFApellidoClienElimClien.setText(cli.getApellido());
            jTFNombreClienElimClien.setText(cli.getNombre());
            jTFDomicilioElimClien.setText(cli.getDomicilio());
            jTFTelefonoElimClien.setText(cli.getTelefono());
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jCBBuscarClienElimClienActionPerformed

    private void jLBtnEliminarElimClienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnEliminarElimClienMouseClicked
        try {
            int cont = 0;
            Cliente cli = (Cliente) jCBBuscarClienElimClien.getSelectedItem();
            if (jTFApellidoClienElimClien.getText().trim().equals(cli.getApellido()) || jTFNombreClienElimClien.getText().trim().equals(cli.getNombre())
                    || jTFDomicilioElimClien.getText().trim().equals(cli.getDomicilio()) || jTFTelefonoElimClien.getText().trim().equals(cli.getTelefono())) {
                for (Venta v : vd.listaVenta()) {
                    if (cli.getIdCliente() == v.getIdCliente()) {
                        cont++;
                    }
                }
                if (cont > 0) {
                    int op = JOptionPane.showConfirmDialog(this, "Este Cliente esta registrado en una o varias ventas, ¿Desea dar de baja esas ventas?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                    switch (op) {
                        case 0:
                            for (DetalleVenta det : dvd.listaDV()) {
                                if (det.getVenta().getIdCliente() == cli.getIdCliente()) {
                                    vd.eliminarVentaId(det.getIdVenta());
                                    dvd.eliminarDetalleVentaPorId(det.getIdDetalleVenta());
                                }
                            }
                            cD.eliminarCliente(cli.getIdCliente());
                            jCBBuscarClienElimClien.removeItemAt(jCBBuscarClienElimClien.getSelectedIndex());
                            break;
                        case 1:
                            break;
                    }
                } else {
                    int opcion = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar los Datos?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                    switch (opcion) {
                        case 0:
                            cD.eliminarCliente(cli.getIdCliente());
                            jCBBuscarClienElimClien.removeItemAt(jCBBuscarClienElimClien.getSelectedIndex());
                        case 1:
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los datos no coinciden");
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jLBtnEliminarElimClienMouseClicked

    private void jtfBuscadorClienListClienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscadorClienListClienKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jtfBuscadorClienListClienKeyTyped

    private void jLBtnEliminarElimProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnEliminarElimProdMousePressed
        try {
            int cont = 0;
            Producto pro = pd.buscarProductoPorNombre(jTFNombreProdElimProd.getText().trim());
            if (pro.getNombreProducto().trim().equals(jTFNombreProdElimProd.getText()) && pro.getDescripcion().trim().equals(jTFDescripcionElimProd.getText())
                    && pro.getPrecioActual() == Double.parseDouble(jTFPrecioActuaElimProd.getText()) && pro.getStock() == Integer.parseInt(jTFStockElimProd.getText())) {
                for (DetalleVenta detv : dvd.listaDV()) {
                    if (pro.getIdProducto() == detv.getIdProducto()) {
                        cont++;
                    }
                }
                if (cont > 0) {
                    int op = JOptionPane.showConfirmDialog(this, "Este producto esta registrado en una o varias ventas, ¿Desea dar de baja esas ventas?", "Selecione una opcion", JOptionPane.YES_NO_OPTION);
                    switch (op) {
                        case 0:
                            for (DetalleVenta det : dvd.listaDV()) {
                                if (pro.getIdProducto() == det.getIdProducto()) {
                                    vd.eliminarVentaId(det.getIdVenta());
                                    dvd.eliminarDetalleVentaPorId(det.getIdDetalleVenta());
                                }
                            }
                            pd.eliminarProducto(pro.getIdProducto());
                            jCBBuscarProdElimProd.removeItemAt(jCBBuscarProdElimProd.getSelectedIndex());
                            break;
                        case 1:
                            break;
                    }
                } else {
                    int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar el Producto?", "Selecione una opcion", JOptionPane.YES_NO_OPTION);
                    switch (opcion) {
                        case 0:
                            pd.eliminarProducto(pro.getIdProducto());
                            jCBBuscarProdElimProd.removeItemAt(jCBBuscarProdElimProd.getSelectedIndex());
                            break;
                        case 1:
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los datos de el producto no coinciden con los de la Base de Datos.");
            }
        } catch (NullPointerException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios");
        }
    }//GEN-LAST:event_jLBtnEliminarElimProdMousePressed

    private void jLBtnModificarModProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnModificarModProdMousePressed
        if (jTFNombreProdModProd.getText().trim().isEmpty() || jTFDescripcionModProd.getText().trim().isEmpty() || jTFPrecioActualModProd.getText().trim().isEmpty()
                || jTFStockModProd.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber espacios vacios");
        } else {
            try {
                Producto pro = (Producto) jcbProductos.getSelectedItem();
                pro = pd.buscarProductoPorNombre(pro.getNombreProducto());
                int opcion = JOptionPane.showConfirmDialog(this, "¿Desea Modificar los Datos?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                switch (opcion) {
                    case 0:
                        Producto prod = new Producto();
                        prod.setIdProducto(pro.getIdProducto());
                        prod.setNombreProducto(jTFNombreProdModProd.getText());
                        prod.setDescripcion(jTFDescripcionModProd.getText());
                        prod.setPrecioActual(Double.parseDouble(jTFPrecioActualModProd.getText()));
                        prod.setStock(Integer.parseInt(jTFStockModProd.getText()));
                        prod.setEstado(pro.getEstado());
                        pd.modificarProducto(prod);
                        break;
                    case 1:
                        break;
                }
            } catch (NumberFormatException ex) {
            }
        }
        llenarCombo();
    }//GEN-LAST:event_jLBtnModificarModProdMousePressed

    private void jcbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProductosActionPerformed
        try {
            Producto pro = (Producto) jcbProductos.getSelectedItem();
            jTFNombreProdModProd.setText(pro.getNombreProducto());
            jTFDescripcionModProd.setText(pro.getDescripcion());
            jTFPrecioActualModProd.setText(pro.getPrecioActual() + "");
            jTFStockModProd.setText(pro.getStock() + "");
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jcbProductosActionPerformed

    private void jCBBuscarProdElimProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBuscarProdElimProdActionPerformed
        try {
            Producto pro = (Producto) jCBBuscarProdElimProd.getSelectedItem();
            jTFNombreProdElimProd.setText(pro.getNombreProducto());
            jTFDescripcionElimProd.setText(pro.getDescripcion());
            jTFPrecioActuaElimProd.setText(pro.getPrecioActual() + "");
            jTFStockElimProd.setText(pro.getStock() + "");
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jCBBuscarProdElimProdActionPerformed

    private void jLEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEmpleadosMouseClicked
        jtpEscritorio.setSelectedIndex(16);
    }//GEN-LAST:event_jLEmpleadosMouseClicked

    private void jLEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEmpleadosMouseEntered
        jLEmpleados.setBackground(grisClaro);
    }//GEN-LAST:event_jLEmpleadosMouseEntered

    private void jLEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEmpleadosMouseExited
        jLEmpleados.setBackground(grisBase);
    }//GEN-LAST:event_jLEmpleadosMouseExited

    private void jlRealizarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRealizarVentaMouseClicked
        if (jtfCantidadVenta.getText().trim().isEmpty() || jtfTelCliente.getText().trim().isEmpty()
                || jdcAgrVenta.getDate() == null || jtfNombreEmpVenta.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar los campos Obligatorios");
        } else {
            try {
                int can = Integer.parseInt(jtfCantidadVenta.getText());
                LocalDate fv = jdcAgrVenta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Producto pro = (Producto) jcbProVenta.getSelectedItem();
                Cliente cli = cD.buscarClientePorTel(jtfTelCliente.getText());
                if (can > pro.getStock()) {
                    JOptionPane.showMessageDialog(this, "La cantidad ingresada es superior al stock disponible");
                } else {
                    if (cli != null) {
                        Empleado emp = ed.buscarPorNombre(jtfNombreEmpVenta.getText());
                        if (!emp.getNombre().equalsIgnoreCase(Login.empleado.getNombre())) {
                            JOptionPane.showMessageDialog(this, "El empleado no coincide");
                        } else {
                            Venta ven = new Venta(cli, emp, fv);
                            vd.guardarVenta(ven);
                            int fila = jtListaGuardVentas.getRowCount();
                            for (int i = 0; i < fila; i++) {
                                int canti = Integer.parseInt(jtListaGuardVentas.getValueAt(i, 3).toString());
                                double pre = Double.parseDouble(jtListaGuardVentas.getValueAt(i, 5).toString());
                                Producto pro1 = pd.buscarProducto(Integer.parseInt(jtListaGuardVentas.getValueAt(i, 0).toString()));
                                if (pro1.getStock() == 0) {
                                    JOptionPane.showMessageDialog(this, "No hay stock disponible de este producto");
                                    break;
                                } else {
                                    DetalleVenta dv = new DetalleVenta(canti, ven, pre, pro1);
                                    dvd.guardarDetalleVenta(dv);
                                    pro1.setStock(pro1.getStock() - canti);
                                    pd.modificarProducto(pro1);
                                }
                            }
                            borrarCamposAgrVen();
                        }
                    } else {
                        int op = JOptionPane.showConfirmDialog(this, "¿Desea agregar un nuevo cliente?", "Selecione una opcion", JOptionPane.YES_NO_OPTION);
                        switch (op) {
                            case 0:
                                cli = new Cliente(null, null, null, jtfTelCliente.getText());
                                cD.guardarCliente(cli);
                                Empleado emp = ed.buscarPorNombre(jtfNombreEmpVenta.getText());
                                if (!emp.getNombre().equalsIgnoreCase(Login.empleado.getNombre())) {
                                    JOptionPane.showMessageDialog(this, "El empleado no coincide");
                                } else {
                                    Venta ven = new Venta(cli, emp, fv);
                                    vd.guardarVenta(ven);
                                    int fila = jtListaGuardVentas.getRowCount();
                                    for (int i = 0; i < fila; i++) {
                                        int canti = Integer.parseInt(jtListaGuardVentas.getValueAt(i, 3).toString());
                                        double pre = Double.parseDouble(jtListaGuardVentas.getValueAt(i, 5).toString());
                                        Producto pro1 = pd.buscarProducto(Integer.parseInt(jtListaGuardVentas.getValueAt(i, 0).toString()));
                                        if (pro1.getStock() == 0) {
                                            JOptionPane.showMessageDialog(this, "No hay stock disponible de este producto");
                                            break;
                                        } else {
                                            DetalleVenta dv = new DetalleVenta(canti, ven, pre, pro1);
                                            dvd.guardarDetalleVenta(dv);
                                            pro1.setStock(pro1.getStock() - canti);
                                            pd.modificarProducto(pro1);
                                        }
                                    }
                                    borrarCamposAgrVen();
                                }
                            case 1:
                                break;
                        }
                    }
                }
            } catch (NullPointerException ex) {
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La cantidad ingresada es invalida");
            }
        }
    }//GEN-LAST:event_jlRealizarVentaMouseClicked

    private void jtfCantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadVentaKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jtfCantidadVentaKeyTyped

    private void jlEliminarVentaBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarVentaBorrarMouseClicked
        Venta v = (Venta) jcbBuscarVenta.getSelectedItem();
        DetalleVenta dv = dvd.buscarDetalleProVenta(v.getIdVenta());
        if (jtfTelCliEliminar.getText().equals(v.getCliente().getTelefono())
                || jdcElimVenta.getDate().equals(Date.valueOf(v.getFechaVenta()))
                || jtfNombreEmpleadoEliminar.getText().equals(Login.empleado.getNombre())) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar la Venta?", "Selecione una opcion", JOptionPane.YES_NO_OPTION);
            switch (opcion) {
                case 0:
                    vd.eliminarVentaId(v.getIdVenta());
                    for (DetalleVenta det : dvd.listaDV()) {
                        if (v.getIdVenta() == det.getIdVenta()) {
                            dvd.eliminarDetalleVentaPorId(dv.getIdDetalleVenta());
                        }
                    }
                    jcbBuscarVenta.removeItemAt(jcbBuscarVenta.getSelectedIndex());
                case 1:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Los Datos no coinciden");
        }
    }//GEN-LAST:event_jlEliminarVentaBorrarMouseClicked

    private void jlImgBusquedaEmplMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImgBusquedaEmplMouseClicked
        borrarFilaE();
        String nombre = jtfBuscadorEmpleadosListEmp.getText().toUpperCase();
        for (Empleado empl : ed.listarEmpleado()) {
            if (empl.getApellido().trim().toUpperCase().contains(nombre)) {
                Modelo2.addRow(new Object[]{empl.getIdEmpleado(), empl.getApellido(), empl.getNombre(), empl.getDni(),
                    empl.getCargo(), empl.getUsuario(), empl.getContraenia()});
            }
        }
    }//GEN-LAST:event_jlImgBusquedaEmplMouseClicked

    private void jlAgregarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarEmpleadoMouseClicked
        Registro reg = new Registro();
        reg.setVisible(true);
    }//GEN-LAST:event_jlAgregarEmpleadoMouseClicked

    private void jlAgregarEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarEmpleadoMouseEntered
        jlAgregarEmpleado.setBackground(verdeClaro);
    }//GEN-LAST:event_jlAgregarEmpleadoMouseEntered

    private void jlAgregarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarEmpleadoMouseExited
        jlAgregarEmpleado.setBackground(verdeBase);
    }//GEN-LAST:event_jlAgregarEmpleadoMouseExited

    private void jlModificarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarEmpleadoMouseClicked
        jtpEscritorio.setSelectedIndex(17);
        llenarComboEmpleado();
        llenarComboCargo();
    }//GEN-LAST:event_jlModificarEmpleadoMouseClicked

    private void jlModificarEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarEmpleadoMouseEntered
        jlModificarEmpleado.setBackground(verdeClaro);
    }//GEN-LAST:event_jlModificarEmpleadoMouseEntered

    private void jlModificarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarEmpleadoMouseExited
        jlModificarEmpleado.setBackground(verdeBase);
    }//GEN-LAST:event_jlModificarEmpleadoMouseExited

    private void jlEliminarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarEmpleadoMouseClicked
        jtpEscritorio.setSelectedIndex(18);
        llenarComboEmpleado();
    }//GEN-LAST:event_jlEliminarEmpleadoMouseClicked

    private void jlEliminarEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarEmpleadoMouseEntered
        jlEliminarEmpleado.setBackground(verdeClaro);
    }//GEN-LAST:event_jlEliminarEmpleadoMouseEntered

    private void jlEliminarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarEmpleadoMouseExited
        jlEliminarEmpleado.setBackground(verdeBase);
    }//GEN-LAST:event_jlEliminarEmpleadoMouseExited

    private void jlListarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarEmpleadoMouseClicked
        jtpEscritorio.setSelectedIndex(19);
        llenarTablaEmp();
    }//GEN-LAST:event_jlListarEmpleadoMouseClicked

    private void jlListarEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarEmpleadoMouseEntered
        jlListarEmpleado.setBackground(verdeClaro);
    }//GEN-LAST:event_jlListarEmpleadoMouseEntered

    private void jlListarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlListarEmpleadoMouseExited
        jlListarEmpleado.setBackground(verdeBase);
    }//GEN-LAST:event_jlListarEmpleadoMouseExited

    private void jCBModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBModificarEmpleadoActionPerformed
        try {
            Empleado emp = (Empleado) jCBModificarEmpleado.getSelectedItem();
            jTFApellidoModEmp.setText(emp.getApellido());
            jTFNombreEmpleadoModEmp.setText(emp.getNombre());
            jTFDniModEmp.setText(emp.getDni() + "");
            jTFUsuarioModEmp.setText(emp.getUsuario());
            jTFContraseñaModEmp.setText(emp.getContraenia());
            jCBCargoModifEmp.setSelectedItem(emp.getCargo());
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jCBModificarEmpleadoActionPerformed

    private void jLBtnModificarModEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnModificarModEmpMouseClicked
        try {
            Empleado emp = ed.buscarEmpleadoPorDni(Integer.parseInt(jTFDniModEmp.getText()));
            if (emp != null) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro, desea Modificar datos del Empleado?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                switch (opcion) {
                    case 0:
                        Empleado emp1 = new Empleado();
                        emp1.setIdEmpleado(emp.getIdEmpleado());
                        emp1.setApellido(jTFApellidoModEmp.getText());
                        emp1.setNombre(jTFNombreEmpleadoModEmp.getText());
                        emp1.setDni(Integer.parseInt(jTFDniModEmp.getText()));
                        emp1.setCargo(jCBCargoModifEmp.getSelectedItem() + "");
                        emp1.setUsuario(jTFUsuarioModEmp.getText());
                        emp1.setContraenia(jTFContraseñaModEmp.getText());
                        emp1.setEstado(true);
                        ed.modificarEmpleado(emp1);
                        break;
                    case 1:
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el empleado");
            }
            llenarComboEmpleado();
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jLBtnModificarModEmpMouseClicked

    private void jLBtnModificarModEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnModificarModEmpMouseEntered
        jLBtnModificarModEmp.setBackground(verdeClaro);
    }//GEN-LAST:event_jLBtnModificarModEmpMouseEntered

    private void jLBtnModificarModEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnModificarModEmpMouseExited
        jLBtnModificarModEmp.setBackground(verdeBase);
    }//GEN-LAST:event_jLBtnModificarModEmpMouseExited

    private void jLBtnEliminarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnEliminarEmpleadoMouseClicked
        try {
            int cont = 0;
            Empleado emp = ed.buscarEmpleadoPorDni(Integer.parseInt(jTFDniElimEmp.getText()));
            if (emp != null) {
                for (Venta v : vd.listaVenta()) {
                    if (emp.getIdEmpleado() == v.getEmpleado().getIdEmpleado()) {
                        cont++;
                    }
                }
                if (cont > 0) {
                    int op = JOptionPane.showConfirmDialog(this, "Este empleado esta registrado en una o varias ventas, ¿Desea darlas de baja?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                    switch (op) {
                        case 0:
                            for (DetalleVenta detv : dvd.listaDV()) {
                                if (emp.getIdEmpleado() == detv.getVenta().getEmpleado().getIdEmpleado()) {
                                    vd.eliminarVentaId(detv.getIdVenta());
                                    dvd.eliminarDetalleVentaPorId(detv.getIdDetalleVenta());
                                }
                            }
                            ed.eliminarEmpleadoPorId(emp.getIdEmpleado());
                            jCBEliminarEmpleado.removeItemAt(jCBEliminarEmpleado.getSelectedIndex());
                            break;
                        case 1:
                            break;
                    }
                } else {
                    int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro, desea Eliminar al Empleado?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                    switch (opcion) {
                        case 0:
                            ed.eliminarEmpleadoPorId(emp.getIdEmpleado());
                            jCBEliminarEmpleado.removeItemAt(jCBEliminarEmpleado.getSelectedIndex());
                            break;
                        case 1:
                            break;
                    }
                }
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jLBtnEliminarEmpleadoMouseClicked

    private void jLBtnEliminarEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnEliminarEmpleadoMouseEntered
        jLBtnEliminarEmpleado.setBackground(verdeClaro);
    }//GEN-LAST:event_jLBtnEliminarEmpleadoMouseEntered

    private void jLBtnEliminarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnEliminarEmpleadoMouseExited
        jLBtnEliminarEmpleado.setBackground(verdeBase);
    }//GEN-LAST:event_jLBtnEliminarEmpleadoMouseExited

    private void jlImgBusquedaEmplMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImgBusquedaEmplMouseEntered
        jlImgBusquedaEmpl.setBackground(verdeClaro);
    }//GEN-LAST:event_jlImgBusquedaEmplMouseEntered

    private void jlImgBusquedaEmplMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImgBusquedaEmplMouseExited
        jlImgBusquedaEmpl.setBackground(Color.WHITE);
    }//GEN-LAST:event_jlImgBusquedaEmplMouseExited

    private void jlVentaPapeleraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentaPapeleraMouseClicked
        try {
            borrarFilaPV();
            for (Venta ven : vd.listaVentaBaja()) {
                ModeloV.addRow(new Object[]{ven.getIdVenta(), ven.getCliente().getTelefono(),
                    ven.getEmpleado().getApellido() + " " + ven.getEmpleado().getNombre(),
                    ven.getFechaVenta()
                });
                jTablePapelera.setModel(ModeloV);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "La papelera esta vacia.");
        }
    }//GEN-LAST:event_jlVentaPapeleraMouseClicked

    private void jlVentaPapeleraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentaPapeleraMouseEntered
        jlVentaPapelera.setBackground(verdeClaro);
    }//GEN-LAST:event_jlVentaPapeleraMouseEntered

    private void jlVentaPapeleraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentaPapeleraMouseExited
        jlVentaPapelera.setBackground(verdeBase);
    }//GEN-LAST:event_jlVentaPapeleraMouseExited

    private void jlClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClienteMouseClicked
        try {
            borrarFilaPC();
            for (Cliente cli : cD.listarClientesBaja()) {
                ModeloC.addRow(new Object[]{cli.getIdCliente(), cli.getApellido(),
                    cli.getNombre(), cli.getDomicilio(), cli.getTelefono()});
                jTablePapelera.setModel(ModeloC);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "La papelera esta vacia.");
        }
    }//GEN-LAST:event_jlClienteMouseClicked

    private void jlClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClienteMouseEntered
        jlCliente.setBackground(verdeClaro);
    }//GEN-LAST:event_jlClienteMouseEntered

    private void jlClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClienteMouseExited
        jlCliente.setBackground(verdeBase);
    }//GEN-LAST:event_jlClienteMouseExited

    private void jlProductoPapeleraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductoPapeleraMouseClicked
        try {
            borrarFilaPP();
            for (Producto pro : pd.listarProductoBaja()) {
                ModeloP.addRow(new Object[]{pro.getIdProducto(), pro.getNombreProducto(),
                    pro.getDescripcion(), pro.getPrecioActual(), pro.getStock()});
                jTablePapelera.setModel(ModeloP);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "La papelera esta vacia.");
        }
    }//GEN-LAST:event_jlProductoPapeleraMouseClicked

    private void jlProductoPapeleraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductoPapeleraMouseEntered
        jlProductoPapelera.setBackground(verdeClaro);
    }//GEN-LAST:event_jlProductoPapeleraMouseEntered

    private void jlProductoPapeleraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductoPapeleraMouseExited
        jlProductoPapelera.setBackground(verdeBase);
    }//GEN-LAST:event_jlProductoPapeleraMouseExited

    private void jlEmpleadoPapeleraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEmpleadoPapeleraMouseClicked
        borrarFilaPE();
        try {
            for (Empleado emp : ed.listarEmpleadoBaja()) {
                ModeloE.addRow(new Object[]{emp.getIdEmpleado(), emp.getApellido(), emp.getNombre(),
                    emp.getDni(), emp.getCargo(), emp.getUsuario(), emp.getContraenia()});
                jTablePapelera.setModel(ModeloE);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "La papelera esta vacia.");
        }
    }//GEN-LAST:event_jlEmpleadoPapeleraMouseClicked

    private void jlEmpleadoPapeleraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEmpleadoPapeleraMouseEntered
        jlEmpleadoPapelera.setBackground(verdeClaro);
    }//GEN-LAST:event_jlEmpleadoPapeleraMouseEntered

    private void jlEmpleadoPapeleraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEmpleadoPapeleraMouseExited
        jlEmpleadoPapelera.setBackground(verdeBase);
    }//GEN-LAST:event_jlEmpleadoPapeleraMouseExited

    private void jlEliminarPapeleraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarPapeleraMouseClicked
        try {
            int fila = jTablePapelera.getSelectedRow();
            if (jTablePapelera.getModel().equals(ModeloP)) {
                int op = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar este Producto y las ventas asociadas de la base de datos?", "Eliga una opcion", JOptionPane.YES_NO_OPTION);
                switch (op) {
                    case 0:
                        Integer id = (Integer) jTablePapelera.getValueAt(fila, 0);
                        for (DetalleVenta dt : dvd.listaDVTodo()) {
                            if (id.equals(dt.getIdProducto())) {
                                for (DetalleVenta det : dvd.listaDVTodo()) {
                                    if (id.equals(dt.getIdProducto())) {
                                        dvd.eliminarDetalleVentaPorIdBD(det.getIdDetalleVenta());
                                    }
                                }
                                vd.eliminarVentaIdBD(dt.getIdVenta());
                            }
                        }
                        pd.eliminarProductoDB(id);
                        ModeloP.removeRow(fila);
                        break;
                    case 1:
                        break;
                }
            } else if (jTablePapelera.getModel().equals(ModeloC)) {
                int op = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar este Cliente y las ventas asociadas de la base de datos?", "Eliga una opcion", JOptionPane.YES_NO_OPTION);
                switch (op) {
                    case 0:
                        Integer id = (Integer) jTablePapelera.getValueAt(fila, 0);
                        for (DetalleVenta dt : dvd.listaDVTodo()) {
                            if (id.equals(dt.getIdProducto())) {
                                for (DetalleVenta det : dvd.listaDVTodo()) {
                                    if (id.equals(dt.getIdProducto())) {
                                        dvd.eliminarDetalleVentaPorIdBD(det.getIdDetalleVenta());
                                    }
                                }
                                vd.eliminarVentaIdBD(dt.getIdVenta());
                            }
                        }
                        cD.eliminarClienteDB(id);
                        ModeloC.removeRow(fila);
                        break;
                    case 1:
                        break;
                }
            } else if (jTablePapelera.getModel().equals(ModeloE)) {
                int op = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar este Empleado y las ventas asociadas de la base de datos?", "Eliga una opcion", JOptionPane.YES_NO_OPTION);
                switch (op) {
                    case 0:
                        Integer id = (Integer) jTablePapelera.getValueAt(fila, 0);
                        for (DetalleVenta dt : dvd.listaDVTodo()) {
                            if (id.equals(dt.getIdProducto())) {
                                for (DetalleVenta det : dvd.listaDVTodo()) {
                                    if (id.equals(dt.getIdProducto())) {
                                        dvd.eliminarDetalleVentaPorIdBD(det.getIdDetalleVenta());
                                    }
                                }
                                vd.eliminarVentaIdBD(dt.getIdVenta());
                            }
                        }
                        ed.eliminarEmpleadoPorIdDB(id);
                        ModeloE.removeRow(fila);
                        break;
                    case 1:
                        break;
                }
            } else if (jTablePapelera.getModel().equals(ModeloV)) {
                int op = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar esta venta de la base de datos?", "Eliga una opcion", JOptionPane.YES_NO_OPTION);
                switch (op) {
                    case 0:
                        Integer id = (Integer) jTablePapelera.getValueAt(fila, 0);
                        for (DetalleVenta det : dvd.listaDVTodo()) {
                            if (id.equals(det.getIdVenta())) {
                                dvd.eliminarDetalleVentaPorIdBD(det.getIdDetalleVenta());
                            }
                        }
                        vd.eliminarVentaIdBD(id);
                        ModeloV.removeRow(fila);
                        break;
                    case 1:
                        break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_jlEliminarPapeleraMouseClicked

    private void jlEliminarPapeleraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarPapeleraMouseEntered
        jlEliminarPapelera.setBackground(verdeClaro);
    }//GEN-LAST:event_jlEliminarPapeleraMouseEntered

    private void jlEliminarPapeleraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarPapeleraMouseExited
        jlEliminarPapelera.setBackground(verdeBase);
    }//GEN-LAST:event_jlEliminarPapeleraMouseExited

    private void jlRestaurarPapeleraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRestaurarPapeleraMouseClicked
        try {
            int fila = jTablePapelera.getSelectedRow();
            if (jTablePapelera.getModel().equals(ModeloP)) {
                int op = JOptionPane.showConfirmDialog(this, "¿Desea restaurar este Producto?", "Eliga una opcion", JOptionPane.YES_NO_OPTION);
                switch (op) {
                    case 0:
                        String nombre = (String) jTablePapelera.getValueAt(jTablePapelera.getSelectedRow(), 1);
                        Producto pro = pd.buscarProductoPorNombreBaja(nombre);
                        pro.setEstado(true);
                        pd.modificarProducto(pro);
                        ModeloP.removeRow(fila);
                        break;
                    case 1:
                        break;
                }
            } else if (jTablePapelera.getModel().equals(ModeloC)) {
                int op = JOptionPane.showConfirmDialog(this, "¿Desea restaurar este Cliente?", "Eliga una opcion", JOptionPane.YES_NO_OPTION);
                switch (op) {
                    case 0:
                        String tel = (String) jTablePapelera.getValueAt(jTablePapelera.getSelectedRow(), 4);
                        Cliente cli = cD.buscarClientePorTelBaja(tel);
                        cli.setEstado(true);
                        cD.modicifarCliente(cli);
                        ModeloC.removeRow(fila);
                        break;
                    case 1:
                        break;
                }
            } else if (jTablePapelera.getModel().equals(ModeloE)) {
                int op = JOptionPane.showConfirmDialog(this, "¿Desea restaurar este Empleado?", "Eliga una opcion", JOptionPane.YES_NO_OPTION);
                switch (op) {
                    case 0:
                        Integer dni = (Integer) jTablePapelera.getValueAt(jTablePapelera.getSelectedRow(), 3);
                        Empleado emp = ed.buscarEmpleadoPorDniBaja(dni);
                        emp.setEstado(true);
                        ed.modificarEmpleado(emp);
                        ModeloE.removeRow(fila);
                        break;
                    case 1:
                        break;
                }
            } else if (jTablePapelera.getModel().equals(ModeloV)) {
                int op = JOptionPane.showConfirmDialog(this, "¿Desea restaurar esta Venta?", "Eliga una opcion", JOptionPane.YES_NO_OPTION);
                switch (op) {
                    case 0:
                        Integer id = (Integer) jTablePapelera.getValueAt(jTablePapelera.getSelectedRow(), 0);
                        Venta ven = vd.buscarVentaId(id);
                        DetalleVenta det = dvd.buscarDetalleProVentaBaja(id);
                        ven.setEstado(true);
                        if (!ven.getCliente().isEstado() && !ven.getEmpleado().isEstado()) {
                            int opcion = JOptionPane.showConfirmDialog(this, "¿Desea restaurar al Cliente y Empleado registrados en esta venta?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                            switch (opcion) {
                                case 0:
                                    ven.getCliente().setEstado(true);
                                    ven.getEmpleado().setEstado(true);
                                    cD.modicifarCliente(ven.getCliente());
                                    ed.modificarEmpleado(ven.getEmpleado());
                                case 1:
                                    break;
                            }
                        } else if (!ven.getCliente().isEstado()) {
                            int opcion = JOptionPane.showConfirmDialog(this, "¿Desea restaurar al Cliente registrado en esta venta?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                            switch (opcion) {
                                case 0:
                                    ven.getCliente().setEstado(true);
                                    cD.modicifarCliente(ven.getCliente());
                                case 1:
                                    break;
                            }
                        } else if (!ven.getEmpleado().isEstado()) {
                            int opcion = JOptionPane.showConfirmDialog(this, "¿Desea restaurar al Empleado registrado en esta venta?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                            switch (opcion) {
                                case 0:
                                    ven.getEmpleado().setEstado(true);
                                    ed.modificarEmpleado(ven.getEmpleado());
                                case 1:
                                    break;
                            }
                        } else if (!det.getProducto().getEstado()) {
                            int opcion = JOptionPane.showConfirmDialog(this, "¿Desea restaurar el Producto registrado en esta venta?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION);
                            switch (opcion) {
                                case 0:
                                    det.getProducto().setEstado(true);
                                    pd.modificarProducto(det.getProducto());
                                case 1:
                                    break;
                            }
                        }
                        vd.modificarVenta(ven);
                        for (DetalleVenta dt : dvd.listaDVTodo()) {
                            if (id.equals(det.getIdVenta())) {
                                dt.setEstado(true);
                                dvd.modificarDetalleVenta(dt);
                            }
                        }
                        ModeloV.removeRow(fila);
                        break;
                    case 1:
                        break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_jlRestaurarPapeleraMouseClicked

    private void jlRestaurarPapeleraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRestaurarPapeleraMouseEntered
        jlRestaurarPapelera.setBackground(verdeClaro);
    }//GEN-LAST:event_jlRestaurarPapeleraMouseEntered

    private void jlRestaurarPapeleraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRestaurarPapeleraMouseExited
        jlRestaurarPapelera.setBackground(verdeBase);
    }//GEN-LAST:event_jlRestaurarPapeleraMouseExited

    private void jlPapeleraMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPapeleraMenuMouseEntered
        jlPapeleraMenu.setBackground(grisClaro);
    }//GEN-LAST:event_jlPapeleraMenuMouseEntered

    private void jlPapeleraMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPapeleraMenuMouseExited
        jlPapeleraMenu.setBackground(grisBase);
    }//GEN-LAST:event_jlPapeleraMenuMouseExited

    private void jlPapeleraMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPapeleraMenuMouseClicked
        jtpEscritorio.setSelectedIndex(20);
    }//GEN-LAST:event_jlPapeleraMenuMouseClicked

    private void jCBEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEliminarEmpleadoActionPerformed
        try {
            Empleado emp = (Empleado) jCBEliminarEmpleado.getSelectedItem();
            jTFApellidoElimEmp.setText(emp.getApellido());
            jTFNombreEmpleadoElimEmp.setText(emp.getNombre());
            jTFDniElimEmp.setText(emp.getDni() + "");
            jTFUsuarioElimEmp.setText(emp.getUsuario());
            jTFContraseñaElimEmp.setText(emp.getContraenia());
            jCBCargoElimEmp.removeAllItems();
            jCBCargoElimEmp.addItem(emp.getCargo());
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jCBEliminarEmpleadoActionPerformed

    private void jTFNombreProductoAgrProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreProductoAgrProdKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFNombreProductoAgrProdKeyTyped

    private void jTFPrecioActualAgrProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioActualAgrProdKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFPrecioActualAgrProdKeyTyped

    private void jTFStockAgrProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFStockAgrProdKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFStockAgrProdKeyTyped

    private void jlIconBuscarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscarVentaMouseClicked
        try {
            borrarFilaV();
            LocalDate fecha = jdcBusquedaVentas.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            for (Venta venta : vd.listarVentasPorFecha(fecha)) {
                if (fecha.equals(venta.getFechaVenta()) && venta.getEstado() == true) {
                    DetalleVenta det = dvd.buscarDetalleProVenta(venta.getIdVenta());
                    Modelo4.addRow(new Object[]{det.getIdDetalleVenta(), venta.getIdVenta(), det.getProducto().getNombreProducto(),
                        venta.getCliente().getTelefono(), venta.getFechaVenta(), det.getCantidad(),
                        det.getPrecioVenta()
                    });
                }
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha.");
        }
    }//GEN-LAST:event_jlIconBuscarVentaMouseClicked

    private void jlIconBuscarVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscarVentaMouseEntered
        jlIconBuscarVenta.setBackground(verdeClaro);
        jlIconBuscarVenta.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - blanco.png")));
    }//GEN-LAST:event_jlIconBuscarVentaMouseEntered

    private void jlIconBuscarVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscarVentaMouseExited
        jlIconBuscarVenta.setBackground(Color.white);
        jlIconBuscarVenta.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - gris.png")));
    }//GEN-LAST:event_jlIconBuscarVentaMouseExited

    private void jLBtnAgregarProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnAgregarProdMouseClicked
        if (jTFNombreProductoAgrProd.getText().trim().isEmpty() || jTFPrecioActualAgrProd.getText().trim().isEmpty()
                || jTFDescripcionAgrProd.getText().trim().isEmpty() || jTFStockAgrProd.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios");
        } else {
            try {
                Producto producto = pd.buscarProductoPorNombre(jTFNombreProductoAgrProd.getText());
                if (producto != null) {
                    JOptionPane.showMessageDialog(this, "Ya hay un producto con ese nombre, si quiere modificarlo vaya a la pestaña de modificar producto");
                } else {
                    producto = new Producto();
                    producto.setNombreProducto(jTFNombreProductoAgrProd.getText());
                    producto.setDescripcion(jTFDescripcionAgrProd.getText());
                    producto.setPrecioActual(Double.parseDouble(jTFPrecioActualAgrProd.getText()));
                    producto.setStock(Integer.parseInt(jTFStockAgrProd.getText()));
                    producto.setEstado(true);
                    pd.guardarProducto(producto);
                    borrarCamposAgrProd();
                }
            } catch (NullPointerException ex) {
            }
        }
    }//GEN-LAST:event_jLBtnAgregarProdMouseClicked

    private void jlIconBuscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscar1MouseClicked
        try {
            LocalDate fecha = jdcFechaPro.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            borrarFila();
            for (Producto p : vd.obtenerProductosPorFecha(fecha)) {
                Modelo.addRow(new Object[]{p.getIdProducto(), p.getNombreProducto(),
                    p.getDescripcion(), p.getPrecioActual(), p.getStock()
                });
            }
            jtListaDetalles.setModel(Modelo);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha");
        }
    }//GEN-LAST:event_jlIconBuscar1MouseClicked

    private void jlIconBuscar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscar1MouseEntered
        jlIconBuscar1.setBackground(verdeClaro);
        jlIconBuscar1.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - blanco.png")));
    }//GEN-LAST:event_jlIconBuscar1MouseEntered

    private void jlIconBuscar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscar1MouseExited
        jlIconBuscar1.setBackground(Color.white);
        jlIconBuscar1.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - gris.png")));
    }//GEN-LAST:event_jlIconBuscar1MouseExited

    private void jlIconBuscar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscar2MouseClicked
        try {
            Producto p1 = (Producto) jcbProXCliente.getSelectedItem();
            borrarFilaC();
            for (Cliente c : vd.obtenerClientesPorProducto(p1)) {
                Modelo1.addRow(new Object[]{c.getIdCliente(), c.getApellido(), c.getNombre(),
                    c.getDomicilio(), c.getTelefono()
                });
            }
            jtListaDetalles.setModel(Modelo1);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Producto");
        }
    }//GEN-LAST:event_jlIconBuscar2MouseClicked

    private void jlIconBuscar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscar2MouseEntered
        jlIconBuscar2.setBackground(verdeClaro);
        jlIconBuscar2.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - blanco.png")));
    }//GEN-LAST:event_jlIconBuscar2MouseEntered

    private void jlIconBuscar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIconBuscar2MouseExited
        jlIconBuscar2.setBackground(Color.white);
        jlIconBuscar2.setIcon(new ImageIcon(getClass().getResource("/Image/busqueda - gris.png")));
    }//GEN-LAST:event_jlIconBuscar2MouseExited

    private void jlVentasCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentasCliMouseClicked
        jtListaDetalles.setModel(Modelo3);
        jcbVentasXCliente.setEnabled(true);
        jlIconBuscar.setEnabled(true);
        jdcFechaPro.setEnabled(false);
        jlIconBuscar1.setEnabled(false);
        jlIconBuscar2.setEnabled(false);
        jcbProXCliente.setEnabled(false);
    }//GEN-LAST:event_jlVentasCliMouseClicked

    private void jlVentasCliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentasCliMouseEntered
        jlVentasCli.setBackground(verdeClaro);
    }//GEN-LAST:event_jlVentasCliMouseEntered

    private void jlVentasCliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentasCliMouseExited
        jlVentasCli.setBackground(verdeBase);
    }//GEN-LAST:event_jlVentasCliMouseExited

    private void jlProXFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProXFechaMouseClicked
        jtListaDetalles.setModel(Modelo);
        jlIconBuscar1.setEnabled(true);
        jdcFechaPro.setEnabled(true);
        jcbVentasXCliente.setEnabled(false);
        jlIconBuscar.setEnabled(false);
        jlIconBuscar2.setEnabled(false);
        jcbProXCliente.setEnabled(false);
    }//GEN-LAST:event_jlProXFechaMouseClicked

    private void jlProXFechaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProXFechaMouseEntered
        jlProXFecha.setBackground(verdeClaro);
    }//GEN-LAST:event_jlProXFechaMouseEntered

    private void jlProXFechaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProXFechaMouseExited
        jlProXFecha.setBackground(verdeBase);
    }//GEN-LAST:event_jlProXFechaMouseExited

    private void jlClientesxProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClientesxProMouseClicked
        jtListaDetalles.setModel(Modelo1);
        jcbProXCliente.setEnabled(true);
        jlIconBuscar2.setEnabled(true);
        jcbVentasXCliente.setEnabled(false);
        jlIconBuscar.setEnabled(false);
        jlIconBuscar1.setEnabled(false);
        jdcFechaPro.setEnabled(false);
    }//GEN-LAST:event_jlClientesxProMouseClicked

    private void jlClientesxProMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClientesxProMouseEntered
        jlClientesxPro.setBackground(verdeClaro);
    }//GEN-LAST:event_jlClientesxProMouseEntered

    private void jlClientesxProMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClientesxProMouseExited
        jlClientesxPro.setBackground(verdeBase);
    }//GEN-LAST:event_jlClientesxProMouseExited

    private void jLimpiarTablaAaVenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLimpiarTablaAaVenMouseClicked
        try {
            borrarFilaAPV();
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "La tabla esta vacia");
        } finally {
            totalPago();
        }
    }//GEN-LAST:event_jLimpiarTablaAaVenMouseClicked

    private void jLimpiarTablaAaVenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLimpiarTablaAaVenMouseEntered
        jLimpiarTablaAaVen.setBackground(verdeClaro);
    }//GEN-LAST:event_jLimpiarTablaAaVenMouseEntered

    private void jLimpiarTablaAaVenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLimpiarTablaAaVenMouseExited
        jLimpiarTablaAaVen.setBackground(verdeBase);
    }//GEN-LAST:event_jLimpiarTablaAaVenMouseExited

    private void jlAgregarProdTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarProdTablaMouseClicked
        if (jtfCantidadVenta.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad");
        } else {
            int cont = 0;
            Producto prod = (Producto) jcbProVenta.getSelectedItem();
            int cantidadProd = (Integer.parseInt(jtfCantidadVenta.getText()));
            int fila = jtListaGuardVentas.getRowCount();
            double subtotal = (prod.getPrecioActual() * cantidadProd);
            try {
                for (int i = 0; i < fila; i++) {
                    if (prod.getNombreProducto().equalsIgnoreCase(jtListaGuardVentas.getValueAt(i, 1).toString())) {
                        cont++;
                    }
                }
                if (cont == 0 || fila == 0) {
                    Modelo5.addRow(new Object[]{prod.getIdProducto(), prod.getNombreProducto(),
                        prod.getDescripcion(), cantidadProd, prod.getPrecioActual(), subtotal});
                    jtListaGuardVentas.setModel(Modelo5);
                } else {
                    for (int i = 0; i < fila; i++) {
                        if (prod.getNombreProducto().equalsIgnoreCase(jtListaGuardVentas.getValueAt(i, 1).toString())) {
                            int agrega = JOptionPane.showConfirmDialog(this, "¿Desea agregar mas cantidad a este producto?", "Este producto ya esta en la lista", JOptionPane.YES_NO_OPTION);
                            switch (agrega) {
                                case 0:
                                    cantidadProd += Integer.parseInt(jtListaGuardVentas.getValueAt(i, 3).toString());
                                    subtotal += Double.parseDouble(jtListaGuardVentas.getValueAt(i, 5).toString());
                                    jtListaGuardVentas.setValueAt(cantidadProd, i, 3);
                                    jtListaGuardVentas.setValueAt(subtotal, i, 5);
                                    break;
                                case 1:
                                    break;
                            }
                        }
                    }
                }
            } catch (NullPointerException ex) {
                Modelo5.addRow(new Object[]{prod.getIdProducto(), prod.getNombreProducto(),
                    prod.getDescripcion(), cantidadProd, prod.getPrecioActual(), subtotal});
                jtListaGuardVentas.setModel(Modelo5);
            } finally {
                totalPago();
                cont = 0;
            }
        }
    }//GEN-LAST:event_jlAgregarProdTablaMouseClicked

    private void jlAgregarProdTablaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarProdTablaMouseEntered
        jlAgregarProdTabla.setBackground(verdeClaro);
    }//GEN-LAST:event_jlAgregarProdTablaMouseEntered

    private void jlAgregarProdTablaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarProdTablaMouseExited
        jlAgregarProdTabla.setBackground(verdeBase);
    }//GEN-LAST:event_jlAgregarProdTablaMouseExited

    private void jlEliminarProdTabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarProdTabla1MouseClicked
        try {
            int fila = jtListaGuardVentas.getSelectedRow();
            Modelo5.removeRow(fila);
            jtListaGuardVentas.setModel(Modelo5);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } finally {
            totalPago();
        }
    }//GEN-LAST:event_jlEliminarProdTabla1MouseClicked

    private void jlEliminarProdTabla1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarProdTabla1MouseEntered
        jlEliminarProdTabla1.setBackground(verdeClaro);
    }//GEN-LAST:event_jlEliminarProdTabla1MouseEntered

    private void jlEliminarProdTabla1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarProdTabla1MouseExited
        jlEliminarProdTabla1.setBackground(verdeBase);
    }//GEN-LAST:event_jlEliminarProdTabla1MouseExited

    private void jTFNombreClienModClienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreClienModClienKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFNombreClienModClienKeyTyped

    private void jTFApellidoModClienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoModClienKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFApellidoModClienKeyTyped

    private void jTFTelefonoModClienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoModClienKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFTelefonoModClienKeyTyped

    private void jtfNombreEmpVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreEmpVentaKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jtfNombreEmpVentaKeyTyped

    private void jtfTelClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelClienteKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jtfTelClienteKeyTyped

    private void jtfTelCliEliminarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelCliEliminarKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jtfTelCliEliminarKeyTyped

    private void jtfNombreEmpleadoEliminarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreEmpleadoEliminarKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jtfNombreEmpleadoEliminarKeyTyped

    private void jTFNombreEmpleadoModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreEmpleadoModEmpKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFNombreEmpleadoModEmpKeyTyped

    private void jTFApellidoModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoModEmpKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFApellidoModEmpKeyTyped

    private void jTFDniModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDniModEmpKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFDniModEmpKeyTyped

    private void jTFNombreEmpleadoElimEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreEmpleadoElimEmpKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFNombreEmpleadoElimEmpKeyTyped

    private void jTFApellidoElimEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoElimEmpKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFApellidoElimEmpKeyTyped

    private void jTFDniElimEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDniElimEmpKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFDniElimEmpKeyTyped

    private void jtfBuscadorEmpleadosListEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscadorEmpleadosListEmpKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jtfBuscadorEmpleadosListEmpKeyTyped

    private void jTFPrecioActuaElimProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioActuaElimProdKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFPrecioActuaElimProdKeyTyped

    private void jTFStockElimProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFStockElimProdKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFStockElimProdKeyTyped

    private void jTFNombreProdElimProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreProdElimProdKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFNombreProdElimProdKeyTyped

    private void jTFNombreProdModProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreProdModProdKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFNombreProdModProdKeyTyped

    private void jTFPrecioActualModProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioActualModProdKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFPrecioActualModProdKeyTyped

    private void jTFStockModProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFStockModProdKeyTyped
        controlNumeros(evt);
    }//GEN-LAST:event_jTFStockModProdKeyTyped

    private void jcbBuscarVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbBuscarVentaItemStateChanged
        try {
            Venta venta = (Venta) jcbBuscarVenta.getSelectedItem();
            Mlist.removeAllElements();
            for (DetalleVenta det : dvd.listaDV()) {
                if (det.getIdVenta() == venta.getIdVenta()) {
                    Mlist.addElement(det.getProducto());
                }
            }
            jtfTelCliEliminar.setText(venta.getCliente().getTelefono());
            jtfNombreEmpleadoEliminar.setText(venta.getEmpleado().getNombre() + " " + venta.getEmpleado().getApellido());
            jdcElimVenta.setDate(Date.valueOf(venta.getFechaVenta()));
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jcbBuscarVentaItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    UIManager.put("nimbusBlueGrey", new Color(51, 51, 76));
//                    UIManager.put("control", new Color(0, 150, 136));
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JLabel DetVenta;
    private javax.swing.JLabel EliminarVenta;
    private javax.swing.JLabel RegistrarVenta;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JScrollPane ScrollListClien;
    private javax.swing.JScrollPane ScrollListClien1;
    private javax.swing.JScrollPane ScrollTablaDetalles;
    private javax.swing.JScrollPane ScrollTablaVentas;
    private javax.swing.JScrollPane ScrollTablaVentas1;
    private javax.swing.JLabel fravemaxLogo;
    private javax.swing.JComboBox<Cliente> jCBBuscarClienElimClien;
    private javax.swing.JComboBox<Producto> jCBBuscarProdElimProd;
    private javax.swing.JComboBox<String> jCBCargoElimEmp;
    private javax.swing.JComboBox<String> jCBCargoModifEmp;
    private javax.swing.JComboBox<Empleado> jCBEliminarEmpleado;
    private javax.swing.JComboBox<Empleado> jCBModificarEmpleado;
    private javax.swing.JLabel jLAgregarProducto;
    private javax.swing.JLabel jLApellidoClienteAgrClien;
    private javax.swing.JLabel jLApellidoElimClien;
    private javax.swing.JLabel jLApellidoElimEmp;
    private javax.swing.JLabel jLApellidoModClien;
    private javax.swing.JLabel jLApellidoModEmp;
    private javax.swing.JLabel jLBtnAgregarCliente;
    private javax.swing.JLabel jLBtnAgregarProd;
    private javax.swing.JLabel jLBtnEliminarElimClien;
    private javax.swing.JLabel jLBtnEliminarElimProd;
    private javax.swing.JLabel jLBtnEliminarEmpleado;
    private javax.swing.JLabel jLBtnModificarModClien;
    private javax.swing.JLabel jLBtnModificarModEmp;
    private javax.swing.JLabel jLBtnModificarModProd;
    private javax.swing.JLabel jLBuscarClienElimClien;
    private javax.swing.JLabel jLBuscarClienModClien;
    private javax.swing.JLabel jLBuscarEmpleadoModEmpl;
    private javax.swing.JLabel jLBuscarProdElimProd;
    private javax.swing.JLabel jLBuscarProdModProd;
    private javax.swing.JLabel jLCargoElimEmp;
    private javax.swing.JLabel jLCargoModEmp;
    private javax.swing.JLabel jLContraseñaElimEmp;
    private javax.swing.JLabel jLContraseñaModEmp;
    private javax.swing.JLabel jLDescripcionAP;
    private javax.swing.JLabel jLDescripcionElimProd;
    private javax.swing.JLabel jLDescripcionModProd;
    private javax.swing.JLabel jLDniElimEmp;
    private javax.swing.JLabel jLDniModEmp;
    private javax.swing.JLabel jLDomicilioClienteAgrClien;
    private javax.swing.JLabel jLDomicilioElimClien;
    private javax.swing.JLabel jLDomicilioModClien;
    private javax.swing.JLabel jLEliminarEmpleado;
    private javax.swing.JLabel jLEmpleados;
    private javax.swing.JLabel jLModificarProd;
    private javax.swing.JLabel jLNombreClienElimClien;
    private javax.swing.JLabel jLNombreClienModClien;
    private javax.swing.JLabel jLNombreClienteAgrClien;
    private javax.swing.JLabel jLNombreEmpElimEmp;
    private javax.swing.JLabel jLNombreEmpModEmp1;
    private javax.swing.JLabel jLNombreProdElimProd;
    private javax.swing.JLabel jLNombreProdModProd;
    private javax.swing.JLabel jLNombreProductoAP;
    private javax.swing.JLabel jLPrecioActualAP;
    private javax.swing.JLabel jLPrecioActualElimProd;
    private javax.swing.JLabel jLPrecioActualModProd;
    private javax.swing.JLabel jLStockAP;
    private javax.swing.JLabel jLStockElimProd;
    private javax.swing.JLabel jLStockModProd;
    private javax.swing.JLabel jLTelefonoClienteAgrClien;
    private javax.swing.JLabel jLTelefonoElimClien;
    private javax.swing.JLabel jLTelefonoModClien;
    private javax.swing.JLabel jLTituloAgrClien;
    private javax.swing.JLabel jLTituloElimEmpleado;
    private javax.swing.JLabel jLTituloEliminarCliente;
    private javax.swing.JLabel jLTituloEliminarProducto;
    private javax.swing.JLabel jLTituloListaClien;
    private javax.swing.JLabel jLTituloListaEmpleados;
    private javax.swing.JLabel jLTituloModClien;
    private javax.swing.JLabel jLTituloModEmpl;
    private javax.swing.JLabel jLUsuarioElimEmp;
    private javax.swing.JLabel jLUsuarioModEmp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLimpiarTablaAaVen;
    private javax.swing.JList<Producto> jListProductosElim;
    private javax.swing.JPanel jPGestionEmpleados;
    private javax.swing.JPanel jPanelCabecera;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JSeparator jSAgrClien1;
    private javax.swing.JSeparator jSAgrClien2;
    private javax.swing.JSeparator jSAgrClien3;
    private javax.swing.JSeparator jSAgrClien4;
    private javax.swing.JSeparator jSAgrProd1;
    private javax.swing.JSeparator jSAgrProd2;
    private javax.swing.JSeparator jSAgrProd3;
    private javax.swing.JSeparator jSAgrProd4;
    private javax.swing.JSeparator jSElimClien1;
    private javax.swing.JSeparator jSElimClien2;
    private javax.swing.JSeparator jSElimClien3;
    private javax.swing.JSeparator jSElimClien4;
    private javax.swing.JSeparator jSElimProd1;
    private javax.swing.JSeparator jSElimProd2;
    private javax.swing.JSeparator jSElimProd3;
    private javax.swing.JSeparator jSElimProd4;
    private javax.swing.JSeparator jSElimProd6;
    private javax.swing.JSeparator jSElimProd7;
    private javax.swing.JSeparator jSModClien1;
    private javax.swing.JSeparator jSModClien2;
    private javax.swing.JSeparator jSModClien3;
    private javax.swing.JSeparator jSModClien4;
    private javax.swing.JSeparator jSModEmp;
    private javax.swing.JSeparator jSModEmp1;
    private javax.swing.JSeparator jSModEmp10;
    private javax.swing.JSeparator jSModEmp11;
    private javax.swing.JSeparator jSModEmp6;
    private javax.swing.JSeparator jSModEmp7;
    private javax.swing.JSeparator jSModEmp8;
    private javax.swing.JSeparator jSModEmp9;
    private javax.swing.JSeparator jSModEmpl5;
    private javax.swing.JSeparator jSModEmpl6;
    private javax.swing.JSeparator jSModProd1;
    private javax.swing.JSeparator jSModProd2;
    private javax.swing.JSeparator jSModProd3;
    private javax.swing.JSeparator jSModProd4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPanePapelera;
    private javax.swing.JSeparator jSep1;
    private javax.swing.JSeparator jSep2;
    private javax.swing.JTextField jTFApellidoClienElimClien;
    private javax.swing.JTextField jTFApellidoClienteAgrClien;
    private javax.swing.JTextField jTFApellidoElimEmp;
    private javax.swing.JTextField jTFApellidoModClien;
    private javax.swing.JTextField jTFApellidoModEmp;
    private javax.swing.JTextField jTFContraseñaElimEmp;
    private javax.swing.JTextField jTFContraseñaModEmp;
    private javax.swing.JTextField jTFDescripcionAgrProd;
    private javax.swing.JTextField jTFDescripcionElimProd;
    private javax.swing.JTextField jTFDescripcionModProd;
    private javax.swing.JTextField jTFDniElimEmp;
    private javax.swing.JTextField jTFDniModEmp;
    private javax.swing.JTextField jTFDomicilioClienteAgrClien;
    private javax.swing.JTextField jTFDomicilioElimClien;
    private javax.swing.JTextField jTFDomicilioModClien;
    private javax.swing.JTextField jTFNombreClienElimClien;
    private javax.swing.JTextField jTFNombreClienModClien;
    private javax.swing.JTextField jTFNombreClienteAgrClien;
    private javax.swing.JTextField jTFNombreEmpleadoElimEmp;
    private javax.swing.JTextField jTFNombreEmpleadoModEmp;
    private javax.swing.JTextField jTFNombreProdElimProd;
    private javax.swing.JTextField jTFNombreProdModProd;
    private javax.swing.JTextField jTFNombreProductoAgrProd;
    private javax.swing.JTextField jTFPrecioActuaElimProd;
    private javax.swing.JTextField jTFPrecioActualAgrProd;
    private javax.swing.JTextField jTFPrecioActualModProd;
    private javax.swing.JTextField jTFStockAgrProd;
    private javax.swing.JTextField jTFStockElimProd;
    private javax.swing.JTextField jTFStockModProd;
    private javax.swing.JTextField jTFTelefonoClienteAg;
    private javax.swing.JTextField jTFTelefonoElimClien;
    private javax.swing.JTextField jTFTelefonoModClien;
    private javax.swing.JTextField jTFUsuarioElimEmp;
    private javax.swing.JTextField jTFUsuarioModEmp;
    private javax.swing.JTable jTablePapelera;
    private javax.swing.JComboBox<Venta> jcbBuscarVenta;
    private javax.swing.JComboBox<Cliente> jcbClienteModifCli;
    private javax.swing.JComboBox<Producto> jcbProVenta;
    private javax.swing.JComboBox<Producto> jcbProXCliente;
    private javax.swing.JComboBox<Producto> jcbProductos;
    private javax.swing.JComboBox<Cliente> jcbVentasXCliente;
    private com.toedter.calendar.JDateChooser jdcAgrVenta;
    private com.toedter.calendar.JDateChooser jdcBusquedaVentas;
    private com.toedter.calendar.JDateChooser jdcElimVenta;
    private com.toedter.calendar.JDateChooser jdcFechaPro;
    private javax.swing.JLabel jlAgrVentas;
    private javax.swing.JLabel jlAgregar;
    private javax.swing.JLabel jlAgregarCliente;
    private javax.swing.JLabel jlAgregarClientes;
    private javax.swing.JLabel jlAgregarEmpl;
    private javax.swing.JLabel jlAgregarEmpleado;
    private javax.swing.JLabel jlAgregarPro;
    private javax.swing.JLabel jlAgregarProdTabla;
    private javax.swing.JLabel jlBorrarVenta;
    private javax.swing.JLabel jlBuscarVenta;
    private javax.swing.JLabel jlBusqueda;
    private javax.swing.JLabel jlBusquedaCliente;
    private javax.swing.JLabel jlBusquedaEmp;
    private javax.swing.JLabel jlCabecera;
    private javax.swing.JLabel jlCantidadVenta;
    private javax.swing.JLabel jlCerrarSesion;
    private javax.swing.JLabel jlClentesIn;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JLabel jlClientes;
    private javax.swing.JLabel jlClientesxPro;
    private javax.swing.JLabel jlDetalles;
    private javax.swing.JLabel jlDetallesVenta;
    private javax.swing.JLabel jlEliminar;
    private javax.swing.JLabel jlEliminarCliente;
    private javax.swing.JLabel jlEliminarClientes;
    private javax.swing.JLabel jlEliminarEmp;
    private javax.swing.JLabel jlEliminarEmpleado;
    private javax.swing.JLabel jlEliminarPapelera;
    private javax.swing.JLabel jlEliminarPro;
    private javax.swing.JLabel jlEliminarProdTabla1;
    private javax.swing.JLabel jlEliminarVenta;
    private javax.swing.JLabel jlEliminarVentaBorrar;
    private javax.swing.JLabel jlEmpleadoPapelera;
    private javax.swing.JLabel jlFechaVenta;
    private javax.swing.JLabel jlFechaVentaEliminar;
    private javax.swing.JLabel jlGestionClientes;
    private javax.swing.JLabel jlGestionDe;
    private javax.swing.JLabel jlGestionEmpleado1;
    private javax.swing.JLabel jlGestionPro;
    private javax.swing.JLabel jlGestionV;
    private javax.swing.JLabel jlIconAgreCli;
    private javax.swing.JLabel jlIconAgreCli1;
    private javax.swing.JLabel jlIconAgreEmpl;
    private javax.swing.JLabel jlIconBuscar;
    private javax.swing.JLabel jlIconBuscar1;
    private javax.swing.JLabel jlIconBuscar2;
    private javax.swing.JLabel jlIconBuscarVenta;
    private javax.swing.JLabel jlIconCliente;
    private javax.swing.JLabel jlIconEliCli;
    private javax.swing.JLabel jlIconEliCli1;
    private javax.swing.JLabel jlIconEliEmpl;
    private javax.swing.JLabel jlIconModCli;
    private javax.swing.JLabel jlIconModCli1;
    private javax.swing.JLabel jlIconModEmpl;
    private javax.swing.JLabel jlIconPro;
    private javax.swing.JLabel jlIconVenta;
    private javax.swing.JLabel jlIconVentaAgr;
    private javax.swing.JLabel jlIconoAgregarPro;
    private javax.swing.JLabel jlIconoAgregarPro1;
    private javax.swing.JLabel jlIconoBorrarPro;
    private javax.swing.JLabel jlIconoBorrarPro1;
    private javax.swing.JLabel jlIconoModPro;
    private javax.swing.JLabel jlIconoModPro1;
    private javax.swing.JLabel jlImgBusqueda;
    private javax.swing.JLabel jlImgBusquedaEmpl;
    private javax.swing.JLabel jlInicio;
    private javax.swing.JLabel jlListaProAc;
    private javax.swing.JLabel jlListaVenta;
    private javax.swing.JLabel jlListar;
    private javax.swing.JLabel jlListarCliente;
    private javax.swing.JLabel jlListarEmpleado;
    private javax.swing.JLabel jlListarVenta;
    private javax.swing.JLabel jlMinimizar;
    private javax.swing.JLabel jlModClientes;
    private javax.swing.JLabel jlModEmpl;
    private javax.swing.JLabel jlModPro;
    private javax.swing.JLabel jlModificar;
    private javax.swing.JLabel jlModificarCliente;
    private javax.swing.JLabel jlModificarEmpleado;
    private javax.swing.JLabel jlNombreEmp;
    private javax.swing.JLabel jlNombreEmpleadoEliminar;
    private javax.swing.JLabel jlNombreProEliminar;
    private javax.swing.JLabel jlNombreUsuario;
    private javax.swing.JLabel jlPapelera;
    private javax.swing.JLabel jlPapeleraMenu;
    private javax.swing.JLabel jlPrecioVenta;
    private javax.swing.JLabel jlProIn;
    private javax.swing.JLabel jlProXFecha;
    private javax.swing.JLabel jlProductoPapelera;
    private javax.swing.JLabel jlProductos;
    private javax.swing.JLabel jlRealizarVenta;
    private javax.swing.JLabel jlRegistrar;
    private javax.swing.JLabel jlRestaurarPapelera;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JLabel jlSelecFecha;
    private javax.swing.JLabel jlSelecFechaVenta;
    private javax.swing.JLabel jlSelecPro;
    private javax.swing.JLabel jlSelecProVenta;
    private javax.swing.JLabel jlTelCliDetalles;
    private javax.swing.JLabel jlTelCliente;
    private javax.swing.JLabel jlVentaIcon1;
    private javax.swing.JLabel jlVentaIcon2;
    private javax.swing.JLabel jlVentaIcon3;
    private javax.swing.JLabel jlVentaIconEliminar;
    private javax.swing.JLabel jlVentaPapelera;
    private javax.swing.JLabel jlVentas;
    private javax.swing.JLabel jlVentasCli;
    private javax.swing.JLabel jlVentasIn;
    private javax.swing.JTable jtListClien;
    private javax.swing.JTable jtListEmpleado;
    private javax.swing.JTable jtListaDetalles;
    private javax.swing.JTable jtListaGuardVentas;
    private javax.swing.JTable jtListaPro;
    private javax.swing.JTable jtListaVentas;
    private javax.swing.JTextField jtfBuscador;
    private javax.swing.JTextField jtfBuscadorClienListClien;
    private javax.swing.JTextField jtfBuscadorEmpleadosListEmp;
    private javax.swing.JTextField jtfCantidadVenta;
    private javax.swing.JTextField jtfNombreEmpVenta;
    private javax.swing.JTextField jtfNombreEmpleadoEliminar;
    private javax.swing.JTextField jtfPrecioVenta;
    private javax.swing.JTextField jtfTelCliEliminar;
    private javax.swing.JTextField jtfTelCliente;
    private javax.swing.JLabel jtfTelClienteEliminar;
    private javax.swing.JPanel jtpAgrClien;
    private javax.swing.JPanel jtpAgrVenta;
    private javax.swing.JPanel jtpAgregarPro;
    private javax.swing.JPanel jtpClientes;
    private javax.swing.JPanel jtpDetallesVenta;
    private javax.swing.JPanel jtpElimClien;
    private javax.swing.JPanel jtpEliminarEmpleado;
    private javax.swing.JPanel jtpEliminarPro;
    private javax.swing.JPanel jtpEliminarVenta;
    private javax.swing.JTabbedPane jtpEscritorio;
    private javax.swing.JPanel jtpInicio;
    private javax.swing.JPanel jtpListClien;
    private javax.swing.JPanel jtpListaEmp;
    private javax.swing.JPanel jtpListaP;
    private javax.swing.JPanel jtpListaVentas;
    private javax.swing.JPanel jtpModClien;
    private javax.swing.JPanel jtpModPro;
    private javax.swing.JPanel jtpModificarEmpleado;
    private javax.swing.JPanel jtpPapelera;
    private javax.swing.JPanel jtpProductos;
    private javax.swing.JPanel jtpVentas;
    private javax.swing.JLabel rectangulo1Pro;
    private javax.swing.JLabel rectangulo2Pro;
    private javax.swing.JLabel rectangulo3Pro;
    private javax.swing.JLabel rectanguloAgEmpl;
    private javax.swing.JLabel rectanguloCli1;
    private javax.swing.JLabel rectanguloCli2;
    private javax.swing.JLabel rectanguloCli3;
    private javax.swing.JLabel rectanguloElimEmpl;
    private javax.swing.JLabel rectanguloIn1;
    private javax.swing.JLabel rectanguloIn2;
    private javax.swing.JLabel rectanguloIn3;
    private javax.swing.JLabel rectanguloModifEmpl;
    private javax.swing.JLabel rectanguloV1;
    private javax.swing.JLabel rectanguloV2;
    private javax.swing.JLabel rectanguloV3;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel textA;
    private javax.swing.JLabel textClienteA;
    private javax.swing.JLabel textClienteE;
    private javax.swing.JLabel textClienteM;
    private javax.swing.JLabel textE;
    private javax.swing.JLabel textEmpleadoA;
    private javax.swing.JLabel textEmpleadoElim;
    private javax.swing.JLabel textEmpleadoM;
    private javax.swing.JLabel textM;
    private javax.swing.JLabel textVentaA;
    private javax.swing.JLabel textVentaD;
    private javax.swing.JLabel textVentaE;
    private javax.swing.JLabel verMasC;
    private javax.swing.JLabel verMasP;
    private javax.swing.JLabel verMasV;
    // End of variables declaration//GEN-END:variables

    private void borrarFila() {
        for (int f = jtListaPro.getRowCount() - 1; f >= 0; f--) {
            Modelo.removeRow(f);
        }
    }

    private void borrarFilaC() {
        for (int i = jtListClien.getRowCount() - 1; i >= 0; i--) {
            Modelo1.removeRow(i);
        }
    }

    private void borrarFilaE() {
        for (int i = jtListEmpleado.getRowCount() - 1; i >= 0; i--) {
            Modelo2.removeRow(i);
        }
    }

    private void borrarFilaDV() {
        for (int i = jtListaDetalles.getRowCount() - 1; i >= 0; i--) {
            Modelo3.removeRow(i);
        }
    }

    private void borrarFilaV() {
        for (int i = jtListaVentas.getRowCount() - 1; i >= 0; i--) {
            Modelo4.removeRow(i);
        }
    }

    private void borrarFilaPV() {
        jTablePapelera.setModel(ModeloV);
        for (int i = jTablePapelera.getRowCount() - 1; i >= 0; i--) {
            ModeloV.removeRow(i);
        }
    }

    private void borrarFilaPP() {
        jTablePapelera.setModel(ModeloP);
        for (int i = jTablePapelera.getRowCount() - 1; i >= 0; i--) {
            ModeloP.removeRow(i);
        }
    }

    private void borrarFilaPE() {
        jTablePapelera.setModel(ModeloE);
        for (int i = jTablePapelera.getRowCount() - 1; i >= 0; i--) {
            ModeloE.removeRow(i);
        }
    }

    private void borrarFilaPC() {
        jTablePapelera.setModel(ModeloC);
        for (int i = jTablePapelera.getRowCount() - 1; i >= 0; i--) {
            ModeloC.removeRow(i);
        }
    }

    private void borrarFilaAPV() {
        for (int i = jtListaGuardVentas.getRowCount() - 1; i >= 0; i--) {
            Modelo5.removeRow(i);
        }
    }

    private void llenarText() {
        text1.setText("<html>Registrar productos: Los usuarios podrán agregar nuevos productos al inventario proporcionando información como nombre, descripción, precio y cantidad disponible</html>");
        text2.setText("<html>Realizar ventas: Los usuarios podrán registrar las ventas de productos a los clientes. el cliente que realiza la compra y la fecha de venta</html>");
        text3.setText("<html>Administrar Clientes: Los usuarios podrán agregar, modificar y eliminar información de los clientes, como nombre, apellido, dirección y número de teléfono</html>");
        textA.setText("<html>Ingresar nuevos productos a la base de datos</html>");
        textM.setText("<html>Actualizar los datos de los productos en la base de datos</html>");
        textE.setText("<html>Borrado logico de los productos en la base de datos</html>");
        textClienteA.setText("<html>Registrar Clientes: Permite agregar Clientes nuevos, ingresando nombre, apellido....</html>");
        textClienteM.setText("<html>Modificar datos: Permite modificar la informacion almacenda de los Clientes</html>");
        textClienteE.setText("<html>Eliminar Clientes: Permite eliminar a los Clientes de manera Lógica</html>");
        textVentaA.setText("<html>Registrar Venta: Permite ingresar los datos de una venta como producto, precio y cantidad</html>");
        textVentaD.setText("<html>Detallar Venta: Lista completa de los datos de una venta registrada</html>");
        textVentaE.setText("<html>Eliminar Venta: Permite dar de baja el registro de una venta para su posterior eliminación");
        textEmpleadoA.setText("<html>Registre un nuevo empleado para iniciar una cuenta en el programa</html>");
        textEmpleadoM.setText("<html>Modifique los datos personales y de Usuario de los empleados</html>");
        textEmpleadoElim.setText("<html>Permite dar de baja las cuentas de los empleados fuera de servicio</html>");
    }

    private void llenarCombo() {
        jcbProductos.removeAllItems();
        jCBBuscarProdElimProd.removeAllItems();
        jcbProVenta.removeAllItems();
        jcbProXCliente.removeAllItems();
        for (Producto pro : pd.listarProducto()) {
            jcbProductos.addItem(pro);
            jCBBuscarProdElimProd.addItem(pro);
            jcbProVenta.addItem(pro);
            jcbProXCliente.addItem(pro);
        }
    }

    private void llenarComboCliente() {
        jcbClienteModifCli.removeAllItems();
        jCBBuscarClienElimClien.removeAllItems();
        jcbVentasXCliente.removeAllItems();
        for (Cliente cli : cD.listarClientes()) {
            jcbClienteModifCli.addItem(cli);
            jCBBuscarClienElimClien.addItem(cli);
            jcbVentasXCliente.addItem(cli);
        }
    }

    private void llenarComboV() {
        jcbBuscarVenta.removeAllItems();
        for (Venta ven : vd.listaVenta()) {
            jcbBuscarVenta.addItem(ven);
        }
    }

    private void llenarComboEmpleado() {
        try {
            jCBModificarEmpleado.removeAllItems();
            jCBEliminarEmpleado.removeAllItems();
            for (Empleado empl : ed.listarEmpleado()) {
                jCBModificarEmpleado.addItem(empl);
                jCBEliminarEmpleado.addItem(empl);
            }
        } catch (NullPointerException ex) {
        }
    }

    private void llenarComboCargo() {
        String c1 = "Vendedor", c2 = "Supervisor";
        jCBCargoModifEmp.addItem(c1);
        jCBCargoModifEmp.addItem(c2);
    }

    private void borrarCamposAgCliente() {
        jTFApellidoClienteAgrClien.setText("");
        jTFNombreClienteAgrClien.setText("");
        jTFDomicilioClienteAgrClien.setText("");
        jTFTelefonoClienteAg.setText("");
    }

    private void borrarCamposAgrProd() {
        jTFNombreProductoAgrProd.setText("");
        jTFPrecioActualAgrProd.setText("");
        jTFDescripcionAgrProd.setText("");
        jTFStockAgrProd.setText("");
    }

    private void borrarCamposAgrVen() {
        jtfCantidadVenta.setText("");
        jtfTelCliente.setText("");
        jtfNombreEmpVenta.setText("");
    }

    private void controlLetras(java.awt.event.KeyEvent evt) {
        if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    private void controlNumeros(java.awt.event.KeyEvent evt) {
        if (Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }

    private void empleadosVisible() {         // VALIDA CARGO DEL QUE HIZO LOGIN!!!!!!
        if (Login.empleado.getCargo().equalsIgnoreCase("supervisor")) {
            jLEmpleados.setVisible(true);
            jlPapeleraMenu.setVisible(true);
        } else {
            jLEmpleados.setVisible(false);
            jlPapeleraMenu.setVisible(false);
        }
    }

    private void llenarTablaVen() {
        borrarFilaV();
        for (DetalleVenta v : dvd.listaDV()) {
            Modelo4.addRow(new Object[]{v.getIdDetalleVenta(), v.getIdVenta(),
                v.getProducto().getNombreProducto(), v.getVenta().getCliente().getTelefono(),
                v.getVenta().getFechaVenta(), v.getCantidad(), v.getPrecioVenta()
            });
        }
    }

    private void llenarTablaEmp() {
        borrarFilaE();
        for (Empleado emp : ed.listarEmpleado()) {
            Modelo2.addRow(new Object[]{emp.getIdEmpleado(), emp.getApellido(),
                emp.getNombre(), emp.getDni(), emp.getCargo(),
                emp.getUsuario(), emp.getContraenia()
            });
        }
    }

    private void llenarTablaCli() {
        borrarFilaC();
        for (Cliente c : cD.listarClientes()) {
            Modelo1.addRow(new Object[]{c.getIdCliente(), c.getApellido(), c.getNombre(), 
                c.getDomicilio(), c.getTelefono()
            });
        }
    }

    private void totalPago() {
        try {
            precioTotal = 0;
            int fila = jtListaGuardVentas.getRowCount();
            for (int i = 0; i < fila; i++) {
                double resultado = Double.parseDouble(String.valueOf(jtListaGuardVentas.getModel().getValueAt(i, 5)));
                precioTotal += resultado;
            }
            jtfPrecioVenta.setText(precioTotal + "");
        } catch (NumberFormatException ex) {
            precioTotal = 0;
        }
    }
}
