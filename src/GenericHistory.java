public class GenericHistory<T> {
    private Node<T> head;
    private Node<T> tail;
    private final Class<T> clazz;
    private int size;

    public GenericHistory(Class<T> clazz){
        this.clazz = clazz;
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
        size++;
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
