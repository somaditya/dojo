package com.scaler.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);

        PalindromeList pl = new PalindromeList();
        System.out.println(pl.lPalin(head));
    }
    public int lPalin(ListNode A) {
        List<Integer> list = toArray(A);

        int l = 0;
        int r = list.size() - 1;

        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return 0;
            }
            l++;
            r--;
        }

        return 1;
    }

    public List<Integer> toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
