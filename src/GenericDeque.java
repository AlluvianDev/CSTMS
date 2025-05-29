public class GenericDeque<T> {
        private Node<T> head;
        private Node<T> tail;
        public GenericDeque(){
            this.head = null;
            this.tail = null;

        }
        public void addFront(T item){
            Node<T> newNode = new Node<>(item);
            if(isEmpty()){
                head = newNode;
                tail = newNode;
            }
            else {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            }
        }
        public void addBack(T item){
            Node<T> newNode = new Node<>(item);
            if(isEmpty()){
                head = newNode;
                tail = newNode;
            }
            else {
                newNode.previous = tail;
                tail.next = newNode;
                tail = newNode;
            }
        }
        public T removeFront(){
            if(isEmpty()){
                return null;
            }
            else{
                T dataToReturn = head.data; // sets head.data to a temporary value, then removes head from the queue
                head = head.next;
                if (head == null) {
                    tail = null;
                }
                return dataToReturn;
            }
        }
        public T removeBack(){
            if(isEmpty()){
                return null;
            }
            else{
                T dataToReturn = tail.data; // sets tail.data to a temporary value, then removes head from the queue

                if (tail == head) {
                    head = null;
                    tail = null;
                }
                else{
                    tail = tail.previous;
                    tail.next = null;
                }
                return dataToReturn;
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
    public T peekBack() {
        if(!isEmpty()){
            return tail.data;
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

        public boolean isEmpty(){
            return head == null;
        }
        public void display(){ //	Prints the deque from front to back.
            Node<T> current = head;
            System.out.print("Deque: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
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
    }

