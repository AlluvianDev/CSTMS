import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericHistory<T> {
    private List<T> history;

    public GenericHistory() {
        history = new ArrayList<>();
    }

    public void add(T item) {
        history.add(item);
    }

    public List<T> getAll() {
        return new ArrayList<>(history);
    }

    public void display() {
        for (T item : history) {
            System.out.println(item);
        }
    }

    public void displaySortedByName(Comparator<T> comparator) {
        List<T> copy = new ArrayList<>(history);
        copy.sort(comparator);
        for (T item : copy) {
            System.out.println(item);
        }
    }

    public void displaySortedByTime(boolean ascending) {
        List<T> copy = new ArrayList<>(history);
        if (ascending) Collections.reverse(copy); // since added in order, reverse for DESC
        for (T item : copy) {
            System.out.println(item);
        }
    }
}
