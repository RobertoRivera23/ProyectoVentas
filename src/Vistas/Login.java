/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.EmpleadoData;
import Entidades.Empleado;
import static Vistas.Menu.verdeBase;
import static Vistas.Menu.verdeClaro;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ROMI
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    int xMouse, yMouse;
    public static Empleado empleado;
    private int contadorIntentos = 0;
    private int contadorUsuario = 0;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPBackground = new javax.swing.JPanel();
        jlFravemax = new javax.swing.JLabel();
        jlBanner1 = new javax.swing.JLabel();
        jPCuerpo = new javax.swing.JPanel();
        jLUsuario = new javax.swing.JLabel();
        jLContraseña = new javax.swing.JLabel();
        jLCargo = new javax.swing.JLabel();
        jCBCargo = new javax.swing.JComboBox<>();
        jTFUsuario = new javax.swing.JTextField();
        jTContraseña = new javax.swing.JTextField();
        jLBtnIniciarSesion = new javax.swing.JLabel();
        jLIconoLogin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLMinimiza = new javax.swing.JLabel();
        jLCierra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(512, 450));

        jPBackground.setPreferredSize(new java.awt.Dimension(570, 400));
        jPBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlFravemax.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlFravemax.setForeground(new java.awt.Color(255, 255, 255));
        jlFravemax.setText("FRAVEMAX");
        jPBackground.add(jlFravemax, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, -1));

        jlBanner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Banner FM.png"))); // NOI18N
        jPBackground.add(jlBanner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

        jPCuerpo.setBackground(new java.awt.Color(255, 255, 255));
        jPCuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLUsuario.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLUsuario.setForeground(new java.awt.Color(0, 150, 136));
        jLUsuario.setText("Usuario:");
        jPCuerpo.add(jLUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLContraseña.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLContraseña.setForeground(new java.awt.Color(0, 150, 136));
        jLContraseña.setText("Contraseña:");
        jPCuerpo.add(jLContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLCargo.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLCargo.setForeground(new java.awt.Color(0, 150, 136));
        jLCargo.setText("Cargo:");
        jPCuerpo.add(jLCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jCBCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Supervisor", "Vendedor" }));
        jCBCargo.setSelectedItem(null);
        jPCuerpo.add(jCBCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 170, -1));

        jTFUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFUsuarioMouseClicked(evt);
            }
        });
        jPCuerpo.add(jTFUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 170, -1));

        jTContraseña.setForeground(new java.awt.Color(51, 51, 76));
        jPCuerpo.add(jTContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 170, -1));

        jLBtnIniciarSesion.setBackground(new java.awt.Color(0, 150, 136));
        jLBtnIniciarSesion.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLBtnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jLBtnIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBtnIniciarSesion.setText("Iniciar sesión");
        jLBtnIniciarSesion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLBtnIniciarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), null, null));
        jLBtnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLBtnIniciarSesion.setOpaque(true);
        jLBtnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBtnIniciarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBtnIniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBtnIniciarSesionMouseExited(evt);
            }
        });
        jPCuerpo.add(jLBtnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 366, 117, 30));

        jLIconoLogin.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLIconoLogin.setForeground(new java.awt.Color(0, 150, 136));
        jLIconoLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLIconoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/usuarios-alt.png"))); // NOI18N
        jLIconoLogin.setText("Login");
        jLIconoLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLIconoLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPCuerpo.add(jLIconoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 140, 120));

        jPanel1.setBackground(new java.awt.Color(0, 150, 136));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLMinimiza.setBackground(new java.awt.Color(0, 150, 136));
        jLMinimiza.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLMinimiza.setForeground(new java.awt.Color(255, 255, 255));
        jLMinimiza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLMinimiza.setText("_");
        jLMinimiza.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLMinimiza.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLMinimiza.setOpaque(true);
        jLMinimiza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLMinimizaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLMinimizaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLMinimizaMouseExited(evt);
            }
        });
        jPanel1.add(jLMinimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 30, 30));

        jLCierra.setBackground(new java.awt.Color(0, 150, 136));
        jLCierra.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLCierra.setForeground(new java.awt.Color(255, 255, 255));
        jLCierra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCierra.setText("X");
        jLCierra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLCierra.setOpaque(true);
        jLCierra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCierraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLCierraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLCierraMouseExited(evt);
            }
        });
        jPanel1.add(jLCierra, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 40, 30));

        jPCuerpo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, 0, 520, 30));

        jPBackground.add(jPCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 350, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFUsuarioMouseClicked
        if (jTFUsuario.getText().equals("Ingrese su usuario")) {
            jTFUsuario.setText("");
            jTFUsuario.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTFUsuarioMouseClicked

    private void jLCierraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCierraMouseExited
        jLCierra.setOpaque(false);
        jLCierra.setBackground(new Color(0, 150, 136));
    }//GEN-LAST:event_jLCierraMouseExited

    private void jLCierraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCierraMouseEntered
        jLCierra.setOpaque(true);
        jLCierra.setBackground(Color.red);
    }//GEN-LAST:event_jLCierraMouseEntered

    private void jLCierraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCierraMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLCierraMouseClicked

    private void jLMinimizaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMinimizaMouseExited
        jLMinimiza.setOpaque(false);
        jLMinimiza.setBackground(new Color(0, 150, 136));
    }//GEN-LAST:event_jLMinimizaMouseExited

    private void jLMinimizaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMinimizaMouseEntered
        jLMinimiza.setOpaque(true);
        jLMinimiza.setBackground(new Color(10, 160, 140));
    }//GEN-LAST:event_jLMinimizaMouseEntered

    private void jLMinimizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMinimizaMouseClicked
        this.setExtendedState(1);
    }//GEN-LAST:event_jLMinimizaMouseClicked

    private void jLBtnIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnIniciarSesionMouseEntered
        jLBtnIniciarSesion.setBackground(verdeClaro);
    }//GEN-LAST:event_jLBtnIniciarSesionMouseEntered

    private void jLBtnIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnIniciarSesionMouseExited
        jLBtnIniciarSesion.setBackground(verdeBase);
    }//GEN-LAST:event_jLBtnIniciarSesionMouseExited

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jLBtnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBtnIniciarSesionMouseClicked
        int cont = 0;
        boolean usuario = false;
        
        System.out.println("contInt " + contadorIntentos);
        EmpleadoData eD = new EmpleadoData();

        if (jTFUsuario.getText().isEmpty() || jTFUsuario.getText().isEmpty() || jCBCargo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
        } else {
            try {
                for (Empleado emp : eD.listarEmpleado()) {
                    if (emp.getUsuario().equals(jTFUsuario.getText())) { // Valida Usuario para Bloqueo
                        contadorUsuario += 1;
                        usuario = true;
                        if (emp.getContraenia().equals(jTContraseña.getText())
                                && emp.getCargo().equals(jCBCargo.getSelectedItem())) {
                            cont++;
                            empleado = new Empleado();
                            empleado.setIdEmpleado(emp.getIdEmpleado());
                            empleado.setApellido(emp.getApellido());
                            empleado.setNombre(emp.getNombre());
                            empleado.setDni(emp.getDni());
                            empleado.setCargo(emp.getCargo());
                            empleado.setUsuario(emp.getUsuario());
                            empleado.setContraenia(emp.getContraenia());
                            empleado.setEstado(emp.isEstado());
                            //Instanciamos Menu 
                            Menu menu = new Menu();
                            menu.setVisible(true);
                            dispose();
                            break;
                        }
                    }
                }
            } catch (NullPointerException ex) {
            }

            if (usuario == false) {
                JOptionPane.showMessageDialog(null, "El usuario ingresado es incorrecto");
            }

            if (cont == 0 && usuario == true) {
                JOptionPane.showMessageDialog(null, "Contraseña y/o Cargo, son incorrectos");
            }
            // Avisa posible bloqueo de Usuario
            if (contadorIntentos == 2 && usuario == false) {
                int opcion = JOptionPane.showConfirmDialog(this, "Si vuleve a equivocarse, su cuenta sera bloqueada!", "¿ Desea Volver a intentar?", JOptionPane.YES_NO_OPTION);
                switch (opcion) {
                    case 0:
                        break;
                    case 1:
                        contadorIntentos = 0;
                        dispose();
                }
            }

            if (contadorIntentos >= 3 && usuario == false) {
                JOptionPane.showMessageDialog(null, "Supero la cantidad de intentos. solicite ayuda al supervisor");
                this.dispose();
            }
            //Bloquea Usuario
            if (contadorUsuario >= 3 && usuario == true) {
                JOptionPane.showMessageDialog(null, "Supero la cantidad de intentos, Cuenta Bloqueda. solicite ayuda al supervisor");
                for (Empleado emplElim : eD.listarEmpleado()) {
                    if (emplElim.getUsuario().equalsIgnoreCase(jTFUsuario.getText())) {
                        eD.eliminarEmpleadoPorId(emplElim.getIdEmpleado());
                    }
                }
                dispose();
            }
//            
        }
    }//GEN-LAST:event_jLBtnIniciarSesionMouseClicked

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
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBCargo;
    private javax.swing.JLabel jLBtnIniciarSesion;
    private javax.swing.JLabel jLCargo;
    private javax.swing.JLabel jLCierra;
    private javax.swing.JLabel jLContraseña;
    private javax.swing.JLabel jLIconoLogin;
    private javax.swing.JLabel jLMinimiza;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JPanel jPBackground;
    private javax.swing.JPanel jPCuerpo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTContraseña;
    private javax.swing.JTextField jTFUsuario;
    private javax.swing.JLabel jlBanner1;
    private javax.swing.JLabel jlFravemax;
    // End of variables declaration//GEN-END:variables
}
