public class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    // Constructor of the node, referance nodes set to null for safety
    
    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

}
