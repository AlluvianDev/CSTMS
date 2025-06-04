import java.util.Comparator;

/**
 * A generic history container implemented using a linked list.
 * @param <T> The type of elements stored in the history
 */
public class GenericHistory<T> {
    private Node<T> head;
    private int size;
    
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
     * Constructs an empty history container.
     */
    public GenericHistory() {
        head = null;
        size = 0;
    }
    
    /**
     * Adds an item to the history.
     * @param item The item to add
     */
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        
        // Add at the beginning of the list (most recent first)
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /**
     * Returns all items in the history as an array.
     * @return An array containing all items in the history
     */
    @SuppressWarnings("unchecked")
    public T[] getAll() {
        if (isEmpty()) {
            return (T[]) new Object[0];
        }
        
        Object[] result = new Object[size];
        Node<T> current = head;
        int index = 0;
        
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        
        return (T[]) result;
    }
    
    /**
     * Sorts the history items using the provided comparator.
     * @param comparator The comparator to use for sorting
     * @return A sorted array of the history items
     */
    @SuppressWarnings("unchecked")
    public T[] getSorted(Comparator<T> comparator) {
        if (isEmpty()) {
            return (T[]) new Object[0];
        }
        
        // Get all items first
        T[] items = getAll();
        
        // Perform insertion sort
        for (int i = 1; i < items.length; i++) {
            T key = items[i];
            int j = i - 1;
            
            while (j >= 0 && comparator.compare(items[j], key) > 0) {
                items[j + 1] = items[j];
                j--;
            }
            
            items[j + 1] = key;
        }
        
        return items;
    }
    
    /**
     * Returns the history items in ascending order (oldest first).
     * @return An array containing the history items in ascending order
     */
    @SuppressWarnings("unchecked")
    public T[] getAscending() {
        if (isEmpty()) {
            return (T[]) new Object[0];
        }
        
        // For ascending order, we need to reverse the list (since we add most recent first)
        Object[] result = new Object[size];
        Node<T> current = head;
        int index = size - 1;  // Start from the end
        
        while (current != null) {
            result[index--] = current.data;
            current = current.next;
        }
        
        return (T[]) result;
    }
    
    /**
     * Returns the history items in descending order (newest first).
     * @return An array containing the history items in descending order
     */
    @SuppressWarnings("unchecked")
    public T[] getDescending() {
        // The internal list is already in descending order
        return getAll();
    }
    
    /**
     * Checks if the history is empty.
     * @return true if the history is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the number of items in the history.
     * @return The number of items in the history
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns a string representation of the history.
     * @param items The items to include in the string representation
     * @return A string representation of the history
     */
    public String toString(T[] items) {
        if (items == null || items.length == 0) {
            return "History is empty";
        }
        
        StringBuilder sb = new StringBuilder();
        int index = 1;
        
        for (T item : items) {
            if (item != null) {
                sb.append(index++).append(". ").append(item).append("\n");
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Returns a string representation of the history in the default order.
     * @return A string representation of the history
     */
    @Override
    public String toString() {
        return toString(getAll());
    }
    
    /**
     * Displays the history items using the provided items array.
     * @param items The items to display
     */
    public void display(T[] items) {
        System.out.println(toString(items));
    }
    
    /**
     * Displays the history items in the default order.
     */
    public void display() {
        System.out.println(toString());
    }
}
