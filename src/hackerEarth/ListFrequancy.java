package hackerEarth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ListFrequancy {
	@Override
	public int hashCode() {
		System.out.println("s");
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("d");
		return super.equals(obj);
	}
	public static void main(String[] args) {
		//List<Integer> list= new ArrayList<Integer>();
		//Set<Integer> list= new TreeSet<Integer>();
		Set<Integer> list = new HashSet<Integer>();
		System.out.println("size: "+list.size()+" capacity: ");
		System.out.println("10"+list.add(10));
		System.out.println("20"+list.add(20));
		System.out.println("30"+list.add(30));
		System.out.println("20"+list.add(20));
		System.out.println("50"+list.add(50));
		System.out.println("20"+list.add(20));
		System.out.println("70"+list.add(70));
		System.out.println("90"+list.add(null));
		System.out.println("90"+list.add(null));
		int i =10;
		System.out.println(list);
		System.out.println("ele: "+i+" frequancy: "+Collections.frequency(list, i));
	}
}
