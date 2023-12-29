package example;
/*
* To create a simple Linked List we dont need
* a seperate linked list class but to use features like add at head or
* add at tail we need a linked list class
*
*
* */

public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addAtHead(T data) {
        Node<T> node = new Node<>(data);
        // case 1 - when ll is empty
        if (head == null) {
            head = node;
            tail = node;
        } else {
            // case 2 - when there is already something
            node.next = head;
            head = node;
        }
    }

    public void addAtTail(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            // case 1 - when ll is empty
            head = node;
            tail = node;
        } else {
            // case 2 - when there is already something
            tail.next = node;
            tail = node;
        }
    }

    public void insertAt(int index, T data) {
        if (index < 0 || index > this.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            // insert at head
            addAtHead(data);
        } else if (index == this.size()) {
            // insert at tail
            addAtTail(data);
        } else {
            // insert at specific index
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int size() {
        Node<T> current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder linkedList = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            linkedList.append(current.data).append("--->  ");
            current = current.next;
        }
        return linkedList.toString();
    }

    public void pop() {
        if (head != null) {
            head = head.next;
            if (head == null) {
                // If the list becomes empty after popping, update the tail to null.
                tail = null;
            }
        } else {
            System.out.println("Cannot pop from an empty list.");
        }
    }

    public void popLast() {
        if (head != null) {
            if (head == tail) {
                // If there's only one element in the list, both head and tail should be null after removal.
                head = null;
                tail = null;
            } else {
                // Traverse the list to find the second-to-last node
                Node<T> current = head;
                while (current.next != tail) {
                    current = current.next;
                }

                // Update the tail and remove the last node
                tail = current;
                tail.next = null;
            }
        } else {
            System.out.println("Cannot pop from an empty list.");
        }
    }
    public Node<T> search(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return current; // Found the node with the specified value
            }
            current = current.next;
        }
        return null; // Value not found in the LinkedList
    }
}
