
import java.awt.*;
public class KnotenAnzeige extends Anzeige
{
    // Attribute
    int x;
    int y;
    int abstand = 1;
    int rand = 100;
    int breite = 50;
    int scale = 15;
    KNOTEN knoten;
    // Konstruktor
    public KnotenAnzeige (Fenster fenster, KNOTEN k)
    {
        super(fenster);
        knoten = k;
        updatePos();
    }
    // Methoden
    public void updatePos(){
        this.x = (int)((knoten.x* (f.getsizeEcht().width-2*rand))/24) + rand;
        this.y = (int)((knoten.y* (f.getsizeEcht().height-2*rand))/24) + rand;
    }
    @Override 
    public void Anzeigen(){
        updatePos();
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
    
    public void WegAnzeigen(){
        updatePos();
        imageG.setColor(Color.BLACK);
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