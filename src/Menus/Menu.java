package Menus;

import Usuarios.Administrar_Usuarios;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Menu extends javax.swing.JFrame {

    
    
    
    
    //TO-DO LIST
    //TESTEAR EL PROGRAMA
    //HACERLO BONITO
    //VER SI PUEDEN ACOMODAR MEJOR LOS BOTONES (QUE TODO QUEDE EMPAREJADO Y ASÍ)

    /*
    Notas importantes:
    SI ESTÁN AQUI Y NO SABEN CONECTAR LA DB EN PRIMER LUGAR, VAYAN A LA CLASE Usuarios.Login
    
        -INTENTEN LEER EL CODIGO POR SI LA PROFE LES PREGUNTA ALGO.
        -EN EL .SQL SE CREAN 2 USUARIOS, EL 1 (EMPLEADO) Y EL 5 (GERENTE), INICIEN SESION CON CADA UNO DE ELLOS PARA VER LAS DIFERENCIAS DEL MENU.
        -ETA = Estimated Time of Arrival, solo es una palabra rara que aparece en Pedidos a Proveedores que significa fecha esperada de arrivo.
        -Intenté hacer el programa lo más consistente en cuanto al funcionamiento, la mayoria de las pestañas te permiten cambiar cosas de la DB y ver y así en las mismas casillas...
            ...para agregar un nuevo producto procuren dejar en blanco el id***_field (en teoría no deberia pasar nadsa si lo hacen, el programa deberia ignorar lo que pongas).
            
        
        Algunos quirks y limitaciones raras:
            -No puedes agregar 2 productos iguales al carrito de compra (es para evitar problemas con la DB debido a problemas de constraints)
            -Algo que me gustaría hacer (y si ustedes pueden hacerlo) sería agregar mensajes de error más personalizados pq todo aparece en ingles
            -Si se puede hacer que la pestaña de estadisticas se actualize automáticamente pero el programa ya es lo suficientemente lento para agregar mas funciones al constructor xd
            -El programa, por simplicidad, no permite modificar la tabla de permisos presente en la DB.
            
     */
    //Variables importantes
    Connection conexion; //Objeto de la clase Connection del driver SQL
    Integer usuario_activo; //ID del usuario con sesión iniciada
    //Guarda el producto en el carrito de compra, la lista carrito está compuesta de varios arreglos, cada uno guardando: [0] es el nombre ,[1] es la cantidad, [2] es el precio actual del producto a comprar
    public LinkedList carrito = new LinkedList(); //Guarda todos los productos a comprar
    Float total = 0f; //Variable que contiene el total de venta
    int id_venta = 1000; //Variable que genera un id venta
    static String[] caracteres_prohibidos = {";", "*", ",", "+", "(", ")", "=", "\\", "\"", "/", "{", "}"}; //ARREGLO DE STRINGS DE CARACTERES PROHIBIDOS

    public Menu(Connection conexion, Integer usuario) throws ClassNotFoundException, SQLException { //Constructor por defecto que inicializa el programa y carga lo necesario
        this.usuario_activo = usuario; //Trae el usuario activo del inicio de sesion
        this.conexion = conexion; //Trae el objeto conexion a la base de datos sql
        this.id_venta = get_idventa();  //Trae el id_venta más alto de la db para siempre generar un id_venta unico.
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        ocultar_pestañas(conexion); //Funcion que oculta las pestañas en función del rol
        mostrar_pedidos(); //Funcion que imprime los pedidos en la tabla esa gigante de la pestaña Pedidos
        mostrar_usuarios(); //Funcion que muestra los empleados registrados de la pestaña de usuarios y empleados
        mostrar_clientes(); //Funcion que muestra los clientes registrados en la pestaña clientes y proveedores
        mostrar_productos(); //Muestra los productos en la pestaña productos
        mostrar_ventas(); //Muestra las ventas en la pestaña ventas
        calcular_total_dia(); //Calcula el total diario
        set_productos_campos(); //Hace que jalen los ComboBox en la pestaña productos
        
        
        
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

        jLabel17 = new javax.swing.JLabel();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        JPane = new javax.swing.JTabbedPane();
        VenderPane = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        ticket_servicios = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        total_servicios = new javax.swing.JTextField();
        cancelar_servicios = new javax.swing.JButton();
        checkout_button = new javax.swing.JButton();
        agrega_servicio = new javax.swing.JButton();
        seleccion_servicio = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        med_quan_field_chko = new javax.swing.JTextField();
        disponibilidadfield = new javax.swing.JLabel();
        disponibilidad_field_chko = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        preciounidad_med_chko = new javax.swing.JTextField();
        add_sell = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        nombre_med_chko1 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        PedidosPane = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buscar_order_button = new javax.swing.JButton();
        agregar_new_pedido_button = new javax.swing.JButton();
        limpiar_pedido_button = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        productos_ordenes_field = new javax.swing.JTextArea();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        order_id_field = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        pedido_entregado_button = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        ordenes_datos_field = new javax.swing.JTextArea();
        refresh_pedidos_button1 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        nombre_pedidos_field = new javax.swing.JTextField();
        marca_pedidos_field = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        empleado_pedido_field = new javax.swing.JTextField();
        fecha_pedidos_field = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        telefono_pedidos_field = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        ProductosPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        idprod_prod_field = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        disponibilidad_prod_field = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        precio_prod_field = new javax.swing.JTextField();
        buscarprod_prod_button = new javax.swing.JButton();
        guardarprod_prod_button = new javax.swing.JButton();
        cancelar_prod_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mostrarproductos_prod_field = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        nombre_prod_field = new javax.swing.JTextField();
        eliminarprod_prod_button = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        marca_prod_field = new javax.swing.JComboBox<>();
        caducidad_prod_field = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        categoria_prod_field = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        prov_prod_field = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        presentacion_prod_field = new javax.swing.JComboBox<>();
        pesoxu_prod_field = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        quanxu_prod_field = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        ingredientes_prod_field = new javax.swing.JTextField();
        administrarmarca_button = new javax.swing.JButton();
        administrarcat_button = new javax.swing.JButton();
        administrarpres_button = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        EmpleadosPane = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ver_todas_ventas_field = new javax.swing.JTextArea();
        clean_verventas_button = new javax.swing.JButton();
        buscarventa_verventa_button = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        idventa_verventa_field = new javax.swing.JTextField();
        fecha_venta_verventa_field = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        totalventa_verventa_field = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        Cantidad1 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cliente_verventa_field = new javax.swing.JTextField();
        empleado_verventa_field = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        telefonocliente_verventa_field = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        telefonoempleado_verventa_field = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        ver_ventas_field1 = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        refresh_pedidos_button2 = new javax.swing.JButton();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        UsuariosPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nombre_empleado_field = new javax.swing.JTextField();
        posicion_empleado_field = new javax.swing.JTextField();
        clean_botton = new javax.swing.JButton();
        save_botton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrar_empleados = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        buscar_empleado_field = new javax.swing.JTextField();
        buscar_cedula_botton = new javax.swing.JButton();
        administrar_usuarios_button = new javax.swing.JButton();
        telefono_empleado_field = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        delete_empleado_button = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        ClientesPane = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        id_cliente_clientes_field = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        nombre_cliente_field = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        telefono_cliente_field = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        mostrar_clientes_field = new javax.swing.JTextArea();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        search_idclient_button = new javax.swing.JButton();
        guardar_cliente_button = new javax.swing.JButton();
        eliminar_cliente_button = new javax.swing.JButton();
        proveedores_button = new javax.swing.JButton();
        cancel_clientes_button = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        EstadisticasPane = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        diatotal_statistics_field = new javax.swing.JTextField();
        corte_caja = new javax.swing.JButton();
        refresh_empleadoventas_button1 = new javax.swing.JButton();
        reporte_diario_button = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        periodotiempo_empleado_statistics_field = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        refresh_empleadoventas_button = new javax.swing.JButton();
        empleadomasventastotal_statistics_field = new javax.swing.JTextField();
        empleadomasventas_statistics_field1 = new javax.swing.JTextField();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        clientemascompras_statistics_field = new javax.swing.JTextField();
        periodotiempo_clientes_statistics_field = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        refresh_clientescompras_button = new javax.swing.JButton();
        clientemascomprastotal_statistics_field = new javax.swing.JTextField();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        productomasvendido_statistics_field = new javax.swing.JTextField();
        periodotiempo_prod_statistics_field = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        refresh_prodvendido_button = new javax.swing.JButton();
        productoprovl_statistics_field = new javax.swing.JTextField();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        bajadis_refresh_botton = new javax.swing.JButton();
        bajadis_statistics_field = new javax.swing.JTextField();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        expiracy_refresh_botton = new javax.swing.JButton();
        expiracy_refresh_field = new javax.swing.JTextField();
        jInternalFrame9 = new javax.swing.JInternalFrame();
        pedidosnodados_statistics_field2 = new javax.swing.JTextField();
        pedidosnodados_statistics_button = new javax.swing.JButton();
        pedidosnodados_statistics_field1 = new javax.swing.JTextField();
        jInternalFrame10 = new javax.swing.JInternalFrame();
        Ventas_x_Cliente_stats = new javax.swing.JButton();
        Ventas_x_Empleado_stats = new javax.swing.JButton();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();

        jLabel17.setText("jLabel17");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPane.setName("Medicity"); // NOI18N
        JPane.setPreferredSize(new java.awt.Dimension(1349, 700));

        VenderPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(137, 166, 246));
        jLabel5.setText("Vender");
        VenderPane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 54, -1, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(137, 166, 246));
        jLabel44.setText("Ticket de venta");
        VenderPane.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 116, -1, -1));

        ticket_servicios.setEditable(false);
        ticket_servicios.setBackground(new java.awt.Color(255, 255, 255));
        ticket_servicios.setColumns(20);
        ticket_servicios.setRows(5);
        jScrollPane9.setViewportView(ticket_servicios);

        VenderPane.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 182, 553, 391));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(137, 166, 246));
        jLabel45.setText("Producto");
        VenderPane.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 148, -1, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(137, 166, 246));
        jLabel46.setText("Cantidad");
        VenderPane.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 148, -1, -1));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(137, 166, 246));
        jLabel48.setText("Subtotal");
        VenderPane.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(846, 148, -1, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(137, 166, 246));
        jLabel50.setText("Total");
        VenderPane.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1091, 148, -1, -1));

        total_servicios.setEditable(false);
        total_servicios.setBackground(new java.awt.Color(255, 255, 255));
        total_servicios.setForeground(new java.awt.Color(0, 0, 0));
        total_servicios.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        total_servicios.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        total_servicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_serviciosActionPerformed(evt);
            }
        });
        VenderPane.add(total_servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1091, 182, 113, 30));

        cancelar_servicios.setBackground(new java.awt.Color(255, 170, 151));
        cancelar_servicios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar_servicios.setForeground(new java.awt.Color(87, 116, 196));
        cancelar_servicios.setText("Limpiar");
        cancelar_servicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_serviciosActionPerformed(evt);
            }
        });
        VenderPane.add(cancelar_servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 365, 110, 30));

        checkout_button.setBackground(new java.awt.Color(255, 170, 151));
        checkout_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        checkout_button.setForeground(new java.awt.Color(87, 116, 196));
        checkout_button.setText("Terminar");
        checkout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkout_buttonActionPerformed(evt);
            }
        });
        VenderPane.add(checkout_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 410, 110, 30));

        agrega_servicio.setBackground(new java.awt.Color(255, 170, 151));
        agrega_servicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        agrega_servicio.setForeground(new java.awt.Color(87, 116, 196));
        agrega_servicio.setText("Buscar");
        agrega_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agrega_servicioActionPerformed(evt);
            }
        });
        VenderPane.add(agrega_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, 30));

        seleccion_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccion_servicioActionPerformed(evt);
            }
        });
        VenderPane.add(seleccion_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 187, 246, 35));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(137, 166, 246));
        jLabel33.setText("Ingrese un ID del producto a vender:");
        VenderPane.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 144, 324, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(137, 166, 246));
        jLabel35.setText("Cantidad a vender");
        VenderPane.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 407, -1, -1));

        med_quan_field_chko.setEditable(false);
        med_quan_field_chko.setBackground(new java.awt.Color(255, 255, 255));
        med_quan_field_chko.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        med_quan_field_chko.setSelectionColor(new java.awt.Color(0, 0, 0));
        med_quan_field_chko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                med_quan_field_chkoActionPerformed(evt);
            }
        });
        VenderPane.add(med_quan_field_chko, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 444, 176, 35));

        disponibilidadfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        disponibilidadfield.setForeground(new java.awt.Color(137, 166, 246));
        disponibilidadfield.setText("Cantidad Disponible");
        VenderPane.add(disponibilidadfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 407, 176, -1));

        disponibilidad_field_chko.setEditable(false);
        disponibilidad_field_chko.setBackground(new java.awt.Color(255, 255, 255));
        disponibilidad_field_chko.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        disponibilidad_field_chko.setEnabled(false);
        VenderPane.add(disponibilidad_field_chko, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 444, 176, 35));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(137, 166, 246));
        jLabel40.setText("$ c/u");
        VenderPane.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 260, -1, -1));

        preciounidad_med_chko.setEditable(false);
        preciounidad_med_chko.setBackground(new java.awt.Color(255, 255, 255));
        preciounidad_med_chko.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        preciounidad_med_chko.setEnabled(false);
        preciounidad_med_chko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preciounidad_med_chkoActionPerformed(evt);
            }
        });
        VenderPane.add(preciounidad_med_chko, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 303, 109, 35));

        add_sell.setBackground(new java.awt.Color(255, 170, 151));
        add_sell.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add_sell.setForeground(new java.awt.Color(87, 116, 196));
        add_sell.setText("Agregar al Carrito");
        add_sell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_sellActionPerformed(evt);
            }
        });
        VenderPane.add(add_sell, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 537, 180, 40));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(137, 166, 246));
        jLabel43.setText("Nombre del producto");
        VenderPane.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 260, -1, -1));

        nombre_med_chko1.setEditable(false);
        nombre_med_chko1.setBackground(new java.awt.Color(255, 255, 255));
        nombre_med_chko1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nombre_med_chko1.setEnabled(false);
        nombre_med_chko1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_med_chko1ActionPerformed(evt);
            }
        });
        VenderPane.add(nombre_med_chko1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 303, 180, 35));

        jLabel112.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(137, 166, 246));
        jLabel112.setText("Dónde la ciudad encuentra el bienestar ");
        VenderPane.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        VenderPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 440));

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        VenderPane.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 830, 390));

        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoMedyCity.png"))); // NOI18N
        VenderPane.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 20, -1, -1));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        VenderPane.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 640, -1));

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        VenderPane.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 460, 650, 370));

        JPane.addTab("Vender", VenderPane);

        PedidosPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(137, 166, 246));
        jLabel8.setText("Pedidos a proveedores");
        PedidosPane.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 63, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(137, 166, 246));
        jLabel3.setText("Productos en el pedido");
        PedidosPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 263, -1, -1));

        buscar_order_button.setBackground(new java.awt.Color(255, 170, 151));
        buscar_order_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar_order_button.setForeground(new java.awt.Color(87, 116, 196));
        buscar_order_button.setText("Buscar");
        buscar_order_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_order_buttonActionPerformed(evt);
            }
        });
        PedidosPane.add(buscar_order_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 213, 82, -1));

        agregar_new_pedido_button.setBackground(new java.awt.Color(255, 170, 151));
        agregar_new_pedido_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregar_new_pedido_button.setForeground(new java.awt.Color(87, 116, 196));
        agregar_new_pedido_button.setText("Nuevo pedido");
        agregar_new_pedido_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_new_pedido_buttonActionPerformed(evt);
            }
        });
        PedidosPane.add(agregar_new_pedido_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 213, 150, -1));

        limpiar_pedido_button.setBackground(new java.awt.Color(255, 170, 151));
        limpiar_pedido_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiar_pedido_button.setForeground(new java.awt.Color(137, 166, 246));
        limpiar_pedido_button.setText("Limpiar");
        limpiar_pedido_button.setEnabled(false);
        limpiar_pedido_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_pedido_buttonActionPerformed(evt);
            }
        });
        PedidosPane.add(limpiar_pedido_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 472, 120, -1));

        productos_ordenes_field.setEditable(false);
        productos_ordenes_field.setColumns(20);
        productos_ordenes_field.setRows(5);
        productos_ordenes_field.setAutoscrolls(false);
        productos_ordenes_field.setFocusable(false);
        jScrollPane3.setViewportView(productos_ordenes_field);

        PedidosPane.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 317, -1, 181));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(137, 166, 246));
        jLabel57.setText("Total Orden");
        PedidosPane.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(915, 145, -1, -1));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(137, 166, 246));
        jLabel58.setText("Fecha ETA");
        PedidosPane.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(1008, 145, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(137, 166, 246));
        jLabel34.setText("ID de Orden");
        PedidosPane.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 179, -1, -1));
        PedidosPane.add(order_id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 98, 35));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(137, 166, 246));
        jLabel68.setText("ID");
        PedidosPane.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 145, -1, -1));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(137, 166, 246));
        jLabel80.setText("ID");
        PedidosPane.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 295, 47, -1));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(137, 166, 246));
        jLabel81.setText("Cantidad");
        PedidosPane.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 295, -1, -1));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(137, 166, 246));
        jLabel82.setText("Costo Mayoreo");
        PedidosPane.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 295, -1, -1));

        pedido_entregado_button.setBackground(new java.awt.Color(255, 170, 151));
        pedido_entregado_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pedido_entregado_button.setForeground(new java.awt.Color(137, 166, 246));
        pedido_entregado_button.setText("Entregado");
        pedido_entregado_button.setEnabled(false);
        pedido_entregado_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido_entregado_buttonActionPerformed(evt);
            }
        });
        PedidosPane.add(pedido_entregado_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 425, 120, -1));

        ordenes_datos_field.setEditable(false);
        ordenes_datos_field.setColumns(20);
        ordenes_datos_field.setRows(5);
        jScrollPane7.setViewportView(ordenes_datos_field);

        PedidosPane.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 179, 320, 336));

        refresh_pedidos_button1.setBackground(new java.awt.Color(255, 170, 151));
        refresh_pedidos_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        refresh_pedidos_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_pedidos_button1ActionPerformed(evt);
            }
        });
        PedidosPane.add(refresh_pedidos_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 485, 40, 30));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(137, 166, 246));
        jLabel75.setText("Nombre Proveedor");
        PedidosPane.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 210, -1, -1));

        nombre_pedidos_field.setEditable(false);
        PedidosPane.add(nombre_pedidos_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 241, 159, 35));

        marca_pedidos_field.setEditable(false);
        PedidosPane.add(marca_pedidos_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 241, 136, 35));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(137, 166, 246));
        jLabel79.setText("Marca Proveedor");
        PedidosPane.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 210, -1, -1));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(137, 166, 246));
        jLabel85.setText("Empleado pedido");
        PedidosPane.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 294, -1, -1));

        empleado_pedido_field.setEditable(false);
        PedidosPane.add(empleado_pedido_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 331, 142, 35));

        fecha_pedidos_field.setEditable(false);
        PedidosPane.add(fecha_pedidos_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 435, 156, 35));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(137, 166, 246));
        jLabel86.setText("Fecha de Orden");
        PedidosPane.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 398, -1, -1));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(137, 166, 246));
        jLabel87.setText("Telefono Proveedor");
        PedidosPane.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 294, -1, -1));

        telefono_pedidos_field.setEditable(false);
        PedidosPane.add(telefono_pedidos_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 331, 156, 35));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(137, 166, 246));
        jLabel69.setText("Todos los pedidos");
        PedidosPane.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 119, -1, -1));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        PedidosPane.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, -1));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        PedidosPane.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 830, 370));

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        PedidosPane.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 650, 460));

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        PedidosPane.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 650, 370));

        JPane.addTab("Pedidos", PedidosPane);

        ProductosPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(137, 166, 246));
        jLabel4.setText("Atributos de medicinas");
        ProductosPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(137, 166, 246));
        jLabel18.setText("ID Producto");
        ProductosPane.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, 19));

        idprod_prod_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idprod_prod_fieldActionPerformed(evt);
            }
        });
        ProductosPane.add(idprod_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 155, 35));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(137, 166, 246));
        jLabel19.setText("Disponibilidad");
        ProductosPane.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));
        ProductosPane.add(disponibilidad_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 155, 35));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(137, 166, 246));
        jLabel20.setText("Categoria");
        ProductosPane.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 85, 24));
        ProductosPane.add(precio_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 143, 35));

        buscarprod_prod_button.setBackground(new java.awt.Color(255, 170, 151));
        buscarprod_prod_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscarprod_prod_button.setForeground(new java.awt.Color(87, 116, 196));
        buscarprod_prod_button.setText("Buscar");
        buscarprod_prod_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarprod_prod_buttonActionPerformed(evt);
            }
        });
        ProductosPane.add(buscarprod_prod_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 110, 35));

        guardarprod_prod_button.setBackground(new java.awt.Color(255, 170, 151));
        guardarprod_prod_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        guardarprod_prod_button.setForeground(new java.awt.Color(87, 116, 196));
        guardarprod_prod_button.setText("Guardar Producto");
        guardarprod_prod_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarprod_prod_buttonActionPerformed(evt);
            }
        });
        ProductosPane.add(guardarprod_prod_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 180, 35));

        cancelar_prod_button.setBackground(new java.awt.Color(255, 170, 151));
        cancelar_prod_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar_prod_button.setForeground(new java.awt.Color(87, 116, 196));
        cancelar_prod_button.setText("Limpiar");
        cancelar_prod_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_prod_buttonActionPerformed(evt);
            }
        });
        ProductosPane.add(cancelar_prod_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 180, 35));

        mostrarproductos_prod_field.setEditable(false);
        mostrarproductos_prod_field.setColumns(20);
        mostrarproductos_prod_field.setRows(5);
        jScrollPane2.setViewportView(mostrarproductos_prod_field);

        ProductosPane.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(951, 164, 456, 409));
        ProductosPane.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 335, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(137, 166, 246));
        jLabel31.setText("Nombre");
        ProductosPane.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        nombre_prod_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_prod_fieldActionPerformed(evt);
            }
        });
        ProductosPane.add(nombre_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 155, 35));

        eliminarprod_prod_button.setBackground(new java.awt.Color(255, 170, 151));
        eliminarprod_prod_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        eliminarprod_prod_button.setForeground(new java.awt.Color(87, 116, 196));
        eliminarprod_prod_button.setText("Eliminar Producto");
        eliminarprod_prod_button.setEnabled(false);
        eliminarprod_prod_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarprod_prod_buttonActionPerformed(evt);
            }
        });
        ProductosPane.add(eliminarprod_prod_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 180, 35));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(137, 166, 246));
        jLabel24.setText("ID");
        ProductosPane.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(951, 142, 25, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(137, 166, 246));
        jLabel25.setText("Nombre");
        ProductosPane.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1221, 142, 47, -1));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(137, 166, 246));
        jLabel52.setText("Disponibilidad");
        ProductosPane.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(1006, 142, 86, -1));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(137, 166, 246));
        jLabel53.setText("Precio");
        ProductosPane.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(1126, 142, -1, -1));

        marca_prod_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProductosPane.add(marca_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 127, 35));
        ProductosPane.add(caducidad_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 127, 35));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(137, 166, 246));
        jLabel27.setText("Precio Unitario");
        ProductosPane.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 124, 24));

        categoria_prod_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProductosPane.add(categoria_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 127, 35));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(137, 166, 246));
        jLabel28.setText("Proveedor");
        ProductosPane.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 124, 24));

        prov_prod_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProductosPane.add(prov_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 127, 35));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(137, 166, 246));
        jLabel29.setText("Marca");
        ProductosPane.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 57, 24));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(137, 166, 246));
        jLabel10.setText("Productos");
        ProductosPane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(137, 166, 246));
        jLabel32.setText("Caducidad");
        ProductosPane.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, -1, 24));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(137, 166, 246));
        jLabel64.setText("Presentación");
        ProductosPane.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, -1, 24));

        presentacion_prod_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProductosPane.add(presentacion_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 127, 35));
        ProductosPane.add(pesoxu_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 155, 35));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(137, 166, 246));
        jLabel65.setText("Peso / Unidad");
        ProductosPane.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 610, -1, -1));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(137, 166, 246));
        jLabel66.setText("Cantidad / Unidad");
        ProductosPane.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, -1, -1));

        quanxu_prod_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanxu_prod_fieldActionPerformed(evt);
            }
        });
        ProductosPane.add(quanxu_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 155, 35));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(137, 166, 246));
        jLabel67.setText("Ingrediente(s)");
        ProductosPane.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, 19));

        ingredientes_prod_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientes_prod_fieldActionPerformed(evt);
            }
        });
        ProductosPane.add(ingredientes_prod_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 155, 35));

        administrarmarca_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/add-circle-outline.png"))); // NOI18N
        administrarmarca_button.setToolTipText("");
        administrarmarca_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarmarca_buttonActionPerformed(evt);
            }
        });
        ProductosPane.add(administrarmarca_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 25, 25));

        administrarcat_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/add-circle-outline.png"))); // NOI18N
        administrarcat_button.setToolTipText("");
        administrarcat_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarcat_buttonActionPerformed(evt);
            }
        });
        ProductosPane.add(administrarcat_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 25, 26));

        administrarpres_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/add-circle-outline.png"))); // NOI18N
        administrarpres_button.setToolTipText("");
        administrarpres_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarpres_buttonActionPerformed(evt);
            }
        });
        ProductosPane.add(administrarpres_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 490, -1, -1));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(137, 166, 246));
        jLabel70.setText("Todos los productos");
        ProductosPane.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(951, 122, -1, -1));

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        ProductosPane.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 450));

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        ProductosPane.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 650, 450));

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        ProductosPane.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 830, 380));

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        ProductosPane.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, 650, 380));

        JPane.addTab("Productos", ProductosPane);

        EmpleadosPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(137, 166, 246));
        jLabel59.setText("Ver Ventas");
        EmpleadosPane.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        Cantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Cantidad.setForeground(new java.awt.Color(137, 166, 246));
        Cantidad.setText("Cantidad");
        EmpleadosPane.add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(137, 166, 246));
        jLabel36.setText("Nombre");
        EmpleadosPane.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(137, 166, 246));
        jLabel37.setText("ID");
        EmpleadosPane.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, 20));

        ver_todas_ventas_field.setEditable(false);
        ver_todas_ventas_field.setColumns(20);
        ver_todas_ventas_field.setRows(5);
        jScrollPane8.setViewportView(ver_todas_ventas_field);

        EmpleadosPane.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 407, -1, 190));

        clean_verventas_button.setBackground(new java.awt.Color(255, 170, 151));
        clean_verventas_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clean_verventas_button.setForeground(new java.awt.Color(87, 116, 196));
        clean_verventas_button.setText("Limpiar");
        clean_verventas_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clean_verventas_buttonActionPerformed(evt);
            }
        });
        EmpleadosPane.add(clean_verventas_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 234, 100, 35));

        buscarventa_verventa_button.setBackground(new java.awt.Color(255, 170, 151));
        buscarventa_verventa_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscarventa_verventa_button.setForeground(new java.awt.Color(87, 116, 196));
        buscarventa_verventa_button.setText("Buscar");
        buscarventa_verventa_button.setToolTipText("");
        buscarventa_verventa_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarventa_verventa_buttonActionPerformed(evt);
            }
        });
        EmpleadosPane.add(buscarventa_verventa_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 181, 100, 35));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(137, 166, 246));
        jLabel38.setText("Ingrese el ID de Venta");
        EmpleadosPane.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 168, -1, -1));

        idventa_verventa_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idventa_verventa_fieldActionPerformed(evt);
            }
        });
        EmpleadosPane.add(idventa_verventa_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 205, 174, 35));

        fecha_venta_verventa_field.setEditable(false);
        EmpleadosPane.add(fecha_venta_verventa_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 289, 136, 35));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(137, 166, 246));
        jLabel49.setText("Fecha de la venta");
        EmpleadosPane.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 246, 181, -1));

        totalventa_verventa_field.setEditable(false);
        EmpleadosPane.add(totalventa_verventa_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 193, 134, 35));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(137, 166, 246));
        jLabel39.setText("Total de la venta");
        EmpleadosPane.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 150, -1, -1));

        Cantidad1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Cantidad1.setForeground(new java.awt.Color(137, 166, 246));
        Cantidad1.setText("Precio unitario");
        EmpleadosPane.add(Cantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, -1, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(137, 166, 246));
        jLabel51.setText("Nombre del cliente");
        EmpleadosPane.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 300, 181, -1));

        cliente_verventa_field.setEditable(false);
        EmpleadosPane.add(cliente_verventa_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 343, 181, 35));

        empleado_verventa_field.setEditable(false);
        EmpleadosPane.add(empleado_verventa_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 449, 181, 35));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(137, 166, 246));
        jLabel54.setText("Empleado responsable");
        EmpleadosPane.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 406, -1, -1));

        telefonocliente_verventa_field.setEditable(false);
        EmpleadosPane.add(telefonocliente_verventa_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 343, 160, 35));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(137, 166, 246));
        jLabel60.setText("Telefono cliente");
        EmpleadosPane.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 300, -1, -1));

        telefonoempleado_verventa_field.setEditable(false);
        EmpleadosPane.add(telefonoempleado_verventa_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 449, 160, 35));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(137, 166, 246));
        jLabel61.setText("Telefono empleado");
        EmpleadosPane.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 406, -1, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(137, 166, 246));
        jLabel47.setText("Todas las ventas");
        EmpleadosPane.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 359, -1, -1));

        ver_ventas_field1.setEditable(false);
        ver_ventas_field1.setColumns(20);
        ver_ventas_field1.setRows(5);
        jScrollPane10.setViewportView(ver_ventas_field1);

        EmpleadosPane.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 432, 447));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(137, 166, 246));
        jLabel41.setText("ID Venta");
        EmpleadosPane.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 385, -1, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(137, 166, 246));
        jLabel42.setText("Total Venta");
        EmpleadosPane.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1007, 385, -1, -1));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(137, 166, 246));
        jLabel62.setText("Ticket de venta");
        EmpleadosPane.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 102, -1, -1));

        refresh_pedidos_button2.setBackground(new java.awt.Color(255, 170, 151));
        refresh_pedidos_button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        refresh_pedidos_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_pedidos_button2ActionPerformed(evt);
            }
        });
        EmpleadosPane.add(refresh_pedidos_button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1171, 557, -1, 40));

        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        EmpleadosPane.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        EmpleadosPane.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 650, 460));

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        EmpleadosPane.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 830, 370));

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        EmpleadosPane.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 460, 660, 370));

        JPane.addTab("Ver ventas", EmpleadosPane);

        UsuariosPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Usuarios y Empleados");
        UsuariosPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(137, 166, 246));
        jLabel9.setText("Nombre del Empleado");
        UsuariosPane.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 166, 246));
        jLabel11.setText("Nombre");
        UsuariosPane.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(137, 166, 246));
        jLabel12.setText("Teléfono");
        UsuariosPane.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        nombre_empleado_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_empleado_fieldActionPerformed(evt);
            }
        });
        UsuariosPane.add(nombre_empleado_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 208, 35));
        UsuariosPane.add(posicion_empleado_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 122, 35));

        clean_botton.setBackground(new java.awt.Color(255, 170, 151));
        clean_botton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clean_botton.setForeground(new java.awt.Color(87, 116, 196));
        clean_botton.setText("Limpiar Casillas");
        clean_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clean_bottonActionPerformed(evt);
            }
        });
        UsuariosPane.add(clean_botton, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 398, 150, 35));

        save_botton1.setBackground(new java.awt.Color(255, 170, 151));
        save_botton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        save_botton1.setForeground(new java.awt.Color(87, 116, 196));
        save_botton1.setText("Guardar Cambios");
        save_botton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_botton1ActionPerformed(evt);
            }
        });
        UsuariosPane.add(save_botton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 170, 35));

        mostrar_empleados.setEditable(false);
        mostrar_empleados.setColumns(20);
        mostrar_empleados.setRows(5);
        jScrollPane1.setViewportView(mostrar_empleados);

        UsuariosPane.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 589, 264));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(137, 166, 246));
        jLabel13.setText("ID");
        UsuariosPane.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(137, 166, 246));
        jLabel14.setText("Posición");
        UsuariosPane.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(137, 166, 246));
        jLabel15.setText("Telefono");
        UsuariosPane.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 166, 246));
        jLabel7.setText("Todos los Empleados");
        UsuariosPane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 194, 28));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(137, 166, 246));
        jLabel16.setText("Buscar ID de Empleado");
        UsuariosPane.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 175, -1, -1));

        buscar_empleado_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_empleado_fieldActionPerformed(evt);
            }
        });
        UsuariosPane.add(buscar_empleado_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 173, 177, 35));

        buscar_cedula_botton.setBackground(new java.awt.Color(255, 170, 151));
        buscar_cedula_botton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar_cedula_botton.setForeground(new java.awt.Color(87, 116, 196));
        buscar_cedula_botton.setText("Buscar");
        buscar_cedula_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_cedula_bottonActionPerformed(evt);
            }
        });
        UsuariosPane.add(buscar_cedula_botton, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 172, 110, 35));

        administrar_usuarios_button.setBackground(new java.awt.Color(255, 170, 151));
        administrar_usuarios_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        administrar_usuarios_button.setForeground(new java.awt.Color(87, 116, 196));
        administrar_usuarios_button.setText("Manejar usuarios");
        administrar_usuarios_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrar_usuarios_buttonActionPerformed(evt);
            }
        });
        UsuariosPane.add(administrar_usuarios_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 170, 35));
        administrar_usuarios_button.getAccessibleContext().setAccessibleName("Administrar Usuarios");

        UsuariosPane.add(telefono_empleado_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 160, 35));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(137, 166, 246));
        jLabel21.setText("Posición");
        UsuariosPane.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, -1, -1));

        delete_empleado_button.setBackground(new java.awt.Color(255, 170, 151));
        delete_empleado_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete_empleado_button.setForeground(new java.awt.Color(87, 116, 196));
        delete_empleado_button.setText("Eliminar empleado");
        delete_empleado_button.setEnabled(false);
        delete_empleado_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_empleado_buttonActionPerformed(evt);
            }
        });
        UsuariosPane.add(delete_empleado_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 170, 35));

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        UsuariosPane.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        UsuariosPane.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 660, 460));

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        UsuariosPane.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 830, 370));

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        UsuariosPane.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, 810, 380));

        JPane.addTab("Usuarios y Empleados", null, UsuariosPane, "");

        ClientesPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(137, 166, 246));
        jLabel71.setText("Clientes y proveedores");
        ClientesPane.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 63, -1, -1));

        id_cliente_clientes_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_cliente_clientes_fieldActionPerformed(evt);
            }
        });
        ClientesPane.add(id_cliente_clientes_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 218, 168, 35));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(137, 166, 246));
        jLabel72.setText("ID del Cliente");
        ClientesPane.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 180, -1, -1));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(137, 166, 246));
        jLabel73.setText("Nombre del Cliente");
        ClientesPane.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 288, 270, -1));
        ClientesPane.add(nombre_cliente_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 317, 270, 35));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(137, 166, 246));
        jLabel74.setText("Telefono del Cliente");
        ClientesPane.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 394, 270, -1));

        telefono_cliente_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefono_cliente_fieldActionPerformed(evt);
            }
        });
        ClientesPane.add(telefono_cliente_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 425, 270, 35));

        mostrar_clientes_field.setEditable(false);
        mostrar_clientes_field.setColumns(20);
        mostrar_clientes_field.setRows(5);
        jScrollPane6.setViewportView(mostrar_clientes_field);

        ClientesPane.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 187, 537, 409));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(137, 166, 246));
        jLabel76.setText("ID");
        ClientesPane.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 165, 47, -1));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(137, 166, 246));
        jLabel77.setText("Nombre");
        ClientesPane.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 165, 47, -1));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(137, 166, 246));
        jLabel78.setText("Telefono");
        ClientesPane.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 165, -1, -1));

        search_idclient_button.setBackground(new java.awt.Color(255, 170, 151));
        search_idclient_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search_idclient_button.setForeground(new java.awt.Color(87, 116, 196));
        search_idclient_button.setText("Buscar");
        search_idclient_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_idclient_buttonActionPerformed(evt);
            }
        });
        ClientesPane.add(search_idclient_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 217, 84, 35));

        guardar_cliente_button.setBackground(new java.awt.Color(255, 170, 151));
        guardar_cliente_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        guardar_cliente_button.setForeground(new java.awt.Color(87, 116, 196));
        guardar_cliente_button.setText("Guardar");
        guardar_cliente_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_cliente_buttonActionPerformed(evt);
            }
        });
        ClientesPane.add(guardar_cliente_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 278, 93, 35));

        eliminar_cliente_button.setBackground(new java.awt.Color(255, 170, 151));
        eliminar_cliente_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        eliminar_cliente_button.setForeground(new java.awt.Color(87, 116, 196));
        eliminar_cliente_button.setText("Eliminar");
        eliminar_cliente_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_cliente_buttonActionPerformed(evt);
            }
        });
        ClientesPane.add(eliminar_cliente_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 331, 93, 35));

        proveedores_button.setBackground(new java.awt.Color(255, 170, 151));
        proveedores_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proveedores_button.setForeground(new java.awt.Color(87, 116, 196));
        proveedores_button.setText("Administrar proveedores");
        proveedores_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedores_buttonActionPerformed(evt);
            }
        });
        ClientesPane.add(proveedores_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 509, 240, 35));

        cancel_clientes_button.setBackground(new java.awt.Color(255, 170, 151));
        cancel_clientes_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancel_clientes_button.setForeground(new java.awt.Color(87, 116, 196));
        cancel_clientes_button.setText("Limpiar");
        cancel_clientes_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_clientes_buttonActionPerformed(evt);
            }
        });
        ClientesPane.add(cancel_clientes_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 384, 93, 35));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(137, 166, 246));
        jLabel63.setText("Todos los clientes");
        ClientesPane.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 139, -1, -1));

        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        ClientesPane.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        ClientesPane.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 660, 460));

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        ClientesPane.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 830, 370));

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        ClientesPane.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 660, 370));

        JPane.addTab("Clientes y proveedores", ClientesPane);

        EstadisticasPane.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(137, 166, 246));
        jLabel6.setText("Estadisticas");
        EstadisticasPane.add(jLabel6);
        jLabel6.setBounds(84, 65, 260, 64);

        jInternalFrame1.setBackground(new java.awt.Color(255, 170, 151));
        jInternalFrame1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jInternalFrame1.setForeground(new java.awt.Color(255, 170, 151));
        jInternalFrame1.setTitle("Total del día");
        jInternalFrame1.setToolTipText("Total del día");
        jInternalFrame1.setFocusable(false);
        jInternalFrame1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jInternalFrame1.setFrameIcon(null);
        jInternalFrame1.setRequestFocusEnabled(false);
        jInternalFrame1.setVisible(true);

        diatotal_statistics_field.setEditable(false);
        diatotal_statistics_field.setBackground(new java.awt.Color(255, 170, 151));
        diatotal_statistics_field.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        diatotal_statistics_field.setForeground(new java.awt.Color(72, 101, 181));
        diatotal_statistics_field.setBorder(null);
        diatotal_statistics_field.setFocusable(false);
        diatotal_statistics_field.setSelectedTextColor(new java.awt.Color(87, 116, 196));
        diatotal_statistics_field.setSelectionColor(new java.awt.Color(87, 116, 196));

        corte_caja.setBackground(new java.awt.Color(255, 220, 214));
        corte_caja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        corte_caja.setForeground(new java.awt.Color(87, 116, 196));
        corte_caja.setText("Corte de Caja");
        corte_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corte_cajaActionPerformed(evt);
            }
        });

        refresh_empleadoventas_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        refresh_empleadoventas_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_empleadoventas_button1ActionPerformed(evt);
            }
        });

        reporte_diario_button.setBackground(new java.awt.Color(255, 220, 214));
        reporte_diario_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reporte_diario_button.setForeground(new java.awt.Color(87, 116, 196));
        reporte_diario_button.setText("Reporte Diario");
        reporte_diario_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporte_diario_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reporte_diario_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(corte_caja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh_empleadoventas_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(diatotal_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(6, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refresh_empleadoventas_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(corte_caja, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(reporte_diario_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(diatotal_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        EstadisticasPane.add(jInternalFrame1);
        jInternalFrame1.setBounds(84, 147, 380, 185);

        jInternalFrame2.setBackground(new java.awt.Color(255, 170, 151));
        jInternalFrame2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jInternalFrame2.setTitle("Empleado con más ventas");
        jInternalFrame2.setToolTipText("Empleado con más ventas");
        jInternalFrame2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jInternalFrame2.setFrameIcon(null);
        jInternalFrame2.setRequestFocusEnabled(false);
        jInternalFrame2.setVisible(true);

        periodotiempo_empleado_statistics_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Día", "Mes", "Año" }));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(87, 116, 196));
        jLabel22.setText("En el último");

        refresh_empleadoventas_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        refresh_empleadoventas_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_empleadoventas_buttonActionPerformed(evt);
            }
        });

        empleadomasventastotal_statistics_field.setEditable(false);
        empleadomasventastotal_statistics_field.setBackground(new java.awt.Color(255, 170, 151));
        empleadomasventastotal_statistics_field.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        empleadomasventastotal_statistics_field.setForeground(new java.awt.Color(72, 101, 181));
        empleadomasventastotal_statistics_field.setBorder(null);
        empleadomasventastotal_statistics_field.setFocusable(false);

        empleadomasventas_statistics_field1.setEditable(false);
        empleadomasventas_statistics_field1.setBackground(new java.awt.Color(255, 170, 151));
        empleadomasventas_statistics_field1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        empleadomasventas_statistics_field1.setForeground(new java.awt.Color(72, 101, 181));
        empleadomasventas_statistics_field1.setBorder(null);
        empleadomasventas_statistics_field1.setFocusable(false);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(periodotiempo_empleado_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(empleadomasventas_statistics_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh_empleadoventas_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empleadomasventastotal_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(periodotiempo_empleado_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addComponent(refresh_empleadoventas_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empleadomasventastotal_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empleadomasventas_statistics_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        EstadisticasPane.add(jInternalFrame2);
        jInternalFrame2.setBounds(473, 147, 358, 185);

        jInternalFrame3.setBackground(new java.awt.Color(255, 170, 151));
        jInternalFrame3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jInternalFrame3.setTitle("Cliente que más ha comprado");
        jInternalFrame3.setToolTipText("Cliente que más ha comprado");
        jInternalFrame3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jInternalFrame3.setFrameIcon(null);
        jInternalFrame3.setRequestFocusEnabled(false);
        jInternalFrame3.setVisible(true);

        clientemascompras_statistics_field.setEditable(false);
        clientemascompras_statistics_field.setBackground(new java.awt.Color(255, 170, 151));
        clientemascompras_statistics_field.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clientemascompras_statistics_field.setForeground(new java.awt.Color(72, 101, 181));
        clientemascompras_statistics_field.setBorder(null);
        clientemascompras_statistics_field.setFocusable(false);

        periodotiempo_clientes_statistics_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Día", "Mes", "Año" }));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(87, 116, 196));
        jLabel23.setText("En el último");

        refresh_clientescompras_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        refresh_clientescompras_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_clientescompras_buttonActionPerformed(evt);
            }
        });

        clientemascomprastotal_statistics_field.setEditable(false);
        clientemascomprastotal_statistics_field.setBackground(new java.awt.Color(255, 170, 151));
        clientemascomprastotal_statistics_field.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        clientemascomprastotal_statistics_field.setForeground(new java.awt.Color(72, 101, 181));
        clientemascomprastotal_statistics_field.setBorder(null);
        clientemascomprastotal_statistics_field.setFocusable(false);

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(periodotiempo_clientes_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clientemascompras_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh_clientescompras_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientemascomprastotal_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(periodotiempo_clientes_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(refresh_clientescompras_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientemascomprastotal_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientemascompras_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        EstadisticasPane.add(jInternalFrame3);
        jInternalFrame3.setBounds(837, 147, 350, 185);

        jInternalFrame4.setBackground(new java.awt.Color(255, 170, 151));
        jInternalFrame4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jInternalFrame4.setTitle("Producto más vendido");
        jInternalFrame4.setToolTipText("Producto más vendido");
        jInternalFrame4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jInternalFrame4.setFrameIcon(null);
        jInternalFrame4.setRequestFocusEnabled(false);
        jInternalFrame4.setVisible(true);

        productomasvendido_statistics_field.setEditable(false);
        productomasvendido_statistics_field.setBackground(new java.awt.Color(255, 170, 151));
        productomasvendido_statistics_field.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        productomasvendido_statistics_field.setForeground(new java.awt.Color(72, 101, 181));
        productomasvendido_statistics_field.setBorder(null);
        productomasvendido_statistics_field.setFocusable(false);

        periodotiempo_prod_statistics_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Día", "Semana", "Todo" }));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(87, 116, 196));
        jLabel26.setText("En la última");

        refresh_prodvendido_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        refresh_prodvendido_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_prodvendido_buttonActionPerformed(evt);
            }
        });

        productoprovl_statistics_field.setEditable(false);
        productoprovl_statistics_field.setBackground(new java.awt.Color(255, 170, 151));
        productoprovl_statistics_field.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productoprovl_statistics_field.setForeground(new java.awt.Color(72, 101, 181));
        productoprovl_statistics_field.setBorder(null);
        productoprovl_statistics_field.setFocusable(false);
        productoprovl_statistics_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoprovl_statistics_fieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productoprovl_statistics_field)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(periodotiempo_prod_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refresh_prodvendido_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(productomasvendido_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(periodotiempo_prod_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refresh_prodvendido_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(productomasvendido_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productoprovl_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        EstadisticasPane.add(jInternalFrame4);
        jInternalFrame4.setBounds(84, 336, 383, 195);

        jInternalFrame5.setBackground(new java.awt.Color(255, 170, 151));
        jInternalFrame5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jInternalFrame5.setTitle("Productos con baja disponibilidad");
        jInternalFrame5.setToolTipText("Productos con baja disponibilidad");
        jInternalFrame5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jInternalFrame5.setFrameIcon(null);
        jInternalFrame5.setRequestFocusEnabled(false);
        jInternalFrame5.setVisible(true);

        bajadis_refresh_botton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        bajadis_refresh_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajadis_refresh_bottonActionPerformed(evt);
            }
        });

        bajadis_statistics_field.setEditable(false);
        bajadis_statistics_field.setBackground(new java.awt.Color(255, 170, 151));
        bajadis_statistics_field.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bajadis_statistics_field.setForeground(new java.awt.Color(72, 101, 181));
        bajadis_statistics_field.setBorder(null);
        bajadis_statistics_field.setFocusable(false);

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bajadis_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bajadis_refresh_botton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bajadis_refresh_botton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bajadis_statistics_field, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        EstadisticasPane.add(jInternalFrame5);
        jInternalFrame5.setBounds(473, 336, 288, 90);

        jInternalFrame6.setBackground(new java.awt.Color(255, 170, 151));
        jInternalFrame6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jInternalFrame6.setTitle("Medicamentos a caducarse");
        jInternalFrame6.setToolTipText("Medicamentos a caducarse");
        jInternalFrame6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jInternalFrame6.setFrameIcon(null);
        jInternalFrame6.setRequestFocusEnabled(false);
        jInternalFrame6.setVisible(true);

        expiracy_refresh_botton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        expiracy_refresh_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expiracy_refresh_bottonActionPerformed(evt);
            }
        });

        expiracy_refresh_field.setEditable(false);
        expiracy_refresh_field.setBackground(new java.awt.Color(255, 170, 151));
        expiracy_refresh_field.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        expiracy_refresh_field.setForeground(new java.awt.Color(72, 101, 181));
        expiracy_refresh_field.setBorder(null);
        expiracy_refresh_field.setFocusable(false);

        javax.swing.GroupLayout jInternalFrame6Layout = new javax.swing.GroupLayout(jInternalFrame6.getContentPane());
        jInternalFrame6.getContentPane().setLayout(jInternalFrame6Layout);
        jInternalFrame6Layout.setHorizontalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(expiracy_refresh_field, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expiracy_refresh_botton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jInternalFrame6Layout.setVerticalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(expiracy_refresh_botton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expiracy_refresh_field, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        EstadisticasPane.add(jInternalFrame6);
        jInternalFrame6.setBounds(473, 432, 288, 99);

        jInternalFrame9.setBackground(new java.awt.Color(255, 170, 151));
        jInternalFrame9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jInternalFrame9.setTitle("Pedidos sin entregar");
        jInternalFrame9.setToolTipText("Pedidos sin entregar");
        jInternalFrame9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jInternalFrame9.setFrameIcon(null);
        jInternalFrame9.setRequestFocusEnabled(false);
        jInternalFrame9.setVisible(true);

        pedidosnodados_statistics_field2.setEditable(false);
        pedidosnodados_statistics_field2.setBackground(new java.awt.Color(255, 170, 151));
        pedidosnodados_statistics_field2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidosnodados_statistics_field2.setForeground(new java.awt.Color(72, 101, 181));
        pedidosnodados_statistics_field2.setBorder(null);
        pedidosnodados_statistics_field2.setFocusable(false);

        pedidosnodados_statistics_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menus/refresh-icon (1).png"))); // NOI18N
        pedidosnodados_statistics_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosnodados_statistics_buttonActionPerformed(evt);
            }
        });

        pedidosnodados_statistics_field1.setEditable(false);
        pedidosnodados_statistics_field1.setBackground(new java.awt.Color(255, 170, 151));
        pedidosnodados_statistics_field1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidosnodados_statistics_field1.setForeground(new java.awt.Color(72, 101, 181));
        pedidosnodados_statistics_field1.setBorder(null);
        pedidosnodados_statistics_field1.setFocusable(false);

        javax.swing.GroupLayout jInternalFrame9Layout = new javax.swing.GroupLayout(jInternalFrame9.getContentPane());
        jInternalFrame9.getContentPane().setLayout(jInternalFrame9Layout);
        jInternalFrame9Layout.setHorizontalGroup(
            jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pedidosnodados_statistics_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jInternalFrame9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pedidosnodados_statistics_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pedidosnodados_statistics_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(64, Short.MAX_VALUE)))
        );
        jInternalFrame9Layout.setVerticalGroup(
            jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pedidosnodados_statistics_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(pedidosnodados_statistics_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame9Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(pedidosnodados_statistics_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(89, Short.MAX_VALUE)))
        );

        EstadisticasPane.add(jInternalFrame9);
        jInternalFrame9.setBounds(767, 336, 424, 195);

        jInternalFrame10.setBackground(new java.awt.Color(255, 170, 151));
        jInternalFrame10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jInternalFrame10.setTitle("Opciones Miscelaneas");
        jInternalFrame10.setToolTipText("Opciones Miscelaneas");
        jInternalFrame10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jInternalFrame10.setFrameIcon(null);
        jInternalFrame10.setRequestFocusEnabled(false);
        jInternalFrame10.setVisible(true);

        Ventas_x_Cliente_stats.setBackground(new java.awt.Color(255, 220, 214));
        Ventas_x_Cliente_stats.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Ventas_x_Cliente_stats.setForeground(new java.awt.Color(87, 116, 196));
        Ventas_x_Cliente_stats.setText("Ventas por cliente");
        Ventas_x_Cliente_stats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ventas_x_Cliente_statsActionPerformed(evt);
            }
        });

        Ventas_x_Empleado_stats.setBackground(new java.awt.Color(255, 220, 214));
        Ventas_x_Empleado_stats.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Ventas_x_Empleado_stats.setForeground(new java.awt.Color(87, 116, 196));
        Ventas_x_Empleado_stats.setText("Ventas por empleado");
        Ventas_x_Empleado_stats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ventas_x_Empleado_statsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame10Layout = new javax.swing.GroupLayout(jInternalFrame10.getContentPane());
        jInternalFrame10.getContentPane().setLayout(jInternalFrame10Layout);
        jInternalFrame10Layout.setHorizontalGroup(
            jInternalFrame10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ventas_x_Empleado_stats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ventas_x_Cliente_stats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jInternalFrame10Layout.setVerticalGroup(
            jInternalFrame10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame10Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(Ventas_x_Cliente_stats, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(Ventas_x_Empleado_stats, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        EstadisticasPane.add(jInternalFrame10);
        jInternalFrame10.setBounds(1197, 147, 200, 384);

        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        EstadisticasPane.add(jLabel107);
        jLabel107.setBounds(0, 0, 830, 465);

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        EstadisticasPane.add(jLabel108);
        jLabel108.setBounds(830, 0, 660, 450);

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        EstadisticasPane.add(jLabel109);
        jLabel109.setBounds(-1, 456, 830, 380);

        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        EstadisticasPane.add(jLabel110);
        jLabel110.setBounds(820, 450, 670, 380);

        JPane.addTab("Estadisticas", EstadisticasPane);

        getContentPane().add(JPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1473, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void nombre_prod_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_prod_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_prod_fieldActionPerformed

    private void cancelar_prod_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_prod_buttonActionPerformed

        try {
            if (!"GERENTE".equals(get_rol())) {
                mostrar_productos();
                precio_prod_field.setText("");
                disponibilidad_prod_field.setText("");
                nombre_prod_field.setText("");
                idprod_prod_field.setText("");
                ingredientes_prod_field.setText("");
                pesoxu_prod_field.setText("");
                quanxu_prod_field.setText("");
                caducidad_prod_field.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            } else {

                set_productos_campos();
                mostrar_productos();
                precio_prod_field.setText("");
                disponibilidad_prod_field.setText("");
                nombre_prod_field.setText("");
                idprod_prod_field.setText("");
                ingredientes_prod_field.setText("");
                pesoxu_prod_field.setText("");
                quanxu_prod_field.setText("");
                caducidad_prod_field.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
                eliminarprod_prod_button.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_cancelar_prod_buttonActionPerformed

    private void guardarprod_prod_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarprod_prod_buttonActionPerformed
        try {
            //Atributos generales de todo producto
            String id_producto = idprod_prod_field.getText();
            String nombre = nombre_prod_field.getText();
            String disponibilidad = disponibilidad_prod_field.getText();
            String precio_unitario = precio_prod_field.getText();
            String categoria = (String) categoria_prod_field.getSelectedItem();
            String marca = (String) marca_prod_field.getSelectedItem();
            String proveedor = (String) prov_prod_field.getSelectedItem();
            String ingredientes = "";
            String CantidadUnidad = "";
            String PrecioxUnidad = "";
            String pres = "";
            String caducidad = "";

            if ("Medicina".equals(categoria)) {
                ingredientes = ingredientes_prod_field.getText();
                CantidadUnidad = quanxu_prod_field.getText();
                PrecioxUnidad = pesoxu_prod_field.getText();
                pres = (String) presentacion_prod_field.getSelectedItem();
                caducidad = new SimpleDateFormat("YYYY-MM-dd").format(caducidad_prod_field.getDate());
            }

            if (check_string(id_producto)) {
                throw new Exception("Ha ingresado un id inválido");
            }

            if ("".equals(nombre) || "".equals(precio_unitario) || "".equals(disponibilidad)) {
                throw new Exception("Asegurese de llenar las casillas correctamente");
            }

            if ("Medicina".equals(categoria) && ("".equals(ingredientes) || "".equals(CantidadUnidad) || "".equals(PrecioxUnidad))) {
                throw new Exception("Asegurese de llenas las casillas correctamente");
            }

            String añadir_prod_query = "EXEC guardar_producto '" + id_producto + "',\n"
                    + "'" + nombre + "',\n"
                    + "'" + precio_unitario + "',\n"
                    + "'" + categoria + "', \n"
                    + "'" + marca + "',\n"
                    + "'" + proveedor + "',\n"
                    + "'" + disponibilidad + "',\n"
                    + "'" + ingredientes + "',\n"
                    + "'" + pres + "',\n"
                    + "'" + caducidad + "',\n"
                    + "'" + CantidadUnidad + "',\n"
                    + "'" + PrecioxUnidad + "'";

            conexion.createStatement().executeUpdate(añadir_prod_query);

            cancelar_prod_buttonActionPerformed(null);
            eliminarprod_prod_button.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_guardarprod_prod_buttonActionPerformed

    private void buscarprod_prod_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarprod_prod_buttonActionPerformed
        try {
            String id_producto = idprod_prod_field.getText();
            String query = "select ph.ID_Producto, ph.Nombre, ph.Disponibilidad, c.Descripcion, m.Descripcion, p.Nombre, ph.Precio_unitario from Productos_Header ph\n"
                    + "INNER JOIN Marcas m ON m.ID_Marca = ph.ID_Marca\n"
                    + "INNER JOIN Categorias_Prod c ON c.ID_Categoria = ph.ID_Categoria \n"
                    + "INNER JOIN Proveedores p ON p.ID_Proveedor = ph.ID_Proveedor \n"
                    + "where ID_Producto = ";

            if ("".equals(id_producto) || check_string(id_producto)) {
                throw new Exception("Ha ingresado un id inválido");
            }

            ResultSet producto = conexion.createStatement().executeQuery(query + id_producto);

            while (producto.next()) {
                precio_prod_field.setText(producto.getString(7));
                disponibilidad_prod_field.setText(producto.getString(3));
                nombre_prod_field.setText(producto.getString(2));
                categoria_prod_field.setSelectedItem(producto.getString(4));
                prov_prod_field.setSelectedItem(producto.getString(6));
                marca_prod_field.setSelectedItem(producto.getString(5));
            }

            if ("Medicina".equals(categoria_prod_field.getSelectedItem())) {

                String med_query = "select Ingrediente, p.Descripcion, Caducidad, CantidadxU, PesoxU from Productos_Med pm \n"
                        + "INNER JOIN Presentaciones p ON p.ID_Presentacion = pm.ID_Presentacion\n"
                        + "WHERE ID_Producto = ";

                ResultSet medicina = conexion.createStatement().executeQuery(med_query + id_producto);

                while (medicina.next()) {
                    pesoxu_prod_field.setText(medicina.getString(5));
                    ingredientes_prod_field.setText(medicina.getString(1));
                    quanxu_prod_field.setText(medicina.getString(4));
                    presentacion_prod_field.setSelectedItem(medicina.getString(2));
                    caducidad_prod_field.setDate(medicina.getDate(3));

                }
            }

            eliminarprod_prod_button.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());

        }


    }//GEN-LAST:event_buscarprod_prod_buttonActionPerformed

    private void idprod_prod_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idprod_prod_fieldActionPerformed

    }//GEN-LAST:event_idprod_prod_fieldActionPerformed

    private void buscar_cedula_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_cedula_bottonActionPerformed
        try {

            if (check_string(buscar_empleado_field.getText()) || "".equals(buscar_empleado_field.getText())) {
                throw new Exception("Rellene bien los campos ni ingrese caracteres prohibidos");
            }

            ResultSet empleado = conexion.createStatement().executeQuery("select e.Nombre, e.Posicion, e.Telefono from Empleados e where ID_Empleado = " + Integer.parseInt(buscar_empleado_field.getText()));

            while (empleado.next()) {
                nombre_empleado_field.setText(empleado.getString(1));
                posicion_empleado_field.setText(empleado.getString(2));
                telefono_empleado_field.setText(empleado.getString(3));
            }

            if ("".equals(nombre_empleado_field.getText())) {
                throw new Exception("El empleado no ha sido encontrado");
            }

            delete_empleado_button.setEnabled(true);
            buscar_empleado_field.setEditable(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_buscar_cedula_bottonActionPerformed

    private void buscar_empleado_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_empleado_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_empleado_fieldActionPerformed

    private void save_botton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_botton1ActionPerformed
        try {
            String id_empleado = buscar_empleado_field.getText();
            String nombre = nombre_empleado_field.getText();
            String posicion = posicion_empleado_field.getText();
            String telefono = telefono_empleado_field.getText();

            if (check_string(nombre) || check_string(posicion) || check_string(telefono) || "".equals(nombre) || "".equals(posicion) || "".equals(telefono)) {
                throw new Exception("No puede ingresar esos caracteres");
            }

            if ("".equals(buscar_empleado_field.getText())) {
                conexion.createStatement().executeUpdate("EXEC agregar_empleado null, '" + nombre + "','" + posicion + "','" + telefono + "'");
            } else {
                conexion.createStatement().executeUpdate("EXEC agregar_empleado " + id_empleado + ",'" + nombre + "','" + posicion + "','" + telefono + "'");
            }
            mostrar_usuarios();
            clean_bottonActionPerformed(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_save_botton1ActionPerformed

    private void clean_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clean_bottonActionPerformed
        nombre_empleado_field.setText(null);
        posicion_empleado_field.setText(null);
        buscar_empleado_field.setText(null);
        telefono_empleado_field.setText(null);
        delete_empleado_button.setEnabled(false);
        buscar_empleado_field.setEditable(true);

        mostrar_usuarios();
    }//GEN-LAST:event_clean_bottonActionPerformed

    private void eliminarprod_prod_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarprod_prod_buttonActionPerformed
        try {
            conexion.createStatement().executeUpdate("EXEC eliminar_producto " + idprod_prod_field.getText());
            cancelar_prod_buttonActionPerformed(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_eliminarprod_prod_buttonActionPerformed

    private void agregar_new_pedido_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_new_pedido_buttonActionPerformed
        Nuevo_pedido nv = new Nuevo_pedido(conexion, usuario_activo);
        nv.setVisible(true);
    }//GEN-LAST:event_agregar_new_pedido_buttonActionPerformed

    private void buscar_order_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_order_buttonActionPerformed
        try {
            if (check_string(order_id_field.getText()) || "".equals(order_id_field.getText())) {
                throw new Exception("Rellene bien los campos o no ingrese caracteres prohibidos");

            }

            Integer id_pedido = Integer.parseInt(order_id_field.getText());

            ResultSet productos_pedido = conexion.createStatement().executeQuery("SELECT ID_Producto, Cantidad, Costo_Mayoreo FROM Pedidos_Detalle WHERE ID_Pedido = " + id_pedido);
            ResultSet pedido_select = conexion.createStatement().executeQuery("select Nombre_Proveedor, Descripcion, Telefono, Nombre_Empleado, Fecha_Pedido from Pedidos_vista WHERE ID_Pedido = " + id_pedido);

            while (productos_pedido.next()) {
                productos_ordenes_field.append(productos_pedido.getString(1)
                        + "\t" + productos_pedido.getString(2)
                        + "\t" + productos_pedido.getString(3) + "\n");
            }

            while (pedido_select.next()) {
                fecha_pedidos_field.setText(pedido_select.getString(5));
                empleado_pedido_field.setText(pedido_select.getString(4));
                telefono_pedidos_field.setText(pedido_select.getString(3));
                marca_pedidos_field.setText(pedido_select.getString(2));
                nombre_pedidos_field.setText(pedido_select.getString(1));
            }

            if ("".equals(productos_ordenes_field.getText())) {
                throw new Exception("No se ha encontrado el pedido");
            }

            limpiar_pedido_button.setEnabled(true);
            pedido_entregado_button.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_buscar_order_buttonActionPerformed

    private void limpiar_pedido_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_pedido_buttonActionPerformed
        mostrar_pedidos();
        order_id_field.setText("");
        limpiar_pedido_button.setEnabled(false);
        pedido_entregado_button.setEnabled(false);
        productos_ordenes_field.setText("");
        fecha_pedidos_field.setText("");
        empleado_pedido_field.setText("");
        telefono_pedidos_field.setText("");
        marca_pedidos_field.setText("");
        nombre_pedidos_field.setText("");
    }//GEN-LAST:event_limpiar_pedido_buttonActionPerformed

    private void corte_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corte_cajaActionPerformed
        try {

            if ("".equals(diatotal_statistics_field.getText())) {
                throw new Exception("Primero haga una venta");
            }

            Formatter corte = new Formatter("corte de caja.txt");
            ResultSet ventas_dia = conexion.createStatement().executeQuery("select ID_Venta, dbo.calcular_venta(ID_Venta) from Ventas_Header WHERE Fecha = cast(getdate() as date)");
            String lista_ventas_corte = "";

            while (ventas_dia.next()) {
                lista_ventas_corte += ventas_dia.getString(1) + "\t" + ventas_dia.getString(2) + "\n";
            }

            corte.format("\tCORTE DE CAJA " + LocalDate.now() + "\n\nID\t\tVENTA\n%s\n\nTOTAL DE VENTAS: %s", lista_ventas_corte, diatotal_statistics_field.getText());
            corte.close();
            JOptionPane.showMessageDialog(null, "Se ha guardado el corte de caja en corte de caja.txt");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_corte_cajaActionPerformed

    private void telefono_cliente_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefono_cliente_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefono_cliente_fieldActionPerformed

    private void search_idclient_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_idclient_buttonActionPerformed
        try {
            if ("".equals(id_cliente_clientes_field.getText()) || check_string(id_cliente_clientes_field.getText())) {
                throw new Exception("Rellene bien los campos o ha ingresado caracteres prohibidos");
            } else {
                ResultSet cliente = conexion.createStatement().executeQuery("SELECT * FROM Clientes WHERE ID_Cliente = " + id_cliente_clientes_field.getText());

                while (cliente.next()) {
                    telefono_cliente_field.setText(cliente.getString(3));
                    nombre_cliente_field.setText(cliente.getString(2));
                }

                if ("".equals(nombre_cliente_field.getText())) {
                    throw new Exception("El cliente no existe");
                } else {
                    id_cliente_clientes_field.setEditable(false);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            cancel_clientes_buttonActionPerformed(null);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_search_idclient_buttonActionPerformed

    private void guardar_cliente_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_cliente_buttonActionPerformed
        try {
            if ("".equals(nombre_cliente_field.getText()) || "".equals(telefono_cliente_field.getText())) {
                throw new Exception("Rellene bien los campos");
            } else {
                if (check_string(nombre_cliente_field.getText()) || check_string(telefono_cliente_field.getText())) {
                    throw new Exception("Ha ingresado caracteres prohibidos");
                } else {
                    if("".equals(id_cliente_clientes_field.getText())){
                        conexion.createStatement().executeUpdate("EXEC guardar_clientes 0,'" + nombre_cliente_field.getText() + "','" + telefono_cliente_field.getText() + "'");
                    }else{
                        conexion.createStatement().executeUpdate("EXEC guardar_clientes " + id_cliente_clientes_field.getText() + ",'" + nombre_cliente_field.getText() + "','" + telefono_cliente_field.getText() + "'");
                        mostrar_clientes();
                    }
                }
            }

            cancel_clientes_buttonActionPerformed(null);

        } catch (Exception e) {
            e.printStackTrace();
            cancel_clientes_buttonActionPerformed(null);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_guardar_cliente_buttonActionPerformed

    private void eliminar_cliente_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_cliente_buttonActionPerformed
        try {
            if (id_cliente_clientes_field.getText() == "" || check_string(id_cliente_clientes_field.getText())) {
                throw new Exception("Rellene bien los campos o ha ingresado caracteres prohibidos");
            } else {
                conexion.createStatement().executeUpdate("DELETE FROM Clientes where ID_Cliente = " + id_cliente_clientes_field.getText());
                mostrar_clientes();
            }

            cancel_clientes_buttonActionPerformed(null);

        } catch (Exception e) {
            e.printStackTrace();
            cancel_clientes_buttonActionPerformed(null);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    }//GEN-LAST:event_eliminar_cliente_buttonActionPerformed

    private void proveedores_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedores_buttonActionPerformed
        Administrar_Proveedores ap = new Administrar_Proveedores(conexion);
        ap.setVisible(true);
    }//GEN-LAST:event_proveedores_buttonActionPerformed

    private void nombre_med_chko1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_med_chko1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_med_chko1ActionPerformed

    private void add_sellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_sellActionPerformed
        try {
            if ("".equals(nombre_med_chko1.getText())) {
                throw new Exception("Busque un producto");
            }
            
            if (Integer.parseInt(disponibilidad_field_chko.getText()) <= 0 || Integer.parseInt(disponibilidad_field_chko.getText()) - Integer.parseInt(med_quan_field_chko.getText()) < 0) {
                throw new Exception("Ya no queda más de este producto.");
            }
            
            Object[] a_comprar = new Object[3]; //NOTA: [0] es el nombre ,[1] es la cantidad, [2] es el precio actual
            a_comprar[0] = nombre_med_chko1.getText();
            a_comprar[1] = Integer.parseInt(med_quan_field_chko.getText());
            a_comprar[2] = Float.parseFloat(preciounidad_med_chko.getText());
            carrito.add(a_comprar);
            limpiar_casillas_chkout();
            ver_lista_ventas();   

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_add_sellActionPerformed

    private void preciounidad_med_chkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preciounidad_med_chkoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preciounidad_med_chkoActionPerformed

    private void seleccion_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccion_servicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccion_servicioActionPerformed

    private void agrega_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agrega_servicioActionPerformed
        if ("".equals(seleccion_servicio.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese primero un ID de producto valido");
        } else {
            try { //Validando información
                Integer ID_Producto = Integer.parseInt(seleccion_servicio.getText());

                Statement get_producto_query = conexion.createStatement(); //Query para obtener el producto solicitado
                ResultSet resultado = get_producto_query.executeQuery("SELECT p.Nombre, p.Precio_unitario, p.Disponibilidad FROM Productos_Header p where ID_Producto=" + ID_Producto);

                while (resultado.next()) {
                    nombre_med_chko1.setText(resultado.getString(1));
                    preciounidad_med_chko.setText(resultado.getString(2));
                    disponibilidad_field_chko.setText(resultado.getString(3));
                    med_quan_field_chko.setEnabled(true);
                    med_quan_field_chko.setEditable(true);
                }

                if ("".equals(nombre_med_chko1.getText())) {
                    throw new Exception("No se encuentra el producto");
                }

                if (ticket_servicios.getText().contains(nombre_med_chko1.getText())) { //Verificando que el producto no haya sido agregado 2 veces
                    nombre_med_chko1.setText(null);
                    preciounidad_med_chko.setText(null);
                    disponibilidad_field_chko.setText(null);
                    throw new Exception("No puedes agregar el mismo producto 2 veces");
                }

                seleccion_servicio.setText(null);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_agrega_servicioActionPerformed

    private void checkout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkout_buttonActionPerformed
        if ("".equals(ticket_servicios.getText())) {
            JOptionPane.showMessageDialog(null, "Añada un producto para vender");
        } else {
            id_venta++;
            Confirmar_Venta cv = new Confirmar_Venta(carrito, conexion, String.valueOf(usuario_activo), String.valueOf(id_venta));
            cv.setVisible(true);
            ticket_servicios.setText(null);
            limpiar_casillas_chkout();
            carrito.clear();
        }
    }//GEN-LAST:event_checkout_buttonActionPerformed

    private void cancelar_serviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_serviciosActionPerformed
        carrito.clear();
        total = 0f;
        total_servicios.setText(null);
        ticket_servicios.setText(null);
        seleccion_servicio.setText(null);
        limpiar_casillas_chkout();
    }//GEN-LAST:event_cancelar_serviciosActionPerformed

    private void total_serviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_serviciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_serviciosActionPerformed

    private void med_quan_field_chkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_med_quan_field_chkoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_med_quan_field_chkoActionPerformed

    private void nombre_empleado_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_empleado_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_empleado_fieldActionPerformed

    private void administrar_usuarios_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrar_usuarios_buttonActionPerformed
        Administrar_Usuarios au = new Administrar_Usuarios(conexion);
        au.setVisible(true);

    }//GEN-LAST:event_administrar_usuarios_buttonActionPerformed

    private void pedido_entregado_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido_entregado_buttonActionPerformed
        try {
            //Esta parte es para traer la fecha de entrega del pedido seleciconado
            ResultSet fechas_entregas = conexion.createStatement().executeQuery("SELECT Fecha_Entregado FROM Pedidos_Header WHERE ID_Pedido = " + Integer.parseInt(order_id_field.getText()));
            String fecha_entrega_aux = ""; //Aca se va a guardar la fecha traida por fecha_entregas

            while (fechas_entregas.next()) { //Ciclamos por el set regresado y guardamos la fecha
                fecha_entrega_aux = fechas_entregas.getString(1);
            }

            if (fecha_entrega_aux == null) {  //Si la todavia no entregan el pedido entonces la fecha será null y hacemos el update para que se actualize a la fecha de hoy
                conexion.createStatement().executeUpdate("UPDATE pedidos_header SET Fecha_Entregado = GETDATE() WHERE ID_Pedido = " + Integer.parseInt(order_id_field.getText()));
            } else {
                throw new Exception("Este pedido ya ha sido entregado"); //Si ya ha sido entregado tiramos la excepcion
            }

            agregar_productos_pedido(Integer.parseInt(order_id_field.getText())); //Funcion que añade los productos
            limpiar_pedido_buttonActionPerformed(null);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_pedido_entregado_buttonActionPerformed

    private void refresh_pedidos_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_pedidos_button1ActionPerformed
        mostrar_pedidos();
     }//GEN-LAST:event_refresh_pedidos_button1ActionPerformed

    private void clean_verventas_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clean_verventas_buttonActionPerformed
        idventa_verventa_field.setText("");
        empleado_verventa_field.setText("");
        cliente_verventa_field.setText("");
        fecha_venta_verventa_field.setText("");
        totalventa_verventa_field.setText("");
        ver_ventas_field1.setText("");
        telefonocliente_verventa_field.setText("");
        telefonoempleado_verventa_field.setText("");
    }//GEN-LAST:event_clean_verventas_buttonActionPerformed

    private void buscarventa_verventa_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarventa_verventa_buttonActionPerformed
        try {
            if("".equals(idventa_verventa_field.getText())){
                throw new Exception ("Ingrese un ID de venta para buscar");
            }
            
            
            Integer id_venta = Integer.parseInt(idventa_verventa_field.getText());
            ver_ventas_field1.setText("");
            ResultSet ver_venta = conexion.createStatement().executeQuery("SELECT * from dbo.ver_ventas (" + id_venta + ")");
            ResultSet calcular_venta = conexion.createStatement().executeQuery("SELECT dbo.calcular_venta (" + id_venta + ")");

            while (ver_venta.next()) {
                ver_ventas_field1.append(ver_venta.getString(1) + "                " + ver_venta.getString(2) + "              " + ver_venta.getString(3) + "                   " + ver_venta.getString(4) + "\n");
                fecha_venta_verventa_field.setText(ver_venta.getString(7));
                cliente_verventa_field.setText(ver_venta.getString(6));
                empleado_verventa_field.setText(ver_venta.getString(5));
                telefonocliente_verventa_field.setText(ver_venta.getString(8));
                telefonoempleado_verventa_field.setText(ver_venta.getString(9));
            }

            while (calcular_venta.next()) {
                totalventa_verventa_field.setText("$" + calcular_venta.getString(1));
            }

            if ("".equals(ver_ventas_field1.getText())) {
                throw new Exception("No se ha encontrado la venta");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_buscarventa_verventa_buttonActionPerformed

    private void idventa_verventa_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idventa_verventa_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idventa_verventa_fieldActionPerformed

    private void cancel_clientes_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_clientes_buttonActionPerformed
        mostrar_clientes();
        telefono_cliente_field.setText("");
        nombre_cliente_field.setText("");
        id_cliente_clientes_field.setText("");

        id_cliente_clientes_field.setEditable(true);

    }//GEN-LAST:event_cancel_clientes_buttonActionPerformed

    private void refresh_pedidos_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_pedidos_button2ActionPerformed
        mostrar_ventas();
    }//GEN-LAST:event_refresh_pedidos_button2ActionPerformed

    private void refresh_empleadoventas_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_empleadoventas_buttonActionPerformed
        empleadomasventas_statistics_field1.setText("");
        empleadomasventastotal_statistics_field.setText("");
        try {
            conexion.createStatement().executeUpdate("exec create_view_empleado_masventas '" + (String) periodotiempo_empleado_statistics_field.getSelectedItem() + "'");

            ResultSet empleado_masventas = conexion.createStatement().executeQuery("select TOP 1 * from empleados_ventas ORDER BY total_empleado DESC");

            while (empleado_masventas.next()) {
                empleadomasventas_statistics_field1.setText(empleado_masventas.getString(1));
                empleadomasventastotal_statistics_field.setText("$" + empleado_masventas.getString(2));
            }

            if ("".equals(empleadomasventas_statistics_field1.getText())) {
                empleadomasventas_statistics_field1.setText("Sin ventas");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_refresh_empleadoventas_buttonActionPerformed

    private void refresh_clientescompras_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_clientescompras_buttonActionPerformed
        clientemascompras_statistics_field.setText("");
        clientemascomprastotal_statistics_field.setText("");
        try {

            conexion.createStatement().executeUpdate("exec create_view_clientes_mascompras '" + (String) periodotiempo_clientes_statistics_field.getSelectedItem() + "'");

            ResultSet clientes_mascompras = conexion.createStatement().executeQuery("select TOP 1 * from clientes_compras ORDER BY total_cliente DESC");

            while (clientes_mascompras.next()) {
                clientemascompras_statistics_field.setText(clientes_mascompras.getString(1));
                clientemascomprastotal_statistics_field.setText("$" + clientes_mascompras.getString(2));
            }

            if ("".equals(clientemascompras_statistics_field.getText())) {
                clientemascompras_statistics_field.setText("Sin ventas");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_refresh_clientescompras_buttonActionPerformed

    private void refresh_prodvendido_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_prodvendido_buttonActionPerformed
        productoprovl_statistics_field.setText("");
        productomasvendido_statistics_field.setText("");

        try {

            ResultSet producto = conexion.createStatement().executeQuery("EXEC get_producto_vendido '" + (String) periodotiempo_prod_statistics_field.getSelectedItem() + "'");

            while (producto.next()) {
                productomasvendido_statistics_field.setText(producto.getString(1) + "     Cantidad: " + producto.getString(3));
                productoprovl_statistics_field.setText("Proveedor: " + producto.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_refresh_prodvendido_buttonActionPerformed

    private void productoprovl_statistics_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoprovl_statistics_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productoprovl_statistics_fieldActionPerformed

    private void bajadis_refresh_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajadis_refresh_bottonActionPerformed
        try {
            bajadis_statistics_field.setText("");
            ResultSet baja_dis = conexion.createStatement().executeQuery("SELECT Nombre, Disponibilidad from Productos_Header WHERE Disponibilidad < 5");

            while (baja_dis.next()) {
                bajadis_statistics_field.setText(baja_dis.getString(1) + "    Cantidad: " + baja_dis.getString(2));
            }

            if ("".equals(bajadis_statistics_field.getText())) {
                bajadis_statistics_field.setText("Todo bien!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bajadis_refresh_bottonActionPerformed

    private void expiracy_refresh_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expiracy_refresh_bottonActionPerformed
        try {
            expiracy_refresh_field.setText("");
            ResultSet caducidad = conexion.createStatement().executeQuery("SELECT ph.Nombre, pm.Caducidad from Productos_Med pm INNER JOIN Productos_Header ph ON ph.ID_Producto = pm.ID_Producto WHERE Caducidad <= GETDATE()+5");

            while (caducidad.next()) {
                expiracy_refresh_field.setText(caducidad.getString(1) + "  Fecha: " + caducidad.getString(2));
            }

            if ("".equals(expiracy_refresh_field.getText())) {
                expiracy_refresh_field.setText("Todo bien!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_expiracy_refresh_bottonActionPerformed

    private void pedidosnodados_statistics_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosnodados_statistics_buttonActionPerformed

        try {
            pedidosnodados_statistics_field1.setText("");
            pedidosnodados_statistics_field2.setText("");
            ResultSet pendientes = conexion.createStatement().executeQuery("SELECT TOP 2 ID_Pedido, Nombre FROM Pedidos_Header ph INNER JOIN Proveedores p ON p.ID_Proveedor = ph.ID_Proveedor WHERE Fecha_Entregado IS NULL");

            while (pendientes.next()) {
                pedidosnodados_statistics_field1.setText("ID: " + pendientes.getString(1) + "  Proveedor: " + pendientes.getString(2));
                if (pendientes.next()) {
                    pedidosnodados_statistics_field2.setText("ID: " + pendientes.getString(1) + "  Proveedor: " + pendientes.getString(2));
                }
            }

            if ("".equals(pedidosnodados_statistics_field1.getText()) && "".equals(pedidosnodados_statistics_field2.getText())) {
                pedidosnodados_statistics_field1.setText("Todo bien!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_pedidosnodados_statistics_buttonActionPerformed

    private void Ventas_x_Cliente_statsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ventas_x_Cliente_statsActionPerformed

        Ventas_x_Cliente vc = new Ventas_x_Cliente(conexion);

        vc.setVisible(true);


    }//GEN-LAST:event_Ventas_x_Cliente_statsActionPerformed

    private void Ventas_x_Empleado_statsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ventas_x_Empleado_statsActionPerformed

        Ventas_x_Empleado ve = new Ventas_x_Empleado(conexion);

        ve.setVisible(true);

    }//GEN-LAST:event_Ventas_x_Empleado_statsActionPerformed

    private void delete_empleado_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_empleado_buttonActionPerformed
        try {

            if ("".equals(buscar_empleado_field.getText()) || check_string(buscar_empleado_field.getText())) {
                throw new Exception("Ha ingresado un ID de empleado invalido");
            }

            conexion.createStatement().executeUpdate("DELETE FROM Empleados WHERE ID_Empleado = " + buscar_empleado_field.getText());

            clean_bottonActionPerformed(null);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_delete_empleado_buttonActionPerformed

    private void refresh_empleadoventas_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_empleadoventas_button1ActionPerformed
        calcular_total_dia();
    }//GEN-LAST:event_refresh_empleadoventas_button1ActionPerformed

    private void quanxu_prod_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanxu_prod_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quanxu_prod_fieldActionPerformed

    private void ingredientes_prod_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientes_prod_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingredientes_prod_fieldActionPerformed

    private void administrarmarca_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarmarca_buttonActionPerformed
        Administrar_Marcas am = new Administrar_Marcas(conexion);
        am.setVisible(true);
    }//GEN-LAST:event_administrarmarca_buttonActionPerformed

    private void administrarcat_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarcat_buttonActionPerformed
        Administrar_Categorias ac = new Administrar_Categorias(conexion);
        ac.setVisible(true);
    }//GEN-LAST:event_administrarcat_buttonActionPerformed

    private void administrarpres_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarpres_buttonActionPerformed
        Administrar_Presentaciones ap = new Administrar_Presentaciones(conexion);
        ap.setVisible(true);
    }//GEN-LAST:event_administrarpres_buttonActionPerformed

    private void id_cliente_clientes_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_cliente_clientes_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_cliente_clientes_fieldActionPerformed

    private void reporte_diario_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporte_diario_buttonActionPerformed
        Reporte_Diario rd = new Reporte_Diario(conexion);
        rd.setVisible(true);
    }//GEN-LAST:event_reporte_diario_buttonActionPerformed

    public void mostrar_usuarios() {
        mostrar_empleados.setText("");
        try {
            ResultSet lista_usuarios = conexion.createStatement().executeQuery("SELECT * FROM Empleados");

            while (lista_usuarios.next()) {
                mostrar_empleados.append(lista_usuarios.getString(1) + "\t" + lista_usuarios.getString(2) + "\t" + lista_usuarios.getString(3) + "\t" + lista_usuarios.getString(4) + "\t\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void ver_lista_ventas() { //Funcion que muestra el carrito de compras
        //NOTA: [0] es el nombre ,[1] es la cantidad, [2] es el precio actual
        ListIterator contador = carrito.listIterator();
        ticket_servicios.setText("");
        while (contador.hasNext()) {
            Object[] a_comprar = (Object[]) contador.next();
            ticket_servicios.append((String) a_comprar[0] + "\t\t" + (int) a_comprar[1] + "\t\t" + (Float) ((int) a_comprar[1] * (Float) a_comprar[2]) + "\n");
        }
        calcular_total();

    }

    public void calcular_total() {
        ListIterator contador = carrito.listIterator();
        Float total = 0f;
        while (contador.hasNext()) {
            Object[] a_comprar = (Object[]) contador.next();
            total += (float) ((int) a_comprar[1] * (float) a_comprar[2]);
        }
        total_servicios.setText("$" + total);
    }

    public void limpiar_casillas_chkout() {
        nombre_med_chko1.setText(null);
        nombre_med_chko1.setEditable(false);
        preciounidad_med_chko.setText(null);
        preciounidad_med_chko.setEditable(false);
        med_quan_field_chko.setText(null);
        med_quan_field_chko.setEditable(false);
        disponibilidad_field_chko.setText(null);
        disponibilidad_field_chko.setEditable(false);
        total_servicios.setText("");
    }

    private void ocultar_pestañas(Connection conexion) throws SQLException { //Funcion que oculta las pestañas que no les son permitidas al usuario dependiendo del rol de SQL.

        if (!"GERENTE".equals(get_rol())) {
            for (int i = 4; i <= 6; i++) {
                JPane.setEnabledAt(i, false);
            }

            guardarprod_prod_button.setVisible(false);
            eliminarprod_prod_button.setVisible(false);
            precio_prod_field.setEditable(false);
            disponibilidad_prod_field.setEditable(false);
            nombre_prod_field.setEditable(false);
            ingredientes_prod_field.setEditable(false);
            pesoxu_prod_field.setEditable(false);
            quanxu_prod_field.setEditable(false);
            caducidad_prod_field.setEnabled(false);

            administrarpres_button.setEnabled(false);
            administrarmarca_button.setEnabled(false);
            administrarcat_button.setEnabled(false);
            presentacion_prod_field.setEnabled(false);
            prov_prod_field.setEnabled(false);
            categoria_prod_field.setEnabled(false);
            marca_prod_field.setEnabled(false);

        }

    }

    public static Boolean check_string(String s) { //Funcion que checa las queries por motivos de seguridad
        return Arrays.stream(caracteres_prohibidos).anyMatch(s::contains);
    }

    private String get_rol() throws SQLException { //   Funcion que obtiene el rol del usuario
        try {
            Statement get_rol = conexion.createStatement();
            String query = "select r.Descripcion from usuarios u inner join Roles r on u.ID_Rol = r.ID_Rol where u.ID_Empleado = " + usuario_activo;
            ResultSet resultado = get_rol.executeQuery(query);
            while (resultado.next()) {
                String rol = resultado.getString(1);
                return rol;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha sucedido un error en la base de datos");
        }
        return null;
    }

    private Integer get_idventa() { // Funcion que retorna el ID_Venta más alto para generar ID unicos desde la aplicacion
        try {
            Statement get_id = conexion.createStatement();
            ResultSet res = get_id.executeQuery("select MAX(ID_Venta) from Ventas_Header");

            while (res.next()) {
                return (Integer) res.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        return null;
    }

    private void mostrar_pedidos() {
        try {
            ordenes_datos_field.setText("");
            ResultSet pedidos = conexion.createStatement().executeQuery("SELECT ID_Pedido, ROUND(Total_Orden,2) , Fecha_Entregado FROM pedidos_vista ORDER BY Fecha_Entregado DESC");
            while (pedidos.next()) {

                String fecha_entregado = pedidos.getString(3); //Regresando la fecha de entregado
                if (fecha_entregado == null) {
                    fecha_entregado = "N/A";  //Si es null, entonces hacemos que ahora diga "no entregado"
                }
                ordenes_datos_field.append( //Imprimimos toda la vista en la pestaña
                        pedidos.getString(1)
                        + "         $" + pedidos.getString(2)
                        + "          " + fecha_entregado
                        + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void agregar_productos_pedido(int id_pedido) {
        try {
            //Este query es para traer el pedido en sí para actualizar la existencia de los productos
            ResultSet pedido = conexion.createStatement().executeQuery("SELECT ID_Producto, Cantidad FROM Pedidos_Detalle WHERE ID_Pedido = " + id_pedido);

            //Ahora ciclaremos por el otro query para actualizar las disponibilidades
            while (pedido.next()) {
                conexion.createStatement().executeUpdate("EXEC aumentar_disponibilidad " + pedido.getString(1) + "," + pedido.getString(2));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void mostrar_clientes() {
        try {
            mostrar_clientes_field.setText("");
            //Este query es para traer todos los clientes en la DB
            ResultSet clientes = conexion.createStatement().executeQuery("SELECT * FROM Clientes");

            while (clientes.next()) {
                mostrar_clientes_field.append(clientes.getString(1) + "                     " + clientes.getString(2) + "            " + clientes.getString(3) + "\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void mostrar_ventas() {
        try {
            ver_todas_ventas_field.setText("");
            //Este query es para traer todos los clientes en la DB
            ResultSet ventas = conexion.createStatement().executeQuery("select ID_Venta, dbo.calcular_venta(ID_Venta) from Ventas_Header");

            while (ventas.next()) {
                ver_todas_ventas_field.append(ventas.getString(1) + "\t" + ventas.getString(2) + "\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void mostrar_productos() {
        try {
            mostrarproductos_prod_field.setText("");
            caducidad_prod_field.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime())); //Esto lo pongo para que se ponga la fecha de hoy en el calendario, realmente solo sirve para que no quede como null.
            //Este query es para traer todos los clientes en la DB
            ResultSet productos = conexion.createStatement().executeQuery("select ID_Producto, Disponibilidad, Precio_unitario, Nombre from Productos_Header");

            while (productos.next()) {
                mostrarproductos_prod_field.append(productos.getString(1) + "\t" + productos.getString(2) + "\t" + productos.getString(3) + "\t" + productos.getString(4) + "\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void calcular_total_dia() {
        try {
            //El select va a calcular el total del dia
            ResultSet totales = conexion.createStatement().executeQuery("select ROUND(SUM(Cantidad * Precio_Unitario),2) from Ventas_Detalle vd INNER JOIN Ventas_Header vh on vh.ID_Venta = vd.ID_Venta WHERE Fecha = cast(getdate() as date)");

            while (totales.next()) {
                if (totales.getString(1) == null) {
                    diatotal_statistics_field.setText("$0");
                } else {
                    diatotal_statistics_field.setText("$" + totales.getString(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void set_productos_campos() {

        try {
            //Seleccionamos todas las marcas
            ResultSet marca = conexion.createStatement().executeQuery("SELECT Descripcion from Marcas");
            ResultSet presentacion = conexion.createStatement().executeQuery("SELECT Descripcion from Presentaciones");
            ResultSet categoria = conexion.createStatement().executeQuery("SELECT Descripcion from Categorias_Prod");
            ResultSet proveedor = conexion.createStatement().executeQuery("SELECT Nombre from Proveedores");

            LinkedList marcas = new LinkedList();
            LinkedList presentaciones = new LinkedList();
            LinkedList categorias = new LinkedList();
            LinkedList proveedores = new LinkedList();

            while (marca.next()) {
                //Una por una
                marcas.add(marca.getString(1));
            }

            while (presentacion.next()) {
                //Una por una
                presentaciones.add(presentacion.getString(1));
            }

            while (categoria.next()) {
                //Una por una
                categorias.add(categoria.getString(1));
            }

            while (proveedor.next()) {
                //Una por una
                proveedores.add(proveedor.getString(1));
            }

            //Si no hay nada en la lista, entonces error
            if (marcas.isEmpty() || presentaciones.isEmpty() || categorias.isEmpty() || proveedores.isEmpty()) {
                throw new Exception("Asegúrese de tener los suficientes datos cargados para mostrar");
            }

            //Aca vamos a inicializar un nuevo arreglo de String
            String[] marcas_model = new String[marcas.size()];
            String[] presentaciones_model = new String[presentaciones.size()];
            String[] categorias_model = new String[categorias.size()];
            String[] proveedores_model = new String[proveedores.size()];

            //Y vamos a llenar dicho arreglo con la lista usando la función toArray para convertirla
            marcas.toArray(marcas_model);
            presentaciones.toArray(presentaciones_model);
            categorias.toArray(categorias_model);
            proveedores.toArray(proveedores_model);

            //SetModel nos va a establecer los campos en dicho menu de lista de acuerdo a lo que haya en el arreglo.
            marca_prod_field.setModel(new javax.swing.DefaultComboBoxModel<>(marcas_model));
            categoria_prod_field.setModel(new javax.swing.DefaultComboBoxModel<>(categorias_model));
            prov_prod_field.setModel(new javax.swing.DefaultComboBoxModel<>(proveedores_model));
            presentacion_prod_field.setModel(new javax.swing.DefaultComboBoxModel<>(presentaciones_model));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public static void main(String args[]) throws ClassNotFoundException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel Cantidad1;
    private javax.swing.JPanel ClientesPane;
    private javax.swing.JPanel EmpleadosPane;
    private javax.swing.JPanel EstadisticasPane;
    private javax.swing.JTabbedPane JPane;
    private javax.swing.JPanel PedidosPane;
    private javax.swing.JPanel ProductosPane;
    private javax.swing.JPanel UsuariosPane;
    private javax.swing.JPanel VenderPane;
    private javax.swing.JButton Ventas_x_Cliente_stats;
    private javax.swing.JButton Ventas_x_Empleado_stats;
    private javax.swing.JButton add_sell;
    private javax.swing.JButton administrar_usuarios_button;
    private javax.swing.JButton administrarcat_button;
    private javax.swing.JButton administrarmarca_button;
    private javax.swing.JButton administrarpres_button;
    private javax.swing.JButton agrega_servicio;
    private javax.swing.JButton agregar_new_pedido_button;
    private javax.swing.JButton bajadis_refresh_botton;
    private javax.swing.JTextField bajadis_statistics_field;
    private javax.swing.JButton buscar_cedula_botton;
    private javax.swing.JTextField buscar_empleado_field;
    private javax.swing.JButton buscar_order_button;
    private javax.swing.JButton buscarprod_prod_button;
    private javax.swing.JButton buscarventa_verventa_button;
    private com.toedter.calendar.JDateChooser caducidad_prod_field;
    private javax.swing.JButton cancel_clientes_button;
    private javax.swing.JButton cancelar_prod_button;
    private javax.swing.JButton cancelar_servicios;
    private javax.swing.JComboBox<String> categoria_prod_field;
    private javax.swing.JButton checkout_button;
    private javax.swing.JButton clean_botton;
    private javax.swing.JButton clean_verventas_button;
    private javax.swing.JTextField cliente_verventa_field;
    private javax.swing.JTextField clientemascompras_statistics_field;
    private javax.swing.JTextField clientemascomprastotal_statistics_field;
    private javax.swing.JButton corte_caja;
    private javax.swing.JButton delete_empleado_button;
    private javax.swing.JTextField diatotal_statistics_field;
    private javax.swing.JTextField disponibilidad_field_chko;
    private javax.swing.JTextField disponibilidad_prod_field;
    private javax.swing.JLabel disponibilidadfield;
    private javax.swing.JButton eliminar_cliente_button;
    private javax.swing.JButton eliminarprod_prod_button;
    private javax.swing.JTextField empleado_pedido_field;
    private javax.swing.JTextField empleado_verventa_field;
    private javax.swing.JTextField empleadomasventas_statistics_field1;
    private javax.swing.JTextField empleadomasventastotal_statistics_field;
    private javax.swing.JButton expiracy_refresh_botton;
    private javax.swing.JTextField expiracy_refresh_field;
    private javax.swing.JTextField fecha_pedidos_field;
    private javax.swing.JTextField fecha_venta_verventa_field;
    private javax.swing.JButton guardar_cliente_button;
    private javax.swing.JButton guardarprod_prod_button;
    private javax.swing.JTextField id_cliente_clientes_field;
    private javax.swing.JTextField idprod_prod_field;
    private javax.swing.JTextField idventa_verventa_field;
    private javax.swing.JTextField ingredientes_prod_field;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame10;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JInternalFrame jInternalFrame9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton limpiar_pedido_button;
    private javax.swing.JTextField marca_pedidos_field;
    private javax.swing.JComboBox<String> marca_prod_field;
    private javax.swing.JTextField med_quan_field_chko;
    private javax.swing.JTextArea mostrar_clientes_field;
    private javax.swing.JTextArea mostrar_empleados;
    private javax.swing.JTextArea mostrarproductos_prod_field;
    private javax.swing.JTextField nombre_cliente_field;
    private javax.swing.JTextField nombre_empleado_field;
    private javax.swing.JTextField nombre_med_chko1;
    private javax.swing.JTextField nombre_pedidos_field;
    private javax.swing.JTextField nombre_prod_field;
    private javax.swing.JTextArea ordenes_datos_field;
    private javax.swing.JTextField order_id_field;
    private javax.swing.JButton pedido_entregado_button;
    private javax.swing.JButton pedidosnodados_statistics_button;
    private javax.swing.JTextField pedidosnodados_statistics_field1;
    private javax.swing.JTextField pedidosnodados_statistics_field2;
    private javax.swing.JComboBox<String> periodotiempo_clientes_statistics_field;
    private javax.swing.JComboBox<String> periodotiempo_empleado_statistics_field;
    private javax.swing.JComboBox<String> periodotiempo_prod_statistics_field;
    private javax.swing.JTextField pesoxu_prod_field;
    private javax.swing.JTextField posicion_empleado_field;
    private javax.swing.JTextField precio_prod_field;
    private javax.swing.JTextField preciounidad_med_chko;
    private javax.swing.JComboBox<String> presentacion_prod_field;
    private javax.swing.JTextField productomasvendido_statistics_field;
    private javax.swing.JTextField productoprovl_statistics_field;
    private javax.swing.JTextArea productos_ordenes_field;
    private javax.swing.JComboBox<String> prov_prod_field;
    private javax.swing.JButton proveedores_button;
    private javax.swing.JTextField quanxu_prod_field;
    private javax.swing.JButton refresh_clientescompras_button;
    private javax.swing.JButton refresh_empleadoventas_button;
    private javax.swing.JButton refresh_empleadoventas_button1;
    private javax.swing.JButton refresh_pedidos_button1;
    private javax.swing.JButton refresh_pedidos_button2;
    private javax.swing.JButton refresh_prodvendido_button;
    private javax.swing.JButton reporte_diario_button;
    private javax.swing.JButton save_botton1;
    private javax.swing.JButton search_idclient_button;
    private javax.swing.JTextField seleccion_servicio;
    private javax.swing.JTextField telefono_cliente_field;
    private javax.swing.JTextField telefono_empleado_field;
    private javax.swing.JTextField telefono_pedidos_field;
    private javax.swing.JTextField telefonocliente_verventa_field;
    private javax.swing.JTextField telefonoempleado_verventa_field;
    private javax.swing.JTextArea ticket_servicios;
    private javax.swing.JTextField total_servicios;
    private javax.swing.JTextField totalventa_verventa_field;
    private javax.swing.JTextArea ver_todas_ventas_field;
    private javax.swing.JTextArea ver_ventas_field1;
    // End of variables declaration//GEN-END:variables
}
