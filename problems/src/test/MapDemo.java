package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Employee{
	private Integer empId;
	private String name;
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}
	public Employee(Integer empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	@Override
	public int hashCode() {
		System.out.println("hashcode:"+empId+":"+empId%2);
		
		return empId%2;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;		
		System.out.println("equals:"+this+"->"+obj);
		return true;
	}
	
}


public class MapDemo {
	public static void main(String[] args) {
//		Map<Employee,Integer> map = new HashMap<Employee,Integer>();
//		map.put(new Employee(1, "a"),1);
//		map.put(new Employee(2, "b"),2);
//		map.put(new Employee(3, "c"),3);
//		map.put(new Employee(5, "d"),4);
//		map.put(new Employee(4, "e"),5);
		
//		System.out.println(map.get(new Employee(1, "")));
		
		Set<Employee> set = new HashSet<>();
		System.out.println(set.add(new Employee(1, "")));
		System.out.println(set.add(new Employee(2, "")));
		System.out.println(set.add(new Employee(3, "")));
		System.out.println(set.add(new Employee(1, "c")));
		
		System.out.println(set);
		
		
		
		
	}
	
	
}
