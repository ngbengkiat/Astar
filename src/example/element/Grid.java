package example.element;

import java.util.ArrayList;
import pathfinding.element.Network;
import pathfinding.element.Node;

public class Grid extends Network{

    private int width, height;
    private ArrayList<Tile> tiles;

    public Grid(int width, int height) {
        tiles = new ArrayList<>();
        //Add individual cell
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile t = new Tile(i, j);
                tiles.add(t);
            }
        }
        this.width = width;
        this.height = height;
    }

    //Expand obstacle to push robot away. Robot can still go through this expanded cell if necessary
    public void ExpandObstacles() {
        //Create obstacle around boundaries
        //Currently 1 cell thick. Likely need to be more than 1 cell
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x==0 || x==width-1 || y==0 || y==height-1) {
                    Node current = find(x,y);
                    current.setObsValue(Node.maxObsValue);
                }
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
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
    }
    public void AddObstacle(int x0, int y0, int width, int height) {
        for (int x=x0; x<(x0+width); x++) {
            for (int y=y0; y<(y0+height); y++) {
                Tile t = find(x,y);
                if (t!=null)
                    t.setObsValue(Node.maxObsValue);
            }
        }
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
