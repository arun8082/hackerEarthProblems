package Test;

public class Test {

	public static void main(String[] args) {
		int i=2;
		int j=7;
		int d=j-i;
		String s=Integer.toBinaryString(j);
		System.out.println("Base10: "+Integer.parseInt(s, 2));
		System.out.println("d: "+Integer.toBinaryString(d)+" "+(d<<-0));
	}	
}
