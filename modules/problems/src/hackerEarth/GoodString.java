package hackerEarth;

import java.util.Arrays;

public class GoodString {

	public static void main(String[] args) {
		String str= "abcddasfhjjpoiuytre";
        char []array = str.toCharArray();
        String []finalarr=new String[10];
        String finals="";
        int j=0;
        for(int i =0; i<array.length-1;i++){
        	
            if(array[i]!=array[i+1]){
                finals +=array[i];
            }else{
            	finals +=array[i];
                finalarr[j++]=finals;
                finals="";
            }
            if(i==array.length-2 && finals !="") {
            	finals +=array[i+1];
                finalarr[j++]=finals;
                finals="";
            }
        }
        if(j==0) {
        	finals +=array[array.length-1];
        	finalarr[j++]=finals;
        }
        System.out.println(Arrays.deepToString(finalarr));
        String max=finalarr[0];
        for(int i=1; i<finalarr.length;i++) {
        	if(finalarr[i]!=null && max.length()<finalarr[i].length()) {
        		max=finalarr[i];
        	}
        }
        System.out.println(max);
	}

}
