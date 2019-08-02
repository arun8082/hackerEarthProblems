package hackerEarth;

public class PascalPyramid {

	public static void main(String[] args) {
		int n=7;
		int coef=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i-1;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				if(i==0||j==0) {
					coef=1;
				}else {
					coef = coef*(i-j+1)/j;
				}
				System.out.printf("%3d",coef);
			}
			System.out.println();
		}
		
	}

}
