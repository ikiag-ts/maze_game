import java.awt.*;
import javax.swing.JFrame;

public class Game extends JFrame{
    public static RayCastPlayer player;
    public static Input input;

    public Game(){
        this.input = new Input();
        this.player = new RayCastPlayer(2,2,90);
        addKeyListener(input);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        Game frame = new Game();
        initializeWindow(frame);
        Graphics g = frame.getGraphics();
        RayCast r = new RayCast(player);
        Visualize2D vis = new Visualize2D();
        vis.run(frame,player);
        
        input.run(player);
        
        while(true){
        

            resetBackground(g);
            drawCasting(r.getDistanceArray(), g);
            try {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) {
            Thread.currentThread().interrupt();

                return;
            }
        }
    }

    public static void initializeWindow(Game frame) {
        int[][] maze = Maze.getMaze();
        frame.setTitle("Maze Game!!!!");
        frame.setResizable(false);
        frame.setSize(1080,720);
        frame.setMinimumSize(new Dimension(1080,720));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); 
        frame.setVisible(true);
    }
    
    public static void drawCasting(int[] distances, Graphics g){
        
        for(int i = 0; i < distances.length; i++)
        {
            int rHeight = (720 - distances[i]) / 2;
            int offset = (720 - rHeight) / 2;
            g.setColor(returnColor(distances[i]));
            g.fillRect(i * 12, offset , 1080/distances.length, rHeight );
        }
    }

    public static void resetBackground(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,1080,360);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,360,1080,360);
    }
    public static Color returnColor(int distance){
        Color c = new Color(0,0,(int)(distance * (255.0 / 720)));
        return c;
    }
}
