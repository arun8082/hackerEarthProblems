package test;

import java.util.Arrays;

public class GenerateAllBinaryStrings {

	public static void main(String[] args) {
		String str="1##0#101";
		int pos[]=new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='#') {
				pos[i]=1;
			}
		}
		//System.out.println(Arrays.toString(pos));
		for (int i = 0; i < pos.length; i++) {
			String temp=str;
			if(i==1) {
				String str1=str.replace("#", "0");
				String str2=str.replaceFirst("#", "1");
				str=str2;
				str1=str1.replaceAll("#", "0");
				str2=str2.replaceAll("#", "0");
				System.out.println(str1);
				System.out.println(str2);
			}
		}
	}	
}
