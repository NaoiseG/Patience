import java.util.LinkedList;

public abstract class CardCollection<T> { // Card or pile lists
    protected LinkedList<T> items = new LinkedList<>();  // Use LinkedList to store items

    public void add(T item) {
        items.add(item);
    }

    public void removeTop() {
        if (!items.isEmpty()) {
            items.removeLast();  // Remove the last item
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);  // Remove item at specified index
        }
    }

    public void clear() {
        items.clear();  // Clear the collection
    }

    public T get(int index) {
        if (!items.isEmpty() && index >= 0 && index < items.size()) {
            return items.get(index);  // Get item at specified index
        }
        return null;
    }

    public T getTop() {
        if (!items.isEmpty()) {
            return items.getLast();  // Get the last item
        }
        return null;
    }

    public int size() {
        return items.size();  // Return the number of items in the collection
    }


}
