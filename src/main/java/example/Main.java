package example;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
//            Node<Integer> node1 = new Node<>(56);
//            Node<Integer> node2 = new Node<>(30);
//            Node<Integer> node3 = new Node<>(70);
//            node1.next = node2;
//            node2.next = node3;
//
//            Node<Integer> node = node1;
//            while (node != null) {
//                System.out.print(node.data+ " ");
//                node = node.next;
//            }

        LinkedList<Integer> list = new LinkedList<>();
        list.pop();
        list.addAtTail(70);
        list.addAtTail(30);
        list.addAtTail(56);
        list.insertAt(2,77);
        System.out.println(list);
        list.pop();
        System.out.println(list);
        list.popLast();
        System.out.println(list);
        list.insertAfter(30,677);


        if(list.search(677)==null){
            System.out.println("Data Not found");
        }
        else{
            System.out.println("Data Found");
        }

        System.out.println(list);

        LinkedList<Integer>list2= new LinkedList<>();
        list.delete(30);
        System.out.println(list);
        list2.addInOrder(86);
        list2.addInOrder(23);
        list2.addInOrder(767);
        System.out.println(list2);

        }




    }
