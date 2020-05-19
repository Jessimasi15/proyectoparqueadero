/********************************************************************************
 * Proyecto Parqueadero.
 * 
 * @author Jessica I. Cespedes Sica
 * Fecha: Marzo 2020
 ********************************************************************************
 */

package parqueadero.interfaz;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

import parqueadero.mundo.*;

/**
 * Clase interfaz operaciones donde se interactua con el parqueadero.
 */
@SuppressWarnings("serial")
public class InterfazOperaciones extends JFrame implements ActionListener
{
    //----------------------------------------------------------------------
    // Constantes
    //----------------------------------------------------------------------
    
    /**
     * Comando ingresar.
     */
    private final static String INGRESAR = "INGRESAR";
    
    /**
     * Comando salir.
     */
    private final static String SALIR = "SALIR";
    
    /**
     * Comando avanzar.
     */
    private final static String AVANZAR = "AVANZAR";
    
    /**
     * Comando cambiar.
     */
    private final static String CAMBIAR = "CAMBIAR";

    /**
     * Comando para salir del sistema.
     */
    private static final String SALIR_SISTEMA = "SALIR SISTEMA";
    
    //---------------------------------------------------------------------------
    // Atributos de la interfaz
    //---------------------------------------------------------------------------
    
    /**
     * Panel que contiene la interfaz de operaciones.
     */
    private JPanel contentPane;
    
    /**
     * Etiqueta para el valor de la hora.
     */
    private JLabel lbHoraActual;
    
    /**
     * Campo de texto para la hora.
     */
    private JTextField textHoraActual;
    
    /**
     * Botón de avanzar hora.
     */
    private JButton btnAvanzarHora;
    
    /**
     * Etiqueta para el valor de la tarifa.
     */
    private JLabel lbTarifa;
    
    /**
     * Campo de texto para la tarifa actual.
     */
    private JTextField textTarifa;
    
    /**
     * Botón de cambiar tarifa.
     */
    private JButton btnCambiarTarifa;

    /**
     * Botón de ingresar carro al parqueadero.
     */
    private JButton btnIngresar;
    
    /**
     * Botón para ir a la ventana de información del parqueadero.
     */
    private JButton btnSalir;
    
    /**
     * Botón para sacar carro del parqueadero.
     */
    private JButton btnSacar;
    
    /**
     * Etiqueta de texto para el valor que hay en caja.
     */
    private JLabel lbValorCaja;
   
    /**
     * Etiqueta para saber cuantos puestos libres tiene el parqueadero.
     */
    private JLabel lbPuestosLibres;
    
    /**
     * Etiqueta para saber cuantos puestos ocupados tiene el parqueadero.
     */
    private JLabel lbPuestosOcupados;
    
    //---------------------------------------------------------------------------
    // Atributos
    //---------------------------------------------------------------------------
    
    /**
     * Es una referencia la parqueadero.
     */
    private Parqueadero parqueadero;
    

    //-----------------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------------
    
