package com.recursion.Iteration;

import com.linkedlist.ListNode;
import com.linkedlist.operations.LinkedList;

public class ReverseAList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        ListNode head = new ListNode(9);
        l1.addElement(head, 1);
        l1.addElement(head, 2);
        l1.addElement(head, 3);
        l1.addElement(head, 4);
        l1.addElement(head, 5);
        System.out.println("Before reverse");
        l1.printElements(head);
        ReverseAList list = new ReverseAList();
        System.out.println("\nAfter reverse");
        list.reverseRecursively(head);
    }

    public void reverseRecursively(ListNode node){
        if( node == null)
            return;
        reverseRecursively(node.next);
        System.out.print(node.val+" ");
    }
}
