/********************************************************************************
 * Proyecto Parqueadero.
 * 
 * @author Jessica I. Cespedes Sica
 * Fecha: Marzo 2020
 ********************************************************************************
 */

package conectorBD;

public class Usuario
{
    //--------------------------------------------------------------------
    // Atributos
    //--------------------------------------------------------------------
    
    /**
     * Usuario para entrar al sistema.
     */
    private String usuario;
    
    /**
     * Clave del usuario para entrar al sistema.
     */
    private String clave;
    
    /**
     * Son los nombres a los que pertenece el usuario.
     */
    private String nombres;
    
    /**
     * Son los apellidos que tiene el usuario.
     */
    private String apellidos;
    
    //---------------------------------------------------------------------
    // Constructores
    //---------------------------------------------------------------------
    
    /**
     * Construye el usuario que entrara al sistema.
     * @param pUsuario - Nombre de usuario para el ingreso. pUsuario != null.
     * @param pClave - Clave con el que se le da ingreso al sistema. pClave != null.
     * @param pNombres - Nombres de la persona que creo el usuario. pNombres != null.
     * @param pApellidos - Apellidos de la persona que creo el usuario. pApellidos != null.
     */
    public Usuario(String pUsuario, String pClave, String pNombres, String pApellidos)
    {
        usuario = pUsuario;
        clave = pClave;
        nombres = pNombres;
        apellidos = pApellidos;
    }

    /**
     * Constructor de Usuario vacio.
     */
    public Usuario( )
    {
        // Constructor vacio
    }

    //-----------------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------------
    
    /**
     * Retorna el usuario.
     * @return Usuario.
     */
    public String darUsuario( )
    {
        return usuario;
    }

    /**
     * Guarda el usuario que se ingreso.
     * @param pUsuario - Usuario que se ingreso. 
     */
    public void guardarUsuario( String pUsuario )
    {
        usuario = pUsuario;
    }

    /**
     * Retorna la clave del usuario.
     * @return Clave del usuario.
     */
    public String darClave( )
    {
        return clave;
    }

    /**
     * Guarda la clave del usuario que ingreso.
     * @param pClave - Clave del usuario que ingreso.
     */
    public void guardarClave( String pClave )
    {
        clave = pClave;
    }

    /**
     * Retorna los nombres del usuario.
     * @return nombres del usuario.
     */
    public String darNombres( )
    {
        return nombres;
    }

    /**
     * Guarda los nombres del usuario que ingreso.
     * @param pNombres - Nombres del usuario que ingreso.
     */
    public void setNombres( String pNombres )
    {
        nombres = pNombres;
    }

    /**
     * Retorna los apellidos del usuario.
     * @return apellidos del usuario.
     */
    public String darApellidos( )
    {
        return apellidos;
    }

    /**
     * Guarda los apellidos del usuario que ingreso.
     * @param pApellidos - Apellidos del usuario que ingreso.
     */
    public void darApellidos( String pApellidos )
    {
        apellidos = pApellidos;
    }
    
    
}
