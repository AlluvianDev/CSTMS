/**
 * A generic double-ended queue implementation using a linked list.
 * @param <T> The type of elements stored in the deque
 */
public class GenericDeque<T> {
    private Node<T> front;  // Points to the first element in the deque
    private Node<T> rear;   // Points to the last element in the deque
    private int size;       // Keeps track of the number of elements
    
    /**
     * A node in the linked list.
     * @param <E> The type of element stored in the node
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;
        
        /**
         * Constructs a new node with the given data.
         * @param data The data to store in the node
         */
        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    /**
     * Constructs an empty deque.
     */
    public GenericDeque() {
        front = null;
        rear = null;
        size = 0;
    }
    
    /**
     * Adds an element to the front of the deque.
     * @param data The element to add
     */
    public void addFront(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        
        size++;
    }
    
    /**
     * Adds an element to the back of the deque.
     * @param data The element to add
     */
    public void addBack(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        
        size++;
    }
    
    /**
     * Removes and returns the element at the front of the deque.
     * @return The element at the front of the deque
     * @throws IllegalStateException if the deque is empty
     */
    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        
        T data = front.data;
        
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        
        size--;
        return data;
    }
    
    /**
     * Removes and returns the element at the back of the deque.
     * @return The element at the back of the deque
     * @throws IllegalStateException if the deque is empty
     */
    public T removeBack() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        
        T data = rear.data;
        
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        
        size--;
        return data;
    }
    
    /**
     * Returns the element at the front of the deque without removing it.
     * @return The element at the front of the deque
     * @throws IllegalStateException if the deque is empty
     */
    public T peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        
        return front.data;
    }
    
    /**
     * Returns the element at the back of the deque without removing it.
     * @return The element at the back of the deque
     * @throws IllegalStateException if the deque is empty
     */
    public T peekBack() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        
        return rear.data;
    }
    
    /**
     * Checks if the deque is empty.
     * @return true if the deque is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the number of elements in the deque.
     * @return The number of elements in the deque
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns all elements in the deque as an array (from front to back).
     * @return An array containing all elements in the deque
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
     * Returns a string representation of the deque.
     * @return A string representation of the deque
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Deque is empty";
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
     * Displays the elements in the deque.
     */
    public void display() {
        System.out.println(toString());
    }
}
