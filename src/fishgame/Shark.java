
package fishgame;

import javax.swing.ImageIcon;

public class Shark {
    public ImageIcon sharkimg =  new ImageIcon();
    public int x;
    public int y;
    Shark(){
        sharkimg = new ImageIcon(this.getClass().getResource("Shark.png"));
    }
    
}
