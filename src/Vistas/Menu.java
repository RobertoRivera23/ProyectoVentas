/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Color;

/**
 *
 * @author ROMI
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
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
        jPanelFravemax = new javax.swing.JPanel();
        jPanelUsuario = new javax.swing.JPanel();
        jlNombreUsuario = new javax.swing.JLabel();
        jlFravemax = new javax.swing.JLabel();
        jPanelOpciones = new javax.swing.JPanel();
        jPanelProductos = new javax.swing.JPanel();
        jlProductos = new javax.swing.JLabel();
        jPanelClientes = new javax.swing.JPanel();
        jlClientes = new javax.swing.JLabel();
        jPanelVentas = new javax.swing.JPanel();
        jlVentas = new javax.swing.JLabel();
        jPanelCerraSesion = new javax.swing.JPanel();
        jlCerrarSesion = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGround.setBackground(new java.awt.Color(255, 255, 255));

        jPanelFravemax.setBackground(new java.awt.Color(0, 150, 136));

        jPanelUsuario.setBackground(new java.awt.Color(0, 150, 136));

        jlNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlNombreUsuario.setText("nombre de usuario");

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jlNombreUsuario)
                .addGap(54, 54, 54))
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jlNombreUsuario)
                .addContainerGap())
        );

        jlFravemax.setForeground(new java.awt.Color(255, 255, 255));
        jlFravemax.setText("FRAVEMAX");

        javax.swing.GroupLayout jPanelFravemaxLayout = new javax.swing.GroupLayout(jPanelFravemax);
        jPanelFravemax.setLayout(jPanelFravemaxLayout);
        jPanelFravemaxLayout.setHorizontalGroup(
            jPanelFravemaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFravemaxLayout.createSequentialGroup()
                .addComponent(jPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 495, Short.MAX_VALUE)
                .addComponent(jlFravemax)
                .addGap(47, 47, 47))
        );
        jPanelFravemaxLayout.setVerticalGroup(
            jPanelFravemaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFravemaxLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFravemaxLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jlFravemax)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelOpciones.setBackground(new java.awt.Color(51, 51, 76));

        jPanelProductos.setBackground(new java.awt.Color(51, 51, 76));

        jlProductos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlProductos.setForeground(new java.awt.Color(255, 255, 255));
        jlProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlProductos.setText("Productos");
        jlProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlProductosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        jPanelClientes.setBackground(new java.awt.Color(51, 51, 76));

        jlClientes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlClientes.setForeground(new java.awt.Color(255, 255, 255));
        jlClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlClientes.setText("Clientes");
        jlClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlClientesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClientesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClientesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelVentas.setBackground(new java.awt.Color(51, 51, 76));

        jlVentas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlVentas.setForeground(new java.awt.Color(255, 255, 255));
        jlVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlVentas.setText("Ventas");
        jlVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlVentasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelVentasLayout = new javax.swing.GroupLayout(jPanelVentas);
        jPanelVentas.setLayout(jPanelVentasLayout);
        jPanelVentasLayout.setHorizontalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlVentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelVentasLayout.setVerticalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentasLayout.createSequentialGroup()
                .addComponent(jlVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelCerraSesion.setBackground(new java.awt.Color(51, 51, 76));

        jlCerrarSesion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jlCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCerrarSesion.setText("Cerrar Sesion");
        jlCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlCerrarSesionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelCerraSesionLayout = new javax.swing.GroupLayout(jPanelCerraSesion);
        jPanelCerraSesion.setLayout(jPanelCerraSesionLayout);
        jPanelCerraSesionLayout.setHorizontalGroup(
            jPanelCerraSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCerraSesionLayout.setVerticalGroup(
            jPanelCerraSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelCerraSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addComponent(jPanelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198)
                .addComponent(jPanelCerraSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFravemax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(jPanelFravemax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductosMouseEntered
        jPanelProductos.setBackground(new Color(66,66,76));
    }//GEN-LAST:event_jlProductosMouseEntered

    private void jlProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductosMouseExited
        jPanelProductos.setBackground(new Color(51,51,76));
    }//GEN-LAST:event_jlProductosMouseExited

    private void jlVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentasMouseEntered
        jPanelVentas.setBackground(new Color(66,66,76));
    }//GEN-LAST:event_jlVentasMouseEntered

    private void jlVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVentasMouseExited
        jPanelVentas.setBackground(new Color(51,51,76));
    }//GEN-LAST:event_jlVentasMouseExited

    private void jlClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClientesMouseEntered
        jPanelClientes.setBackground(new Color(66,66,76));
    }//GEN-LAST:event_jlClientesMouseEntered

    private void jlClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlClientesMouseExited
        jPanelClientes.setBackground(new Color(51,51,76));
    }//GEN-LAST:event_jlClientesMouseExited

    private void jlCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarSesionMouseEntered
        jPanelCerraSesion.setBackground(new Color(66,66,76));
    }//GEN-LAST:event_jlCerrarSesionMouseEntered

    private void jlCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarSesionMouseExited
        jPanelCerraSesion.setBackground(new Color(51,51,76));
    }//GEN-LAST:event_jlCerrarSesionMouseExited

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JPanel jPanelCerraSesion;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelFravemax;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JPanel jPanelVentas;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlCerrarSesion;
    private javax.swing.JLabel jlClientes;
    private javax.swing.JLabel jlFravemax;
    private javax.swing.JLabel jlNombreUsuario;
    private javax.swing.JLabel jlProductos;
    private javax.swing.JLabel jlVentas;
    // End of variables declaration//GEN-END:variables
}