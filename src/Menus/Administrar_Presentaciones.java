package Menus;

import static Menus.Menu.check_string;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

public class Administrar_Presentaciones extends javax.swing.JFrame {

    Connection conexion;

    public Administrar_Presentaciones(Connection conexion) {
        this.conexion = conexion;
        initComponents();
        this.setLocationRelativeTo(null);
        
        mostrar_presentaciones();
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
        idpres_pres_field = new javax.swing.JTextField();
        desc_pres_field = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        buscarpres_pres_button = new javax.swing.JButton();
        limpiar_pres_button = new javax.swing.JButton();
        deletepres_pres_button = new javax.swing.JButton();
        savemarca_pres_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarpres_pres_field = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Administrar Presentaciones");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 66, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(137, 166, 246));
        jLabel16.setText("ID");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        idpres_pres_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpres_pres_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(idpres_pres_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 158, 113, 35));

        desc_pres_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc_pres_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(desc_pres_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 211, 113, 35));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(137, 166, 246));
        jLabel18.setText("Descripción");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 213, -1, -1));

        buscarpres_pres_button.setBackground(new java.awt.Color(255, 170, 151));
        buscarpres_pres_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscarpres_pres_button.setForeground(new java.awt.Color(137, 166, 246));
        buscarpres_pres_button.setText("Buscar");
        buscarpres_pres_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarpres_pres_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(buscarpres_pres_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 281, 108, 35));

        limpiar_pres_button.setBackground(new java.awt.Color(255, 170, 151));
        limpiar_pres_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiar_pres_button.setForeground(new java.awt.Color(137, 166, 246));
        limpiar_pres_button.setText("Limpiar");
        limpiar_pres_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_pres_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(limpiar_pres_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 281, 113, 35));

        deletepres_pres_button.setBackground(new java.awt.Color(255, 170, 151));
        deletepres_pres_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletepres_pres_button.setForeground(new java.awt.Color(137, 166, 246));
        deletepres_pres_button.setText("Eliminar");
        deletepres_pres_button.setEnabled(false);
        deletepres_pres_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletepres_pres_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(deletepres_pres_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 374, 113, 35));

        savemarca_pres_button.setBackground(new java.awt.Color(255, 170, 151));
        savemarca_pres_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        savemarca_pres_button.setForeground(new java.awt.Color(137, 166, 246));
        savemarca_pres_button.setText("Guardar");
        savemarca_pres_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savemarca_pres_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(savemarca_pres_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 374, 108, 35));

        mostrarpres_pres_field.setEditable(false);
        mostrarpres_pres_field.setColumns(20);
        mostrarpres_pres_field.setRows(5);
        jScrollPane1.setViewportView(mostrarpres_pres_field);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 224, -1, 207));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(137, 166, 246));
        jLabel13.setText("ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 192, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Presentaciones de Producto");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 158, 246, 28));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 166, 246));
        jLabel11.setText("Descripcion");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 192, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 460));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 700, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idpres_pres_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpres_pres_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpres_pres_fieldActionPerformed

    private void desc_pres_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc_pres_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desc_pres_fieldActionPerformed

    private void buscarpres_pres_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarpres_pres_buttonActionPerformed
        try {

            if ("".equals(idpres_pres_field.getText()) || check_string(idpres_pres_field.getText())) {
                throw new Exception("Escriba un ID de Presentación o no incluya caracteres prohibidos");
            }

            ResultSet pres = conexion.createStatement().executeQuery("SELECT Descripcion FROM Presentaciones WHERE ID_Presentacion = " + idpres_pres_field.getText());

            while (pres.next()) {
                desc_pres_field.setText(pres.getString(1));
            }

            if ("".equals(desc_pres_field.getText())) {
                throw new Exception("Esta presentacion no existe");
            }

            deletepres_pres_button.setEnabled(true);
            idpres_pres_field.setEditable(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_buscarpres_pres_buttonActionPerformed

    public void mostrar_presentaciones() {
        try {
            mostrarpres_pres_field.setText("");
            ResultSet pres = conexion.createStatement().executeQuery("SELECT * FROM Presentaciones");

            while (pres.next()) {
                mostrarpres_pres_field.append(pres.getString(1) + "\t" + pres.getString(2) + "\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    private void limpiar_pres_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_pres_buttonActionPerformed
        desc_pres_field.setText("");
        idpres_pres_field.setText("");
        mostrarpres_pres_field.setText("");
        deletepres_pres_button.setEnabled(false);
        idpres_pres_field.setEditable(true);

        mostrar_presentaciones();
    }//GEN-LAST:event_limpiar_pres_buttonActionPerformed

    private void deletepres_pres_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletepres_pres_buttonActionPerformed
        try {
            conexion.createStatement().executeUpdate("DELETE FROM Presentaciones WHERE ID_Presentacion = " + idpres_pres_field.getText());
            limpiar_pres_buttonActionPerformed(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_deletepres_pres_buttonActionPerformed

    private void savemarca_pres_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savemarca_pres_buttonActionPerformed
        try {
            if (check_string(desc_pres_field.getText())) {
                throw new Exception("La descripción no puede contener caracteres inválidos");
            }

            conexion.createStatement().executeUpdate("EXEC guardar_presentacion '" + idpres_pres_field.getText() + "','" + desc_pres_field.getText() + "'  ");

            limpiar_pres_buttonActionPerformed(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_savemarca_pres_buttonActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrar_Presentaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrar_Presentaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrar_Presentaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrar_Presentaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarpres_pres_button;
    private javax.swing.JButton deletepres_pres_button;
    private javax.swing.JTextField desc_pres_field;
    private javax.swing.JTextField idpres_pres_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar_pres_button;
    private javax.swing.JTextArea mostrarpres_pres_field;
    private javax.swing.JButton savemarca_pres_button;
    // End of variables declaration//GEN-END:variables
}
