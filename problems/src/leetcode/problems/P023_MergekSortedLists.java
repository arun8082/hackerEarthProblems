package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P023_MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null;
		List<Integer> l = new ArrayList<Integer>();
		for (ListNode node : lists) {
			while (node != null) {
				l.add(node.val);
				node = node.next;
			}
		}
		Collections.sort(l);
		if(l.size()==0) return null;
		head = new ListNode(l.get(0));
		ListNode tmp = head;
		for (int i = 1; i < l.size(); i++) {
			tmp.next = new ListNode(l.get(i));
			tmp = tmp.next;
		}
		return head;
	}

	public static void main(String[] args) {

	}

}
