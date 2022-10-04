package frc.robot.Astar;

public class Layout {
    // Dimension of layout in real unit
    public static final int x_size_mm = 4038;
    public static final int y_size_mm = 2038;
    public static final int tile_size_mm = 25;
    public static final float tile_size_meter = tile_size_mm/1000.0f;
    public static final int X_SIZE = Math.round((float)x_size_mm/tile_size_mm)+1; //??
    public static final int Y_SIZE = Math.round((float)y_size_mm/tile_size_mm)+1;

    //List all fixed walls in layout here
    public static final int walls_mm[][] = {
        //(x0,y0) (x1,y1) end coordinates of line
        //x0,   y0,    x1,    y1
        //Boundary
        {0,     0,     4038,  0   }, 
        {4038,  0,     4038,  2038}, 
        {4038,  2038,  0,     2038}, 
        {0,     2038,  0,     0   }, 

        //Bottom
        {0,     680,   340,   680}, 
        {1013,  0,     1013,  680}, 
        {2023,  0,     2023,  680}, 
        {3033,  0,     3033,  680}, 
        //Top
        {1787,  2038,  1787,  2038-450}, 
        {3007,  2038,  3007,  2038-300}, 
    };


    //List all fixed rectangular obstacles in layout here
    public static final int obs_mm[][] = {
        //(x0,y0) - centre of box
        //x0   y0    xSize ySize Angle
        {1013, 755,  210,  150,  0 }, 
        {2023, 755,  210,  150,  0 }, 
        {3033, 755,  210,  150,  0 }, 
        {1957, 2038-425,  150,  210,  0 }, 
        {3007, 2038-425,  150,  210,  0 }, 
        {525, 2038-50,    650,  100,  0 }, 

    };

    private int walls[][];
    private int obs[][];


    public Layout() {
        int i, j;
        
        //Convert walls in mm to walls in cell size
        walls = new int[walls_mm.length][4];
        for (i=0; i< walls_mm.length; i++) {
            for (j=0; j<4; j++) {
                walls[i][j] = Math.round((float)walls_mm[i][j]/tile_size_mm);
            }
        }

        //Convert obstacles in mm to obstacles in cell size
        obs = new int[obs_mm.length][5];
        for (i=0; i< obs_mm.length; i++) {
            for (j=0; j<4; j++) {
                obs[i][j] = Math.round((float)obs_mm[i][j]/tile_size_mm);
            }
            obs[i][4] = obs_mm[i][4];  //Angle in degree stays the same
        }

    }

    public int [][] getWalls() {
        return walls;
    }

    public int [][] getObs() {
        return obs;
    }
}
