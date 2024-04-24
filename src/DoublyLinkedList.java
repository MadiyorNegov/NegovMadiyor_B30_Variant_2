import java.util.Objects;

public class  DoublyLinkedList<E> {
    private Node head;
    private Node last;
    private int size;

    private class Node {
        E value;
        Node next;
        Node prev;

        public Node(E value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(E value) {
            this.value = value;
        }
    }

    public void add(E element) {
        if (Objects.isNull(head)) {
            head = new Node(element);
            last = head;
            size++;
            return;
        }

        last.next = new Node(element);
        last.next.prev = last;
        last = last.next;
        size++;
    }

    public void remove(int index) {
        removeObj(nodeInd(index));
    }

    private void removeObj(Node node) {

        if (node == null) {
            return;
        }
        if (node == head) {
            head = node.next;
        }
        if (node == last) {
            last = node.prev;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        node.prev = null;
        node.next = null;
    }

    private Node nodeInd(int index) {
        int i = 0;
        for (Node x = head; x != null; x = x.next) {
            if (index == i) {
                return x;
            }
            i++;

        }
        return null;
    }

    public E get(int index) {
        if (index < 0 || index <= size) {
            throw new IndexOutOfBoundsException("Index" + index + "Size " + size);
        }
        int j = 0;
        for (Node i = head; i != null; i = i.next) {
            if (index == j) {
                return i.value;
            }
            j++;
        }
        return null;
    }


    public boolean contains(E element) {
        int index = 0;
        for (Node i = head; i != null; i = i.next) {
            if (i.value.equals(element)) {
                return true;
            }
            index++;
        }

        return false;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(23);
        doublyLinkedList.add(34);
        doublyLinkedList.add(45);
        doublyLinkedList.add(6);

        System.out.println(doublyLinkedList.get(1));
        doublyLinkedList.remove(3);
        System.out.println(doublyLinkedList.get(3));
        System.out.println(doublyLinkedList.contains(23));
        System.out.println(doublyLinkedList.contains(98));
    }
}
