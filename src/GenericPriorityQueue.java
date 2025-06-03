public class GenericPriorityQueue<T extends Comparable<T>> {
    GenericQueue<T> highQueue;
    GenericQueue<T> mediumQueue;
    GenericQueue<T> lowQueue;

    public GenericPriorityQueue(){
        highQueue = new GenericQueue<>();
        mediumQueue = new GenericQueue<>();
        lowQueue = new GenericQueue<>();
    }

    public void offer(T item){
        String str = item.toString().toLowerCase();

        if (str.contains("high")){
            highQueue.enqueue(item);
        }
        else if (str.contains("medium")){
            mediumQueue.enqueue(item);
        }
        else if (str.contains("low")){
            lowQueue.enqueue(item);
        }
    }

    public T poll(){
        if(!highQueue.isEmpty()){
            return highQueue.dequeue();
        }
        else if(!mediumQueue.isEmpty()){
            return mediumQueue.dequeue();
        }
        else if(!lowQueue.isEmpty()){
            return lowQueue.dequeue();
        }
        return null;
    }

    public boolean isEmpty(){
        return highQueue.isEmpty() && mediumQueue.isEmpty() && lowQueue.isEmpty();
    }

    @SuppressWarnings("unchecked")
    public T[] getAll(){
        T[] highItems = highQueue.getAll();
        T[] mediumItems = mediumQueue.getAll();
        T[] lowItems = lowQueue.getAll();

        int totalSize = highItems.length + mediumItems.length + lowItems.length;
        T[] result = (T[]) new Comparable[totalSize];

        int index = 0;

        // High priority items
        for (T item: highItems){
            result[index] = item;
            index++;
        }

        // Medium priority items
        for (T item: mediumItems){
            result[index] = item;
            index++;
        }

        // Low priority items
        for (T item: lowItems){
            result[index] = item;
            index++;
        }

        return result;
    }
}