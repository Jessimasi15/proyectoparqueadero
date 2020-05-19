/********************************************************************************
 * Proyecto Parqueadero.
 * 
 * @author Jessica I. Cespedes Sica
 * Fecha: Marzo 2020
 ********************************************************************************
 */

package conectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion
{
    //-----------------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------------
    
    /**
     * Este m�todo es el que realiza la conexi�n del sistema con la BD de MySQL.
     * @return si la conexi�n es un exito retorna la conexion. Sino retorna el error correspondiente,
     * que puede ser: "Error al cargar el Driver" o "Error con la BD".
     */
    public static Connection getConexion()
    {
        Connection con = null;
        
        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
            String url = "jdbc:mysql://localhost/parqueadero";
            String usuario = "root";
            String contrase�a = "";
            
            con = DriverManager.getConnection( url, usuario, contrase�a );
        }
        catch( ClassNotFoundException e )
        {
            System.out.println( "Error ---> al cargar el Driver." );
            e.printStackTrace();
        }
        catch( SQLException e )
        {
            System.out.println( "Error ---> con la BD." );
            e.printStackTrace();
        }
        
        return con;
    }
}
