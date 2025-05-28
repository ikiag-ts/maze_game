import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Visualize2D extends Thread{
    public Game g;
    public int[][] maze = {
        { 1, 1, 1, 1, 1},
        { 1, 0, 0, 0, 1},
        { 1, 0, 0, 0, 1},
        { 1, 0, 0, 0, 1},
        { 1, 1, 1, 1, 1},
    };

    public void run(Game g){
        this.g = g;
        initializeWindow();
    }

    private void initializeWindow() {
        JFrame frame = new JFrame("MazeVisualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(maze.length, maze[0].length));// avoid null layouts
        //frame.setSize(1920, 1080); //use preferred size and let layout manager set the size
        frame.setLocationRelativeTo(null);

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                JLabel label = makeLabel(maze[row][col]);
                frame.add(label);
            }
        }
        frame.pack();
        frame.setVisible(true);
    }

    private JLabel makeLabel(int i) {

        JLabel label= new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(40, 40));

        if(i == 1){
            label.setBackground(Color.BLUE);
        }
        else{
            label.setBackground(Color.WHITE);
        }

        label.setOpaque(true);
        return label;
    }


}