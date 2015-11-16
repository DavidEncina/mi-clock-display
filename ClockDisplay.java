
/**
 * * Se crea un reloj que marca la hora y los segundos.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
}
