package Menus;

import java.sql.*;
import static Menus.Menu.check_string;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Administrar_Categorias extends javax.swing.JFrame {

    Connection conexion;

    public Administrar_Categorias(Connection conexion) {
        this.conexion = conexion;
        initComponents();
        this.setLocationRelativeTo(null);
        mostrar_categorias();
    }
    
    //Icono JFrame
    @Override
    public Image getIconImage () {
    
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/LogoMedyCity.png"));
                
                return retValue;
    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarcat_cat_field = new javax.swing.JTextArea();
        idcat_cat_field = new javax.swing.JTextField();
        buscarcat_cat_button = new javax.swing.JButton();
        limpiar_cat_button = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        desc_cat_field = new javax.swing.JTextField();
        deletecat_cat_button = new javax.swing.JButton();
        savecat_cat_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Administrar Categorias");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 69, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(137, 166, 246));
        jLabel16.setText("ID Categoria");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Categorias");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 158, 194, 28));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(137, 166, 246));
        jLabel13.setText("ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 192, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 166, 246));
        jLabel11.setText("Descripcion");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 192, -1, -1));

        mostrarcat_cat_field.setEditable(false);
        mostrarcat_cat_field.setColumns(20);
        mostrarcat_cat_field.setRows(5);
        jScrollPane1.setViewportView(mostrarcat_cat_field);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 224, -1, 207));

        idcat_cat_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcat_cat_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(idcat_cat_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 158, 113, 35));

        buscarcat_cat_button.setBackground(new java.awt.Color(255, 170, 151));
        buscarcat_cat_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscarcat_cat_button.setForeground(new java.awt.Color(87, 116, 196));
        buscarcat_cat_button.setText("Buscar");
        buscarcat_cat_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarcat_cat_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(buscarcat_cat_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 281, 108, 35));

        limpiar_cat_button.setBackground(new java.awt.Color(255, 170, 151));
        limpiar_cat_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiar_cat_button.setForeground(new java.awt.Color(87, 116, 196));
        limpiar_cat_button.setText("Limpiar");
        limpiar_cat_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_cat_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(limpiar_cat_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 281, 113, 35));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(137, 166, 246));
        jLabel18.setText("Descripción");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 213, -1, -1));

        desc_cat_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc_cat_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(desc_cat_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 211, 113, 35));

        deletecat_cat_button.setBackground(new java.awt.Color(255, 170, 151));
        deletecat_cat_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletecat_cat_button.setForeground(new java.awt.Color(87, 116, 196));
        deletecat_cat_button.setText("Eliminar");
        deletecat_cat_button.setEnabled(false);
        deletecat_cat_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletecat_cat_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(deletecat_cat_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 374, 113, 35));

        savecat_cat_button.setBackground(new java.awt.Color(255, 170, 151));
        savecat_cat_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        savecat_cat_button.setForeground(new java.awt.Color(87, 116, 196));
        savecat_cat_button.setText("Guardar");
        savecat_cat_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savecat_cat_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(savecat_cat_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 374, 108, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 660, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idcat_cat_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcat_cat_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idcat_cat_fieldActionPerformed

    private void buscarcat_cat_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarcat_cat_buttonActionPerformed
        try {

            if ("".equals(idcat_cat_field.getText()) || check_string(idcat_cat_field.getText())) {
                throw new Exception("Escriba un ID de Categoria o no incluya caracteres prohibidos");
            }

            ResultSet categoria = conexion.createStatement().executeQuery("SELECT Descripcion FROM Categorias_Prod WHERE ID_Categoria = " + idcat_cat_field.getText());

            while (categoria.next()) {
                desc_cat_field.setText(categoria.getString(1));
            }

            if ("".equals(desc_cat_field.getText())) {
                throw new Exception("Esta categoría no existe");
            }

            deletecat_cat_button.setEnabled(true);
            idcat_cat_field.setEditable(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_buscarcat_cat_buttonActionPerformed

    public void mostrar_categorias() {
        try {
            mostrarcat_cat_field.setText("");
            ResultSet categorias = conexion.createStatement().executeQuery("SELECT * FROM Categorias_Prod");

            while (categorias.next()) {
                mostrarcat_cat_field.append(categorias.getString(1) + "\t" + categorias.getString(2) + "\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }
    private void limpiar_cat_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_cat_buttonActionPerformed
        desc_cat_field.setText("");
        idcat_cat_field.setText("");
        mostrarcat_cat_field.setText("");
        deletecat_cat_button.setEnabled(false);
        idcat_cat_field.setEditable(true);

        mostrar_categorias();
    }//GEN-LAST:event_limpiar_cat_buttonActionPerformed

    private void desc_cat_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc_cat_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desc_cat_fieldActionPerformed

    private void deletecat_cat_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletecat_cat_buttonActionPerformed
        try {
            conexion.createStatement().executeUpdate("DELETE FROM Categorias_Prod WHERE ID_Categoria = " + idcat_cat_field.getText());
            limpiar_cat_buttonActionPerformed(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_deletecat_cat_buttonActionPerformed

    private void savecat_cat_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savecat_cat_buttonActionPerformed
        try {
            if(check_string(desc_cat_field.getText())){
                throw new Exception ("La descripción no puede contener caracteres inválidos");
            }
            
            conexion.createStatement().executeUpdate("EXEC guardar_categoria '" + idcat_cat_field.getText() + "','" + desc_cat_field.getText() + "'  ");
            
            
            limpiar_cat_buttonActionPerformed(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_savecat_cat_buttonActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrar_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrar_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrar_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrar_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarcat_cat_button;
    private javax.swing.JButton deletecat_cat_button;
    private javax.swing.JTextField desc_cat_field;
    private javax.swing.JTextField idcat_cat_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar_cat_button;
    private javax.swing.JTextArea mostrarcat_cat_field;
    private javax.swing.JButton savecat_cat_button;
    // End of variables declaration//GEN-END:variables
}
