package com.linkedlist.easy;

import com.linkedlist.ListNode;
import com.linkedlist.operations.LinkedList;

public class LinkedListI {
    public static void main(String[] args) {
        LinkedListI obj = new LinkedListI();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(5);

        ListNode res = obj.mergeTwoLists(node1, node2);
        LinkedList linkedList = new LinkedList();
        linkedList.printElements(res);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while( l1 != null && l2 != null ){
            if( l1.val < l2.val ){
                dummy.next = l1;
                l1 = l1.next;
            }else if ( l1.val == l2.val ){
                dummy.next = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if( l1 != null ){
            dummy.next = l1;
        }else{
            dummy.next = l2;
        }
        return head.next;
    }
}
