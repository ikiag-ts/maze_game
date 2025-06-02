public class RayCastPlayer {
    private double x;
    private double y;
    private int fov;
    private int rotation;
    private int[][] maze; 

    public RayCastPlayer(double initX, double initY, int fov) {
        this.x = initX;
        this.y = initY;
        this.fov = fov;
        this.rotation = 180;
    }
    
    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    
    public int getFov() {   
        return fov;    
    }
    
    public int getRotation() { 
        return rotation;  
    }
    
    public double getX() { 
        return x;
    }
    
    public double getY() { 
        return y;    
    }
    
    public void rotateLeft() {  
        rotation -=15;   
    }
    
    public void rotateRight() { 
        rotation +=15;    
    }
    
    public void moveForward() { 

        double newX = x + Math.cos(rotation * Math.PI / 180 - Math.PI/2) * 0.5;    
        double newY = y + Math.sin(rotation * Math.PI / 180 - Math.PI/2) * 0.5;
    
        if (canMoveTo(newX, newY)) {    
            x = newX;   
            y = newY;  
        } 
    }
    
    public void moveBackward() {       

        double newY = y + Math.sin(rotation * Math.PI / 180 + Math.PI/2);
        double newX = x + Math.cos(rotation * Math.PI / 180 + Math.PI/2);    
    
        if (canMoveTo(newX, newY)) {    
            x = newX;   
            y = newY;  
        } 
    }
    
    private boolean canMoveTo(double newX, double newY) { 

        if (maze == null) return true;
        if (newY < 0 || newY >= maze.length || newX < 0 || newX >= maze[0].length) {    
            return false;   
        }
    

        return maze[(int)newY][(int)newX] == 0;   
    }
}