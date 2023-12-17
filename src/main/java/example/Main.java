package example;

public class Main {
    public static void main(String[] args) {
            Node<Integer> node1 = new Node<>(56);
            Node<Integer> node2 = new Node<>(30);
            Node<Integer> node3 = new Node<>(70);
            node1.next = node2;
            node2.next = node3;

            Node<Integer> node = node1;
            while (node != null) {
                System.out.print(node.data+ " ");
                node = node.next;
            }
        }
    }
