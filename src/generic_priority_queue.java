/**
 * A generic priority queue implementation using three internal queues for high, medium, and low priority items.
 * 
 * @param <T> The type of elements stored in the priority queue, must implement Comparable
 */
public class GenericPriorityQueue<T extends Comparable<T>> {
    private final GenericQueue<T> highPriorityQueue;
    private final GenericQueue<T> mediumPriorityQueue;
    private final GenericQueue<T> lowPriorityQueue;
    
    /**
     * Constructs an empty priority queue.
     */
    public GenericPriorityQueue() {
        highPriorityQueue = new GenericQueue<>();
        mediumPriorityQueue = new GenericQueue<>();
        lowPriorityQueue = new GenericQueue<>();
    }
    
    /**
     * Adds an item to the appropriate priority queue.
     * The item's priority is determined by its implementation of the Comparable interface.
     * 
     * @param item The item to add
     */
    public void offer(T item) {
        // For Ticket objects, we use the Priority enum to determine which queue to use
        if (item instanceof Ticket) {
            Ticket ticket = (Ticket) item;
            
            switch (ticket.getPriority()) {
                case HIGH:
                    highPriorityQueue.enqueue(item);
                    break;
                case MEDIUM:
                    mediumPriorityQueue.enqueue(item);
                    break;
                case LOW:
                    lowPriorityQueue.enqueue(item);
                    break;
            }
        } else {
            // For other Comparable objects, we use their toString method
            // This is a simple implementation, could be enhanced for other types
            String str = item.toString().toUpperCase();
            
            if (str.contains("HIGH")) {
                highPriorityQueue.enqueue(item);
            } else if (str.contains("MEDIUM")) {
                mediumPriorityQueue.enqueue(item);
            } else {
                lowPriorityQueue.enqueue(item);
            }
        }
    }
    
    /**
     * Removes and returns the highest priority item.
     * Items are dequeued from the high priority queue first, then medium, then low.
     * 
     * @return The highest priority item
     * @throws IllegalStateException if the priority queue is empty
     */
    public T poll() {
        if (!highPriorityQueue.isEmpty()) {
            return highPriorityQueue.dequeue();
        } else if (!mediumPriorityQueue.isEmpty()) {
            return mediumPriorityQueue.dequeue();
        } else if (!lowPriorityQueue.isEmpty()) {
            return lowPriorityQueue.dequeue();
        } else {
            throw new IllegalStateException("Priority queue is empty");
        }
    }
    
    /**
     * Returns the highest priority item without removing it.
     * 
     * @return The highest priority item
     * @throws IllegalStateException if the priority queue is empty
     */
    public T peek() {
        if (!highPriorityQueue.isEmpty()) {
            return highPriorityQueue.peek();
        } else if (!mediumPriorityQueue.isEmpty()) {
            return mediumPriorityQueue.peek();
        } else if (!lowPriorityQueue.isEmpty()) {
            return lowPriorityQueue.peek();
        } else {
            throw new IllegalStateException("Priority queue is empty");
        }
    }
    
    /**
     * Checks if the priority queue is empty.
     * 
     * @return true if the priority queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return highPriorityQueue.isEmpty() && 
               mediumPriorityQueue.isEmpty() && 
               lowPriorityQueue.isEmpty();
    }
    
    /**
     * Returns the total number of elements in the priority queue.
     * 
     * @return The total number of elements
     */
    public int size() {
        return highPriorityQueue.size() + mediumPriorityQueue.size() + lowPriorityQueue.size();
    }
    
    /**
     * Returns all elements in the priority queue as an array, sorted by priority.
     * 
     * @return An array containing all elements sorted by priority
     */
    @SuppressWarnings("unchecked")
    public T[] getAll() {
        if (isEmpty()) {
            return (T[]) new Object[0];
        }
        
        int totalSize = size();
        Object[] result = new Object[totalSize];
        int index = 0;
        
        // Add high priority items first
        T[] highItems = highPriorityQueue.getAll();
        for (T item : highItems) {
            if (item != null) {
                result[index++] = item;
            }
        }
        
        // Add medium priority items next
        T[] mediumItems = mediumPriorityQueue.getAll();
        for (T item : mediumItems) {
            if (item != null) {
                result[index++] = item;
            }
        }
        
        // Add low priority items last
        T[] lowItems = lowPriorityQueue.getAll();
        for (T item : lowItems) {
            if (item != null) {
                result[index++] = item;
            }
        }
        
        return (T[]) result;
    }
    
    /**
     * Returns a string representation of the priority queue.
     * 
     * @return A string representation of the priority queue
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Priority queue is empty";
        }
        
        StringBuilder sb = new StringBuilder();
        int index = 1;
        
        // Append high priority items first
        if (!highPriorityQueue.isEmpty()) {
            T[] highItems = highPriorityQueue.getAll();
            for (T item : highItems) {
                if (item != null) {
                    sb.append(index++).append(". ").append(item).append("\n");
                }
            }
        }
        
        // Append medium priority items next
        if (!mediumPriorityQueue.isEmpty()) {
            T[] mediumItems = mediumPriorityQueue.getAll();
            for (T item : mediumItems) {
                if (item != null) {
                    sb.append(index++).append(". ").append(item).append("\n");
                }
            }
        }
        
        // Append low priority items last
        if (!lowPriorityQueue.isEmpty()) {
            T[] lowItems = lowPriorityQueue.getAll();
            for (T item : lowItems) {
                if (item != null) {
                    sb.append(index++).append(". ").append(item).append("\n");
                }
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Displays the elements in the priority queue.
     */
    public void display() {
        System.out.println(toString());
    }
}
