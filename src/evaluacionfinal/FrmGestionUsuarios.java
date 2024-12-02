/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package evaluacionfinal;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JTable;

/**
 *
 * @author RAUL
 */

public class FrmGestionUsuarios extends javax.swing.JFrame {
    
    private Usuario usuarioActual;
    public FrmGestionUsuarios() {
        try {
            initComponents();
            ArrayList<String> lineas=GestorArchivo.leerArchivo("usuarios.txt");
            actualizarUsuarios();

        } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingreso aceptado",
                    "Admin", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    


    
    public void actualizarTabla(ArrayList<String> lineas){
        DefaultTableModel contenidoTabla = (DefaultTableModel) tblUsuarios.getModel();
        contenidoTabla.setRowCount(0);
        for(String linea : lineas){
            Usuario u = new Usuario(linea);
            contenidoTabla.addRow(u.toArray());
        }
    }
    public void actualizarUsuarios() { 
        try {
            ArrayList<String> usuarios = GestorArchivo.leerArchivo("usuarios.txt");
            DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
            modelo.setRowCount(0); 
            for (String usuario : usuarios) {
                String[] datos = usuario.split("&\\$");
                modelo.addRow(datos);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer usuarios: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(FrmGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnAgregarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion Usuarios");

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Apodo", "Nombre", "Apellidos"
            }
        ));
        jScrollPane1.setViewportView(tblUsuarios);

        btnAgregarUsuario.setText("Agregar Usuario");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar Usuario");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuario.setText("Modificar Usuario");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(75, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnAgregarUsuario)
                        .addGap(30, 30, 30)
                        .addComponent(btnEliminarUsuario)
                        .addGap(29, 29, 29)
                        .addComponent(btnModificarUsuario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        FrmUsuario pantalla = new FrmUsuario(this); 
        pantalla.setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        int indice = tblUsuarios.getSelectedRow();
        if (indice >= 0) {
            String apodoSeleccionado = (String) tblUsuarios.getValueAt(indice, 1);
            if (usuarioActual != null && usuarioActual.getApodo().equals(apodoSeleccionado)) {
                JOptionPane.showMessageDialog(this, "No puedes eliminar tu propio usuario.",
                        "Gestión de Usuarios", JOptionPane.WARNING_MESSAGE);
            } else {
                int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar al usuario " + apodoSeleccionado + "?",
                        "Gestión de Usuarios", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        ArrayList<String> usuariosActualizados = GestorArchivo.eliminarLinea("usuarios.txt", indice);
                        if (usuariosActualizados != null) {
                            JOptionPane.showMessageDialog(this, "El usuario se ha eliminado correctamente.",
                                    "Gestión de Usuarios", JOptionPane.INFORMATION_MESSAGE);
                            actualizarUsuarios();
                        } else {
                            JOptionPane.showMessageDialog(this, "La eliminación no pudo ser completada.",
                                    "Gestión de Usuarios", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(FrmGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la lista.",
                    "Gestión de Usuarios", JOptionPane.WARNING_MESSAGE);
        }
      
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        int indice = tblUsuarios.getSelectedRow(); 
        if (indice >= 0) { 
            try { 
                ArrayList<String> usuarios = GestorArchivo.leerArchivo("usuarios.txt"); 
                String lineaSeleccionada = usuarios.get(indice);
                String[] datos = lineaSeleccionada.split("&\\$");
                if (datos.length == 4) { 
                    Usuario usuarioSeleccionado = new Usuario(
                        Integer.parseInt(datos[0]), 
                        datos[1],                   
                        datos[2],                  
                        datos[3]                   
                    );
                    FrmUsuario pantalla = new FrmUsuario(this); 
                    pantalla.sobreescribirUsuario(usuarioSeleccionado, indice); 
                    pantalla.setVisible(true); 
                    this.setVisible(false); 
                } else {
                    JOptionPane.showMessageDialog(this, "Los datos del usuario están incompletos o corruptos.",
                            "Gestión de Usuarios", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                Logger.getLogger(FrmGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al convertir los datos del usuario.",
                        "Gestión de Usuarios", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) { 
                Logger.getLogger(FrmGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al cargar el usuario para modificar.",
                        "Gestión de Usuarios", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(FrmGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else { 
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la lista.", 
                    "Gestión de Usuarios", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGestionUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables

    
}
