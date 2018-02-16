import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* Changes from Project 1:
 *
 * Data member validLocations was changed from a Location array to a
 * Set<Location>, but it still represents the group of locations that may be
 * visited in the maze.
 *
 * Data member validLocationCount was eliminated (because validLocations is no
 * longer an array).
 *
 * We let the compiler deal with the assignment operator, copy constructor, and 
 * for this version of the Maze, you should use the default constructor for the
 * _usual_ and to initally allocate memory for the Set of validLocations using
 * the TreeSet implementation of a Set.
 */

class Maze {
  private Set<Location> validLocations;

  private Location startLocation;
  private Location endLocation;

  Maze() {
    this.startLocation = new Location();
    this.endLocation = new Location();
  }

  Location getStartLocation() {
    return this.startLocation;
  }
  
  boolean isValidLocation(Location loc) {
    Iterator<Location> iter = validLocations.iterator();
    while(iter.hasNext()) {
    	  if (validLocations.contains(loc)) {
    		  return true;
    	  }
    	  else {
    		  iter.next();
    	  }
    }
    return false;
  }
  
  boolean isEndLocation(Location loc) {
    return this.endLocation.isEqual(loc);
  }

  void streamIn(Scanner input) {
    validLocations = new TreeSet<>();
    int count = input.nextInt();
    input.nextLine();
    
    for (int i = 0; i < count; i++) {
      Location temp = new Location();
    	  temp.streamIn(input);
    	  validLocations.add(temp);
    }
    input.nextLine();
    startLocation.streamIn(input);
    endLocation.streamIn(input);
  }
  
}
