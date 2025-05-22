public class RayCast {
    int[][] maze = {
        {1,1,1,0,1,1,1,1},
        {1,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,1},
        {1,0,0,1,1,0,0,1},
        {1,0,0,1,1,0,0,1},
        {1,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1},
    };
    
    RayCastPlayer player;
    private int[][] scaledMap;
    private final int scaleFactor = 256;


    public RayCast(RayCastPlayer player){
        scaledMap = makeScaledMap();
        this.player = player;
    }
    public int[][] getScaledMap(){
        return scaledMap;
    }
    public int[][] makeScaledMap(){
        int[][] newScaledMap = new int[maze.length * scaleFactor][maze[0].length * scaleFactor];
        for(int i = 0; i < maze.length;i++){
            for(int j = 0; j < maze[0].length; j++){
                for(int k = 0; k < scaleFactor; k++){
                    for(int l = 0; l < scaleFactor; l++){
                        newScaledMap[k + i * scaleFactor][l +j * scaleFactor] = maze[i][j];
                    }
                }
            }
        }
        return newScaledMap;
    }

    public double getDistance(double angle){
        angle +=player.getRotation();
        int run = (int)(16 * Math.cos(angle));
        int rise = (int)(16 * Math.sin(angle));
 
        int startPosX = (player.getX() * scaleFactor);// - scaleFactor / 2;
        int startPosY = (player.getY() * scaleFactor);//- scaleFactor / 2;
        int rayX = startPosX;
        int rayY = startPosY;
        for(int i = 0 ;i <scaledMap.length;i++)
        {
            if(!isInBound(scaledMap, rayX,rayY))
            {
                return -1;
            }
            if(scaledMap[rayX][rayY] == 1)
            {
                return Math.sqrt(Math.pow(startPosX - rayX, 2.0) + Math.pow(startPosY - rayY, 2.0));
            }
            rayX+=run;
            rayY+=rise;
        }
        return -1;
        
    }
    public int[] getDistanceArray()
    {
        int fov = player.getFov();
        int[] distanceArray = new int[fov];
        int index = 0;
        for(int i = (180 - fov) / 2; i < fov + ((180 - fov) / 2); i++)
        {
            distanceArray[index] = (int)(getDistance(Math.toRadians(i)) * (1.0/maze.length*scaleFactor)*(720.0/51167)) ;
            index++;
        }
        swapArray(distanceArray);
        return distanceArray;
    }

    public void printTestFrame()
    {
        int[] distanceArray = getDistanceArray();
        distanceArray = swapArray(distanceArray);
        printArray(distanceArray);
        int[][] screen = new int[maze.length*scaleFactor * 2][player.getFov()];
        for(int x = 0; x < screen[0].length; x++){
            //screen[0][x];
            for(int i = 0; i < distanceArray[x]; i++){
                System.out.print(( screen.length - distanceArray[x]  ) / 2);
                screen[i+ ((screen.length - distanceArray[x]  ) / 2)][x] = 1; // 
            }
        }
        print2dArray(screen);

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
        String b = "";
        for(int i = 0; i < a.length; i++){
            b += a[i];
            if (i +1<a.length){
                b+= "  ";
            }
        }
        b +=" ";
        System.out.println(b);
    }
}