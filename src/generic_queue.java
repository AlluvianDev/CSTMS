/**
 * A generic FIFO queue implementation using a linked list.
 * @param <T> The type of elements stored in the queue
 */
public class GenericQueue<T> {
    private Node<T> front;  // Points to the first element in the queue
    private Node<T> rear;   // Points to the last element in the queue
    private int size;       // Keeps track of the number of elements
    
    /**
     * A node in the linked list.
     * @param <E> The type of element stored in the node
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;
        
        /**
         * Constructs a new node with the given data.
         * @param data The data to store in the node
         */
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * Constructs an empty queue.
     */
    public GenericQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    /**
     * Adds an element to the rear of the queue.
     * @param data The element to add
     */
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        
        rear = newNode;
        size++;
    }
    
    /**
     * Removes and returns the element at the front of the queue.
     * @return The element at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        T data = front.data;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        
        size--;
        return data;
    }
    
    /**
     * Returns the element at the front of the queue without removing it.
     * @return The element at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        return front.data;
    }
    
    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the number of elements in the queue.
     * @return The number of elements in the queue
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns all elements in the queue as an array.
     * @return An array containing all elements in the queue
     */
    @SuppressWarnings("unchecked")
    public T[] getAll() {
        if (isEmpty()) {
            return (T[]) new Object[0];
        }
        
        Object[] result = new Object[size];
        Node<T> current = front;
        int index = 0;
        
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        
        return (T[]) result;
    }
    
    /**
     * Returns a string representation of the queue.
     * @return A string representation of the queue
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue is empty";
        }
        
        StringBuilder sb = new StringBuilder();
        Node<T> current = front;
        int index = 1;
        
        while (current != null) {
            sb.append(index).append(". ").append(current.data).append("\n");
            current = current.next;
            index++;
        }
        
        return sb.toString();
    }
    
    /**
     * Displays the elements in the queue.
     */
    public void display() {
        System.out.println(toString());
    }
}
