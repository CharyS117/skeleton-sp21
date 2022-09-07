package deque;

public interface Deque<Item> {
    public int size();
    public void addLast(Item item);
    public void addFirst(Item item);
    public Item removeLast();
    public Item removeFirst();
    public Item get(int index);
    public void printDeque();
    public default boolean isEmpty() {
        return size() == 0;
    }
}
