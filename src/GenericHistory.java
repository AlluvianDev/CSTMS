public class GenericHistory<T> {
    private Node<T> head;
    private Node<T> tail;
    private final Class<T> clazz;
    private int size;

    public GenericHistory(Class<T> clazz){
        this.clazz = clazz;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T item){
        Node<T> newNode = new Node<>(item);
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
        return size;
    }

    @SuppressWarnings("unchecked")
    public T[] getAll() {
        if (size == 0) {
            return (T[]) java.lang.reflect.Array.newInstance(clazz, 0);
        }

        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, size);

        Node<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }

    public void display(){
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
