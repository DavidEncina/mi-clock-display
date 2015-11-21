
/**
 * Se crea un reloj que marca la hora y los minutos. Tambien se vera la fecha en dia, mes y año. 
 * @author David Encina Maestro
 * @version 1.0
 */
import java.util.Calendar;

public class ClockDisplay
{
    //La hora del reloj.
    private NumberDisplay horas;
    //Los minutos del reloj.
    private NumberDisplay minutos;
    //Los años del reloj.
    private NumberDisplay ano;
    //Los meses del reloj.
    private NumberDisplay mes;
    //Los dias del reloj.
    private NumberDisplay dia;
    //La hora y los minutos actuales en 5 caracteres.   
    private String horaActual;
    //Permite elegir entre formato 24 h. (true) o 12 h. (false).
    private boolean tipoReloj;
    
    /**
     * Crea un reloj cuya hora de inicio es La hora actual del sistema.
     * Permite elegir el formato de hora entre 24 h y 12 h.
     * Al crearse mostrara la fecha actual del sistema.
     */
    public ClockDisplay(boolean formato)
    {
        //Inicializa el reloj en la fecha actual y se elige el formato.
        Calendar today = Calendar.getInstance();        
        horas = new NumberDisplay(23);
        horas.setValue(today.get(Calendar.HOUR_OF_DAY));
        minutos = new NumberDisplay(59);
        minutos.setValue(today.get(Calendar.MINUTE));
        ano = new NumberDisplay(9999);
        ano.setValue(today.get(Calendar.YEAR));
        mes = new NumberDisplay(12);
        mes.setValue(today.get(Calendar.MONTH) + 1);
        dia = new NumberDisplay(30);
        dia.setValue(today.get(Calendar.DAY_OF_MONTH));
        tipoReloj = formato;
        updateHoraActual();        
    }   

    /**
     * Crea un reloj cuya hora de inicio y fecha se fija al crearlo.
     * Permite elegir el formato de hora entre 24 h y 12 h.
     */
    public ClockDisplay(int h, int m, int a, int me, int d, boolean formato)
    {
        //Inicializa el reloj a una hora fijada en horas y miutos.
        horas = new NumberDisplay(23);
        horas.setValue(h);
        minutos = new NumberDisplay(59);
        minutos.setValue(m);
        ano = new NumberDisplay(99);
        ano.setValue(a);
        mes = new NumberDisplay(12);
        mes.setValue(me);
        dia = new NumberDisplay(30);
        dia.setValue(d);
        tipoReloj = formato;
        updateHoraActual();        
    }
    
    /**
     * Permite alternar entre los dos formatos de reloj.
     */    
    public void cambiarFormato()
    {
          tipoReloj = !tipoReloj;
          updateHoraActual();
    }
    
    /**
     * Se introducen horas, minutos, año, mes y dia para cambiar la hora y fecha del reloj.     
     */
    public void setTime(int h, int m, int a, int me, int d)
    {
        horas.setValue(h);
        minutos.setValue(m);               
        ano.setValue(a);        
        mes.setValue(me);
        dia.setValue(d); 
        updateHoraActual();
    }
    
     /**
     * Metodo para devolver la hora y los minutos en formato de 5 caracteres separados por dos puntos.     
     */
    public String getTime()
    {        
       return horaActual;   
    }
    
    /**
     * Permite avanzar el tiempo 1 minuto.
     * Cuando se pase de 59 minutos los minutos volveran a 0 y las horas sumaran 1.
     * Cuando las horas lleguen a 24 volveran automaticamente a 0 y los dias sumaran 1.
     * Cuando los dias lleguen a 31 volveran automaticamente a 0 y los meses sumaran 1.
     * Cuando los meses lleguen a 13 volveran automaticamente a 0 y los años sumaran 1.
     * Cuando los años lleguen a 99 o a 9999 (depende del formato del reloj) volveran automaticamente a 0.
     */
    public void timeTick()
    {
        minutos.increment();
        if (minutos.getValue() == 01) {
            horas.increment();
            if (horas.getValue() == 01) {
                dia.increment();                
                if (dia.getValue() == 01) {
                    mes.increment();
                    dia.setValue(1);                    
                    if (mes.getValue() == 01) {
                        ano.increment();
                        mes.setValue(1);
                    }
                }
            }
        }           
        updateHoraActual();
    }
    
    /**
     * Actualiza el atributo horaActual siguiendo las normas de un reloj de 12 horas.
     */
    public void updateHoraActual()
    {
        if (tipoReloj) {           
            String periodo = " am";
            String hora = horas.getDisplayValue();
            if (horas.getValue() == 12) {
                periodo = " pm";
            }        
            else if (horas.getValue() > 12) {
                periodo = " pm";
                hora = horas.getValue() - 12 + "";
            }        
            else if (horas.getValue() == 00) {
                hora = 12 + "";
            }
            horaActual = "Año: " + ano.getDisplayValue() + " Mes: " + mes.getDisplayValue() + " Dia: " + dia.getDisplayValue() + " Hora: " + hora + ":" + minutos.getDisplayValue() + periodo;
        }           
        else {
            horaActual = " Año: " + ano.getDisplayValue() + " Mes: " + mes.getDisplayValue() + " Dia: " + dia.getDisplayValue() + " Hora: " + horas.getDisplayValue() + ":" + minutos.getDisplayValue();         
        }
    }
}