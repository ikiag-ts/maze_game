import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Game extends JFrame implements KeyListener{
    private Player player;

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            player.moveRight();
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
            player.moveLeft();
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
            player.moveDown();
        else if(e.getKeyCode()== KeyEvent.VK_UP)
            player.moveUp();

    }
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
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
                initializeWindow(frame,Graphics g);
            }
        });
    }

    public static void initializeWindow(Game frame, Graphics g) {
        int[][] maze = Maze.getMaze();
        frame.setTitle("Square Move Practice");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(Maze.getX(), Maze.getY());
        frame.setMinimumSize(new Dimension(Maze.getX(), Maze.getY()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(frame.player);
        frame.pack();

        for(int px = 0; px < Maze.getX(); px+= 32){
            for(int py = 0; py < Maze.getX(); py+= 32){
                if(maze[py/32][px/32] == 1){
                    g.fillRect(px,py,32,32);
                }
            }
        }
        
    }

    private static JLabel makeLabel(int i) {
        JLabel label= new JLabel();
        label.setPreferredSize(new Dimension(32, 32));
        if(i == 1){
            label.setBackground(new Color(40,40,40));
        }
        else{
                label.setBackground(Color.WHITE);
        }
        label.setOpaque(true);
        return label;
    }
}
