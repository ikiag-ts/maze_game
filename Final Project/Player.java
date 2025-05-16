import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;

public class Player extends JComponent{
    public int x = Maze.getX()/2;
    public int y = Maze.getY()/2;
    public int r = 10;
    double rotation;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(x, y, r, r);
        g.fillOval(x,y,r,r);
        g.setColor(Color.RED);
        
    }

    public void move(int[] arr){
        x += arr[0];
        y += arr[1];
    }

    public void moveRight() {
        x = x + 5;
        repaint();
    }

    public void moveLeft() {
        x = x - 5;
        repaint();
    }

    public void moveDown() {
        y = y + 5;
        repaint();
    }

    public void moveUp() {
        y = y - 5;
        repaint();
    }
}