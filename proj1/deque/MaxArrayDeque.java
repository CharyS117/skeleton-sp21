package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> {
    ArrayDeque<T> deque;
    Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        deque = new ArrayDeque<T>();
        comparator = c;
    }

    public T max(Comparator<T> c) {
        if (deque.isEmpty()) {
            return null;
        }
        T max = deque.get(0);
        for (int i = 1; i < deque.size(); i++) {
            if (c.compare(max, deque.get(i)) < 0) {
                max = deque.get(i);
            }
        }
        return max;
    }

    public T max() {
        return max(comparator);
    }

    public void addFirst(T a) {
        deque.addFirst(a);
    }

    public void addLast(T a) {
        deque.addLast(a);
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public T get(int index) {
        return deque.get(index);
    }

    public int size() {
        return deque.size();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public void printDeque() {
        deque.printDeque();
    }
}
