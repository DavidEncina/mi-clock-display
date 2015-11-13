
/**
 * Se crea un display de 1 nº al que se le asignara un limite superior. * 
 * @author David Encina Maestro 
 * @version 1.0
 */
public class NumberDisplay
{
    //Es el nº que aparece en el display.
    private int num;
    //Es el limite superior al que puede llegar el display.
    private int limite;
 
    /**
     * Crea un display de un nº.
     * Al nº se le asigna un límite superior.
     * 
     */
    public NumberDisplay(int limSup)
    { 
        limite = limSup;
        num = 0;        
    }
    
    /**
     * Fija el valor actual del display al valor pasado como parámetro.  
     */
    public void setValue(int val)
    {
        if (val <= limite && val >= 0) {
            num = val;
        }
        else {
            System.out.println ("val debe estar entre 0 y " + limite);
        }
    }
    
    /**
     *Devuelve el valor actual del display en forma de cadena de 2 caracteres.
     */
    public String getDisplayValue()
    {
        String numero = num + "";
        if (num < 10) {            
            numero = "0" + numero;
        }
        return numero;
    }
    
    /**
     * Devuelve el valor actual del display como entero
     */
    public int getValue()
    {
        return num;
    }
    
    /**
     * Incrementa en 1 al display y lo hace volver al principio si alcanza el límite.
     */
    public void increment()
    {
        num++;
        if (num == limite) {
            num = 0;
        }
    }
}
