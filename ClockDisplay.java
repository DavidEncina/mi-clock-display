
/**
 * * Se crea un reloj que marca la hora y los segundos.
 * 
 * @author David Encina Maestro
 * @version 1.0
 */
public class ClockDisplay
{
    //La hora del reloj.
    private NumberDisplay horas;
    //Los minutos del reloj.
    private NumberDisplay minutos;
    //La hora y los minutos actuales en 5 caracteres.
    private String horaActual;    
    
    /**
     * Crea un reloj cuya hora de inicio es 00:00.
     */
    public ClockDisplay()
    {
        //Inicializa el reloj a 00:00.
        horas = new NumberDisplay(24);        
        minutos = new NumberDisplay(60);
        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();        
    }

    /**
     * Crea un reloj cuya hora de inicio se fija al crearlo.
     */
    public ClockDisplay(int h, int m)
    {
        //Inicializa el reloj a una hora fijada en horas y miutos.
        horas = new NumberDisplay(24);
        horas.setValue(h);
        minutos = new NumberDisplay(60);
        minutos.setValue(m);        
        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue(); 
    }
    
    /**
     * Se introducen horas y segundos para cambiar la hora del reloj.     
     */
    public void setTime(int h, int m)
    {
        horas.setValue(h);
        minutos.setValue(m);
        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
     /**
     * Metodo para devolver la hora y los minutos en formato de 5 caracteres separados por dos puntos.     
     */
    public String getTime()
    {
        String periodo = " am";
        String hora = horas.getDisplayValue();
        if (horas.getValue() > 12) {
            periodo = " pm";
            hora = horas.getValue() - 12 + "";
        }
        
        if (horas.getValue() == 00) {
            hora = 12 + "";
        }
        horaActual = hora + ":" + minutos.getDisplayValue() + periodo;
        return horaActual;   
    }
    
    /**
     * Permite avanzar el tiempo 1 minuto.
     * Cuando se pase de 59 minutos los minutos volveran a 0 y las horas sumaran 1.
     * Cuando las horas lleguen a 24 volveran automaticamente a 0.
     */
    public void timeTick()
    {
        minutos.increment();
        if (minutos.getValue() == 0) {
            horas.increment();
        }
        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
}
   
