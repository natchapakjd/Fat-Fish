package fishgame;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class bullet extends JPanel{
    public int x;
    public int y;
    public ImageIcon bulletImg = new ImageIcon();
    
    
    public bullet(int x,int y){
       String bullocate = "teeth.png";
       bulletImg = new ImageIcon(this.getClass().getResource(bullocate));
       this.x = x;
       this.y = y;
    }
    public void move (){
        this.y -=5;
    }
    public Rectangle2D getbound(){
        return(new Rectangle2D.Double(x,y,25,25));
    }
}
