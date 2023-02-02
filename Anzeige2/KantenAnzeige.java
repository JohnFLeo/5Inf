
import java.awt.*;
import java.awt.geom.Line2D;
public class KantenAnzeige extends Anzeige
{
    KnotenAnzeige ka1;
    KnotenAnzeige ka2;
    GraphenAnzeige ga;
    boolean markiert;
    boolean wegmarkiert;
    public KantenAnzeige(Fenster fenster, KnotenAnzeige ka1, KnotenAnzeige ka2, GraphenAnzeige ga){
        super(fenster);
        markiert = false;
        wegmarkiert = false;
        this.ka1 = ka1;
        this.ka2 = ka2;
        this.ga = ga;
    }

    @Override
    public void Anzeigen(){
         Graphics2D g2 = (Graphics2D) imageG;
        if(markiert){
            g2.setColor(Color.GREEN);
        }else{
            g2.setColor(Color.GREEN);
        }
        if(wegmarkiert){
            g2.setColor(Color.GREEN);
        }
        g2.setStroke(new BasicStroke(10));
        g2.draw(new Line2D.Float(ka1.x, ka1.y, ka2.x, ka2.y));
    }
}
