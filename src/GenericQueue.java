public class GenericQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private final Class<T> clazz;
    private int size;

    public GenericQueue(Class<T> clazz){
        this.clazz = clazz;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(T item){
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

    public T peek(){
        if(!isEmpty()){
            return head.data;
        }
        else{
            return null;
        }
    }

    public int size() {
        return size;
    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }

        T dataToReturn = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return dataToReturn;
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

    public boolean isEmpty(){
        return head == null;
    }
}
