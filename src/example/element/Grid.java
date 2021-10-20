package example.element;

import java.util.ArrayList;
import pathfinding.element.Network;
import pathfinding.element.Node;

public class Grid extends Network{

    private int xSize, ySize;
    private ArrayList<Tile> tiles;

    public Grid(int xSize, int ySize) {
        tiles = new ArrayList<>();
        //Add individual cell
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                Tile t = new Tile(i, j);
                tiles.add(t);
            }
        }
        this.xSize = xSize;
        this.ySize = ySize;
    }

    //Expand obstacle to push robot away. Robot can still go through this expanded cell if necessary
    public void ExpandObstacles() {
        //Create obstacle around boundaries
        //Currently 1 cell thick. Likely need to be more than 1 cell
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (x==0 || x==xSize-1 || y==0 || y==ySize-1) {
                    Node current = find(x,y);
                    current.setObsValue(Node.maxObsValue);
                }
            }
        }

        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                Node current = find(x,y);
                if (current.getObsValue()==Node.maxObsValue) {
                    for (Node n : current.getNeighbours()) {
                        if (n.getObsValue()==0.0)
                            n.setObsValue(Node.maxObsValue/2);
                    }
                }
            }
        }
        //Expand another layer for better path generation
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                Node current = find(x,y);
                if (current.getObsValue()==Node.maxObsValue/2) {
                    for (Node n : current.getNeighbours()) {
                        if (n.getObsValue()==0.0)
                            n.setObsValue(Node.maxObsValue/5);
                    }
                }
            }
        }
    }
    public void AddObstacle(int x0, int y0, int xSize, int ySize, double angle) {
        for (int x=-xSize/2; x<xSize/2; x++) {
            for (int y=-ySize/2; y<ySize/2; y++) {
                int xx = (int)Math.round(x*Math.cos(angle) - y*Math.sin(angle));
                int yy = (int)Math.round(x*Math.sin(angle) + y*Math.cos(angle));
                Tile t = find(xx+x0,yy+y0);
                if (t!=null)
                    t.setObsValue(Node.maxObsValue);
            }
        }
    }
    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
    
    public Tile find(int x, int y){
        for(Tile t : tiles){
            if(t.getX() == x && t.getY() == y)
                return t;
        }
        return null;
    }

    @Override
    public Iterable<Node> getNodes() {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.addAll(tiles);
        return nodes;
    }
}
