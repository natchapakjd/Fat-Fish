package fishgame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;



public class FishGame extends JFrame{
    public FishGameMenu Fishmenu = new FishGameMenu();
    public map1 Map = new map1();
    public FishGame(){
        Listener l = new Listener();
        
        setSize(1000,800);
        add(Fishmenu);   
        Fishmenu.btExit.addActionListener(l);
        Fishmenu.btStart.addActionListener(l);
    }
    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == Fishmenu.btStart){
                setLocationRelativeTo(null);
                remove(Fishmenu);
                setSize(1000,800);
                add(Map);
                Map.requestFocusInWindow();
            }
            else if(e.getSource() == Fishmenu.btExit){
                System.exit(0);
            }
            validate();
            repaint();
            
        }
        
    }
    
    public static void main(String[] args) {
        JFrame f = new FishGame(); 
        f.setTitle("Sharkgame");
        f.setSize(1000,800);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }
    
}
