package Usuarios;

import Menus.Menu;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    public Login() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        login_botton = new javax.swing.JButton();
        userfield = new javax.swing.JTextField();
        passfield = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoMedyCity.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medicity Farmacias");
        setBackground(new java.awt.Color(255, 204, 204));
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        setForeground(new java.awt.Color(153, 204, 226));
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(137, 166, 246));
        jLabel1.setText("ID de Empleado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 166, 246));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        login_botton.setBackground(new java.awt.Color(255, 170, 151));
        login_botton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        login_botton.setForeground(new java.awt.Color(87, 116, 196));
        login_botton.setText("Iniciar Sesión");
        login_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_bottonActionPerformed(evt);
            }
        });
        getContentPane().add(login_botton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 140, 35));
        getContentPane().add(userfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 117, 35));
        getContentPane().add(passfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 117, 35));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoMedyCity.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 204, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 650, 460));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGAPP.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 650, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_bottonActionPerformed
        try {
            Integer campo_usuario = Integer.parseInt(userfield.getText());
            String campo_contrasenya = passfield.getText();
            
            Connection conexion = getConexion (campo_usuario, campo_contrasenya); //Funcion que conecta a la DB y nos trae el objeto conexion que literalmente hace todo el programa jalar
            
            if (conexion!= null){
                 Menu pc = new Menu(conexion, campo_usuario);
                 pc.setVisible(true);
                 this.dispose();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Su usuario o contraseña son incorrectos");
        
        }
    }//GEN-LAST:event_login_bottonActionPerformed
    
    
    public static Connection getConexion (Integer usuario, String contrasenya) throws ClassNotFoundException{ //Acá intentamos conectar a la DB
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                //USTEDES SUSTITUYAN ESTOS DATOS DEPENDIENDO DE SUS COMPUTADORAS
                "jdbc:sqlserver://localhost:1433;" //VEAN EL TUTO DE ARRIBA, PERO EN TEORÍA DEBERIA SER IGUAL PARA TODOS
                        + "database=Medicity;" 
                        + "user="+ usuario +";"   //RECUERDEN CREAR UN USUARIO EN SQL SERVER https://www.youtube.com/watch?v=l8bEa8j_c6o, AUNQUE EL .SQL YA TENGA USUARIOS PARA CREAR, EL SQL SERVER
                        + "password="+ contrasenya +";"  //NO TE VA A DEJAR INICIAR SESIÓN HASTA QUE NO ACTIVES Y VEAS EL VIDEO ESE https://www.youtube.com/watch?v=wjIXaPW1dy8
                        + "trustServerCertificate=true";
        try {
           Connection connection = DriverManager.getConnection(connectionUrl);
           
           return connection;
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Su usuario o contraseña son incorrectos");
        }
        return null;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton login_botton;
    private javax.swing.JPasswordField passfield;
    private javax.swing.JTextField userfield;
    // End of variables declaration//GEN-END:variables
}