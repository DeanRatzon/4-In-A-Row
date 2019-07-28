import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class Disc extends JComponent{

    @Override
    public void paintComponent ( Graphics g ) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawOval(500,500,500,500);
    }
}