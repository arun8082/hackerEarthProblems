package geeksDataStructure;

import java.time.LocalTime;

public class ConvertTImeIntoWords{
	static String [] nums = { "zero", "one", "two", "three", "four", 
            "five", "six", "seven", "eight", "nine", 
            "ten", "eleven", "twelve", "thirteen", 
            "fourteen", "fifteen", "sixteen", "seventeen", 
            "eighteen", "nineteen", "twenty", "twenty one", 
            "twenty two", "twenty three", "twenty four", 
            "twenty five", "twenty six", "twenty seven", 
            "twenty eight", "twenty nine", 
        }; 
	
	@Override
	protected void finalize() {
		System.err.println("vhhvh");
	}
	
	public static void main(String[] args) {
		LocalTime time = LocalTime.parse("01:31");
		System.out.println(time);
		
		int hours = time.getHour();
		int minutes = time.getMinute();
		
		if(minutes == 0) {
			System.out.println(hours+" O'Clock");
		}else if(minutes == 1) {
			System.out.println("One minutes past "+nums[hours]);
		}else if(minutes == 59) {
			System.out.println("One minutes to "+nums[hours+1]);
		}else if(minutes == 15) {
			System.out.println("Quarter past "+nums[hours]);
		}else if(minutes == 30) {
			System.out.println("Half past "+nums[hours]);
		}else if(minutes == 45) {
			System.out.println("Quarter to "+nums[hours+1]);
		}else if(minutes <=30){
			System.out.println(nums[minutes]+" minutes past to "+nums[hours]);
		}else if (minutes >30) {
			System.out.println(nums[60-minutes]+" minutes to "+nums[hours+1]);
		}
		ConvertTImeIntoWords obj = null;//new ConvertTImeIntoWords();
		obj= null;
		System.gc();
		
	}
	
}
