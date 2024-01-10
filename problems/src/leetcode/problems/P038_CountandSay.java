package leetcode.problems;

public class P038_CountandSay {
	public static String countAndSay(int n) {
		String res= "";
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";
		res="11";
		for(int i=3; i<=n;i++) {
			StringBuilder sb=new StringBuilder("");
			int counter =1;
			res=res+"&";
			for(int j=1; j<res.length();j++) {
				if(res.charAt(j)==res.charAt(j-1)) {
					counter++;					
				}else {
					sb.append(counter).append(res.charAt(j-1));
//					t+=counter +""+ res.charAt(j-1);
					counter=1;
				}
			}
			res=sb.toString();
		}
		return res;

	}

	public static void main(String[] args) {
//		System.out.println(countAndSay(1));
		System.out.println(countAndSay(5));

	}

}
