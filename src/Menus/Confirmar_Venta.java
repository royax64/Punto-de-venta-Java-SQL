package Menus;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Formatter;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Confirmar_Venta extends javax.swing.JFrame {

    //Guarda el producto en el carrito de compra, la lista carrito está compuesta de varios arreglos, cada uno guardando: [0] es el nombre ,[1] es la cantidad, [2] es el precio actual del producto a comprar
    LinkedList carrito_compra = new LinkedList();
    Connection conexion;
    String id_empleado = "";
    String id_venta = "";
    String formato_ticket //String que contiene el formato para la creación de un ticket
            = "\t\t\tTICKET DE VENTA\t\t\t\n"
            + "\t\tGRACIAS POR SU COMPRA\t\t\t\n"
            + "\t\t\tID de VENTA: %s" + "\n"
            + "Dia: " + LocalDate.now() + "\t\tHora: " + LocalTime.now() + "\n"
            + "\n\n"
            + "Producto   Cantidad   $Subtotal\n";
    Float total_compra = 0f; //Variable que guarda el total de la compra por orden, solo se usa para imprimirla en el ticket

    public Confirmar_Venta(LinkedList carrito, Connection conexion, String id_empleado, String id_venta) {
        for (int i = 0; i < carrito.size(); i++) {
            carrito_compra.add(carrito.get(i));
        }
        this.conexion = conexion;
        this.id_empleado = id_empleado;
        this.id_venta = id_venta;
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

        jLabel5 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        client_field_chko = new javax.swing.JTextField();
        finalizar_venta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(137, 166, 246));
        jLabel5.setText("Confirmar Venta");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 47, 477, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(137, 166, 246));
        jLabel36.setText("¿Para qué cliente quiere que se registre la venta? Ingrese un ID");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 123, 500, -1));

        client_field_chko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                client_field_chkoActionPerformed(evt);
            }
        });
        getContentPane().add(client_field_chko, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 166, 240, 35));

        finalizar_venta.setBackground(new java.awt.Color(255, 170, 151));
        finalizar_venta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        finalizar_venta.setForeground(new java.awt.Color(87, 116, 196));
        finalizar_venta.setText("Registrar");
        finalizar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizar_ventaActionPerformed(evt);
            }
        });
        getContentPane().add(finalizar_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 169, 120, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void client_field_chkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_client_field_chkoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_client_field_chkoActionPerformed

    private void finalizar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizar_ventaActionPerformed
        try {
            Integer ID_Cliente = Integer.parseInt(client_field_chko.getText());
            Statement check_client = conexion.createStatement(); //Query para obtener el nombre solicitado
            ResultSet res = check_client.executeQuery("select Nombre from Clientes where ID_Cliente = " + ID_Cliente);

            if (!res.next() || "".equals(client_field_chko.getText())) { //Verificando el ID de cliente.
                throw new Exception("El ID del cliente no es valido o no se encuentra");
            }

            Statement registrar_venta = conexion.createStatement();
            registrar_venta.executeUpdate("EXEC añadir_ventas " + id_venta + "," + client_field_chko.getText() + "," + id_empleado);

            Statement ventas_detalle = conexion.createStatement();
            Statement disminuir_disponibilidad = conexion.createStatement();

            for (int i = 0; i < carrito_compra.size(); i++) {
                Object[] a_comprar = (Object[]) carrito_compra.get(i);
                ventas_detalle.executeUpdate("exec añadir_ventas_detalle " + id_venta + ",'" + a_comprar[0] + "'," + a_comprar[1] + "," + a_comprar[2]);
                disminuir_disponibilidad.executeUpdate("EXEC disminuir_disponibilidad " + "'" + a_comprar[0] + "'," + a_comprar[1]);
                total_compra += (Float)((int)a_comprar[1]*(float)a_comprar[2]);
                formato_ticket += (String)((String)a_comprar[0] + "\t\t" + String.valueOf(a_comprar[1]) + "\t\t" + String.valueOf(a_comprar[2]) + "\n");
            }

            crear_ticket();
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_finalizar_ventaActionPerformed

    public void crear_ticket() {
        try {
            formato_ticket += "\n\n\t\tTotal= $ %f";
            Formatter ticket = new Formatter("ticket" + id_venta + ".txt");
            ticket.format(formato_ticket, id_venta, total_compra);
            ticket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar el ticket");
        }
        JOptionPane.showMessageDialog(null, "El ticket se guardo en ticket" + id_venta + ".txt");
    }

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
            java.util.logging.Logger.getLogger(Confirmar_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Confirmar_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Confirmar_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Confirmar_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField client_field_chko;
    private javax.swing.JButton finalizar_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
