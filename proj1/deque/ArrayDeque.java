package deque;

import sun.tools.tree.NewArrayExpression;

public class ArrayDeque<Item> implements Deque<Item> {
    int size;
    Item[] content;
    public ArrayDeque() {
        content = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int length) {
        Item[] newArray = (Item[]) new Object[length];
        System.arraycopy(content, 0, newArray, 0, size);
        content = newArray;
    }

    public void addFirst(Item a) {
        if (size == content.length) {
            resize(content.length * 2);
        }
        Item[] newArray = (Item[]) new Object[content.length];
        System.arraycopy(content, 0, newArray, 1, size);
        content[0] = a;
        size++;
    }

    public void addLast(Item a) {
        if (size == content.length) {
            resize(content.length * 2);
        }
        content[size] = a;
        size++;
    }

    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size <= content.length / 4) {
            resize(content.length / 2);
        }
        Item removed = content[0];
        Item[] newArray = (Item[]) new Object[content.length];
        System.arraycopy(content, 1, newArray, 0, size - 1);
        content = newArray;
        size--;
        return removed;

    }

    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        if (size <= content.length / 4) {
            resize(content.length / 2);
        }
        Item removed = content[size - 1];
        size--;
        return removed;
    }

    public Item get(int index) {
        if (index >= size) {
            return null;
        }
        return content[index];
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        if(size==0){
            System.out.print("\n");
            return;
        }
        for (int i = 0;i<size-1;i++){
            System.out.print(content[i]);
            System.out.print(" ");
        }
        System.out.print(content[size-1]);
        System.out.print("\n");
    }
}
