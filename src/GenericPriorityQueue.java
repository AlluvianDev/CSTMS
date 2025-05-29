public class GenericPriorityQueue<T extends Comparable<T>> {
    GenericQueue<T> highQueue ;
    GenericQueue<T> mediumQueue ;
    GenericQueue<T> lowQueue ;

    public GenericPriorityQueue(){
        highQueue = new GenericQueue<>();
        mediumQueue = new GenericQueue<>();
        lowQueue = new GenericQueue<>();
    }

    public void offer(T item){  //item will be the customer ==> new,CustomerName,IssueDescription,Priority
        String str = item.toString().toLowerCase();   //Priority will be pulled out from item and used here

        if (str.contains("high")){
            highQueue.enqueue(item);
        }
        if (str.contains("medium")){
            mediumQueue.enqueue(item);
        }
        if (str.contains("low")){
            lowQueue.enqueue(item);
        }
    }

    public T poll(){
        if(!highQueue.isEmpty()){    //dequeues from high to low priority
            return highQueue.dequeue();
        }
        if(!mediumQueue.isEmpty()){
            return mediumQueue.dequeue();
        }
        if(!lowQueue.isEmpty()){
            return lowQueue.dequeue();
        }
        return null;
    }
    public boolean isEmpty(){ //if all are empty return true
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
        for (T item: highItems){
            result[index] = item;
            index++;
        }
        for (T item: highItems){
            result[index] = item;
            index++;
        }
        for (T item: highItems){
            result[index] = item;
            index++;
        }
        return result;
    }
}
