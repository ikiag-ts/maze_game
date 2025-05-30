import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;

public class Input extends Thread implements KeyListener
{
    private static RayCastPlayer player;

    public void run(RayCastPlayer player){
        this.player = player;

    }


    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_D)
            player.rotateRight();
        else if(e.getKeyCode()== KeyEvent.VK_A)
            player.rotateLeft();
        else if(e.getKeyCode()== KeyEvent.VK_S)
            player.moveBackward();
        else if(e.getKeyCode()== KeyEvent.VK_W)
            player.moveForward();
        System.out.println((int)(player.getX()) + " " + (int)(player.getY()) + " " + player.getRotation());
    }

    public void keyReleased(KeyEvent e) {
        
    }    

    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped");
    }
}