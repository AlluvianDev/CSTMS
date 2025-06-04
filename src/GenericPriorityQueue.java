public class GenericPriorityQueue<T extends Comparable<T>> {
    private GenericQueue<T> highPriority;
    private GenericQueue<T> mediumPriority;
    private GenericQueue<T> lowPriority;

    public GenericPriorityQueue() {
        highPriority = new GenericQueue<>();
        mediumPriority = new GenericQueue<>();
        lowPriority = new GenericQueue<>();
    }

    public void offer(T item) {
        String priority = item.toString().toLowerCase();
        if (priority.contains("high")) {
            highPriority.enqueue(item);
        } else if (priority.contains("medium")) {
            mediumPriority.enqueue(item);
        } else if (priority.contains("low")) {
            lowPriority.enqueue(item);
        } else {
            throw new IllegalArgumentException("Unknown priority level in: " + item);
        }
    }

    public T poll() {
        if (!highPriority.isEmpty()) return highPriority.dequeue();
        if (!mediumPriority.isEmpty()) return mediumPriority.dequeue();
        if (!lowPriority.isEmpty()) return lowPriority.dequeue();
        return null;
    }

    public boolean isEmpty() {
        return highPriority.isEmpty() && mediumPriority.isEmpty() && lowPriority.isEmpty();
    }

    public java.util.List<T> getAll() {
        java.util.List<T> result = new java.util.ArrayList<>();
        result.addAll(highPriority.getAll());
        result.addAll(mediumPriority.getAll());
        result.addAll(lowPriority.getAll());
        return result;
    }
}
