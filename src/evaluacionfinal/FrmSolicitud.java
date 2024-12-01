/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal;

import javax.swing.*; 
import javax.swing.table.DefaultTableModel; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate; 
import java.time.format.DateTimeFormatter; 
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author charl
 */
public class FrmSolicitud extends javax.swing.JFrame {
    private int idPrestamo = -1;
    private ListaPrestamos formLista;
    /**
     * Creates new form FrmSolisitud
     */
    public FrmSolicitud() {
        try {
            initComponents();

            // Cargar solicitantes al inicializar
            ArrayList<Object> objetos = ManejadorArchivos.leerArchivo("Solicitantes.txt");
            if (objetos != null) {
                cargarSolicitantes(objetos);
            } else {
                JOptionPane.showMessageDialog(null, "No hay solicitantes disponibles en el archivo.",
                        "Aplicación Biblioteca", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "El formato del archivo de almacenamiento no coincide.",
                    "Aplicación Biblioteca", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public FrmSolicitud(int idPrestamo ,ListaPrestamos formLista) {
        try {
            initComponents();
            //Buscar esa línea en el archivo y cargar las cajas de texto
            Object objeto = ManejadorArchivos.leerObjeto("Prestamos.txt", idPrestamo);
            //Solo si la línea se encontró en el archivo carga los datos
            if (objeto != null) {
                this.idPrestamo = idPrestamo;
                this.formLista = formLista;
                Prestamo p = (Prestamo)objeto;
                cboSolicitante.setSelectedItem(p.getSolicitante());
                cboLibro.setEnabled(true);
                btnAgregar.setEnabled(true);
                txtFechaLimite.setText(p.getFechaLimiteEntrega().format(
                        DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            } else {
                //Lanzar una excepción
                throw new NoSuchElementException("El prestamo seleccionado no se encontró");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "El formato del archivo de almacenamiento no coincide",
                        "Aplicación Biblioteca", JOptionPane.ERROR_MESSAGE);
        }
    }

    FrmSolicitud(ListaPrestamos aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        cboSolicitante = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboLibro = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibrosPrestados = new javax.swing.JTable();
        txtFechaLimite = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnGuardarPrestamo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Solicitar Prestamo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        cboSolicitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSolicitanteActionPerformed(evt);
            }
        });

        jLabel2.setText("Solicitante");

        jLabel3.setText("Libro");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblLibrosPrestados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Autor"
            }
        ));
        jScrollPane1.setViewportView(tblLibrosPrestados);

        jLabel4.setText("Fecha Limite");

        btnGuardarPrestamo.setText("Guardar Prestamo");
        btnGuardarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPrestamoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(96, 96, 96))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3)))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(txtFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(btnGuardarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(txtFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnGuardarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cboSolicitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSolicitanteActionPerformed
//        ArrayList<String> listaDatos = new ArrayList<>();
//        listaDatos.add("Elemento 1");
//        listaDatos.add("Elemento 2");
//        listaDatos.add("Elemento 3");
    }//GEN-LAST:event_cboSolicitanteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void btnGuardarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPrestamoActionPerformed
        try{
            //Asumimos que la fecha fue ingresada en la caja de texto en formato
            //dia-mes-año
            LocalDate fechaLim = LocalDate.parse(txtFechaLimite.getText(),
                    DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            Prestamo p = new Prestamo(cboSolicitante.getSelectedItem().toString(),
                Libro,
                    fechaLim);
            if (idPrestamo >= 0) {
                //Enviamos la posición de la línea a reemplazar, el alumno con las modificaciones 
                //en versión String y obtenemos la actualización de las líneas 
                ArrayList<Object> objetos = ManejadorArchivos.reemplazarObjeto("Prestamos.txt",
                        idPrestamo, p);
                if (objetos != null) {
                    //Si el reemplazo se hizo correctamente informamos
                    JOptionPane.showMessageDialog(this, "El prestamo se ha actualizado correctamente",
                            "Gestión Prestamo", JOptionPane.INFORMATION_MESSAGE);
                    //Actualizamos la lista
                    formLista.actualizarTabla(objetos);
                    //Mostramos el form de la lista
                    formLista.setVisible(true);
                    //Cerramos el form actual
                    this.dispose();
                } else {
                    //Informar que no se hizo la operación
                    JOptionPane.showMessageDialog(this, "La actualización no pudo ser completada",
                            "Gestión Prestamos", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                //Enviamos a almacenar elnuevo alumno y obtenemos la actualización de las líneas 
                ArrayList<Object> objetos = ManejadorArchivos.agregarObjeto("Alumnos.poo",
                        p);
                if (objetos != null) {
                    //Si el reemplazo se hizo correctamente informamos
                    JOptionPane.showMessageDialog(this, "El alumno se ha añadido correctamente",
                            "Gestión de alumnos", JOptionPane.INFORMATION_MESSAGE);
                    //Actualizamos la lista
                    formLista.actualizarTabla(objetos);
                    //Mostramos el form de la lista
                    formLista.setVisible(true);
                    //Cerramos el form actual
                    this.dispose();
                } else {
                    //Informar que no se hizo la operación
                    JOptionPane.showMessageDialog(this, "El prestamo no pudo ser agregado",
                            "Gestión Prestamos", JOptionPane.ERROR_MESSAGE);
               }
            }
        }catch(DateTimeException ex){
            JOptionPane.showMessageDialog(this, "La fecha es obligatoria y debe tener un formato correcto (Ejemplo: 18-09-2024)",
                        "Gestión de alumnos", JOptionPane.ERROR_MESSAGE);
        }
        catch(IllegalArgumentException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Gestión de alumnos", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "El formato del archivo de almacenamiento no coincide",
                        "Aplicación para gestionar alumnos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarPrestamoActionPerformed

    public void cargarSolicitantes(ArrayList<Object> objetos) {
        try {
            ArrayList<Solicitante> soli = new ArrayList<>();

            // Convertir objetos leídos a tipo Solicitante
            for (Object obj : objetos) {
                if (obj instanceof Solicitante) {
                    soli.add((Solicitante) obj);
                }
            }

            // Verificar si hay solicitantes válidos
            if (soli.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay solicitantes válidos para mostrar.",
                        "Aplicación Biblioteca", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Poblar el combo box
            cboSolicitante.removeAllItems();
            for (Solicitante solicitante : soli) {
                cboSolicitante.addItem(solicitante.getNombre().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar solicitantes: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarTabla(ArrayList<Object> objetos) {
        DefaultTableModel contenidoTabla = (DefaultTableModel) tblLibrosPrestados.getModel();
        //Quitar cualquier fila que ya esté en la tabla 
        contenidoTabla.setRowCount(0);
        for (Object objeto : objetos) {
            contenidoTabla.addRow(((Prestamo)objeto).toArray());
        }
    }
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
            java.util.logging.Logger.getLogger(FrmSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardarPrestamo;
    private javax.swing.JComboBox<String> cboLibro;
    private javax.swing.JComboBox<String> cboSolicitante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLibrosPrestados;
    private javax.swing.JTextField txtFechaLimite;
    // End of variables declaration//GEN-END:variables
}
