
import java.awt.*;
public class KnotenAnzeige extends Anzeige
{
    // Attribute
    int x;
    int y;
    KnotenAnzeige[] knotenA;
    // Konstruktor
    public KnotenAnzeige (Fenster fenster, int x, int y)
    {
        super(fenster);
        this.x = x;
        this.y = y;
    }
    // Methoden
    @Override 
    public void Anzeigen(){
        imageG.setColor(Color.BLUE);
        imageG.fillRect(x*60+50,y*60+50,50,50);
        f.repaint();
    }
    //Getter
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    //Setter
    
}