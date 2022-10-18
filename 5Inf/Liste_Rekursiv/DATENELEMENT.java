
public interface DATENELEMENT
{
    // Methoden
    public void Ausgeben();
    public void NaechsterSetzen(DATENELEMENT d);
    public boolean IstGleich(DATENELEMENT d);
    public void Hinzufuegen(DATENELEMENT d);
    public int Suchen(DATENELEMENT d);
    public DATENELEMENT Entfernen(int nr);
    public int AnzahlGeben();
   
}