package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.w3c.dom.NodeList;

// Definition for singly-linked list. 
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	public static String printReverse(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val);
			head = head.next;
		}

		return sb.reverse().toString();
	}
	public static String print(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val);
			head = head.next;
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	
}


public class P002_AddTwoNumbers {
	

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int num1 = Integer.parseInt(ListNode.printReverse(l1));
		int num2 = Integer.parseInt(ListNode.printReverse(l2));
		StringBuilder sb = new StringBuilder((num1 + num2) + "").reverse();
		String[] digits = sb.toString().split("");
		ListNode head = new ListNode(Integer.parseInt(digits[0]));
		ListNode tmp = head;
		ListNode next = null;
		for (int i = 1; i < digits.length; i++) {
			next = new ListNode(Integer.parseInt(digits[i]));
			if (head.next == null) {
				head.next = next;
				tmp = head.next;
			} else {
				tmp.next = next;
				tmp = tmp.next;
			}
		}
		return head;
	}

	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode tmp = null;
		ListNode next = null;
		ListNode t1=l1,t2=l2;
		int rem = 0;
		while (t1 != null || t2 != null) {
			int t = 0;
			if(t2==null) {
				t+=t1.val;
			}else if(t1==null) {
				t+=t2.val;
			}else {
				t+=t1.val+t2.val;
			}
			int sum = (rem+t) % 10;
			rem= (rem+t)/10;
			if (head == null) {
				head = new ListNode(sum);
				tmp=head;
			} else if (head.next == null) {
				next = new ListNode(sum);
				head.next = next;
				tmp = next;
			} else {				
				next = new ListNode(sum);
				tmp.next=next;
				tmp = next;
			}
			if(t1!=null)
				t1=t1.next;
			if(t2!=null)
				t2=t2.next;
		}
		if(rem!=0) {
			next = new ListNode(rem);
			tmp.next=next;
			tmp = next;
		}
		System.out.println("::" + ListNode.printReverse(head));
		return head;
	}

	public static void main(String[] args) {
		/*ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(3);
		l11.next = l12;
		l12.next = l13;
		System.out.println(print(l11));

		ListNode l21 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l23 = new ListNode(4);
		l21.next = l22;
		l22.next = l23;
		System.out.println(print(l21));

		addTwoNumbers2(l11, l21);*/
		
//		List<Integer> i1= Arrays.asList(9,9,9,9,9,9,9);
//		List<Integer> i2= Arrays.asList(9,9,9,9);
		List<Integer> i1= Arrays.asList(5);
		List<Integer> i2= Arrays.asList(5);
		ListNode l1= new ListNode(i1.get(0));
		ListNode tmp=l1;
		for(int i=1;i<i1.size();i++) {
			tmp.next=new ListNode(i1.get(i));
			tmp=tmp.next;
		}
		System.out.println(ListNode.printReverse(l1));
		
		ListNode l2= new ListNode(i1.get(0));
		tmp=l2;
		for(int i=1;i<i2.size();i++) {
			tmp.next=new ListNode(i2.get(i));
			tmp=tmp.next;
		}
		System.out.println(ListNode.printReverse(l2));
		addTwoNumbers2(l1, l2);
	}

}
