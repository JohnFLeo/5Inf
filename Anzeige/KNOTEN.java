
public class KNOTEN
{
    // Attribute
    private String bezeichnung;
    private boolean markiert;
    int x;
    int y;
    
    // Konstruktor
    public KNOTEN ( String bezeichnung, int x, int y)
    {
        this.bezeichnung = bezeichnung;
        markiert = false;
        this.x = x;
        this.y = y;
    }

    // Methoden
    public String BezeichnungGeben(){
        return bezeichnung;
    }

    public void Markieren(){
        markiert = true;
    }

    public void MarkierenLoeschen(){
        markiert = false;
    }
    public boolean MarkierungGeben(){
        return markiert;
    }
    public boolean IstGleich( String bezeichnung )
    {
        return this.bezeichnung.equals( bezeichnung );
    }
}