public class GenericQueue<T> {
    private Node<T> head;
    private Node<T> tail;

    public GenericQueue(){
        this.head = null;
        this.tail = null;

    }

    public void enqueue(T item){
        Node<T> newNode = new Node<>(item); // placed data inside the node then pointing it
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }

    }

    public T peek(){
        if(!isEmpty()){ //return data of head if not empty
            return head.data;
        }
        else{
            return null;
        }
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

    public T dequeue(){ //dequeues the 1st
        if(isEmpty()){
            return null;
        }

        T dataToReturn = head.data; // sets head.data to a temporary value, then removes head from the queue
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return dataToReturn;
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

    public boolean isEmpty(){
        return head == null;
    }
}
