package leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class P021_MergeTwoSortedLists {

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode res = new ListNode();
		ListNode head = res;

		while (list1!=null || list2!=null) {
			if (list1 != null && list2 != null && list1.val <= list2.val) {
				res.next = new ListNode(list1.val);
				list1 = list1.next;
			} else if (list1 == null && list2 != null) {
				res.next = new ListNode(list2.val);
				list2 = list2.next;
			} else if (list2 == null && list1 != null) {
				res.next = new ListNode(list1.val);
				list1 = list1.next;
			} else {
				res.next = new ListNode(list2.val);
				list2 = list2.next;
			}
			res = res.next;
		}
		System.out.println("final==>" + list1 + "\n" + list2 + "\n");
		return head.next;
	}

	public static void main(String[] args) {
//		List<Integer> i1 = Arrays.asList(1,2,4);
//		List<Integer> i2 = Arrays.asList(1,3,4);

		List<Integer> i1 = Arrays.asList(2);
		List<Integer> i2 = Arrays.asList(1);

		ListNode l1 = new ListNode(i1.get(0));
		ListNode tmp = l1;
		for (int i = 1; i < i1.size(); i++) {
			tmp.next = new ListNode(i1.get(i));
			tmp = tmp.next;
		}

		ListNode l2 = new ListNode(i2.get(0));
		tmp = l2;
		for (int i = 1; i < i2.size(); i++) {
			tmp.next = new ListNode(i2.get(i));
			tmp = tmp.next;
		}
//		ListNode res = mergeTwoLists(l1, l2);
		ListNode res = mergeTwoLists(null, l2);
//		ListNode res = mergeTwoLists(l1, null);
//		ListNode res = mergeTwoLists(null, null);
//		ListNode res = mergeTwoLists(l1, l2);
		System.err.println(res);
		System.out.println(ListNode.print(res));
	}

}
