
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
}
