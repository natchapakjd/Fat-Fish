
package fishgame;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class finishGame extends JPanel{
        private ImageIcon bgend = new ImageIcon(this.getClass().getResource("bgmn.jpg"));
        private ImageIcon btrestart = new ImageIcon(this.getClass().getResource("startbt.png"));
        private ImageIcon btQuit= new ImageIcon(this.getClass().getResource("bgmn.jpg"));
        private JButton Btrestart = new JButton(btrestart);
        private JButton BtQuit = new JButton(btQuit);
        
        public finishGame() {
            setLayout(null);
            Btrestart.setBounds(getWidth()/2 + 418, 400, 150, 75);
            add(Btrestart);
            BtQuit.setBounds(getWidth()/2 + 418, 500, 150, 75);
            add(BtQuit);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bgend.getImage(),0,0,1000,800,this);
        }
}
