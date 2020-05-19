/********************************************************************************
 * Proyecto Parqueadero.
 * 
 * @author Jessica I. Cespedes Sica
 * Fecha: Marzo 2020
 ********************************************************************************
 */
package parqueadero.mundo;

/**
 * esta clase representa un parqueadero con TAMANO puestos.
 */
public class Parqueadero
{
    //------------------------------------------------------------------
    // Constantes
    //------------------------------------------------------------------
    
    /**
     * Indica el número de puestos en el parqueadero.
     */
    public final static int TAMANO = 10;
    
    /**
     * Es el código de error para cuando el parqueadero está lleno.
     */
    public final static int NO_HAY_PUESTO = -1;
    
    /**
     * Es el código de error para cuando el parqueadero está cerrado.
     */
    public final static int PARQUEADERO_CERRADO = -2;
    
    /**
     * Es el código de error para cuando el carro que se busca no está dentro del parqueadero.
     */
    public final static int CARRO_NO_EXISTE = -3;
    
    /**
     * Es el código de error para cuando ya hay un carro en el parqueadero con la placa de un nuevo carro que va a entrar.
     */
    public final static int CARRO_YA_EXISTE = -4;
    
    /**
     * Es la hora a la que se abre el parqueadero.
     */
    public final static int HORA_INICIAL = 6; // REVISAR para tiempo real
    
    //public final static int MINUTOS_INICIAL = 00; 
    
    /**
     * Es la hora a la que se cierra el parqueadero.
     */
    public final static int HORA_CIERRE = 22; // REVISAR para tiempo real
    
    /**
     * Es la tarifa inicial del parqueadero. En pesos mexicanos.
     */
    public final static int TARIFA_INICIAL = 20;
    
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    
    /**
     * Contenedora de tamaño fijo de puestos.
     */
    private Puesto puestos[];
    
    /**
     * Tarifa por hora en el parqueadero.
     */
    private int tarifa;
    
    /**
     * Valor recibido en la caja del parqueadero.
     */
    private int caja;
    
    /**
     * Hora actual en el parqueadero.
     */
    private int horaActual; // REVISAR para tiempo real
    
    /**
     * Indica si el parqueadero está abierto.
     */
    private boolean abierto;
    
    //------------------------------------------------------------------
    // Construtores
    //------------------------------------------------------------------
    
    /**
     * Crea un parqueadero con su información básica. <br>
     * <b>post: </b> Se creó un parqueadero abierto con la tarifa establecida y el arreglo de puestos está creando.
     */
    public Parqueadero()
    {
        horaActual = HORA_INICIAL; //REVISAR para tiempo real
        abierto = true;
        tarifa = TARIFA_INICIAL;
        caja = 0;
        
        // Crea el arreglo de puestos e inicializa cada uno de ellos
        puestos = new Puesto[TAMANO];
        for(int i = 0; i < TAMANO; i++)
        {
            puestos[i] = new Puesto(i);
        }
    }
    
    //-------------------------------------------------------------------
    // Métodos
    //-------------------------------------------------------------------
    
    /**
     * Retorna un mensaje con la placa del carro que se encuentra en la posición indica.
     * @param pPosicion - Posición del carro.
     * @return Mensaje con la placa. Si no hay un carro en dicha posición retorna un mensaje indicando que no hay un carro en esa posición.
     */
    public String darPlacaCarro(int pPosicion)
    {
        String respuesta = "";
        if(estaOcupado(pPosicion))
        {
            respuesta = "Placa: " + puestos[pPosicion].darCarro( ).darPlaca( );
        }
        else
        {
            respuesta = "No hay un carro en esta posición";
        }
        return respuesta;
    }
    
    /**
     * Indica si un puesto está ocupado.
     * @param pPuesto - El puesto que se quiere saber si está ocupado. pPuesto >= 0 && pPuesto < puestos.length.
     * @return Retorna true si el puesto está ocupado. False en caso contrario.
     */
    public boolean estaOcupado(int pPuesto)
    {
        boolean ocupado = puestos[pPuesto].estaOcupado( );
        return ocupado;
    }
    
    /**
     * Ingresa un carro al parqueadero.
     * <b>pre: </b> El arreglo de puestos no está vacío. <br>
     * <b>post: </b> El carro quedó parqueado en el puesto indicado.
     * @param pPlaca - Placa del carro que ingresa. pPlaca != null.
     * @return Puesto en el que debe parquear. <br>
     *         Si el parqueadero está lleno retorna el valor NO_HAY_PUESTO. <br>
     *         Si el parqueadero está cerrado retorna el valor PARQUEADERO_CERRADO.
     */
    public int entrarCarro(String pPlaca)
    {
        int resultado = 0;
        if(!abierto)
        {
            resultado = PARQUEADERO_CERRADO;
        }
        else
        {
            // Busca en el parqueadero un carro con la placa indicada
            int numPuestoCarro = buscarPuestoCarro(pPlaca.toUpperCase( ));
            if(numPuestoCarro != CARRO_NO_EXISTE)
            {
                resultado = CARRO_YA_EXISTE;
            }
            
            // Buscar un puesto libre para el carro y agregarlo
            resultado = buscarPuestoLibre();
            if(resultado != NO_HAY_PUESTO)
            {
                Carro carroEntrando = new Carro(pPlaca, horaActual); // REVISAR
                puestos[resultado].parquearCarro( carroEntrando );
            }
        }
        return resultado;
    }
    
