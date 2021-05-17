package Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class DateRange{
	private LocalDate startDate;
	private LocalDate endDate;
	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
	public DateRange(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "DateRange [startDate=" + startDate.format(df) + ", endDate=" + endDate.format(df) + "]";
	}
	
}

public class MergeDates {

	static boolean isOverlap(DateRange date1, DateRange date2) {
		if(date2.getStartDate().isBefore(date1.getEndDate())) {
			return true;
		}
		return false;
	}
	
	static DateRange mergeDates(DateRange date1, DateRange date2) {
		date1.setEndDate(date2.getEndDate());
		return date1;
	}
	
	public static void main(String[] args) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
		List<DateRange> list = new ArrayList<DateRange>();
		list.add(new DateRange(LocalDate.parse("01 Jan 2014",df), LocalDate.parse("30 Jan 2014",df)));
		list.add(new DateRange(LocalDate.parse("15 Jan 2014",df), LocalDate.parse("15 Feb 2014",df)));
		list.add(new DateRange(LocalDate.parse("10 Mar 2014",df), LocalDate.parse("15 Apr 2014",df)));
		list.add(new DateRange(LocalDate.parse("10 Apr 2014",df), LocalDate.parse("15 May 2014",df)));
		list.add(new DateRange(LocalDate.parse("10 Apr 2014",df), LocalDate.parse("30 May 2014",df)));
		
		List<DateRange> list2 = new ArrayList<DateRange>();
		list.add(new DateRange(LocalDate.parse("01 Jan 2015",df), LocalDate.parse("15 Jan 2015",df)));
		list.add(new DateRange(LocalDate.parse("16 Jan 2015",df), LocalDate.parse("20 Jan 2015",df)));
		list.add(new DateRange(LocalDate.parse("17 Jan 2015",df), LocalDate.parse("25 Jan 2015",df)));
		list.add(new DateRange(LocalDate.parse("26 Jan 2015",df), LocalDate.parse("30 Mar 2015",df)));
		
		List<DateRange> finalList = new ArrayList<DateRange>();		
		
		for (int i = 0; i < list.size()-1; i=i+2) {
			DateRange date1=list.get(i);
			DateRange date2=list.get(i+1);
			DateRange res= null;
			if (isOverlap(date1, date2)) {
				res=mergeDates(date1, date2);
				finalList.add(res);
			}else {
				finalList.add(date1);
				finalList.add(date2);
			}
		}
		if(list.size()%2!=0) {
			finalList.add(list.get(list.size()-1));
		}
		finalList.stream().forEach(System.out::println);
	}
}
