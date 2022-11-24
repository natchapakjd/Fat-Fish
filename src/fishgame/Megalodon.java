/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fishgame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;


public class Megalodon {
    public Image img;
    public int x = 1200;
    public int y = (int) ((Math.random() * 300) + 20);

    public Megalodon() {
        String imglocate = "meg.png";
        URL imgurl =this.getClass().getResource(imglocate);
        img = Toolkit.getDefaultToolkit().getImage(imgurl);
        runner.start();
        
    }
    //move x label
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                x -=1;
                if (x <= 0) {
                    img = null;
                    runner = null;
                    x = +500;
                    y = +500;
                }   
                try {
                    runner.sleep(10);
                } 
                catch (InterruptedException e) {
                    
                }
            }
        }
    });
    public Image getImage() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 150, 45));
    }
    
    
}
