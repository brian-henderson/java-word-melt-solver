import java.util.Scanner;
import java.util.TreeMap;

public class Driver_prj2 {

  public static void main(String[] args) {
    TreeMap<Location, Location> pastLocs = new TreeMap<>();
    ArrayQueue arrQueue = new ArrayQueue();  
    Maze maze = new Maze();
    String[] soloutions = new String[5];
	boolean isSolved = false;
	  
    Scanner input = new Scanner(System.in);
    maze.streamIn(input);
    
    arrQueue.add(maze.getStartLocation());
    
    while (arrQueue.getLength() > 0 && !isSolved) {
    	  Location temp = arrQueue.getFront();
    	  arrQueue.remove();
    	  while (!temp.isDone()) {
        Location locTemp = temp.nextNeighbor();
        if (maze.isValidLocation(locTemp)) {
        	  if (!temp.isEqual(locTemp) && !pastLocs.containsKey(locTemp)) {
        		  pastLocs.put(locTemp, temp);
        	  }
        	  if (maze.isEndLocation(locTemp)) {
        	    isSolved = true;
        	    
        	  }
        	  else {
        		  arrQueue.add(temp);
        	  }
        }
    	  }
    }
	  
  }


}
