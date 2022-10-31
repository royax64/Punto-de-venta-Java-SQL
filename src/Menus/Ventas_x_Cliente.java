package Menus;

import static Menus.Menu.check_string;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

public class Ventas_x_Cliente extends javax.swing.JFrame {

    Connection conexion;

    public Ventas_x_Cliente(Connection conexion) {
        this.conexion = conexion;
        initComponents();
        this.setLocationRelativeTo(null);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        mostrar_ventaidcliente_field = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        buscar_ventaidcliente_field = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buscar_ventaidcliente_button = new javax.swing.JButton();
        prod_mascomprado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        clear_ventaidcliente_field = new javax.swing.JButton();
        total_ventaidcliente_field = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setBackground(new java.awt.Color(255, 204, 204));
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mostrar_ventaidcliente_field.setEditable(false);
        mostrar_ventaidcliente_field.setColumns(20);
        mostrar_ventaidcliente_field.setRows(5);
        jScrollPane1.setViewportView(mostrar_ventaidcliente_field);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 271, 397, 207));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(137, 166, 246));
        jLabel18.setText("Producto más comprado");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(137, 166, 246));
        jLabel13.setText("ID Venta");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 239, -1, -1));

        buscar_ventaidcliente_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_ventaidcliente_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(buscar_ventaidcliente_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 158, 144, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Ventas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 205, 194, 28));

        buscar_ventaidcliente_button.setBackground(new java.awt.Color(255, 170, 151));
        buscar_ventaidcliente_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar_ventaidcliente_button.setForeground(new java.awt.Color(87, 116, 196));
        buscar_ventaidcliente_button.setText("Buscar");
        buscar_ventaidcliente_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_ventaidcliente_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(buscar_ventaidcliente_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 157, 137, 35));

        prod_mascomprado.setEditable(false);
        prod_mascomprado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prod_mascompradoActionPerformed(evt);
            }
        });
        getContentPane().add(prod_mascomprado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 144, 35));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 166, 246));
        jLabel11.setText("Total de venta");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 239, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Buscar compras de clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 69, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(137, 166, 246));
        jLabel16.setText("Buscar cliente ID");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 160, -1, -1));

        clear_ventaidcliente_field.setBackground(new java.awt.Color(255, 170, 151));
        clear_ventaidcliente_field.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clear_ventaidcliente_field.setForeground(new java.awt.Color(87, 116, 196));
        clear_ventaidcliente_field.setText("Limpiar");
        clear_ventaidcliente_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_ventaidcliente_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(clear_ventaidcliente_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 205, 137, 35));

        total_ventaidcliente_field.setEditable(false);
        total_ventaidcliente_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_ventaidcliente_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(total_ventaidcliente_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 443, 144, 35));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(137, 166, 246));
        jLabel17.setText("Total Ventas");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 406, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 730, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_ventaidcliente_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_ventaidcliente_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_ventaidcliente_fieldActionPerformed

    private void buscar_ventaidcliente_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_ventaidcliente_buttonActionPerformed
        try {

            mostrar_ventaidcliente_field.setText(null);

            if ("".equals(buscar_ventaidcliente_field.getText()) || check_string(buscar_ventaidcliente_field.getText())) {
                throw new Exception("Escriba un ID de Proveedor o no incluya caracteres prohibidos");
            }

            ResultSet ventasxcliente = conexion.createStatement().executeQuery("select ID_Venta, dbo.calcular_venta(ID_Venta) from Ventas_Header WHERE ID_Cliente = " + buscar_ventaidcliente_field.getText());
            ResultSet totalventasxcliente = conexion.createStatement().executeQuery("select ROUND(SUM(dbo.calcular_venta(ID_Venta)),2) from Ventas_Header WHERE ID_Cliente = " + buscar_ventaidcliente_field.getText());
            
            String prodmascomprado_query = "SELECT TOP 1 p.Nombre FROM Ventas_Detalle vd\n" +
                                            "INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta\n" +
                                            "INNER JOIN Productos_Header p ON p.ID_Producto = vd.ID_Producto\n" +
                                            "WHERE vh.ID_Cliente = " + buscar_ventaidcliente_field.getText() + "\n" +
                                            "GROUP BY p.ID_Producto, p.Nombre\n" +
                                            "ORDER BY SUM(vd.Cantidad) DESC";
            
            ResultSet prodmascomprado = conexion.createStatement().executeQuery(prodmascomprado_query);

            while (ventasxcliente.next()) {
                mostrar_ventaidcliente_field.append(ventasxcliente.getString(1) + "\t$" + ventasxcliente.getString(2) + "\n");
            }
            
            if ("".equals(mostrar_ventaidcliente_field.getText())) {
                throw new Exception("Las compras del cliente no ha sido encontrados");
            }

            while (totalventasxcliente.next()) {
                total_ventaidcliente_field.setText("$" + totalventasxcliente.getString(1));
            }
            
            while (prodmascomprado.next()){
                prod_mascomprado.setText(prodmascomprado.getString(1));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_buscar_ventaidcliente_buttonActionPerformed

    private void clear_ventaidcliente_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_ventaidcliente_fieldActionPerformed
        buscar_ventaidcliente_field.setText("");
        mostrar_ventaidcliente_field.setText("");
        total_ventaidcliente_field.setText("");
    }//GEN-LAST:event_clear_ventaidcliente_fieldActionPerformed

    private void total_ventaidcliente_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_ventaidcliente_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_ventaidcliente_fieldActionPerformed

    private void prod_mascompradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prod_mascompradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prod_mascompradoActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventas_x_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas_x_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas_x_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas_x_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar_ventaidcliente_button;
    private javax.swing.JTextField buscar_ventaidcliente_field;
    private javax.swing.JButton clear_ventaidcliente_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mostrar_ventaidcliente_field;
    private javax.swing.JTextField prod_mascomprado;
    private javax.swing.JTextField total_ventaidcliente_field;
    // End of variables declaration//GEN-END:variables
}
