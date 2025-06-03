import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends JFrame{
    public static RayCastPlayer player;
    public static Input input;

    public Game(){
        this.input = new Input();
        this.player = new RayCastPlayer(17,0,270);
        addKeyListener(input);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        Game frame = new Game();
        initializeWindow(frame);
        Graphics g = frame.getGraphics();
        RayCast r = new RayCast(player);
        r.printArray(r.getDistanceArray());
        boolean win = false;


        
        input.run(player);
        
        while(!win){
            resetBackground(g);
            drawCasting(r.getDistanceArray(), g);
            win = checkWin();
            
            try {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) {
            Thread.currentThread().interrupt();

                return;
            }

        }

        JOptionPane.showMessageDialog(null, "You win!!","WINNNERRRRRRRRRR", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean checkWin(){
        return (int)player.getX() == 17 && (int)player.getY() == 23;
    }

    public static void initializeWindow(Game frame) {
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
            // double corr = Math.atan(correction[i]);
            int rHeight = (int)((720-distances[i]));
            int offset = (distances[i]) / 2;
            g.setColor(returnColor(distances[i]));
            g.fillRect((int)(i * 12), offset , (int)(1080/distances.length),rHeight);
        }
    }

    // public static double[] makeCorr(){
    //     double[] corrArr = new double[90];
    //     for(int i = 0; i < 90; i++){
    //         corrArr[i] = (player.getRotation() - 45 + i) * Math.PI / 180;
    //     }
    //     return corrArr;
    // }

    public static void resetBackground(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(0,0,1080,360);
        g.setColor(Color.BLUE);
        g.fillRect(0,360,1080,360);
    }
    public static Color returnColor(int distance){
        int rgb = Math.max(0,155-(int)(distance * (255.0 / 720)));
        Color c = new Color(0,rgb,0);
        return c;
    }
}
