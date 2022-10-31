package Menus;

import static Menus.Menu.check_string;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Administrar_Proveedores extends javax.swing.JFrame {

    Connection conexion;

    public Administrar_Proveedores(Connection conexion) {
        this.conexion = conexion;
        initComponents();
        this.setLocationRelativeTo(null);
        
        get_marcas_campos(); //Funcion que obtiene una lista de las marcas de la tabla marcas para mostrarla en el campo Marcas de Proveedor
        mostrar_proveedores(); //Funcion que imprime los proveedores en el campo grande ese

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

        jLabel9 = new javax.swing.JLabel();
        buscar_proveedor_field = new javax.swing.JTextField();
        buscar_proveedor_botton = new javax.swing.JButton();
        marca_proveedor_field = new javax.swing.JComboBox<>();
        save_proveedor_button = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cancelar_proveedor_botton = new javax.swing.JButton();
        name_proveedor_field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrar_proveedores = new javax.swing.JTextArea();
        delete_proveedor_button = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        telefono_proveedor_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(137, 166, 246));
        jLabel9.setText("Telefono");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 272, -1, -1));

        buscar_proveedor_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_proveedor_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(buscar_proveedor_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 158, 201, 35));

        buscar_proveedor_botton.setBackground(new java.awt.Color(255, 170, 151));
        buscar_proveedor_botton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar_proveedor_botton.setForeground(new java.awt.Color(87, 116, 196));
        buscar_proveedor_botton.setText("Buscar");
        buscar_proveedor_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_proveedor_bottonActionPerformed(evt);
            }
        });
        getContentPane().add(buscar_proveedor_botton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 157, 120, 35));

        marca_proveedor_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marca_proveedor_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(marca_proveedor_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 303, 162, 35));

        save_proveedor_button.setBackground(new java.awt.Color(255, 170, 151));
        save_proveedor_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        save_proveedor_button.setForeground(new java.awt.Color(87, 116, 196));
        save_proveedor_button.setText("Guardar Cambios");
        save_proveedor_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_proveedor_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(save_proveedor_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 225, 160, 35));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(137, 166, 246));
        jLabel17.setText("Nombre");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 227, -1, -1));

        cancelar_proveedor_botton.setBackground(new java.awt.Color(255, 170, 151));
        cancelar_proveedor_botton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar_proveedor_botton.setForeground(new java.awt.Color(87, 116, 196));
        cancelar_proveedor_botton.setText("Cancelar");
        cancelar_proveedor_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_proveedor_bottonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar_proveedor_botton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 278, 137, 35));

        name_proveedor_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_proveedor_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(name_proveedor_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 225, 180, 35));

        mostrar_proveedores.setEditable(false);
        mostrar_proveedores.setColumns(20);
        mostrar_proveedores.setRows(5);
        jScrollPane1.setViewportView(mostrar_proveedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 225, 397, 207));

        delete_proveedor_button.setBackground(new java.awt.Color(255, 170, 151));
        delete_proveedor_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete_proveedor_button.setForeground(new java.awt.Color(87, 116, 196));
        delete_proveedor_button.setText("Eliminar");
        delete_proveedor_button.setEnabled(false);
        delete_proveedor_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_proveedor_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(delete_proveedor_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 331, 137, 35));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(137, 166, 246));
        jLabel13.setText("ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 199, 20, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Lista de Proveedores");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 158, 194, 28));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 166, 246));
        jLabel11.setText("Nombre");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 199, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Administrar Proveedores");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 69, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(137, 166, 246));
        jLabel14.setText("Marca");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 272, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(137, 166, 246));
        jLabel16.setText("Buscar por ID");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 160, -1, -1));
        getContentPane().add(telefono_proveedor_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 303, 174, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 460));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(817, -4, 270, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_proveedor_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_proveedor_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_proveedor_fieldActionPerformed

    private void buscar_proveedor_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_proveedor_bottonActionPerformed
        try {

            if ("".equals(buscar_proveedor_field.getText()) || check_string(buscar_proveedor_field.getText())) {
                throw new Exception("Escriba un ID de Proveedor o no incluya caracteres prohibidos");
            }

            ResultSet proveedores = conexion.createStatement().executeQuery("select Nombre, m.Descripcion, Telefono from Proveedores p INNER JOIN Marcas m ON m.ID_Marca = p.ID_Marca where ID_Proveedor = " + buscar_proveedor_field.getText());

            while (proveedores.next()) {
                name_proveedor_field.setText(proveedores.getString(1));
                telefono_proveedor_field.setText(proveedores.getString(3));
                marca_proveedor_field.setSelectedItem((String) proveedores.getString(2));
            }

            if ("".equals(name_proveedor_field.getText())) {
                throw new Exception("El proveedor no ha sido encontrado, si busca añadir uno nuevo entonces no llene esta casilla");
            }

            buscar_proveedor_field.setEditable(false);
            delete_proveedor_button.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_buscar_proveedor_bottonActionPerformed

    private void marca_proveedor_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marca_proveedor_fieldActionPerformed

    }//GEN-LAST:event_marca_proveedor_fieldActionPerformed

    private void save_proveedor_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_proveedor_buttonActionPerformed
        try {
            String id_proveedor = buscar_proveedor_field.getText();
            String nombre = name_proveedor_field.getText();
            String telefono = telefono_proveedor_field.getText();
            String marca = (String) marca_proveedor_field.getSelectedItem();
            
            if ("".equals(nombre) || "".equals(telefono) || check_string(nombre) || check_string(telefono) || check_string (id_proveedor) ){
                throw new Exception ("Asegurese de que los campos estén llenados o de que no contengan caracteres prohibidos");
            }
            
            if ("".equals(id_proveedor)){ //Si es un nuevo proveedor
                conexion.createStatement().executeUpdate("EXEC guardar_proveedores 0, '" + nombre + "', '" + marca + "', '" + telefono + "'");
            } else { //Si modificamos el existente
                conexion.createStatement().executeUpdate("EXEC guardar_proveedores " + id_proveedor + ", '" + nombre + "', '" + marca + "', '" + telefono + "'");
            }

            cancelar_proveedor_bottonActionPerformed(null);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_save_proveedor_buttonActionPerformed

    private void cancelar_proveedor_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_proveedor_bottonActionPerformed
        telefono_proveedor_field.setText(null);
        buscar_proveedor_field.setText(null);
        name_proveedor_field.setText(null);
        delete_proveedor_button.setEnabled(false);
        buscar_proveedor_field.setText(null);
        buscar_proveedor_field.setEditable(true);
        
        get_marcas_campos();
        mostrar_proveedores();

    }//GEN-LAST:event_cancelar_proveedor_bottonActionPerformed

    private void name_proveedor_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_proveedor_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_proveedor_fieldActionPerformed

    private void delete_proveedor_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_proveedor_buttonActionPerformed

        try {
            String id_proveedor = buscar_proveedor_field.getText();

            if ("".equals(id_proveedor) || check_string(id_proveedor)) {
                throw new Exception("Busque un usuario antes de eliminarlo o ha ingresado caracteres prohibidos");
            }

            conexion.createStatement().executeUpdate("delete Proveedores where ID_Proveedor = " + id_proveedor);
            cancelar_proveedor_bottonActionPerformed(null);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_delete_proveedor_buttonActionPerformed

    public void get_marcas_campos() {

        try {
            //Seleccionamos todas las marcas
            ResultSet result = conexion.createStatement().executeQuery("SELECT Descripcion from Marcas");

            //Lista en la que añadiremos las marcas
            LinkedList marcas = new LinkedList();

            while (result.next()) {
                //Una por una
                marcas.add(result.getString(1));
            }

            //Si no hay nada en la lista, entonces error
            if (marcas.isEmpty()) {
                throw new Exception("Asegúrese de tener marcas para enlazar los proveedores");
            }

            //Aca vamos a inicializar un nuevo arreglo de String
            String[] marcas_model = new String[marcas.size()];

            //Y vamos a llenar dicho arreglo con la lista usando la función toArray para convertirla
            marcas.toArray(marcas_model);

            //SetModel nos va a establecer los campos en dicho menu de lista de acuerdo a lo que haya en el arreglo.
            marca_proveedor_field.setModel(new javax.swing.DefaultComboBoxModel<>(marcas_model));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public void mostrar_proveedores() {

        try {
            mostrar_proveedores.setText("");
            ResultSet res = conexion.createStatement().executeQuery("SELECT ID_Proveedor, Nombre from Proveedores");

            while (res.next()) {
                mostrar_proveedores.append(res.getString(1) + "\t" + res.getString(2) + "\n");
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
            java.util.logging.Logger.getLogger(Administrar_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrar_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrar_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrar_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar_proveedor_botton;
    private javax.swing.JTextField buscar_proveedor_field;
    private javax.swing.JButton cancelar_proveedor_botton;
    private javax.swing.JButton delete_proveedor_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> marca_proveedor_field;
    private javax.swing.JTextArea mostrar_proveedores;
    private javax.swing.JTextField name_proveedor_field;
    private javax.swing.JButton save_proveedor_button;
    private javax.swing.JTextField telefono_proveedor_field;
    // End of variables declaration//GEN-END:variables

}
