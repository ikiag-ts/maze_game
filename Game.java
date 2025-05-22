import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.BorderFactory;


public class Game extends JFrame implements KeyListener{
    private Player player;

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_D)
            player.moveRight();
        else if(e.getKeyCode()== KeyEvent.VK_A)
            player.moveLeft();
        else if(e.getKeyCode()== KeyEvent.VK_S)
            player.moveDown();
        else if(e.getKeyCode()== KeyEvent.VK_W)
            player.moveUp();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped");
    }

    public Game(){
        this.player = new Player();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Game frame = new Game();
                initializeWindow(frame);
                Graphics g = frame.getGraphics();
                RayCastPlayer p = new RayCastPlayer(2,3,90);
                RayCast r = new RayCast(p);
                while(true)
                {drawCasting(r.getDistanceArray(), g);}
            }
        });
    }

    public static void initializeWindow(Game frame) {
        int[][] maze = Maze.getMaze();
        frame.setTitle("Square Move Practice");
        frame.setResizable(false);
        frame.setSize(720,1080);
        frame.setMinimumSize(new Dimension(720,1080));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(frame.player);
        frame.pack(); 
        frame.setVisible(true);
    }
    
    public static void drawCasting(int[] distances, Graphics g){
        //720 x 1080
        for(int i = 0; i < distances.length; i++)
        {
            int offset = (720 - distances[i]) / 2;
            g.setColor(Color.BLUE);
            g.fillRect(i * 12, offset /2, 1080/distances.length,(distances[i]) / 2);
        }
    }
}
