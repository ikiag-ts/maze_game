public class Maze {
    private int[][] maze;
    private int size = 0;
    public Maze(int size){
        this.size = size;
        maze = new int[size][size];
    }
    public Maze(int[][] maze){
        this.maze = maze;
        size = maze.length;
    }
}
