public class INTQUEUE
{
    
    private int[] werte;
    private int anfang;
    private int ende;
    
    public INTQUEUE ( int max_anz )
    {
        werte = new int[ max_anz ];
        anfang = 0;
        ende = 0;
    }
    
    public void Enqueue( int wert )
    {
        int naechster = (ende + 1) % werte.length;
        if ( naechster != anfang )
        {
            werte[ ende + 1 ] = wert;
            ende = naechster;
        }
    }
    
    public int Dequeue()
    {
        if ( Peek() )
        {
            int erg = werte[ anfang ];
            anfang = (anfang + 1) % werte.length;
            return erg;
        }
        return -404;
    }
    
    public boolean Peek()
    {   
        return ende != anfang;
    }
    
}
