public class GenericDeque<T> {
    private Node<T> front;
    private Node<T> rear;

    public void addFront(T item) {
        Node<T> newNode = new Node<>(item);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.setNext(front);
            front = newNode;
        }
    }

    public void addBack(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public T removeFront() {
        if (front == null) return null;
        T data = front.getData();
        front = front.getNext();
        if (front == null) rear = null;
        return data;
    }

    public T removeBack() {
        if (rear == null) return null;
        if (front == rear) {
            T data = rear.getData();
            front = rear = null;
            return data;
        }
        Node<T> current = front;
        while (current.getNext() != rear) {
            current = current.getNext();
        }
        T data = rear.getData();
        rear = current;
        rear.setNext(null);
        return data;
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
