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
       // cas1- when ll is empty
        if (head == null) {
            head = node;
            tail = node;
        } else {
            // case 2 when there is already something
            node.next = head;
            head = node;
        }
    }

    @Override
    public String toString() {
        String linkedList = "";
        Node<T> node = head;
        while (node != null) {
            linkedList += node.data + "--->  ";
            node = node.next;
        }
        return linkedList;
    }
}
