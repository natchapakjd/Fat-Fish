package fishgame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class map1 extends JPanel{
    private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("sea.jpg"));
    Shark mainShark = new Shark();
    
    FishGameMenu homePage = new FishGameMenu();
    public int score,size = 0;
    
    ImageIcon feildover = new ImageIcon(this.getClass().getResource("opm.jpg"));
    ImageIcon exitover = new ImageIcon(this.getClass().getResource("bgmn.jpg"));
    ImageIcon restart = new ImageIcon(this.getClass().getResource("startbt.png"));
    private JButton Btrestart = new JButton(restart);
    private JButton BtQuit = new JButton(exitover);

    
   
    public ArrayList<Bomb> bombEne = new ArrayList<Bomb>();
    public ArrayList<smallFish> smallfish = new ArrayList<smallFish>();
    public ArrayList<bullet> bul = new ArrayList<bullet>();
    public ArrayList<poison> poison = new ArrayList<poison>();
    public ArrayList<Whale> whale = new ArrayList<Whale>();
    public ArrayList<Snake> snake = new ArrayList<Snake>();
    public ArrayList<Megalodon> megalodon = new ArrayList<Megalodon>();
    public ArrayList<Turtle> turtle = new ArrayList<Turtle>();
    
    
    //Weight of fish
    public static int whale_size = 50;
    public static int snake_size = 3;
    public static int meg_size = 500;
    
    Thread actorThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(10);
                }
                catch(Exception e){   
                }
                repaint();
            }
        }
    });
    
    Thread bombThread = new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep((long) (Math.random() * 10000) + 200);
                }
                catch(Exception e){
                    
                }
                bombEne.add(new Bomb());
            }
        }
        
    });
    Thread poisonThread = new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep((long) (Math.random() * 10000) + 200);
                }
                catch(Exception e){
                    
                }
                poison.add(new poison());
            }
        }
        
    });
    Thread smfishThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep((long) (Math.random() * 10000) + 200);
                }
                catch(Exception e){
                    
                }
                smallfish.add(new smallFish());
            }
        }
    });
    
    Thread whaleThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep((long) (Math.random() * 10000) + 200);
                }
                catch(Exception e){
                    
                }
                whale.add(new Whale());
            }
        }
    });
    
    Thread snakeThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep((long) (Math.random() * 10000) + 200);
                }
                catch(Exception e){
                    
                }
                snake.add(new Snake());
            }
        }
    });
    
    Thread megalodonThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(10000);
                }
                catch(Exception e){
                    
                }
                megalodon.add(new Megalodon());
            }
        }
    });
    
    Thread turtleThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(10000);
                }
                catch(Exception e){
                    
                }
                turtle.add(new Turtle());
            }
        }
    });
    
    map1(){
        this.setFocusable(true);
        this.setLayout(null);
        
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_A){
                    mainShark.x -=10; 
                    
                }
                else if(e.getKeyCode() == KeyEvent.VK_D){
                    mainShark.x +=10;
                    
                }
                else if(e.getKeyCode() == KeyEvent.VK_W){
                    mainShark.y -=10;
                    
                }
                else if(e.getKeyCode() == KeyEvent.VK_S){
                    mainShark.y +=10;
                    
                }
                else if(e.getKeyCode() == KeyEvent.VK_UP){
                    bul.add(new bullet(mainShark.x,mainShark.y));
                }
            }
          
        });
        mainShark.x = 400;
        mainShark.y = 600;
        actorThread.start();
        smfishThread.start();
        bombThread.start();
        poisonThread.start();
        whaleThread.start();
        snakeThread.start();
        megalodonThread.start();
        turtleThread.start();
    }
    
    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        if(size >= 0){
            g.drawImage(imgstate1.getImage(), 0, 0, 1000, 800, this);
            g.drawImage(mainShark.sharkimg.getImage(), mainShark.x, mainShark.y, 80+size, 80+size, this);
            if(mainShark.x < 0){
                mainShark.x = this.getWidth() - 10;
            }
            if(mainShark.x > this.getWidth()){
                mainShark.x = 20 ;
            }
            if(mainShark.y < 0){
                mainShark.y = this.getHeight() - 10;
            }

            if(mainShark.y > this.getHeight()){
                mainShark.y = 20;
            }

            for(int i = 0 ; i < bul.size() ;i++){
                bullet bl =  bul.get(i);
                g.drawImage(bl.bulletImg.getImage(),bl.x,bl.y,30,30,null);
                bl.move();
                if(bl.y < 0){
                    bul.remove(i);
                }

            }

            for (int i = 0; i < smallfish.size(); i++) {
                    g.drawImage(smallfish.get(i).getImage(), smallfish.get(i).getX(), smallfish.get(i).getY(), 100, 100, this);
            }
            for (int i = 0; i < bul.size(); i++) {
                    for (int j = 0; j < smallfish.size(); j++) {
                        if (Intersect(bul.get(i).getbound(), smallfish.get(j).getbound())) {
                            System.out.println("Intersection");
                            smallfish.remove(j);
                            bul.remove(i);
                            size += 10 ;
                            score += 30;
                            if(size >= 350){
                                size = 0;
                            }
                            
                        }
                    }
            }
            
            
            for (int i = 0; i < whale.size(); i++) {
                    g.drawImage(whale.get(i).getImage(), whale.get(i).getX(), whale.get(i).getY(), 200, 125, this);
            }
            for (int i = 0; i < bul.size(); i++) {
                    for (int j = 0; j < whale.size(); j++) {
                        if (Intersect(bul.get(i).getbound(), whale.get(j).getbound())) {
                            System.out.println("Intersection");
                            whale.remove(j);
                            bul.remove(i);
                            
                            size += 10 ;
                            score += 300;
                            if(size >= 1500){
                                size = 100;
                            }
                            else if(size < whale_size){
                                size = -9999999;
                            }
                        }
                    }
            }
            for (int i = 0; i < snake.size(); i++) {
                    g.drawImage(snake.get(i).getImage(), snake.get(i).getX(), snake.get(i).getY(), 120, 100, this);
            }
            for (int i = 0; i < bul.size(); i++) {
                    for (int j = 0; j < snake.size(); j++) {
                        if (Intersect(bul.get(i).getbound(), snake.get(j).getbound())) {
                            System.out.println("Intersection");
                            snake.remove(j);
                            bul.remove(i);
                            
                            size += 3 ;
                            score += 30;
                            if(size >= 1500){
                                size = 100;
                            }
                            else if(size < snake_size){
                                size = -9999999;
                            }
                        }
                    }
            }
            
            for (int i = 0; i < megalodon.size(); i++) {
                    g.drawImage(megalodon.get(i).getImage(), megalodon.get(i).getX(), megalodon.get(i).getY(), 400, 150, this);
            }
            for (int i = 0; i < bul.size(); i++) {
                    for (int j = 0; j < megalodon.size(); j++) {
                        if (Intersect(bul.get(i).getbound(), megalodon.get(j).getbound())) {
                            System.out.println("Intersection");
                            megalodon.remove(j);
                            bul.remove(i);
                            
                            size += 50 ;
                            score += 1000;
                            if(size >= 1500){
                                size = 100;
                            }
                            else if(size < meg_size){
                                size = -9999999;
                            }
                        }
                    }
            }
            
            for (int i = 0; i < bombEne.size(); i++) {
                    g.drawImage(bombEne.get(i).getImage(), bombEne.get(i).getX(), bombEne.get(i).getY(), 30, 30, this);
            }
            for (int i = 0; i < bul.size(); i++) {
                    for (int j = 0; j < bombEne.size(); j++) {
                        if (Intersect(bul.get(i).getbound(), bombEne.get(j).getbound())) {
                            System.out.println("Intersection");
                            bombEne.remove(j);
                            bul.remove(i);
                            size -= 99999999;
                        }
                    }
            }

            for (int i = 0; i < poison.size(); i++) {
                    g.drawImage(poison.get(i).getImage(), poison.get(i).getX(), poison.get(i).getY(), 30, 30, this);
            }
            for (int i = 0; i < bul.size(); i++) {
                    for (int j = 0; j < poison.size(); j++) {
                        if (Intersect(bul.get(i).getbound(), poison.get(j).getbound())) {
                            System.out.println("Intersection");
                            poison.remove(j);
                            bul.remove(i);
                            size -= 5;
                            score-= 30;
                        }
                    }
            }
            for (int i = 0; i < turtle.size(); i++) {
                    g.drawImage(turtle.get(i).getImage(), turtle.get(i).getX(), turtle.get(i).getY(), 120, 100, this);
            }
            
            for (int i = 0; i < bul.size(); i++) {
                    for (int j = 0; j < turtle.size(); j++) {
                        if (Intersect(bul.get(i).getbound(), turtle.get(j).getbound())) {
                            System.out.println("Intersection");
                            turtle.remove(j);
                            bul.remove(i);
                            
                            size += 15 ;
                            score += 45;
                            if(size >= 1500){
                                size = 100;
                            }
                            
                        }
                    }
            }
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 20));
            g.setColor(Color.red);
            g.drawString("SCORE =  " + score, 825,40);

            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 20));
            g.setColor(Color.red);
            g.drawString("SIZE =  " + size, 725,40);
        }
        else{
            g.drawImage(feildover.getImage(), 0, 0, 1000, 800, this);
            g.setColor(Color.red);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 40));
            g.drawString("SCORE   " + score, 380, 200);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 70));
            g.drawString("GAME OVER", 290, 150);
            
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Btrestart) {
            this.setSize(1000, 800);
            this.add(homePage);
            this.setLocation(null);
            
        } else if (e.getSource() == BtQuit) {
            System.exit(0);
        }
    }
}
