public class KNOTEN
{
    // Attribute
    private String bezeichnung;
    private boolean markiert;
    
    // Konstruktor
    public KNOTEN ( String bezeichnung )
    {
        this.bezeichnung = bezeichnung;
        markiert = false;
    }

    // Methoden
    public String BezeichnungGeben()
    {
        return bezeichnung;
    }
    
    public void Markieren()
    {
        markiert = true;
    }
    
    public void MarkierungLoeschen()
    {
        markiert = false;
    }
    
    public boolean MarkierungGeben()
    {
        return markiert;
    }
    
    public boolean IstGleich( String bezeichnung )
    {
        return this.bezeichnung.equals( bezeichnung );
    }
    
}