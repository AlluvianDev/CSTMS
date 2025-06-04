public class GenericQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private final Class<T> clazz;
    private int size;

    public GenericQueue(Class<T> clazz){
        this.clazz = clazz;
        this.head = null;
        this.tail = null;

    }

    public void enqueue(T item){
        Node<T> newNode = new Node<>(item); // placed data inside the node then pointing it
        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
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
        size = count;
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
        size--;
        return dataToReturn;
    }

    @SuppressWarnings("unchecked")
    public T[] getAll() {
        // Manual creation of T[] using clazz without Array.newInstance
        // We’ll create an array of the specific type like: new String[size], new Integer[size], etc.
        // Since we don’t know T at compile-time, we still must use reflection to create the array.
        // But to simulate this manually with clazz, we do this:
        if (size == 0) {
            // Return an empty array of type T[]
            return (T[]) java.lang.reflect.Array.newInstance(clazz, 0);
        }

        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, size); // still needed internally

        Node<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }

    public boolean isEmpty(){
        return head == null;
    }

}
