package Test;

public class SlidingWindow {
	public static void main(String[] args) {		
		String str = "abcdefghijk";
		char []a = str.toCharArray();
		int k=4;
		int i=0;
		int j=i+1;	
		while(i<j && j<str.length()) {
			if(j-i<k) {
				j++;
			}else if(j-i>k) {
				i++;
			}else {
				System.out.println(str.substring(i,j));
				i++;j++;
			}
		}
	}
	
}
