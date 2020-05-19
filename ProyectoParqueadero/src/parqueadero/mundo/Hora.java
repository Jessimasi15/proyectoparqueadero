/********************************************************************************
 * Proyecto Parqueadero.
 * 
 * @author Jessica I. Cespedes Sica
 * Fecha: Marzo 2020
 ********************************************************************************
 */
package parqueadero.mundo;

// Clase para realizarlo en tiempo real
public class Hora
{
    //-------------------------------------------------------------------
    // Atributos
    //-------------------------------------------------------------------
    
    private int hora;
    
    private int minutos;
    
    //------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------
    
    public Hora( int pHora, int pMinutos)
    {
        hora = pHora;
        minutos = pMinutos;
    }
    
    public int darHora()
    {
        return hora;
    }
    
    public int darMinutos()
    {
        return minutos;
    }
    
    public int darDiferenciaDeMinutos(Hora pHora)
    {
        int diferencia = 0;
        
        int otraHora = pHora.darHora( );
        int otroMinuto = pHora.darMinutos( );
        
        // Calcula la diferencia en minutos
        diferencia = 60 * (otraHora - hora) + (otroMinuto - minutos);
        
        // Si los minutos no es mayor, se resta un minuto
        if(otroMinuto < minutos)
        {
            diferencia--;
        }
        
        return diferencia;
    }
    
    public String toString()
    {
        return hora + ":" + minutos;
    }
}
