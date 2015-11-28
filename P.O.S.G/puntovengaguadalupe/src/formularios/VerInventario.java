/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formularios;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DEOCCIDENTE
 */
public class VerInventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerInventario
     */
    public VerInventario() {
        initComponents();
        CargarInventario();
    }
    
    public void CargarInventario(){
        Connection cn=null;
        PreparedStatement pst;
        ResultSet rs;
        
        //String sql= "SELECT CodProducto, NombreProducto,PrecioUProducto,PrecioMayoristaProducto,tblMarca_idtblMarca(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE NombreProducto like'"+comodin+"'";
        // String sql= "(SELECT CodProducto,NombreProducto,DescripcionProducto, PrecioUproducto, PrecioMProducto,Existencias,(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE NombreProducto like'"+comodin+"')";
        String sql= "(SELECT tblProductos.CodProducto,tblProductos.NombreProducto,tblProductos.DescripcionProducto,tblProductos.PrecioUproducto,tblProductos.PrecioMProducto,tblProductos.Existencias , tblMarca.NombreMarca FROM tblProductos INNER JOIN tblMarca ON tblProductos.idtblMarca= tblMarca.idtblMarca)";
        try {
            cn= conexion.getConexion();
            pst=cn.prepareCall(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Inventario Total");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio U", "Precio M", "Existencias", "Marca"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo De Busqueda"));

        jRadioButton1.setText("Codigo");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Nombre");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Marca");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel3.setText("Ingrese el texto a buscar:");

        jButton2.setText("Pocas Existencias. (12)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Existencias Menores A..."));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButton3))
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void Busqnombre(){
          Connection cn=null;
        PreparedStatement pst;
        ResultSet rs;
        String comodin= jTextField1.getText() + "%";
        //String sql= "SELECT CodProducto, NombreProducto,PrecioUProducto,PrecioMayoristaProducto,tblMarca_idtblMarca(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE NombreProducto like'"+comodin+"'";
        //String sql= "(SELECT CodProducto,NombreProducto,DescripcionProducto, PrecioUproducto, PrecioMProducto,Existencias,(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE NombreProducto like '"+comodin+"')";
       String sql= "(SELECT tblProductos.CodProducto,tblProductos.NombreProducto,tblProductos.Existencias,tblProductos.PrecioUproducto,tblProductos.PrecioMProducto, tblMarca.NombreMarca FROM tblProductos INNER JOIN tblMarca ON tblProductos.idtblMarca= tblMarca.idtblMarca WHERE NombreProducto like'"+comodin+"')";
        try {
            cn= conexion.getConexion();
            pst=cn.prepareCall(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }
    public void BusqCodigo(){
          Connection cn=null;
        PreparedStatement pst;
        ResultSet rs;
        String comodin= jTextField1.getText() + "%";
        //String sql= "SELECT CodProducto, NombreProducto,PrecioUProducto,PrecioMayoristaProducto,tblMarca_idtblMarca(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE NombreProducto like'"+comodin+"'";
       // String sql= "(SELECT CodProducto,NombreProducto,DescripcionProducto, PrecioUproducto, PrecioMProducto,Existencias,(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE CodProducto like'"+comodin+"')";
        String sql= "(SELECT tblProductos.CodProducto,tblProductos.NombreProducto,tblProductos.Existencias,tblProductos.PrecioUproducto,tblProductos.PrecioMProducto, tblMarca.NombreMarca FROM tblProductos INNER JOIN tblMarca ON tblProductos.idtblMarca= tblMarca.idtblMarca WHERE CodProducto like'"+comodin+"')";
       
        try {
            cn= conexion.getConexion();
            pst=cn.prepareCall(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }
    public void busqMarca(){
          Connection cn=null;
        PreparedStatement pst;
        ResultSet rs;
        String comodin= jTextField1.getText() + "%";
        //String sql= "SELECT CodProducto, NombreProducto,PrecioUProducto,PrecioMayoristaProducto,tblMarca_idtblMarca(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE NombreProducto like'"+comodin+"'";
       // String sql= "(SELECT CodProducto,NombreProducto,DescripcionProducto, PrecioUproducto, PrecioMProducto,Existencias,(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE CodProducto like'"+comodin+"')";
        String sql= "(SELECT tblProductos.CodProducto,tblProductos.NombreProducto,tblProductos.Existencias,tblProductos.PrecioUproducto,tblProductos.PrecioMProducto, tblMarca.NombreMarca FROM tblProductos INNER JOIN tblMarca ON tblProductos.idtblMarca= tblMarca.idtblMarca WHERE NombreMarca like'"+comodin+"')";
       
        try {
            cn= conexion.getConexion();
            pst=cn.prepareCall(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }
    
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here
        if (jRadioButton1.isSelected()){
            BusqCodigo();
        }else{
            if(jRadioButton2.isSelected()){
                Busqnombre();
            }else{
                if(jRadioButton3.isSelected()){
                    busqMarca();
                }
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(false);
        jRadioButton3.setSelected(false);
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          Connection cn=null;
        PreparedStatement pst;
        ResultSet rs;
        String comodin= jTextField1.getText() + "%";
        //String sql= "SELECT CodProducto, NombreProducto,PrecioUProducto,PrecioMayoristaProducto,tblMarca_idtblMarca(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE NombreProducto like'"+comodin+"'";
       // String sql= "(SELECT CodProducto,NombreProducto,DescripcionProducto, PrecioUproducto, PrecioMProducto,Existencias,(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE CodProducto like'"+comodin+"')";
        String sql= "(SELECT tblProductos.CodProducto,tblProductos.Existencias,tblProductos.NombreProducto,tblProductos.PrecioUproducto,tblProductos.PrecioMProducto, tblMarca.NombreMarca FROM tblProductos INNER JOIN tblMarca ON tblProductos.idtblMarca= tblMarca.idtblMarca WHERE Existencias <=12)";
       
        try {
            cn= conexion.getConexion();
            pst=cn.prepareCall(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          Connection cn=null;
        PreparedStatement pst;
        ResultSet rs;
        String comodin= jTextField2.getText();
        //String sql= "SELECT CodProducto, NombreProducto,PrecioUProducto,PrecioMayoristaProducto,tblMarca_idtblMarca(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE NombreProducto like'"+comodin+"'";
       // String sql= "(SELECT CodProducto,NombreProducto,DescripcionProducto, PrecioUproducto, PrecioMProducto,Existencias,(SELECT NombreMarca FROM tblMarca WHERE idtblMarca=tblMarca_idtblMarca) FROM tblProductos WHERE CodProducto like'"+comodin+"')";
        String sql= "(SELECT tblProductos.CodProducto,tblProductos.Existencias,tblProductos.NombreProducto,tblProductos.DescripcionProducto,tblProductos.PrecioUproducto,tblProductos.PrecioMProducto, tblMarca.NombreMarca FROM tblProductos INNER JOIN tblMarca ON tblProductos.idtblMarca= tblMarca.idtblMarca WHERE Existencias <="+comodin+")";
       
        try {
            cn= conexion.getConexion();
            pst=cn.prepareCall(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