    /**
     * Crea la interfaz de operaciones para administrar el parqueadero.
     */
    public InterfazOperaciones( )
    {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setBounds( 100, 100, 500, 500);
        contentPane = new JPanel( );
        contentPane.setLayout(null);
        setContentPane( contentPane );
        
        parqueadero = new Parqueadero();
         
        JPanel PanelPrincipal = new JPanel();
        PanelPrincipal.setBounds(0, 0, 484, 106);
        getContentPane().add(PanelPrincipal);
        PanelPrincipal.setLayout(null);
        
        JLabel lbNombre = new JLabel("Parking Control");
        lbNombre.setBounds(0, 29, 183, 48);
        lbNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
        PanelPrincipal.add(lbNombre);
        
        JLabel lbImagen = new JLabel("");
        lbImagen.setBounds(181, 0, 303, 106);
        lbImagen.setIcon(new ImageIcon(InterfazOperaciones.class.getResource("/parqueadero/interfaz/parking.png")));
        lbImagen.setHorizontalAlignment(SwingConstants.CENTER);
        PanelPrincipal.add(lbImagen);
        
        JPanel PanelOperacion = new JPanel();
        PanelOperacion.setBounds(0, 104, 484, 228);
        getContentPane().add(PanelOperacion);
        PanelOperacion.setLayout(null);
        
        JLabel lbTitulo1 = new JLabel("Operaciones");
        lbTitulo1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo1.setBounds(138, 11, 199, 27);
        PanelOperacion.add(lbTitulo1);
        
        lbHoraActual = new JLabel("Hora actual: ");
        lbHoraActual.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbHoraActual.setHorizontalAlignment(SwingConstants.CENTER);
        lbHoraActual.setBounds(42, 63, 103, 27);
        PanelOperacion.add(lbHoraActual);
        
        textHoraActual = new JTextField();
        textHoraActual.setHorizontalAlignment(SwingConstants.CENTER);
        textHoraActual.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textHoraActual.setEditable(false);
        textHoraActual.setBounds(138, 63, 103, 27);
        textHoraActual.setForeground( Color.BLUE );
        PanelOperacion.add(textHoraActual);
        textHoraActual.setColumns(10);
        
        btnAvanzarHora = new JButton("Avanzar Hora");
        btnAvanzarHora.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnAvanzarHora.setBounds(283, 63, 135, 27);
        btnAvanzarHora.setActionCommand(AVANZAR);
        btnAvanzarHora.addActionListener(this);
        PanelOperacion.add(btnAvanzarHora);
        
        lbTarifa = new JLabel("Tarifa: ");
        lbTarifa.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbTarifa.setHorizontalAlignment(SwingConstants.CENTER);
        lbTarifa.setBounds(42, 101, 103, 27);
        PanelOperacion.add(lbTarifa);
        
        textTarifa = new JTextField();
        textTarifa.setHorizontalAlignment(SwingConstants.CENTER);
        textTarifa.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textTarifa.setEditable(false);
        textTarifa.setBounds(139, 101, 102, 27);
        textTarifa.setForeground( Color.BLUE );
        PanelOperacion.add(textTarifa);
        textTarifa.setColumns(10);
        
        btnCambiarTarifa = new JButton("Cambiar Tarifa");
        btnCambiarTarifa.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCambiarTarifa.setBounds(283, 100, 135, 28);
        btnCambiarTarifa.setActionCommand( CAMBIAR );
        btnCambiarTarifa.addActionListener( this );
        PanelOperacion.add(btnCambiarTarifa);
        
        btnIngresar = new JButton("Ingresar Carro");
        btnIngresar.setBounds(67, 158, 124, 50);
        btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnIngresar.setActionCommand( INGRESAR );
        btnIngresar.addActionListener( this );
        PanelOperacion.add(btnIngresar);
        
        btnSacar = new JButton("Sacar Carro");
        btnSacar.setBounds(264, 158, 124, 50);
        btnSacar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSacar.setActionCommand( SALIR );
        btnSacar.addActionListener( this );
        PanelOperacion.add(btnSacar);
        
        JPanel PanelInformacion = new JPanel();
        PanelInformacion.setBounds(0, 331, 484, 130);
        contentPane.add(PanelInformacion);
        PanelInformacion.setLayout(null);
        
        JLabel lbTitulo2 = new JLabel("Informaci\u00F3n");
        lbTitulo2.setBounds(167, 0, 140, 28);
        lbTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo2.setFont(new Font("Tahoma", Font.BOLD, 16));
        PanelInformacion.add(lbTitulo2);
        
        lbValorCaja = new JLabel("Valor en Caja: ");
        lbValorCaja.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbValorCaja.setBounds(21, 39, 130, 22);
        PanelInformacion.add(lbValorCaja);
        
        lbPuestosLibres = new JLabel("Puestos Vac\u00EDos: ");
        lbPuestosLibres.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbPuestosLibres.setBounds(161, 39, 129, 22);
        PanelInformacion.add(lbPuestosLibres);
        
        lbPuestosOcupados = new JLabel("Puestos Ocupados: ");
        lbPuestosOcupados.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbPuestosOcupados.setBounds(319, 40, 140, 20);
        PanelInformacion.add(lbPuestosOcupados);
        
        btnSalir = new JButton("Salir del Sistema");
        btnSalir.setBounds(153, 72, 154, 50);
        PanelInformacion.add(btnSalir);
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSalir.setActionCommand( SALIR_SISTEMA );
        btnSalir.addActionListener( this );
        
        actualizar();
        
    }
    
    //------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------
    
    /**
     * Cambia la hora presentada. <br>
     * <b>post: </b> Se está mostrando la nueva hora.
     * @param pHora - Nueva hora que se debe mostrar.
     */
    public void cambiarHora(int pHora)
    {
        textHoraActual.setText( pHora + ":00" );
    }
    
    
    /**
     * Cambia la tarifa presentada. <br>
     * <b>post: </b> Se está mostrando la nueva tarifa.
     * @param pTarifa - Nueva tarifa que se debe mostrar.
     */
    public void cambiarTarifa( int pTarifa )
    {
        textTarifa.setText( "$ " + pTarifa );   
    }
    
    /**
     * Este método se encarga de actualizar los datos que se presentan en la interfaz.
     */
    public void actualizar( )
    {
        cambiarHora(parqueadero.darHoraActual( ));
        cambiarTarifa(parqueadero.darTarifa( ));
        actualizarDatos( parqueadero.darMontoCaja(), parqueadero.calcularPuestosLibres( ), parqueadero.calcularPuestosOcupados( ) );
    }
    
