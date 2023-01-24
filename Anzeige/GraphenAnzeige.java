
import java.awt.*;
public class GraphenAnzeige extends Anzeige
{
    // Attribute
    KnotenAnzeige[] knotenA;
    
    // Konstruktor
    public GraphenAnzeige(KNOTEN[] knoten, int[][] matrix)
    {
        super(new Fenster());   
        knotenA = new KnotenAnzeige[knoten.length];
        for(int i = 0; i < knoten.length; i = i + 1){
            knotenA[i] = new KnotenAnzeige(super.f, i , i);
            knotenA[i].Anzeigen();
        }
    }
    // Methoden
    @Override
    public void Anzeigen(){
        imageG.setColor(Color.BLUE);
        imageG.fillRect(200,100,100,50);
        f.repaint();
    }
}