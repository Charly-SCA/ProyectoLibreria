/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*; 
import java.time.DateTimeException;
import java.time.LocalDate; 
import java.time.format.DateTimeFormatter; 
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author charl
 */
public class FrmSolicitud extends javax.swing.JFrame {
    private int idPrestamo = -1;
    private ListaPrestamos formLista;
    private ArrayList<Libro> librosPrestados;
    /**
     * Creates new form FrmSolisitud
     */
    public FrmSolicitud() {
        initComponents();
    }
    
    public FrmSolicitud(ListaPrestamos formLista) {
        
        this.librosPrestados = new ArrayList<>();
        initComponents();
        
        // Cargar solicitantes al inicializar
        //cargarSolicitantes();
        cargarSolicitantes("Solicitantes.txt", cboSolicitante);
        // Cargar libros al inicializar
        //cargarLibros();
        cargarLibros("Libros.txt", cboLibro);
    }
    //public FrmSolicitud(int idPrestamo ,ListaPrestamos formLista) {
//        try {
//            initComponents();
//            // Cargar solicitantes al inicializar
//            ArrayList<Object> objetos = ManejadorArchivos.leerArchivo("Solicitantes.txt");
//            if (objetos != null) {
//                cargarSolicitantes(objetos);
//            } else {
//                JOptionPane.showMessageDialog(null, "No hay solicitantes disponibles en el archivo.",
//                        "Aplicación Biblioteca", JOptionPane.INFORMATION_MESSAGE);
//            }
//            ArrayList<Object> objetos2 = ManejadorArchivos.leerArchivo("Libros.txt");
//            if (objetos2 != null) {
//                cargarLibros(objetos2);
//            } else {
//                JOptionPane.showMessageDialog(null, "No hay libros disponibles en el archivo.",
//                        "Aplicación Biblioteca", JOptionPane.INFORMATION_MESSAGE);
//            }
//            
//            //Buscar esa línea en el archivo y cargar las cajas de texto
//            Object objeto = ManejadorArchivos.leerObjeto("Prestamos.txt", idPrestamo);
//            //Solo si la línea se encontró en el archivo carga los datos
//            if (objeto != null) {
//                this.idPrestamo = idPrestamo;
//                this.formLista = formLista;
//                Prestamo p = (Prestamo)objeto;
//                cboSolicitante.setSelectedItem(p.getSolicitante());
//                cboLibro.setEnabled(true);
//                btnAgregar.setEnabled(true);
//                txtFechaLimite.setText(p.getFechaLimiteEntrega().format(
//                        DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//            } else {
//                //Lanzar una excepción
//                throw new NoSuchElementException("El prestamo seleccionado no se encontró");
//            }
//        } catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "El formato del archivo de almacenamiento no coincide",
//                        "Aplicación Biblioteca", JOptionPane.ERROR_MESSAGE);
//        }
//    }


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
        btnCancelar = new javax.swing.JButton();

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

        cboLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLibroActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblLibrosPrestados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Autor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLibrosPrestados);

        jLabel4.setText("Fecha Limite");

        btnGuardarPrestamo.setText("Guardar Prestamo");
        btnGuardarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPrestamoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 27, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    String libroSeleccionado = cboLibro.getSelectedItem().toString(); 
    if (libroSeleccionado != null) { 
        DefaultTableModel model = (DefaultTableModel) tblLibrosPrestados.getModel(); 
        try { 
            ArrayList<String> lineas = GestorArchivo.leerArchivo("Libros.txt"); 
            ArrayList<String> nuevasLineas = new ArrayList<>();
            for (String linea : lineas) { 
                Libro libro = new Libro(linea); 
                if (libro.getNombre().equals(libroSeleccionado)) { 
                    librosPrestados.add(libro); 
                    libro.setDisponible("No Disponible");
                    model.addRow(new Object[]{libro.getNombre(), libro.getAutor()});
                } 
                nuevasLineas.add(libro.toString());
            } 
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Libros.txt"))) { 
                for (String nuevaLinea : nuevasLineas) { 
                    writer.write(nuevaLinea + "\n"); 
                } 
            }
            cargarLibros("Libros.txt", cboLibro);
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog(null, "Error al agregar libro: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE); 
        } 
    }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cboSolicitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSolicitanteActionPerformed
        
    }//GEN-LAST:event_cboSolicitanteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //formLista.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnGuardarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPrestamoActionPerformed
    try {
        String solicitanteSeleccionado = cboSolicitante.getSelectedItem().toString();
        LocalDate fechaPrestamo = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaPrestamoString = fechaPrestamo.format(formatter);
        String fechaLimiteString = txtFechaLimite.getText();
        LocalDate fechaLimite = LocalDate.parse(fechaLimiteString, formatter);

        Solicitante solicitante = null;
        for (String linea : GestorArchivo.leerArchivo("Solicitantes.txt")) {
            Solicitante s = new Solicitante(linea);
            if (s.toString().equals(solicitanteSeleccionado)) {
                solicitante = s;
                break;
            }
        }
        
        String devolucion = "No devuelto";
        Prestamo prestamo = new Prestamo(solicitante, librosPrestados, fechaPrestamo, fechaLimite, devolucion);
        BufferedWriter writer = new BufferedWriter(new FileWriter("Prestamos.txt", true));
        writer.write(prestamo.toString() + "\n");
        writer.close();

        // Actualizar disponibilidad de los libros prestados y recargar el combo box
        for (Libro libro : librosPrestados) {
            libro.setDisponible("No Disponible");
        }
        actualizarLibros();
        cargarLibros("Libros.txt", cboLibro);

        JOptionPane.showMessageDialog(null, "Préstamo guardado exitosamente.",
                "Confirmación", JOptionPane.INFORMATION_MESSAGE);

        dispose();
        formLista.setVisible(true);
        formLista.actualizarTabla(GestorArchivo.leerArchivo("Prestamos.txt"));
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar el préstamo: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }



        
        

