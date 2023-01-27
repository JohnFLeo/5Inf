
public class KNOTEN
{
    // Attribute
    private String bezeichnung;
    private boolean markiert;
    KnotenAnzeige ka;
    int x;
    int y;
    
    // Konstruktor
    public KNOTEN ( String bezeichnung, int x, int y, GraphenAnzeige ga)
    {
        this.bezeichnung = bezeichnung;
        markiert = false;
        this.x = x;
        this.y = y;
        ka = new KnotenAnzeige(ga.f, this);
        ga.addKa(ka);
    }

    // Methoden
    public String BezeichnungGeben(){
        return bezeichnung;
    }

    public void Markieren(){
        markiert = true;
        updateAnzeige();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void MarkierenLoeschen(){
        markiert = false;
        updateAnzeige();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public boolean MarkierungGeben(){
        return markiert;
    }
    public boolean IstGleich( String bezeichnung )
    {
        return this.bezeichnung.equals( bezeichnung );
    }
    public void updateAnzeige(){
        ka.Anzeigen();
    }
}