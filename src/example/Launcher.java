package example;

import example.ui.ControlsPanel;
import java.awt.Dimension;

import example.ui.MainFrame;
import example.ui.GridPanel;
import javax.swing.JPanel;

import Astar.AStarAlgorithm;
import Astar.Grid;
import Astar.Tile;

public class Launcher {

    public static int X_SIZE;
    public static int Y_SIZE;

    private static MainFrame frame;
    private static JPanel container;
    private static GridPanel canvas;
    private static ControlsPanel controls;
    
    private static AStarAlgorithm astar;

    public static void main(String[] args) {
        
        //Create grid
        Layout layout = new Layout();
        Grid grid = new Grid(layout);
        X_SIZE = grid.getxSize();
        Y_SIZE = grid.getySize();

        //Add fixed obstacles
        grid.AddObstacle(10,10, 10,4, 0);
        grid.AddObstacle(10,60, 10,4, Math.PI/4);
        grid.AddObstacle(40,50, 2,8, 0);
        grid.ExpandObstacles(50);
        //Create solver
        astar = new AStarAlgorithm(grid);
        
        initUI();

        astar.addPropertyChangeListener(canvas);
        astar.updateUI();
    }

    private static void initUI() {
        
        int w = X_SIZE * Tile.TILE_SIZE;
        int h = Y_SIZE * Tile.TILE_SIZE;
        int controlsW = 200;
        int margin = 10;
        
        frame = new MainFrame();
        frame.setPreferredSize(new Dimension(w + controlsW + 15 + (margin * 3), h + 40 + (margin * 2)));
        
        container = new JPanel();
        container.setLayout(null);
        
        controls = new ControlsPanel(controlsW, 120, astar);
        controls.setBounds(w + (margin * 2), margin, controlsW, h);
        
        canvas = new GridPanel(controls);
        canvas.setBounds(margin, margin, w, h);
        
        
        container.add(controls);
        container.add(canvas);
        
        frame.setContentPane(container);
        frame.setVisible(true);
        frame.pack();
    }

}
