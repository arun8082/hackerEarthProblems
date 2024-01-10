package com.debuide;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Amdocs2 {
	static int pthSmallest(int n, int arr[],int p,int x,int z) {
		int res=0;
		List<Integer> list = Arrays.stream(arr).mapToObj(i->i).collect(Collectors.toList());
		List<Integer> l = list.stream().filter(i->{
			if(i%x==z) {
				return true;
			}
			return false;			
		}).collect(Collectors.toList());
		Collections.sort(l);
		int s = l.get(p-1);
		res =list.indexOf(s);		
		return res;
	}
	
	public static void main(String[] args) {
		int n=10;
		int []ar = new int[]{6,42,60,3,11,5,22,75,4,0};
		int p=4;
		int x =2;
		int z =1;
		System.out.println(pthSmallest(n,ar,p,x,z));
	}
}