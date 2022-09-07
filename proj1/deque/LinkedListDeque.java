package deque;

public class LinkedListDeque<Item> implements Deque<Item> {
    private class LinkNode {
        public LinkNode previous;
        public LinkNode next;
        Item content;
    }

    private LinkNode head;
    private int size;

    public LinkedListDeque() {
        head = new LinkNode();
        head.next = head;
        head.previous = head;
        size = 0;
    }

    public void addFirst(Item i) {
        LinkNode newNode = new LinkNode();
        newNode.content = i;
        newNode.next = head.next;
        head.next.previous = newNode;
        newNode.previous = head;
        head.next = newNode;
        size++;
    }

    public void addLast(Item i) {
        LinkNode newNode = new LinkNode();
        newNode.content = i;
        newNode.previous = head.previous;
        head.previous.next = newNode;
        newNode.next = head;
        head.previous = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkNode cur = head.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(cur.content);
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.print(cur.content);
        System.out.print("\n");
    }

    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Item pop = head.next.content;
        head.next.next.previous = head;
        head.next = head.next.next;
        size--;
        return pop;
    }

    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        Item pop = head.previous.content;
        head.previous.previous.next = head;
        head.previous = head.previous.previous;
        size--;
        return pop;
    }

    public Item get(int index) {
        if (index >= size) {
            return null;
        }
        LinkNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.content;
    }
}
