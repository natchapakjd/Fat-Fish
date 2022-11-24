
package fishgame;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class FishGameMenu extends JPanel{
        private ImageIcon bg = new ImageIcon(this.getClass().getResource("Aerial.jpg"));
        private ImageIcon btStartPic = new ImageIcon(this.getClass().getResource("startbt.png"));
        private ImageIcon btStartExit = new ImageIcon(this.getClass().getResource("exit.jpg"));
        JButton btStart = new JButton(btStartPic);
        JButton btExit = new JButton(btStartExit);
        
        public FishGameMenu() {
            setLayout(null);
            btStart.setBounds(getWidth()/2 + 418, 400, 150, 75);
            add(btStart);
            btExit.setBounds(getWidth()/2 + 418, 500, 150, 75);
            add(btExit);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bg.getImage(),0,0,1000,800,this);
        }
        
}
