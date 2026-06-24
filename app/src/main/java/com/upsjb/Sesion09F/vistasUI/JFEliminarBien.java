
package com.upsjb.Sesion09F.vistasUI;

import com.upsjb.Sesion09F.DAO.BienDAO;
import com.upsjb.Sesion09F.ModeloDT.Bien;

import java.util.List;
import javax.swing.table.DefaultTableModel;



public class JFEliminarBien extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFEliminarBien.class.getName());

    public JFEliminarBien() {
        initComponents();
          // Cargar los bienes al abrir el formulario
        CargarBienes();
        // Ocultar el mensaje al inicio
        jlBienELiminado.setVisible(false);
        // Detectar cuando el usuario selecciona una fila
        jtbBienesRegistrados.getSelectionModel().addListSelectionListener(e -> SeleccionarFila());
    }
    // Método que carga todos los bienes de la base de datos en la tabla
    public void CargarBienes(){
        // Crear el modelo de la tabla con las columnas
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Estado");
        modelo.addColumn("Ubicacion");
        // Obtener la lista de bienes desde la base de datos
        BienDAO dao = new BienDAO();
        List<Bien> lista = dao.listar();
        // Recorrer la lista y agregar cada bien como fila en la tabla
        for(Bien b: lista){
            modelo.addRow(new Object[]{
                b.getIdBien(),
                b.getNombre(),
                b.getCantidad(),
                b.getEstado(),
                b.getUbicacion(),
            });
        }
        // Asignar el modelo a la tabla
        jtbBienesRegistrados.setModel(modelo);   
    }
    // Método que detecta cuando el usuario selecciona una fila de la tabla
    private void SeleccionarFila(){
        int filaSeleccionado = jtbBienesRegistrados.getSelectedRow();
                // Si hay una fila seleccionada, toma el ID y lo pone en el campo de texto

        if(filaSeleccionado >= 0){
            String id =jtbBienesRegistrados.getValueAt(filaSeleccionado, 0).toString();
            jtxfID.setText(id);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpGestionBienes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpLitsadeBienesR = new javax.swing.JPanel();
        jlListaDeBienesRegistrados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBienesRegistrados = new javax.swing.JTable();
        jpBienEliminado = new javax.swing.JPanel();
        jlIdBienEliminar = new javax.swing.JLabel();
        jtxfID = new javax.swing.JTextField();
        jbtEliminar = new javax.swing.JButton();
        jlBienELiminado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpGestionBienes.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 204, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Bienes - Eliminación");
        jLabel1.setOpaque(true);
        jpGestionBienes.add(jLabel1, java.awt.BorderLayout.CENTER);

        jpLitsadeBienesR.setLayout(new java.awt.BorderLayout());

        jlListaDeBienesRegistrados.setBackground(new java.awt.Color(255, 204, 204));
        jlListaDeBienesRegistrados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListaDeBienesRegistrados.setText("Lista de Bienes Registrados");
        jlListaDeBienesRegistrados.setOpaque(true);
        jpLitsadeBienesR.add(jlListaDeBienesRegistrados, java.awt.BorderLayout.PAGE_START);

        jtbBienesRegistrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Estado", "Cantidad", "Ubicación"
            }
        ));
        jScrollPane1.setViewportView(jtbBienesRegistrados);

        jpLitsadeBienesR.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpBienEliminado.setBackground(new java.awt.Color(204, 204, 255));

        jlIdBienEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlIdBienEliminar.setText("ID del Bien a Eliminar:");

        jbtEliminar.setText("Eliminar");
        jbtEliminar.addActionListener(this::jbtEliminarActionPerformed);

        jlBienELiminado.setBackground(new java.awt.Color(255, 255, 255));
        jlBienELiminado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlBienELiminado.setOpaque(true);

        jButton1.setText("volver");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jpBienEliminadoLayout = new javax.swing.GroupLayout(jpBienEliminado);
        jpBienEliminado.setLayout(jpBienEliminadoLayout);
        jpBienEliminadoLayout.setHorizontalGroup(
            jpBienEliminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBienEliminadoLayout.createSequentialGroup()
                .addGroup(jpBienEliminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBienEliminadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlIdBienEliminar))
                    .addGroup(jpBienEliminadoLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jbtEliminar))
                    .addGroup(jpBienEliminadoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(59, 59, 59)
                        .addGroup(jpBienEliminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlBienELiminado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxfID, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBienEliminadoLayout.setVerticalGroup(
            jpBienEliminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBienEliminadoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlIdBienEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBienEliminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpBienEliminadoLayout.createSequentialGroup()
                        .addComponent(jtxfID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jlBienELiminado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpGestionBienes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpLitsadeBienesR, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                            .addComponent(jpBienEliminado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpGestionBienes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpLitsadeBienesR, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpBienEliminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEliminarActionPerformed
        // Verificar que el campo ID no esté vacío
        if(jtxfID.getText().isEmpty()){
            jlBienELiminado.setText("Selecciona un Bien de la tabla primero");
            return;
        }
           // Obtener el ID del campo de texto
        int id = Integer.parseInt(jtxfID.getText());
        // Llamar al método eliminar del DAO
        BienDAO bien = new BienDAO();
        bien.eliminar(id);
        // Mostrar mensaje de confirmación
        jlBienELiminado.setVisible(true);
        jlBienELiminado.setText("Bien eliminado exitosamente");
         // Limpiar el campo ID y recargar la tabla
        jtxfID.setText("");
        CargarBienes();
    }//GEN-LAST:event_jbtEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(() -> new JFEliminarBien().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtEliminar;
    private javax.swing.JLabel jlBienELiminado;
    private javax.swing.JLabel jlIdBienEliminar;
    private javax.swing.JLabel jlListaDeBienesRegistrados;
    private javax.swing.JPanel jpBienEliminado;
    private javax.swing.JPanel jpGestionBienes;
    private javax.swing.JPanel jpLitsadeBienesR;
    private javax.swing.JTable jtbBienesRegistrados;
    private javax.swing.JTextField jtxfID;
    // End of variables declaration//GEN-END:variables
}
