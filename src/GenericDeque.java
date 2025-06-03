class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;
    
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

public class GenericDeque<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public GenericDeque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addFront(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addBack(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty deque");
        }
        
        T dataToReturn = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }
        size--;
        return dataToReturn;
    }
    
    public T removeBack() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty deque");
        }
        
        T dataToReturn = tail.data;
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return dataToReturn;
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek empty deque");
        }
        return head.data;
    }
    
    public T peekBack() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek empty deque");
        }
        return tail.data;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void display() {
        Node<T> current = head;
        System.out.print("Deque: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    @SuppressWarnings("unchecked")
    public T[] getAll() {
        T[] result = (T[]) new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }
}
