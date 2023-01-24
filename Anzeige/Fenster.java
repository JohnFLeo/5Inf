
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
public class Fenster extends JFrame
{
    // Attribute
    BufferedImage img;
    Graphics graphics;
    // Konstruktor
    public Fenster ()
    {
        Dimension sizeEcht = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(sizeEcht);
        setVisible(true);
        img = new BufferedImage(getSize().width,getSize().height, BufferedImage.TYPE_INT_ARGB);
        graphics = img.getGraphics();
        getGraphicsBuffer().setColor(Color.WHITE);
        getGraphicsBuffer().fillRect(0,0,getSize().width,getSize().height);
        repaint();
    }
    
    // Methoden
    public Graphics getGraphicsBuffer(){
        return graphics;
    }
    @Override
    public void paint(Graphics g){ 
        g.drawImage(img, 0, 0, null);
    }
    
}