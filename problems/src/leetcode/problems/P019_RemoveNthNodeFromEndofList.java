package leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class P019_RemoveNthNodeFromEndofList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tmp=head;
		if(tmp==null) {
			return head;
		}else if(tmp.next==null) {
			return null;
		}
		int size=1;
		while(tmp.next!=null) {
			size++;
			tmp=tmp.next;
		}
		int i=1;
		tmp=head;
		ListNode prev=head;
		if(size==n) {
			return head.next;
		}

		while (i!=(size-n+1) && tmp!=null) {
			prev=tmp;
			tmp=tmp.next;
			i++;
		}		
		prev.next=tmp.next;	
		
		return head;
	}

	public static void main(String[] args) {
//		List<Integer> i1= Arrays.asList(1,2,3,4,5);
		List<Integer> i1= Arrays.asList(1);
//		List<Integer> i1= Arrays.asList(1,2);
//		List<Integer> i1= Arrays.asList(1,2,3);
		ListNode l1= new ListNode(i1.get(0));
		ListNode tmp=l1;
		for(int i=1;i<i1.size();i++) {
			tmp.next=new ListNode(i1.get(i));
			tmp=tmp.next;
		}
//		System.out.println(ListNode.print(l1));
//		ListNode head= removeNthFromEnd(l1, 2);
		ListNode head= removeNthFromEnd(l1, 1);
//		ListNode head= removeNthFromEnd(l1, 3);
		System.out.println(ListNode.print(head));

	}

}
