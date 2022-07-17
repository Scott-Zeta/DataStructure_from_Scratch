import java.util.List;
import java.util.ArrayList;

public class P_Queue<T extends Comparable<T>> {
    private List<T> heap;

    public P_Queue(int size) {
        heap = new ArrayList<T>(size);
    }

    public P_Queue() {
        this(1);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        return heap.get(0);
    }

    public boolean contains(T element) {
        for (int i = 0; i < size(); i++) {
            if (heap.get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean lessOrEqual(int index1, int index2) {
        T node1 = heap.get(index1);
        T node2 = heap.get(index2);
        return node1.compareTo(node2) <= 0;
    }

    public void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public boolean isP_Queue(int root) {
        if (root > size()) {
            return true;
        }

        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size() && !lessOrEqual(root, left)) {
            return false;
        }

        if (right < size() && !lessOrEqual(root, right)) {
            return false;
        }

        return isP_Queue(left) && isP_Queue(right);
    }

    public void rise(int pinpoint) {
        int parent = (pinpoint - 1) / 2;

        while (pinpoint > 0 && !lessOrEqual(parent, pinpoint)) {
            swap(parent, pinpoint);
            pinpoint = parent;
            parent = (pinpoint - 1) / 2;
        }
    }

    public void fall(int pinpoint) {
        while (true) {
            int left = pinpoint * 2 + 1;
            int right = pinpoint * 2 + 2;

            int smaller = left;
            if (right < size() && lessOrEqual(right, left)){
                smaller = right;
            }

            if (smaller >= size() || lessOrEqual(pinpoint, smaller)){
                break;
            }

            swap(pinpoint, smaller);
            pinpoint = smaller;
        }
    }
}
