package Menus;

import static Menus.Menu.check_string;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

public class Administrar_Marcas extends javax.swing.JFrame {

    Connection conexion;

    public Administrar_Marcas(Connection conexion) {
        this.conexion = conexion;
        initComponents();
        this.setLocationRelativeTo(null);
        
        mostrar_marcas();
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
        jLabel18 = new javax.swing.JLabel();
        desc_marcas_field = new javax.swing.JTextField();
        idmarca_marcas_field = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarmarcas_marcas_field = new javax.swing.JTextArea();
        limpiar_marca_button = new javax.swing.JButton();
        deletemarcas_marca_button = new javax.swing.JButton();
        savemarca_marcas_button = new javax.swing.JButton();
        buscarmarcas_marca_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Administrar Marcas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(137, 166, 246));
        jLabel16.setText("ID Marca");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 160, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(137, 166, 246));
        jLabel18.setText("Descripción");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 213, -1, -1));

        desc_marcas_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc_marcas_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(desc_marcas_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 211, 113, 35));

        idmarca_marcas_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idmarca_marcas_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(idmarca_marcas_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 158, 113, 35));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(137, 166, 246));
        jLabel13.setText("ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 192, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 166, 246));
        jLabel11.setText("Descripcion");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 192, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Marcas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 158, 194, 28));

        mostrarmarcas_marcas_field.setEditable(false);
        mostrarmarcas_marcas_field.setColumns(20);
        mostrarmarcas_marcas_field.setRows(5);
        jScrollPane1.setViewportView(mostrarmarcas_marcas_field);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 224, -1, 207));

        limpiar_marca_button.setBackground(new java.awt.Color(255, 170, 151));
        limpiar_marca_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiar_marca_button.setForeground(new java.awt.Color(87, 116, 196));
        limpiar_marca_button.setText("Limpiar");
        limpiar_marca_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_marca_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(limpiar_marca_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 281, 113, 35));

        deletemarcas_marca_button.setBackground(new java.awt.Color(255, 170, 151));
        deletemarcas_marca_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletemarcas_marca_button.setForeground(new java.awt.Color(87, 116, 196));
        deletemarcas_marca_button.setText("Eliminar");
        deletemarcas_marca_button.setEnabled(false);
        deletemarcas_marca_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletemarcas_marca_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(deletemarcas_marca_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 374, 113, 35));

        savemarca_marcas_button.setBackground(new java.awt.Color(255, 170, 151));
        savemarca_marcas_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        savemarca_marcas_button.setForeground(new java.awt.Color(87, 116, 196));
        savemarca_marcas_button.setText("Guardar");
        savemarca_marcas_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savemarca_marcas_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(savemarca_marcas_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 374, 108, 35));

        buscarmarcas_marca_button.setBackground(new java.awt.Color(255, 170, 151));
        buscarmarcas_marca_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscarmarcas_marca_button.setForeground(new java.awt.Color(87, 116, 196));
        buscarmarcas_marca_button.setText("Buscar");
        buscarmarcas_marca_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarmarcas_marca_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(buscarmarcas_marca_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 281, 108, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void desc_marcas_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc_marcas_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desc_marcas_fieldActionPerformed

    private void idmarca_marcas_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idmarca_marcas_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idmarca_marcas_fieldActionPerformed

    private void limpiar_marca_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_marca_buttonActionPerformed
        desc_marcas_field.setText("");
        idmarca_marcas_field.setText("");
        mostrarmarcas_marcas_field.setText("");
        deletemarcas_marca_button.setEnabled(false);
        idmarca_marcas_field.setEditable(true);

        mostrar_marcas();
    }//GEN-LAST:event_limpiar_marca_buttonActionPerformed

    private void deletemarcas_marca_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletemarcas_marca_buttonActionPerformed
        try {
            conexion.createStatement().executeUpdate("DELETE FROM Marcas WHERE ID_Marca = " + idmarca_marcas_field.getText());
            limpiar_marca_buttonActionPerformed(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_deletemarcas_marca_buttonActionPerformed

    private void savemarca_marcas_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savemarca_marcas_buttonActionPerformed
        try {
            if (check_string(desc_marcas_field.getText())) {
                throw new Exception("La descripción no puede contener caracteres inválidos");
            }

            conexion.createStatement().executeUpdate("EXEC guardar_marca '" + idmarca_marcas_field.getText() + "','" + desc_marcas_field.getText() + "'  ");

            limpiar_marca_buttonActionPerformed(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_savemarca_marcas_buttonActionPerformed

    private void buscarmarcas_marca_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarmarcas_marca_buttonActionPerformed
        try {

            if ("".equals(idmarca_marcas_field.getText()) || check_string(idmarca_marcas_field.getText())) {
                throw new Exception("Escriba un ID de Marca o no incluya caracteres prohibidos");
            }

            ResultSet marca = conexion.createStatement().executeQuery("SELECT Descripcion FROM Marcas WHERE ID_Marca = " + idmarca_marcas_field.getText());

            while (marca.next()) {
                desc_marcas_field.setText(marca.getString(1));
            }

            if ("".equals(desc_marcas_field.getText())) {
                throw new Exception("Esta marca no existe");
            }

            deletemarcas_marca_button.setEnabled(true);
            idmarca_marcas_field.setEditable(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_buscarmarcas_marca_buttonActionPerformed

    public void mostrar_marcas() {
        try {
            mostrarmarcas_marcas_field.setText("");
            ResultSet marcas = conexion.createStatement().executeQuery("SELECT * FROM Marcas");

            while (marcas.next()) {
                mostrarmarcas_marcas_field.append(marcas.getString(1) + "\t" + marcas.getString(2) + "\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarmarcas_marca_button;
    private javax.swing.JButton deletemarcas_marca_button;
    private javax.swing.JTextField desc_marcas_field;
    private javax.swing.JTextField idmarca_marcas_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar_marca_button;
    private javax.swing.JTextArea mostrarmarcas_marcas_field;
    private javax.swing.JButton savemarca_marcas_button;
    // End of variables declaration//GEN-END:variables
}
