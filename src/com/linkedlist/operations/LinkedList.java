package com.linkedlist.operations;

import com.linkedlist.ListNode;

public class LinkedList {

    ListNode head = null;
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
//        list.addElement(1);
//        list.addElement(2);
//        list.addElement(3);
//        list.addElement(4);
//        list.addElement(6);
//        list.addElement(8);
//        list.addElement(9);
//        list.addElement(16);
//        list.addElement(63);

        list.printElements();

    }

    public void addElement( ListNode head, int element){
        if( head == null){
            head = new ListNode(element);
        }else{
            ListNode current = head;
            while ( current.next != null){
                current = current.next;
            }

            ListNode node  = new ListNode(element);
            current.next = node;
        }
    }

    public void printElements(){
        if( head == null){
            System.out.println(" List is empty. ");
        }

        while ( head != null ){
            System.out.print( head.val + " ");
            head = head.next;
        }
    }

    public void printElements(ListNode head1){
        if( head1 == null){
            System.out.println(" List is empty. ");
        }

        while ( head1 != null ){
            System.out.print( head1.val + " ");
            head1 = head1.next;
        }
    }
    public ListNode getHead() {
        return head != null ? head :  new ListNode(5);
    }




}
