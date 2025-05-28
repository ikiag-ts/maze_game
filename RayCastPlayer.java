import javax.swing.JComponent;
public class RayCastPlayer extends JComponent {
    private int x;
    private int y;
    private int fov;

    private int rotation;

    public RayCastPlayer(int initX, int initY, int fov)
    {
        this.x = initX;
        this.y = initY;
        this.fov = fov;
        rotation = 0;
    }

    public int getFov()
    {
        return fov;
    }

    public int getRotation()
    {
        return rotation;
    }

    public int getX()
    {
        return x;
    }

    public int getY(){
        return y;
    }

    public void rotateLeft()
    {
        rotation = (rotation - 90) % 360;
    }

    public void rotateRight()
    {
        rotation = (rotation + 90) % 360;
    }

    public void moveForward()
    {
        int posRot = (rotation + 360) % 360;
        if(posRot == 0){
            y -= 1;
        }

        if(posRot == 90){
            x += 1;
        }

        if(posRot == 180){
            y += 1;
        }

        if(posRot == 270){
            x -= 1;
        }
    }

    public void moveBackward()
    {
        int posRot = (rotation + 360) % 360;
        if(posRot == 0){
            y += 1;
        }

        if(posRot == 90){
            x -= 1;
        }

        if(posRot == 180){
            y -= 1;
        }

        if(posRot == 270){
            x += 1;
        }
    }
}