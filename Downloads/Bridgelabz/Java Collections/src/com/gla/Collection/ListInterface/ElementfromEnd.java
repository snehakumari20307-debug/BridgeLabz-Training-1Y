package com.gla.Collection.ListInterface;
class ListNode {
    char val;
    ListNode next;

    ListNode(char val) {
        this.val = val;
        this.next = null;
    }
}

public class ElementfromEnd {

    public static char ElementfromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // move fast n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("N is larger than list size");
            }
            fast = fast.next;
        }

        // move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }

    public static void main(String[] args) {
        // A -> B -> C -> D -> E
        ListNode head = new ListNode('A');
        head.next = new ListNode('B');
        head.next.next = new ListNode('C');
        head.next.next.next = new ListNode('D');
        head.next.next.next.next = new ListNode('E');

        int n = 2;
        System.out.println(ElementfromEnd(head, n)); // Output: D
    }
}

