package leetcode.array;

public class MaximumPossibleValueByAding5 {
	public static void main(String[] args) {
		int []n = {-1259,129,0,7,6948};
//		int []n = {-44};
		
		for (int i = 0; i < n.length; i++) {
			int re = maxNumber2(n[i]);
			System.out.println(re);			
		}
	}

	static int maxNumber2(int n) {
		String s =n+"";		
		int num =Integer.MAX_VALUE;		
		if(n<0) {
			num = Integer.parseInt(s.substring(0,1)+5+s.substring(1));
			for(int i=1;i<=s.length();i++) {
				String tmp=s.substring(0,i)+5+s.substring(i);
				if(num<Integer.parseInt(tmp)) {
					num = Integer.parseInt(tmp);
				}
			}
		}else {
			num = Integer.parseInt(5+s);
			for(int i=0;i<=s.length();i++) {
				String tmp=s.substring(0,i)+5+s.substring(i);
				if(num<Integer.parseInt(tmp)) {
					num = Integer.parseInt(tmp);
				}
			}
		}			
		return num;
	}
	
	static int maxNumber(int n) {
		String num;
		String[] s;
		String res="";
		
		num = n+"";
		s = num.split("");
		
		if(n<0) {
			res = num.substring(0,1)+5+num.substring(1);
		}else if (5 > new Integer(s[0])) {
			res = 5 + num;
		} else if(num.length()==1){
			res = num+5;
		}
		else {
			int pos =Integer.MAX_VALUE;
			for (int i = 1; i < s.length; i++) {
				if (5 < new Integer(s[i])) {
					pos=i;
				}
			}
			res = num.substring(0,pos+1)+5+num.substring(pos+1);
		}
		return Integer.parseInt(res);
	}
}
