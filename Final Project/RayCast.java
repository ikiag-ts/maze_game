public class RayCast {
    // public int[][] maze = {
    //    { 1, 1, 1, 1, 1},
    //    { 1, 0, 0, 0, 1},
    //    { 1, 0, 0, 0, 1},
    //    { 1, 0, 0, 0, 1},
    //    { 1, 1, 1, 1, 1},
    // };
    //public int[][] maze = {
    //{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},    
    //{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},    
    //{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},    
    //{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},    
    //{1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
    //{1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
    //{1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
    //{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},    
    //};
    public int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
    };

    RayCastPlayer player;
    private double[] correctAngles;

    public RayCast(RayCastPlayer player){

        this.player = player;
        player.setMaze(this.maze);
        correctAngles = correctAngles();
    }

    public double[] correctAngles()
    {
        double[] c = new double[90];
        double step = (2.0/89);
        for(int i = 0; i < 90; i ++)
        {
            c[i] = Math.atan(i*step-1);
        }
        return c;
    }
    public double getDistance(double alpha, double beta) {
        alpha += Math.toRadians(player.getRotation())+Math.PI; 
        
        double startPosX = player.getX();
        double startPosY = player.getY();
        
        double rayX = startPosX;
        double rayY = startPosY;

        double stepSize = 0.05;

        double dx = Math.cos(alpha) * stepSize;
        double dy = Math.sin(alpha) * stepSize;

        while (maze[(int)(rayY)][(int)(rayX)] == 0) {
            rayX += dx;
            rayY += dy;

            int mazeX = (int)(rayX);
            int mazeY = (int)(rayY);

            if (!isInBound(maze, mazeY, mazeX)) {
                return Integer.MAX_VALUE; 
            }
        }
        
        // System.out.println(rayX);
        double fx = rayX - startPosX;
        double fy = rayY - startPosY;
        return Math.sqrt(fx * fx + fy * fy) * Math.cos(beta);
    }
    
    public int[] getDistanceArray()
    {
        int fov = player.getFov();
        int[] distanceArray = new int[fov];
        int index = 0;
        for(int i = 0; i < 90; i++)
        {
            distanceArray[index] = (int)(getDistance(correctAngles[i],correctAngles[i]) * (720.0) * (1.0/maze.length)) ;

            //distanceArray[index] = (int)((1.0 / getDistance(Math.toRadians(i))) * 10000000 * (720.0/666666.0)) ;
            index++;
        }
        //swapArray(distanceArray);
        return distanceArray;
    }


    public int[] swapArray(int[] arr)
    {
        int[] newArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            newArr[arr.length - i - 1] = arr[i];
        }
        return newArr;
    }
    public boolean isInBound(int[][] arr, int x, int y)
    {
        return (x >= 0 && x < arr.length) &&  (y >=0 && y < arr[0].length);
    }

    private int[] appendArray(int[] arr1, int[] arr2){
        int[] newArr = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++){
            newArr[i] = arr1[i];
        }
        for(int i = 0; i < arr2.length; i++){
            newArr[i+arr1.length] = arr2[i=+arr1.length];
        }
        return newArr;
    }
    public static void print2dArray(int[][] a){
        for(int i = 0; i < a.length; i++){
            printArray(a[i]);
            
        }
    }
    public static void printArray(int[] a){
        String b = "[]";
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