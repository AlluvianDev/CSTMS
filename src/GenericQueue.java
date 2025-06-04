public class GenericQueue<T> {
    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T data = front.getData();
        front = front.getNext();
        if (front == null) rear = null;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        Node<T> current = front;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public java.util.List<T> getAll() {
        java.util.List<T> list = new java.util.ArrayList<>();
        Node<T> current = front;
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }
}