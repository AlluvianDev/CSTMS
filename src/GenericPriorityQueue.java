public class GenericPriorityQueue<T extends Comparable<T>> {
    
    GenericQueue<T> lowQueue;
    GenericQueue<T> mediumQueue;
    GenericQueue<T> highQueue;

    private final Class<T> clazz;

    public GenericPriorityQueue(Class<T> clazz){
        this.clazz = clazz;
        highQueue = new GenericQueue<>(clazz);
        mediumQueue = new GenericQueue<>(clazz);
        lowQueue = new GenericQueue<>(clazz);
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
    public T[] getAll() {
        T[] highItems = highQueue.getAll();
        T[] mediumItems = mediumQueue.getAll();
        T[] lowItems = lowQueue.getAll();

        int totalSize = highItems.length + mediumItems.length + lowItems.length;

        // Proper way to create generic array of type T
        T[] result = (T[]) java.lang.reflect.Array.newInstance(clazz, totalSize);

        int index = 0;
        for (T item : highItems) result[index++] = item;
        for (T item : mediumItems) result[index++] = item;
        for (T item : lowItems) result[index++] = item;

        return result;
    }
}
