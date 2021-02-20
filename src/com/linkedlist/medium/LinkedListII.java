package com.linkedlist.medium;

import com.linkedlist.ListNode;
import com.linkedlist.operations.LinkedList;

//Reverse a list [1,2,3,4,50
public class LinkedListII {

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        ListNode head = new ListNode(9);
        l1.addElement(head, 1);
        l1.addElement(head, 2);
        l1.addElement(head, 3);
        l1.addElement(head, 4);
        l1.addElement(head, 5);
        l1.printElements(head);

        LinkedListII l11 = new LinkedListII();
        System.out.println("Applying recursion" +
                "");
        l11.recursiveReverse(head);
        ListNode res = l11.reverseList(head);
      //  System.out.println();
      //  l1.printElements(res);

    }

    public void recursiveReverse(ListNode head){
        if( head == null)
            return;
        recursiveReverse(head.next);
        System.out.print(head.val+" ");

    }

    public ListNode reverseList(ListNode head){
         if( head == null || head.next == null)
             return head;

         ListNode current = head;
         ListNode next = null;
         ListNode prev = null;

         while ( current != null){
             next = current.next;
             current.next = prev;
             prev = current;
             current = next;
         }
//         prev = current;
         return prev;
    }

}
