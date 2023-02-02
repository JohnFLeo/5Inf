
import java.awt.*;
import java.awt.geom.Line2D;
public class GraphenAnzeige extends Anzeige
{
    // Attribute
    KnotenAnzeige[] knotenA;
    int anzahl;
    int [][] kanten;
    
    // Konstruktor
    public GraphenAnzeige(int maxanz)
    {
        super(new Fenster());
        anzahl = 0;
        knotenA = new KnotenAnzeige[maxanz];
        
        
    }
    // Methoden
    public void addKa(KnotenAnzeige ka){
        knotenA[anzahl] = ka;
        anzahl = anzahl + 1;
    }
    public void updateKanten(int [][] matrix){
        kanten = matrix;
    }
    @Override
    public void Anzeigen(){
        imageG.setColor(Color.WHITE);
        imageG.fillRect(0,0,f.getSize().width,f.getSize().height);
        for(int i = 0; i< anzahl; i++){
            if(knotenA[i] != null){
                knotenA[i].updatePos();
            }
        }
        for(int i = 0; i< anzahl; i++){
            for(int j = 0; j< anzahl; j++){
                if(kanten[i][j]>0){
                    //g.setColor(Color.GREEN);
                    //g.drawLine(knotenA[i].x, knotenA[i].y, knotenA[j].x, knotenA[j].y);
                    Graphics2D g2 = (Graphics2D) imageG;
                    g2.setColor(Color.GREEN);
                    g2.setStroke(new BasicStroke(10));
                    g2.draw(new Line2D.Float(knotenA[i].x, knotenA[i].y, knotenA[j].x, knotenA[j].y));
                    g2.setColor(Color.BLACK);
                    imageG.setFont(new Font("MyFont",Font.BOLD, 14));
                    imageG.drawString(kanten[i][j]+"",(knotenA[i].x + knotenA[j].x)/2 ,(knotenA[i].y + knotenA[j].y)/2 );
                }
            }
        }
        for(int i = 0; i< anzahl; i++){
            if(knotenA[i] != null){
                knotenA[i].Anzeigen();
            }
        }
        f.repaint();
    }
}