    /**
     * Sirve para sacar un carro del parqueadero y saber la cantidad de dinero que debe pagar. <br>
     * <b>pre: </b> El arreglo de puestos no está vacío. <br>
     * <b>post: </b> El carro salió del parqueadero y el puesto que ocupaba, ahora está libre.
     * @param pPlaca - Placa del carro que va a salir. pPlaca != null.
     * @return Retorna el valor a pagar. Si el carro no se encontraba dentro del parqueadero entonces retorna CARRO_NO_EXISTE. <br>
     *         Si el parqueadero ya estaba cerrado retorna PARQUEADERO_CERRADO.
     */
    public int sacarCarro(String pPlaca)
    {
        int resultado = 0;
        if(!abierto)
        {
            resultado = PARQUEADERO_CERRADO;
        }
        else
        {
            int numPuesto = buscarPuestoCarro(pPlaca.toUpperCase( ));
            if(numPuesto == CARRO_NO_EXISTE)
            {
                resultado = CARRO_NO_EXISTE;
            }
            else
            {
                Carro carro = puestos[numPuesto].darCarro( );
                int nHoras = carro.darTiempoEnParqueadero( horaActual ); // REVISAR
                int porPagar = nHoras * tarifa;
                caja = caja + porPagar;
                puestos[numPuesto].sacarCarro( );
                resultado = porPagar;
            }
        }
        return resultado;
    }
    
    /**
     * Indica la cantidad de dinero que hay en caja.
     * @return Los ingresos totales en la caja.
     */
    public int darMontoCaja()
    {
        return caja;
    }
    
    /**
     * Indica la cantidad de puestos libres que hay.
     * @return El número de espacios vacíos en el parqueadero.
     */
    public int calcularPuestosLibres()
    {
        int puestosLibres = 0;
        for(Puesto puesto : puestos)
        {
            if(!puesto.estaOcupado( ))
            {
                puestosLibres = puestosLibres + 1;
            }
        }
        return puestosLibres;
    }
    
    /**
     * Indica la cantidad de puestos ocupados que hay.
     * @return El número de espacios ocupados en el parqueadero.
     */
    public int calcularPuestosOcupados()
    {
        int puestosOcupados = 0;
        for(Puesto puesto : puestos)
        {
            if(puesto.estaOcupado( ))
            {
                puestosOcupados = puestosOcupados + 1;
            }
        }
        return puestosOcupados;
    }
    
    /**
     * Cambia la tarifa actual del parqueadero.
     * @param pTarifa - Tarifa nueva del parqueadero.
     */
    public void cambiarTarifa(int pTarifa)
    {
        tarifa = pTarifa;
    }
    
    /**
     * Busca un puesto libre en el parqueadero y lo retorna. Si no encuentra retorna el valor NO_HAY_PUESTO.
     * @return Número del puesto libre encontrado.
     */
    private int buscarPuestoLibre()
    {
        int puesto = NO_HAY_PUESTO;
        for(int i = 0; i < TAMANO && puesto == NO_HAY_PUESTO; i++)
        {
            if(!puestos[i].estaOcupado( ))
            {
                puesto = i;
            }
        }
        return puesto;
    }
    
    /**
     * Indica el número de puesto en el que se encuentra el carro con una placa dada. Si no lo encuentra retorna el valor CARRO_NO_EXISTE.
     * @param pPlaca - Placa del carro que se busca. pPlaca != null.
     * @return Número del puesto en el que se encuentra el carro.
     */
    private int buscarPuestoCarro(String pPlaca)
    {
        int puesto = CARRO_NO_EXISTE;
        for(int i = 0; i < TAMANO && puesto == CARRO_NO_EXISTE; i++)
        {
            if(puestos[i].tieneCarroConPlaca( pPlaca ))
            {
                puesto = i;
            }
        }
        return puesto;
    }
    
    /**
     * Avanza una hora en el parqueadero. Si la hora actual es igual a la hora de cierre, 
     * el parqueadero se cierra.
     */
    public void avanzarHora() // REVISAR para tiempo real
    {
        if(horaActual <= HORA_CIERRE)
        {
            horaActual = (horaActual + 1);
        }
        if(horaActual == HORA_CIERRE)
        {
            abierto = false;
        }
    }
    
    /**
     * Retorna la hora actual.
     * @return La hora actual en el parqueadero.
     */
    public int darHoraActual() // REVISAR para tiempo real
    {
        return horaActual;
        /*GregorianCalendar gc = new GregorianCalendar();
        
        int hora = gc.get( Calendar.HOUR_OF_DAY );
        int minutos = gc.get( Calendar.MINUTE );
        
        Hora actual = new Hora(hora, minutos);
        return actual;*/
    }
    
    /**
     * Indica si el parqueadero está abierto.
     * @return Retorna true si el parqueadero está abierto. False en caso contrario.
     */
    public boolean estaAbierto()
    {
        return abierto;
    }
    
    /**
     * Retorna la tarifa por hora del parqueadero.
     * @return La tarifa que se está aplicando en el parqueadero.
     */
    public int darTarifa()
    {
        return tarifa;
    }
}
