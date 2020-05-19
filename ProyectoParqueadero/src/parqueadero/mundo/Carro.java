/********************************************************************************
 * Proyecto Parqueadero.
 * 
 * @author Jessica I. Cespedes Sica
 * Fecha: Marzo 2020
 ********************************************************************************
 */
package parqueadero.mundo;

/**
 * Esta clase representa un carro dentro del parqueadero.
 */
public class Carro
{
    //-------------------------------------------------------------------
    // Atributos
    //-------------------------------------------------------------------
    
    /**
     * Placa del carro.
     */
    private String placa;
    
    /**
     * Hora de llegada del carro al parqueadero: valor entre 6 y 22.
     */
    private int horaLlegada;
    
    //-------------------------------------------------------------------
    // Constructores
    //-------------------------------------------------------------------
    
    /**
     * Crea un carro con la información básica.
     * @param pPlaca - Placa del carro. pPlaca != null.
     * @param pHoraLlegada - Hora de ingreso.
     */
    public Carro(String pPlaca, int pHoraLlegada)
    {
        placa = pPlaca;
        horaLlegada = pHoraLlegada;
    }
    
    //-------------------------------------------------------------------
    // Métodos
    //-------------------------------------------------------------------
    
    /**
     * Retorna la placa del carro.
     * @return la placa del carro.
     */
    public String darPlaca()
    {
        return placa;
    }
    
    /**
     * Retorna la hora de llegada del carro.
     * @return la hora en la que llegó el carro al parqueadero.
     */
    public int darHoraLlegada() // REVISAR
    {
        // Para realizarlo con tiempo real
        //String strHora = horaLlegada.toString( );
        //return strHora;
        
        return horaLlegada;
    }
    
    /**
     * Indica si la placa del carro es igual a la recibida por parámetro.
     * @param pPlaca - Placa contra la que se está comparando. pPlaca != null.
     * @return Retorna true si las placas son iguales, false en caso contrario.
     */
    public boolean tienePlaca(String pPlaca)
    {
        boolean tienePlaca = false;
        
        if(placa.equalsIgnoreCase( pPlaca ))
        {
            tienePlaca = true;
        }
        else
        {
            tienePlaca = false;
        }
        return tienePlaca;
    }
    
    // Para realizarlo con tiempo real
    /*public String darHoraSalida()
    {
        
    }*/
    
    /**
     * Calcula el número de horas que debe pagar el carro según el tiempo que lleva el auto en el parqueadero.
     * @param pHoraSalida - Hora a la que el carro sale del parqueadero. pHoraSalida >= horaLlegada.
     * @return Tiempo que ha estado en el parqueadero.
     */
    public int darTiempoEnParqueadero(int pHoraSalida) // REVISAR
    {
        int tiempoParqueadero = pHoraSalida - horaLlegada + 1;
        return tiempoParqueadero;
        
        // Para tiempo real se tiene que modificar
    }
}
