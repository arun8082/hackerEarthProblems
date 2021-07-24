package com.debuide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cognigent {
	
	static long minTime(List<Integer>batchSize,List<Integer> processingTime, List<Integer> numTask) {
		List<Long> resList = new ArrayList<Long>();
		for(int i=0;i<numTask.size();i++) {
			long res = 0l;
			Integer cb = batchSize.get(i);//3
			Integer cpTime = processingTime.get(i);//5
			Integer ct = numTask.get(i);//8
			int rem = ct%cb;
			int div = ct/cb;
			if(rem == 0) {
				res =  (div*cpTime);
			}else {
				res =  ((div+1)*cpTime);
			}			
			resList.add(res);
			
		}
		return Collections.max(resList);
	}
	
	
	public static void main(String[] args) {
		List<Integer> batchSize = Arrays.stream(new int[] {3,2,5,7}).boxed().collect(Collectors.toList());
		List<Integer> processingTime = Arrays.stream(new int[] {5,4,10,12}).boxed().collect(Collectors.toList());
		List<Integer> numTask = Arrays.stream(new int[] {10,6,10,5}).boxed().collect(Collectors.toList());
		
		System.out.println(minTime(batchSize, processingTime, numTask));
	}

}
