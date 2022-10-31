
package Usuarios;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class Administrar_Usuarios extends javax.swing.JFrame {

    Connection conexion;
    String old_rol = ""; //Variable que guarda el antiguo rol del usuario, solo es usada para actualizar el rol si es que se decide cambiar de rol
    static String[] caracteres_prohibidos = {";","*",",","+","(",")","=","\\","\"","/","{","}"}; //STRING DE CARACTERES PROHIBIDOS

    public Administrar_Usuarios(Connection conexion) {
        this.conexion = conexion;
        initComponents();
        this.setLocationRelativeTo(null);
        
        mostrar_usuarios();
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
        buscar_usuario_field = new javax.swing.JTextField();
        buscar_usuario_botton = new javax.swing.JButton();
        save_usuario_button = new javax.swing.JButton();
        clean_botton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrar_usuarios = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        rol_field = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        id_empleado_field = new javax.swing.JTextField();
        delete_user_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Administrar Usuarios y Roles");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 69, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(137, 166, 246));
        jLabel16.setText("Buscar usuario");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 160, -1, -1));

        buscar_usuario_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_usuario_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(buscar_usuario_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 158, 211, 35));

        buscar_usuario_botton.setBackground(new java.awt.Color(255, 170, 151));
        buscar_usuario_botton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar_usuario_botton.setForeground(new java.awt.Color(87, 116, 196));
        buscar_usuario_botton.setText("Buscar");
        buscar_usuario_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_usuario_bottonActionPerformed(evt);
            }
        });
        getContentPane().add(buscar_usuario_botton, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 157, 110, 35));

        save_usuario_button.setBackground(new java.awt.Color(255, 170, 151));
        save_usuario_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        save_usuario_button.setForeground(new java.awt.Color(87, 116, 196));
        save_usuario_button.setText("Guardar Cambios");
        save_usuario_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_usuario_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(save_usuario_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 170, 40));

        clean_botton.setBackground(new java.awt.Color(255, 170, 151));
        clean_botton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clean_botton.setForeground(new java.awt.Color(87, 116, 196));
        clean_botton.setText("Cancelar");
        clean_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clean_bottonActionPerformed(evt);
            }
        });
        getContentPane().add(clean_botton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 170, 35));

        mostrar_usuarios.setEditable(false);
        mostrar_usuarios.setColumns(20);
        mostrar_usuarios.setRows(5);
        jScrollPane1.setViewportView(mostrar_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 225, 397, 207));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(137, 166, 246));
        jLabel13.setText("ID (Usuario)");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 199, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Lista de Usuarios");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 158, 194, 28));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 166, 246));
        jLabel11.setText("Rol");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 199, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(137, 166, 246));
        jLabel14.setText("Rol");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 272, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(137, 166, 246));
        jLabel9.setText("Nueva Contraseña");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 272, -1, -1));
        getContentPane().add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 303, 214, 35));

        rol_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GERENTE", "EMPLEADO" }));
        rol_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rol_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(rol_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 303, 122, 35));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(137, 166, 246));
        jLabel17.setText("ID Empleado");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 227, -1, -1));

        id_empleado_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_empleado_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(id_empleado_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 225, 93, 35));

        delete_user_button.setBackground(new java.awt.Color(255, 170, 151));
        delete_user_button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        delete_user_button.setForeground(new java.awt.Color(87, 116, 196));
        delete_user_button.setText("Eliminar Usuario");
        delete_user_button.setEnabled(false);
        delete_user_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_user_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(delete_user_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 331, 160, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 470));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 260, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_usuario_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_usuario_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_usuario_fieldActionPerformed

    private void buscar_usuario_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_usuario_bottonActionPerformed
        try {
            
            if(check_string (buscar_usuario_field.getText()) || "".equals(buscar_usuario_field.getText())){
                throw new Exception("Ingrese bien los campos o contienen caracteres prohibidos");
            }
            ResultSet usuario = conexion.createStatement().executeQuery("select u.ID_Empleado, r.Descripcion from Usuarios u INNER JOIN Roles r ON u.ID_Rol = r.ID_Rol INNER JOIN Empleados e on e.ID_Empleado = u.ID_Empleado where u.ID_Empleado = " + Integer.parseInt(buscar_usuario_field.getText()));

            while (usuario.next()) {
                id_empleado_field.setText(usuario.getString(1));
                password_field.setText(null);
                rol_field.setSelectedItem((String) usuario.getString(2));
                old_rol = (String) usuario.getString(2);
            }

            if ("".equals(id_empleado_field.getText())) {
                throw new Exception("El usuario no ha sido encontrado");
            }

            id_empleado_field.setEditable(false);
            delete_user_button.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_buscar_usuario_bottonActionPerformed

    private void save_usuario_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_usuario_buttonActionPerformed
        try {
            Integer id_empleado = Integer.parseInt(id_empleado_field.getText());
            String password = password_field.getText();
            String rol = (String) rol_field.getSelectedItem();

            if (check_string(password) || "".equals(password)) {
                throw new Exception("La contraseña no puede estar vacia o con caracteres invalidos");
            }

            if ("".equals(buscar_usuario_field.getText())) {
                conexion.createStatement().executeUpdate("CREATE LOGIN [" + id_empleado + "] WITH PASSWORD = '" + password + "'"); //Creando nuevo usuario, login, y asignandole el rol
                conexion.createStatement().executeUpdate("CREATE USER [" + id_empleado + "] FOR LOGIN [" + id_empleado + "]");
                conexion.createStatement().executeUpdate("ALTER ROLE " + rol + " ADD MEMBER [" + id_empleado + "]");
                conexion.createStatement().executeUpdate("exec agregar_usuario [" + id_empleado + "], [" + rol + "]"); //Añadiendo a tabla usuarios
            } else {
                conexion.createStatement().executeUpdate("ALTER LOGIN [" + id_empleado + "] WITH PASSWORD = '" + password + "'"); //Modificando el usuario, login, y cambiando el rol
                conexion.createStatement().executeUpdate("ALTER ROLE " + old_rol + " DROP MEMBER [" + id_empleado + "]");
                conexion.createStatement().executeUpdate("ALTER ROLE " + rol + " ADD MEMBER [" + id_empleado + "]");
                conexion.createStatement().executeUpdate("exec agregar_usuario [" + id_empleado + "], [" + rol + "]"); //Añadiendo a tabla usuarios
            }

            //El string dar_permisos_importantes da permisos necesarios globales para que el programa jale.
            String dar_permisos_importantes = "use [master];\n"
                    + "GRANT ALTER ANY CREDENTIAL TO [" + id_empleado + "];\n"
                    + "GRANT ALTER ANY DATABASE TO [" + id_empleado + "];\n"
                    + "GRANT ALTER ANY LOGIN TO [" + id_empleado + "];\n"
                    + "GRANT ALTER ANY SERVER ROLE TO [" + id_empleado + "];\n"
                    + "GRANT CONNECT ANY DATABASE TO [" + id_empleado + "];\n"
                    + "GRANT CONNECT SQL TO [" + id_empleado + "];\n"
                    + "GRANT CONTROL SERVER TO [" + id_empleado + "];\n"
                    + "USE [Medicity];";

            if ("GERENTE".equals((String) rol_field.getSelectedItem())) conexion.createStatement().executeUpdate(dar_permisos_importantes);

            mostrar_usuarios();
            clean_bottonActionPerformed(null);
            JOptionPane.showMessageDialog(null, "Aviso: Tendrá que reiniciar el programa para aplicar los cambios.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_save_usuario_buttonActionPerformed

    private void clean_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clean_bottonActionPerformed
        password_field.setText(null);
        buscar_usuario_field.setText(null);
        id_empleado_field.setText(null);
        delete_user_button.setEnabled(false);
        id_empleado_field.setEditable(true);

        mostrar_usuarios();
    }//GEN-LAST:event_clean_bottonActionPerformed

    private static Boolean check_string(String s) { //Funcion que checa las queries por motivos de seguridad
        return Arrays.stream(caracteres_prohibidos).anyMatch(s::contains);
    }

    public void mostrar_usuarios() {
        mostrar_usuarios.setText("");
        try {
            ResultSet lista_usuarios = conexion.createStatement().executeQuery("select u.ID_Empleado, r.Descripcion from Usuarios u INNER JOIN Roles r ON u.ID_Rol = r.ID_Rol");

            while (lista_usuarios.next()) {
                mostrar_usuarios.append(lista_usuarios.getString(1) + "\t" + lista_usuarios.getString(2) + "\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void rol_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rol_fieldActionPerformed
    }//GEN-LAST:event_rol_fieldActionPerformed

    private void id_empleado_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_empleado_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_empleado_fieldActionPerformed

    private void delete_user_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_user_buttonActionPerformed

        try {
            String id_empleado = buscar_usuario_field.getText();
            String password = password_field.getText();
            String rol = (String) rol_field.getSelectedItem();

            if ("".equals(id_empleado) || check_string(id_empleado)) {
                throw new Exception("Busque un usuario antes de eliminarlo o ha ingresado caracteres prohibidos");
            }

            conexion.createStatement().executeUpdate("ALTER ROLE [" + rol + "] DROP MEMBER [" + id_empleado + "]");
            conexion.createStatement().executeUpdate("DELETE FROM Usuarios where ID_Empleado = " + id_empleado);
            conexion.createStatement().executeUpdate("DROP USER [" + id_empleado + "]; DROP LOGIN [" + id_empleado + "];");

            mostrar_usuarios();
            clean_bottonActionPerformed(null);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_delete_user_buttonActionPerformed

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar_usuario_botton;
    private javax.swing.JTextField buscar_usuario_field;
    private javax.swing.JButton clean_botton;
    private javax.swing.JButton delete_user_button;
    private javax.swing.JTextField id_empleado_field;
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
    private javax.swing.JTextArea mostrar_usuarios;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JComboBox<String> rol_field;
    private javax.swing.JButton save_usuario_button;
    // End of variables declaration//GEN-END:variables
}
