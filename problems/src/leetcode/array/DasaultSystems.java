package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DasaultSystems {
	static private int p=10; 
	static class A{
		@Override
		public String toString() {			
			return p+"";
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums = {11,7,6,4,3,3,4,9,10};
		
		int max = Arrays.stream(nums).max().getAsInt();
		DasaultSystems.A a = new A();
		System.out.println(a);
		
		System.out.println();
		
//		System.out.println(Arrays.toString(filterDuplicates(nums)));
//		System.out.println(discount(new int[] {100,400,200},20));
//		System.out.println(discount(new int[] {10,20,5,1,2},10));
		
	}
	static int discount(int[]p,int discount) {
		List<Integer> list = Arrays.stream(p).mapToObj(i->new Integer(i)).collect(Collectors.toList());
		int max = Collections.max(list);
		list.remove(new Integer(max));
		double dis = ((max*1.0/100)*discount);
		double d = (max*1.0)-dis;
		for(int i:list) {
			d +=i; 
		}
		return (int)Math.floor(d);
	}
	
	static int[] filterDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < nums.length; j++) {
			if(!list.contains(nums[j])) {
				list.add(nums[j]);
			}
		}
		
		return list.stream().mapToInt(i->i).toArray();
	}
}
