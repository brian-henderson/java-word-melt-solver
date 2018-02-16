/* An ArrayQueue is a queue based on an array. The array is a circular array.
 * The queue should grow dynamically if it gets full (it should double in
 * capacity each time it gets full).
 *
 * The default constructor creates an ArrayQueue that is empty but has some
 * capacity > 0. The copy constructor creates a deep copy of the given
 * ArrayQueue object. This means that it gets its own deep copy of the data.
 *
 * The add method adds an element to the back of the queue. The remove method
 * removes one item from the front of the queue. These methods should not move
 * any data already in the queue. The getFront method returns the item at the
 * front of the queue.
 *
 * The getLength function returns the length of the queue. If the length is 0,
 * the queue is considered to be empty.
 *
 * The copyFrom method first checks to see if the queue we are assigning to is
 * the same as this, and if not, makes a deep copy of the given queue.
 *
 * The doubleCapacity method doubles the capacity of the ArrayQueue, and updates
 * the data members so they are now valid for the newly allocated array.
 *
 * Note that even if some methods are not used in your project, you still need
 * to implement them all correctly!
 */

class ArrayQueue {
  private Location[] data;
  private int length, capacity, front;
  
  private void doubleCapacity() {
    Location[] temp = new Location[capacity*2];
    for (int i=0; i < this.capacity; i++) {
    	  temp[i] = this.data[this.front];
    	  this.front = (this.front + 1) % this.length;
    }
    this.front = 0;
    this.capacity = temp.length;
    this.data = temp;
  }

  ArrayQueue() {
    this.data = new Location[10];
    this.length = 0;
    this.capacity = 10;
    this.front = 0;
  }
  ArrayQueue(ArrayQueue q) {
    this.data = q.data;
    this.length = q.length;
    this.capacity = q.capacity;
    this.front = q.front;
  }
  void add(Location loc) {
    if (this.length == this.capacity) {
    	  doubleCapacity();
    }
    int id = (front + length) % capacity;
    data[id] = loc;
    length++;
  }
  void remove() {
    this.data[this.front] = null;
    this.front = (this.front + 1) % this.capacity;
    this.length--;
  }

  Location getFront() {
    return this.data[this.front];
  }

  int getLength()  {
    return this.length;
  }

  ArrayQueue copyFrom(ArrayQueue q) {
    boolean equal = true;
    for (int i = 0; i <q.length; i++) {
	  if (q.data[i].isEqual(this.data[i])) {
		  equal = false;
	  }
    }
    if (!equal) {
    	  ArrayQueue tempCopy = new ArrayQueue(q);
    	  return tempCopy;
    }
    else {
      return null;
    }
  }
}