    /**
     * Actualiza los datos de valor en caja, puestos libres y ocupados.
     * @param pMontoCaja - Monto total que hay en caja.
     * @param pVacios - Total de puestos libres que estan disponibles en el parqueadero.
     * @param pOcupados - Total de puestos ocupados en el parqueadero.
     */
    public void actualizarDatos(int pMontoCaja, int pVacios, int pOcupados)
    {
        lbValorCaja.setText( "Valor en Caja: $ " + pMontoCaja );
        lbPuestosLibres.setText( "Puestos Vacios: " + pVacios );
        lbPuestosOcupados.setText( "Puestos Ocupados: " + pOcupados );
    }
    
    /**
     * Ingresa un carro al parqueadero. Debe preguntar la placa del carro e informar la posición donde debe estacionarse. <br>
     * Si no se puede parquear, porque el parqueadero está cerrado o porque no hay ningún lugar disponible, entonces se debe informar el error.
     */
    public void ingresar()
    {
        String placa = JOptionPane.showInputDialog( this, "Por favor digite la placa del carro que está ingresando", "Ingresar carro", JOptionPane.QUESTION_MESSAGE );
        if(placa != null)
        {
            int puesto = parqueadero.entrarCarro( placa );
            switch(puesto)
            {
                case Parqueadero.NO_HAY_PUESTO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero está lleno." );
                    break;
                case Parqueadero.CARRO_YA_EXISTE:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: ya hay un carro con la misma placa" );
                    break;
                case Parqueadero.PARQUEADERO_CERRADO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero está cerrado." );
                    break;
                default:
                    JOptionPane.showMessageDialog( this, "Bienvenido:\n Su carro quedó parqueado en el puesto: " + (puesto + 1) );
                    break;
            }
            actualizar();
        }
    }
    
    /**
     * Este método sirve para sacar un carro del parqueadero. Debe pedir la placa y luego contactar al parqueadero para sacar el carro y saber <br>
     * cuánto debe cancelar. Si la placa no corresponde a un carro que está en el parqueadero entonces debe mostrar un error.
     */
    public void salir()
    {
        String placa = JOptionPane.showInputDialog( this, "Por favor digite la placa del carro que está saliendo", "Salida carro", JOptionPane.QUESTION_MESSAGE );
        if(placa != null)
        {
            int valor = parqueadero.sacarCarro( placa );
            switch(valor)
            {
                case Parqueadero.PARQUEADERO_CERRADO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero está cerrado", "Error", JOptionPane.ERROR_MESSAGE );
                    break;
                case Parqueadero.CARRO_NO_EXISTE:
                    JOptionPane.showMessageDialog( this, "El carro de placa " + placa + " no está en el parqueadero", "Error", JOptionPane.ERROR_MESSAGE );
                    break;
                default:
                    JOptionPane.showMessageDialog( this, "Placa: " + placa + " debe cancelar $ " + valor);
                    break;
            }
            actualizar();
        }
    }
    /**
     * Sirve para hacer avanzar un hora el reloj del parqueadero.
     */
    public void avanzar()
    {
        parqueadero.avanzarHora( );
        actualizar();
    }
    
    /**
     * Este método permite cambiar la tarifa del parqueadero. Pide una tarifa al usuario, si esta tarifa no es válida informa al usuario.
     */
    public void cambiar()
    {
        String tarifa = JOptionPane.showInputDialog( this, "Por favor digite la nueva tarifa", "Nueva tarifa", JOptionPane.QUESTION_MESSAGE );
        if(tarifa != null)
        {
            try
            {
                int tarifaNumero = Integer.parseInt( tarifa );
                if(tarifaNumero <= 0)
                {
                    JOptionPane.showMessageDialog( this, "Ingrese una tarifa válida", "Tarifa inválida", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    parqueadero.cambiarTarifa( tarifaNumero );
                    cambiarTarifa(tarifaNumero);
                    JOptionPane.showMessageDialog( this, "Se ha cambiado la tarifa", "Nueva tarifa", JOptionPane.INFORMATION_MESSAGE );
                } 
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog( this, "Ingrese una tarifa válida", "Tarifa inválida", JOptionPane.ERROR_MESSAGE );
            }
        }
        
    }
    
    /**
     * Este método ejecuta las acciones asociadas a los botones que se encuentran en la interfaz.
     * @param pEvento - Es el evento del click sobre el botón.
     */
    public void actionPerformed(ActionEvent pEvento)
    {
        String command = pEvento.getActionCommand( );
        if( command.equals( INGRESAR ))
        {
            ingresar();
        }
        else if(command.equals( SALIR ))
        {
            salir();
        }
        else if(command.equals( AVANZAR ))
        {
            avanzar();
        }
        else if(command.equals( CAMBIAR ))
        {
            cambiar();
        }
        else if(command.equals( SALIR_SISTEMA ))
        {
            InterfazPrincipal login = new InterfazPrincipal();
            login.setVisible( true );
            this.dispose( );
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
                    InterfazOperaciones frame = new InterfazOperaciones( );
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
