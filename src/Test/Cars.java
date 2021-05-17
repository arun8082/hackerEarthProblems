package Test;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cars {
	
	public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String AB = "12 100";//sc.next().trim();
        String [] ar = AB.split(" ");
        System.out.println(max(ar[0],ar[1]));
   }
   static int max(String A,String B){
       String revA = new StringBuffer(A).reverse().toString();
       String revB = new StringBuffer(B).reverse().toString();       
       int a =Integer.parseInt(revA);
       int b=Integer.parseInt(revB);
       return a>b?a:b;
   }
	
    public static void main1(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 1;//sc.nextInt();
        while(T-- > 0){
            String city= "qwerqwyqq";//sc.nextLine().trim();
            System.out.println(countMax(city));
        }
   }
    static Character countMax(String city){
        List<Character> clist = city.chars().mapToObj(c->(char)c).collect(Collectors.toList());
        Map<Character,Long> freq = clist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
         Character res=null;
         Long max = -1l;
         for(Map.Entry<Character,Long> entry:freq.entrySet()){
        	 System.out.println((max == -1) +"<->"+ (max < entry.getValue()));
             if(max == -1 || max < entry.getValue()){
                 res = entry.getKey();
                 max = entry.getValue();
             }
         }
        return res;
    }
}