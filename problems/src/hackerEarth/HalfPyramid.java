package hackerEarth;

public class HalfPyramid {

	public static void main(String[] args) {
		int n=7;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				System.out.print(i);
			}
			for(int k=0;k<i;k++) {
				System.out.print("*");
			} 
			for(int j=0;j<i;j++) {
				System.out.print("#");
			}
			for(int j=0;j<n-i;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(i);
			}
			for(int k=0;k<n-i;k++) {
				if(i!=0) {
					System.out.print("#");
				}
			} 
			for(int j=0;j<n-i;j++) {
				if(i!=0) {
				System.out.print("*");
				}
			}
			for(int j=0;j<i;j++) {
				System.out.print(i);
			}
			if(i!=0) {
				System.out.println();
			}
		}
	}

}
