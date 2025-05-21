public class Player {
    private int x;
    private int y;
    private int fov;

    private int rotation;

    public Player(int initX, int initY, int fov)
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
        rotation+=15;
    }

    public void rotateRight()
    {
        rotation -=15;
    }
    public void moveUp()
    {
        y-=1;
    }
    public void moveDown()
    {
        y+=1;
    }
    public void moveLeft()
    {
        x+=1;
    }
    public void moveRight()
    {
        x-=1;
    }
}
