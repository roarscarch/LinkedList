package example;
/*
* To create a simple Linked List we dont need
* a seperate linked list class but to use features like add at head or
* add at tail we need a linked list class
*
*
* */

public class LinkedList<T extends Comparable> {
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

    public void insertAfter(T existingValue, T newValue) {
        Node<T> newNode = new Node<>(newValue);

        if (head != null) {
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(existingValue)) {
                    newNode.next = current.next;
                    current.next = newNode;

                    if (current == tail) {
                        // If inserting after the tail, update the tail to the new node
                        tail = newNode;
                    }

                    break;
                }
                current = current.next;
            }
        } else {
            System.out.println("Cannot insert after in an empty list.");
        }
    }

    public void delete(T value) {
        if (head != null) {
            // Handle the case where the value to delete is the head
            if (head.data.equals(value)) {
                head = head.next;
                if (head == null) {
                    // If the list becomes empty after deletion, update the tail to null
                    tail = null;
                }
                return;
            }

            // Traverse the list to find the node before the node with the specified value
            Node<T> current = head;
            while (current.next != null && !current.next.data.equals(value)) {
                current = current.next;
            }

            if (current.next != null) {
                // Update the next reference to skip the node with the specified value
                current.next = current.next.next;

                if (current.next == null) {
                    // If the deleted node was the tail, update the tail to the previous node
                    tail = current;
                }
            } else {
                System.out.println("Value " + value + " not found in the list.");
            }
        } else {
            System.out.println("Cannot delete from an empty list.");
        }
    }

    public void addInOrder(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null || data.compareTo(head.data) < 0) {
            // If the list is empty or the new data is smaller than the head, insert at the head
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                // If the list was empty, update the tail to the new node
                tail = newNode;
            }
        } else {
            Node<T> current = head;

            while (current.next != null && data.compareTo(current.next.data) >= 0) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;

            if (current == tail) {
                // If inserting after the tail, update the tail to the new node
                tail = newNode;
            }
        }
    }
}
