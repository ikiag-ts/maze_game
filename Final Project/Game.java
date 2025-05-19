import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;


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

    public Graphics getGraphics(){
        return super.getGraphics();
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
            }
        });
    }

    public static void initializeWindow(Game frame) {
        int[][] maze = Maze.getMaze();
        Graphics g = frame.getGraphics();
        frame.setTitle("Square Move Practice");
        frame.setResizable(false);
        frame.setLayout(new GridLayout(maze.length, maze[0].length));
        frame.setSize(Maze.getX(), Maze.getY());
        frame.setMinimumSize(new Dimension(Maze.getX(), Maze.getY()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                JLabel label = makeLabel(maze[row][col]);
                frame.add(label);
            }
        }

        frame.pack();
        frame.setVisible(true);
        
    }

    private static JLabel makeLabel(int i) {

        JLabel label= new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(40, 40));
        switch(i) {
            case 1:
                label.setBackground(Color.GRAY);
                break;
            default:
                label.setBackground(Color.WHITE);
                break;

        }
        label.setOpaque(true);
        return label;
    }

}
