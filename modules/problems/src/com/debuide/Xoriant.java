package com.debuide;
/* 
 * Save this in a file called Main.java and compile it. To test it 
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

import java.io.*;
import java.util.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */
class Candidate{
	private Integer Candidate_ID;
	private String Name;
	private String Constituency;
	private Integer Votes;
	public Integer getCandidate_ID() {
		return Candidate_ID;
	}
	public void setCandidate_ID(Integer candidate_ID) {
		Candidate_ID = candidate_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getConstituency() {
		return Constituency;
	}
	public void setConstituency(String constituency) {
		Constituency = constituency;
	}
	public Integer getVotes() {
		return Votes;
	}
	public void setVotes(Integer votes) {
		Votes = votes;
	}
	@Override
	public String toString() {
		return "Candidate [Candidate_ID=" + Candidate_ID + ", Name=" + Name + ", Constituency=" + Constituency
				+ ", Votes=" + Votes + "]";
	}
	
}
public class Xoriant {	
	public static Map<String, Integer> processData(ArrayList<String> array) {
		List<Candidate> list = new ArrayList<Candidate>();
		for (int i = 0; i < array.size(); i++) {
			String[] s = array.get(i).split(",");
			Candidate c = new Candidate();
			c.setCandidate_ID(Integer.parseInt(s[0].trim()));
			c.setName(s[1].trim());
			c.setConstituency(s[2].trim());
			c.setVotes(Integer.parseInt(s[3].trim()));
			list.add(c);
		}
		Map<String, Candidate> retVal = new HashMap<String, Candidate>();
		for(Candidate c:list) {
			if(retVal.containsKey(c.getConstituency())) {
				Candidate oldc = retVal.get(c.getConstituency());
				if(oldc.getVotes()<c.getVotes()) {
					retVal.replace(c.getConstituency(), c);
				}
			}else {
				retVal.put(c.getConstituency(), c);
			}
		}
		Map<String,Integer> res = new HashMap<String, Integer>();
		for(Map.Entry<String, Candidate> c :retVal.entrySet()) {
			res.put(c.getKey(),c.getValue().getVotes());
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<String> inputData = new ArrayList<String>();
		String line;
		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
			while (in.hasNextLine())
				inputData.add(in.nextLine());
			Map<String, Integer> retVal = processData(inputData);
			System.out.println(retVal);
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
			for (Map.Entry<String, Integer> e : retVal.entrySet())
				output.println(e.getKey() + ": " + e.getValue());
			output.close();
		} catch (IOException e) {
			System.out.println("IO error in input.txt or output.txt");
		}
	}
}
