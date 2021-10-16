package pathfinding.element;

import java.util.ArrayList;

public abstract class Node {

    private Node parent;
    private ArrayList<Node> neighbours;
    private double cost, heuristic, function;
    private double obsValue;
    private int dir=-1;

    public abstract void calculateNeighbours(Network network);
    
    public abstract double distanceTo(Node dest);

    public abstract int dirTo(Node dest);
    
    public abstract double heuristic(Node dest);

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
    public double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }

    public double getFunction() {
        return function;
    }

    public void setFunction(double function) {
        this.function = function;
    }

   
    
    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public double getObsValue() {
        return obsValue;
    }

    public void setObsValue(double obsValue) {
        this.obsValue = obsValue;
    }
    
    public void reverseObsValue(){
        if (obsValue==0) obsValue=1;
        else obsValue = 0;
    }

}
