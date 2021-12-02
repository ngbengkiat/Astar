package example;

public class Layout {
    // Dimension of layout in real unit
    public static final int x_size_mm = 2250;
    public static final int y_size_mm = 4500;
    public static final int grid_size_mm = 50;

    //List all fixed walls in layout here
    public static final int walls_mm[][] = {
        //x0,   y0,    x1,     y1
        {0,    0,      2250,  0}, 
        {2250, 0,      2250,  4500}, 
        {2250, 4500,   0,     4500}, 
        {0,    4500,   0,     0}, 
        {0,    0,      1000,  1000}, 
        {0,    1000,   1000,  2000}, 
    };


    //List all fixed rectangular obstacles in layout here
    public static final double obs_mm[][] = {
        //x0,   y0,    x1,    y1

        {500,  500,   500,   200,  0}, 
        {500,  300,  500,    200,  45}, 
        {200,  250,   100,   400,  0}, 

    };

    private int walls[][];

    public final int X_SIZE = Math.round((float)x_size_mm/grid_size_mm)+1; //??

    public final int Y_SIZE = Math.round((float)y_size_mm/grid_size_mm)+1;

    public Layout() {
        int i, j;
        walls = new int[walls_mm.length][4];
        for (i=0; i< walls_mm.length; i++) {
            for (j=0; j<4; j++) {
                walls[i][j] = Math.round((float)walls_mm[i][j]/grid_size_mm);
                //System.out.printf("%d ", walls[i][j]);
            }
            //System.out.println();
        }
        //System.out.printf("%d %d\n", X_SIZE, Y_SIZE);
    }

    public int [][] getWalls() {
        return walls;
    }
}
