package hackerEarth;

public class PrimeNoBetweenTwo {

	public static void main(String[] args) {
		int a=5;
		int b=31;
		while(a<=b) {
			boolean flag=false;
			for(int i=2; i*i<=a;i++) {
				if(a%i==0) {
					flag=true;
					break;
				}
			}
			if(flag==false) {
				System.out.println(a);
			}
			++a;
		}
	}

}
