/********************************************************************************
 * Proyecto Parqueadero.
 * 
 * @author Jessica I. Cespedes Sica
 * Fecha: Marzo 2020
 ********************************************************************************
 */

package conectorBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GestionUsuario
{

    //-----------------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------------
    
    /**
     * Este método obtiene un usuario que este registrado en la base de datos "parqueadero".
     * Y busca dicho usuario en la tabla "usuarios".
     * @param pUsuario - Usuario que se va a verificar si existe en la BD.
     * @return si existe retorna el usuario que encontro. Sino se muestra un error.
     */
    public Usuario obtenerUsuario(Usuario pUsuario)
    {
        Usuario usuario = null;
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            con = MySQLConexion.getConexion();
            
            String sql = "select * from usuarios where usuario = ? and clave = ? ";
            
            pst = con.prepareStatement( sql );
            pst.setString( 1, pUsuario.darUsuario() );
            pst.setString( 2, pUsuario.darClave( ) );
            
            rs = pst.executeQuery( );
            
            while(rs.next( ))
            {
                usuario = new Usuario(rs.getString( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getString( 4 ));
            }
        }
        catch( Exception e )
        {
            System.out.println( "Error en obtener usuario." );
        }
        
        return usuario;
    }
}
