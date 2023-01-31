
import java.awt.*;
public abstract class Anzeige
{
    // Attribute
    protected Fenster f;
    protected Graphics imageG;
    // Konstruktor
    public Anzeige (Fenster fenster)
    {
        f = fenster; 
        imageG = f.getGraphicsBuffer();
    }

    // Methoden
    public void Anzeigen(){
        imageG.setColor(Color.BLACK);
        imageG.fillRect(100,100,50,50);
        f.repaint();
    }
}