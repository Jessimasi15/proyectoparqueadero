/********************************************************************************
 * Proyecto Parqueadero.
 * 
 * @author Jessica I. Cespedes Sica
 * Fecha: Marzo 2020
 ********************************************************************************
 */
package parqueadero.interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import conectorBD.GestionUsuario;
import conectorBD.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * Clase de la Interfaz Principal donde será el login de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazPrincipal extends JFrame implements ActionListener
{
    //------------------------------------------------------------------------
    // CONSTANTES
    //------------------------------------------------------------------------
    
    /**
     * Comando ingresar
     */
    private static final String INGRESAR = "INGRESAR";
    //------------------------------------------------------------------------
    // Atributos de la interfaz
    //------------------------------------------------------------------------
    
    /**
     * Panel de la interfaz de la aplicación.
     */
    private JPanel contentPane;
    
    /**
     * Campo de texto para ingresar el usuario.
     */
    private JTextField textUsuario;
    
    /**
     * Campo de texto para ingresar la contraseña encriptada.
     */
    private JPasswordField passwordUsuario;
    
    //--------------------------------------------------------------------
    // Constructores
    //--------------------------------------------------------------------
    
    /**
     * Crea la ventana de la interfaz principal para el inicio de sesión de la aplicación.
     */
    public InterfazPrincipal( )
    {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setBounds( 100, 100, 500, 400 );
        contentPane = new JPanel( );
        contentPane.setLayout( new BorderLayout( 0, 0 ) );
        setContentPane( contentPane );
        
        JPanel PanelPrincipal = new JPanel();
        getContentPane().add(PanelPrincipal);
        PanelPrincipal.setLayout(null);
        
        JLabel lbNombre = new JLabel("Parking Control");
        lbNombre.setBounds(0, 11, 176, 84);
        lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lbNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
        PanelPrincipal.add(lbNombre);
        
        JLabel lbImagen = new JLabel("");
        lbImagen.setBounds(171, 0, 313, 106);
        lbImagen.setIcon(new ImageIcon(InterfazPrincipal.class.getResource("/parqueadero/interfaz/parking.png")));
        lbImagen.setHorizontalAlignment(SwingConstants.CENTER);
        PanelPrincipal.add(lbImagen);
        
        JLabel lbBienvenido = new JLabel("Bienvenido al Sistema");
        lbBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        lbBienvenido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lbBienvenido.setBounds(97, 117, 288, 32);
        PanelPrincipal.add(lbBienvenido);
        
        JLabel lbTitulo = new JLabel("Ingrese sus datos para iniciar sesi\u00F3n:");
        lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setBounds(107, 160, 265, 14);
        PanelPrincipal.add(lbTitulo);
        
        JLabel lbUsuario = new JLabel("Usuario: ");
        lbUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbUsuario.setBounds(111, 189, 105, 23);
        PanelPrincipal.add(lbUsuario);
        
        textUsuario = new JTextField();
        textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textUsuario.setBounds(243, 190, 129, 23);
        PanelPrincipal.add(textUsuario);
        textUsuario.setColumns(10);
        
        JLabel lbContraseña = new JLabel("Contrase\u00F1a: ");
        lbContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        lbContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbContraseña.setBounds(111, 235, 105, 23);
        PanelPrincipal.add(lbContraseña);
        
        passwordUsuario = new JPasswordField();
        passwordUsuario.setBounds(243, 235, 129, 23);
        PanelPrincipal.add(passwordUsuario);
        
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnIngresar.setBounds(177, 294, 115, 45);
        btnIngresar.setActionCommand( INGRESAR );
        btnIngresar.addActionListener( this );
        PanelPrincipal.add(btnIngresar);
    }
    
    //-----------------------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------------------
    
    /**
     * Ingreso con usuario y contraseña a la aplicación.
     */
    @SuppressWarnings("deprecation")
    public void ingresar()
    {
        String usuario = textUsuario.getText( );
        String pass = passwordUsuario.getText( );
        
        /*if(usuario.isEmpty( ) || pass.isEmpty( ))
        {
            JOptionPane.showMessageDialog( null, "Algún campo está vacio." );
        }
        else
        {
            if(usuario.equals( "admin" ) && pass.equals( "admin" ))
            {
                JOptionPane.showMessageDialog( null, "Bienvenido." );
                InterfazOperaciones inicio = new InterfazOperaciones();
                inicio.setVisible( true );
                this.dispose( );
            }
            else
            {
                JOptionPane.showMessageDialog( null, "Su usuario o contraseña es incorrecto." );
            }
        }*/
        
        // Con Conexion a MySQL
        GestionUsuario gestionUsuario = new GestionUsuario();
        
        Usuario usuario2 = new Usuario();
        usuario2.guardarUsuario( usuario );
        usuario2.guardarClave( pass );
        
        Usuario usuario1 = gestionUsuario.obtenerUsuario( usuario2 );
        
        if(usuario1 != null)
        {
            JOptionPane.showMessageDialog( contentPane, "Bienvenido." );
            InterfazOperaciones inicio = new InterfazOperaciones();
            inicio.setVisible( true );
            this.dispose( );
        }
        else
        {
            JOptionPane.showMessageDialog( contentPane, "Datos invalidos.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
    
    /**
     * Acción del botón de ingresar a la aplicación.
     */
    public void actionPerformed(ActionEvent pEvento)
    {
        String command = pEvento.getActionCommand( );
        if(command.equals( INGRESAR ))
        {
            ingresar();
        }
    }
    
    
    /**
     * Ejecuta la aplicación.
     */
    public static void main( String[] args )
    {
        EventQueue.invokeLater( new Runnable( )
        {
            public void run( )
            {
                try
                {
                    InterfazPrincipal frame = new InterfazPrincipal( );
                    frame.setVisible( true );
                }
                catch( Exception e )
                {
                    e.printStackTrace( );
                }
            }
        } );
    }

}
