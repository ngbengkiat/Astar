# A* Pathfinding Algorithm
***Author: Ruben Amendoeira***<br>
A java implementation of the A* pathfinding/search algorithm with an interactive example.<br><br>


This algorithm can be applied to any java project, here's how:

- Import the files into your project.
- Implement an instance of the Node class (Tile.java in the example provided).
- Implement an instance of the Network class (Grid.java in the example provided). This is simply a collection of nodes.
- Adjust the AStarAlgorithm.java file to suit your needs.
- Call the setStart(), setEnd() and solve() methods.<br><br>

Modification:
Author : Ng Beng Kiat
The search algo is modified to solve for path with lesser number of turns
It also incorporate features to push path away from obstacles so as to avoid collision.
Note that Astar is now integrated with the path generation code in Trajectory-Imported

Screenshot of the interactive example provided:<br>
![](https://github.com/psikoi/AStar-Pathfinding/blob/master/images/8f3037659be6497cc324a27e2c0c8ef4.png)
