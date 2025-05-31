public class GenericHistory<T> {
    private Node<T> head;
    private Node<T> tail;

    public GenericHistory(){
        this.head = null;
        this.tail = null;
    }

    public void add(T item){
        Node<T> newNode = new Node<>(item); // placed data inside the node then pointing it
        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
    }

    public int size() {
        int count = 0;
        Node<T> current = head; //temp node for while loop
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    public T[] getAll(){ //Returns all elements in order, as a list.
        int size = size();
        T[] result = (T[]) new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }

    public void display(){ //	Prints the deque from front to back.
        Node<T> current = head;
        System.out.print("--- Resolved Ticket History ---");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return head == null;
    }
}
