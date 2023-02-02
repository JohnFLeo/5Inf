
public class KNOTEN
{
    // Attribute
    private String bezeichnung;
    private boolean markiert;
    private boolean wegmarkiert;
    KnotenAnzeige ka;
    GraphenAnzeige ga;
    int x;
    int y;
    public KNOTEN vorgaenger;
    public int distanz;
    // Konstruktor
    public KNOTEN ( String bezeichnung, int x, int y, GraphenAnzeige ga)
    {
        this.bezeichnung = bezeichnung;
        markiert = false;
        this.x = x;
        this.y = y;
        this.ga = ga;
        ka = new KnotenAnzeige(ga.f, this);
        ga.addKa(ka);
        
    }

    // Methoden
    public String BezeichnungGeben(){
        return bezeichnung;
    }

    public void Markieren(int delay){
        markiert = true;
        updateAnzeige();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void MarkierenLoeschen(int delay){
        markiert = false;
        wegmarkiert = false;
        updateAnzeige();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public boolean MarkierungGeben(){
        return markiert;
    }
    public boolean WegMarkierungGeben(){
        return wegmarkiert;
    }
    public void ZurueckSetzen()
    {
        MarkierenLoeschen(0);
        EntfernungMaximieren();
        VorgaengerLoeschen();
    }
    
    private void VorgaengerLoeschen()
    {
        vorgaenger = null;
    }
    
    private void EntfernungMaximieren()
    {
        distanz = Integer.MAX_VALUE;
    }
    public boolean IstGleich( String bezeichnung )
    {
        return this.bezeichnung.equals( bezeichnung );
    }
    public void WegAnzeigen(String startknoten,int delay){
        wegmarkiert = true;
        ka.Anzeigen();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if(bezeichnung.equals(startknoten)){
            return;
        }
        vorgaenger.WegAnzeigen(startknoten, delay);
    }
    public void updateAnzeige(){
        ka.Anzeigen();
    }
}