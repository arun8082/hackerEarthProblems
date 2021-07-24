package com.debuide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NoOfDigitSegmentLed {

		static int Solve(int Length,String N) {
			int arr[][]= {
					{1,1,1,1,1,1,0},
					{0,1,1,0,0,0,0},
					{1,1,0,1,1,0,1},
					{1,1,1,1,0,0,1},
					{0,1,1,0,0,1,1},
					{1,0,1,1,0,1,1},
					{0,0,1,1,1,1,1},
					{1,1,1,0,0,0,0},
					{1,1,1,1,1,1,1},
					{1,1,1,0,0,1,1}
			};
			List<List<Integer>> seg =Arrays.stream(arr).
					map(r->Arrays.stream(r).boxed().collect(Collectors.toList()))
					.collect(Collectors.toList());
			
			int ch=Integer.parseInt(N.charAt(0)+"");
			List<Integer>prev=seg.get(ch);
			int res=Collections.frequency(prev, 1);
			int sum=res;
			for(int i=1;i<Length;i++)
			{
				int cur=Integer.parseInt(N.charAt(i)+"");
				List<Integer>current=seg.get(cur);
				int reqLed=getreqLed(prev,current);
				sum+=reqLed;
				prev = current;
			}
			return sum;
		}

	static int getreqLed(List<Integer> prev, List<Integer> current) {
		int count=0;
		for(int i=0;i<prev.size();i++)
		{
			if(prev.get(i)!=current.get(i))
			{
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Solve(2, "013"));
	}
}
