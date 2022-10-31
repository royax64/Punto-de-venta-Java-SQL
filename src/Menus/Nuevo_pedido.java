package Menus;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JOptionPane;

public class Nuevo_pedido extends javax.swing.JFrame {

    Integer id_empleado = 0; //Entero que guarda el id_empleado a registrar el pedido, siempre se usará el de la sesión activa
    String nombres_pedidos = ""; //Es un string que trae dentro todos los nombres de los productos de los strings, no sirve para nada pero para asegurar que no ingresemos más de 2 productos iguales.
    Connection conexion; //Objecto de conexion
    Integer id_pedido = 0; //Variable que trae el id_pedido más alto en la DB para usarlo en el siguiente nuevo pedido.
    LinkedList pedido = new LinkedList(); //Lista con todos los productos a pedir, parecido a ventas, donde cada elemento trae un arreglo para cada producto con lo siguiente:
    //[0] = ID_producto, [1] = cantidad_agregar, [2] = precio_mayoreo, [3] = Nombre_producto

    public Nuevo_pedido(Connection conexion, Integer id_empleado) {
        this.id_empleado = id_empleado;
        this.conexion = conexion;
        buscar_idpedido_reciente(); //Funcion que busca dicho id_pedido más alto para incrementarlo en uno y así usarlo en el siguiente pedido
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
        id_proveedor_field = new javax.swing.JTextField();
        buscar_proveedor_pedido_botton = new javax.swing.JButton();
        agregar_producto_pedido_button = new javax.swing.JButton();
        cancelar_pedido_button = new javax.swing.JButton();
        id_producto_field = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrar_pedido = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mas_cantidad_field = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        precio_mayoreo_field = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        terminar_pedido_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Nuevo pedido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 56, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(137, 166, 246));
        jLabel16.setText("ID Proveedor");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 147, -1, -1));

        id_proveedor_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_proveedor_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(id_proveedor_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 145, 220, 35));

        buscar_proveedor_pedido_botton.setBackground(new java.awt.Color(255, 170, 151));
        buscar_proveedor_pedido_botton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar_proveedor_pedido_botton.setForeground(new java.awt.Color(87, 116, 196));
        buscar_proveedor_pedido_botton.setText("Buscar");
        buscar_proveedor_pedido_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_proveedor_pedido_bottonActionPerformed(evt);
            }
        });
        getContentPane().add(buscar_proveedor_pedido_botton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 90, 35));

        agregar_producto_pedido_button.setBackground(new java.awt.Color(255, 170, 151));
        agregar_producto_pedido_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregar_producto_pedido_button.setForeground(new java.awt.Color(87, 116, 196));
        agregar_producto_pedido_button.setText("Agregar a pedido");
        agregar_producto_pedido_button.setEnabled(false);
        agregar_producto_pedido_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_producto_pedido_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(agregar_producto_pedido_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 271, 170, 35));

        cancelar_pedido_button.setBackground(new java.awt.Color(255, 170, 151));
        cancelar_pedido_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar_pedido_button.setForeground(new java.awt.Color(87, 116, 196));
        cancelar_pedido_button.setText("Cancelar");
        cancelar_pedido_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_pedido_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar_pedido_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 294, 137, 35));

        id_producto_field.setEditable(false);
        id_producto_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_producto_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(id_producto_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 218, 93, 35));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(137, 166, 246));
        jLabel17.setText("ID Producto");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 212, -1, -1));

        mostrar_pedido.setEditable(false);
        mostrar_pedido.setColumns(20);
        mostrar_pedido.setRows(5);
        jScrollPane1.setViewportView(mostrar_pedido);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 191, 263, 207));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(137, 166, 246));
        jLabel13.setText("ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 157, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 166, 246));
        jLabel11.setText("Cantidad");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 157, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Productos en pedido");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 116, 194, 28));

        mas_cantidad_field.setEditable(false);
        mas_cantidad_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mas_cantidad_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(mas_cantidad_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 272, 93, 35));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(137, 166, 246));
        jLabel18.setText("Cantidad a pedir");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 274, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(137, 166, 246));
        jLabel19.setText("Precio Mayoreo");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 327, -1, -1));

        precio_mayoreo_field.setEditable(false);
        precio_mayoreo_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio_mayoreo_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(precio_mayoreo_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 325, 93, 35));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(137, 166, 246));
        jLabel12.setText("Costo mayoreo");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 157, -1, -1));

        terminar_pedido_button.setBackground(new java.awt.Color(255, 170, 151));
        terminar_pedido_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        terminar_pedido_button.setForeground(new java.awt.Color(87, 116, 196));
        terminar_pedido_button.setText("Terminar");
        terminar_pedido_button.setEnabled(false);
        terminar_pedido_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminar_pedido_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(terminar_pedido_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 137, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 250, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_proveedor_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_proveedor_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_proveedor_fieldActionPerformed

    private void buscar_proveedor_pedido_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_proveedor_pedido_bottonActionPerformed
        try {
            if ("".equals(id_proveedor_field.getText())) {
                throw new Exception("Asegurese de llenar bien el campo");
            }
            //Checando si existe el proveedor ingresado, para ello buscaremos el nombre del proveedor dado su id, cabe destacar que el nombre no se va a usar.
            ResultSet checar_proveedor = conexion.createStatement().executeQuery("SELECT Nombre from Proveedores WHERE ID_Proveedor = " + Integer.parseInt(id_proveedor_field.getText()));
            String aux = "";
            //Apuntando al primer elemento
            while (checar_proveedor.next()) {
                aux = checar_proveedor.getString(1);
            }

            //Verificando si el resultado que trae en null o si el campo esta vacio
            if ("".equals(aux)) {
                throw new Exception("Proveedor no encontrado, si este es nuevo asegúrese de agregarlo en la pestaña de Proveedores y Clientes");
            } else {
                //Habilitamos todos los campos una vez se verifique que el proveedor sea existente
                agregar_producto_pedido_button.setEnabled(true);
                precio_mayoreo_field.setEditable(true);
                mas_cantidad_field.setEditable(true);
                id_producto_field.setEditable(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_buscar_proveedor_pedido_bottonActionPerformed

    private void agregar_producto_pedido_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_producto_pedido_buttonActionPerformed
        try {
            Object[] producto_pedido = new Object[4];//Creando el arreglo que guarda info importante (ver más arriba)
            if ("".equals(id_producto_field.getText()) || "".equals(mas_cantidad_field.getText()) || "".equals(precio_mayoreo_field.getText())) { //Tiramos error si alguno está vacio
                throw new Exception("Asegurese de llenar bien los campos");
            } else {
                //Ahora checando que el ID_Producto exista en la tabla productos, funciona igual que en la funcion de buscar_idprov_button
                Integer id_producto_pedido = Integer.parseInt(id_producto_field.getText());
                ResultSet check_producto = conexion.createStatement().executeQuery("SELECT Nombre from Productos_Header WHERE ID_Producto = " + id_producto_pedido);
                //Si no hay más elementos en el set de resultados check_producto tiramos excepción, guardamos en el arreglo si no.
                if (check_producto.next() != false) {
                    //Guardamos el nombre del producto en la variable nombre_producto
                    String nombre_producto = check_producto.getString(1);
                    if (nombres_pedidos.contains(nombre_producto)) { //Si ya está en el string gigante de arriba que almacena todos los strings en el pedido, entonces error, si no, guardamos
                        throw new Exception("No puede ingresar el mismo producto dos veces");
                    } else {
                        //Aca ahora si ya inicia lo importante
                        Integer cantidad_agregar = Integer.parseInt(mas_cantidad_field.getText());
                        Float precio_mayoreo = Float.parseFloat(precio_mayoreo_field.getText());

                        //Guardando en el arreglo la info importante
                        producto_pedido[0] = id_producto_pedido;
                        producto_pedido[1] = cantidad_agregar;
                        producto_pedido[2] = precio_mayoreo;
                        producto_pedido[3] = nombre_producto;

                        //Añadiendola al "carrito" de pedidos
                        pedido.add(producto_pedido);
                        terminar_pedido_button.setEnabled(true);
                        id_producto_field.setText(null);
                        precio_mayoreo_field.setText("");
                        mas_cantidad_field.setText("");
                    }

                } else {
                    throw new Exception("No se encuentra el producto, asegúrese de que esté registrado.");

                }

            }

            mostrar_productos_pedido();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_agregar_producto_pedido_buttonActionPerformed

    private void cancelar_pedido_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_pedido_buttonActionPerformed
        id_proveedor_field.setText(null);
        id_producto_field.setText(null);
        mostrar_pedido.setText("");
        precio_mayoreo_field.setText("");
        mas_cantidad_field.setText("");

        agregar_producto_pedido_button.setEnabled(false);
        terminar_pedido_button.setEnabled(false);

        precio_mayoreo_field.setEditable(false);
        mas_cantidad_field.setEditable(false);
        id_producto_field.setEditable(false);

        pedido.clear();
        nombres_pedidos = "";

        mostrar_productos_pedido();
    }//GEN-LAST:event_cancelar_pedido_buttonActionPerformed

    private void mostrar_productos_pedido() {

        mostrar_pedido.setText("");
        nombres_pedidos = "";
        for (int i = 0; i < pedido.size(); i++) {
            Object[] pedido_aux = new Object[3];

            pedido_aux = (Object[]) pedido.get(i);

            mostrar_pedido.append((Integer) pedido_aux[0] + "\t" + (Integer) pedido_aux[1] + "\t" + (Float) pedido_aux[2] + "\n");
            nombres_pedidos += (String) pedido_aux[3];
        }

    }

    private void buscar_idpedido_reciente() {
        try {//NOTA: id_pedidos es el result set (lo que regresa el executeQuery) e id_pedido es el string que guarda el id_pedido más alto de la DB
            ResultSet id_pedidos = conexion.createStatement().executeQuery("SELECT MAX(ID_Pedido) from Pedidos_Header");

            while (id_pedidos.next()) {
                id_pedido = Integer.parseInt(id_pedidos.getString(1));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }


    private void id_producto_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_producto_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_producto_fieldActionPerformed

    private void mas_cantidad_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mas_cantidad_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mas_cantidad_fieldActionPerformed

    private void precio_mayoreo_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio_mayoreo_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precio_mayoreo_fieldActionPerformed

    private void terminar_pedido_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminar_pedido_buttonActionPerformed
        try {
            id_pedido++;
            conexion.createStatement().executeUpdate("EXEC nuevo_pedido_header " + id_pedido + "," + id_proveedor_field.getText() + "," + id_empleado);
            ListIterator i = pedido.listIterator();
            while (i.hasNext()) {
                Object[] aux = (Object[]) i.next();
                conexion.createStatement().executeUpdate("EXEC nuevo_pedido_detalle " + id_pedido + "," + (Integer) aux[0] + "," + (Integer) aux[1] + "," + (Float) aux[2]);
            }

            cancelar_pedido_buttonActionPerformed(null);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_terminar_pedido_buttonActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nuevo_pedido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nuevo_pedido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nuevo_pedido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nuevo_pedido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_producto_pedido_button;
    private javax.swing.JButton buscar_proveedor_pedido_botton;
    private javax.swing.JButton cancelar_pedido_button;
    private javax.swing.JTextField id_producto_field;
    private javax.swing.JTextField id_proveedor_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mas_cantidad_field;
    private javax.swing.JTextArea mostrar_pedido;
    private javax.swing.JTextField precio_mayoreo_field;
    private javax.swing.JButton terminar_pedido_button;
    // End of variables declaration//GEN-END:variables
}
