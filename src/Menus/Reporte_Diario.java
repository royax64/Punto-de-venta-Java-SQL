
package Menus;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.time.LocalDate;
import java.util.Formatter;
import javax.swing.JOptionPane;


public class Reporte_Diario extends javax.swing.JFrame {

    
    Connection conexion;
    
    public Reporte_Diario(Connection conexion) {
        this.conexion = conexion;
        initComponents();
        this.setLocationRelativeTo(null);
        get_daily_tickets();
        get_daily_productos();
        calcular_total_dia();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        refresh_prod = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        refresh_ticket = new javax.swing.JButton();
        daily_total_field = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        print2file = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        daily_report_prod_field = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        daily_report_ventas_field = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Todos los productos vendidos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 270, 28));

        refresh_prod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        refresh_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_prodActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 530, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Reporte Diario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 69, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(137, 166, 246));
        jLabel8.setText("Todos los tickets del día");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 270, 28));

        refresh_ticket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        refresh_ticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_ticketActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 770, -1, -1));

        daily_total_field.setEditable(false);
        daily_total_field.setBackground(new java.awt.Color(255, 220, 214));
        daily_total_field.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        daily_total_field.setForeground(new java.awt.Color(87, 116, 196));
        daily_total_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 170, 151)));
        daily_total_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daily_total_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(daily_total_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 630, 230, 50));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(137, 166, 246));
        jLabel72.setText("Total del día");
        getContentPane().add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, -1, -1));

        print2file.setBackground(new java.awt.Color(255, 170, 151));
        print2file.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        print2file.setForeground(new java.awt.Color(87, 116, 196));
        print2file.setText("Exportar a Archivo");
        print2file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print2fileActionPerformed(evt);
            }
        });
        getContentPane().add(print2file, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 720, 170, 35));

        daily_report_prod_field.setEditable(false);
        daily_report_prod_field.setColumns(20);
        daily_report_prod_field.setRows(5);
        jScrollPane2.setViewportView(daily_report_prod_field);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 400, 340));

        daily_report_ventas_field.setEditable(false);
        daily_report_ventas_field.setColumns(20);
        daily_report_ventas_field.setRows(5);
        jScrollPane1.setViewportView(daily_report_ventas_field);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 590, 620));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 730, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 420, 460));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 420, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refresh_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_prodActionPerformed
        try {
            get_daily_productos();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_refresh_prodActionPerformed

    private void refresh_ticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_ticketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refresh_ticketActionPerformed

    private void daily_total_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daily_total_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daily_total_fieldActionPerformed

    private void print2fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print2fileActionPerformed
        try {
            
            if("".equals(daily_report_ventas_field.getText()) || "".equals(daily_report_prod_field.getText())){
                throw new Exception ("Haga primero una venta");
            }
            
            Formatter corte = new Formatter("reporte diario.txt");

            corte.format("\tREPORTE DIARIO " + LocalDate.now() + "\n\n\tTOTAL DEL DÍA: %s \n\nTODOS LOS TICKETS: \n\n%s \n\nVENTAS DE PRODUCTOS:\n\n %s", daily_total_field.getText(), daily_report_ventas_field.getText(), daily_report_prod_field.getText());
            corte.close();
            JOptionPane.showMessageDialog(null, "Se ha guardado el corte de caja en reporte diario.txt");
            

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_print2fileActionPerformed

    
        //Icono JFrame
    @Override
    public Image getIconImage () {
    
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/LogoMedyCity.png"));
                
                return retValue;
    
    }
    
   
    
    public void get_daily_tickets (){
        try{
            daily_report_ventas_field.setText("");
            ResultSet daily_ventas = conexion.createStatement().executeQuery("EXEC daily_ventas");
            
            while(daily_ventas.next()){
                daily_report_ventas_field.append("ID\tHora\tCliente                                Empleado\n");
                Integer id_venta = daily_ventas.getInt(1);   
                
                daily_report_ventas_field.append(daily_ventas.getString(1) + "\t" + daily_ventas.getString(2) + "               " + daily_ventas.getString(3) + "                " + daily_ventas.getString(4) + "\n" );
                daily_report_ventas_field.append("\nCantidad      Precio Unitario\tSubtotal\tProducto\n");
                
                
                ResultSet ticket = conexion.createStatement().executeQuery("select * from dbo.regresar_ticket (" + id_venta + ")");
                while(ticket.next()){
                    daily_report_ventas_field.append(ticket.getString(1) + "                    " + ticket.getString(2) + "\t" + ticket.getString(3) + "\t" + ticket.getString(4) + "\n");
                }
             
                
                ResultSet total = conexion.createStatement().executeQuery("select dbo.calcular_venta (" + id_venta + ")");
                
                while(total.next()){
                    daily_report_ventas_field.append("\nTOTAL DE VENTA: $" + total.getString(1) + "\n");
                }
                
                daily_report_ventas_field.append("-------------------------------------------------------------------------------------------------------------------------------------\n\n");
            }
            
            if("".equals(daily_report_ventas_field.getText())){
                throw new Exception("No hay ventas hechas hoy...");
            }
            
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public void get_daily_productos(){
        try{
            daily_report_prod_field.setText("");
            ResultSet daily_prod = conexion.createStatement().executeQuery("EXEC daily_ventas_productos");
            
            daily_report_prod_field.append("ID        Cantidad Vendida             Total                     Nombre\n");
            while(daily_prod.next()){
                daily_report_prod_field.append(daily_prod.getString(1) + "\t" + daily_prod.getString(2) + "\t" + daily_prod.getString(3) + "\t" + daily_prod.getString(4) + "\n");
            }
            
            
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
    }
    
    
        private void calcular_total_dia() {
        try {
            //El select va a calcular el total del dia
            ResultSet totales = conexion.createStatement().executeQuery("select ROUND(SUM(Cantidad * Precio_Unitario),2) from Ventas_Detalle vd INNER JOIN Ventas_Header vh on vh.ID_Venta = vd.ID_Venta WHERE Fecha = cast(getdate() as date)");

            while (totales.next()) {
                if (totales.getString(1) == null) {
                    daily_total_field.setText("$0");
                } else {
                    daily_total_field.setText("$" + totales.getString(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reporte_Diario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte_Diario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte_Diario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte_Diario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea daily_report_prod_field;
    private javax.swing.JTextArea daily_report_ventas_field;
    private javax.swing.JTextField daily_total_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton print2file;
    private javax.swing.JButton refresh_prod;
    private javax.swing.JButton refresh_ticket;
    // End of variables declaration//GEN-END:variables
}
