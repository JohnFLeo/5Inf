
import java.awt.*;
public class KnotenAnzeige extends Anzeige
{
    // Attribute
    int x;
    int y;
    int abstand = 60;
    int rand = 100;
    int breite = 50;
    int scale = 15;
    KNOTEN knoten;
    // Konstruktor
    public KnotenAnzeige (Fenster fenster, int x, int y, KNOTEN k)
    {
        super(fenster);
        this.x = (int)((scale*x)/24)* abstand + rand;
        this.y = (int)((scale*y)/24)* abstand + rand;
        knoten = k;
    }
    // Methoden
    @Override 
    public void Anzeigen(){
        if(knoten.MarkierungGeben()){
            imageG.setColor(Color.RED);
        }else{
            imageG.setColor(Color.BLUE);
        }
        imageG.fillOval((int)(x-0.5*breite),(int)(y-0.5*breite),breite,breite);
        
        imageG.setColor(Color.WHITE);
        imageG.setFont(new Font("MyFont",Font.BOLD, 14));
        imageG.drawString(knoten.BezeichnungGeben(),x-5, y);
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