//        try{
//            //Asumimos que la fecha fue ingresada en la caja de texto en formato
//            //dia-mes-año
//            LocalDate fechaLim = LocalDate.parse(txtFechaLimite.getText(),
//                    DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//            
//            // Obtener el solicitante seleccionado
//            String nombreSolicitante = cboSolicitante.getSelectedItem().toString();
//            Solicitante solicitante = new Solicitante(nombreSolicitante);
//            
//            // Crear un ArrayList para los libros seleccionados
//            ArrayList<Libro> librosPrestados = new ArrayList<>();
//            
//            Prestamo p = new Prestamo(solicitante, librosPrestados, fechaLim);
//            
//            if (idPrestamo >= 0) {
//                //Enviamos la posición de la línea a reemplazar, el alumno con las modificaciones 
//                //en versión String y obtenemos la actualización de las líneas 
//                ArrayList<Object> objetos = ManejadorArchivos.reemplazarObjeto("Prestamos.txt",
//                        idPrestamo, p);
//                if (objetos != null) {
//                    //Si el reemplazo se hizo correctamente informamos
//                    JOptionPane.showMessageDialog(this, "El prestamo se ha actualizado correctamente",
//                            "Gestión Prestamo", JOptionPane.INFORMATION_MESSAGE);
//                    //Actualizamos la lista
//                    formLista.actualizarTabla(objetos);
//                    //Mostramos el form de la lista
//                    formLista.setVisible(true);
//                    //Cerramos el form actual
//                    this.dispose();
//                } else {
//                    //Informar que no se hizo la operación
//                    JOptionPane.showMessageDialog(this, "La actualización no pudo ser completada",
//                            "Gestión Prestamos", JOptionPane.ERROR_MESSAGE);
//                }
//            } else {
//                //Enviamos a almacenar elnuevo alumno y obtenemos la actualización de las líneas 
//                ArrayList<Object> objetos = ManejadorArchivos.agregarObjeto("Prestamos.txt",
//                        p);
//                if (objetos != null) {
//                    //Si el reemplazo se hizo correctamente informamos
//                    JOptionPane.showMessageDialog(this, "El prestamo se ha añadido correctamente",
//                            "Gestión Prestamos", JOptionPane.INFORMATION_MESSAGE);
//                    //Actualizamos la lista
//                    formLista.actualizarTabla(objetos);
//                    //Mostramos el form de la lista
//                    formLista.setVisible(true);
//                    //Cerramos el form actual
//                    this.dispose();
//                } else {
//                    //Informar que no se hizo la operación
//                    JOptionPane.showMessageDialog(this, "El prestamo no pudo ser agregado",
//                            "Gestión Prestamos", JOptionPane.ERROR_MESSAGE);
//               }
//            }
//        }catch(DateTimeException ex){
//            JOptionPane.showMessageDialog(this, "La fecha es obligatoria y debe tener un formato correcto (Ejemplo: 18-09-2024)",
//                        "Gestión Prestamos", JOptionPane.ERROR_MESSAGE);
//        }
//        catch(IllegalArgumentException ex){
//            JOptionPane.showMessageDialog(this, ex.getMessage(),
//                        "Gestión Prestamos", JOptionPane.ERROR_MESSAGE);
//        }
//        catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "El formato del archivo de almacenamiento no coincide",
//                        "Aplicación Bliblioteca", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnGuardarPrestamoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cboLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLibroActionPerformed
    
    private void cargarSolicitantes(String archivo, JComboBox<String> combo) { 
        try { 
            ArrayList<String> lineas = GestorArchivo.leerArchivo(archivo); 
            combo.removeAllItems();
            for (String linea : lineas) { 
                Solicitante solicitante = new Solicitante(linea); 
                combo.addItem(solicitante.toString()); 
            } 
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar solicitantes", 
                    JOptionPane.ERROR_MESSAGE); 
        } 
    }
    
    private void cargarLibros(String archivo, JComboBox<String> combo) {
        try {
            ArrayList<String> lineas = GestorArchivo.leerArchivo(archivo);
            combo.removeAllItems();
            for (String linea : lineas) {
                Libro libro = new Libro(linea);
                if (libro.getDisponible().equals("Disponible")) {
                    combo.addItem(libro.getNombre().trim());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error al cargar libros", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarTabla(ArrayList<String> lineas){
        DefaultTableModel contenidoTabla = (DefaultTableModel) tblLibrosPrestados.getModel();
        contenidoTabla.setRowCount(0);
        for(String linea : lineas){
            Libro lib = new Libro(linea);
            contenidoTabla.addRow(lib.toArray());
        }
    }
    
    private void actualizarLibros() {
        try {
            ArrayList<String> lineas = GestorArchivo.leerArchivo("Libros.txt");
            ArrayList<String> nuevasLineas = new ArrayList<>();

            for (String linea : lineas) {
                Libro libro = new Libro(linea);
                for (Libro prestado : librosPrestados) {
                    if (libro.getNombre().equals(prestado.getNombre())) {
                        libro.setDisponible("No Disponible");
                    }
                }
                nuevasLineas.add(libro.toString());
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Libros.txt"))) {
                for (String nuevaLinea : nuevasLineas) {
                    writer.write(nuevaLinea + "\n");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los libros: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
//    private void agregarLibro() { 
//        String libroSeleccionado = (String) cboLibros.getSelectedItem(); 
//        if (libroSeleccionado != null) { 
//            try {
//                DefaultTableModel model = (DefaultTableModel) tblLibrosPrestados.getModel();
//                for (String libro : GestorArchivo.leerArchivo("Libros.txt")) {
//                    Libro l = new Libro(libro);
//                    if (l.toString().equals(libroSeleccionado)) {
//                        librosPrestados.add(l);
//                        model.addRow(new Object[]{l.getNombre(), l.getAutor()});
//                        break;
//                    } 
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(FrmSolicitud.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } 
//    }
    
//    private void actualizarLibros() { 
//        ArrayList<String> lineas = GestorArchivo.leerArchivo("Libros.txt"); 
//        ArrayList<String> nuevasLineas = new ArrayList<>(); 
//        for (String linea : lineas) { 
//            Libro libro = new Libro(linea); 
//            for (Libro prestado : librosPrestados) { 
//                if (libro.getNombre().equals(prestado.getNombre())) { 
//                    libro.setDisponible(false); 
//                } 
//            } 
//            nuevasLineas.add(libro.toString()); 
//        } 
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Libros.txt"))) { 
//            for (String nuevaLinea : nuevasLineas) { 
//                writer.write(nuevaLinea + "\n"); 
//            } 
//        } catch (Exception ex) { 
//            JOptionPane.showMessageDialog(null, "Error al actualizar los libros: " + ex.getMessage(), 
//                    "Error", JOptionPane.ERROR_MESSAGE); 
//        } 
//    }
    
    /*
    public void cargarSolicitantes(String Archivo, JComboBox<String> cbo) {
        try {
            ArrayList<String> lineas = GestorArchivo.leerArchivo(Archivo);

            // Poblar el combo box
            cbo.removeAllItems();
            for (String linea : lineas) {
                cbo.addItem(linea.trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar solicitantes: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarLibros(String Archivo, JComboBox<String> cbo) {
        try {
            ArrayList<String> lineas = GestorArchivo.leerArchivo(Archivo);

            // Poblar el combo box
            cbo.removeAllItems();
            for (String linea : lineas) {
                cbo.addItem(linea.trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar libros: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
 */
    
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
    private javax.swing.JButton btnCancelar;
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
