/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import static Vistas.Menu.verdeBase;
import static Vistas.Menu.verdeClaro;
import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author rober
 */
public class Registro extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;
    
    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarCombo();
        jRMostrar.setSelected(false); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPFondo = new javax.swing.JPanel();
        jlFravemax = new javax.swing.JLabel();
        jlBanner2 = new javax.swing.JLabel();
        jPFravemax = new javax.swing.JPanel();
        jLMinimiza = new javax.swing.JLabel();
        jLCierra = new javax.swing.JLabel();
        jPDatos = new javax.swing.JPanel();
        jLApellido = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLNombre1 = new javax.swing.JLabel();
        jLCargo = new javax.swing.JLabel();
        jLUsuario = new javax.swing.JLabel();
        jLContraseña = new javax.swing.JLabel();
        jTFApellido = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jTFDni = new javax.swing.JTextField();
        jTFUsuario = new javax.swing.JTextField();
        jCBCargo = new javax.swing.JComboBox<>();
        jRMostrar = new javax.swing.JRadioButton();
        jPContraseña = new javax.swing.JPasswordField();
        jlCargar = new javax.swing.JLabel();
        jLVolver = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(512, 450));
        setSize(new java.awt.Dimension(512, 450));

        jPFondo.setPreferredSize(new java.awt.Dimension(512, 450));
        jPFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlFravemax.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jlFravemax.setForeground(new java.awt.Color(255, 255, 255));
        jlFravemax.setText("FRAVEMAX");
        jPFondo.add(jlFravemax, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, -1));

        jlBanner2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Banner FM.png"))); // NOI18N
        jPFondo.add(jlBanner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 450));

        jPFravemax.setBackground(new java.awt.Color(0, 150, 136));
        jPFravemax.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPFravemaxMouseDragged(evt);
            }
        });
        jPFravemax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPFravemaxMousePressed(evt);
            }
        });
        jPFravemax.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLMinimiza.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLMinimiza.setForeground(new java.awt.Color(255, 255, 255));
        jLMinimiza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLMinimiza.setText("_");
        jLMinimiza.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLMinimiza.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPFravemax.add(jLMinimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 30, 30));

        jLCierra.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLCierra.setForeground(new java.awt.Color(255, 255, 255));
        jLCierra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCierra.setText("X");
        jLCierra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPFravemax.add(jLCierra, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 40, 30));

        jPFondo.add(jPFravemax, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 30));

        jPDatos.setBackground(new java.awt.Color(255, 255, 255));
        jPDatos.setForeground(new java.awt.Color(255, 255, 255));
        jPDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLApellido.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLApellido.setForeground(new java.awt.Color(0, 150, 136));
        jLApellido.setText("Apellido:");
        jPDatos.add(jLApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLNombre.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLNombre.setForeground(new java.awt.Color(0, 150, 136));
        jLNombre.setText("Nombre:");
        jPDatos.add(jLNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLNombre1.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLNombre1.setForeground(new java.awt.Color(0, 150, 136));
        jLNombre1.setText("Dni:");
        jPDatos.add(jLNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLCargo.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLCargo.setForeground(new java.awt.Color(0, 150, 136));
        jLCargo.setText("Cargo:");
        jPDatos.add(jLCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLUsuario.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLUsuario.setForeground(new java.awt.Color(0, 150, 136));
        jLUsuario.setText("Usuario:");
        jPDatos.add(jLUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLContraseña.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLContraseña.setForeground(new java.awt.Color(0, 150, 136));
        jLContraseña.setText("Contraseña:");
        jPDatos.add(jLContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jTFApellido.setForeground(new java.awt.Color(51, 51, 76));
        jTFApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFApellidoKeyTyped(evt);
            }
        });
        jPDatos.add(jTFApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 170, -1));

        jTFNombre.setForeground(new java.awt.Color(51, 51, 76));
        jTFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreKeyTyped(evt);
            }
        });
        jPDatos.add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 170, -1));

        jTFDni.setForeground(new java.awt.Color(51, 51, 76));
        jTFDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFDniKeyTyped(evt);
            }
        });
        jPDatos.add(jTFDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 170, -1));

        jTFUsuario.setForeground(new java.awt.Color(51, 51, 76));
        jPDatos.add(jTFUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 170, -1));

        jPDatos.add(jCBCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 170, -1));

        jRMostrar.setBackground(new java.awt.Color(51, 51, 76));
        jRMostrar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jRMostrar.setForeground(new java.awt.Color(0, 150, 136));
        jRMostrar.setText("Mostrar");
        jRMostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRMostrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRMostrar.setOpaque(false);
        jRMostrar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jRMostrar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jRMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRMostrarMousePressed(evt);
            }
        });
        jPDatos.add(jRMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 80, 20));
        jPDatos.add(jPContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 120, -1));

        jlCargar.setBackground(new java.awt.Color(0, 150, 136));
        jlCargar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jlCargar.setForeground(new java.awt.Color(255, 255, 255));
        jlCargar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCargar.setText("Cargar");
        jlCargar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlCargar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), null, null));
        jlCargar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlCargar.setOpaque(true);
        jlCargar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlCargarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlCargarMouseExited(evt);
            }
        });
        jPDatos.add(jlCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 80, 30));

        jLVolver.setBackground(new java.awt.Color(0, 150, 136));
        jLVolver.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLVolver.setForeground(new java.awt.Color(255, 255, 255));
        jLVolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLVolver.setText("Volver");
        jLVolver.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), null, null));
        jLVolver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLVolver.setOpaque(true);
        jLVolver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLVolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLVolverMouseExited(evt);
            }
        });
        jPDatos.add(jLVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 80, 30));

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 150, 136));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/usuarios-alt.png"))); // NOI18N
        jLabel4.setText("Formulario de Registro");
        jLabel4.setIconTextGap(40);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 290, 90));

        jPFondo.add(jPDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 28, 350, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLMinimizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMinimizaMouseClicked
        this.setExtendedState(1);
    }//GEN-LAST:event_jLMinimizaMouseClicked

    private void jLMinimizaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMinimizaMouseEntered
        jLMinimiza.setOpaque(true);
        jLMinimiza.setBackground(new Color(10, 160, 140));
    }//GEN-LAST:event_jLMinimizaMouseEntered

    private void jLMinimizaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMinimizaMouseExited
        jLMinimiza.setOpaque(false);
        jLMinimiza.setBackground(new Color(0, 150, 136));
    }//GEN-LAST:event_jLMinimizaMouseExited

    private void jLCierraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCierraMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLCierraMouseClicked

    private void jLCierraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCierraMouseEntered
        jLCierra.setOpaque(true);
        jLCierra.setBackground(Color.red);
    }//GEN-LAST:event_jLCierraMouseEntered

    private void jLCierraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCierraMouseExited
        jLCierra.setOpaque(false);
        jLCierra.setBackground(new Color(0, 150, 136));
    }//GEN-LAST:event_jLCierraMouseExited

    private void jTFApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFApellidoKeyTyped

    private void jTFNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreKeyTyped
        controlLetras(evt);
    }//GEN-LAST:event_jTFNombreKeyTyped

    private void jTFDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDniKeyTyped
        if (jTFDni.getText().length() <= 10) {
            controlNumeros(evt);
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFDniKeyTyped

    private void jRMostrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRMostrarMousePressed
        if(jRMostrar.isSelected()== false){
        jPContraseña.setEchoChar((char)0);
        } else {
        jPContraseña.setEchoChar('*');
        }       
    }//GEN-LAST:event_jRMostrarMousePressed

    private void jPFravemaxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPFravemaxMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPFravemaxMousePressed

    private void jPFravemaxMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPFravemaxMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPFravemaxMouseDragged

    private void jlCargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCargarMouseEntered
        jlCargar.setBackground(verdeClaro);
    }//GEN-LAST:event_jlCargarMouseEntered

    private void jlCargarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCargarMouseExited
        jlCargar.setBackground(verdeBase);
    }//GEN-LAST:event_jlCargarMouseExited

    private void jLVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVolverMouseEntered
        jLVolver.setBackground(verdeClaro);
    }//GEN-LAST:event_jLVolverMouseEntered

    private void jLVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVolverMouseExited
        jLVolver.setBackground(verdeBase);
    }//GEN-LAST:event_jLVolverMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBCargo;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLCargo;
    private javax.swing.JLabel jLCierra;
    private javax.swing.JLabel jLContraseña;
    private javax.swing.JLabel jLMinimiza;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLNombre1;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLVolver;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPContraseña;
    private javax.swing.JPanel jPDatos;
    private javax.swing.JPanel jPFondo;
    private javax.swing.JPanel jPFravemax;
    private javax.swing.JRadioButton jRMostrar;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFUsuario;
    private javax.swing.JLabel jlBanner2;
    private javax.swing.JLabel jlCargar;
    private javax.swing.JLabel jlFravemax;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {
        jCBCargo.addItem("");
        jCBCargo.addItem("Vendedor");
        jCBCargo.addItem("Supervisor");
    }

    private void limpiarCampos() {
        jTFApellido.setText("");
        jTFNombre.setText("");
        jTFUsuario.setText("");
        jPContraseña.setText("");
        jRMostrar.setSelected(false);
        jRMostrar.setSelected(false);
    }

    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Registro().setVisible(true);
            }
        });
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

    public String usuario(String usuario){
        return usuario;
    }
}
