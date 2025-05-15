public class RayCastTester {
    
    public static void main(String[] args) {
        int[][] maze = {
            {1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,1},
            {1,0,0,1,1,0,0,1},
            {1,0,0,1,1,0,0,1},
            {1,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1},
        };
        Maze m = new Maze(maze);
        RayCast r = new RayCast();
        System.out.println(r.getDistance(Math.toRadians(135)));
        //int[][] m = r.getScaledMap();
        //print2dArray(m);
    }
    
    public static void print2dArray(int[][] a){
        for(int i = 0; i < a.length; i++){
            printArray(a[i]);
            
        }
    }
    public static void printArray(int[] a){
        String b = "[";
        for(int i = 0; i < a.length; i++){
            b += a[i];
            if (i +1<a.length){
                b+= ", ";
            }
        }
        b +="]";
        System.out.println(b);
    }
}
