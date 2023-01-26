
import java.awt.*;
import java.awt.geom.Line2D;
public class GraphenAnzeige extends Anzeige
{
    // Attribute
    KnotenAnzeige[] knotenA;
    int[][] kanten;
    Graphics g;
    // Konstruktor
    public GraphenAnzeige(KNOTEN[] knoten, int[][] matrix)
    {
        super(new Fenster());   
        knotenA = new KnotenAnzeige[knoten.length];
        kanten = matrix;
        for(int i = 0; i < knoten.length; i = i + 1){
            if(!(knoten[i] == null)){
                int kX = knoten[i].x;
                int kY = knoten[i].y;
                knotenA[i] = new KnotenAnzeige(super.f, kX , kY, knoten[i]);
            }
        }
        g = super.f.getGraphicsBuffer();
    }
    // Methoden
    @Override
    public void Anzeigen(){
        for(int i = 0; i< knotenA.length; i++){
            for(int j = 0; j< knotenA.length; j++){
                if(kanten[i][j]>0){
                    //g.setColor(Color.GREEN);
                    //g.drawLine(knotenA[i].x, knotenA[i].y, knotenA[j].x, knotenA[j].y);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setColor(Color.GREEN);
                    g2.setStroke(new BasicStroke(10));
                    g2.draw(new Line2D.Float(knotenA[i].x, knotenA[i].y, knotenA[j].x, knotenA[j].y));
                    g2.setColor(Color.BLACK);
                    imageG.setFont(new Font("MyFont",Font.BOLD, 14));
                    imageG.drawString(kanten[i][j]+"",(knotenA[i].x + knotenA[j].x)/2 ,(knotenA[i].y + knotenA[j].y)/2 );
                }
            }
        }
        for(KnotenAnzeige i : knotenA){
            if(i != null){
                i.Anzeigen();
            }
        }

    }
}