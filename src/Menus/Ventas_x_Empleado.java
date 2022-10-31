
package Menus;

import static Menus.Menu.check_string;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;


public class Ventas_x_Empleado extends javax.swing.JFrame {

    Connection conexion;

    public Ventas_x_Empleado(Connection conexion) {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrar_ventaidempleado_field = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        buscar_ventaidempleado_field = new javax.swing.JTextField();
        buscar_ventaidempleado_botton = new javax.swing.JButton();
        clear_ventaidempleado_button = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        prod_masvendido = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        total_ventaidempleado_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Buscar ventas de empleados");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 69, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(137, 166, 246));
        jLabel16.setText("Buscar empleado ID");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Ventas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 206, 194, 28));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(137, 166, 246));
        jLabel13.setText("ID Venta");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 246, -1, -1));

        mostrar_ventaidempleado_field.setEditable(false);
        mostrar_ventaidempleado_field.setColumns(20);
        mostrar_ventaidempleado_field.setRows(5);
        jScrollPane1.setViewportView(mostrar_ventaidempleado_field);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 278, 397, 207));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 166, 246));
        jLabel11.setText("Total de venta");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 246, -1, -1));

        buscar_ventaidempleado_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_ventaidempleado_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(buscar_ventaidempleado_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 158, 144, 35));

        buscar_ventaidempleado_botton.setBackground(new java.awt.Color(255, 170, 151));
        buscar_ventaidempleado_botton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar_ventaidempleado_botton.setForeground(new java.awt.Color(87, 116, 196));
        buscar_ventaidempleado_botton.setText("Buscar");
        buscar_ventaidempleado_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_ventaidempleado_bottonActionPerformed(evt);
            }
        });
        getContentPane().add(buscar_ventaidempleado_botton, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 157, 137, 35));

        clear_ventaidempleado_button.setBackground(new java.awt.Color(255, 170, 151));
        clear_ventaidempleado_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clear_ventaidempleado_button.setForeground(new java.awt.Color(87, 116, 196));
        clear_ventaidempleado_button.setText("Limpiar");
        clear_ventaidempleado_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_ventaidempleado_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(clear_ventaidempleado_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 205, 137, 35));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(137, 166, 246));
        jLabel18.setText("Producto más vendido");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        prod_masvendido.setEditable(false);
        prod_masvendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prod_masvendidoActionPerformed(evt);
            }
        });
        getContentPane().add(prod_masvendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 144, 35));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(137, 166, 246));
        jLabel17.setText("Total Ventas");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 413, -1, -1));

        total_ventaidempleado_field.setEditable(false);
        total_ventaidempleado_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_ventaidempleado_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(total_ventaidempleado_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 450, 144, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 440));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 436, 760, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_ventaidempleado_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_ventaidempleado_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_ventaidempleado_fieldActionPerformed

    private void buscar_ventaidempleado_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_ventaidempleado_bottonActionPerformed
        try {

            mostrar_ventaidempleado_field.setText(null);

            if ("".equals(buscar_ventaidempleado_field.getText()) || check_string(buscar_ventaidempleado_field.getText())) {
                throw new Exception("Escriba un ID de Proveedor o no incluya caracteres prohibidos");
            }

            ResultSet ventasxempleado = conexion.createStatement().executeQuery("select ID_Venta, dbo.calcular_venta(ID_Venta) from Ventas_Header WHERE ID_Empleado = " + buscar_ventaidempleado_field.getText());
            ResultSet totalventasxempleado = conexion.createStatement().executeQuery("select ROUND(SUM(dbo.calcular_venta(ID_Venta)),2) from Ventas_Header WHERE ID_Empleado = " + buscar_ventaidempleado_field.getText());
            
            
            String prodmasvendido_query = "SELECT TOP 1 p.Nombre FROM Ventas_Detalle vd\n" +
                                            "INNER JOIN Ventas_Header vh ON vh.ID_Venta = vd.ID_Venta\n" +
                                            "INNER JOIN Productos_Header p ON p.ID_Producto = vd.ID_Producto\n" +
                                            "WHERE vh.ID_Empleado = " + buscar_ventaidempleado_field.getText() + "\n" +
                                            "GROUP BY p.ID_Producto, p.Nombre\n" +
                                            "ORDER BY SUM(vd.Cantidad) DESC";
            
            ResultSet prodmasvendido = conexion.createStatement().executeQuery(prodmasvendido_query);

            while (ventasxempleado.next()) {
                mostrar_ventaidempleado_field.append(ventasxempleado.getString(1) + "\t$" + ventasxempleado.getString(2) + "\n");
            }
            
            if ("".equals(mostrar_ventaidempleado_field.getText())) {
                throw new Exception("Las ventas de este empleado no ha sido encontradas");
            }

            while (totalventasxempleado.next()) {
                total_ventaidempleado_field.setText("$" + totalventasxempleado.getString(1));
            }
            
            while (prodmasvendido.next()){
                prod_masvendido.setText(prodmasvendido.getString(1));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_buscar_ventaidempleado_bottonActionPerformed

    private void clear_ventaidempleado_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_ventaidempleado_buttonActionPerformed
        buscar_ventaidempleado_field.setText("");
        mostrar_ventaidempleado_field.setText("");
        total_ventaidempleado_field.setText("");
    }//GEN-LAST:event_clear_ventaidempleado_buttonActionPerformed

    private void total_ventaidempleado_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_ventaidempleado_fieldActionPerformed

    }//GEN-LAST:event_total_ventaidempleado_fieldActionPerformed

    private void prod_masvendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prod_masvendidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prod_masvendidoActionPerformed


    public static void main(String args[]) {


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar_ventaidempleado_botton;
    private javax.swing.JTextField buscar_ventaidempleado_field;
    private javax.swing.JButton clear_ventaidempleado_button;
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
    private javax.swing.JTextArea mostrar_ventaidempleado_field;
    private javax.swing.JTextField prod_masvendido;
    private javax.swing.JTextField total_ventaidempleado_field;
    // End of variables declaration//GEN-END:variables
}
