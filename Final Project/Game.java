import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.BorderFactory;


public class Game extends JFrame implements KeyListener{
    private static RayCastPlayer player;

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_D)
            player.rotateRight();
        else if(e.getKeyCode()== KeyEvent.VK_A)
            player.rotateLeft();
        else if(e.getKeyCode()== KeyEvent.VK_S)
            player.moveDown();
        else if(e.getKeyCode()== KeyEvent.VK_W)
            player.moveUp();
        System.out.println(player.getX() + " " + player.getY() + " " + player.getRotation());
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped");
    }

    public Game(){
        this.player = new RayCastPlayer(2,2,90);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        Game frame = new Game();
        initializeWindow(frame);
        Graphics g = frame.getGraphics();
        RayCast r = new RayCast(player);
        // r.printTestFrame();
        // javax.swing.SwingUtilities.invokeLater(new Runnable() {
        //     public void run() {
            drawCasting(r.getDistanceArray(), g);
            
            // }
        // });
    }

    public static void initializeWindow(Game frame) {
        int[][] maze = Maze.getMaze();
        frame.setTitle("Square Move Practice");
        frame.setResizable(false);
        frame.setSize(1080,720);
        frame.setMinimumSize(new Dimension(1080,720));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); 
        frame.setVisible(true);
    }
    
    public static void drawCasting(int[] distances, Graphics g){
        //720 x 1080
        for(int i = 0; i < distances.length; i++)
        {
            int offset = (720 - distances[i]) / 2;
            g.setColor(returnColor(distances[i]));
            g.fillRect(i * 12, offset , 1080/distances.length,(distances[i]) );
        }
    }

    public static Color returnColor(int distance){
        Color c = new Color(0,0,(int)(distance * (255.0 / 720)));
        return c;
    }
}
