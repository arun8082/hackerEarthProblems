package leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class P024_SwapNodesinPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		else if (head.next == null)
			return head;
		else if (head.next.next == null) {
			ListNode t = head.next;
			head.next = null;
			t.next = head;
			return t;
		} else {
	        ListNode dummy = new ListNode(0,head);
	        ListNode current = dummy;
	        while (current.next != null && current.next.next != null) {
	            ListNode first = current.next;
	            ListNode second = current.next.next;
	            first.next = second.next;
	            current.next = second;
	            current.next.next = first;
	            current = current.next.next;
	        }
	        return dummy.next;
		}
	}

	public static void main(String[] args) {
		List<Integer> i1 = Arrays.asList(1, 2, 3, 4, 5);
		ListNode l1 = new ListNode(i1.get(0));
		ListNode tmp = l1;

		for (int i = 1; i < i1.size(); i++) {
			tmp.next = new ListNode(i1.get(i));
			tmp = tmp.next;
		}
		System.err.println(l1);
		ListNode res = swapPairs(l1);
		System.out.println("==>" + res);
	}

}
